package hgwxr.wl.com.demoproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView) findViewById(R.id.tv_jump)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent = new Intent("task1.action.test");

//                Intent intent = new Intent("app.action.second");

                Intent intent = new Intent("task1.action.main1");
               // intent.addCategory("task1.action.test");
               // Intent intent = new Intent(Main1Activity.this, TestActivity.class);
                startActivity(intent);

            }
        });
    }
}
