# 实施计划：本地认证简化

## 概述

将 WiseCloud MDM Android 客户端的认证流程从邮箱 + 密码 + 验证码简化为用户名 + 密码，新增注册功能，并将 API 基础地址切换到本地后端。按数据层 → 业务层 → UI 层的顺序逐步实施，确保每一步都可编译运行。

## Tasks

- [x] 1. 修改数据层：请求模型、API 接口、Repository
  - [x] 1.1 简化 RequestModels 和 MdmApiService
    - 修改 `RequestModels.kt`：将 `LoginRequest` 字段改为 `username` + `password`，新增 `RegisterRequest(username, password)`，移除 `SendCodeRequest`
    - 修改 `MdmApiService.kt`：移除 `sendVerificationCode` 端点，新增 `register` 端点 `POST api/auth/register`
    - _Requirements: 2.1, 2.2, 4.3, 4.4, 6.5_

  - [x] 1.2 简化 AuthRepository
    - 修改 `AuthRepository.kt` 接口：`login` 方法签名改为 `(username, password)`，新增 `register(username, password): Result<Unit>`，移除 `sendCode` 方法
    - 修改 `AuthRepositoryImpl`：实现简化后的 `login`（使用新 `LoginRequest`），实现 `register`（使用 `safeApiCallUnit`），登录成功后保存 token
    - _Requirements: 2.2, 2.4, 4.4, 6.4_

  - [x] 1.3 修改 TokenManager 凭证存储
    - 将 `saveCredentials` / `getSavedCredentials` 中的 `email` 参数和 `KEY_EMAIL` 改为 `username` / `KEY_USERNAME`
    - _Requirements: 3.3_

  - [x] 1.4 切换 NetworkModule BASE_URL
    - 将 `NetworkModule.kt` 中 `BASE_URL` 从 `https://api.wisecloud.com/` 改为 `http://localhost:8080/`
    - _Requirements: 1.1, 1.2_

- [x] 2. 修改业务层：ViewModel 和输入校验
  - [x] 2.1 简化 LoginViewModel
    - 移除 `VerifyMethod` 枚举、`countdownSeconds` LiveData、`verifyMethod` LiveData、`sendVerificationCode()` 方法、`switchVerifyMethod()` 方法、`startCountdown()` 方法
    - `login()` 方法签名改为 `(username, password)`，使用 `InputValidator.isValidUsername` 校验，移除验证码/MFA 校验逻辑
    - `savedEmail` LiveData 改为 `savedUsername`，`saveCredentials` / `loadSavedCredentials` 改用 username
    - _Requirements: 3.5, 6.1, 6.2, 6.3, 6.6_

  - [x] 2.2 新增 InputValidator.isValidUsername 方法
    - 在 `InputValidator` 中新增 `isValidUsername(username: String): Boolean = username.trim().isNotEmpty()`
    - _Requirements: 3.5, 4.6_

  - [x] 2.3 新增 RegisterViewModel
    - 创建 `RegisterViewModel.kt`，包含 `registerState: LiveData<RegisterUiState>` 和 `register(username, password, confirmPassword)` 方法
    - 实现客户端校验：用户名非空、密码长度 ≥ 8、密码与确认密码一致
    - 校验通过后调用 `authRepository.register(username, password)`
    - 定义 `RegisterUiState` sealed class（Idle, Loading, Success, Error, NetworkError）
    - _Requirements: 4.1, 4.5, 4.6, 4.7, 4.8, 4.9, 4.10, 4.11_

- [x] 3. 检查点 - 确保数据层和业务层编译通过
  - 确保所有代码编译通过，ask the user if questions arise.

- [x] 4. 修改 UI 层：登录界面简化
  - [x] 4.1 简化 fragment_login.xml 布局
    - 将 `tilEmail` / `etEmail` 改为 `tilUsername` / `etUsername`（hint 改为用户名）
    - 移除 `layoutEmailVerify`（验证码区域）、`layoutMfa`（MFA 区域）、`btnSwitchMethod`（切换验证方式按钮）
    - 新增 `btnGoRegister`（"去注册"文字按钮）
    - _Requirements: 3.1, 3.2, 3.4_

  - [x] 4.2 简化 LoginFragment
    - 移除验证码/MFA 相关监听和 UI 逻辑（`btnGetCode`、`btnSwitchMethod`、`countdownSeconds` observer、`verifyMethod` observer）
    - `performLogin()` 改为读取 username + password，调用 `viewModel.login(username, password)`
    - `savedEmail` observer 改为 `savedUsername`
    - 新增 `btnGoRegister` 点击事件，导航到 RegisterFragment
    - _Requirements: 3.1, 3.2, 3.4, 3.5, 3.6, 3.7, 3.8, 3.9_

