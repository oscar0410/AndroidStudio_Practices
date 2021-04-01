package com.example.marragesuggestion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // EditText物件
    private EditText mEdtAge;
    // TextView物件
    private TextView mTxtResult;
    // Button物件
    private Button mBtnDo;
    // 性別
    private String msGender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 連結介面元件

        mEdtAge = findViewById(R.id.edtAge);
        mTxtResult = findViewById(R.id.textResult);
        mBtnDo = findViewById(R.id.btnDo);

        // 設定按鈕觸發事件
        mBtnDo.setOnClickListener(btnDoOnClick);

        Spinner spnGender = findViewById(R.id.spnGender);

        spnGender.setOnItemSelectedListener(spnGenderOnItemSelected);
    }
    private View.OnClickListener btnDoOnClick = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            // 取得年齡
            int age = Integer.parseInt(mEdtAge.getText().toString());
            // 從字串資源取出預先定義好的suggestion字串
            String suggestion = getString(R.string.suggestion);

            //判斷性別
            if(msGender.equals(getString(R.string.male))){
                if(age<28){
                    suggestion += getString(R.string.not_hurry);
                }else if(age>33){
                    suggestion += getString(R.string.get_married);
                }else{
                    suggestion += getString(R.string.find_couple);
                }
            }else{
                if(age<25){
                    suggestion += getString(R.string.not_hurry);
                }else if(age>30){
                    suggestion += getString(R.string.get_married);
                }else{
                    suggestion += getString(R.string.find_couple);
                }
            }

            // 輸出結果
            mTxtResult.setText(suggestion);
        }
    };

    private AdapterView.OnItemSelectedListener spnGenderOnItemSelected = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            switch (position){
                case 0:
                    msGender = getString(R.string.male);
                    break;
                case 1:
                    msGender = "";
                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }

    };
}