package com.wisecloud.app.ui.wizard.ota;

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
public final class OtaUpdateViewModel_Factory implements Factory<OtaUpdateViewModel> {
  private final Provider<TaskRepository> taskRepositoryProvider;

  public OtaUpdateViewModel_Factory(Provider<TaskRepository> taskRepositoryProvider) {
    this.taskRepositoryProvider = taskRepositoryProvider;
  }

  @Override
  public OtaUpdateViewModel get() {
    return newInstance(taskRepositoryProvider.get());
  }

  public static OtaUpdateViewModel_Factory create(Provider<TaskRepository> taskRepositoryProvider) {
    return new OtaUpdateViewModel_Factory(taskRepositoryProvider);
  }

  public static OtaUpdateViewModel newInstance(TaskRepository taskRepository) {
    return new OtaUpdateViewModel(taskRepository);
  }
}
