package com.wisecloud.app.ui.wizard.install;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.wisecloud.app.R;
import com.wisecloud.app.data.model.response.AppVersion;
import com.wisecloud.app.data.model.response.ApplicationInfo;

/**
 * Adapter for displaying applications with expandable version selection.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0013\u0014B-\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\tJ\u001c\u0010\f\u001a\u00020\u00062\n\u0010\r\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u001c\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/wisecloud/app/ui/wizard/install/AppListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/wisecloud/app/data/model/response/ApplicationInfo;", "Lcom/wisecloud/app/ui/wizard/install/AppListAdapter$AppViewHolder;", "onAppSelected", "Lkotlin/Function1;", "", "onVersionSelected", "Lcom/wisecloud/app/data/model/response/AppVersion;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "selectedAppIndex", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "AppDiffCallback", "AppViewHolder", "app_debug"})
public final class AppListAdapter extends androidx.recyclerview.widget.ListAdapter<com.wisecloud.app.data.model.response.ApplicationInfo, com.wisecloud.app.ui.wizard.install.AppListAdapter.AppViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.wisecloud.app.data.model.response.ApplicationInfo, kotlin.Unit> onAppSelected = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.wisecloud.app.data.model.response.AppVersion, kotlin.Unit> onVersionSelected = null;
    private int selectedAppIndex = -1;
    
    public AppListAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.wisecloud.app.data.model.response.ApplicationInfo, kotlin.Unit> onAppSelected, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.wisecloud.app.data.model.response.AppVersion, kotlin.Unit> onVersionSelected) {
        super(null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.wisecloud.app.ui.wizard.install.AppListAdapter.AppViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.ui.wizard.install.AppListAdapter.AppViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/wisecloud/app/ui/wizard/install/AppListAdapter$AppDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/wisecloud/app/data/model/response/ApplicationInfo;", "()V", "areContentsTheSame", "", "a", "b", "areItemsTheSame", "app_debug"})
    public static final class AppDiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.wisecloud.app.data.model.response.ApplicationInfo> {
        
        public AppDiffCallback() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        com.wisecloud.app.data.model.response.ApplicationInfo a, @org.jetbrains.annotations.NotNull()
        com.wisecloud.app.data.model.response.ApplicationInfo b) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        com.wisecloud.app.data.model.response.ApplicationInfo a, @org.jetbrains.annotations.NotNull()
        com.wisecloud.app.data.model.response.ApplicationInfo b) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/wisecloud/app/ui/wizard/install/AppListAdapter$AppViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/wisecloud/app/ui/wizard/install/AppListAdapter;Landroid/view/View;)V", "layoutVersions", "Landroid/widget/LinearLayout;", "getLayoutVersions", "()Landroid/widget/LinearLayout;", "rbApp", "Landroid/widget/RadioButton;", "getRbApp", "()Landroid/widget/RadioButton;", "rvVersions", "Landroidx/recyclerview/widget/RecyclerView;", "getRvVersions", "()Landroidx/recyclerview/widget/RecyclerView;", "tvAppDesc", "Landroid/widget/TextView;", "getTvAppDesc", "()Landroid/widget/TextView;", "tvAppName", "getTvAppName", "app_debug"})
    public final class AppViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.RadioButton rbApp = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvAppName = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvAppDesc = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.LinearLayout layoutVersions = null;
        @org.jetbrains.annotations.NotNull()
        private final androidx.recyclerview.widget.RecyclerView rvVersions = null;
        
        public AppViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.RadioButton getRbApp() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvAppName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvAppDesc() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.LinearLayout getLayoutVersions() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.recyclerview.widget.RecyclerView getRvVersions() {
            return null;
        }
    }
}