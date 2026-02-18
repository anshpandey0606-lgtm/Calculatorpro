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
        setupNumberButton(R.id.btnSci7, "7");
        setupNumberButton(R.id.btnSci8, "8");
        setupNumberButton(R.id.btnSci9, "9");
        setupNumberButton(R.id.btnSci4, "4");
        setupNumberButton(R.id.btnSci5, "5");
        setupNumberButton(R.id.btnSci6, "6");
        setupNumberButton(R.id.btnSci1, "1");
        setupNumberButton(R.id.btnSci2, "2");
        setupNumberButton(R.id.btnSci3, "3");
        setupNumberButton(R.id.btnSci0, "0");
        setupNumberButton(R.id.btnSciDot, ".");

        // Operator buttons
        setupOperatorButton(R.id.btnSciAdd, "+");
        setupOperatorButton(R.id.btnSciSubtract, "-");
        setupOperatorButton(R.id.btnSciMultiply, "×");
        setupOperatorButton(R.id.btnSciDivide, "÷");

        // sin button
        Button btnSin = findViewById(R.id.btnSciSin);
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

        // cos button
        Button btnCos = findViewById(R.id.btnSciCos);
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

        // tan button
        Button btnTan = findViewById(R.id.btnSciTan);
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

        // log button
        Button btnLog = findViewById(R.id.btnSciLog);
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

        // ln button
        Button btnLn = findViewById(R.id.btnSciLn);
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

        // square root button
        Button btnSqrt = findViewById(R.id.btnSciSqrt);
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

        // square button
        Button btnSquare = findViewById(R.id.btnSciSquare);
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

        // pi button
        Button btnPi = findViewById(R.id.btnSciPi);
        btnPi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNumber = String.valueOf(Math.PI);
                display.setText(currentNumber);
            }
        });

        // e button
        Button btnE = findViewById(R.id.btnSciE);
        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNumber = String.valueOf(Math.E);
                display.setText(currentNumber);
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
    }

    private void setupNumberButton(int id, String value) {
        Button btn = findViewById(id);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNewOperation) {
                    currentNumber = "";
                    isNewOperation = false;
                }
                if (value.equals(".")) {
                    if (!currentNumber.contains(".")) {
                        if (currentNumber.isEmpty()) {
                            currentNumber = "0.";
                        } else {
                            currentNumber += ".";
                        }
                    }
                } else {
                    currentNumber += value;
                }
                display.setText(currentNumber);
            }
        });
    }

    private void setupOperatorButton(int id, String op) {
        Button btn = findViewById(id);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentNumber.isEmpty()) {
                    firstValue = Double.parseDouble(currentNumber);
                    operator = op;
                    currentNumber = "";
                    isNewOperation = false;
                }
            }
        });
    }
}