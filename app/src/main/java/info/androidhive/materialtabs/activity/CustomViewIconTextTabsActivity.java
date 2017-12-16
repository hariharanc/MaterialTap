package info.androidhive.materialtabs.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.materialtabs.R;
import info.androidhive.materialtabs.fragments.OneFragment;
import info.androidhive.materialtabs.fragments.ThreeFragment;
import info.androidhive.materialtabs.fragments.TwoFragment;

public class CustomViewIconTextTabsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView tabOne, tabTwo, tabThree, tabFour;
    private String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view_icon_text_tabs);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());

                switch (tab.getPosition()) {
                    case 0:
                        showToast("One");
                        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_mobile_active, 0, 0);
                        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_dth_normal, 0, 0);
                        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_datacard_normal, 0, 0);
                        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_broadband_normal, 0, 0);
                        break;
                    case 1:
                        showToast("Two");
                        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_mobile_normal, 0, 0);
                        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_dth_active, 0, 0);
                        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_datacard_normal, 0, 0);
                        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_broadband_normal, 0, 0);
                        break;
                    case 2:
                        showToast("Three");
                        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_mobile_normal, 0, 0);
                        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_dth_normal, 0, 0);
                        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_datacard_active, 0, 0);
                        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_broadband_normal, 0, 0);
                        break;
                    case 3:
                        showToast("Four");
                        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_mobile_normal, 0, 0);
                        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_dth_normal, 0, 0);
                        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_datacard_normal, 0, 0);
                        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_broadband_active, 0, 0);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    //
    void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    /**
     * Adding custom view to tab
     */
    private void setupTabIcons() {

        tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("Mobile");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_mobile_active, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("Dth");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_dth_normal, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText("Data Card");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_datacard_normal, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);

        tabFour = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabFour.setText("Broadband");
        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_broadband_normal, 0, 0);
        tabLayout.getTabAt(3).setCustomView(tabFour);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new OneFragment(), "MOBILE");
        adapter.addFrag(new TwoFragment(), "DTH");
        adapter.addFrag(new ThreeFragment(), "BROADBAND");
        adapter.addFrag(new ThreeFragment(), "DATACARD");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
