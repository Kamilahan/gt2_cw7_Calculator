package com.gt.gt2_cw7_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends BaseActivity {

  private TextView textView;
 private Integer first, second;
  private boolean isOperationClicked;

   private Button btn_2ndA;


    private String currentOp = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       textView=findViewById(R.id.tv);

        btn_2ndA=findViewById(R.id.btn_2ndA);
      btn_2ndA.setVisibility(View.GONE);

    btn_2ndA.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          String textToPass=textView.getText().toString();
          Intent intent=new Intent(MainActivity.this,SecondActivity.class);
          intent.putExtra("textKey",textToPass);
           startActivity(intent);

        }
    });



    }

    public void onNumberClick(View v) {
        Button button = (Button) v;
        if(v.getId()==R.id.btn_clear){
            textView.setText("0");
            first=0;
              second=0;
        } else{
        String num = button.getText().toString();
            if (isTextViewIsEmpty(textView) || isOperationClicked) {
           textView.setText(num);}
       else{textView.append(num);}
        }
        isOperationClicked=false;

        btn_2ndA.setVisibility(View.GONE);
    }

    public void onOperatorClick(View v) {
        Button button = (Button) v;
        currentOp = button.getText().toString();
        first = Integer.parseInt(textView.getText().toString());
textView.setText("");

        isOperationClicked=true;

        btn_2ndA.setVisibility(View.GONE);
    }

    public void onEqualsClick(View v) {
        second= Integer.parseInt(textView.getText().toString());
        switch(currentOp) {
            case "+":
                textView.setText(String.valueOf(first + second));
                break;
            case "-":
                textView.setText(String.valueOf(first - second));
                break;
            case "x":
                textView.setText(String.valueOf(first * second));
                break;
            case "/":
                textView.setText(String.valueOf(first / second));
                break;
        }
        first = 0;
        currentOp = "";
        isOperationClicked=true;

        btn_2ndA.setVisibility(View.VISIBLE);
    }




    public boolean isTextViewIsEmpty(TextView textView){
        return textView.getText().toString().equals("0");
    }



}

