package com.xtruong.scanner.ui.payment.barcode.product;

import com.xtruong.scanner.ui.base.IPresenter;

/**
 * Created by truongtx on 8/25/2019
 */
public interface IProductPresenter<V extends IProductView> extends IPresenter<V> {

    void onBuyClicked();

    void onCancelClicked();
}
