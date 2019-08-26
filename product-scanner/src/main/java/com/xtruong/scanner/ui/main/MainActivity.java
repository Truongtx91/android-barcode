package com.xtruong.scanner.ui.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.xtruong.scanner.BuildConfig;
import com.xtruong.scanner.R;
import com.xtruong.scanner.ui.about.AboutFragment;
import com.xtruong.scanner.ui.base.BaseActivity;
import com.xtruong.scanner.ui.login.LoginActivity;
import com.xtruong.scanner.ui.main.password.PasswordDialog;
import com.xtruong.scanner.ui.main.rating.RatingDialog;
import com.xtruong.scanner.ui.nav.dashboard.DashboardFragment;
import com.xtruong.scanner.ui.nav.home.HomeFragment;
import com.xtruong.scanner.ui.nav.notification.NotificationFragment;
import com.xtruong.scanner.ui.payment.PaymentActivity;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by truongtx on 8/10/2019
 */
public class MainActivity extends BaseActivity implements  IMainView {

    @Inject
    IMainPresenter<IMainView> mPresenter;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.tv_app_version)
    TextView mAppVersionTextView;

    @BindView(R.id.drawer_view)
    DrawerLayout mDrawer;

    @BindView(R.id.nav_view)
    NavigationView mNavigationView;

    @BindView(R.id.navigation)
    BottomNavigationView mBottomNavView;

    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    private TextView mNameTextView;

    private TextView mEmailTextView;

    private ActionBarDrawerToggle mDrawerToggle;

    private RoundedImageView mProfileImageView;

    public static Intent getStartIntent(Context context){
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        setUp();

    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(AboutFragment.TAG);
        if (fragment == null) {
            super.onBackPressed();
        } else {
            onFragmentDetached(AboutFragment.TAG);
        }
    }

    @Override
    public void updateAppVersion() {
        String version = "version" + " " + BuildConfig.VERSION_NAME;
        mAppVersionTextView.setText(version);
    }

    @Override
    public void showAboutFragment() {
        lockDrawer();
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .add(R.id.cl_root_view, AboutFragment.newInstance(), AboutFragment.TAG)
                .commit();
    }

    @Override
    public void showBarcodeFragment() {

    }

    @Override
    public void updateUserName(String currentUserName) {
        mNameTextView.setText(currentUserName);
    }

    @Override
    public void updateUserEmail(String currentUserEmail) {
        mEmailTextView.setText(currentUserEmail);
    }

    @Override
    public void updateUserProfilePic(String currentUserProfilePicUrl) {
        //load profile pic url into ANImageView
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mDrawer != null)
            mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void onFragmentAttached() {
    }

    @Override
    public void onFragmentDetached(String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment != null) {
            fragmentManager
                    .beginTransaction()
                    .disallowAddToBackStack()
                    .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                    .remove(fragment)
                    .commitNow();
            unlockDrawer();
        }
    }

    @Override
    public void unlockDrawer() {
        if (mDrawer != null)
            mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }

    @Override
    public void lockDrawer() {
        if (mDrawer != null)
            mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Drawable drawable = item.getIcon();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
        switch (item.getItemId()) {
            case R.id.action_cut:
                return true;
            case R.id.action_copy:
                return true;
            case R.id.action_share:
                return true;
            case R.id.action_delete:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void setUp() {

        FragmentPageAdapter adapter = new FragmentPageAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(new FragmentPageAdapter(getSupportFragmentManager()));
        mViewPager.setOffscreenPageLimit(adapter.getCount() - 1);

        setSupportActionBar(mToolbar);
        mBottomNavView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawer,
                mToolbar,
                R.string.open_drawer,
                R.string.close_drawer) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                hideKeyboard();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        mDrawer.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        setupNavMenu();
        mPresenter.onNavMenuCreated();

        setupBarCodeContainerView();

        mPresenter.onViewInitialized();
    }


    private void setupBarCodeContainerView() {
        // TODO
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            mToolbar.setTitle(item.getTitle());
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mViewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    mViewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    mViewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };

    private void setupNavMenu() {

        View headerLayout = mNavigationView.getHeaderView(0);

        mProfileImageView = headerLayout.findViewById(R.id.iv_profile_pic);
        mNameTextView =  headerLayout.findViewById(R.id.tv_name);
        mEmailTextView = headerLayout.findViewById(R.id.tv_email);

        mNavigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        mDrawer.closeDrawer(GravityCompat.START);

                        switch (item.getItemId()) {
                            case R.id.nav_item_payment:
                                mPresenter.onDrawerPaymentClick();
                                return true;
                            case R.id.nav_item_change_password:
                                mPresenter.onDrawerChangePasswordClick();
                                return true;
                            case R.id.nav_item_rate_us:
                                mPresenter.onDrawerRateUsClick();
                                return true;
                            case R.id.nav_item_about:
                                mPresenter.onDrawerOptionAboutClick();
                                return true;
                            case R.id.nav_item_logout:
                                mPresenter.onDrawerOptionLogoutClick();
                                return true;
                            default:
                                return false;
                        }
                    }
                });
    }


    @Override
    public void openLoginActivity() {
        startActivity(LoginActivity.getStartIntent(this));
        finish();
    }

    @Override
    public void closeNavigationDrawer() {
        if (mDrawer != null) {
            mDrawer.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    public void showRateUsDialog() {
        RatingDialog.newInstance().show(getSupportFragmentManager());
    }

    @Override
    public void openPaymentActivity(){
        startActivity(PaymentActivity.getStartIntent(this));
    }

    @Override
    public void showChangePasswordDialog(){
        PasswordDialog.newInstance().show(getSupportFragmentManager());
    }

    private static class FragmentPageAdapter extends FragmentPagerAdapter {

        public FragmentPageAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return HomeFragment.newInstance();
                case 1:
                    return DashboardFragment.newInstance();
                case 2:
                    return NotificationFragment.newInstance();
            }
            return null;
        }
        @Override
        public int getCount() {
            return 3;
        }
    }

}
