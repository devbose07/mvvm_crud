package com.deb.mvvmcrud.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;

import com.deb.mvvmcrud.data.db.model.User;

/**
Created by Deb
*/
@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insert(User user);
}
