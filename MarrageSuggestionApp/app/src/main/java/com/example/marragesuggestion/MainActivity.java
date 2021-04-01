package com.example.marragesuggestion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // EditText物件
    private EditText mEdtGender, mEdtAge;
    // TextView物件
    private TextView mTxtResult;
    // Button物件
    private Button mBtnDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 連結介面元件
        mEdtGender = findViewById(R.id.edtGender);
        mEdtAge = findViewById(R.id.edtAge);
        mTxtResult = findViewById(R.id.textResult);
        mBtnDo = findViewById(R.id.btnDo);

        // 設定按鈕觸發事件
        mBtnDo.setOnClickListener(btnDoOnClick);
    }
    private View.OnClickListener btnDoOnClick = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            // 取得性別和年齡
            String sex = mEdtGender.getText().toString();
            int age = Integer.parseInt(mEdtAge.getText().toString());
            // 從字串資源取出預先定義好的suggestion字串
            String suggestion = getString(R.string.suggestion);

            //判斷性別
            if(sex.equals(R.string.male)){
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
}