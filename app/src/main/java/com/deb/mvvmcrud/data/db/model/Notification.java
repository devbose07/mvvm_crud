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

package com.deb.mvvmcrud.data.db.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by amitshekhar on 08/07/17.
 */

@Entity(tableName = "notification")
public class Notification {

    @Expose
    @SerializedName("message")
    @ColumnInfo(name = "message")
    public String message;

    public String getMessage() {
        return message;
    }

    public Integer getId() {
        return id;
    }

    public String getHeader() {
        return header;
    }

    public Integer getType() {
        return type;
    }

    public String getActionPath() {
        return actionPath;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getAddedOn() {
        return addedOn;
    }

    public String getDeletedOn() {
        return deletedOn;
    }

    public Integer getDeletedBy() {
        return deletedBy;
    }

    public Integer getFlag() {
        return flag;
    }

    @Expose
    @PrimaryKey(autoGenerate = true)
    public Integer id;

    @Expose
    @SerializedName("header")
    @ColumnInfo(name = "header")
    public String header;

    @Expose
    @SerializedName("type")
    @ColumnInfo(name = "type")
    public Integer type;

    @Expose
    @SerializedName("action_path")
    @ColumnInfo(name = "action_path")
    public String actionPath;

    @Expose
    @SerializedName("image_url")
    @ColumnInfo(name = "image_url")
    public String imageUrl;

    @Expose
    @SerializedName("added_on")
    @ColumnInfo(name = "added_on")
    public String addedOn;

    @Expose
    @SerializedName("deleted_on")
    @ColumnInfo(name = "deleted_on")
    public String deletedOn;


    @Expose
    @SerializedName("deleted_by")
    @ColumnInfo(name = "deleted_by")
    public Integer deletedBy;


    @Expose
    @SerializedName("flag")
    @ColumnInfo(name = "flag")
    public Integer flag;


    public Notification(){

    }

    public Notification(String msg, String header, int type, String actionPath, String imageUrl, String addedOn, String deletedOn, int deletedBy, int flag) {
       // this.id=id;
        this.message = msg;
        this.header = header;
        this.type = type;
        this.actionPath = actionPath;
        this.addedOn = addedOn;
        this.imageUrl = imageUrl;
        this.deletedOn=deletedOn;
        this.deletedBy=deletedBy;
        this.flag=flag;
    }

    /*public Notification(int id,String msg, String header, int type, String actionPath,String addedOn,String imageUrl) {
        this.id=id;
        this.message = msg;
        this.header = header;
        this.type = type;
        this.actionPath = actionPath;
        this.addedOn = addedOn;
        this.imageUrl = imageUrl;
    }
*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Notification)) return false;

        Notification note = (Notification) o;

        if (id != note.id) return false;
        return header != null ? header.equals(note.header) : note.header == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (header != null ? header.hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", header='" + header + '\'' +
                ", type='" + type + '\'' +
                ", actionPath='" + actionPath + '\'' +
                ", addedOn='" + addedOn + '\'' +
                ", deletedOn='" + deletedOn + '\'' +
                ", deletedBy='" + deletedBy + '\'' +
                ", flag='" + flag + '\'' +
                ", imageUrl=" + imageUrl +
                '}';
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setActionPath(String actionPath) {
        this.actionPath = actionPath;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setAddedOn(String addedOn) {
        this.addedOn = addedOn;
    }

    public void setDeletedOn(String deletedOn) {
        this.deletedOn = deletedOn;
    }

    public void setDeletedBy(Integer deletedBy) {
        this.deletedBy = deletedBy;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
