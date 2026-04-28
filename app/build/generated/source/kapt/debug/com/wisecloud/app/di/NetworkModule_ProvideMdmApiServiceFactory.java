package com.wisecloud.app.di;

import com.wisecloud.app.data.api.MdmApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

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
public final class NetworkModule_ProvideMdmApiServiceFactory implements Factory<MdmApiService> {
  private final Provider<Retrofit> retrofitProvider;

  public NetworkModule_ProvideMdmApiServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public MdmApiService get() {
    return provideMdmApiService(retrofitProvider.get());
  }

  public static NetworkModule_ProvideMdmApiServiceFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new NetworkModule_ProvideMdmApiServiceFactory(retrofitProvider);
  }

  public static MdmApiService provideMdmApiService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideMdmApiService(retrofit));
  }
}
