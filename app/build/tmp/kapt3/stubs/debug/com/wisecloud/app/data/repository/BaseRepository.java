package com.wisecloud.app.data.repository;

import com.wisecloud.app.data.model.response.ApiResponse;
import retrofit2.HttpException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J>\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007H\u0084@\u00a2\u0006\u0002\u0010\nJ8\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007H\u0084@\u00a2\u0006\u0002\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/wisecloud/app/data/repository/BaseRepository;", "", "()V", "safeApiCall", "Lcom/wisecloud/app/data/repository/Result;", "T", "apiCall", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lcom/wisecloud/app/data/model/response/ApiResponse;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "safeApiCallUnit", "", "app_debug"})
public abstract class BaseRepository {
    
    public BaseRepository() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final <T extends java.lang.Object>java.lang.Object safeApiCall(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super com.wisecloud.app.data.model.response.ApiResponse<T>>, ? extends java.lang.Object> apiCall, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.repository.Result<? extends T>> $completion) {
        return null;
    }
    
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    @org.jetbrains.annotations.Nullable()
    protected final java.lang.Object safeApiCallUnit(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super com.wisecloud.app.data.model.response.ApiResponse<kotlin.Unit>>, ? extends java.lang.Object> apiCall, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.repository.Result<kotlin.Unit>> $completion) {
        return null;
    }
}