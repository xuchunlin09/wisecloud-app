package com.wisecloud.app.ui.device.detail;

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
public final class DeviceDetailViewModel_Factory implements Factory<DeviceDetailViewModel> {
  private final Provider<DeviceRepository> deviceRepositoryProvider;

  public DeviceDetailViewModel_Factory(Provider<DeviceRepository> deviceRepositoryProvider) {
    this.deviceRepositoryProvider = deviceRepositoryProvider;
  }

  @Override
  public DeviceDetailViewModel get() {
    return newInstance(deviceRepositoryProvider.get());
  }

  public static DeviceDetailViewModel_Factory create(
      Provider<DeviceRepository> deviceRepositoryProvider) {
    return new DeviceDetailViewModel_Factory(deviceRepositoryProvider);
  }

  public static DeviceDetailViewModel newInstance(DeviceRepository deviceRepository) {
    return new DeviceDetailViewModel(deviceRepository);
  }
}
