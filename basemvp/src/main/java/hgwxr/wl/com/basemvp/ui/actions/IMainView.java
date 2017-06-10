package hgwxr.wl.com.basemvp.ui.actions;

import hgwxr.wl.com.basemvp.data.other.CaipuBase;

/**
 * Created by Administrator on 2017/6/9.
 */

public interface IMainView  extends IBaseView  {
   void  handleCaiPuNum(int num);
   void  handleCaiPuTianGou(CaipuBase.TngouBean tngouBean);
}
