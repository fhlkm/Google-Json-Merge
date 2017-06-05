package com.looppay.android.tpd.common;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.looppay.android.tpd.common.service.push.GCMOperation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GCMOperation instance = GCMOperation.getInstance();
                instance.setmActivity(MainActivity.this);
                instance.startCommonGCM();
            }
        });
    }
}
