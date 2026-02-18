package com.example.calculatorpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView display;
    String currentNumber = "";
    String operator = "";
    double firstValue = 0;
    double secondValue = 0;
    boolean isNewOperation = true;

    // History
    ArrayList<String> historyList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        // ============ NUMBER BUTTONS ============
        Button btn0 = findViewById(R.id.btn0);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);
        Button btnDot = findViewById(R.id.btnDot);

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

        // ============ OPERATOR BUTTONS ============
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnSubtract = findViewById(R.id.btnSubtract);
        Button btnMultiply = findViewById(R.id.btnMultiply);
        Button btnDivide = findViewById(R.id.btnDivide);
        Button btnPercent = findViewById(R.id.btnPercent);

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

        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentNumber.isEmpty()) {
                    double value = Double.parseDouble(currentNumber);
                    double result = value / 100;
                    display.setText(String.valueOf(result));
                    currentNumber = String.valueOf(result);
                    isNewOperation = true;
                }
            }
        });

        // ============ ACTION BUTTONS ============
        Button btnEquals = findViewById(R.id.btnEquals);
        Button btnAC = findViewById(R.id.btnAC);
        Button btnBackspace = findViewById(R.id.btnBackspace);
        Button btnBracket = findViewById(R.id.btnBracket);

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
                            isNewOperation = true;
                            return;
                        }
                    }

                    display.setText(String.valueOf(result));

                    // History mein save
                    String historyEntry = firstValue + " " + operator + " " + secondValue + " = " + result;
                    historyList.add(historyEntry);

                    currentNumber = String.valueOf(result);
                    operator = "";
                    isNewOperation = true;
                }
            }
        });

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

        // Backspace - normal click
        btnBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentNumber.isEmpty()) {
                    currentNumber = currentNumber.substring(0, currentNumber.length() - 1);
                    if (currentNumber.isEmpty()) {
                        display.setText("0");
                    } else {
                        display.setText(currentNumber);
                    }
                }
            }
        });

        // Backspace - long press
        btnBackspace.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                currentNumber = "";
                display.setText("0");
                isNewOperation = true;
                return true;
            }
        });

        btnBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNewOperation) {
                    currentNumber = "(";
                    isNewOperation = false;
                } else {
                    currentNumber += ")";
                }
                display.setText(currentNumber);
            }
        });

        // ============ HISTORY BUTTON ============
        Button btnHistory = findViewById(R.id.btnHistory);

        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (historyList.isEmpty()) {
                    display.setText("No History");
                } else {
                    display.setText(historyList.get(historyList.size() - 1));
                    isNewOperation = true;
                }
            }
        });

        btnHistory.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (historyList.isEmpty()) {
                    display.setText("No History");
                } else {
                    StringBuilder sb = new StringBuilder();
                    for (String h : historyList) {
                        sb.append(h).append("\n");
                    }
                    display.setText(sb.toString());
                    isNewOperation = true;
                }
                return true;
            }
        });

        // ============ SCIENTIFIC BUTTON (ARROW) - SAFE VERSION ============
        Button btnScientific = findViewById(R.id.btnScientific);
        if (btnScientific != null) {
            btnScientific.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, com.example.calculatorpro.ScientificActivity.class);
                    startActivity(intent);
                }
            });
        } else {
            // Button nahi mila to kuch mat kar
            // Agar XML mein button add kiya hai to yeh kabhi execute nahi hoga
        }
    }
}