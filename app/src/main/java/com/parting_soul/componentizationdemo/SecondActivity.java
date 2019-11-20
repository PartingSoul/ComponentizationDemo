package com.parting_soul.componentizationdemo;

import com.parting_soul.annoation.ARouter;
import com.parting_soul.base.AbstractActivity;

/**
 * @author parting_soul
 * @date 2019-11-19
 */
@ARouter(group = "app", path = "SecondActivity")
public class SecondActivity extends AbstractActivity {
    @Override
    protected int getContentViewId() {
        return 0;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }
}