- [x] 5. 新增 UI 层：注册界面
  - [x] 5.1 创建 fragment_register.xml 布局
    - 包含用户名输入框、密码输入框、确认密码输入框、注册按钮、"返回登录"文字按钮、加载指示器
    - _Requirements: 4.1, 4.2_

  - [x] 5.2 创建 RegisterFragment
    - 实现注册表单交互：点击注册按钮调用 `viewModel.register(username, password, confirmPassword)`
    - 观察 `registerState`：Loading 时显示加载指示器并禁用按钮，Success 时提示并导航回登录页，Error 时显示错误 Snackbar，NetworkError 时显示网络错误
    - 点击"返回登录"导航回 LoginFragment
    - _Requirements: 4.1, 4.2, 4.5, 4.6, 4.7, 4.8, 4.9, 4.10, 4.11_

- [x] 6. 更新导航图
  - 在 `nav_graph.xml` 中新增 `registerFragment` 目的地
  - 在 `loginFragment` 中新增 `action_loginFragment_to_registerFragment` 导航动作
  - 在 `registerFragment` 中新增 `action_registerFragment_to_loginFragment` 导航动作
  - 保持 `loginFragment` 为起始目的地
  - _Requirements: 5.1, 5.2, 5.3, 5.4_

- [x] 7. 检查点 - 确保全部编译通过且 UI 可运行
  - 确保所有代码编译通过，ask the user if questions arise.

- [ ]* 8. 属性测试（Property-Based Tests）
  - [ ]* 8.1 配置 Kotest 属性测试依赖
    - 在 `build.gradle.kts` 中添加 `kotest-property-jvm` 和 `kotest-assertions-core-jvm` 测试依赖

  - [ ]* 8.2 编写属性测试：LoginResponse 序列化往返一致性
    - **Property 1: LoginResponse 序列化往返一致性**
    - **Validates: Requirements 2.3**

  - [ ]* 8.3 编写属性测试：登录成功后 Token 持久化
    - **Property 2: 登录成功后 Token 持久化**
    - **Validates: Requirements 2.4**

  - [ ]* 8.4 编写属性测试：登录请求字段透传
    - **Property 3: 登录请求字段透传**
    - **Validates: Requirements 3.5, 6.6**

  - [ ]* 8.5 编写属性测试：错误信息透传显示
    - **Property 4: 错误信息透传显示**
    - **Validates: Requirements 3.8**

  - [ ]* 8.6 编写属性测试：密码不一致时客户端拒绝注册
    - **Property 5: 密码不一致时客户端拒绝注册**
    - **Validates: Requirements 4.5**

  - [ ]* 8.7 编写属性测试：合法输入触发注册请求
    - **Property 6: 合法输入触发注册请求**
    - **Validates: Requirements 4.6**

- [ ]* 9. 单元测试
  - [ ]* 9.1 编写 LoginViewModel 单元测试
    - 测试简化后的 login 方法正确调用 AuthRepository，验证状态转换（Idle → Loading → Success/Error/NetworkError）
    - _Requirements: 3.5, 3.6, 3.7, 3.8, 3.9_

  - [ ]* 9.2 编写 RegisterViewModel 单元测试
    - 测试注册流程各状态转换，测试密码不一致拒绝、用户名为空拒绝、密码长度不足拒绝
    - _Requirements: 4.5, 4.6, 4.7, 4.8, 4.9, 4.10, 4.11_

  - [ ]* 9.3 编写 AuthRepository 单元测试
    - 测试 login/register 方法正确调用 MdmApiService 并处理响应，验证 token 保存逻辑
    - _Requirements: 2.2, 2.4, 4.4_

- [x] 10. 最终检查点 - 确保所有测试通过
  - 确保所有测试通过，ask the user if questions arise.

## Notes

- 标记 `*` 的任务为可选任务，可跳过以加快 MVP 进度
- 每个任务引用了具体的需求编号以确保可追溯性
- 检查点确保增量验证，避免问题累积
- 属性测试验证设计文档中定义的 6 个正确性属性
- 实施语言：Kotlin，技术栈：Retrofit + Hilt + Jetpack Navigation + MVVM
