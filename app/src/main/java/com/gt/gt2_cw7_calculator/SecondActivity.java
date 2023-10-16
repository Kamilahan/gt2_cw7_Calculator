package com.gt.gt2_cw7_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btnDestroy = findViewById(R.id.secondA_btn_destroy);

        TextView tv = findViewById(R.id.tv_resultFromMainA);
        String receivedResult = getIntent().getStringExtra("textKey");

        if (receivedResult != null) {
            tv.setText(receivedResult);
        }

        btnDestroy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseActivity.closeAllActivities();
            }
        });
    }
}