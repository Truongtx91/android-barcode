package com.xtruong.scanner.ui.register;

import com.xtruong.scanner.data.IDataManager;
import com.xtruong.scanner.ui.base.BasePresenter;
import com.xtruong.scanner.utils.rx.ISchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by truongtx on 8/12/2019
 */
public class RegisterPresenter<V extends IRegisterView> extends BasePresenter<V>
    implements IRegisterPresenter<V>{


    @Inject
    public RegisterPresenter(IDataManager dataManager,
                          ISchedulerProvider schedulerProvider,
                          CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onOKClick(String fullname, String email, String password) {

        //TODO
        // validate parameter;
        // send to server backend
        // come back login

        getMvpView().hideLoading();
        getMvpView().openLoginActivity();
    }

    @Override
    public void onCancelClick() {

        // comeback login window
        getMvpView().hideLoading();
        getMvpView().openLoginActivity();
    }
}
