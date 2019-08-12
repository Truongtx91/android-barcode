package com.xtruong.scanner.di.module;

import android.app.Application;
import android.content.Context;

import com.xtruong.scanner.BuildConfig;
import com.xtruong.scanner.R;
import com.xtruong.scanner.data.AppDataManager;
import com.xtruong.scanner.data.IDataManager;
import com.xtruong.scanner.data.db.AppDbHelper;
import com.xtruong.scanner.data.db.IDbHelper;
import com.xtruong.scanner.data.network.ApiHeader;
import com.xtruong.scanner.data.network.AppApiHelper;
import com.xtruong.scanner.data.network.IApiHelper;
import com.xtruong.scanner.data.prefs.AppPreferencesHelper;
import com.xtruong.scanner.data.prefs.IPreferencesHelper;
import com.xtruong.scanner.di.ApiInfo;
import com.xtruong.scanner.di.ApplicationContext;
import com.xtruong.scanner.di.DatabaseInfo;
import com.xtruong.scanner.di.PreferenceInfo;
import com.xtruong.scanner.utils.AppConfig;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by truongtx on 8/11/2019
 */
@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConfig.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConfig.PREF_NAME;
    }


    @Provides
    @Singleton
    IDbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    IPreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    IApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    IDataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           IPreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                preferencesHelper.getCurrentUserId(),
                preferencesHelper.getAccessToken());
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }
}
