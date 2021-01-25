package com.example.calculatechermyanin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String oldNumber = "";
    private String operationSign = "+";
    private TextView mResultTv;
    private boolean newEnter = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mResultTv = findViewById(R.id.resultTv);

    }
    public void writeNumbers(View view) {
        if (newEnter) {
            mResultTv.setText("");
            newEnter = false;
        }
        String number = mResultTv.getText().toString();
        switch (view.getId()){
            case R.id.changeSignBtn:
                number = "-" + number;
                break;
            case R.id.decimalBtn:
                number += ".";
                break;
            case R.id.zeroBtn:
                number += "0";
                break;
            case R.id.oneBtn:
                number += "1";
                break;
            case R.id.twoBtn:
                number += "2";
                break;
            case R.id.threeBtn:
                number += "3";
                break;
            case R.id.fourBtn:
                number += "4";
                break;
            case R.id.fiveBtn:
                number += "5";
                break;
            case R.id.sixBtn:
                number += "6";
                break;
            case R.id.sevenBtn:
                number +="7";
                break;
            case R.id.eightBtn:
                number += "8";
                break;
            case R.id.nineBtn:
                number += "9";
                break;
        }
        mResultTv.setText(number);
    }

    public void countOperation(View view) {
        newEnter = true;
        oldNumber = mResultTv.getText().toString();
        switch (view.getId()) {
            case R.id.divisionBtn:
                operationSign = "/";
                break;
            case R.id.multiBtn:
                operationSign = "*";
                break;
            case R.id.plusBtn:
                operationSign = "+";
                break;
            case R.id.minusBtn:
                operationSign = "-";
                break;
        }
    }

    public void opEqual(View view) {
        String newNumber = mResultTv.getText().toString();
        double result = 0.0;
        switch (operationSign) {
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                break;
        }
        mResultTv.setText(result+"");
    }

    public void clearField(View view) {
        mResultTv.setText("0");
        newEnter = true;
    }

    public void countPercent(View view) {
        double percent = Double.parseDouble(mResultTv.getText().toString())/100;
        mResultTv.setText(percent+"");
        newEnter = true;
    }
}