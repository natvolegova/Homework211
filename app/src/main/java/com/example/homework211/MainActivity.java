package com.example.homework211;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity{
    private EditText mInputMoney;
    private EditText mInputInfo;
    private Button btnOK;
    private CheckBox bankCardChkBx;
    private CheckBox mobilePhoneChkBx;
    private CheckBox cashAddressChkBx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        //переопределяем метод для дальнейшей работы с CheckBox
        CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    switch(compoundButton.getId()){
                        case R.id.bankCardChkBx:
                            resetCheckBoxes();
                            bankCardChkBx.setChecked(true);
                            mInputInfo.setInputType(InputType.TYPE_CLASS_NUMBER);
                            break;
                        case R.id.mobilePhoneChkBx:
                            resetCheckBoxes();
                            mobilePhoneChkBx.setChecked(true);
                            mInputInfo.setInputType(InputType.TYPE_CLASS_PHONE);
                            break;
                        case R.id.cashAddressChkBx:
                            resetCheckBoxes();
                            cashAddressChkBx.setChecked(true);
                            mInputInfo.setInputType(InputType.TYPE_CLASS_TEXT);
                            break;
                    }
                }
            }
        };
        //для каждого CheckBox определяем метод из интерфейса setOnCheckedChangeListener
        bankCardChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mobilePhoneChkBx.setOnCheckedChangeListener(checkedChangeListener);
        cashAddressChkBx.setOnCheckedChangeListener(checkedChangeListener);

        //для кнопки переопределяем свой метод из интерфейса OnClickListener
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = "Сумма: "+ mInputMoney.getText().toString()+ ", информация об оплате: "+mInputInfo.getText().toString();
                Toast.makeText( MainActivity.this, value, Toast.LENGTH_LONG).show();
            }
        });
    }
    //при загрузке экрена определяем все элементы и присваиваем их переменным
    public void initViews(){
        mInputMoney=findViewById(R.id.inputMoney);
        mInputInfo = findViewById(R.id.inputInfo);
        btnOK = findViewById(R.id.btnOK);
        bankCardChkBx = findViewById(R.id.bankCardChkBx);
        mobilePhoneChkBx = findViewById(R.id.mobilePhoneChkBx);
        cashAddressChkBx = findViewById(R.id.cashAddressChkBx);
    }
    //вспомогательный метод, сбрасываем значения всех сheckBox
    public void resetCheckBoxes(){
        bankCardChkBx.setChecked(false);
        mobilePhoneChkBx.setChecked(false);
        cashAddressChkBx.setChecked(false);
    }

}
