package com.deb.mvvmcrud.ui.base;

import android.arch.lifecycle.ViewModel;

import com.deb.mvvmcrud.utils.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

/**
Created by Deb
*/
public abstract class BaseViewModel<N,D> extends ViewModel {

    private final SchedulerProvider mSchedulerProvider;
    private CompositeDisposable mCompositeDisposable;
    private N mNavigator;
    private final D mDataManager;

    public BaseViewModel(D dataManager,
                         SchedulerProvider schedulerProvider) {
        this.mDataManager = dataManager;
        this.mSchedulerProvider = schedulerProvider;
        this.mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        super.onCleared();
    }
    public D getDataManager() {
        return mDataManager;
    }
    public N getNavigator() {
        return mNavigator;
    }

    public void setNavigator(N navigator) {
        this.mNavigator = navigator;
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }
}
