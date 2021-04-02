package com.example.marragesuggestion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        // TextView物件
    private TextView mTxtResult;
    // Button物件
    private Button mBtnDo;
    // RadioGroup物件
    private RadioGroup mRadGrpGender, mRadGrpAge;
    // RadioButton物件
    private RadioButton mRadBtnAge1 , mRadBtnAge2, mRadBtnAge3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 連結介面元件
        mTxtResult = findViewById(R.id.textResult);
        mBtnDo = findViewById(R.id.btnDo);

        // 設定按鈕觸發事件
        mBtnDo.setOnClickListener(btnDoOnClick);


        mRadGrpGender = findViewById(R.id.radGrpGender);
        mRadGrpAge = findViewById(R.id.radGrpAge);
        mRadBtnAge1 = findViewById(R.id.radBtnAge1);
        mRadBtnAge2 = findViewById(R.id.radBtnAge2);
        mRadBtnAge3 = findViewById(R.id.radBtnAge3);

        mRadGrpGender.setOnCheckedChangeListener(radGrpGenderOnCheckedChage);
    }
    private View.OnClickListener btnDoOnClick = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            // 從字串資源取出預先定義好的suggestion字串
            String suggestion = getString(R.string.suggestion);

            switch(mRadGrpAge.getCheckedRadioButtonId()){
                case R.id.radBtnAge1 :
                    suggestion+= getString(R.string.not_hurry);
                    break;
                case R.id.radBtnAge2 :
                    suggestion += getString(R.string.find_couple);
                    break;
                case R.id.radBtnAge3:
                    suggestion += getString(R.string.get_married);
                    break;
            }
            // 輸出結果
            mTxtResult.setText(suggestion);
        }
    };

    private RadioGroup.OnCheckedChangeListener radGrpGenderOnCheckedChage = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radionGroup, int checkedId) {
            if(checkedId == R.id.radBtnMale){
                mRadBtnAge1.setText(R.string.radbtn_male_age1);
                mRadBtnAge2.setText(R.string.radbtn_male_age2);
                mRadBtnAge3.setText(R.string.radbtn_male_age3);
            } else {
                mRadBtnAge1.setText(R.string.radbtn_female_age1);
                mRadBtnAge2.setText(R.string.radbtn_female_age2);
                mRadBtnAge3.setText(R.string.radbtn_female_age3);
            }
        }
    };
}