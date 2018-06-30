package com.deb.mvvmcrud.ui.user;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.res.Resources;
import android.databinding.ObservableField;
import android.util.Log;

import com.deb.mvvmcrud.R;
import com.deb.mvvmcrud.data.db.helper.NotificationDbHelper;
import com.deb.mvvmcrud.data.db.model.Notification;
import com.deb.mvvmcrud.data.manager.DataManager;
import com.deb.mvvmcrud.ui.base.BaseViewModel;
import com.deb.mvvmcrud.utils.rx.SchedulerProvider;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

/**
Created by Deb
*/
public class UserViewModel extends  BaseViewModel<AddUserNavigator,DataManager> {
    public static final String TAG = UserViewModel.class.getName();
    public ObservableField<String> username = new ObservableField<>();
    private final MutableLiveData<List<String>> userListData=new MutableLiveData<>();

    @Inject
    NotificationDbHelper mNotificationDbHelper;

    @Inject
    Resources resources;
    @Inject
    Context conText;

    public UserViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager,schedulerProvider);
        //username.set(resources.getString(R.string.app_name));
        username.set("set from model");
    }

    /*public ObservableField<String> getUsername() {
        return username;
    }

    public void setUsername(ObservableField<String> username) {
        this.username = username;
    }*/

    public MutableLiveData<List<String>> getUserListData() {
        return userListData;
    }


    public void saveUser(){
        Log.i(UserViewModel.TAG,"Username:" +username.get());
        Notification notification=new Notification();
        notification.setMessage("Debashis");
        //notification.setId(12);
        notification.setCreateDate(new Date(System.currentTimeMillis()));
        //notification.createDate="2018-06-27 16:18:00";

        getCompositeDisposable().add(
        getDataManager().saveNotification(notification)
        .subscribeOn(getSchedulerProvider().io())
        .observeOn(getSchedulerProvider().ui())
        .subscribe(id -> {
            Log.i("username","id "+id);
        })
);
        username.set(username.get()+" update after save");
       /* if(resources==null)
        {
            Log.i(UserViewModel.TAG,"resources null :" );
            Log.i(UserViewModel.TAG,"conText not null :" +conText.getString(R.string.app_name));
        }
        else
        {
            Log.i(UserViewModel.TAG,"resources not null :" +conText.getString(R.string.app_name));
        }*/
        //mNotificationDbHelper.saveNotification(notification);
        //return 0L;

    }
}
