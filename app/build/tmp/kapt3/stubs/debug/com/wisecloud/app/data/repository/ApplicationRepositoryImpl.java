package com.wisecloud.app.data.repository;

import com.wisecloud.app.data.api.MdmApiService;
import com.wisecloud.app.data.model.response.ApplicationInfo;
import com.wisecloud.app.data.model.response.AppUploadResponse;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0096@\u00a2\u0006\u0002\u0010\nJ.\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0096@\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/wisecloud/app/data/repository/ApplicationRepositoryImpl;", "Lcom/wisecloud/app/data/repository/BaseRepository;", "Lcom/wisecloud/app/data/repository/ApplicationRepository;", "apiService", "Lcom/wisecloud/app/data/api/MdmApiService;", "(Lcom/wisecloud/app/data/api/MdmApiService;)V", "getApplicationList", "Lcom/wisecloud/app/data/repository/Result;", "", "Lcom/wisecloud/app/data/model/response/ApplicationInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadApk", "Lcom/wisecloud/app/data/model/response/AppUploadResponse;", "file", "Lokhttp3/MultipartBody$Part;", "appAlias", "Lokhttp3/RequestBody;", "appDescription", "(Lokhttp3/MultipartBody$Part;Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class ApplicationRepositoryImpl extends com.wisecloud.app.data.repository.BaseRepository implements com.wisecloud.app.data.repository.ApplicationRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.wisecloud.app.data.api.MdmApiService apiService = null;
    
    @javax.inject.Inject()
    public ApplicationRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.api.MdmApiService apiService) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getApplicationList(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.repository.Result<? extends java.util.List<com.wisecloud.app.data.model.response.ApplicationInfo>>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object uploadApk(@org.jetbrains.annotations.NotNull()
    okhttp3.MultipartBody.Part file, @org.jetbrains.annotations.NotNull()
    okhttp3.RequestBody appAlias, @org.jetbrains.annotations.Nullable()
    okhttp3.RequestBody appDescription, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.repository.Result<com.wisecloud.app.data.model.response.AppUploadResponse>> $completion) {
        return null;
    }
}