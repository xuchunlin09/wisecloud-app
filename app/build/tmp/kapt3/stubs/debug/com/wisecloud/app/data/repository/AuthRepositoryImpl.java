package com.wisecloud.app.data.repository;

import com.wisecloud.app.data.api.MdmApiService;
import com.wisecloud.app.data.local.TokenManager;
import com.wisecloud.app.data.model.request.LoginRequest;
import com.wisecloud.app.data.model.request.RegisterRequest;
import com.wisecloud.app.data.model.response.LoginResponse;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/wisecloud/app/data/repository/AuthRepositoryImpl;", "Lcom/wisecloud/app/data/repository/BaseRepository;", "Lcom/wisecloud/app/data/repository/AuthRepository;", "apiService", "Lcom/wisecloud/app/data/api/MdmApiService;", "tokenManager", "Lcom/wisecloud/app/data/local/TokenManager;", "(Lcom/wisecloud/app/data/api/MdmApiService;Lcom/wisecloud/app/data/local/TokenManager;)V", "login", "Lcom/wisecloud/app/data/repository/Result;", "Lcom/wisecloud/app/data/model/response/LoginResponse;", "username", "", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "", "register", "app_debug"})
public final class AuthRepositoryImpl extends com.wisecloud.app.data.repository.BaseRepository implements com.wisecloud.app.data.repository.AuthRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.wisecloud.app.data.api.MdmApiService apiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.wisecloud.app.data.local.TokenManager tokenManager = null;
    
    @javax.inject.Inject()
    public AuthRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.api.MdmApiService apiService, @org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.local.TokenManager tokenManager) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object login(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.repository.Result<com.wisecloud.app.data.model.response.LoginResponse>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object register(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.repository.Result<kotlin.Unit>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    public void logout() {
    }
}