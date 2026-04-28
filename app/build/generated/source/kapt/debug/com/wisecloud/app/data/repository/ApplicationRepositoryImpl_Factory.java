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
public final class ApplicationRepositoryImpl_Factory implements Factory<ApplicationRepositoryImpl> {
  private final Provider<MdmApiService> apiServiceProvider;

  public ApplicationRepositoryImpl_Factory(Provider<MdmApiService> apiServiceProvider) {
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public ApplicationRepositoryImpl get() {
    return newInstance(apiServiceProvider.get());
  }

  public static ApplicationRepositoryImpl_Factory create(
      Provider<MdmApiService> apiServiceProvider) {
    return new ApplicationRepositoryImpl_Factory(apiServiceProvider);
  }

  public static ApplicationRepositoryImpl newInstance(MdmApiService apiService) {
    return new ApplicationRepositoryImpl(apiService);
  }
}
