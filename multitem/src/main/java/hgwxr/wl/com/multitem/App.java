package hgwxr.wl.com.multitem;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2017/6/12.
 */

public class App  extends Application {
       private static Context mContext;
        @Override
        public void onCreate() {
            mContext=this;
            super.onCreate();
        }
    public static  Context  getAppContext(){
        return  mContext;
    }
}
