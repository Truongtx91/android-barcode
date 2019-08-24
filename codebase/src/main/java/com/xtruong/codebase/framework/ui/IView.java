package com.xtruong.codebase.framework.ui;

import androidx.annotation.StringRes;

/**
 * Created by truongtx on 8/22/2019
 */
public interface IView {
    void showLoading();

    void hideLoading();

    void openActivityOnTokenExpire();

    void onError(@StringRes int resId);

    void onError(String message);

    void showMessage(String message);

    void showMessage(@StringRes int resId);

    boolean isNetworkConnected();

    void hideKeyboard();
}
