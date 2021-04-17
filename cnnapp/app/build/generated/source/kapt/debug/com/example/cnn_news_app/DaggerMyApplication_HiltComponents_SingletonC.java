// Generated by Dagger (https://dagger.dev).
package com.example.cnn_news_app;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.example.cnn_news_app.data.database.ArticleDao;
import com.example.cnn_news_app.data.database.NewsDatabase;
import com.example.cnn_news_app.data.network.NewsApi;
import com.example.cnn_news_app.di.DatabaseModule;
import com.example.cnn_news_app.di.DatabaseModule_ProvideDaoFactory;
import com.example.cnn_news_app.di.DatabaseModule_ProvideDatabaseFactory;
import com.example.cnn_news_app.di.NetworkModule;
import com.example.cnn_news_app.di.NetworkModule_ProvideApiServiceFactory;
import com.example.cnn_news_app.di.NetworkModule_ProvideConverterFactoryFactory;
import com.example.cnn_news_app.di.NetworkModule_ProvideHttpClientFactory;
import com.example.cnn_news_app.di.NetworkModule_ProvideRetrofitInstanceFactory;
import com.example.cnn_news_app.repository.NewsRepository;
import com.example.cnn_news_app.view.fragments.HomeFragment;
import com.example.cnn_news_app.view.fragments.ProfileFragment;
import com.example.cnn_news_app.view.fragments.SavedFragment;
import com.example.cnn_news_app.view.fragments.SearchFragment;
import com.example.cnn_news_app.view.fragments.category.SportsFragment;
import com.example.cnn_news_app.view.fragments.category.TopNewsFragment;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_Lifecycle_Factory;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideApplicationFactory;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.MapBuilder;
import dagger.internal.MemoizedSentinel;
import dagger.internal.Preconditions;
import dagger.internal.SetBuilder;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerMyApplication_HiltComponents_SingletonC extends MyApplication_HiltComponents.SingletonC {
  private final ApplicationContextModule applicationContextModule;

  private volatile Object okHttpClient = new MemoizedSentinel();

  private volatile Object gsonConverterFactory = new MemoizedSentinel();

  private volatile Object retrofit = new MemoizedSentinel();

  private volatile Object newsApi = new MemoizedSentinel();

  private volatile Object newsDatabase = new MemoizedSentinel();

  private volatile Object articleDao = new MemoizedSentinel();

  private DaggerMyApplication_HiltComponents_SingletonC(
      ApplicationContextModule applicationContextModuleParam) {
    this.applicationContextModule = applicationContextModuleParam;
  }

  public static Builder builder() {
    return new Builder();
  }

  private OkHttpClient okHttpClient() {
    Object local = okHttpClient;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = okHttpClient;
        if (local instanceof MemoizedSentinel) {
          local = NetworkModule_ProvideHttpClientFactory.provideHttpClient();
          okHttpClient = DoubleCheck.reentrantCheck(okHttpClient, local);
        }
      }
    }
    return (OkHttpClient) local;
  }

  private GsonConverterFactory gsonConverterFactory() {
    Object local = gsonConverterFactory;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = gsonConverterFactory;
        if (local instanceof MemoizedSentinel) {
          local = NetworkModule_ProvideConverterFactoryFactory.provideConverterFactory();
          gsonConverterFactory = DoubleCheck.reentrantCheck(gsonConverterFactory, local);
        }
      }
    }
    return (GsonConverterFactory) local;
  }

  private Retrofit retrofit() {
    Object local = retrofit;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = retrofit;
        if (local instanceof MemoizedSentinel) {
          local = NetworkModule_ProvideRetrofitInstanceFactory.provideRetrofitInstance(okHttpClient(), gsonConverterFactory());
          retrofit = DoubleCheck.reentrantCheck(retrofit, local);
        }
      }
    }
    return (Retrofit) local;
  }

  private NewsApi newsApi() {
    Object local = newsApi;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = newsApi;
        if (local instanceof MemoizedSentinel) {
          local = NetworkModule_ProvideApiServiceFactory.provideApiService(retrofit());
          newsApi = DoubleCheck.reentrantCheck(newsApi, local);
        }
      }
    }
    return (NewsApi) local;
  }

  private NewsDatabase newsDatabase() {
    Object local = newsDatabase;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = newsDatabase;
        if (local instanceof MemoizedSentinel) {
          local = DatabaseModule_ProvideDatabaseFactory.provideDatabase(ApplicationContextModule_ProvideContextFactory.provideContext(applicationContextModule));
          newsDatabase = DoubleCheck.reentrantCheck(newsDatabase, local);
        }
      }
    }
    return (NewsDatabase) local;
  }

  private ArticleDao articleDao() {
    Object local = articleDao;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = articleDao;
        if (local instanceof MemoizedSentinel) {
          local = DatabaseModule_ProvideDaoFactory.provideDao(newsDatabase());
          articleDao = DoubleCheck.reentrantCheck(articleDao, local);
        }
      }
    }
    return (ArticleDao) local;
  }

  @Override
  public void injectMyApplication(MyApplication myApplication) {
  }

  @Override
  public ActivityRetainedComponentBuilder retainedComponentBuilder() {
    return new ActivityRetainedCBuilder();
  }

  @Override
  public ServiceComponentBuilder serviceComponentBuilder() {
    return new ServiceCBuilder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder databaseModule(DatabaseModule databaseModule) {
      Preconditions.checkNotNull(databaseModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder networkModule(NetworkModule networkModule) {
      Preconditions.checkNotNull(networkModule);
      return this;
    }

    public MyApplication_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new DaggerMyApplication_HiltComponents_SingletonC(applicationContextModule);
    }
  }

  private final class ActivityRetainedCBuilder implements MyApplication_HiltComponents.ActivityRetainedC.Builder {
    @Override
    public MyApplication_HiltComponents.ActivityRetainedC build() {
      return new ActivityRetainedCImpl();
    }
  }

  private final class ActivityRetainedCImpl extends MyApplication_HiltComponents.ActivityRetainedC {
    private volatile Object lifecycle = new MemoizedSentinel();

    private volatile Object newsRepository = new MemoizedSentinel();

    private ActivityRetainedCImpl() {

    }

    private Object lifecycle() {
      Object local = lifecycle;
      if (local instanceof MemoizedSentinel) {
        synchronized (local) {
          local = lifecycle;
          if (local instanceof MemoizedSentinel) {
            local = ActivityRetainedComponentManager_Lifecycle_Factory.newInstance();
            lifecycle = DoubleCheck.reentrantCheck(lifecycle, local);
          }
        }
      }
      return (Object) local;
    }

    private NewsRepository newsRepository() {
      Object local = newsRepository;
      if (local instanceof MemoizedSentinel) {
        synchronized (local) {
          local = newsRepository;
          if (local instanceof MemoizedSentinel) {
            local = new NewsRepository(DaggerMyApplication_HiltComponents_SingletonC.this.newsApi(), DaggerMyApplication_HiltComponents_SingletonC.this.articleDao());
            newsRepository = DoubleCheck.reentrantCheck(newsRepository, local);
          }
        }
      }
      return (NewsRepository) local;
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder();
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return (ActivityRetainedLifecycle) lifecycle();
    }

    private final class ActivityCBuilder implements MyApplication_HiltComponents.ActivityC.Builder {
      private Activity activity;

      @Override
      public ActivityCBuilder activity(Activity activity) {
        this.activity = Preconditions.checkNotNull(activity);
        return this;
      }

      @Override
      public MyApplication_HiltComponents.ActivityC build() {
        Preconditions.checkBuilderRequirement(activity, Activity.class);
        return new ActivityCImpl(activity);
      }
    }

    private final class ActivityCImpl extends MyApplication_HiltComponents.ActivityC {
      private ActivityCImpl(Activity activity) {

      }

      @Override
      public void injectMainActivity(MainActivity mainActivity) {
      }

      @Override
      public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
        return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(ApplicationContextModule_ProvideApplicationFactory.provideApplication(DaggerMyApplication_HiltComponents_SingletonC.this.applicationContextModule), getViewModelKeys(), new ViewModelCBuilder(), Collections.<ViewModelProvider.Factory>emptySet(), Collections.<ViewModelProvider.Factory>emptySet());
      }

      @Override
      public Set<String> getViewModelKeys() {
        return SetBuilder.<String>newSetBuilder(2).add(MainViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(com.example.cnn_news_app.viewmodel.MainViewModel_HiltModules_KeyModule_ProvideFactory.provide()).build();
      }

      @Override
      public ViewModelComponentBuilder getViewModelComponentBuilder() {
        return new ViewModelCBuilder();
      }

      @Override
      public FragmentComponentBuilder fragmentComponentBuilder() {
        return new FragmentCBuilder();
      }

      @Override
      public ViewComponentBuilder viewComponentBuilder() {
        return new ViewCBuilder();
      }

      private final class FragmentCBuilder implements MyApplication_HiltComponents.FragmentC.Builder {
        private Fragment fragment;

        @Override
        public FragmentCBuilder fragment(Fragment fragment) {
          this.fragment = Preconditions.checkNotNull(fragment);
          return this;
        }

        @Override
        public MyApplication_HiltComponents.FragmentC build() {
          Preconditions.checkBuilderRequirement(fragment, Fragment.class);
          return new FragmentCImpl(fragment);
        }
      }

      private final class FragmentCImpl extends MyApplication_HiltComponents.FragmentC {
        private FragmentCImpl(Fragment fragment) {

        }

        @Override
        public void injectHomeFragment(HomeFragment homeFragment) {
        }

        @Override
        public void injectProfileFragment(ProfileFragment profileFragment) {
        }

        @Override
        public void injectSavedFragment(SavedFragment savedFragment) {
        }

        @Override
        public void injectSearchFragment(SearchFragment searchFragment) {
        }

        @Override
        public void injectSportsFragment(SportsFragment sportsFragment) {
        }

        @Override
        public void injectTopNewsFragment(TopNewsFragment topNewsFragment) {
        }

        @Override
        public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
          return ActivityCImpl.this.getHiltInternalFactoryFactory();
        }

        @Override
        public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
          return new ViewWithFragmentCBuilder();
        }

        private final class ViewWithFragmentCBuilder implements MyApplication_HiltComponents.ViewWithFragmentC.Builder {
          private View view;

          @Override
          public ViewWithFragmentCBuilder view(View view) {
            this.view = Preconditions.checkNotNull(view);
            return this;
          }

          @Override
          public MyApplication_HiltComponents.ViewWithFragmentC build() {
            Preconditions.checkBuilderRequirement(view, View.class);
            return new ViewWithFragmentCImpl(view);
          }
        }

        private final class ViewWithFragmentCImpl extends MyApplication_HiltComponents.ViewWithFragmentC {
          private ViewWithFragmentCImpl(View view) {

          }
        }
      }

      private final class ViewCBuilder implements MyApplication_HiltComponents.ViewC.Builder {
        private View view;

        @Override
        public ViewCBuilder view(View view) {
          this.view = Preconditions.checkNotNull(view);
          return this;
        }

        @Override
        public MyApplication_HiltComponents.ViewC build() {
          Preconditions.checkBuilderRequirement(view, View.class);
          return new ViewCImpl(view);
        }
      }

      private final class ViewCImpl extends MyApplication_HiltComponents.ViewC {
        private ViewCImpl(View view) {

        }
      }
    }

    private final class ViewModelCBuilder implements MyApplication_HiltComponents.ViewModelC.Builder {
      private SavedStateHandle savedStateHandle;

      @Override
      public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
        this.savedStateHandle = Preconditions.checkNotNull(handle);
        return this;
      }

      @Override
      public MyApplication_HiltComponents.ViewModelC build() {
        Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
        return new ViewModelCImpl(savedStateHandle);
      }
    }

    private final class ViewModelCImpl extends MyApplication_HiltComponents.ViewModelC {
      private volatile Provider<MainViewModel> mainViewModelProvider;

      private volatile Provider<com.example.cnn_news_app.viewmodel.MainViewModel> mainViewModelProvider2;

      private ViewModelCImpl(SavedStateHandle savedStateHandle) {

      }

      private MainViewModel mainViewModel() {
        return new MainViewModel(ActivityRetainedCImpl.this.newsRepository(), ApplicationContextModule_ProvideApplicationFactory.provideApplication(DaggerMyApplication_HiltComponents_SingletonC.this.applicationContextModule));
      }

      private Provider<MainViewModel> mainViewModelProvider() {
        Object local = mainViewModelProvider;
        if (local == null) {
          local = new SwitchingProvider<>(0);
          mainViewModelProvider = (Provider<MainViewModel>) local;
        }
        return (Provider<MainViewModel>) local;
      }

      private com.example.cnn_news_app.viewmodel.MainViewModel mainViewModel2() {
        return new com.example.cnn_news_app.viewmodel.MainViewModel(ActivityRetainedCImpl.this.newsRepository(), ApplicationContextModule_ProvideApplicationFactory.provideApplication(DaggerMyApplication_HiltComponents_SingletonC.this.applicationContextModule));
      }

      private Provider<com.example.cnn_news_app.viewmodel.MainViewModel> mainViewModelProvider2() {
        Object local = mainViewModelProvider2;
        if (local == null) {
          local = new SwitchingProvider<>(1);
          mainViewModelProvider2 = (Provider<com.example.cnn_news_app.viewmodel.MainViewModel>) local;
        }
        return (Provider<com.example.cnn_news_app.viewmodel.MainViewModel>) local;
      }

      @Override
      public Map<String, Provider<ViewModel>> getHiltViewModelMap() {
        return MapBuilder.<String, Provider<ViewModel>>newMapBuilder(2).put("com.example.cnn_news_app.MainViewModel", (Provider) mainViewModelProvider()).put("com.example.cnn_news_app.viewmodel.MainViewModel", (Provider) mainViewModelProvider2()).build();
      }

      private final class SwitchingProvider<T> implements Provider<T> {
        private final int id;

        SwitchingProvider(int id) {
          this.id = id;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T get() {
          switch (id) {
            case 0: // com.example.cnn_news_app.MainViewModel 
            return (T) ViewModelCImpl.this.mainViewModel();

            case 1: // com.example.cnn_news_app.viewmodel.MainViewModel 
            return (T) ViewModelCImpl.this.mainViewModel2();

            default: throw new AssertionError(id);
          }
        }
      }
    }
  }

  private final class ServiceCBuilder implements MyApplication_HiltComponents.ServiceC.Builder {
    private Service service;

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(service);
    }
  }

  private final class ServiceCImpl extends MyApplication_HiltComponents.ServiceC {
    private ServiceCImpl(Service service) {

    }
  }
}
