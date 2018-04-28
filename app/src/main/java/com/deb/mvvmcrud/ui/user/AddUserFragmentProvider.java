package com.deb.mvvmcrud.ui.user;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
Created by Deb
*/
@Module
public abstract class AddUserFragmentProvider {
    @ContributesAndroidInjector(modules = UserModule.class)
    abstract AddUserFragment provideAboutFragmentFactory();
}
