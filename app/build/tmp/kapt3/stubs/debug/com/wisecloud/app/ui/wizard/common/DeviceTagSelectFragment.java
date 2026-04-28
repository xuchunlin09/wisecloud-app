package com.wisecloud.app.ui.wizard.common;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.wisecloud.app.R;
import com.wisecloud.app.databinding.FragmentDeviceTagSelectBinding;

/**
 * Reusable fragment for device tag multi-select list with search.
 *
 * Usage: Embed in wizard Step 3 to let users select device tags.
 * Call [setTags] to populate and [getSelectedTags] to retrieve selections.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 %2\u00020\u0001:\u0003%&\'B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eJ\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u000eJ$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\u001a\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0014\u0010\"\u001a\u00020\u00132\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\u000eJ\b\u0010$\u001a\u00020\u0013H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00060\u0006R\u00020\u0000X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/wisecloud/app/ui/wizard/common/DeviceTagSelectFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/wisecloud/app/databinding/FragmentDeviceTagSelectBinding;", "adapter", "Lcom/wisecloud/app/ui/wizard/common/DeviceTagSelectFragment$TagAdapter;", "allTags", "", "Lcom/wisecloud/app/ui/wizard/common/DeviceTagSelectFragment$DeviceTag;", "binding", "getBinding", "()Lcom/wisecloud/app/databinding/FragmentDeviceTagSelectBinding;", "filteredTags", "", "selectedTagIds", "", "", "filterTags", "", "query", "getSelectedTagIds", "getSelectedTags", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setTags", "tags", "updateUI", "Companion", "DeviceTag", "TagAdapter", "app_debug"})
public final class DeviceTagSelectFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.wisecloud.app.databinding.FragmentDeviceTagSelectBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.wisecloud.app.ui.wizard.common.DeviceTagSelectFragment.DeviceTag> allTags = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Set<java.lang.String> selectedTagIds = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.wisecloud.app.ui.wizard.common.DeviceTagSelectFragment.DeviceTag> filteredTags;
    private com.wisecloud.app.ui.wizard.common.DeviceTagSelectFragment.TagAdapter adapter;
    @org.jetbrains.annotations.NotNull()
    public static final com.wisecloud.app.ui.wizard.common.DeviceTagSelectFragment.Companion Companion = null;
    
    public DeviceTagSelectFragment() {
        super();
    }
    
    private final com.wisecloud.app.databinding.FragmentDeviceTagSelectBinding getBinding() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void setTags(@org.jetbrains.annotations.NotNull()
    java.util.List<com.wisecloud.app.ui.wizard.common.DeviceTagSelectFragment.DeviceTag> tags) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.wisecloud.app.ui.wizard.common.DeviceTagSelectFragment.DeviceTag> getSelectedTags() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getSelectedTagIds() {
        return null;
    }
    
    private final void filterTags(java.lang.String query) {
    }
    
    private final void updateUI() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/wisecloud/app/ui/wizard/common/DeviceTagSelectFragment$Companion;", "", "()V", "newInstance", "Lcom/wisecloud/app/ui/wizard/common/DeviceTagSelectFragment;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.wisecloud.app.ui.wizard.common.DeviceTagSelectFragment newInstance() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J\'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/wisecloud/app/ui/wizard/common/DeviceTagSelectFragment$DeviceTag;", "", "id", "", "name", "deviceCount", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getDeviceCount", "()I", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
    public static final class DeviceTag {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String id = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String name = null;
        private final int deviceCount = 0;
        
        public DeviceTag(@org.jetbrains.annotations.NotNull()
        java.lang.String id, @org.jetbrains.annotations.NotNull()
        java.lang.String name, int deviceCount) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getId() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getName() {
            return null;
        }
        
        public final int getDeviceCount() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        public final int component3() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.wisecloud.app.ui.wizard.common.DeviceTagSelectFragment.DeviceTag copy(@org.jetbrains.annotations.NotNull()
        java.lang.String id, @org.jetbrains.annotations.NotNull()
        java.lang.String name, int deviceCount) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016J \u0010\u000b\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/wisecloud/app/ui/wizard/common/DeviceTagSelectFragment$TagAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/wisecloud/app/ui/wizard/common/DeviceTagSelectFragment$TagAdapter$TagViewHolder;", "Lcom/wisecloud/app/ui/wizard/common/DeviceTagSelectFragment;", "(Lcom/wisecloud/app/ui/wizard/common/DeviceTagSelectFragment;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "TagViewHolder", "app_debug"})
    final class TagAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.wisecloud.app.ui.wizard.common.DeviceTagSelectFragment.TagAdapter.TagViewHolder> {
        
        public TagAdapter() {
            super();
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public com.wisecloud.app.ui.wizard.common.DeviceTagSelectFragment.TagAdapter.TagViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        @java.lang.Override()
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
        com.wisecloud.app.ui.wizard.common.DeviceTagSelectFragment.TagAdapter.TagViewHolder holder, int position) {
        }
        
        @java.lang.Override()
        public int getItemCount() {
            return 0;
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/wisecloud/app/ui/wizard/common/DeviceTagSelectFragment$TagAdapter$TagViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/wisecloud/app/ui/wizard/common/DeviceTagSelectFragment$TagAdapter;Landroid/view/View;)V", "cbTag", "Landroid/widget/CheckBox;", "getCbTag", "()Landroid/widget/CheckBox;", "tvDeviceCount", "Landroid/widget/TextView;", "getTvDeviceCount", "()Landroid/widget/TextView;", "tvTagName", "getTvTagName", "app_debug"})
        public final class TagViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
            @org.jetbrains.annotations.NotNull()
            private final android.widget.CheckBox cbTag = null;
            @org.jetbrains.annotations.NotNull()
            private final android.widget.TextView tvTagName = null;
            @org.jetbrains.annotations.NotNull()
            private final android.widget.TextView tvDeviceCount = null;
            
            public TagViewHolder(@org.jetbrains.annotations.NotNull()
            android.view.View itemView) {
                super(null);
            }
            
            @org.jetbrains.annotations.NotNull()
            public final android.widget.CheckBox getCbTag() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final android.widget.TextView getTvTagName() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final android.widget.TextView getTvDeviceCount() {
                return null;
            }
        }
    }
}