package com.xtruong.scanner.ui.payment.report;

import com.xtruong.scanner.ui.base.IPresenter;

/**
 * Created by truongtx on 8/13/2019
 */
public interface IReportPresenter<V extends IReportView> extends IPresenter<V> {

    void onViewPrepared();
}
