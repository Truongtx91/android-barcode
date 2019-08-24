package com.xtruong.scanner.ui.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.xtruong.scanner.R;
import com.xtruong.scanner.ui.base.BaseActivity;
import com.xtruong.scanner.ui.login.LoginActivity;
import com.xtruong.scanner.ui.main.MainActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by truongtx on 8/22/2019
 */
public class SplashActivity extends BaseActivity implements ISplashView {

    @Inject
    ISplashPresenter<ISplashView> mPresenter;

    public static Intent getStartIntent(Context context){
        Intent intent = new Intent(context, SplashActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(SplashActivity.this);
    }

    @Override
    protected void setUp() {

    }

    @Override
    public void openLoginActivity() {
        Intent intent = LoginActivity.getStartIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void openMainActivity() {
        Intent intent = MainActivity.getStartIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void startSyncService() {

    }

    @Override
    protected void onDestroy(){
        mPresenter.onDetach();
        super.onDestroy();
    }
}
