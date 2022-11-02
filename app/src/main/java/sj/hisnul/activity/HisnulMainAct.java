package sj.hisnul.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.mushafconsolidated.Activity.BaseActivity;
import com.example.mushafconsolidated.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import sj.hisnul.fragments.AllDuaFrag;
import sj.hisnul.fragments.BookmarkFragment;
import sj.hisnul.fragments.CatTwoFrag;

public class HisnulMainAct extends BaseActivity {


    private static final int NUM_TAB_TITLES= 3;

    private boolean ismujarrad;
    Bundle dataBundle;

    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2,R.string.tab_text_3};
    // Arrey of strings FOR TABS TITLES


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hisnul_act);

        FragmentManager fm = getSupportFragmentManager();
        //  MaterialToolbar toolbar =   findViewById(R.id.toolbarmainact);
        // setSupportActionBar(toolbar);
        //  getSupportActionBar().hide();
        ViewStateAdapter sa = new ViewStateAdapter(fm, getLifecycle());
        final ViewPager2 viewPager = findViewById(R.id.view_pager);
        sa.notifyItemChanged(0);

        viewPager.setAdapter(sa);
        final TabLayout tabLayout = findViewById(R.id.tabs);
        dataBundle = new Bundle();
        Bundle bundle = getIntent().getExtras();

//        String root = bundle.getString("list");



        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(TAB_TITLES[position])).attach();











        // Now we have tabs, NOTE: I am hardcoding the order, you'll want to do something smarter

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

        // And now we have tabs that, when clicked, navigate to the correct page
    }


    private class ViewStateAdapter extends FragmentStateAdapter {

        public ViewStateAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);


        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            // Hardcoded in this order, you'll want to use lists and make sure the titles match
            if (position == 0) {
                BookmarkFragment fragv = new BookmarkFragment();
                fragv.setArguments(dataBundle);

                return fragv.newInstance();
            } else if (position ==1) {
                CatTwoFrag catTwoFrag = new CatTwoFrag();
                catTwoFrag.setArguments(dataBundle);
                return catTwoFrag.newInstance();
            } else if (position == 2) {
                AllDuaFrag fragment = new AllDuaFrag();
                fragment.setArguments(dataBundle);
                return fragment.newInstance();
            }

            //  CatoneFrag fragv = new CatoneFrag();
            //  fragv.setArguments(dataBundle);
            // return fragv.newInstance();
            return null;
        }


        @Override
        public int getItemCount() {

            return NUM_TAB_TITLES;

        }
    }







}
