package com.xtruong.scanner.ui.payment.barcode;

import com.xtruong.scanner.data.IDataManager;
import com.xtruong.scanner.ui.base.BasePresenter;
import com.xtruong.scanner.utils.rx.ISchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by truongtx on 8/13/2019
 */
public class BarcodePresenter<V extends IBarcodeView> extends BasePresenter<V>
    implements IBarcodePresenter<V>{

    @Inject
    public BarcodePresenter(IDataManager dataManager,
                         ISchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

}
