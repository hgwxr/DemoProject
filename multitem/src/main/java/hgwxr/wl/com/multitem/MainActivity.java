package hgwxr.wl.com.multitem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)  RecyclerView mRecycler;
    @BindView(R.id.tv_bootom)
    TextView tvBootom;
    private List list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mRecycler = ((RecyclerView) findViewById(R.id.recycler_view));
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList();
        initData();
        MultAdapter multAdapter = new MultAdapter(this);
        mRecycler.setAdapter(multAdapter);
        mRecycler.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        HashMap<Class, ItemDataDelegates> itemDataDelegates = new HashMap<>();
        itemDataDelegates.put(User.class,new UserDelegate());
        itemDataDelegates.put(Member.class,new MemberDelegate());
        multAdapter.addItemDelegate(itemDataDelegates);
        multAdapter.addAll(list);
    }

    private void initData() {
        User user = new User();
        user.setAge("18");
        user.setName("bob");
        list.add(user);
        Member member = new Member();
        member.setAge("20");
        member.setName("tom");
        member.setMember(true);
        member.setUserPrivilege(" speak ,talk,play");
        list.add(member);
    }
}
