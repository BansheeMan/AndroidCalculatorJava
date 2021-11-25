package com.example.androidcalculatorjava.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.androidcalculatorjava.R;

public class SettingsActivity extends ThemesActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        init();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb_light:
                setCurrentTheme(THEM_LIGHT);
                break;
            case R.id.rb_dark:
                setCurrentTheme(THEM_DARK);
                break;
        }
        recreate();
        Toast toast = Toast.makeText(this, "Theme Apply", Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    public void init() {
        RadioButton key_rb_light = findViewById(R.id.rb_light);
        RadioButton key_rb_dark = findViewById(R.id.rb_dark);
        key_rb_light.setOnClickListener(this);
        key_rb_dark.setOnClickListener(this);

        switch (getCurrentTheme()) {
            case 1:
                key_rb_light.setChecked(true);
                break;
            case 2:
                key_rb_dark.setChecked(true);
                break;
        }
    }
}