package com.deb.mvvmcrud.data.db.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
Created by Deb
*/
@Entity(tableName = "test_model")
public class TestModel {

    @ColumnInfo(name = "created_at")
    public String createdAt;

    @PrimaryKey
    public Long id;

    public String name;

    @ColumnInfo(name = "updated_at")
    public String updatedAt;
}
