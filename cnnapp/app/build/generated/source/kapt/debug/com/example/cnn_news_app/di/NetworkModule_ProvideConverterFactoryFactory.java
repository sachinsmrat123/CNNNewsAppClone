// Generated by Dagger (https://dagger.dev).
package com.example.cnn_news_app.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import retrofit2.converter.gson.GsonConverterFactory;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class NetworkModule_ProvideConverterFactoryFactory implements Factory<GsonConverterFactory> {
  @Override
  public GsonConverterFactory get() {
    return provideConverterFactory();
  }

  public static NetworkModule_ProvideConverterFactoryFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static GsonConverterFactory provideConverterFactory() {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideConverterFactory());
  }

  private static final class InstanceHolder {
    private static final NetworkModule_ProvideConverterFactoryFactory INSTANCE = new NetworkModule_ProvideConverterFactoryFactory();
  }
}
