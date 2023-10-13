package com.example.testing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private char currentSymbol;
    private DecimalFormat decimalFormat;
    private TextView operacion, numbers;
    private double firstValue = Double.NaN;
    private double secondValue;
    private MaterialButton btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,
            button_sum, button_res, button_div, button_mul, button_clear, button_fin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operacion = findViewById(R.id.oper);
        numbers = findViewById(R.id.numbers);

        btn0 = findViewById(R.id.button_0);
        btn1 = findViewById(R.id.button_1);
        btn2 = findViewById(R.id.button_2);
        btn3 = findViewById(R.id.button_3);
        btn4 = findViewById(R.id.button_4);
        btn5 = findViewById(R.id.button_5);
        btn6 = findViewById(R.id.button_6);
        btn7 = findViewById(R.id.button_7);
        btn8 = findViewById(R.id.button_8);
        btn9 = findViewById(R.id.button_9);

        button_sum = findViewById(R.id.button_sum);
        button_res = findViewById(R.id.button_res);
        button_div = findViewById(R.id.button_div);
        button_mul = findViewById(R.id.button_mul);
        button_clear = findViewById(R.id.button_clear);
        button_fin = findViewById(R.id.button_fin);

        // Set up click listeners for buttons
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion.setText(operacion.getText() + "0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion.setText(operacion.getText() + "1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion.setText(operacion.getText() + "2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion.setText(operacion.getText() + "3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion.setText(operacion.getText() + "4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion.setText(operacion.getText() + "5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion.setText(operacion.getText() + "6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion.setText(operacion.getText() + "7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion.setText(operacion.getText() + "8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion.setText(operacion.getText() + "9");
            }
        });
        button_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = ADDITION;
                numbers.setText(decimalFormat.format(firstValue) + "+");
                operacion.setText(null);
            }
        });
        button_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = SUBTRACTION;
                numbers.setText(decimalFormat.format(firstValue) + "-");
                operacion.setText(null);
            }
        });
        button_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = MULTIPLICATION;
                numbers.setText(decimalFormat.format(firstValue) + "x");
                operacion.setText(null);
            }
        });
        button_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = DIVISION;
                numbers.setText(decimalFormat.format(firstValue) + "/");
                operacion.setText(null);
            }
        });
        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operacion.getText().length() > 0) {
                    CharSequence currentText = operacion.getText();
                    operacion.setText(currentText.subSequence(0, currentText.length() - 1));
                } else {
                    firstValue = Double.NaN;
                    secondValue = Double.NaN;
                    operacion.setText("");
                    numbers.setText("");
                }
            }
        });
        button_fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                numbers.setText(decimalFormat.format(firstValue));
                firstValue = Double.NaN;
                currentSymbol = '0';
            }
        });
    }

    private void allCalculations(){
        if (!Double.isNaN(firstValue)) {
            secondValue = Double.parseDouble(operacion.getText().toString());
            operacion.setText(null);
            if (currentSymbol == ADDITION)
                firstValue = this.firstValue + secondValue;
            else if (currentSymbol == SUBTRACTION)
                firstValue = this.firstValue - secondValue;
            else if (currentSymbol == MULTIPLICATION)
                firstValue = this.firstValue * secondValue;
            else if (currentSymbol == DIVISION)
                firstValue = this.firstValue / secondValue;
        } else {
            try {
                firstValue = Double.parseDouble(operacion.getText().toString());
            } catch (Exception e) {
            }
        }
    }




}