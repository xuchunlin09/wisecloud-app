package com.wisecloud.app.data.repository;

import com.wisecloud.app.data.api.MdmApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class DeviceRepositoryImpl_Factory implements Factory<DeviceRepositoryImpl> {
  private final Provider<MdmApiService> apiServiceProvider;

  public DeviceRepositoryImpl_Factory(Provider<MdmApiService> apiServiceProvider) {
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public DeviceRepositoryImpl get() {
    return newInstance(apiServiceProvider.get());
  }

  public static DeviceRepositoryImpl_Factory create(Provider<MdmApiService> apiServiceProvider) {
    return new DeviceRepositoryImpl_Factory(apiServiceProvider);
  }

  public static DeviceRepositoryImpl newInstance(MdmApiService apiService) {
    return new DeviceRepositoryImpl(apiService);
  }
}
