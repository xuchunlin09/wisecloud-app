package com.wisecloud.app.ui.device.list;

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
public final class DeviceListViewModel_Factory implements Factory<DeviceListViewModel> {
  private final Provider<DeviceRepository> deviceRepositoryProvider;

  public DeviceListViewModel_Factory(Provider<DeviceRepository> deviceRepositoryProvider) {
    this.deviceRepositoryProvider = deviceRepositoryProvider;
  }

  @Override
  public DeviceListViewModel get() {
    return newInstance(deviceRepositoryProvider.get());
  }

  public static DeviceListViewModel_Factory create(
      Provider<DeviceRepository> deviceRepositoryProvider) {
    return new DeviceListViewModel_Factory(deviceRepositoryProvider);
  }

  public static DeviceListViewModel newInstance(DeviceRepository deviceRepository) {
    return new DeviceListViewModel(deviceRepository);
  }
}
