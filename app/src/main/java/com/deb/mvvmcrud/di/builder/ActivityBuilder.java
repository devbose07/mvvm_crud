/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.deb.mvvmcrud.di.builder;

import com.deb.mvvmcrud.ui.navigation.NavigationActivity;
import com.deb.mvvmcrud.ui.navigation.NavigationActivityModule;
import com.deb.mvvmcrud.ui.user.AddUserFragmentProvider;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by deb
 */
@Module
public abstract class ActivityBuilder {

    /*@ContributesAndroidInjector(modules = {
            FeedActivityModule.class,
            BlogFragmentProvider.class,
            OpenSourceFragmentProvider.class})
    abstract FeedActivity bindFeedActivity();

    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector(modules = {
            MainActivityModule.class,
            AboutFragmentProvider.class,
            RateUsDialogProvider.class})
    abstract MainActivity bindMainActivity();*/

    @ContributesAndroidInjector(modules = {NavigationActivityModule.class,AddUserFragmentProvider.class})
    abstract NavigationActivity bindNavigationActivity();
}
