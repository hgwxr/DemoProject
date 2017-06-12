package hgwxr.wl.com.multitem;

import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/6/12.
 */

public class UserDelegate  implements  ItemDataDelegates<User> {


    @Override
    public int getItemType(List list, int position) {
         if(!list.isEmpty()&&list.get(position) instanceof  User)
           return R.layout.item_user;
        throw new IllegalArgumentException("No layout item ");
    }

    @Override
    public Class getItemDataClass() {
        return User.class;
    }

    @Override
    public  void handlerWayForItem(User user, BaseRecyclerAdapter.BaseViewHolder holder, int position) {
        TextView tvUser =  holder.getView(R.id.tv_user);
        tvUser.setText(user.getAge()+"   "+user.getName());
    }
}
