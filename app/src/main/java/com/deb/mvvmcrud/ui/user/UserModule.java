package com.deb.mvvmcrud.ui.user;

import android.support.v7.widget.LinearLayoutManager;

import com.deb.mvvmcrud.data.manager.DataManager;
import com.deb.mvvmcrud.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
Created by Deb
*/
@Module
public class UserModule {

   /* @Provides
    ViewModelProvider.Factory userViewModelProvider(UserViewModel userViewModel) {
        return new ViewModelProviderFactory<>(userViewModel);
    }*/
    @Provides
    UserViewModel provideUserViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new UserViewModel(dataManager, schedulerProvider);
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AddUserFragment fragment) {
        return new LinearLayoutManager(fragment.getActivity());
    }
}
