package com.deb.mvvmcrud.ui.user;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.widget.LinearLayoutManager;

import com.deb.mvvmcrud.ViewModelProviderFactory;
import com.deb.mvvmcrud.ui.navigation.NavigationViewModel;
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
    UserViewModel provideUserViewModel( SchedulerProvider schedulerProvider) {
        return new UserViewModel( schedulerProvider);
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AddUserFragment fragment) {
        return new LinearLayoutManager(fragment.getActivity());
    }
}
