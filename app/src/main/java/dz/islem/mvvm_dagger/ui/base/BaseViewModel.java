package dz.islem.mvvm_dagger.ui.base;

import androidx.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModel extends ViewModel {
    protected CompositeDisposable compositeDisposable;

    public BaseViewModel(){
        compositeDisposable = new CompositeDisposable();
    }

    public void cleanupVM(){
        if (compositeDisposable != null )
            compositeDisposable.dispose();
    }
}
