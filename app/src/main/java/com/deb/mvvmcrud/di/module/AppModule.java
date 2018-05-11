/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.deb.mvvmcrud.di.module;

import android.app.Application;
import android.app.NotificationManager;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.util.Log;

import com.deb.mvvmcrud.data.db.AppDatabase;
import com.deb.mvvmcrud.data.db.helper.NotificationDbHelper;
import com.deb.mvvmcrud.data.db.helper.NotificationDbHelperImpl;
import com.deb.mvvmcrud.data.manager.AppDataManager;
import com.deb.mvvmcrud.data.manager.DataManager;
import com.deb.mvvmcrud.di.DatabaseInfo;
import com.deb.mvvmcrud.di.PreferenceInfo;
import com.deb.mvvmcrud.utils.AppConstants;
import com.deb.mvvmcrud.utils.rx.AppSchedulerProvider;
import com.deb.mvvmcrud.utils.rx.SchedulerProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * deb
 */
@Module
public class AppModule {



    @Provides
    @Singleton
    public AppDatabase provideAppDatabase(@DatabaseInfo String dbName, Context context) {
        Log.i("AppModule","Db created");
        return Room.databaseBuilder(context, AppDatabase.class, dbName).fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }


    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @Singleton
    DataManager provideNotificationManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    NotificationDbHelper provideDbHelper(NotificationDbHelperImpl appDbHelper) {
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
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }
}
