package com.deb.mvvmcrud.data.manager;

import android.content.Context;

import com.deb.mvvmcrud.data.db.helper.NotificationDbHelper;
import com.deb.mvvmcrud.data.db.helper.UserDBHelper;
import com.deb.mvvmcrud.data.db.model.Notification;
import com.deb.mvvmcrud.data.db.model.User;
import com.google.gson.Gson;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
Created by Deb
*/
public class UserDataManagerImpl implements UserDataManager {
    private final Context mContext;

    private final UserDBHelper mDbHelper;

    private final Gson mGson;

    @Inject
    public UserDataManagerImpl(Context context, UserDBHelper dbHelper, Gson gson) {
        mContext = context;
        mDbHelper = dbHelper;
        mGson = gson;
    }

    @Override
    public Observable<Long> saveUser(User user) {
        return mDbHelper.saveUser(user);
    }

    /*@Override
    public Observable<Long> saveNotification(User user) {
        return mDbHelper.saveNotification(user);
    }*/
}
