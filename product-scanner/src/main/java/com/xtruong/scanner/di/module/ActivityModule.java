package com.xtruong.scanner.di.module;

import android.content.Context;

import com.xtruong.scanner.di.ActivityContext;
import com.xtruong.scanner.di.PerActivity;
import com.xtruong.scanner.ui.about.AboutPresenter;
import com.xtruong.scanner.ui.about.IAboutPresenter;
import com.xtruong.scanner.ui.about.IAboutView;
import com.xtruong.scanner.ui.codereader.BarcodePresenter;
import com.xtruong.scanner.ui.codereader.IBarcodePresenter;
import com.xtruong.scanner.ui.codereader.IBarcodeView;
import com.xtruong.scanner.ui.login.ILoginPresenter;
import com.xtruong.scanner.ui.login.ILoginView;
import com.xtruong.scanner.ui.login.LoginPresenter;
import com.xtruong.scanner.ui.main.IMainPresenter;
import com.xtruong.scanner.ui.main.IMainView;
import com.xtruong.scanner.ui.main.MainPresenter;
import com.xtruong.scanner.ui.register.IRegisterPresenter;
import com.xtruong.scanner.ui.register.IRegisterView;
import com.xtruong.scanner.ui.register.RegisterPresenter;
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
    @PerActivity
    IRegisterPresenter<IRegisterView> provideRegisterPresenter(
            RegisterPresenter<IRegisterView> presenter){
        return presenter;
    }

    @Provides
    IAboutPresenter<IAboutView> provideAboutPresenter(
            AboutPresenter<IAboutView> presenter) {
        return presenter;
    }

    @Provides
    IBarcodePresenter<IBarcodeView> provideBarcodePresenter(
            BarcodePresenter<IBarcodeView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    IMainPresenter<IMainView> provideMainPresenter(
            MainPresenter<IMainView> presenter) {
        return presenter;
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }

}
