package com.wisecloud.app.ui.wizard.instruction;

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
public final class PushInstructionViewModel_Factory implements Factory<PushInstructionViewModel> {
  private final Provider<TaskRepository> taskRepositoryProvider;

  public PushInstructionViewModel_Factory(Provider<TaskRepository> taskRepositoryProvider) {
    this.taskRepositoryProvider = taskRepositoryProvider;
  }

  @Override
  public PushInstructionViewModel get() {
    return newInstance(taskRepositoryProvider.get());
  }

  public static PushInstructionViewModel_Factory create(
      Provider<TaskRepository> taskRepositoryProvider) {
    return new PushInstructionViewModel_Factory(taskRepositoryProvider);
  }

  public static PushInstructionViewModel newInstance(TaskRepository taskRepository) {
    return new PushInstructionViewModel(taskRepository);
  }
}
