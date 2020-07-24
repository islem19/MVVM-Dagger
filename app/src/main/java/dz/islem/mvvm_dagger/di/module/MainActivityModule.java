package dz.islem.mvvm_dagger.di.module;

import androidx.lifecycle.ViewModelProvider;

import dagger.Module;
import dagger.Provides;
import dz.islem.mvvm_dagger.data.DataManager;
import dz.islem.mvvm_dagger.ui.main.MainViewModel;
import dz.islem.mvvm_dagger.ui.main.MainViewModelFactory;

@Module
public class MainActivityModule {

    @Provides
    MainViewModel providesViewModel(DataManager dataManager){
        return new MainViewModel(dataManager);
    }

    @Provides
    ViewModelProvider.Factory provideViewModelProvider(MainViewModel mainViewModel){
        return new MainViewModelFactory(mainViewModel);
    }
}
