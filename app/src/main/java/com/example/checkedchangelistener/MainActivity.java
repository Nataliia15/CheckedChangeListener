package com.example.checkedchangelistener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioButton whiteCatRB,redCatRB;
    private CheckBox colorCB;
    private ImageView catIV;
    private RadioGroup radioGroup;
    private LinearLayout ll;
    private static final String CBOX_STATE="checkBox";
    private static final String RADIO_BUT_RED="radioButtonRed";
    private static final String RADIO_BUT_WHITE="radioButtonWite";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        redCatRB=findViewById(R.id.redCatRB);
        whiteCatRB=findViewById(R.id.whiteCatRB);
        catIV=findViewById(R.id.imageView);
        radioGroup=findViewById(R.id.radioGroup);
        colorCB=findViewById(R.id.checkBox);
        if(savedInstanceState!=null){
            colorCB.setChecked((Boolean) savedInstanceState.get(CBOX_STATE));
            redCatRB.setChecked((Boolean) savedInstanceState.get(RADIO_BUT_RED));
            whiteCatRB.setChecked((Boolean) savedInstanceState.get(RADIO_BUT_WHITE));

            
        }
        ll=findViewById(R.id.linearLayout);
        redCatRB.setChecked(true);
        radioGroup.setOnCheckedChangeListener(this);
        colorCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(colorCB.isChecked()){
                    ll.setBackgroundColor(getResources().getColor(R.color.purple_200));
                }else {
                    ll.setBackgroundColor(getResources().getColor(R.color.white));

                }
            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putBoolean(CBOX_STATE,colorCB.isChecked());
        outState.putBoolean(RADIO_BUT_RED,redCatRB.isChecked());
        outState.putBoolean(RADIO_BUT_WHITE,whiteCatRB.isChecked());

        super.onSaveInstanceState(outState);
    }

    public void changeImage(int id){
       catIV.setImageResource(id);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch(checkedId){
            case R.id.redCatRB:
                changeImage(R.drawable.red_cat);
                break;
            case R.id.whiteCatRB:
                changeImage(R.drawable.white_cat);
                break;

        }
    }
}