package com.wisecloud.app.data.repository;

import com.wisecloud.app.data.api.MdmApiService;
import com.wisecloud.app.data.model.response.DeviceDetailResponse;
import com.wisecloud.app.data.model.response.DeviceOverviewResponse;
import com.wisecloud.app.data.model.response.DeviceSummary;
import com.wisecloud.app.data.model.response.PagedResponse;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u000bJ,\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u00072\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0096@\u00a2\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0007H\u0096@\u00a2\u0006\u0002\u0010\u0015J\"\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00170\u00072\u0006\u0010\u0018\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/wisecloud/app/data/repository/DeviceRepositoryImpl;", "Lcom/wisecloud/app/data/repository/BaseRepository;", "Lcom/wisecloud/app/data/repository/DeviceRepository;", "apiService", "Lcom/wisecloud/app/data/api/MdmApiService;", "(Lcom/wisecloud/app/data/api/MdmApiService;)V", "getDeviceDetail", "Lcom/wisecloud/app/data/repository/Result;", "Lcom/wisecloud/app/data/model/response/DeviceDetailResponse;", "sn", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDeviceList", "Lcom/wisecloud/app/data/model/response/PagedResponse;", "Lcom/wisecloud/app/data/model/response/DeviceSummary;", "page", "", "status", "(ILjava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOverview", "Lcom/wisecloud/app/data/model/response/DeviceOverviewResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchDevices", "", "keyword", "app_debug"})
public final class DeviceRepositoryImpl extends com.wisecloud.app.data.repository.BaseRepository implements com.wisecloud.app.data.repository.DeviceRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.wisecloud.app.data.api.MdmApiService apiService = null;
    
    @javax.inject.Inject()
    public DeviceRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.api.MdmApiService apiService) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getOverview(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.repository.Result<com.wisecloud.app.data.model.response.DeviceOverviewResponse>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object searchDevices(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.repository.Result<? extends java.util.List<com.wisecloud.app.data.model.response.DeviceSummary>>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getDeviceList(int page, @org.jetbrains.annotations.Nullable()
    java.lang.Integer status, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.repository.Result<com.wisecloud.app.data.model.response.PagedResponse<com.wisecloud.app.data.model.response.DeviceSummary>>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getDeviceDetail(@org.jetbrains.annotations.NotNull()
    java.lang.String sn, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.repository.Result<com.wisecloud.app.data.model.response.DeviceDetailResponse>> $completion) {
        return null;
    }
}