package hgwxr.wl.com.multitem;

import android.support.annotation.LayoutRes;

import java.util.List;

/**
 * Created by Administrator on 2017/6/12.
 */

public interface ItemDataDelegates<T> {
     @LayoutRes int getItemType(List list,int position);
     Class getItemDataClass();
     void  handlerWayForItem(T data, BaseRecyclerAdapter.BaseViewHolder holder, int position);
}
