package com.parting_soul.componentizationdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.parting_soul.annoation.ARouter;
import com.parting_soul.arouter_common.RecordManager;

@ARouter(group = "app", path = "MainActivity")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void jumpToOrder(View view) {
        Class<?> clazz = RecordManager.getInstance().getTargetClass("order", "Order_MainActivity");
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    public void jumpToPersonal(View view) {
//        try {
//            Class<?> clazz = Class.forName("com.parting_soul.personal.Personal_MainActivity");
//            Intent intent = new Intent(this, clazz);
//            startActivity(intent);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

//        Class<?> clazz = RecordManager.getInstance().getTargetClass("personal", "Personal_MainActivity");
//        Intent intent = new Intent(this, clazz);
//        startActivity(intent);

        com.parting_soul.componentizationdemo.SecondActivity$ARouter aRouter = new com.parting_soul.componentizationdemo.SecondActivity$ARouter();
        Class<?> clazz = aRouter.geTargetClass();
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

}
