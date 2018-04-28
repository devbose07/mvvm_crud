package com.deb.mvvmcrud.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.deb.mvvmcrud.data.db.model.Notification;

import java.util.List;

import io.reactivex.Flowable;


/**
 * Created by Ashish on 24-Apr-18.
 */
@Dao
public interface NotificationDao {

    @Delete
    void delete(Notification notification);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Notification notification);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addNotification(Notification notification);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Notification> notification);

    @Query("SELECT * FROM notification")
    List<Notification> loadAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Notification... notifications);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long addNotification1(Notification notification);

    /**
     * Select all tasks from the tasks table.
     *
     * @return all tasks.
     */
    @Query("SELECT * FROM notification")
    Flowable<List<Notification>> getTasks();

}
