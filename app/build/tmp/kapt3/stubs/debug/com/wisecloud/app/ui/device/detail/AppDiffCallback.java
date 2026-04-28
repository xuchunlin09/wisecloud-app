package com.wisecloud.app.ui.device.detail;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.wisecloud.app.data.model.response.InstalledApp;
import com.wisecloud.app.databinding.ItemInstalledAppGridBinding;
import com.wisecloud.app.databinding.ItemInstalledAppListBinding;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c2\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/wisecloud/app/ui/device/detail/AppDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/wisecloud/app/data/model/response/InstalledApp;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
final class AppDiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.wisecloud.app.data.model.response.InstalledApp> {
    @org.jetbrains.annotations.NotNull()
    public static final com.wisecloud.app.ui.device.detail.AppDiffCallback INSTANCE = null;
    
    private AppDiffCallback() {
        super();
    }
    
    @java.lang.Override()
    public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.model.response.InstalledApp oldItem, @org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.model.response.InstalledApp newItem) {
        return false;
    }
    
    @java.lang.Override()
    public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.model.response.InstalledApp oldItem, @org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.model.response.InstalledApp newItem) {
        return false;
    }
}