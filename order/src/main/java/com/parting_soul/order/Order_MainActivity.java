package com.parting_soul.order;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.parting_soul.annoation.ARouter;
import com.parting_soul.arouter_common.RecordManager;

@ARouter(group = "order", path = "/Order_MainActivity")
public class Order_MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_activity_main);
    }

    public void jumpToIndex(View view) {
        Class<?> clazz = RecordManager.getInstance().getTargetClass("app", "MainActivity");
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    public void jumpToPersonal(View v) {
        Class<?> clazz = RecordManager.getInstance().getTargetClass("personal", "Personal_MainActivity");
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

}
