package com.wisecloud.app.data.repository;

import com.wisecloud.app.data.api.MdmApiService;
import com.wisecloud.app.data.model.response.ApplicationInfo;
import com.wisecloud.app.data.model.response.AppUploadResponse;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0006J.\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00a6@\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/wisecloud/app/data/repository/ApplicationRepository;", "", "getApplicationList", "Lcom/wisecloud/app/data/repository/Result;", "", "Lcom/wisecloud/app/data/model/response/ApplicationInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadApk", "Lcom/wisecloud/app/data/model/response/AppUploadResponse;", "file", "Lokhttp3/MultipartBody$Part;", "appAlias", "Lokhttp3/RequestBody;", "appDescription", "(Lokhttp3/MultipartBody$Part;Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ApplicationRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getApplicationList(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.repository.Result<? extends java.util.List<com.wisecloud.app.data.model.response.ApplicationInfo>>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object uploadApk(@org.jetbrains.annotations.NotNull()
    okhttp3.MultipartBody.Part file, @org.jetbrains.annotations.NotNull()
    okhttp3.RequestBody appAlias, @org.jetbrains.annotations.Nullable()
    okhttp3.RequestBody appDescription, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.repository.Result<com.wisecloud.app.data.model.response.AppUploadResponse>> $completion);
}