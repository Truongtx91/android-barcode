package com.xtruong.scanner.di.module;

import android.content.Context;

import com.xtruong.scanner.di.ActivityContext;
import com.xtruong.scanner.di.PerActivity;
import com.xtruong.scanner.ui.login.ILoginPresenter;
import com.xtruong.scanner.ui.login.ILoginView;
import com.xtruong.scanner.ui.login.LoginPresenter;
import com.xtruong.scanner.utils.rx.AppSchedulerProvider;
import com.xtruong.scanner.utils.rx.ISchedulerProvider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by truongtx on 8/11/2019
 */
@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity){
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    ISchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    ILoginPresenter<ILoginView> provideLoginPresenter(
            LoginPresenter<ILoginView> presenter) {
        return presenter;
    }


    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }

}
