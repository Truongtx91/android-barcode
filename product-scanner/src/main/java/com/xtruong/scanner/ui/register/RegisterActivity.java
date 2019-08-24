package com.xtruong.scanner.ui.register;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.xtruong.scanner.R;
import com.xtruong.scanner.ui.base.BaseActivity;
import com.xtruong.scanner.ui.login.LoginActivity;
import com.xtruong.scanner.utils.AppConfig;
import com.xtruong.scanner.utils.Functions;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by truongtx on 8/10/2019
 */
public class RegisterActivity extends BaseActivity implements  IRegisterView {

    @Inject
    IRegisterPresenter<IRegisterView> mPresenter;


    @BindView(R.id.et_name)
    EditText mFullNameEditText;

    @BindView(R.id.et_email)
    EditText mEmailEditText;

    @BindView(R.id.et_password)
    EditText mPasswordEditText;

    public static Intent getStartIntent(Context context){
        Intent intent = new Intent(context, RegisterActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind((this)));

        mPresenter.onAttach(RegisterActivity.this);
    }

    @OnClick(R.id.btnRegister)
    void onRegisterClick(View v){
        mPresenter.onOKClick(mFullNameEditText.getText().toString(),
                mEmailEditText.getText().toString(),
                mPasswordEditText.getText().toString());
    }


    @Override
    public void openLoginActivity() {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected  void setUp(){}
}