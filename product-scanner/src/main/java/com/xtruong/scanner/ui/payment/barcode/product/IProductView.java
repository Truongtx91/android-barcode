package com.xtruong.scanner.ui.payment.barcode.product;

import com.xtruong.scanner.ui.base.IDialogView;

/**
 * Created by truongtx on 8/25/2019
 */
public interface IProductView extends IDialogView {

    void disableBuyButton();

    void disableCancelButton();

    void dismissDialog();
}
