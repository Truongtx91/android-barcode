package com.xtruong.scanner.ui.payment;

import com.xtruong.scanner.di.PerActivity;
import com.xtruong.scanner.ui.base.IPresenter;
import com.xtruong.scanner.ui.base.IView;

/**
 * Created by truongtx on 8/13/2019
 */
@PerActivity
public interface IPaymentPresenter<V extends IView> extends IPresenter<V> {
}
