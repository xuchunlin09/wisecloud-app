package com.wisecloud.app.ui.dashboard;

import com.wisecloud.app.data.local.TokenManager;
import com.wisecloud.app.data.repository.DeviceRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
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
public final class DashboardViewModel_Factory implements Factory<DashboardViewModel> {
  private final Provider<DeviceRepository> deviceRepositoryProvider;

  private final Provider<TokenManager> tokenManagerProvider;

  public DashboardViewModel_Factory(Provider<DeviceRepository> deviceRepositoryProvider,
      Provider<TokenManager> tokenManagerProvider) {
    this.deviceRepositoryProvider = deviceRepositoryProvider;
    this.tokenManagerProvider = tokenManagerProvider;
  }

  @Override
  public DashboardViewModel get() {
    return newInstance(deviceRepositoryProvider.get(), tokenManagerProvider.get());
  }

  public static DashboardViewModel_Factory create(
      Provider<DeviceRepository> deviceRepositoryProvider,
      Provider<TokenManager> tokenManagerProvider) {
    return new DashboardViewModel_Factory(deviceRepositoryProvider, tokenManagerProvider);
  }

  public static DashboardViewModel newInstance(DeviceRepository deviceRepository,
      TokenManager tokenManager) {
    return new DashboardViewModel(deviceRepository, tokenManager);
  }
}
