package com.deb.mvvmcrud.ui.navigation;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.deb.mvvmcrud.BR;
import com.deb.mvvmcrud.BuildConfig;
import com.deb.mvvmcrud.R;
import com.deb.mvvmcrud.databinding.ActivityNavigationBinding;
import com.deb.mvvmcrud.ui.base.BaseActivity;
import com.deb.mvvmcrud.ui.user.AddUserFragment;
import com.deb.mvvmcrud.ui.user.ViewUserFragment;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class NavigationActivity extends BaseActivity<ActivityNavigationBinding,NavigationViewModel>  implements Navigator,
        NavigationView.OnNavigationItemSelectedListener,HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    @Inject
    ViewModelProvider.Factory mViewModelFactory;
    private ActivityNavigationBinding mActivityNavigationBinding;
    private NavigationViewModel mNavigationViewModel;

    private DrawerLayout mDrawer;
    private NavigationView mNavigationView;
    private Toolbar mToolbar;

    @Override
    public int getBindingVariable() {
        return BR.navModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_navigation;
    }

    @Override
    public NavigationViewModel getViewModel() {
        mNavigationViewModel = ViewModelProviders.of(this, mViewModelFactory).get(NavigationViewModel.class);
        return mNavigationViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);*/


        mActivityNavigationBinding = getViewDataBinding();
        mNavigationViewModel.setNavigator(this);
        setUp();
        mNavigationViewModel.updateTxtHello("Wellcome to dragger and RX");
        mNavigationView.setNavigationItemSelectedListener(this);
    }

    private void setUp() {
        mDrawer = mActivityNavigationBinding.drawerLayout;
        mToolbar = mActivityNavigationBinding.icludeAppBarNavigation.toolbar;
        mNavigationView = mActivityNavigationBinding.navView;

        setSupportActionBar(mToolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawer,
                mToolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                hideKeyboard();
            }
        };
        mDrawer.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        //setupNavMenu();
        //String version = getString(R.string.version) + " " + BuildConfig.VERSION_NAME;
        //mNavigationViewModel.updateAppVersion(version);
        //mNavigationViewModel.onNavMenuCreated();
        //setupCardContainerView();
        //subscribeToLiveData();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_adduser) {
            adduser();
        } else if (id == R.id.nav_viewuser) {
            viewuser();
        }

        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void handleError(Throwable throwable) {

    }

    @Override
    public void adduser() {
        mDrawer.closeDrawer(GravityCompat.START);
        Log.i(AddUserFragment.TAG,"Clicked");
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .replace(R.id.clRootView, AddUserFragment.newInstance("play","Music"), AddUserFragment.TAG)
                .commit();
    }

    @Override
    public void viewuser() {
        mDrawer.closeDrawer(GravityCompat.START);
        Log.i(AddUserFragment.TAG,"Clicked");
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .replace(R.id.clRootView, ViewUserFragment.newInstance(1), ViewUserFragment.TAG)
                .commit();

    }
@Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
