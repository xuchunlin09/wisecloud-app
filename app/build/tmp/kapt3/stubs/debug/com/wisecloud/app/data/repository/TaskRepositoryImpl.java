package com.wisecloud.app.data.repository;

import com.wisecloud.app.data.api.MdmApiService;
import com.wisecloud.app.data.model.request.*;
import com.wisecloud.app.data.model.response.TaskCreateResponse;
import com.wisecloud.app.data.model.response.TaskDetailResponse;
import com.wisecloud.app.data.model.response.TaskSummary;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\rH\u0096@\u00a2\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u0010H\u0096@\u00a2\u0006\u0002\u0010\u0011J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u0013H\u0096@\u00a2\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u0016H\u0096@\u00a2\u0006\u0002\u0010\u0017J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u0019H\u0096@\u00a2\u0006\u0002\u0010\u001aJ.\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020 H\u0096@\u00a2\u0006\u0002\u0010\"J.\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$0\u00072\b\u0010&\u001a\u0004\u0018\u00010\u001e2\b\u0010\'\u001a\u0004\u0018\u00010\u001eH\u0096@\u00a2\u0006\u0002\u0010(R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/wisecloud/app/data/repository/TaskRepositoryImpl;", "Lcom/wisecloud/app/data/repository/BaseRepository;", "Lcom/wisecloud/app/data/repository/TaskRepository;", "apiService", "Lcom/wisecloud/app/data/api/MdmApiService;", "(Lcom/wisecloud/app/data/api/MdmApiService;)V", "createFilePushTask", "Lcom/wisecloud/app/data/repository/Result;", "Lcom/wisecloud/app/data/model/response/TaskCreateResponse;", "request", "Lcom/wisecloud/app/data/model/request/FilePushRequest;", "(Lcom/wisecloud/app/data/model/request/FilePushRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createInstallTask", "Lcom/wisecloud/app/data/model/request/InstallTaskRequest;", "(Lcom/wisecloud/app/data/model/request/InstallTaskRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createInstructionTask", "Lcom/wisecloud/app/data/model/request/InstructionTaskRequest;", "(Lcom/wisecloud/app/data/model/request/InstructionTaskRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createOtaTask", "Lcom/wisecloud/app/data/model/request/OtaTaskRequest;", "(Lcom/wisecloud/app/data/model/request/OtaTaskRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createUninstallTask", "Lcom/wisecloud/app/data/model/request/UninstallTaskRequest;", "(Lcom/wisecloud/app/data/model/request/UninstallTaskRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createWiseOSSettingTask", "Lcom/wisecloud/app/data/model/request/WiseOSSettingRequest;", "(Lcom/wisecloud/app/data/model/request/WiseOSSettingRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTaskDetails", "Lcom/wisecloud/app/data/model/response/TaskDetailResponse;", "traceId", "", "status", "", "page", "(Ljava/lang/String;Ljava/lang/Integer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTaskList", "", "Lcom/wisecloud/app/data/model/response/TaskSummary;", "type", "keyword", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class TaskRepositoryImpl extends com.wisecloud.app.data.repository.BaseRepository implements com.wisecloud.app.data.repository.TaskRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.wisecloud.app.data.api.MdmApiService apiService = null;
    
    @javax.inject.Inject()
    public TaskRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.api.MdmApiService apiService) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object createInstallTask(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.model.request.InstallTaskRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.repository.Result<com.wisecloud.app.data.model.response.TaskCreateResponse>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object createUninstallTask(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.model.request.UninstallTaskRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.repository.Result<com.wisecloud.app.data.model.response.TaskCreateResponse>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object createOtaTask(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.model.request.OtaTaskRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.repository.Result<com.wisecloud.app.data.model.response.TaskCreateResponse>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object createInstructionTask(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.model.request.InstructionTaskRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.repository.Result<com.wisecloud.app.data.model.response.TaskCreateResponse>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object createWiseOSSettingTask(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.model.request.WiseOSSettingRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.repository.Result<com.wisecloud.app.data.model.response.TaskCreateResponse>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object createFilePushTask(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.model.request.FilePushRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.repository.Result<com.wisecloud.app.data.model.response.TaskCreateResponse>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getTaskList(@org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String keyword, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.repository.Result<? extends java.util.List<com.wisecloud.app.data.model.response.TaskSummary>>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getTaskDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String traceId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer status, int page, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.repository.Result<com.wisecloud.app.data.model.response.TaskDetailResponse>> $completion) {
        return null;
    }
}