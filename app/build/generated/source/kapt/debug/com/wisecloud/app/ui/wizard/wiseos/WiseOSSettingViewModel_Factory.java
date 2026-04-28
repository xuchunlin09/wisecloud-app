package com.wisecloud.app.ui.wizard.wiseos;

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
public final class WiseOSSettingViewModel_Factory implements Factory<WiseOSSettingViewModel> {
  private final Provider<TaskRepository> taskRepositoryProvider;

  public WiseOSSettingViewModel_Factory(Provider<TaskRepository> taskRepositoryProvider) {
    this.taskRepositoryProvider = taskRepositoryProvider;
  }

  @Override
  public WiseOSSettingViewModel get() {
    return newInstance(taskRepositoryProvider.get());
  }

  public static WiseOSSettingViewModel_Factory create(
      Provider<TaskRepository> taskRepositoryProvider) {
    return new WiseOSSettingViewModel_Factory(taskRepositoryProvider);
  }

  public static WiseOSSettingViewModel newInstance(TaskRepository taskRepository) {
    return new WiseOSSettingViewModel(taskRepository);
  }
}
