package com.example.calculatorpro;
import com.example.calculatorpro.ScientificActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView display;
    String currentNumber = "";
    String operator = "";
    double firstValue = 0;
    double secondValue = 0;
    boolean isNewOperation = true;
    ArrayList<String> historyList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        // Number buttons
        setupNumberButton(R.id.btn0, "0");
        setupNumberButton(R.id.btn1, "1");
        setupNumberButton(R.id.btn2, "2");
        setupNumberButton(R.id.btn3, "3");
        setupNumberButton(R.id.btn4, "4");
        setupNumberButton(R.id.btn5, "5");
        setupNumberButton(R.id.btn6, "6");
        setupNumberButton(R.id.btn7, "7");
        setupNumberButton(R.id.btn8, "8");
        setupNumberButton(R.id.btn9, "9");
        setupNumberButton(R.id.btnDot, ".");

        // Operator buttons
        setupOperatorButton(R.id.btnAdd, "+");
        setupOperatorButton(R.id.btnSubtract, "-");
        setupOperatorButton(R.id.btnMultiply, "×");
        setupOperatorButton(R.id.btnDivide, "÷");

        // Percent button
        Button btnPercent = findViewById(R.id.btnPercent);
        btnPercent.setOnClickListener(v -> {
            if (!currentNumber.isEmpty()) {
                double value = Double.parseDouble(currentNumber);
                double result = value / 100;
                display.setText(String.valueOf(result));
                currentNumber = String.valueOf(result);
                isNewOperation = true;
            }
        });

        // Equals button
        Button btnEquals = findViewById(R.id.btnEquals);
        btnEquals.setOnClickListener(v -> {
            if (!currentNumber.isEmpty() && !operator.isEmpty()) {
                secondValue = Double.parseDouble(currentNumber);
                double result = 0;

                switch (operator) {
                    case "+": result = firstValue + secondValue; break;
                    case "-": result = firstValue - secondValue; break;
                    case "×": result = firstValue * secondValue; break;
                    case "÷":
                        if (secondValue != 0) result = firstValue / secondValue;
                        else {
                            display.setText("Error");
                            currentNumber = ""; operator = ""; isNewOperation = true;
                            return;
                        }
                        break;
                }

                display.setText(String.valueOf(result));
                historyList.add(firstValue + " " + operator + " " + secondValue + " = " + result);
                currentNumber = String.valueOf(result);
                operator = "";
                isNewOperation = true;
            }
        });

        // AC button
        Button btnAC = findViewById(R.id.btnAC);
        btnAC.setOnClickListener(v -> {
            currentNumber = ""; operator = "";
            firstValue = 0; secondValue = 0;
            display.setText("0");
            isNewOperation = true;
        });

        // Backspace
        Button btnBackspace = findViewById(R.id.btnBackspace);
        btnBackspace.setOnClickListener(v -> {
            if (!currentNumber.isEmpty()) {
                currentNumber = currentNumber.substring(0, currentNumber.length() - 1);
                display.setText(currentNumber.isEmpty() ? "0" : currentNumber);
            }
        });

        btnBackspace.setOnLongClickListener(v -> {
            currentNumber = "";
            display.setText("0");
            isNewOperation = true;
            return true;
        });

        // Bracket button
        Button btnBracket = findViewById(R.id.btnBracket);
        btnBracket.setOnClickListener(v -> {
            if (isNewOperation) {
                currentNumber = "(";
                isNewOperation = false;
            } else {
                currentNumber += ")";
            }
            display.setText(currentNumber);
        });

        // ============ TOP BAR BUTTONS ============

        // History button
        Button btnHistory = findViewById(R.id.btnHistory);
        btnHistory.setOnClickListener(v -> {
            if (historyList.isEmpty()) {
                display.setText("No History");
            } else {
                StringBuilder sb = new StringBuilder();
                for (String h : historyList) sb.append(h).append("\n");
                display.setText(sb.toString());
                isNewOperation = true;
            }
        });

        // Scientific button
        Button btnScientific = findViewById(R.id.btnScientific);
        btnScientific.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ScientificActivity.class);
            startActivity(intent);
        });

        // Menu button (3 dots)
        Button btnMenu = findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(v -> {
            PopupMenu popup = new PopupMenu(MainActivity.this, btnMenu);
            popup.getMenuInflater().inflate(R.menu.main_menu, popup.getMenu());
            popup.setOnMenuItemClickListener(item -> {
                int id = item.getItemId();
                if (id == R.id.menu_clear_history) {
                    historyList.clear();
                    Toast.makeText(this, "History Cleared", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.menu_theme) {
                    Toast.makeText(this, "Theme Change (Coming Soon)", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.menu_help) {
                    Toast.makeText(this, "Help: Use = to calculate", Toast.LENGTH_SHORT).show();
                }
                return true;
            });
            popup.show();
        });
    }

    private void setupNumberButton(int id, String value) {
        Button btn = findViewById(id);
        btn.setOnClickListener(v -> {
            if (isNewOperation) {
                currentNumber = "";
                isNewOperation = false;
            }
            if (value.equals(".")) {
                if (!currentNumber.contains(".")) {
                    currentNumber = currentNumber.isEmpty() ? "0." : currentNumber + ".";
                }
            } else {
                currentNumber += value;
            }
            display.setText(currentNumber);
        });
    }

    private void setupOperatorButton(int id, String op) {
        Button btn = findViewById(id);
        btn.setOnClickListener(v -> {
            if (!currentNumber.isEmpty()) {
                firstValue = Double.parseDouble(currentNumber);
                operator = op;
                currentNumber = "";
                isNewOperation = false;
            }
        });
    }
}