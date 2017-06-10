package hgwxr.wl.com.basemvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import hgwxr.wl.com.basemvp.data.other.CaipuBase;
import hgwxr.wl.com.basemvp.ui.BaseMvpActivity;
import hgwxr.wl.com.basemvp.ui.actions.IMainView;
import hgwxr.wl.com.basemvp.ui.presenters.MainPresenter;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements IMainView {

    private TextView tvJump;


    @Override
    protected void configLayout() {
        setContentView(R.layout.activity_main);
        tvJump = ((TextView) findViewById(R.id.basemvp_tv_jump));
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
        tvJump.setText(tngouBean.toString());
    }

    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter();
    }
}
