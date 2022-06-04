package com.example.currency;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Spinner[] spinner_cur = new Spinner[2];
    TextView[] viewCur = new TextView[2];
    String[] textShow = new String[2];
    float[] number = new float[2];
    Button[] btn_number = new Button[10];
    float[] exchange = new float[2];
    int[] id_btn;
    int[] id_view;
    int[] id_spinner;
    Button btn_del, btn_point, btn_ce;
    int selected, notSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SetUpArray();
        SetupView();
        SetupSpinner();
        SetViewCur(0, 1);
    }

    private void SetupView(){
        for(int i = 0; i < spinner_cur.length; i++){
            spinner_cur[i] = (Spinner) findViewById(id_spinner[i]);
        }
        for(int i = 0; i < viewCur.length; i++){
            viewCur[i] = findViewById(id_view[i]);
            viewCur[i].setOnClickListener(this);
        }
        for(int i = 0; i < btn_number.length; i++){
            btn_number[i] = findViewById(id_btn[i]);
            btn_number[i].setOnClickListener(this);
        }
        btn_del = findViewById(R.id.button_del);
        btn_del.setOnClickListener(this);
        btn_point = findViewById(R.id.button_point);
        btn_point.setOnClickListener(this);
        btn_ce = findViewById(R.id.button_ce);
        btn_ce.setOnClickListener(this);
    }

    private void SetupSpinner(){
        Currency[] currencies = CurrencyData.getCurrency();
        String[] name = new String[currencies.length];
        for(int i = 0; i < currencies.length; i++){
            name[i] = currencies[i].getName();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, name);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_cur[0].setAdapter(adapter);
        spinner_cur[0].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                exchange[0] = currencies[i].getValue();
                CalculateCurrency(textShow[selected]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        spinner_cur[1].setAdapter(adapter);
        spinner_cur[1].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                exchange[1] = currencies[i].getValue();
                CalculateCurrency(textShow[selected]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void SetUpArray(){
        id_btn = new int[]{R.id.button_0, R.id.button_1, R.id.button_2, R.id.button_3, R.id.button_4,
                R.id.button_5, R.id.button_6, R.id.button_7, R.id.button_8, R.id.button_9};
        id_view = new int[]{R.id.view_cur1, R.id.view_cur2};
        id_spinner = new int[]{R.id.spinner_currency1, R.id.spinner_currency2};
        Arrays.fill(textShow, "0");
    }

    private void SetViewCur(int indSelected, int indNot){
        viewCur[indSelected].setTypeface(Typeface.DEFAULT_BOLD);
        viewCur[indNot].setTypeface(Typeface.DEFAULT);
        selected = indSelected;
        notSelected = indNot;
    }
    @Override
    public void onClick(View view) {
        if (view.getId() == id_view[0]) { SetViewCur(0, 1);}
        if (view.getId() == id_view[1]) { SetViewCur(1, 0);}
        for(int i = 0; i < id_btn.length; i++){
            if (view.getId() == id_btn[i])
                SetTextFromNum(Integer.toString(i));
        }
        if(view.getId() == R.id.button_ce) Btn_ce();
        if(view.getId() == R.id.button_del) Btn_del();
        if(view.getId() == R.id.button_point) Btn_point();
    }

    private void Btn_point() {
        if(textShow[selected].contains(".")) return;
        textShow[selected] += ".";
        viewCur[selected].setText(textShow[selected]);
        CalculateCurrency(textShow[selected]);
    }

    private void Btn_del() {
        if (textShow[selected].length() == 1) textShow[selected] = "0";
        else textShow[selected] = textShow[selected].substring(0, textShow[selected].length() - 1);
        CalculateCurrency(textShow[selected]);
        number[selected] = Float.parseFloat(textShow[selected]);
        viewCur[selected].setText(textShow[selected]);
    }

    private void Btn_ce() {
        textShow[selected] = "0";
        viewCur[selected].setText(textShow[selected]);
        CalculateCurrency(textShow[selected]);
    }

    private void SetTextFromNum(String num){
        if(textShow[selected].equals("0")) textShow[selected] = num;
        else {
            textShow[selected] += num;
        }
        number[selected] = Float.parseFloat(textShow[selected]);
        viewCur[selected].setText(textShow[selected]);
        CalculateCurrency(textShow[selected]);
    }

    private void CalculateCurrency(String num){
        number[selected] = Float.parseFloat(num);
        number[notSelected] = number[selected] * exchange[notSelected] / exchange[selected];
        if(number[notSelected] == (int) number[notSelected]){
            textShow[notSelected] = Integer.toString((int)number[notSelected]);
            viewCur[notSelected].setText(textShow[notSelected]);
        }
        else {
            textShow[notSelected] = Float.toString(number[notSelected]);
            viewCur[notSelected].setText(textShow[notSelected]);
        }
    }
}