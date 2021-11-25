package com.example.androidcalculatorjava.ui;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.androidcalculatorjava.R;
import com.example.androidcalculatorjava.domain.CalculatorImp;
import com.example.androidcalculatorjava.domain.Operation;

import java.util.HashMap;
import java.util.Map;

public class CalculatorActivity extends ThemesActivity implements CalculatorView {

    private TextView argOneField;
    private TextView argTwoField;
    private TextView operatorField;
    private TextView txtResult;
    private Button btnSettings;
    private CalculatorPresenter presenter;
    private final Map<Integer, Integer> digits = new HashMap<>();
    private final Map<Integer, Operation> operators = new HashMap<>();
    private static final String SAVE_ARG_ONE = "SAVE_ARG_ONE";
    private static final String SAVE_ARG_TWO = "SAVE_ARG_TWO";
    private static final String SAVE_RESULT = "SAVE_RESULT";
    private static final String SAVE_OPERATION = "SAVE_OPERATION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new CalculatorPresenter(this, new CalculatorImp());
        putKey();
        initTextView();
        showResult();

        //noinspection ConstantConditions
        View.OnClickListener digitsPress = view -> presenter.onDigitPressed(digits.get(view.getId()));
        View.OnClickListener operatorsPress = view -> presenter.onOperationPressed(operators.get(view.getId()));
        initKey(digitsPress, operatorsPress);
        findViewById(R.id.key_dot).setOnClickListener(view -> presenter.onDotPressed());
        findViewById(R.id.key_equal).setOnClickListener(view -> presenter.displayResult());
        findViewById(R.id.key_clear).setOnClickListener(view -> presenter.displayClear());

        if (btnSettings != null) {
            btnSettings.setOnClickListener(view -> {
                Intent i = new Intent(CalculatorActivity.this, SettingsActivity.class);
                startActivity(i);
            });
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        recreate();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble(SAVE_ARG_ONE, presenter.getArgOne());
        outState.putDouble(SAVE_ARG_TWO, presenter.getArgTwo());
        outState.putDouble(SAVE_RESULT, presenter.getResult());
        outState.putSerializable(SAVE_OPERATION, presenter.getOperation());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        presenter.setArgOne(savedInstanceState.getDouble(SAVE_ARG_ONE));
        presenter.setArgTwo(savedInstanceState.getDouble(SAVE_ARG_TWO));
        presenter.setResult(savedInstanceState.getDouble(SAVE_RESULT));
        presenter.setOperation((Operation) savedInstanceState.getSerializable(SAVE_OPERATION));
        showResult();
    }

    @Override
    public void showResult() {
        argOneField.setText(String.valueOf(presenter.getArgOne()));
        argTwoField.setText(String.valueOf(presenter.getArgTwo()));
        operatorField.setText(presenter.getOperation().toString());
        txtResult.setText(String.valueOf(presenter.getResult()));
    }

    @Override
    public void showResultWithoutEquals() {
        argOneField.setText(String.valueOf(presenter.getArgOne()));
        argTwoField.setText(String.valueOf(presenter.getArgTwo()));
        operatorField.setText(presenter.getOperation().toString());
    }

    public void putKey() {
        digits.put(R.id.key_0, 0);
        digits.put(R.id.key_1, 1);
        digits.put(R.id.key_2, 2);
        digits.put(R.id.key_3, 3);
        digits.put(R.id.key_4, 4);
        digits.put(R.id.key_5, 5);
        digits.put(R.id.key_6, 6);
        digits.put(R.id.key_7, 7);
        digits.put(R.id.key_8, 8);
        digits.put(R.id.key_9, 9);

        operators.put(R.id.key_plus, Operation.PLUS);
        operators.put(R.id.key_multiply, Operation.MULTIPLICATION);
        operators.put(R.id.key_deduct, Operation.DEDUCT);
        operators.put(R.id.key_divide, Operation.DIVISION);
    }

    public void initTextView() {
        argOneField = findViewById(R.id.argOneField);
        argTwoField = findViewById(R.id.argTwoField);
        operatorField = findViewById(R.id.operatorField);
        txtResult = findViewById(R.id.resultField);
    }

    public void initKey(View.OnClickListener digitsPress, View.OnClickListener operatorsPress) {
        findViewById(R.id.key_0).setOnClickListener(digitsPress);
        findViewById(R.id.key_1).setOnClickListener(digitsPress);
        findViewById(R.id.key_2).setOnClickListener(digitsPress);
        findViewById(R.id.key_3).setOnClickListener(digitsPress);
        findViewById(R.id.key_4).setOnClickListener(digitsPress);
        findViewById(R.id.key_5).setOnClickListener(digitsPress);
        findViewById(R.id.key_6).setOnClickListener(digitsPress);
        findViewById(R.id.key_7).setOnClickListener(digitsPress);
        findViewById(R.id.key_8).setOnClickListener(digitsPress);
        findViewById(R.id.key_9).setOnClickListener(digitsPress);

        findViewById(R.id.key_plus).setOnClickListener(operatorsPress);
        findViewById(R.id.key_multiply).setOnClickListener(operatorsPress);
        findViewById(R.id.key_deduct).setOnClickListener(operatorsPress);
        findViewById(R.id.key_divide).setOnClickListener(operatorsPress);
        btnSettings = findViewById(R.id.key_setting);
    }
}