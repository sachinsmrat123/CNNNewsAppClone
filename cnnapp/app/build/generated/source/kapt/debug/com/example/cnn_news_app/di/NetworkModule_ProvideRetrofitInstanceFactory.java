// Generated by Dagger (https://dagger.dev).
package com.example.cnn_news_app.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class NetworkModule_ProvideRetrofitInstanceFactory implements Factory<Retrofit> {
  private final Provider<OkHttpClient> okHttpClientProvider;

  private final Provider<GsonConverterFactory> gsonConverterFactoryProvider;

  public NetworkModule_ProvideRetrofitInstanceFactory(Provider<OkHttpClient> okHttpClientProvider,
      Provider<GsonConverterFactory> gsonConverterFactoryProvider) {
    this.okHttpClientProvider = okHttpClientProvider;
    this.gsonConverterFactoryProvider = gsonConverterFactoryProvider;
  }

  @Override
  public Retrofit get() {
    return provideRetrofitInstance(okHttpClientProvider.get(), gsonConverterFactoryProvider.get());
  }

  public static NetworkModule_ProvideRetrofitInstanceFactory create(
      Provider<OkHttpClient> okHttpClientProvider,
      Provider<GsonConverterFactory> gsonConverterFactoryProvider) {
    return new NetworkModule_ProvideRetrofitInstanceFactory(okHttpClientProvider, gsonConverterFactoryProvider);
  }

  public static Retrofit provideRetrofitInstance(OkHttpClient okHttpClient,
      GsonConverterFactory gsonConverterFactory) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideRetrofitInstance(okHttpClient, gsonConverterFactory));
  }
}