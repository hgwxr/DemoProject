package hgwxr.wl.com.basemvp.ui.presenters;

import hgwxr.wl.com.basemvp.ui.actions.IBaseView;

/**
 * Created by Administrator on 2017/6/9.
 */

public class BasePresenter<T extends IBaseView>  {
    protected T mActionView;
    public void attach(T view){
        mActionView=view;
    }
    public void deAttach(){
        mActionView=null;
    }
}
