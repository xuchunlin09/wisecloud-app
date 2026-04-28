package com.wisecloud.app.ui.task.list;

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
public final class TaskListViewModel_Factory implements Factory<TaskListViewModel> {
  private final Provider<TaskRepository> taskRepositoryProvider;

  public TaskListViewModel_Factory(Provider<TaskRepository> taskRepositoryProvider) {
    this.taskRepositoryProvider = taskRepositoryProvider;
  }

  @Override
  public TaskListViewModel get() {
    return newInstance(taskRepositoryProvider.get());
  }

  public static TaskListViewModel_Factory create(Provider<TaskRepository> taskRepositoryProvider) {
    return new TaskListViewModel_Factory(taskRepositoryProvider);
  }

  public static TaskListViewModel newInstance(TaskRepository taskRepository) {
    return new TaskListViewModel(taskRepository);
  }
}
