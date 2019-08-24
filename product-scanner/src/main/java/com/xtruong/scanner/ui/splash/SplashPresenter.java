package com.xtruong.scanner.ui.splash;

import com.xtruong.scanner.R;
import com.xtruong.scanner.data.IDataManager;
import com.xtruong.scanner.ui.base.BasePresenter;
import com.xtruong.scanner.utils.rx.ISchedulerProvider;

import javax.inject.Inject;

import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by truongtx on 8/22/2019
 */
public class SplashPresenter<V extends ISplashView> extends BasePresenter<V>
    implements ISplashPresenter<V>{

    @Inject
    public SplashPresenter(IDataManager dataManager,
                           ISchedulerProvider schedulerProvider,
                           CompositeDisposable compositeDisposable)
    {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);

        getMvpView().startSyncService();

        decideNextActivity();
    }

    private void decideNextActivity() {
        if (getDataManager().getCurrentUserLoggedInMode()
                == IDataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType()) {
            getMvpView().openLoginActivity();
        } else {
            getMvpView().openMainActivity();
        }
    }

}
