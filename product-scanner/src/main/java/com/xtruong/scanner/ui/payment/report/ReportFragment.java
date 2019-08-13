package com.xtruong.scanner.ui.payment.report;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xtruong.scanner.R;
import com.xtruong.scanner.di.component.ActivityComponent;
import com.xtruong.scanner.ui.base.BaseFragment;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import butterknife.ButterKnife;

/**
 * Created by truongtx on 8/13/2019
 */
public class ReportFragment extends BaseFragment implements
    IReportView, ReportAdapter.Callback{


    private static final String TAG = "ReportFragment";

    @Inject
    IReportPresenter<IReportView> mPresenter;

    @Inject
    ReportAdapter mReportAdapter;

    @Inject
    LinearLayoutManager mLayoutManager;

    public static ReportFragment newInstance() {
        Bundle args = new Bundle();
        ReportFragment fragment = new ReportFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_report, container, false);

        ActivityComponent component = getActivityComponent();

        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);

            mReportAdapter.setCallback(this);
        }
        return view;
    }

    @Override
    protected void setUp(View view) {
        //TODO
    }

    @Override
    public void onRepoEmptyViewRetryClick() {
        //TODO
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }
}
