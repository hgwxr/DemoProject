package hgwxr.wl.com.basemvp.data;

import hgwxr.wl.com.basemvp.DemoApp;
import hgwxr.wl.com.basemvp.data.local.DbHelper;
import hgwxr.wl.com.basemvp.data.local.PreferencesHelper;
import hgwxr.wl.com.basemvp.data.server.ApiService;
import hgwxr.wl.com.basemvp.data.server.IServerApi;

/**
 * Created by Administrator on 2017/6/9.
 */
public class DataManager {
    private DbHelper mDbHelper;
    private PreferencesHelper mPreferencesHelper;
    private IServerApi mIServerApi;
    private static DataManager mDataManager;
    private  DataManager(){
        mDbHelper=new DbHelper();
        mPreferencesHelper=PreferencesHelper.getInstance(DemoApp.getAppContext());
        mIServerApi= ApiService.createService(IServerApi.class);
    }
    public static DataManager getInstance(){
        if (mDataManager==null){
            mDataManager=new DataManager();
        }
        return mDataManager;
    }
    public DbHelper getmDbHelper(){
        return mDataManager.mDbHelper;
    }
    public PreferencesHelper getmPreferencesHelper(){
        return mDataManager.mPreferencesHelper;
    }
    public IServerApi getmIServerApi(){
        return mDataManager.mIServerApi;
    }
}
