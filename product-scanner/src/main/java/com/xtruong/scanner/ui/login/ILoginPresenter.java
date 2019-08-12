package com.xtruong.scanner.ui.login;

import com.xtruong.scanner.di.PerActivity;
import com.xtruong.scanner.ui.base.IPresenter;

/**
 * Created by truongtx on 8/11/2019
 */
@PerActivity
public interface ILoginPresenter<V extends  ILoginView> extends IPresenter<V> {

    void onLoginClick(String email, String password);

}
