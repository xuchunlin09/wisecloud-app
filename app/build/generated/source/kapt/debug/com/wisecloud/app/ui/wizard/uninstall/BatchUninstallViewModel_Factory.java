package com.wisecloud.app.ui.wizard.uninstall;

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
public final class BatchUninstallViewModel_Factory implements Factory<BatchUninstallViewModel> {
  private final Provider<ApplicationRepository> applicationRepositoryProvider;

  private final Provider<TaskRepository> taskRepositoryProvider;

  public BatchUninstallViewModel_Factory(
      Provider<ApplicationRepository> applicationRepositoryProvider,
      Provider<TaskRepository> taskRepositoryProvider) {
    this.applicationRepositoryProvider = applicationRepositoryProvider;
    this.taskRepositoryProvider = taskRepositoryProvider;
  }

  @Override
  public BatchUninstallViewModel get() {
    return newInstance(applicationRepositoryProvider.get(), taskRepositoryProvider.get());
  }

  public static BatchUninstallViewModel_Factory create(
      Provider<ApplicationRepository> applicationRepositoryProvider,
      Provider<TaskRepository> taskRepositoryProvider) {
    return new BatchUninstallViewModel_Factory(applicationRepositoryProvider, taskRepositoryProvider);
  }

  public static BatchUninstallViewModel newInstance(ApplicationRepository applicationRepository,
      TaskRepository taskRepository) {
    return new BatchUninstallViewModel(applicationRepository, taskRepository);
  }
}
