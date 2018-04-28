package com.deb.mvvmcrud.ui.user;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;
import android.util.Log;

import com.deb.mvvmcrud.ui.base.BaseViewModel;
import com.deb.mvvmcrud.utils.rx.SchedulerProvider;

import java.util.List;

/**
Created by Deb
*/
public class UserViewModel extends BaseViewModel<AddUserNavigator> {
    public static final String TAG = UserViewModel.class.getName();
    private final ObservableField<String> username = new ObservableField<>();
    private final MutableLiveData<List<String>> userListData=new MutableLiveData<>();

    public UserViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public ObservableField<String> getUsername() {
        return username;
    }

    public MutableLiveData<List<String>> getUserListData() {
        return userListData;
    }


    void saveUser(){
        Log.i(UserViewModel.TAG,"Username" +username);
        //return 0L;
    }
}
