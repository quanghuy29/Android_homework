package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView resView, subView;
    String res, sub = "", secondSub = "";
    boolean isSecondNum, isDone;
    int stateOperator, oldOperator;
    int numFirst, numLast, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isSecondNum = false;
        isDone = false;
        stateOperator = 0;
        resView = findViewById(R.id.result);
        subView = findViewById(R.id.result_sub);

        Button btn_switch = findViewById(R.id.button_switch);
        Button btn_zero = findViewById(R.id.button_zero);
        Button btn_one = findViewById(R.id.button_one);
        Button btn_two = findViewById(R.id.button_two);
        Button btn_three = findViewById(R.id.button_three);
        Button btn_four = findViewById(R.id.button_four);
        Button btn_five = findViewById(R.id.button_five);
        Button btn_six = findViewById(R.id.button_six);
        Button btn_seven = findViewById(R.id.button_seven);
        Button btn_eight = findViewById(R.id.button_eight);
        Button btn_nine = findViewById(R.id.button_nine);
        Button btn_plus = findViewById(R.id.button_plus);
        Button btn_minus = findViewById(R.id.button_minus);
        Button btn_point = findViewById(R.id.button_point);
        Button btn_ce = findViewById(R.id.button_ce);
        Button btn_c = findViewById(R.id.button_c);
        Button btn_del = findViewById(R.id.button_delete);
        Button btn_equal = findViewById(R.id.button_square);
        Button btn_mul = findViewById(R.id.button_multi);
        Button btn_div = findViewById(R.id.button_divide);

        btn_switch.setOnClickListener(this);
        btn_zero.setOnClickListener(this);
        btn_one.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_three.setOnClickListener(this);
        btn_four.setOnClickListener(this);
        btn_five.setOnClickListener(this);
        btn_six.setOnClickListener(this);
        btn_seven.setOnClickListener(this);
        btn_eight.setOnClickListener(this);
        btn_nine.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_ce.setOnClickListener(this);
        btn_div.setOnClickListener(this);
        btn_c.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_zero:
                Btn_zero();
                break;
            case R.id.button_one:
                Btn_one();
                break;
            case R.id.button_two:
                Btn_two();
                break;
            case R.id.button_three:
                Btn_three();
                break;
            case R.id.button_four:
                Btn_four();
                break;
            case R.id.button_five:
                Btn_five();
                break;
            case R.id.button_six:
                Btn_six();
                break;
            case R.id.button_seven:
                Btn_seven();
                break;
            case R.id.button_eight:
                Btn_eight();
                break;
            case R.id.button_nine:
                Btn_nine();
                break;
            case R.id.button_plus:
                Btn_plus();
                break;
            case R.id.button_minus:
                Btn_minus();
                break;
            case R.id.button_multi:
                Btn_multi();
                break;
            case R.id.button_divide:
                Btn_divide();
                break;
            case R.id.button_square:
                Btn_equal();
                break;
            case R.id.button_c:
                Btn_c();
                break;
            case R.id.button_point:
                Btn_point();
                break;
            case R.id.button_delete:
                Btn_del();
                break;
            case R.id.button_ce:
                Btn_ce();
                break;
            case R.id.button_switch:
                Btn_switch();
                break;

        }
    }

    private void Btn_switch() {
        if (isDone) {
            result = -result;
            res = Integer.toString(result);
            sub = res;
            resView.setText(res);
            subView.setText(sub);
        }
        else if (isSecondNum && !secondSub.equals("")) {
            numLast = Integer.parseInt(secondSub);
            numLast = -numLast;
            sub = sub.substring(0, sub.length() - secondSub.length());
            secondSub = Integer.toString(numLast);
            sub += secondSub;
            subView.setText(sub);
        }
        else if (!isSecondNum){
            numFirst = Integer.parseInt(sub);
            numFirst = -numFirst;
            sub = Integer.toString(numFirst);
            subView.setText(sub);
        }
    }

    private void Btn_ce() {
        if (isSecondNum) {
            sub = sub.substring(0, sub.length() - secondSub.length());
            secondSub = "";
            subView.setText(sub);
        } else if (isDone){
            isDone = false;
            isSecondNum = true;
            sub = sub.substring(0, sub.length() - secondSub.length());
            secondSub = "";
            subView.setText(sub);
            stateOperator = oldOperator;
        }
    }

    private void Btn_del() {
        if (!isDone){
            if (sub.length() == 1){
                sub = "0";
            } else {
                if (isSecondNum && secondSub.length() > 0){
                    secondSub = secondSub.substring(0, secondSub.length() - 1);
                    sub = sub.substring(0, sub.length() - 1);
                } else if (isSecondNum) {
                    isSecondNum = false;
                    sub = sub.substring(0, sub.length() - 3);
                }
                else {
                    sub = sub.substring(0, sub.length() - 1);
                }
            }
        } else {
            sub = "0";
            secondSub = "";
            isDone = false;
            isSecondNum = false;
        }
        subView.setText(sub);
    }

    private void Btn_point() {
    }

    private void Btn_c() {
        sub = "0";
        secondSub = "";
        isDone = false;
        isSecondNum = false;
        subView.setText(sub);
    }

    private void Btn_equal() {
        if (isDone) return;

        if (isSecondNum)
        {
            isSecondNum = false;
            isDone = true;
            if (secondSub.equals("")) numLast = numFirst;
            else numLast = Integer.parseInt(secondSub);
            switch (stateOperator){
                case 1:
                    result = numFirst + numLast;
                    break;
                case 2:
                    result = numFirst - numLast;
                    break;
                case 3:
                    result = numFirst * numLast;
                    break;
                case 4:
                    result = numFirst / numLast;
                    break;
            }
            stateOperator = 0;
            res = Integer.toString(result);
            resView.setText(res);
        }
        else {
            isDone = true;
            resView.setText(sub);
        }
    }

    private void Btn_divide() { SetTextFromOperator(4, " / "); }

    private void Btn_multi() { SetTextFromOperator(3, " x "); }

    private void Btn_minus() { SetTextFromOperator(2, " - "); }

    private void Btn_plus() { SetTextFromOperator(1, " + "); }

    private void Btn_nine() {
        SetTextFromNum("9");
    }

    private void Btn_eight() {
        SetTextFromNum("8");
    }

    private void Btn_seven() {
        SetTextFromNum("7");
    }

    private void Btn_six() {
        SetTextFromNum("6");
    }

    private void Btn_five() {
        SetTextFromNum("5");
    }

    private void Btn_four() {
        SetTextFromNum("4");
    }

    private void Btn_three() {
        SetTextFromNum("3");
    }

    private void Btn_two() {
        SetTextFromNum("2");
    }

    private void Btn_one() {
        SetTextFromNum("1");
    }

    private void Btn_zero() {
        SetTextFromNum("0");
    }

    private void SetTextFromNum(String num){
        if (!isDone)
        {
            if (sub.equals("0")) sub = num;
            else if (isSecondNum && secondSub.equals("0")) {
                sub = sub.substring(0, sub.length() - 1);
                sub += num;
                secondSub += num;
            }
            else {
                sub += num;
                if (isSecondNum) secondSub += num;
            }
        } else {
            sub = "";
            secondSub = "";
            sub += num;
            isSecondNum = false;
            isDone = false;
        }
        subView.setText(sub);
    }

    private void SetTextFromOperator(int num, String operator){
        if (!isSecondNum) {
            stateOperator = num;
            oldOperator = num;
            isSecondNum = true;
            if (!isDone) numFirst = Integer.parseInt(sub);
            else {
                isDone = false;
                numFirst = result;
                secondSub = "";
                sub = Integer.toString(numFirst);
            }
        }
        else if (secondSub.equals("")) {
            stateOperator = num;
            oldOperator = num;
            sub = sub.substring(0, sub.length() - 3);
        }
        else {
            Btn_equal();
            stateOperator = num;
            oldOperator = num;
            isDone = false;
            isSecondNum = true;
            secondSub = "";
            numFirst = result;
            res = Integer.toString(result);
            sub = res;
        }
        sub += operator;
        subView.setText(sub);
    }
}