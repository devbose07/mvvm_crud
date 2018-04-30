package com.deb.mvvmcrud.ui.user;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;
import android.util.Log;

import com.deb.mvvmcrud.data.db.helper.NotificationDbHelper;
import com.deb.mvvmcrud.data.db.model.Notification;
import com.deb.mvvmcrud.data.manager.NotificationManager;
import com.deb.mvvmcrud.ui.base.BaseViewModel;
import com.deb.mvvmcrud.utils.rx.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

/**
Created by Deb
*/
public class UserViewModel extends BaseViewModel<AddUserNavigator> {
    public static final String TAG = UserViewModel.class.getName();
    public ObservableField<String> username = new ObservableField<>();
    private final MutableLiveData<List<String>> userListData=new MutableLiveData<>();

    @Inject
    NotificationDbHelper mNotificationDbHelper;

    public UserViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
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
        notification.setMessage(username.get());
        mNotificationDbHelper.saveNotification(notification);
        //return 0L;
    }
}
