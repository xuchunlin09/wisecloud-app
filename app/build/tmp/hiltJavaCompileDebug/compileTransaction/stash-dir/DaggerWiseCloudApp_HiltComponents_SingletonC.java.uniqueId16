package com.wisecloud.app;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.wisecloud.app.data.api.MdmApiService;
import com.wisecloud.app.data.local.TokenManager;
import com.wisecloud.app.data.repository.ApplicationRepositoryImpl;
import com.wisecloud.app.data.repository.AuthRepositoryImpl;
import com.wisecloud.app.data.repository.DeviceRepositoryImpl;
import com.wisecloud.app.data.repository.TaskRepositoryImpl;
import com.wisecloud.app.di.NetworkModule_ProvideLoggingInterceptorFactory;
import com.wisecloud.app.di.NetworkModule_ProvideMdmApiServiceFactory;
import com.wisecloud.app.di.NetworkModule_ProvideOkHttpClientFactory;
import com.wisecloud.app.di.NetworkModule_ProvideRetrofitFactory;
import com.wisecloud.app.ui.MainActivity;
import com.wisecloud.app.ui.auth.LoginFragment;
import com.wisecloud.app.ui.auth.LoginViewModel;
import com.wisecloud.app.ui.auth.LoginViewModel_HiltModules_KeyModule_ProvideFactory;
import com.wisecloud.app.ui.auth.RegisterFragment;
import com.wisecloud.app.ui.auth.RegisterViewModel;
import com.wisecloud.app.ui.auth.RegisterViewModel_HiltModules_KeyModule_ProvideFactory;
import com.wisecloud.app.ui.dashboard.DashboardFragment;
import com.wisecloud.app.ui.dashboard.DashboardViewModel;
import com.wisecloud.app.ui.dashboard.DashboardViewModel_HiltModules_KeyModule_ProvideFactory;
import com.wisecloud.app.ui.device.detail.DeviceDetailFragment;
import com.wisecloud.app.ui.device.detail.DeviceDetailViewModel;
import com.wisecloud.app.ui.device.detail.DeviceDetailViewModel_HiltModules_KeyModule_ProvideFactory;
import com.wisecloud.app.ui.device.list.DeviceListFragment;
import com.wisecloud.app.ui.device.list.DeviceListViewModel;
import com.wisecloud.app.ui.device.list.DeviceListViewModel_HiltModules_KeyModule_ProvideFactory;
import com.wisecloud.app.ui.task.detail.TaskDetailFragment;
import com.wisecloud.app.ui.task.detail.TaskDetailViewModel;
import com.wisecloud.app.ui.task.detail.TaskDetailViewModel_HiltModules_KeyModule_ProvideFactory;
import com.wisecloud.app.ui.task.list.TaskListFragment;
import com.wisecloud.app.ui.task.list.TaskListViewModel;
import com.wisecloud.app.ui.task.list.TaskListViewModel_HiltModules_KeyModule_ProvideFactory;
import com.wisecloud.app.ui.wizard.filepush.FilePushViewModel;
import com.wisecloud.app.ui.wizard.filepush.FilePushViewModel_HiltModules_KeyModule_ProvideFactory;
import com.wisecloud.app.ui.wizard.filepush.FilePushWizardFragment;
import com.wisecloud.app.ui.wizard.install.BatchInstallViewModel;
import com.wisecloud.app.ui.wizard.install.BatchInstallViewModel_HiltModules_KeyModule_ProvideFactory;
import com.wisecloud.app.ui.wizard.install.BatchInstallWizardFragment;
import com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel;
import com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel_HiltModules_KeyModule_ProvideFactory;
import com.wisecloud.app.ui.wizard.instruction.PushInstructionWizardFragment;
import com.wisecloud.app.ui.wizard.ota.OtaUpdateViewModel;
import com.wisecloud.app.ui.wizard.ota.OtaUpdateViewModel_HiltModules_KeyModule_ProvideFactory;
import com.wisecloud.app.ui.wizard.ota.OtaUpdateWizardFragment;
import com.wisecloud.app.ui.wizard.uninstall.BatchUninstallViewModel;
import com.wisecloud.app.ui.wizard.uninstall.BatchUninstallViewModel_HiltModules_KeyModule_ProvideFactory;
import com.wisecloud.app.ui.wizard.uninstall.BatchUninstallWizardFragment;
import com.wisecloud.app.ui.wizard.wiseos.WiseOSSettingViewModel;
import com.wisecloud.app.ui.wizard.wiseos.WiseOSSettingViewModel_HiltModules_KeyModule_ProvideFactory;
import com.wisecloud.app.ui.wizard.wiseos.WiseOSSettingWizardFragment;
import com.wisecloud.app.util.AuthInterceptor;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.SetBuilder;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class DaggerWiseCloudApp_HiltComponents_SingletonC {
  private DaggerWiseCloudApp_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public WiseCloudApp_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new SingletonCImpl(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements WiseCloudApp_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public WiseCloudApp_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements WiseCloudApp_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public WiseCloudApp_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements WiseCloudApp_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public WiseCloudApp_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements WiseCloudApp_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public WiseCloudApp_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements WiseCloudApp_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public WiseCloudApp_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements WiseCloudApp_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public WiseCloudApp_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements WiseCloudApp_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public WiseCloudApp_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends WiseCloudApp_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends WiseCloudApp_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public void injectLoginFragment(LoginFragment arg0) {
    }

    @Override
    public void injectRegisterFragment(RegisterFragment arg0) {
    }

    @Override
    public void injectDashboardFragment(DashboardFragment arg0) {
    }

    @Override
    public void injectDeviceDetailFragment(DeviceDetailFragment arg0) {
    }

    @Override
    public void injectDeviceListFragment(DeviceListFragment arg0) {
    }

    @Override
    public void injectTaskDetailFragment(TaskDetailFragment arg0) {
    }

    @Override
    public void injectTaskListFragment(TaskListFragment arg0) {
    }

    @Override
    public void injectFilePushWizardFragment(FilePushWizardFragment arg0) {
    }

    @Override
    public void injectBatchInstallWizardFragment(BatchInstallWizardFragment arg0) {
    }

    @Override
    public void injectPushInstructionWizardFragment(PushInstructionWizardFragment arg0) {
    }

    @Override
    public void injectOtaUpdateWizardFragment(OtaUpdateWizardFragment arg0) {
    }

    @Override
    public void injectBatchUninstallWizardFragment(BatchUninstallWizardFragment arg0) {
    }

    @Override
    public void injectWiseOSSettingWizardFragment(WiseOSSettingWizardFragment arg0) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends WiseCloudApp_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends WiseCloudApp_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectMainActivity(MainActivity arg0) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Set<String> getViewModelKeys() {
      return SetBuilder.<String>newSetBuilder(13).add(BatchInstallViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(BatchUninstallViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(DashboardViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(DeviceDetailViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(DeviceListViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(FilePushViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(LoginViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(OtaUpdateViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(PushInstructionViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(RegisterViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(TaskDetailViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(TaskListViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(WiseOSSettingViewModel_HiltModules_KeyModule_ProvideFactory.provide()).build();
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }
  }

  private static final class ViewModelCImpl extends WiseCloudApp_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<BatchInstallViewModel> batchInstallViewModelProvider;

    private Provider<BatchUninstallViewModel> batchUninstallViewModelProvider;

    private Provider<DashboardViewModel> dashboardViewModelProvider;

    private Provider<DeviceDetailViewModel> deviceDetailViewModelProvider;

    private Provider<DeviceListViewModel> deviceListViewModelProvider;

    private Provider<FilePushViewModel> filePushViewModelProvider;

    private Provider<LoginViewModel> loginViewModelProvider;

    private Provider<OtaUpdateViewModel> otaUpdateViewModelProvider;

    private Provider<PushInstructionViewModel> pushInstructionViewModelProvider;

    private Provider<RegisterViewModel> registerViewModelProvider;

    private Provider<TaskDetailViewModel> taskDetailViewModelProvider;

    private Provider<TaskListViewModel> taskListViewModelProvider;

    private Provider<WiseOSSettingViewModel> wiseOSSettingViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.batchInstallViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.batchUninstallViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.dashboardViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.deviceDetailViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
      this.deviceListViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4);
      this.filePushViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 5);
      this.loginViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 6);
      this.otaUpdateViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 7);
      this.pushInstructionViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 8);
      this.registerViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 9);
      this.taskDetailViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 10);
      this.taskListViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 11);
      this.wiseOSSettingViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 12);
    }

    @Override
    public Map<String, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return MapBuilder.<String, javax.inject.Provider<ViewModel>>newMapBuilder(13).put("com.wisecloud.app.ui.wizard.install.BatchInstallViewModel", ((Provider) batchInstallViewModelProvider)).put("com.wisecloud.app.ui.wizard.uninstall.BatchUninstallViewModel", ((Provider) batchUninstallViewModelProvider)).put("com.wisecloud.app.ui.dashboard.DashboardViewModel", ((Provider) dashboardViewModelProvider)).put("com.wisecloud.app.ui.device.detail.DeviceDetailViewModel", ((Provider) deviceDetailViewModelProvider)).put("com.wisecloud.app.ui.device.list.DeviceListViewModel", ((Provider) deviceListViewModelProvider)).put("com.wisecloud.app.ui.wizard.filepush.FilePushViewModel", ((Provider) filePushViewModelProvider)).put("com.wisecloud.app.ui.auth.LoginViewModel", ((Provider) loginViewModelProvider)).put("com.wisecloud.app.ui.wizard.ota.OtaUpdateViewModel", ((Provider) otaUpdateViewModelProvider)).put("com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel", ((Provider) pushInstructionViewModelProvider)).put("com.wisecloud.app.ui.auth.RegisterViewModel", ((Provider) registerViewModelProvider)).put("com.wisecloud.app.ui.task.detail.TaskDetailViewModel", ((Provider) taskDetailViewModelProvider)).put("com.wisecloud.app.ui.task.list.TaskListViewModel", ((Provider) taskListViewModelProvider)).put("com.wisecloud.app.ui.wizard.wiseos.WiseOSSettingViewModel", ((Provider) wiseOSSettingViewModelProvider)).build();
    }

    @Override
    public Map<String, Object> getHiltViewModelAssistedMap() {
      return Collections.<String, Object>emptyMap();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.wisecloud.app.ui.wizard.install.BatchInstallViewModel 
          return (T) new BatchInstallViewModel(singletonCImpl.applicationRepositoryImplProvider.get(), singletonCImpl.taskRepositoryImplProvider.get());

          case 1: // com.wisecloud.app.ui.wizard.uninstall.BatchUninstallViewModel 
          return (T) new BatchUninstallViewModel(singletonCImpl.applicationRepositoryImplProvider.get(), singletonCImpl.taskRepositoryImplProvider.get());

          case 2: // com.wisecloud.app.ui.dashboard.DashboardViewModel 
          return (T) new DashboardViewModel(singletonCImpl.deviceRepositoryImplProvider.get(), singletonCImpl.tokenManagerProvider.get());

          case 3: // com.wisecloud.app.ui.device.detail.DeviceDetailViewModel 
          return (T) new DeviceDetailViewModel(singletonCImpl.deviceRepositoryImplProvider.get());

          case 4: // com.wisecloud.app.ui.device.list.DeviceListViewModel 
          return (T) new DeviceListViewModel(singletonCImpl.deviceRepositoryImplProvider.get());

          case 5: // com.wisecloud.app.ui.wizard.filepush.FilePushViewModel 
          return (T) new FilePushViewModel(singletonCImpl.taskRepositoryImplProvider.get());

          case 6: // com.wisecloud.app.ui.auth.LoginViewModel 
          return (T) new LoginViewModel(singletonCImpl.authRepositoryImplProvider.get(), singletonCImpl.tokenManagerProvider.get());

          case 7: // com.wisecloud.app.ui.wizard.ota.OtaUpdateViewModel 
          return (T) new OtaUpdateViewModel(singletonCImpl.taskRepositoryImplProvider.get());

          case 8: // com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel 
          return (T) new PushInstructionViewModel(singletonCImpl.taskRepositoryImplProvider.get());

          case 9: // com.wisecloud.app.ui.auth.RegisterViewModel 
          return (T) new RegisterViewModel(singletonCImpl.authRepositoryImplProvider.get());

          case 10: // com.wisecloud.app.ui.task.detail.TaskDetailViewModel 
          return (T) new TaskDetailViewModel(singletonCImpl.taskRepositoryImplProvider.get());

          case 11: // com.wisecloud.app.ui.task.list.TaskListViewModel 
          return (T) new TaskListViewModel(singletonCImpl.taskRepositoryImplProvider.get());

          case 12: // com.wisecloud.app.ui.wizard.wiseos.WiseOSSettingViewModel 
          return (T) new WiseOSSettingViewModel(singletonCImpl.taskRepositoryImplProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends WiseCloudApp_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends WiseCloudApp_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends WiseCloudApp_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<TokenManager> tokenManagerProvider;

    private Provider<AuthInterceptor> authInterceptorProvider;

    private Provider<HttpLoggingInterceptor> provideLoggingInterceptorProvider;

    private Provider<OkHttpClient> provideOkHttpClientProvider;

    private Provider<Retrofit> provideRetrofitProvider;

    private Provider<MdmApiService> provideMdmApiServiceProvider;

    private Provider<ApplicationRepositoryImpl> applicationRepositoryImplProvider;

    private Provider<TaskRepositoryImpl> taskRepositoryImplProvider;

    private Provider<DeviceRepositoryImpl> deviceRepositoryImplProvider;

    private Provider<AuthRepositoryImpl> authRepositoryImplProvider;

    private SingletonCImpl(ApplicationContextModule applicationContextModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;
      initialize(applicationContextModuleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam) {
      this.tokenManagerProvider = DoubleCheck.provider(new SwitchingProvider<TokenManager>(singletonCImpl, 5));
      this.authInterceptorProvider = DoubleCheck.provider(new SwitchingProvider<AuthInterceptor>(singletonCImpl, 4));
      this.provideLoggingInterceptorProvider = DoubleCheck.provider(new SwitchingProvider<HttpLoggingInterceptor>(singletonCImpl, 6));
      this.provideOkHttpClientProvider = DoubleCheck.provider(new SwitchingProvider<OkHttpClient>(singletonCImpl, 3));
      this.provideRetrofitProvider = DoubleCheck.provider(new SwitchingProvider<Retrofit>(singletonCImpl, 2));
      this.provideMdmApiServiceProvider = DoubleCheck.provider(new SwitchingProvider<MdmApiService>(singletonCImpl, 1));
      this.applicationRepositoryImplProvider = DoubleCheck.provider(new SwitchingProvider<ApplicationRepositoryImpl>(singletonCImpl, 0));
      this.taskRepositoryImplProvider = DoubleCheck.provider(new SwitchingProvider<TaskRepositoryImpl>(singletonCImpl, 7));
      this.deviceRepositoryImplProvider = DoubleCheck.provider(new SwitchingProvider<DeviceRepositoryImpl>(singletonCImpl, 8));
      this.authRepositoryImplProvider = DoubleCheck.provider(new SwitchingProvider<AuthRepositoryImpl>(singletonCImpl, 9));
    }

    @Override
    public void injectWiseCloudApp(WiseCloudApp wiseCloudApp) {
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return Collections.<Boolean>emptySet();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.wisecloud.app.data.repository.ApplicationRepositoryImpl 
          return (T) new ApplicationRepositoryImpl(singletonCImpl.provideMdmApiServiceProvider.get());

          case 1: // com.wisecloud.app.data.api.MdmApiService 
          return (T) NetworkModule_ProvideMdmApiServiceFactory.provideMdmApiService(singletonCImpl.provideRetrofitProvider.get());

          case 2: // retrofit2.Retrofit 
          return (T) NetworkModule_ProvideRetrofitFactory.provideRetrofit(singletonCImpl.provideOkHttpClientProvider.get());

          case 3: // okhttp3.OkHttpClient 
          return (T) NetworkModule_ProvideOkHttpClientFactory.provideOkHttpClient(singletonCImpl.authInterceptorProvider.get(), singletonCImpl.provideLoggingInterceptorProvider.get());

          case 4: // com.wisecloud.app.util.AuthInterceptor 
          return (T) new AuthInterceptor(singletonCImpl.tokenManagerProvider.get());

          case 5: // com.wisecloud.app.data.local.TokenManager 
          return (T) new TokenManager(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 6: // okhttp3.logging.HttpLoggingInterceptor 
          return (T) NetworkModule_ProvideLoggingInterceptorFactory.provideLoggingInterceptor();

          case 7: // com.wisecloud.app.data.repository.TaskRepositoryImpl 
          return (T) new TaskRepositoryImpl(singletonCImpl.provideMdmApiServiceProvider.get());

          case 8: // com.wisecloud.app.data.repository.DeviceRepositoryImpl 
          return (T) new DeviceRepositoryImpl(singletonCImpl.provideMdmApiServiceProvider.get());

          case 9: // com.wisecloud.app.data.repository.AuthRepositoryImpl 
          return (T) new AuthRepositoryImpl(singletonCImpl.provideMdmApiServiceProvider.get(), singletonCImpl.tokenManagerProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
