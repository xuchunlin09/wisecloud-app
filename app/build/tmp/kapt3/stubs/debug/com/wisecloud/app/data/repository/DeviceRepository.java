package com.wisecloud.app.data.repository;

import com.wisecloud.app.data.api.MdmApiService;
import com.wisecloud.app.data.model.response.DeviceDetailResponse;
import com.wisecloud.app.data.model.response.DeviceOverviewResponse;
import com.wisecloud.app.data.model.response.DeviceSummary;
import com.wisecloud.app.data.model.response.PagedResponse;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00a2\u0006\u0002\u0010\u0007J.\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00032\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u00a6@\u00a2\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0011J\"\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00130\u00032\u0006\u0010\u0014\u001a\u00020\u0006H\u00a6@\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\u0015"}, d2 = {"Lcom/wisecloud/app/data/repository/DeviceRepository;", "", "getDeviceDetail", "Lcom/wisecloud/app/data/repository/Result;", "Lcom/wisecloud/app/data/model/response/DeviceDetailResponse;", "sn", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDeviceList", "Lcom/wisecloud/app/data/model/response/PagedResponse;", "Lcom/wisecloud/app/data/model/response/DeviceSummary;", "page", "", "status", "(ILjava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOverview", "Lcom/wisecloud/app/data/model/response/DeviceOverviewResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchDevices", "", "keyword", "app_debug"})
public abstract interface DeviceRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getOverview(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.repository.Result<com.wisecloud.app.data.model.response.DeviceOverviewResponse>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object searchDevices(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.repository.Result<? extends java.util.List<com.wisecloud.app.data.model.response.DeviceSummary>>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getDeviceList(int page, @org.jetbrains.annotations.Nullable()
    java.lang.Integer status, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.repository.Result<com.wisecloud.app.data.model.response.PagedResponse<com.wisecloud.app.data.model.response.DeviceSummary>>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getDeviceDetail(@org.jetbrains.annotations.NotNull()
    java.lang.String sn, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wisecloud.app.data.repository.Result<com.wisecloud.app.data.model.response.DeviceDetailResponse>> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}