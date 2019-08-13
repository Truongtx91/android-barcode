package com.xtruong.scanner.ui.about;

import com.xtruong.scanner.data.IDataManager;
import com.xtruong.scanner.ui.base.BasePresenter;
import com.xtruong.scanner.ui.base.IView;
import com.xtruong.scanner.utils.rx.ISchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by truongtx on 8/12/2019
 */
public class AboutPresenter<V extends IAboutView> extends BasePresenter<V>
        implements IAboutPresenter<V> {

    @Inject
    public AboutPresenter(IDataManager dataManager,
                          ISchedulerProvider schedulerProvider,
                          CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
