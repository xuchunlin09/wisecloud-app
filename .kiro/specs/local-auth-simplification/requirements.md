# 需求文档 — 本地认证简化

## 简介

将 WiseCloud MDM Android 客户端的登录界面从当前的邮箱 + 密码 + 验证码（邮件/MFA）多步认证流程，简化为仅用户名 + 密码的登录方式，并新增用户注册功能。同时将 API 基础地址从远程服务 `https://api.wisecloud.com/` 切换到本地 Spring Boot 后端 `http://localhost:8080`。后端 API 已在 `wisecloud-device-management` 设计文档中定义完毕。

## 术语表

- **MDM_App**: WiseCloud MDM Android 客户端应用
- **Local_Backend**: 运行在 `http://localhost:8080` 的 Spring Boot 后端服务
- **Login_Screen**: 用户登录界面（LoginFragment + 对应布局）
- **Register_Screen**: 用户注册界面（新增 RegisterFragment + 对应布局）
- **Auth_Repository**: 认证数据仓库层，负责调用 API 并管理 Token
- **Api_Service**: Retrofit 接口定义层（MdmApiService）
- **Network_Module**: Hilt 依赖注入中的网络配置模块
- **Token_Manager**: 本地 SharedPreferences Token 存储管理器
- **LoginRequest**: 登录请求数据模型，包含 username 和 password 字段
- **RegisterRequest**: 注册请求数据模型，包含 username 和 password 字段
- **LoginResponse**: 登录响应数据模型，包含 token 和 expiresIn 字段
- **Nav_Graph**: Jetpack Navigation 导航图

## 需求

### 需求 1：API 基础地址切换

**用户故事：** 作为开发者，我希望将 API 基础地址切换到本地后端服务，以便在本地开发环境中进行调试和测试。

#### 验收标准

1. THE Network_Module SHALL 将 BASE_URL 配置为 `http://localhost:8080/`
2. WHEN MDM_App 发起任何 API 请求时，THE Api_Service SHALL 将请求发送到 Local_Backend 地址

### 需求 2：简化登录请求模型

**用户故事：** 作为用户，我希望仅使用用户名和密码登录，无需验证码或 MFA，以便简化登录流程。

#### 验收标准

1. THE LoginRequest SHALL 仅包含 username（字符串）和 password（字符串）两个字段
2. THE Api_Service SHALL 通过 `POST /api/auth/login` 端点发送 LoginRequest 到 Local_Backend
3. WHEN Local_Backend 返回成功响应时，THE LoginResponse SHALL 包含 token（字符串）和 expiresIn（长整型）字段
4. WHEN 登录成功时，THE Auth_Repository SHALL 将 token 保存到 Token_Manager

### 需求 3：简化登录界面

**用户故事：** 作为用户，我希望看到一个简洁的登录界面，只需输入用户名和密码即可登录。

#### 验收标准

1. THE Login_Screen SHALL 显示用户名输入框、密码输入框和登录按钮
2. THE Login_Screen SHALL 移除邮箱验证码输入区域、MFA 输入区域和验证方式切换按钮
3. THE Login_Screen SHALL 保留记住密码复选框功能
4. THE Login_Screen SHALL 显示一个"去注册"链接，用于导航到 Register_Screen
5. WHEN 用户点击登录按钮时，THE Login_Screen SHALL 使用用户名和密码字段发起登录请求
6. WHILE 登录请求正在处理中，THE Login_Screen SHALL 显示加载指示器并禁用登录按钮
7. WHEN 登录成功时，THE Login_Screen SHALL 导航到 Dashboard 页面
8. IF 登录失败，THEN THE Login_Screen SHALL 显示错误提示信息
9. IF 网络连接失败，THEN THE Login_Screen SHALL 显示网络错误提示

### 需求 4：新增注册功能

**用户故事：** 作为新用户，我希望能够注册账号，以便使用 MDM 系统。

#### 验收标准

1. THE Register_Screen SHALL 显示用户名输入框、密码输入框、确认密码输入框和注册按钮
2. THE Register_Screen SHALL 显示一个"返回登录"链接，用于导航回 Login_Screen
3. THE RegisterRequest SHALL 包含 username（字符串）和 password（字符串）两个字段
4. THE Api_Service SHALL 通过 `POST /api/auth/register` 端点发送 RegisterRequest 到 Local_Backend
5. WHEN 用户点击注册按钮且密码与确认密码不一致时，THE Register_Screen SHALL 显示"两次密码输入不一致"错误提示，且不发起网络请求
6. WHEN 用户点击注册按钮且所有输入合法时，THE Register_Screen SHALL 发起注册请求
7. WHILE 注册请求正在处理中，THE Register_Screen SHALL 显示加载指示器并禁用注册按钮
8. WHEN 注册成功时，THE Register_Screen SHALL 显示成功提示并导航回 Login_Screen
9. IF Local_Backend 返回 409 状态码，THEN THE Register_Screen SHALL 显示"用户名已存在"错误提示
10. IF Local_Backend 返回 400 状态码（密码长度不足），THEN THE Register_Screen SHALL 显示"密码长度不足"错误提示
11. IF 网络连接失败，THEN THE Register_Screen SHALL 显示网络错误提示

### 需求 5：导航图更新

**用户故事：** 作为用户，我希望能够在登录页面和注册页面之间自由切换。

#### 验收标准

1. THE Nav_Graph SHALL 包含 Register_Screen 作为导航目的地
2. THE Nav_Graph SHALL 定义从 Login_Screen 到 Register_Screen 的导航动作
3. THE Nav_Graph SHALL 定义从 Register_Screen 到 Login_Screen 的导航动作
4. THE Nav_Graph SHALL 保持 Login_Screen 作为起始目的地

### 需求 6：移除旧认证逻辑

**用户故事：** 作为开发者，我希望移除不再使用的验证码和 MFA 相关代码，以保持代码整洁。

#### 验收标准

1. THE LoginViewModel SHALL 移除验证码发送逻辑（sendVerificationCode 方法）
2. THE LoginViewModel SHALL 移除验证方式切换逻辑（switchVerifyMethod 方法、VerifyMethod 枚举）
3. THE LoginViewModel SHALL 移除倒计时逻辑（countdownSeconds LiveData）
4. THE Auth_Repository SHALL 移除 sendCode 方法
5. THE Api_Service SHALL 移除 sendVerificationCode 端点定义
6. THE LoginViewModel SHALL 使用 username 替代 email 进行登录调用
