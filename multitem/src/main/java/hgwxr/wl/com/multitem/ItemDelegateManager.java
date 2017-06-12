package hgwxr.wl.com.multitem;

import android.support.annotation.LayoutRes;
import android.support.v4.util.Pair;
import android.util.Log;
import android.util.SparseArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/12.
 */

public class ItemDelegateManager {
    private static final String TAG = ItemDelegateManager.class.getSimpleName();
//    private List<HashMap<Class,ItemDataDelegates>> mItemDataDelegates;
    public ItemDelegateManager(){
//        mItemDataDelegates=new ArrayList<>();
        mMap=new HashMap<>();
    }
    public void addItemDelegate(HashMap<Class,ItemDataDelegates> itemDataDelegates){
//        mItemDataDelegates.add(itemDataDelegates);
        mMap=itemDataDelegates;
    }
    private  HashMap<Class,ItemDataDelegates> mMap;
    public void handlerWayForItem(Object data, BaseRecyclerAdapter.BaseViewHolder holder, int position) {

        ItemDataDelegates itemDataDelegates = mMap.get(data.getClass());
        if (itemDataDelegates!=null){
            itemDataDelegates.handlerWayForItem(data, holder, position);
        }
        else
        throw new IllegalArgumentException("no handler ItemDataDelegates");
       /* for (Pair<Class, ItemDataDelegates> itemDataDelegate : mItemDataDelegates) {
            Class first = itemDataDelegate.first;
            if (data.getClass()== first ){
                itemDataDelegate.second.handlerWayForItem(data,holder,position);
                Log.d(TAG, "handlerWayForItem() called with: data = [" + data + "], holder = [" + holder + "], position = [" + position + "]");
            }
        }*/

    }

    public int getItemType(List list, int position) {
        Object o = list.get(position);
        ItemDataDelegates itemDataDelegates = mMap.get(o.getClass());
        if (itemDataDelegates!=null){
            return  itemDataDelegates.getItemType(list, position);
        }else
         throw  new IllegalArgumentException("itemDataDelegates.getItemType error");
    }
}
