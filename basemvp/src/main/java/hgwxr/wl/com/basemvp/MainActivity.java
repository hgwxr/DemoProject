package hgwxr.wl.com.basemvp;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import hgwxr.wl.com.basemvp.data.other.CaipuBase;
import hgwxr.wl.com.basemvp.databinding.ActivityMainBinding;
import hgwxr.wl.com.basemvp.ui.BaseMvpActivity;
import hgwxr.wl.com.basemvp.ui.actions.IMainView;
import hgwxr.wl.com.basemvp.ui.presenters.MainPresenter;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements IMainView {

    private TextView tvJump;
    private ActivityMainBinding mainBinding;
    private CaipuBase.TngouBean tngouBean;


    @Override
    protected void configLayout() {
        setContentView(R.layout.activity_main);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        tvJump = ((TextView) findViewById(R.id.basemvp_tv_jump));
        tngouBean = new CaipuBase.TngouBean();
        mainBinding.setTiangou(tngouBean);
        tvJump.postDelayed(new Runnable() {
            @Override
            public void run() {
               tngouBean.setId(2);
            }
        },1000);

        tvJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  mPresenter.loadDataCaiPu();
            }
        });
    }
    @Override
    public  void handleCaiPuNum(int num){
        tvJump.setText(String.valueOf(num));
    }

    @Override
    public void handleCaiPuTianGou(CaipuBase.TngouBean tngouBean) {
//         this.tngouBean=tngouBean;
        //mainBinding.setTiangou(tngouBean);
        this.tngouBean.setId(tngouBean.getId());
        //mainBinding.executePendingBindings();
       // tvJump.setText(tngouBean.toString());
    }

    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter();
    }
}
