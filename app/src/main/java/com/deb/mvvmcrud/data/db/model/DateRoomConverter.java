package com.deb.mvvmcrud.data.db.model;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/*
Created by Deb
*/
public class DateRoomConverter {
    @TypeConverter
    public static Date toDate(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long toLong(Date value) {
        return value == null ? null : value.getTime();
    }
}
