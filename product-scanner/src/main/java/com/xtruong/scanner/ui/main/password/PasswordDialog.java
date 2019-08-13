package com.xtruong.scanner.ui.main.password;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.xtruong.scanner.R;
import com.xtruong.scanner.di.component.ActivityComponent;
import com.xtruong.scanner.ui.base.BaseDialog;

import javax.inject.Inject;

import androidx.fragment.app.FragmentManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by truongtx on 8/13/2019
 */
public class PasswordDialog extends BaseDialog implements IPasswordView {

    private static final String TAG = "Password";

    @BindView(R.id.et_old_password)
    EditText moldPwdEditText;

    @BindView(R.id.et_new_password)
    EditText mnewPwdEditText;

    @Inject
    IPasswordPresenter<IPasswordView> mPresenter;

    public static PasswordDialog newInstance(){

        PasswordDialog fragment = new PasswordDialog();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_change_password, container, false);

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

    @OnClick(R.id.btn_Ok)
    void OkClicked(){
        mPresenter.onOkClicked(moldPwdEditText.getText().toString(),mnewPwdEditText.getText().toString());
    }

    @OnClick(R.id.btn_Cancel)
    void CancelClicked(){
        mPresenter.onCancelClicked();
    }

    @Override
    protected void setUp(View view) {

    }

    @Override
    public void hideSubmitButton() {
    }

    @Override
    public void dismissDialog() {
        super.dismissDialog(TAG);
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }
}
