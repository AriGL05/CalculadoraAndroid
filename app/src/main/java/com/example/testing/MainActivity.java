package com.example.testing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText resultado;
    private StringBuilder input;

    TextView numbers, operacion;
    Button button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8,button_9,
            button_sum, button_res, button_div, button_mul, button_clear, button_fin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado = findViewById(R.id.numbers);
        input = new StringBuilder();

        // Set up click listeners for buttons
        setupButtonClickListeners();
    }

    private void setupButtonClickListeners() {
        // Find and set click listeners for digit buttons (0-9)
        for (int i = 0; i <= 9; i++) {
            int resId = getResources().getIdentifier("button" + i, "id", getPackageName());
            Button button = findViewById(resId);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button clickedButton = (Button) view;
                    input.append(clickedButton.getText().toString());
                    resultado.setText(input.toString());
                }
            });
        }
    }



    @Override
    public void onClick(View view) {
        Button btn = (Button) view;
        String btnText = btn.getText().toString();
        operacion.setText(btnText);
    }
}