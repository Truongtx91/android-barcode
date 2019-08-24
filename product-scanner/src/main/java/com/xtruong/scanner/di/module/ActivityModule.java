package com.xtruong.scanner.di.module;

import android.content.Context;

import com.xtruong.scanner.di.ActivityContext;
import com.xtruong.scanner.di.PerActivity;
import com.xtruong.scanner.ui.about.AboutPresenter;
import com.xtruong.scanner.ui.about.IAboutPresenter;
import com.xtruong.scanner.ui.about.IAboutView;
import com.xtruong.scanner.ui.login.ILoginPresenter;
import com.xtruong.scanner.ui.login.ILoginView;
import com.xtruong.scanner.ui.login.LoginPresenter;
import com.xtruong.scanner.ui.main.IMainPresenter;
import com.xtruong.scanner.ui.main.IMainView;
import com.xtruong.scanner.ui.main.MainPresenter;
import com.xtruong.scanner.ui.main.password.IPasswordPresenter;
import com.xtruong.scanner.ui.main.password.IPasswordView;
import com.xtruong.scanner.ui.main.password.PasswordPresenter;
import com.xtruong.scanner.ui.main.rating.IRatingDialogPresenter;
import com.xtruong.scanner.ui.main.rating.IRatingDialogView;
import com.xtruong.scanner.ui.main.rating.RatingDialogPresenter;
import com.xtruong.scanner.ui.payment.IPaymentPresenter;
import com.xtruong.scanner.ui.payment.IPaymentView;
import com.xtruong.scanner.ui.payment.PaymentPagerAdapter;
import com.xtruong.scanner.ui.payment.PaymentPresenter;
import com.xtruong.scanner.ui.payment.barcode.BarcodeAdapter;
import com.xtruong.scanner.ui.payment.barcode.BarcodePresenter;
import com.xtruong.scanner.ui.payment.barcode.IBarcodePresenter;
import com.xtruong.scanner.ui.payment.barcode.IBarcodeView;
import com.xtruong.scanner.ui.payment.report.IReportPresenter;
import com.xtruong.scanner.ui.payment.report.IReportView;
import com.xtruong.scanner.ui.payment.report.ReportAdapter;
import com.xtruong.scanner.ui.payment.report.ReportPresenter;
import com.xtruong.scanner.ui.register.IRegisterPresenter;
import com.xtruong.scanner.ui.register.IRegisterView;
import com.xtruong.scanner.ui.register.RegisterPresenter;
import com.xtruong.scanner.ui.splash.ISplashPresenter;
import com.xtruong.scanner.ui.splash.ISplashView;
import com.xtruong.scanner.ui.splash.SplashPresenter;
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
    @PerActivity
    IMainPresenter<IMainView> provideMainPresenter(
            MainPresenter<IMainView> presenter) {
        return presenter;
    }

    @Provides
    IRatingDialogPresenter<IRatingDialogView> provideRatingDialogPresenter(
            RatingDialogPresenter<IRatingDialogView> presenter) {
        return presenter;
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }

    @Provides
    IBarcodePresenter<IBarcodeView> provideBarcodePresenter(
        BarcodePresenter<IBarcodeView> presenter) {
        return presenter;
    }

    @Provides
    IReportPresenter<IReportView> provideReportPresenter(ReportPresenter<IReportView> presenter){
        return presenter;
    }

    @Provides
    IPaymentPresenter<IPaymentView> providePaymentPresenter(PaymentPresenter<IPaymentView> presenter){
        return presenter;
    }

    @Provides
    ReportAdapter provideReportAdapter(){
        return new ReportAdapter();
    }

    @Provides
    PaymentPagerAdapter providePaymentPagerAdapter(AppCompatActivity activity){
        return new PaymentPagerAdapter(activity.getSupportFragmentManager());
    }

    @Provides
    BarcodeAdapter provideBarcodeAdapter(){
        return new BarcodeAdapter();
    }


    @Provides
    IPasswordPresenter<IPasswordView> providePasswordPresenter(PasswordPresenter<IPasswordView> presenter){
        return presenter;
    }

    @Provides
    ISplashPresenter<ISplashView> provideSplashPresenter(SplashPresenter<ISplashView> presenter){
        return presenter;
    }



}
