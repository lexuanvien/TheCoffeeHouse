package com.example.thecoffeehouse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager_153;
    private IntroViewPagerAdapter mPagerAdapter_153;
    private LinearLayout mDotsLayout_153;
    private TextView[] mDots_153;
    private int[] mLayouts_153;
    private Button mBtnSkip_153;
    private Button mBtnNext_153;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        if (!PrefManager.getInstance(this).isFirstTimeLaunch()) {
            launchHomeScreen();
        }

        //Making notification bar transparent
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        }
        mViewPager_153 = (ViewPager) findViewById(R.id.view_pager);
        mDotsLayout_153 = (LinearLayout) findViewById(R.id.layoutDots);
        mBtnSkip_153 = (Button) findViewById(R.id.btn_skip);
        mBtnNext_153 = (Button) findViewById(R.id.btn_next);

        /**
         * Layouts of all welcome slides
         * add few more layouts if you want
         */
        mLayouts_153 = new int[]{R.layout.welcome_side1, R.layout.welcome_side2, R.layout.welcome_side3};
        addBottomDots(0);
        changeStatusBarColor();

        mPagerAdapter_153 = new IntroViewPagerAdapter();
        mViewPager_153.setAdapter(mPagerAdapter_153);
        mViewPager_153.addOnPageChangeListener(mViewPagerChangeListener);

        mBtnSkip_153.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchHomeScreen();
            }
        });

        mBtnNext_153.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * Checking for last page if last page home screen will be launched
                 */
                int current = getItem(1);
                if (current < mLayouts_153.length) {
                    // move to nex screen
                    mViewPager_153.setCurrentItem(current);
                } else {
                    launchHomeScreen();
                }

            }
        });
    }
    private ViewPager.OnPageChangeListener mViewPagerChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);
            //Change the next button text 'NEXT'/'GOT IT'
            if (position == mLayouts_153.length - 1) {
                mBtnNext_153.setText(getString(R.string.start));
                mBtnSkip_153.setVisibility(View.GONE);
            } else {
                //Still pages are left
                mBtnNext_153.setText(getString(R.string.next));
                mBtnSkip_153.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private void addBottomDots(int currentPage) {
        mDots_153 = new TextView[mLayouts_153.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInActive = getResources().getIntArray(R.array.array_dot_inactive);

        mDotsLayout_153.removeAllViews();
        for (int i = 0; i < mDots_153.length; i++) {
            mDots_153[i] = new TextView(this);
            mDots_153[i].setText(Html.fromHtml("•"));
            mDots_153[i].setTextSize(35);
            mDots_153[i].setTextColor(colorsInActive[currentPage]);
            mDotsLayout_153.addView(mDots_153[i]);
        }
        if (mDots_153.length > 0) {
            mDots_153[currentPage].setTextColor(colorsActive[currentPage]);
        }
    }

    /**
     * Making notification bar transparent
     */
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    private int getItem(int i) {
        return mViewPager_153.getCurrentItem() + i;
    }

    private void launchHomeScreen() {
        Intent intent = new Intent(this, SigninActivity.class);
        startActivity(intent);
        finish();
    }

    public class IntroViewPagerAdapter extends PagerAdapter {
        private LayoutInflater mInflater;

        public IntroViewPagerAdapter() {
            super();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = mInflater.inflate(mLayouts_153[position], container, false);
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return mLayouts_153.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}