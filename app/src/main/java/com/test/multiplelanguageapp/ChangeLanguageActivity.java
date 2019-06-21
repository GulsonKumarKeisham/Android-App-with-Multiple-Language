package com.test.multiplelanguageapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class ChangeLanguageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_language);

        final Spinner spinner = findViewById(R.id.spinner);

        //get current locale language
        String cLang = getResources().getConfiguration().locale.getLanguage();

        //set selected position for the current language in spinner
        switch (cLang){
            case "en": spinner.setSelection(0); break;
            case "zh": spinner.setSelection(1); break;
            case "fr": spinner.setSelection(2); break;
            case "hi": spinner.setSelection(3); break;
            case "kn": spinner.setSelection(4); break;
            case "es": spinner.setSelection(5); break;
        }

        Button applyBtn = findViewById(R.id.applyBtn);
        applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = spinner.getSelectedItemPosition();
                setLanguage(i);
            }
        });
    }

    /**
     * method for updating locale config
     * @param item
     */
    private void setLanguage(int item){
        String lang;
        switch (item){
            case 0:lang = "en"; break;//set language as english
            case 1:lang = "zh"; break;//set language as chinese
            case 2:lang = "fr"; break;//set language as french
            case 3:lang = "hi"; break;//set language as hindi
            case 4:lang = "kn"; break;//set language as kannada
            case 5:lang = "es"; break;//set language as spanish
            default: lang = "en"; //set english as default english
        }

        //create new locale with selected language
        Locale myLocale = new Locale(lang);
        //get app resources
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        //update with new config
        res.updateConfiguration(conf, dm);
        //refresh or restart the main activity
        startActivity(new Intent(this, MainActivity.class));
        //finish the current activity
        finish();
    }
}
