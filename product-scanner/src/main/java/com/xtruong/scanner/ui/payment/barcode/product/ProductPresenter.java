package com.xtruong.scanner.ui.payment.barcode.product;

import com.xtruong.scanner.data.IDataManager;
import com.xtruong.scanner.ui.base.BasePresenter;
import com.xtruong.scanner.utils.rx.ISchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by truongtx on 8/25/2019
 */
public class ProductPresenter<V extends IProductView> extends BasePresenter<V>
    implements IProductPresenter<V>{

    public static final String TAG = "ProductDialogPresenter";

    @Inject
    public ProductPresenter(IDataManager dataManager,
                            ISchedulerProvider schedulerProvider,
                            CompositeDisposable compositeDisposable){
        super(dataManager, schedulerProvider, compositeDisposable);
    }


    @Override
    public void onBuyClicked() {
        //TODO
    }

    @Override
    public void onCancelClicked() {
        getMvpView().dismissDialog();
    }
}
