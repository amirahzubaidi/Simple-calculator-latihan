package com.example.project7;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText num1, num2;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hubungkan komponen dengan ID di layout
        num1 = findViewById(R.id.inputNumber1);
        num2 = findViewById(R.id.inputNumber2);
        result = findViewById(R.id.resultText);

        Button addButton = findViewById(R.id.addButton);
        Button subtractButton = findViewById(R.id.subtractButton);
        Button multiplyButton = findViewById(R.id.multiplyButton);
        Button divideButton = findViewById(R.id.divideButton);

        // Logika untuk tombol operasi
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("add");
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("subtract");
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("multiply");
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("divide");
            }
        });

    }

    private void calculate(String operation) {
        String num1Text = num1.getText().toString();
        String num2Text = num2.getText().toString();

        if (num1Text.isEmpty() || num2Text.isEmpty()) {
            result.setText("Please enter both numbers");
            return;
        }

        double number1 = Double.parseDouble(num1Text);
        double number2 = Double.parseDouble(num2Text);
        double calculationResult;

        switch (operation) {
            case "add":
                calculationResult = number1 + number2;
                break;
            case "subtract":
                calculationResult = number1 - number2;
                break;
            case "multiply":
                calculationResult = number1 * number2;
                break;
            case "divide":
                if (number2 == 0) {
                    result.setText("Cannot divide by zero");
                    return;
                }
                calculationResult = number1 / number2;
                break;
            default:
                calculationResult = 0;
        }

        result.setText("Result: " + calculationResult);
    }
}