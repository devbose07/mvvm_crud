package com.deb.mvvmcrud.data.db.helper;

import com.deb.mvvmcrud.data.db.model.Notification;

import java.util.List;

import io.reactivex.Observable;

/**
Created by Deb
*/
public interface NotificationDbHelper extends BaseDBHelper {
    Observable<Long> saveNotification(Notification notification);
    Observable<List<Notification>> getAllNotification();
}
