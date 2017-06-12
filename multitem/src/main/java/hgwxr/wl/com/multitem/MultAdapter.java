package hgwxr.wl.com.multitem;

import android.content.Context;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/6/12.
 */

public class MultAdapter  extends  BaseRecyclerAdapter {
    private  ItemDelegateManager mItemDataDelegates;
    public MultAdapter(Context mContext) {
        super(mContext);
        //声明 处理哪几种数据
        mItemDataDelegates=new ItemDelegateManager();
       /* HashMap<Class, ItemDataDelegates> itemDataDelegates = new HashMap<>();
        itemDataDelegates.put(User.class,new UserDelegate());
        itemDataDelegates.put(Member.class,new MemberDelegate());
        mItemDataDelegates.addItemDelegate(itemDataDelegates);*/

//        mItemDataDelegates.addItemDelegate(Pair.<Class, ItemDataDelegates>create(User.class,new UserDelegate()));
       // mItemDataDelegates.add(User.class,R.layout.item_user,new HandlerWayForItem());
    }
    public  void addItemDelegate(HashMap<Class, ItemDataDelegates> itemDataDelegates){
        mItemDataDelegates.addItemDelegate(itemDataDelegates);
    }
    @Override
    protected void bindDataToView(BaseViewHolder holder, Object data, int position) {
          /* if (data instanceof User){
               handleUser(((User) data),holder,position);
           }*/
          if (mItemDataDelegates!=null)
              mItemDataDelegates.handlerWayForItem(data,holder,position);
          else
              throw new IllegalArgumentException("no handler way");
    }

    private void handleUser(User user, BaseViewHolder holder, int position) {
        TextView tvUser =  holder.getView(R.id.tv_user);
        tvUser.setText(user.getAge()+"   "+user.getName());
    }

    @Override
    protected int getItemType(int position) {
       /* if (mTList.get(position) instanceof User)
            return R.layout.item_user;*/
        //throw new IllegalArgumentException("No layout item ");
        if (mItemDataDelegates!=null) {
            return mItemDataDelegates.getItemType(mTList,position);
        }
        else
        throw new IllegalArgumentException("No layout item ");
    }


}
