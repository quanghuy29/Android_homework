package com.example.inputdata;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    boolean isEnoughData;
    EditText text_name, text_mssv, text_cccd, text_phone, text_email, text_birthday, text_address, text_hometown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isEnoughData = false;
        text_name = findViewById(R.id.textinput_name);
        text_mssv = findViewById(R.id.textinput_mssv);
        text_cccd = findViewById(R.id.textinput_cccd);
        text_phone = findViewById(R.id.textinput_phone);
        text_email = findViewById(R.id.textinput_email);
        text_birthday = findViewById(R.id.textinput_bd);
        text_address = findViewById(R.id.textinput_address);
        text_hometown = findViewById(R.id.textinput_hometown);

        Button btn_ok = findViewById(R.id.btn_ok);
        btn_ok.setEnabled(false);
        btn_ok.setOnClickListener(view -> {
            if (!checkEmpty()){
                Toast toast = Toast.makeText(MainActivity.this, "Chưa nhập đầy đủ thông tin!", Toast.LENGTH_SHORT);
                toast.show();
            }
            else {
                Toast toast = Toast.makeText(MainActivity.this, "Nhập thông tin thành công!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                String date = day + "/" + month + "/" + year;
                text_birthday.setText(date);
            }
        });
        calendarView.setVisibility(CalendarView.GONE);

        ImageButton calendar = findViewById(R.id.btn_day);
        calendar.setOnClickListener(view -> {
            if (calendarView.getVisibility() == CalendarView.GONE) {
                calendarView.setVisibility(CalendarView.VISIBLE);
                calendarView.bringToFront();
            }
            else {
                calendarView.setVisibility(CalendarView.GONE);
            }
        });



        CheckBox cb_agree = findViewById(R.id.cb_agree);
        cb_agree.setOnCheckedChangeListener((compoundButton, isChecked) -> btn_ok.setEnabled(isChecked));
    }
    public boolean checkEmpty(){
        if (TextUtils.isEmpty(text_email.getText().toString()) || TextUtils.isEmpty(text_mssv.getText().toString())
        || TextUtils.isEmpty(text_cccd.getText().toString()) || TextUtils.isEmpty(text_phone.getText().toString())
        || TextUtils.isEmpty(text_name.getText().toString())) {
            if (TextUtils.isEmpty(text_email.getText().toString())) text_email.setBackgroundResource(R.drawable.border_red);
            else text_email.setBackgroundResource(R.drawable.border_white);

            if (TextUtils.isEmpty(text_mssv.getText().toString())) text_mssv.setBackgroundResource(R.drawable.border_red);
            else text_mssv.setBackgroundResource(R.drawable.border_white);

            if (TextUtils.isEmpty(text_cccd.getText().toString())) text_cccd.setBackgroundResource(R.drawable.border_red);
            else text_cccd.setBackgroundResource(R.drawable.border_white);

            if (TextUtils.isEmpty(text_phone.getText().toString())) text_phone.setBackgroundResource(R.drawable.border_red);
            else text_phone.setBackgroundResource(R.drawable.border_white);

            if (TextUtils.isEmpty(text_name.getText().toString())) text_name.setBackgroundResource(R.drawable.border_red);
            else text_name.setBackgroundResource(R.drawable.border_white);

            isEnoughData = false;
            return false;
        }
        else {
            text_email.setBackgroundResource(R.drawable.border_white);
            text_mssv.setBackgroundResource(R.drawable.border_white);
            text_cccd.setBackgroundResource(R.drawable.border_white);
            text_phone.setBackgroundResource(R.drawable.border_white);
            text_name.setBackgroundResource(R.drawable.border_white);
            isEnoughData = true;
            return true;
        }

    }
}