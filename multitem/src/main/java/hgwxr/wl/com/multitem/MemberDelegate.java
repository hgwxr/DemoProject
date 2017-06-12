package hgwxr.wl.com.multitem;

import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/6/12.
 */

public class MemberDelegate  implements  ItemDataDelegates<Member> {
    @Override
    public int getItemType(List list, int position) {
        return R.layout.item_user;
    }

    @Override
    public Class getItemDataClass() {
        return Member.class;
    }

    @Override
    public void handlerWayForItem(Member data, BaseRecyclerAdapter.BaseViewHolder holder, int position) {
        TextView tvMemeber =  holder.getView(R.id.tv_user);
             if (data.isMember()){
                // 会员bgm
                 tvMemeber.setBackgroundColor(ContextCompat.getColor(App.getAppContext(),android.R.color.holo_orange_light));
             }
            tvMemeber.setText(data.getAge()+"  "+data.getName()+"\n"+ data.getUserPrivilege());
    }
}
