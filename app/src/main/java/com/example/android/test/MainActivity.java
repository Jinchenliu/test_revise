package com.example.android.test;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.test.R;

public class MainActivity extends AppCompatActivity {
    String result = "Wrong";
    private String inputName="";
    private String bornPlace = "";
    private String singer = "";
    private String inputAge="";
    private boolean travelPlace = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit(View view) {
        checkAnswer_name();
        checkAnswer_age();
        checkAnswer_bornPlace();
        checkAnswer_favorite_singer();
        checkAnswer_travelPlace();
        if ((inputName.equals(getString(R.string.answer_name))) && (inputAge.equals(getString(R.string.answer_age))) && (bornPlace.equals(getString(R.string.radioButton_2)))
                && (singer.equals(getString(R.string.radioButton_4))) && (travelPlace)) {
            result = getString(R.string.result_right);
        } else {
            result = getString(R.string.result_wrong);
        }
        display(result);
    }

    private void display(String toastResult) {
        Context context = getApplicationContext();
        CharSequence text = toastResult;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private void checkAnswer_name() {
        EditText name = (EditText) findViewById(R.id.name);
        inputName = name.getText().toString();
    }

    private void checkAnswer_age() {
        EditText age = (EditText) findViewById(R.id.age);
        inputAge = age.getText().toString();
    }

    private void checkAnswer_bornPlace() {
        RadioGroup radioGroup_bornPlace = (RadioGroup) findViewById(R.id.born_place);
        int selectedId = radioGroup_bornPlace.getCheckedRadioButtonId();
        if (selectedId >= 0) {
            RadioButton radioButton_bornPlace = (RadioButton) findViewById(selectedId);
            bornPlace = radioButton_bornPlace.getText().toString();
        } else {
            bornPlace = "";
        }
    }

    private void checkAnswer_favorite_singer() {
        RadioGroup radioGroup_singer = (RadioGroup) findViewById(R.id.favorite_singer);
        int selectedId = radioGroup_singer.getCheckedRadioButtonId();
        if (selectedId >= 0) {
            RadioButton radioButton_singer = (RadioButton) findViewById(selectedId);
            singer = radioButton_singer.getText().toString();
        } else {
            singer = "";
        }
    }

    private void checkAnswer_travelPlace() {
        CheckBox singapore = (CheckBox) findViewById(R.id.singapore);
        CheckBox chengdu = (CheckBox) findViewById(R.id.chengdu);
        CheckBox xiamen = (CheckBox) findViewById(R.id.xiamen);
        boolean singapore_chosen = singapore.isChecked();
        boolean chengdu_chosen = chengdu.isChecked();
        boolean xiamen_chosen = xiamen.isChecked();
        if ((singapore_chosen) && (!chengdu_chosen) && (xiamen_chosen)) {
            travelPlace = true;
        } else {
            travelPlace = false;
        }
    }

}

