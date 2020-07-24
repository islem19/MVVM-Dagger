package dz.islem.mvvm_dagger;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dz.islem.mvvm_dagger.di.component.DaggerAppComponent;

public class App extends DaggerApplication {
    private static App mInstance;

    @Override
    public void onCreate(){
        super.onCreate();
        mInstance = this;
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }

    public static App getInstance(){
        return mInstance;
    }

}
