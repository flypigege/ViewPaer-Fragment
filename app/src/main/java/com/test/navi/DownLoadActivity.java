package com.test.navi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.test.navi.ui.download.DownLoadFragment;

public class DownLoadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.down_load_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container1, DownLoadFragment.newInstance())
                    .commitNow();
        }
    }
}
