package com.example.statusbar_drawerlayout;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.statusbar_drawerlayout.base.BaseActivity;


public class PlanTwoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_two);

        addStatusBarView();
    }

    private void addStatusBarView() {
        View view = new View(this);
        view.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                getStatusBarHeight(this));

        ViewGroup decorView = (ViewGroup) findViewById(android.R.id.content);

        decorView.addView(view, params);
    }

    public int getStatusBarHeight(Context context) {
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return context.getResources().getDimensionPixelSize(resourceId);
    }
}
