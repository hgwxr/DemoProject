package hgwxr.wl.com.basemvp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import hgwxr.wl.com.basemvp.R;
import hgwxr.wl.com.basemvp.ui.actions.IBaseView;
import hgwxr.wl.com.basemvp.ui.presenters.BasePresenter;

public abstract class BaseMvpActivity<T extends BasePresenter> extends AppCompatActivity implements IBaseView {

   protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       configLayout();
       mPresenter=getPresenter();
       mPresenter.attach(this);
    }

    protected abstract void configLayout();

    protected   abstract  T getPresenter() ;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.deAttach();
    }
}
