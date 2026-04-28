package com.wisecloud.app.di;

import com.wisecloud.app.data.repository.*;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\tH\'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\fH\'J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000fH\'\u00a8\u0006\u0010"}, d2 = {"Lcom/wisecloud/app/di/RepositoryModule;", "", "()V", "bindApplicationRepository", "Lcom/wisecloud/app/data/repository/ApplicationRepository;", "impl", "Lcom/wisecloud/app/data/repository/ApplicationRepositoryImpl;", "bindAuthRepository", "Lcom/wisecloud/app/data/repository/AuthRepository;", "Lcom/wisecloud/app/data/repository/AuthRepositoryImpl;", "bindDeviceRepository", "Lcom/wisecloud/app/data/repository/DeviceRepository;", "Lcom/wisecloud/app/data/repository/DeviceRepositoryImpl;", "bindTaskRepository", "Lcom/wisecloud/app/data/repository/TaskRepository;", "Lcom/wisecloud/app/data/repository/TaskRepositoryImpl;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract class RepositoryModule {
    
    public RepositoryModule() {
        super();
    }
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.wisecloud.app.data.repository.AuthRepository bindAuthRepository(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.repository.AuthRepositoryImpl impl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.wisecloud.app.data.repository.DeviceRepository bindDeviceRepository(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.repository.DeviceRepositoryImpl impl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.wisecloud.app.data.repository.TaskRepository bindTaskRepository(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.repository.TaskRepositoryImpl impl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.wisecloud.app.data.repository.ApplicationRepository bindApplicationRepository(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.repository.ApplicationRepositoryImpl impl);
}