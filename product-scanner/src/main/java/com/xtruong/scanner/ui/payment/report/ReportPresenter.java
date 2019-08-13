package com.xtruong.scanner.ui.payment.report;

import com.xtruong.scanner.data.IDataManager;
import com.xtruong.scanner.ui.base.BasePresenter;
import com.xtruong.scanner.utils.rx.ISchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by truongtx on 8/13/2019
 */
public class ReportPresenter<V extends IReportView> extends BasePresenter<V>
    implements  IReportPresenter<V>{


    @Inject
    public ReportPresenter(IDataManager dataManager,
                               ISchedulerProvider schedulerProvider,
                               CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }


    @Override
    public void onViewPrepared() {
        //TODO
    }
}
