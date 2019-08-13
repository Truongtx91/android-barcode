package com.xtruong.scanner.ui.login;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.xtruong.scanner.R;
import com.xtruong.scanner.ui.base.BaseActivity;
import com.xtruong.scanner.ui.main.MainActivity;
import com.xtruong.scanner.ui.register.RegisterActivity;
import com.xtruong.scanner.utils.Functions;

import javax.inject.Inject;

import androidx.appcompat.app.AlertDialog;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by truongtx on 8/10/2019
 */
public class LoginActivity extends BaseActivity implements ILoginView {

    @Inject
    ILoginPresenter<ILoginView> mPresenter;

    @BindView(R.id.et_email)
    EditText mEmailEditText;

    @BindView(R.id.et_password)
    EditText mPasswordEditText;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(LoginActivity.this);

    }

    @OnClick(R.id.btnLogin)
    void onLoginServerClick(View v){
        mPresenter.onLoginClick(mEmailEditText.getText().toString(), mPasswordEditText.getText().toString());
    }

    @OnClick(R.id.btnRegister)
    void onRegister(View v){
        mPresenter.onRegisterClick();
    }

    @OnClick(R.id.btnForgotPassword)
    void onForgotPassword(View v){
        mPresenter.onForgotPassword();
    }

    @Override
    public void openMainActivity(){
        Intent intent = MainActivity.getStartIntent(LoginActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void openRegisterActivity(){
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public void openForgotPasswordDialog(){
        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.reset_password,null);

        dialogBuilder.setView(dialogView);
        dialogBuilder.setTitle("Forgot Password");
        dialogBuilder.setCancelable(false);

        final TextInputLayout mEditEmail = dialogView.findViewById(R.id.editEmail);

        dialogBuilder.setPositiveButton("Reset",  new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // empty
            }
        });

        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        final AlertDialog alertDialog = dialogBuilder.create();

        mEditEmail.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(mEditEmail.getEditText().getText().length() > 0){
                    alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(true);
                } else {
                    alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(final DialogInterface dialog) {
                final Button b = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                b.setEnabled(false);

                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String email = mEditEmail.getEditText().getText().toString();

                        if (!email.isEmpty()) {
                            if (Functions.isValidEmailAddress(email)) {
                                resetPassword(email);
                                dialog.dismiss();
                            } else {
                                Toast.makeText(getApplicationContext(), "Email is not valid!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Fill all values!", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });

        alertDialog.show();
    }

    private void resetPassword(final String email){
        //TODO
    }

    @Override
    protected void setUp(){}

}
