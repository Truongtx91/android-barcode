package com.xtruong.scanner.ui.payment.barcode.product;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xtruong.scanner.R;
import com.xtruong.scanner.di.component.ActivityComponent;
import com.xtruong.scanner.ui.base.BaseDialog;

import javax.inject.Inject;

import androidx.fragment.app.FragmentManager;
import butterknife.ButterKnife;

/**
 * Created by truongtx on 8/25/2019
 */
public class ProductDialog extends BaseDialog implements IProductView {

    private static final String TAG = "ProductDialog";

    @Inject
    IProductPresenter<IProductView> mPresenter;

    public static ProductDialog newInstance() {
        ProductDialog fragment = new ProductDialog();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_product_result, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {

            component.inject(this);

            setUnBinder(ButterKnife.bind(this, view));

            mPresenter.onAttach(this);
        }

        return view;
    }

    public void show(FragmentManager fragmentManager) {
        super.show(fragmentManager, TAG);
    }

    @Override
    public void disableBuyButton(){
        //TODO
    }


    @Override
    public void disableCancelButton(){
        //TODO
    }

    @Override
    public void dismissDialog(){
        super.dismissDialog(TAG);
    }

    @Override
    protected void setUp(View view) {

    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }
}
