package com.wisecloud.app.ui.device.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.wisecloud.app.data.model.response.DeviceDetailResponse;
import com.wisecloud.app.data.repository.DeviceRepository;
import com.wisecloud.app.data.repository.Result;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/wisecloud/app/ui/device/detail/ChartPeriod;", "", "(Ljava/lang/String;I)V", "TODAY", "SEVEN_DAYS", "THIRTY_DAYS", "app_debug"})
public enum ChartPeriod {
    /*public static final*/ TODAY /* = new TODAY() */,
    /*public static final*/ SEVEN_DAYS /* = new SEVEN_DAYS() */,
    /*public static final*/ THIRTY_DAYS /* = new THIRTY_DAYS() */;
    
    ChartPeriod() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.wisecloud.app.ui.device.detail.ChartPeriod> getEntries() {
        return null;
    }
}