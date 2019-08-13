package com.xtruong.scanner.ui.main.password;

import com.xtruong.scanner.data.IDataManager;
import com.xtruong.scanner.ui.base.BasePresenter;
import com.xtruong.scanner.utils.rx.ISchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by truongtx on 8/13/2019
 */
public class PasswordPresenter<V extends IPasswordView> extends BasePresenter<V>
    implements IPasswordPresenter<V>{

    public static final String TAG = "PasswordPresenter";

    @Inject
    public PasswordPresenter(IDataManager dataManager,
                                 ISchedulerProvider schedulerProvider,
                                 CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onOkClicked(String newPassword, String oldPassword) {

        // validate password;

        getMvpView().showLoading();
        getMvpView().hideLoading();
        getMvpView().showMessage("Changed Password");
        getMvpView().dismissDialog();
    }

    @Override
    public void onCancelClicked() {
        getMvpView().dismissDialog();
    }

}
