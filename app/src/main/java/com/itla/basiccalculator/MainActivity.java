package com.itla.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtResult;
    private Button btnZero;
    private Button btnDot;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;
    private Button btnFive;
    private Button btnSix;
    private Button btnSeven;
    private Button banEight;
    private Button btnNine;

    private Button btnClear;

    private Button btnPlus;
    private Button btnMinus;
    private Button btnMultiply;
    private Button btnDivision;
    private Button btnPercent;
    private Button btnSquareRoot;
    private Button btnCubeRoot;
    private Button btnFactorial;
    private Button btnPowerTwo;

    private Button btnEqual;

    private Boolean firstInput = true;
    private Boolean lastWasOperator = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.txtResult = findViewById(R.id.txtResult);

        final Calculator calculator = new Calculator();
        this.initializeComponents();
        this.setDigitsListener();
        this.setOperatorsListener(calculator);
        this.setClearButtonListener(calculator);
        this.setEqualButtonListener(calculator);
    }

    private void initializeComponents() {

        this.btnZero = findViewById(R.id.btnZero);
        this.btnDot = findViewById(R.id.btnDot);
        this.btnOne = findViewById(R.id.btnOne);
        this.btnTwo = findViewById(R.id.btnTwo);
        this.btnThree = findViewById(R.id.btnThree);
        this.btnFour = findViewById(R.id.btnFour);
        this.btnFive = findViewById(R.id.btnFive);
        this.btnSix = findViewById(R.id.btnSix);
        this.btnSeven = findViewById(R.id.btnSeven);
        this.banEight = findViewById(R.id.btnEight);
        this.btnNine = findViewById(R.id.btnNine);

        this.btnPlus = findViewById(R.id.btnPlus);
        this.btnMinus = findViewById(R.id.btnMinus);
        this.btnMultiply = findViewById(R.id.btnMultiply);
        this.btnDivision = findViewById(R.id.btnDivision);
        this.btnPercent = findViewById(R.id.btnPercent);
        this.btnSquareRoot = findViewById(R.id.btnSquareRoot);
        this.btnCubeRoot = findViewById(R.id.btnCubeRoot);
        this.btnFactorial = findViewById(R.id.btnFactorial);
        this.btnPowerTwo = findViewById(R.id.btnPowerTwo);

        this.btnEqual = findViewById(R.id.btnEqual);
        this.btnClear = findViewById(R.id.btnClear);
    }

    private void setDigitsListener() {
        OnClickListener digitOnClickListener = new OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!firstInput) {
                    txtResult.setText("");
                    firstInput = true;
                }

                lastWasOperator = false;
                StringBuilder sb = new StringBuilder();
                sb.append(txtResult.getText());
                String digit = ((Button) v).getText().toString();

                sb.append(digit);
                txtResult.setText(sb.toString());
            }
        };

        this.btnDot.setOnClickListener(digitOnClickListener);
        this.btnZero.setOnClickListener(digitOnClickListener);
        this.btnOne.setOnClickListener(digitOnClickListener);
        this.btnTwo.setOnClickListener(digitOnClickListener);
        this.btnThree.setOnClickListener(digitOnClickListener);
        this.btnFour.setOnClickListener(digitOnClickListener);
        this.btnFive.setOnClickListener(digitOnClickListener);
        this.btnSix.setOnClickListener(digitOnClickListener);
        this.btnSeven.setOnClickListener(digitOnClickListener);
        this.banEight.setOnClickListener(digitOnClickListener);
        this.btnNine.setOnClickListener(digitOnClickListener);
    }

    private void setClearButtonListener(final Calculator calculator) {
        this.btnClear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText("0");
                calculator.clear();
                firstInput = true;
            }
        });

    }

    private void setEqualButtonListener(final Calculator calculator) {
        this.btnEqual.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Double value  = Double.parseDouble(txtResult.getText().toString());
                txtResult.setText(formatCalcResult(calculator.getValue(value)));
            }
        });
    }

    private void setOperatorsListener(final Calculator calculator) {

        OnClickListener operatorOnClickListener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtResult.getText().equals("0"))
                    return;

                String symbol = ((Button) v).getText().toString();
                if(!lastWasOperator)
                    calculator.makeCalculation(symbol, Double.parseDouble(txtResult.getText().toString()));
                else
                    calculator.setOperator(symbol);

                txtResult.setText(formatCalcResult(calculator.getValue()));
                firstInput = false;
                lastWasOperator = true;
            }
        };

        this.btnPlus.setOnClickListener(operatorOnClickListener);
        this.btnMinus.setOnClickListener(operatorOnClickListener);
        this.btnMultiply.setOnClickListener(operatorOnClickListener);
        this.btnDivision.setOnClickListener(operatorOnClickListener);
        this.btnPercent.setOnClickListener(operatorOnClickListener);
        this.btnSquareRoot.setOnClickListener(operatorOnClickListener);
        this.btnCubeRoot.setOnClickListener(operatorOnClickListener);
        this.btnFactorial.setOnClickListener(operatorOnClickListener);
        this.btnPowerTwo.setOnClickListener(operatorOnClickListener);
    }

    private String formatCalcResult(Double value) {
        String result = value.toString();
        return result.substring(0, (result.length() > 12 ? 12 : result.length()));
    }
}
