package com.parting_soul.componentizationdemo;

import android.app.Application;

import com.parting_soul.arouter_common.RecordManager;
import com.parting_soul.order.Order_MainActivity;
import com.parting_soul.personal.Personal_MainActivity;

/**
 * @author parting_soul
 * @date 2019-11-19
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RecordManager.getInstance().addPath("order", "Order_MainActivity", Order_MainActivity.class);
        RecordManager.getInstance().addPath("personal", "Personal_MainActivity", Personal_MainActivity.class);
        RecordManager.getInstance().addPath("app", "MainActivity", MainActivity.class);
    }

}
