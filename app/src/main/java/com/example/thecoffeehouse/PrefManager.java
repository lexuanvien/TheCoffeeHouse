package com.example.thecoffeehouse;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    SharedPreferences mPref_153;
    SharedPreferences.Editor mEditor_153;
    Context mContext_153;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME_153 = "androidhive-welcome";
    private static final String IS_FIRST_TIME_LAUNCH_153 = "IsFirstTimeLaunch";
    private static PrefManager mInstance_153;

    public static PrefManager getInstance(Context context) {
        if (mInstance_153 == null) {
            mInstance_153 = new PrefManager(context);
        }
        return mInstance_153;
    }

    public PrefManager(Context context) {
        this.mContext_153 = context;
        mPref_153 = mContext_153.getSharedPreferences(PREF_NAME_153, PRIVATE_MODE);
        mEditor_153 = mPref_153.edit();
    }

    public void setFirstimeLaunch(boolean isFirstTime) {
        mEditor_153.putBoolean(IS_FIRST_TIME_LAUNCH_153, isFirstTime);
        mEditor_153.apply();
    }

    public boolean isFirstTimeLaunch() {
        return mPref_153.getBoolean(IS_FIRST_TIME_LAUNCH_153, true);
    }
}
