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
public final class TaskRepositoryImpl_Factory implements Factory<TaskRepositoryImpl> {
  private final Provider<MdmApiService> apiServiceProvider;

  public TaskRepositoryImpl_Factory(Provider<MdmApiService> apiServiceProvider) {
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public TaskRepositoryImpl get() {
    return newInstance(apiServiceProvider.get());
  }

  public static TaskRepositoryImpl_Factory create(Provider<MdmApiService> apiServiceProvider) {
    return new TaskRepositoryImpl_Factory(apiServiceProvider);
  }

  public static TaskRepositoryImpl newInstance(MdmApiService apiService) {
    return new TaskRepositoryImpl(apiService);
  }
}
