package com.example.calculatorpro;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ScientificActivity extends AppCompatActivity {

    TextView display;
    String currentNumber = "";
    String operator = "";
    double firstValue = 0;
    double secondValue = 0;
    boolean isNewOperation = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific);

        display = findViewById(R.id.display);

        // Number buttons
        Button btn0 = findViewById(R.id.btnSci0);
        Button btn1 = findViewById(R.id.btnSci1);
        Button btn2 = findViewById(R.id.btnSci2);
        Button btn3 = findViewById(R.id.btnSci3);
        Button btn4 = findViewById(R.id.btnSci4);
        Button btn5 = findViewById(R.id.btnSci5);
        Button btn6 = findViewById(R.id.btnSci6);
        Button btn7 = findViewById(R.id.btnSci7);
        Button btn8 = findViewById(R.id.btnSci8);
        Button btn9 = findViewById(R.id.btnSci9);
        Button btnDot = findViewById(R.id.btnSciDot);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNewOperation) {
                    currentNumber = "";
                    isNewOperation = false;
                }
                currentNumber += "0";
                display.setText(currentNumber);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNewOperation) {
                    currentNumber = "";
                    isNewOperation = false;
                }
                currentNumber += "1";
                display.setText(currentNumber);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNewOperation) {
                    currentNumber = "";
                    isNewOperation = false;
                }
                currentNumber += "2";
                display.setText(currentNumber);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNewOperation) {
                    currentNumber = "";
                    isNewOperation = false;
                }
                currentNumber += "3";
                display.setText(currentNumber);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNewOperation) {
                    currentNumber = "";
                    isNewOperation = false;
                }
                currentNumber += "4";
                display.setText(currentNumber);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNewOperation) {
                    currentNumber = "";
                    isNewOperation = false;
                }
                currentNumber += "5";
                display.setText(currentNumber);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNewOperation) {
                    currentNumber = "";
                    isNewOperation = false;
                }
                currentNumber += "6";
                display.setText(currentNumber);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNewOperation) {
                    currentNumber = "";
                    isNewOperation = false;
                }
                currentNumber += "7";
                display.setText(currentNumber);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNewOperation) {
                    currentNumber = "";
                    isNewOperation = false;
                }
                currentNumber += "8";
                display.setText(currentNumber);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNewOperation) {
                    currentNumber = "";
                    isNewOperation = false;
                }
                currentNumber += "9";
                display.setText(currentNumber);
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNewOperation) {
                    currentNumber = "";
                    isNewOperation = false;
                }
                if (!currentNumber.contains(".")) {
                    if (currentNumber.isEmpty()) {
                        currentNumber = "0.";
                    } else {
                        currentNumber += ".";
                    }
                    display.setText(currentNumber);
                }
            }
        });

        // Basic operator buttons
        Button btnAdd = findViewById(R.id.btnSciAdd);
        Button btnSubtract = findViewById(R.id.btnSciSubtract);
        Button btnMultiply = findViewById(R.id.btnSciMultiply);
        Button btnDivide = findViewById(R.id.btnSciDivide);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentNumber.isEmpty()) {
                    firstValue = Double.parseDouble(currentNumber);
                    operator = "+";
                    currentNumber = "";
                    isNewOperation = false;
                }
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentNumber.isEmpty()) {
                    firstValue = Double.parseDouble(currentNumber);
                    operator = "-";
                    currentNumber = "";
                    isNewOperation = false;
                }
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentNumber.isEmpty()) {
                    firstValue = Double.parseDouble(currentNumber);
                    operator = "×";
                    currentNumber = "";
                    isNewOperation = false;
                }
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentNumber.isEmpty()) {
                    firstValue = Double.parseDouble(currentNumber);
                    operator = "÷";
                    currentNumber = "";
                    isNewOperation = false;
                }
            }
        });

        // Scientific function buttons
        Button btnSin = findViewById(R.id.btnSciSin);
        Button btnCos = findViewById(R.id.btnSciCos);
        Button btnTan = findViewById(R.id.btnSciTan);
        Button btnLog = findViewById(R.id.btnSciLog);
        Button btnLn = findViewById(R.id.btnSciLn);
        Button btnSqrt = findViewById(R.id.btnSciSqrt);
        Button btnSquare = findViewById(R.id.btnSciSquare);
        Button btnPi = findViewById(R.id.btnSciPi);
        Button btnE = findViewById(R.id.btnSciE);

        btnSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentNumber.isEmpty()) {
                    double value = Double.parseDouble(currentNumber);
                    double result = Math.sin(Math.toRadians(value));
                    display.setText(String.valueOf(result));
                    currentNumber = String.valueOf(result);
                }
            }
        });

        btnCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentNumber.isEmpty()) {
                    double value = Double.parseDouble(currentNumber);
                    double result = Math.cos(Math.toRadians(value));
                    display.setText(String.valueOf(result));
                    currentNumber = String.valueOf(result);
                }
            }
        });

        btnTan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentNumber.isEmpty()) {
                    double value = Double.parseDouble(currentNumber);
                    double result = Math.tan(Math.toRadians(value));
                    display.setText(String.valueOf(result));
                    currentNumber = String.valueOf(result);
                }
            }
        });

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentNumber.isEmpty()) {
                    double value = Double.parseDouble(currentNumber);
                    double result = Math.log10(value);
                    display.setText(String.valueOf(result));
                    currentNumber = String.valueOf(result);
                }
            }
        });

        btnLn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentNumber.isEmpty()) {
                    double value = Double.parseDouble(currentNumber);
                    double result = Math.log(value);
                    display.setText(String.valueOf(result));
                    currentNumber = String.valueOf(result);
                }
            }
        });

        btnSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentNumber.isEmpty()) {
                    double value = Double.parseDouble(currentNumber);
                    double result = Math.sqrt(value);
                    display.setText(String.valueOf(result));
                    currentNumber = String.valueOf(result);
                }
            }
        });

        btnSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentNumber.isEmpty()) {
                    double value = Double.parseDouble(currentNumber);
                    double result = value * value;
                    display.setText(String.valueOf(result));
                    currentNumber = String.valueOf(result);
                }
            }
        });

        btnPi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNumber = String.valueOf(Math.PI);
                display.setText(currentNumber);
            }
        });

        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNumber = String.valueOf(Math.E);
                display.setText(currentNumber);
            }
        });

        // AC button
        Button btnAC = findViewById(R.id.btnSciAC);
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNumber = "";
                operator = "";
                firstValue = 0;
                secondValue = 0;
                display.setText("0");
                isNewOperation = true;
            }
        });

        // Equals button
        Button btnEquals = findViewById(R.id.btnSciEquals);
        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentNumber.isEmpty() && !operator.isEmpty()) {
                    secondValue = Double.parseDouble(currentNumber);
                    double result = 0;

                    if (operator.equals("+")) {
                        result = firstValue + secondValue;
                    } else if (operator.equals("-")) {
                        result = firstValue - secondValue;
                    } else if (operator.equals("×")) {
                        result = firstValue * secondValue;
                    } else if (operator.equals("÷")) {
                        if (secondValue != 0) {
                            result = firstValue / secondValue;
                        } else {
                            display.setText("Error");
                            currentNumber = "";
                            operator = "";
                            return;
                        }
                    }

                    display.setText(String.valueOf(result));
                    currentNumber = String.valueOf(result);
                    operator = "";
                }
            }
        });

        // Back button
        Button btnBack = findViewById(R.id.btnSciBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}