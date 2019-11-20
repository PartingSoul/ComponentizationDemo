package com.parting_soul.personal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.parting_soul.arouter_common.RecordManager;

public class Personal_MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_activity_main);
    }

    public void jumpToIndex(View view) {
        Class<?> clazz = RecordManager.getInstance().getTargetClass("app", "MainActivity");
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    public void jumpToOrder(View v) {
        Class<?> clazz = RecordManager.getInstance().getTargetClass("order", "Order_MainActivity");
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

}
