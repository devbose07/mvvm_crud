package com.deb.mvvmcrud.ui.navigation;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;
import android.util.Log;

import com.deb.mvvmcrud.data.db.model.Notification;
import com.deb.mvvmcrud.data.db.model.User;
import com.deb.mvvmcrud.data.manager.DataManager;
import com.deb.mvvmcrud.data.manager.UserDataManager;
import com.deb.mvvmcrud.ui.base.BaseViewModel;
import com.deb.mvvmcrud.ui.user.UserViewModel;
import com.deb.mvvmcrud.utils.rx.SchedulerProvider;

import java.util.Date;
import java.util.List;

/**
Created by Deb
*/
public class NavigationViewModel extends BaseViewModel<Navigator,UserDataManager> {

    private final ObservableField<String> txtHello = new ObservableField<>();
    //private final NotificationManager mdataManager;

    private final MutableLiveData<List<Notification>> notificationdData;

   /* public NavigationViewModel(NotificationManager dataManager, SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
        mdataManager=dataManager;
        notificationdData = new MutableLiveData<>();
        loadNotification();

    }*/

    public NavigationViewModel(UserDataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager,schedulerProvider);

        notificationdData = new MutableLiveData<>();
        //loadNotification();

    }

    /*public void loadNotification() {
        getCompositeDisposable().add(mdataManager
                .getAllNotification()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(notificationList -> {
                    if (notificationList != null) {
                        notificationdData.setValue(notificationList);
                    }
                }, throwable -> {

                }));
    }*/

    public ObservableField<String> getTxtHello() {
        return txtHello;
    }

    public void updateTxtHello(String txt) {
        txtHello.set(txt);
    }

    public void saveUser(){

        User user=new User();
        user.setName("Test Name");
        //notification.setId(12);
        user.setCreatedAt(new Date(System.currentTimeMillis()));
        //notification.createDate="2018-06-27 16:18:00";

        getCompositeDisposable().add(
                getDataManager().saveUser(user)
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(id -> {
                            Log.i("username","id "+id);
                        })
        );


    }
}
