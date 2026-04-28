package com.wisecloud.app.ui.wizard.filepush;

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
public final class FilePushViewModel_Factory implements Factory<FilePushViewModel> {
  private final Provider<TaskRepository> taskRepositoryProvider;

  public FilePushViewModel_Factory(Provider<TaskRepository> taskRepositoryProvider) {
    this.taskRepositoryProvider = taskRepositoryProvider;
  }

  @Override
  public FilePushViewModel get() {
    return newInstance(taskRepositoryProvider.get());
  }

  public static FilePushViewModel_Factory create(Provider<TaskRepository> taskRepositoryProvider) {
    return new FilePushViewModel_Factory(taskRepositoryProvider);
  }

  public static FilePushViewModel newInstance(TaskRepository taskRepository) {
    return new FilePushViewModel(taskRepository);
  }
}
