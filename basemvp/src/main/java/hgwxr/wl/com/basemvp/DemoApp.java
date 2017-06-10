package hgwxr.wl.com.basemvp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Administrator on 2017/6/9.
 */

public class DemoApp extends Application {
    private static final String TAG = "DemoApp";
   private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
        this.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                Log.d(TAG, "onActivityCreated() called with: activity = [" + activity + "], savedInstanceState = [" + savedInstanceState + "]");
            }

            @Override
            public void onActivityStarted(Activity activity) {
                Log.d(TAG, "onActivityStarted() called with: activity = [" + activity + "]");
            }

            @Override
            public void onActivityResumed(Activity activity) {
                Log.d(TAG, "onActivityResumed() called with: activity = [" + activity + "]");
            }

            @Override
            public void onActivityPaused(Activity activity) {
                Log.d(TAG, "onActivityPaused() called with: activity = [" + activity + "]");
            }

            @Override
            public void onActivityStopped(Activity activity) {
                Log.d(TAG, "onActivityStopped() called with: activity = [" + activity + "]");
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                Log.d(TAG, "onActivitySaveInstanceState() called with: activity = [" + activity + "], outState = [" + outState + "]");
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                Log.d(TAG, "onActivityDestroyed() called with: activity = [" + activity + "]");
            }
        });
    }
    public static Context getAppContext(){
        return mContext;
    }
}
