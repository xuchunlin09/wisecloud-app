package com.wisecloud.app.ui.auth;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.wisecloud.app.data.local.TokenManager;
import com.wisecloud.app.data.repository.AuthRepository;
import com.wisecloud.app.data.repository.Result;
import com.wisecloud.app.util.InputValidator;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/wisecloud/app/ui/auth/VerifyMethod;", "", "(Ljava/lang/String;I)V", "EMAIL", "MFA", "app_debug"})
public enum VerifyMethod {
    /*public static final*/ EMAIL /* = new EMAIL() */,
    /*public static final*/ MFA /* = new MFA() */;
    
    VerifyMethod() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.wisecloud.app.ui.auth.VerifyMethod> getEntries() {
        return null;
    }
}