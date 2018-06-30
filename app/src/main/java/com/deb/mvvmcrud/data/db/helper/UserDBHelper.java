package com.deb.mvvmcrud.data.db.helper;


import com.deb.mvvmcrud.data.db.model.Notification;
import com.deb.mvvmcrud.data.db.model.User;

import io.reactivex.Observable;

/**
Created by Deb
*/
public interface UserDBHelper extends BaseDBHelper {
    Observable<Long> saveUser(User user);
}
