package com.naxtre.anand.nomainactivitydemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by Anand Vardhan on 10/4/2016.
 */
public class LoginActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton firstButton,secondButton,thirdButton;
    private Button submitButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        radioGroup=(RadioGroup)findViewById(R.id.radio_group);
        submitButton=(Button)findViewById(R.id.submit_button);
        firstButton=(RadioButton)findViewById(R.id.first_button);
        secondButton=(RadioButton)findViewById(R.id.second_button);
        thirdButton=(RadioButton)findViewById(R.id.third_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId=0;
                selectedId=radioGroup.getCheckedRadioButtonId();
                if(selectedId==0){
                    Toast.makeText(LoginActivity.this,"Nothing Selected\nPlease Select Something",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(selectedId==R.id.first_button){
                        Preferences.writeString(LoginActivity.this,"RadioButtonSelected","first");
                        Toast.makeText(LoginActivity.this, "First Button Selected", Toast.LENGTH_SHORT).show();
                    }
                    else if(selectedId==R.id.second_button){
                        Preferences.writeString(LoginActivity.this,"RadioButtonSelected","second");
                        Toast.makeText(LoginActivity.this, "Second Button Selected", Toast.LENGTH_SHORT).show();

                    }
                    else if(selectedId==R.id.third_button){
                        Preferences.writeString(LoginActivity.this,"RadioButtonSelected","third");
                        Toast.makeText(LoginActivity.this, "Third Button Selected", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
