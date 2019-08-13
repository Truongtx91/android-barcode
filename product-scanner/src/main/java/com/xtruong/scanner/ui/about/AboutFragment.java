package com.xtruong.scanner.ui.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xtruong.scanner.R;
import com.xtruong.scanner.di.component.ActivityComponent;
import com.xtruong.scanner.ui.base.BaseFragment;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by truongtx on 8/12/2019
 */
public class AboutFragment extends BaseFragment implements  IAboutView {

    public static final String TAG = "AboutFragment";

    @Inject
    IAboutPresenter<IAboutView> mPresenter;

    public static AboutFragment newInstance() {
        Bundle args = new Bundle();
        AboutFragment fragment = new AboutFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        ActivityComponent component = getActivityComponent();

        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
        }

        return view;
    }

    @Override
    protected void setUp(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @OnClick(R.id.nav_back_btn)
    void onNavBackClick() {
        getBaseActivity().onFragmentDetached(TAG);
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }
}
