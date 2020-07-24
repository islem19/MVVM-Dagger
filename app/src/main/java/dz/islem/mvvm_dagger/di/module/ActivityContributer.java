package dz.islem.mvvm_dagger.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dz.islem.mvvm_dagger.ui.detail.DetailActivity;
import dz.islem.mvvm_dagger.ui.main.MainActivity;

@Module
public abstract class ActivityContributer {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector(modules = DetailActivityModule.class)
    abstract DetailActivity contributeDetailActivity();
}
