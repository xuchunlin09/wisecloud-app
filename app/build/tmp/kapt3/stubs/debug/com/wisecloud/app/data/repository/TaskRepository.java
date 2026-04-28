package com.wisecloud.app.data.repository;

import com.wisecloud.app.data.api.MdmApiService;
import com.wisecloud.app.data.model.request.*;
import com.wisecloud.app.data.model.response.TaskCreateResponse;
import com.wisecloud.app.data.model.response.TaskDetailResponse;
import com.wisecloud.app.data.model.response.TaskSummary;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00a2\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\tH\u00a6@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\fH\u00a6@\u00a2\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u000fH\u00a6@\u00a2\u0006\u0002\u0010\u0010J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0012H\u00a6@\u00a2\u0006\u0002\u0010\u0013J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0015H\u00a6@\u00a2\u0006\u0002\u0010\u0016J2\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001cH\u00a6@\u00a2\u0006\u0002\u0010\u001eJ2\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001aH\u00a6@\u00a2\u0006\u0002\u0010$\u00a8\u0006%"}, d2 = {"Lcom/wisecloud/app/data/repository/TaskRepository;", "", "createFilePushTask", "Lcom/wisecloud/app/data/repository/Result;", "Lcom/wisecloud/app/data/model/response/TaskCreateResponse;", "request", "Lcom/wisecloud/app/data/model/request/FilePushRequest;", "(Lcom/wisecloud/app/data/model/request/FilePushRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createInstallTask", "Lcom/wisecloud/app/data/model/request/InstallTaskRequest;", "(Lcom/wisecloud/app/data/model/request/InstallTaskRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createInstructionTask", "Lcom/wisecloud/app/data/model/request/InstructionTaskRequest;", "(Lcom/wisecloud/app/data/model/request/InstructionTaskRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createOtaTask", "Lcom/wisecloud/app/data/model/request/OtaTaskRequest;", "(Lcom/wisecloud/app/data/model/request/OtaTaskRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createUninstallTask", "Lcom/wisecloud/app/data/model/request/UninstallTaskRequest;", "(Lcom/wisecloud/app/data/model/request/UninstallTaskRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createWiseOSSettingTask", "Lcom/wisecloud/app/data/model/request/WiseOSSettingRequest;", "(Lcom/wisecloud/app/data/model/request/WiseOSSettingRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTaskDetails", "Lcom/wisecloud/app/data/model/response/TaskDetailResponse;", "traceId", "", "status", "", "page", "(Ljava/lang/String;Ljava/lang/Integer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTaskList", "", "Lcom/wisecloud/app/data/model/response/TaskSummary;", "type", "keyword", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface TaskRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createInstallTask(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.model.request.InstallTaskRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.repository.Result<com.wisecloud.app.data.model.response.TaskCreateResponse>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createUninstallTask(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.model.request.UninstallTaskRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.repository.Result<com.wisecloud.app.data.model.response.TaskCreateResponse>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createOtaTask(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.model.request.OtaTaskRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.repository.Result<com.wisecloud.app.data.model.response.TaskCreateResponse>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createInstructionTask(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.model.request.InstructionTaskRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.repository.Result<com.wisecloud.app.data.model.response.TaskCreateResponse>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createWiseOSSettingTask(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.model.request.WiseOSSettingRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.repository.Result<com.wisecloud.app.data.model.response.TaskCreateResponse>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createFilePushTask(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.model.request.FilePushRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.repository.Result<com.wisecloud.app.data.model.response.TaskCreateResponse>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTaskList(@org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String keyword, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.repository.Result<? extends java.util.List<com.wisecloud.app.data.model.response.TaskSummary>>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTaskDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String traceId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer status, int page, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.repository.Result<com.wisecloud.app.data.model.response.TaskDetailResponse>> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}