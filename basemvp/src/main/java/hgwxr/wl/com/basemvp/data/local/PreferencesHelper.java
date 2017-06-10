package hgwxr.wl.com.basemvp.data.local;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2017/6/9.
 */

public class PreferencesHelper {
    public static final String PREF_FILE_NAME = "android_demo_pref_file";

    private static  SharedPreferences mPref;
    private static PreferencesHelper mPreferencesHelper;
    private PreferencesHelper( Context context) {
        mPref = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
    }

    public static PreferencesHelper getInstance(Context context){
        if (mPreferencesHelper==null){
            mPreferencesHelper= new PreferencesHelper(context);
        }
        return mPreferencesHelper;
    }

    public SharedPreferences getSharedPref() {
        return mPref;
    }
    public SharedPreferences.Editor getSharedPrefEditor() {
        return mPref.edit();
    }
    public void clear() {
        mPref.edit().clear().apply();
    }

}
