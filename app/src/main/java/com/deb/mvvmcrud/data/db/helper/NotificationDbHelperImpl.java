package com.deb.mvvmcrud.data.db.helper;


import android.util.Log;

import com.deb.mvvmcrud.data.db.AppDatabase;
import com.deb.mvvmcrud.data.db.model.Notification;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
Created by Deb
*/
@Singleton
public class NotificationDbHelperImpl implements NotificationDbHelper {

    private static final String TAG = NotificationDbHelperImpl.class.getName();

    private final AppDatabase mAppDatabase;

    @Inject
    public NotificationDbHelperImpl(AppDatabase appDatabase) {
        this.mAppDatabase = appDatabase;
    }

    @Override
    public Observable<Long> saveNotification(final Notification notification) {
        Log.i("mAppDatabase","mAppDatabase :"+mAppDatabase);
        return Observable.fromCallable(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                Long id=mAppDatabase.notificationDao().addNotification1(notification);
                Log.i(TAG,"ID "+id);
                return id;

            }
        });
    }

    @Override
    public Observable<List<Notification>> getAllNotification() {

        return Observable.fromCallable(new Callable<List<Notification>>() {
            @Override
            public List<Notification> call() throws Exception {
                return mAppDatabase.notificationDao().loadAll();
            }
        });
    }
}
