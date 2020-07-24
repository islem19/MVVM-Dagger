package dz.islem.mvvm_dagger.di.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dz.islem.mvvm_dagger.App;

@Module
public class AppModule {

    @Singleton
    @Provides
    Context provideContext(App app){
        return app;
    }

}
