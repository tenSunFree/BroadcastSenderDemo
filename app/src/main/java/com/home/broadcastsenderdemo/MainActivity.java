package com.home.broadcastsenderdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    private CheckBox attackPowerCheckBox, defensivePowerCheckBox,
            lightWorkCheckBox, qualificationCheckBox;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializationView();
    }

    /** 初始化View */
    private void initializationView() {
        attackPowerCheckBox = findViewById(R.id.attackPowerCheckBox);
        defensivePowerCheckBox = findViewById(R.id.defensivePowerCheckBox);
        lightWorkCheckBox = findViewById(R.id.lightWorkCheckBox);
        qualificationCheckBox = findViewById(R.id.qualificationCheckBox);
        attackPowerCheckBox.setOnClickListener(onClickListener());
        defensivePowerCheckBox.setOnClickListener(onClickListener());
        lightWorkCheckBox.setOnClickListener(onClickListener());
        qualificationCheckBox.setOnClickListener(onClickListener());
    }

    /** 發送修改各種數值的廣播 */
    @NonNull
    private View.OnClickListener onClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.attackPowerCheckBox:
                        if (attackPowerCheckBox.isChecked()) {
                            intent = new Intent("com.home.broadcastdemo.action.isAttackMax");
                            intent.putExtra("com.home.broadcastdemo.isAttackMax", true);
                            sendBroadcast(intent);
                        } else {
                            intent = new Intent("com.home.broadcastdemo.action.isAttackMax");
                            intent.putExtra("com.home.broadcastdemo.isAttackMax", false);
                            sendBroadcast(intent);
                        }
                        break;
                    case R.id.defensivePowerCheckBox:
                        if (defensivePowerCheckBox.isChecked()) {
                            intent = new Intent("com.home.broadcastdemo.action.isDefensiveMax");
                            intent.putExtra("com.home.broadcastdemo.isDefensiveMax", true);
                            sendBroadcast(intent);
                        } else {
                            intent = new Intent("com.home.broadcastdemo.action.isDefensiveMax");
                            intent.putExtra("com.home.broadcastdemo.isDefensiveMax", false);
                            sendBroadcast(intent);
                        }
                        break;
                    case R.id.lightWorkCheckBox:
                        if (lightWorkCheckBox.isChecked()) {
                            intent = new Intent("com.home.broadcastdemo.action.isLightMax");
                            intent.putExtra("com.home.broadcastdemo.isLightMax", true);
                            sendBroadcast(intent);
                        } else {
                            intent = new Intent("com.home.broadcastdemo.action.isLightMax");
                            intent.putExtra("com.home.broadcastdemo.isLightMax", false);
                            sendBroadcast(intent);
                        }
                        break;
                    case R.id.qualificationCheckBox:
                        if (qualificationCheckBox.isChecked()) {
                            intent = new Intent("com.home.broadcastdemo.action.isQualificationMax");
                            intent.putExtra("com.home.broadcastdemo.isQualificationMax", true);
                            sendBroadcast(intent);
                        } else {
                            intent = new Intent("com.home.broadcastdemo.action.isQualificationMax");
                            intent.putExtra("com.home.broadcastdemo.isQualificationMax", false);
                            sendBroadcast(intent);
                        }
                        break;
                }
            }
        };
    }
}
