package dz.islem.mvvm_dagger.di.component;


import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dz.islem.mvvm_dagger.App;
import dz.islem.mvvm_dagger.di.module.ActivityContributer;
import dz.islem.mvvm_dagger.di.module.AppModule;
import dz.islem.mvvm_dagger.di.module.NetworkModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ActivityContributer.class,
        NetworkModule.class
})
public interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {

    }

}
