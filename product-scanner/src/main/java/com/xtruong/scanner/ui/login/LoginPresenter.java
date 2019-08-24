package com.xtruong.scanner.ui.login;

import com.androidnetworking.error.ANError;
import com.xtruong.scanner.R;
import com.xtruong.scanner.data.IDataManager;
import com.xtruong.scanner.data.network.model.LoginRequest;
import com.xtruong.scanner.data.network.model.LoginResponse;
import com.xtruong.scanner.ui.base.BasePresenter;
import com.xtruong.scanner.utils.CommonUtils;
import com.xtruong.scanner.utils.rx.ISchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

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
        // validate email and password
        if (email == null || email.isEmpty()) {
            getMvpView().onError(R.string.empty_email);
            return;
        }
        if (!CommonUtils.isEmailValid(email)) {
            getMvpView().onError(R.string.invalid_email);
            return;
        }
        if (password == null || password.isEmpty()) {
            getMvpView().onError(R.string.empty_password);
            return;
        }
        getMvpView().showLoading();

        getCompositeDisposable().add(getDataManager()
                .doServerLoginApiCall(new LoginRequest.ServerLoginRequest(email, password))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<LoginResponse>() {
                    @Override
                    public void accept(LoginResponse response) throws Exception {
                        getDataManager().updateUserInfo(
                                response.getAccessToken(),
                                response.getUserId(),
                                IDataManager.LoggedInMode.LOGGED_IN_MODE_SERVER);

                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();
                        getMvpView().openMainActivity();

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();

                        // handle the login error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));
    }


    @Override
    public void onRegisterClick(){
        getMvpView().hideLoading();
        getMvpView().openRegisterActivity();
    }

    @Override
    public void onForgotPassword(){
        getMvpView().hideLoading();
        getMvpView().openForgotPasswordDialog();
    }
}
