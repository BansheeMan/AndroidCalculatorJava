package com.example.androidcalculatorjava.ui;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidcalculatorjava.R;

public class ThemesActivity extends AppCompatActivity {

    private static final String KEY_SHP = "KEY_SHP";
    private static final String KEY_CURRENT_THEME = "KEY_CURRENT_THEME";
    protected static final int THEM_LIGHT = 1;
    protected static final int THEM_DARK = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getRealTheme(getCurrentTheme()));
    }

    public int getRealTheme(int currentTheme) {
        switch (currentTheme) {
            case THEM_LIGHT:
                return R.style.MyTheme;
            case THEM_DARK:
                return R.style.MyTheme_Dark;
            default:
                return 0;
        }
    }

    public int getCurrentTheme() {
        SharedPreferences shp = getSharedPreferences(KEY_SHP, MODE_PRIVATE);
        return shp.getInt(KEY_CURRENT_THEME, -1);
    }

    public void setCurrentTheme(int currentTheme) {
        SharedPreferences shp = getSharedPreferences(KEY_SHP, MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        editor.putInt(KEY_CURRENT_THEME, currentTheme);
        editor.apply();
    }
}
