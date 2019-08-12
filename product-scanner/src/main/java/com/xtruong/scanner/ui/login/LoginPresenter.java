package com.xtruong.scanner.ui.login;

import com.xtruong.scanner.data.IDataManager;
import com.xtruong.scanner.ui.base.BasePresenter;
import com.xtruong.scanner.utils.rx.ISchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by truongtx on 8/11/2019
 */
public class LoginPresenter<V extends ILoginView> extends BasePresenter<V>
    implements  ILoginPresenter<V>{

    private static final String TAG = "LoginPresenter";

    @Inject
    public LoginPresenter(IDataManager dataManager,
                          ISchedulerProvider schedulerProvider,
                          CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onLoginClick(String email, String password){
        //TODO
    }


}
