package com.wisecloud.app.ui.wizard.install;

import com.wisecloud.app.data.repository.ApplicationRepository;
import com.wisecloud.app.data.repository.TaskRepository;
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
public final class BatchInstallViewModel_Factory implements Factory<BatchInstallViewModel> {
  private final Provider<ApplicationRepository> applicationRepositoryProvider;

  private final Provider<TaskRepository> taskRepositoryProvider;

  public BatchInstallViewModel_Factory(
      Provider<ApplicationRepository> applicationRepositoryProvider,
      Provider<TaskRepository> taskRepositoryProvider) {
    this.applicationRepositoryProvider = applicationRepositoryProvider;
    this.taskRepositoryProvider = taskRepositoryProvider;
  }

  @Override
  public BatchInstallViewModel get() {
    return newInstance(applicationRepositoryProvider.get(), taskRepositoryProvider.get());
  }

  public static BatchInstallViewModel_Factory create(
      Provider<ApplicationRepository> applicationRepositoryProvider,
      Provider<TaskRepository> taskRepositoryProvider) {
    return new BatchInstallViewModel_Factory(applicationRepositoryProvider, taskRepositoryProvider);
  }

  public static BatchInstallViewModel newInstance(ApplicationRepository applicationRepository,
      TaskRepository taskRepository) {
    return new BatchInstallViewModel(applicationRepository, taskRepository);
  }
}
