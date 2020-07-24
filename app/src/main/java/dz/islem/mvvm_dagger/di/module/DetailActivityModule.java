package dz.islem.mvvm_dagger.di.module;

import androidx.lifecycle.ViewModelProvider;

import dagger.Module;
import dagger.Provides;
import dz.islem.mvvm_dagger.data.DataManager;
import dz.islem.mvvm_dagger.ui.detail.DetailViewModel;
import dz.islem.mvvm_dagger.ui.detail.DetailViewModelFactory;

@Module
public class DetailActivityModule {

    @Provides
    DetailViewModel providesViewModel(DataManager dataManager){
        return new DetailViewModel(dataManager);
    }

    @Provides
    ViewModelProvider.Factory provideViewModelProvider(DetailViewModel detailViewModel){
        return new DetailViewModelFactory(detailViewModel);
    }
}
