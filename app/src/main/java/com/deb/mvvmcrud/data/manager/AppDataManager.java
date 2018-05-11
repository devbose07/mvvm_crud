package com.deb.mvvmcrud.data.manager;

import android.content.Context;

import com.deb.mvvmcrud.data.db.helper.NotificationDbHelper;
import com.deb.mvvmcrud.data.db.model.Notification;
import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
Created by Deb
*/

@Singleton
public class AppDataManager implements DataManager {

    private final Context mContext;

    private final NotificationDbHelper mDbHelper;

    private final Gson mGson;

    @Inject
    public AppDataManager(Context context, NotificationDbHelper dbHelper, Gson gson) {
        mContext = context;
        mDbHelper = dbHelper;
        mGson = gson;
    }

    @Override
    public Observable<Long> saveNotification(Notification notification) {
        return mDbHelper.saveNotification(notification);
    }

    @Override
    public Observable<List<Notification>> getAllNotification() {
        return mDbHelper.getAllNotification();
    }
}
