package com.wisecloud.app.ui.device.detail;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.wisecloud.app.data.model.response.InstalledApp;
import com.wisecloud.app.databinding.ItemInstalledAppGridBinding;
import com.wisecloud.app.databinding.ItemInstalledAppListBinding;

/**
 * Grid mode adapter for installed apps (icon + name, 4-column grid)
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/wisecloud/app/ui/device/detail/InstalledAppGridAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/wisecloud/app/data/model/response/InstalledApp;", "Lcom/wisecloud/app/ui/device/detail/InstalledAppGridAdapter$ViewHolder;", "()V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
public final class InstalledAppGridAdapter extends androidx.recyclerview.widget.ListAdapter<com.wisecloud.app.data.model.response.InstalledApp, com.wisecloud.app.ui.device.detail.InstalledAppGridAdapter.ViewHolder> {
    
    public InstalledAppGridAdapter() {
        super(null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.wisecloud.app.ui.device.detail.InstalledAppGridAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.ui.device.detail.InstalledAppGridAdapter.ViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/wisecloud/app/ui/device/detail/InstalledAppGridAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/wisecloud/app/databinding/ItemInstalledAppGridBinding;", "(Lcom/wisecloud/app/databinding/ItemInstalledAppGridBinding;)V", "bind", "", "app", "Lcom/wisecloud/app/data/model/response/InstalledApp;", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.wisecloud.app.databinding.ItemInstalledAppGridBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.wisecloud.app.databinding.ItemInstalledAppGridBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.wisecloud.app.data.model.response.InstalledApp app) {
        }
    }
}