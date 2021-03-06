package dz.islem.mvvm_dagger.di.module;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dz.islem.mvvm_dagger.data.DataManager;
import dz.islem.mvvm_dagger.data.network.RemoteApi;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Singleton
    @Provides
    Retrofit provideRetrofit(@Named("jsonplaceholder") String url,
                             GsonConverterFactory gsonConverterFactory,
                             RxJava2CallAdapterFactory rxJava2CallAdapterFactory){
        return new Retrofit.Builder().
                addConverterFactory(gsonConverterFactory).
                addCallAdapterFactory(rxJava2CallAdapterFactory).
                baseUrl(url).
                build();
    }

    @Provides
    @Named("jsonplaceholder")
    String provideUrl() {
        return "https://jsonplaceholder.typicode.com";
    }

    @Provides
    RxJava2CallAdapterFactory provideRxAdapterCall() {
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
    GsonConverterFactory provideGsonConverter(){
        return GsonConverterFactory.create();
    }

    @Provides
    RemoteApi provideApi(Retrofit retrofit){
        return retrofit.create(RemoteApi.class);
    }


    @Singleton
    @Provides
    DataManager provideDataManager(RemoteApi remoteApi){
        return new DataManager(remoteApi);
    }

}
