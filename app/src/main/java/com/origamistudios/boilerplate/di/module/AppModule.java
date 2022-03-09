package com.origamistudios.boilerplate.di.module;

import android.app.Application;

import androidx.room.Room;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.origamistudios.boilerplate.BuildConfig;
import com.origamistudios.boilerplate.R;
import com.origamistudios.boilerplate.data.AppDataManager;
import com.origamistudios.boilerplate.data.DataManager;
import com.origamistudios.boilerplate.data.local.db.AppDatabase;
import com.origamistudios.boilerplate.data.local.db.AppDbHelper;
import com.origamistudios.boilerplate.data.local.db.DbHelper;
import com.origamistudios.boilerplate.data.local.prefs.AppPreferencesHelper;
import com.origamistudios.boilerplate.data.local.prefs.PreferencesHelper;
import com.origamistudios.boilerplate.data.remote.ApiHeader;
import com.origamistudios.boilerplate.data.remote.ApiHelper;
import com.origamistudios.boilerplate.data.remote.AppApiHelper;
import com.origamistudios.boilerplate.di.ApiInfo;
import com.origamistudios.boilerplate.di.DatabaseInfo;
import com.origamistudios.boilerplate.di.PreferenceInfo;
import com.origamistudios.boilerplate.utils.AppConstants;
import com.origamistudios.boilerplate.utils.rx.AppSchedulerProvider;
import com.origamistudios.boilerplate.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

@Module
public class AppModule {

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(@DatabaseInfo String dbName, Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, dbName).fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                preferencesHelper.getCurrentUserId(),
                preferencesHelper.getAccessToken());
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

}
