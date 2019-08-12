package com.xtruong.scanner.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

import androidx.annotation.StringRes;

/**
 * Created by truongtx on 8/11/2019
 */
public abstract class BaseSubView extends ViewGroup  implements ISubView{

    private IView mParentView;

    public BaseSubView(Context context) {
        super(context);
    }

    public BaseSubView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseSubView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(21)
    public BaseSubView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void attachParentMvpView(IView parentView) {
        mParentView = parentView;
    }

    @Override
    public void showLoading() {
        if (mParentView != null) {
            mParentView.showLoading();
        }
    }

    @Override
    public void hideLoading() {
        if (mParentView != null) {
            mParentView.hideLoading();
        }
    }

    @Override
    public void onError(@StringRes int resId) {
        if (mParentView != null) {
            mParentView.onError(resId);
        }
    }

    @Override
    public void onError(String message) {
        if (mParentView != null) {
            mParentView.onError(message);
        }
    }

    @Override
    public void showMessage(String message) {
        if (mParentView != null) {
            mParentView.showMessage(message);
        }
    }

    @Override
    public void showMessage(@StringRes int resId) {
        if (mParentView != null) {
            mParentView.showMessage(resId);
        }
    }

    @Override
    public void hideKeyboard() {
        if (mParentView != null) {
            mParentView.hideKeyboard();
        }
    }

    @Override
    public boolean isNetworkConnected() {
        if (mParentView != null) {
            return mParentView.isNetworkConnected();
        }
        return false;
    }

    @Override
    public void openActivityOnTokenExpire() {
        if (mParentView != null) {
            mParentView.openActivityOnTokenExpire();
        }
    }

    protected abstract void bindViewsAndSetOnClickListeners();

    protected abstract void setUp();

}
