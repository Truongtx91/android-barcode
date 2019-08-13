package com.xtruong.scanner.ui.payment;

import com.xtruong.scanner.data.IDataManager;
import com.xtruong.scanner.ui.base.BasePresenter;
import com.xtruong.scanner.utils.rx.ISchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by truongtx on 8/13/2019
 */
public class PaymentPresenter<V extends IPaymentView> extends BasePresenter<V>
        implements IPaymentPresenter<V>{

    private static final String TAG = "FeedPresenter";

    @Inject
    public PaymentPresenter(IDataManager dataManager,
                         ISchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

}
