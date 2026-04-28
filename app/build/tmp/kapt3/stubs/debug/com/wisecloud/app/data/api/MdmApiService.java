package com.wisecloud.app.data.api;

import com.wisecloud.app.data.model.request.*;
import com.wisecloud.app.data.model.response.*;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u00b2\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010\u0016J\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u001aJ\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00032\b\b\u0001\u0010\u001d\u001a\u00020\u001eH\u00a7@\u00a2\u0006\u0002\u0010\u001fJ:\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0\u00032\b\b\u0001\u0010#\u001a\u00020$2\b\b\u0003\u0010%\u001a\u00020$2\n\b\u0003\u0010&\u001a\u0004\u0018\u00010$H\u00a7@\u00a2\u0006\u0002\u0010\'J\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u001aJ>\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00032\b\b\u0001\u0010,\u001a\u00020\u001e2\n\b\u0003\u0010&\u001a\u0004\u0018\u00010$2\b\b\u0003\u0010#\u001a\u00020$2\b\b\u0003\u0010%\u001a\u00020$H\u00a7@\u00a2\u0006\u0002\u0010-J2\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0\u00180\u00032\n\b\u0003\u00100\u001a\u0004\u0018\u00010\u001e2\n\b\u0003\u00101\u001a\u0004\u0018\u00010\u001eH\u00a7@\u00a2\u0006\u0002\u00102J\u001e\u00103\u001a\b\u0012\u0004\u0012\u0002040\u00032\b\b\u0001\u0010\u0005\u001a\u000205H\u00a7@\u00a2\u0006\u0002\u00106J$\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00180\u00032\b\b\u0001\u00101\u001a\u00020\u001eH\u00a7@\u00a2\u0006\u0002\u0010\u001fJ\u001e\u00108\u001a\b\u0012\u0004\u0012\u0002090\u00032\b\b\u0001\u0010\u0005\u001a\u00020:H\u00a7@\u00a2\u0006\u0002\u0010;J4\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u00032\b\b\u0001\u0010>\u001a\u00020?2\b\b\u0001\u0010@\u001a\u00020A2\n\b\u0001\u0010B\u001a\u0004\u0018\u00010AH\u00a7@\u00a2\u0006\u0002\u0010C\u00a8\u0006D"}, d2 = {"Lcom/wisecloud/app/data/api/MdmApiService;", "", "createFilePushTask", "Lcom/wisecloud/app/data/model/response/ApiResponse;", "Lcom/wisecloud/app/data/model/response/TaskCreateResponse;", "request", "Lcom/wisecloud/app/data/model/request/FilePushRequest;", "(Lcom/wisecloud/app/data/model/request/FilePushRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createInstallTask", "Lcom/wisecloud/app/data/model/request/InstallTaskRequest;", "(Lcom/wisecloud/app/data/model/request/InstallTaskRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createInstructionTask", "Lcom/wisecloud/app/data/model/request/InstructionTaskRequest;", "(Lcom/wisecloud/app/data/model/request/InstructionTaskRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createOtaTask", "Lcom/wisecloud/app/data/model/request/OtaTaskRequest;", "(Lcom/wisecloud/app/data/model/request/OtaTaskRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createUninstallTask", "Lcom/wisecloud/app/data/model/request/UninstallTaskRequest;", "(Lcom/wisecloud/app/data/model/request/UninstallTaskRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createWiseOSSettingTask", "Lcom/wisecloud/app/data/model/request/WiseOSSettingRequest;", "(Lcom/wisecloud/app/data/model/request/WiseOSSettingRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getApplicationList", "", "Lcom/wisecloud/app/data/model/response/ApplicationInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDeviceDetail", "Lcom/wisecloud/app/data/model/response/DeviceDetailResponse;", "sn", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDeviceList", "Lcom/wisecloud/app/data/model/response/PagedResponse;", "Lcom/wisecloud/app/data/model/response/DeviceSummary;", "page", "", "size", "status", "(IILjava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDeviceOverview", "Lcom/wisecloud/app/data/model/response/DeviceOverviewResponse;", "getTaskDetails", "Lcom/wisecloud/app/data/model/response/TaskDetailResponse;", "traceId", "(Ljava/lang/String;Ljava/lang/Integer;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTaskList", "Lcom/wisecloud/app/data/model/response/TaskSummary;", "type", "keyword", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "Lcom/wisecloud/app/data/model/response/LoginResponse;", "Lcom/wisecloud/app/data/model/request/LoginRequest;", "(Lcom/wisecloud/app/data/model/request/LoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchDevices", "sendVerificationCode", "", "Lcom/wisecloud/app/data/model/request/SendCodeRequest;", "(Lcom/wisecloud/app/data/model/request/SendCodeRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadApk", "Lcom/wisecloud/app/data/model/response/AppUploadResponse;", "file", "Lokhttp3/MultipartBody$Part;", "appAlias", "Lokhttp3/RequestBody;", "appDescription", "(Lokhttp3/MultipartBody$Part;Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface MdmApiService {
    
    @retrofit2.http.POST(value = "api/auth/login")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object login(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.model.request.LoginRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.model.response.ApiResponse<com.wisecloud.app.data.model.response.LoginResponse>> $completion);
    
    @retrofit2.http.POST(value = "api/auth/send-code")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object sendVerificationCode(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.model.request.SendCodeRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.model.response.ApiResponse<kotlin.Unit>> $completion);
    
    @retrofit2.http.GET(value = "api/devices/overview")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getDeviceOverview(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.model.response.ApiResponse<com.wisecloud.app.data.model.response.DeviceOverviewResponse>> $completion);
    
    @retrofit2.http.GET(value = "api/devices/search")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object searchDevices(@retrofit2.http.Query(value = "keyword")
    @org.jetbrains.annotations.NotNull()
    java.lang.String keyword, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.model.response.ApiResponse<java.util.List<com.wisecloud.app.data.model.response.DeviceSummary>>> $completion);
    
    @retrofit2.http.GET(value = "api/devices")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getDeviceList(@retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "size")
    int size, @retrofit2.http.Query(value = "status")
    @org.jetbrains.annotations.Nullable()
    java.lang.Integer status, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.model.response.ApiResponse<com.wisecloud.app.data.model.response.PagedResponse<com.wisecloud.app.data.model.response.DeviceSummary>>> $completion);
    
    @retrofit2.http.GET(value = "api/devices/{sn}/detail")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getDeviceDetail(@retrofit2.http.Path(value = "sn")
    @org.jetbrains.annotations.NotNull()
    java.lang.String sn, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.model.response.ApiResponse<com.wisecloud.app.data.model.response.DeviceDetailResponse>> $completion);
    
    @retrofit2.http.GET(value = "api/applications")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getApplicationList(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.model.response.ApiResponse<java.util.List<com.wisecloud.app.data.model.response.ApplicationInfo>>> $completion);
    
    @retrofit2.http.Multipart()
    @retrofit2.http.POST(value = "api/applications/upload")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object uploadApk(@retrofit2.http.Part()
    @org.jetbrains.annotations.NotNull()
    okhttp3.MultipartBody.Part file, @retrofit2.http.Part(value = "appAlias")
    @org.jetbrains.annotations.NotNull()
    okhttp3.RequestBody appAlias, @retrofit2.http.Part(value = "appDescription")
    @org.jetbrains.annotations.Nullable()
    okhttp3.RequestBody appDescription, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.model.response.ApiResponse<com.wisecloud.app.data.model.response.AppUploadResponse>> $completion);
    
    @retrofit2.http.POST(value = "api/tasks/install")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createInstallTask(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.model.request.InstallTaskRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.model.response.ApiResponse<com.wisecloud.app.data.model.response.TaskCreateResponse>> $completion);
    
    @retrofit2.http.POST(value = "api/tasks/uninstall")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createUninstallTask(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.model.request.UninstallTaskRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.model.response.ApiResponse<com.wisecloud.app.data.model.response.TaskCreateResponse>> $completion);
    
    @retrofit2.http.POST(value = "api/tasks/ota")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createOtaTask(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.model.request.OtaTaskRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.model.response.ApiResponse<com.wisecloud.app.data.model.response.TaskCreateResponse>> $completion);
    
    @retrofit2.http.POST(value = "api/tasks/instruction")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createInstructionTask(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.model.request.InstructionTaskRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.model.response.ApiResponse<com.wisecloud.app.data.model.response.TaskCreateResponse>> $completion);
    
    @retrofit2.http.POST(value = "api/tasks/wiseos-setting")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createWiseOSSettingTask(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.model.request.WiseOSSettingRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.model.response.ApiResponse<com.wisecloud.app.data.model.response.TaskCreateResponse>> $completion);
    
    @retrofit2.http.POST(value = "api/tasks/file-push")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createFilePushTask(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.model.request.FilePushRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.model.response.ApiResponse<com.wisecloud.app.data.model.response.TaskCreateResponse>> $completion);
    
    @retrofit2.http.GET(value = "api/tasks")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTaskList(@retrofit2.http.Query(value = "type")
    @org.jetbrains.annotations.Nullable()
    java.lang.String type, @retrofit2.http.Query(value = "keyword")
    @org.jetbrains.annotations.Nullable()
    java.lang.String keyword, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.model.response.ApiResponse<java.util.List<com.wisecloud.app.data.model.response.TaskSummary>>> $completion);
    
    @retrofit2.http.GET(value = "api/tasks/{traceId}/details")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTaskDetails(@retrofit2.http.Path(value = "traceId")
    @org.jetbrains.annotations.NotNull()
    java.lang.String traceId, @retrofit2.http.Query(value = "status")
    @org.jetbrains.annotations.Nullable()
    java.lang.Integer status, @retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "size")
    int size, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.model.response.ApiResponse<com.wisecloud.app.data.model.response.TaskDetailResponse>> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}