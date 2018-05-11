package com.deb.mvvmcrud.ui.navigation;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;

import com.deb.mvvmcrud.data.db.model.Notification;
import com.deb.mvvmcrud.data.manager.DataManager;
import com.deb.mvvmcrud.ui.base.BaseViewModel;
import com.deb.mvvmcrud.utils.rx.SchedulerProvider;

import java.util.List;

/**
Created by Deb
*/
public class NavigationViewModel extends BaseViewModel<Navigator,DataManager> {

    private final ObservableField<String> txtHello = new ObservableField<>();
    //private final NotificationManager mdataManager;

    private final MutableLiveData<List<Notification>> notificationdData;

   /* public NavigationViewModel(NotificationManager dataManager, SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
        mdataManager=dataManager;
        notificationdData = new MutableLiveData<>();
        loadNotification();

    }*/

    public NavigationViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
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
}
