// Generated by Dagger (https://dagger.dev).
package com.example.cnn_news_app;

import android.app.Application;
import com.example.cnn_news_app.repository.NewsRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class MainViewModel_Factory implements Factory<MainViewModel> {
  private final Provider<NewsRepository> repositoryProvider;

  private final Provider<Application> applicationProvider;

  public MainViewModel_Factory(Provider<NewsRepository> repositoryProvider,
      Provider<Application> applicationProvider) {
    this.repositoryProvider = repositoryProvider;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public MainViewModel get() {
    return newInstance(repositoryProvider.get(), applicationProvider.get());
  }

  public static MainViewModel_Factory create(Provider<NewsRepository> repositoryProvider,
      Provider<Application> applicationProvider) {
    return new MainViewModel_Factory(repositoryProvider, applicationProvider);
  }

  public static MainViewModel newInstance(NewsRepository repository, Application application) {
    return new MainViewModel(repository, application);
  }
}
