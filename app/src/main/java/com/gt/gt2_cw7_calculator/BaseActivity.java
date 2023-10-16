package com.gt.gt2_cw7_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity {

    public static List<Activity> activities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activities.add(this);
    }

    public void onDestroy() {

        super.onDestroy();
        activities.remove(this);
    }

    public static void closeAllActivities(){
        for (Activity activity:activities){
           activity.finish();
        }
    }
}