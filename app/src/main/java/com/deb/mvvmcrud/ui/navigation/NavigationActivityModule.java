package com.deb.mvvmcrud.ui.navigation;

import android.arch.lifecycle.ViewModelProvider;

import com.deb.mvvmcrud.ViewModelProviderFactory;
import com.deb.mvvmcrud.data.manager.DataManager;
import com.deb.mvvmcrud.data.manager.UserDataManager;
import com.deb.mvvmcrud.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
Created by Deb
*/
@Module
public class NavigationActivityModule {

   /* @Provides
    NavigationViewModel provideNavigationViewModel(NotificationManager dataManager, SchedulerProvider schedulerProvider) {
        return new NavigationViewModel(dataManager, schedulerProvider);
    }*/
   @Provides
   ViewModelProvider.Factory mainViewModelProvider(NavigationViewModel navigationViewModel) {
       return new ViewModelProviderFactory<>(navigationViewModel);
   }
    @Provides
    NavigationViewModel provideNavigationViewModel(UserDataManager dataManager, SchedulerProvider schedulerProvider) {
        return new NavigationViewModel( dataManager,schedulerProvider);
    }
}
