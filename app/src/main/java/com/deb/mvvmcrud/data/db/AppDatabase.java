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

package com.deb.mvvmcrud.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.deb.mvvmcrud.data.db.dao.NotificationDao;
import com.deb.mvvmcrud.data.db.dao.UserDao;
import com.deb.mvvmcrud.data.db.model.DateRoomConverter;
import com.deb.mvvmcrud.data.db.model.Notification;
import com.deb.mvvmcrud.data.db.model.TestModel;
import com.deb.mvvmcrud.data.db.model.TimestampConverter;
import com.deb.mvvmcrud.data.db.model.User;
import com.deb.mvvmcrud.utils.AppConstants;


/**
 * Created by deb
 */

@Database(entities = {Notification.class,User.class,TestModel.class}, version = 2)
@TypeConverters({DateRoomConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    public static AppDatabase instance=null;

    public static AppDatabase getAppDatabse(Context context)
    {
        return Room.databaseBuilder(context, AppDatabase.class, AppConstants.DB_NAME).fallbackToDestructiveMigration()
                .build();
    }

    public abstract NotificationDao notificationDao();

    public abstract UserDao userDao();

}
