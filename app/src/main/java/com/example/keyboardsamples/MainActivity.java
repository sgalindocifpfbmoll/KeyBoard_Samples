package com.example.keyboardsamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        final EditText editMessage = findViewById(R.id.inputMessage);
        final EditText editMail = findViewById(R.id.inputMail);
        final EditText editPhone = findViewById(R.id.inputPhone);

        // Get buttons
        Button buttonMessage = findViewById(R.id.showMessage);
        Button buttonMail = findViewById(R.id.showMail);

        // Buttons listeners
        buttonMessage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //
                showToast(String.valueOf(editMessage.getText()));
            }
        });
        buttonMail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //
                showToast(String.valueOf(editMail.getText()));
            }
        });



        editPhone.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_DONE){
                    // Get the text value and insert it into the textPhone
                    Spinner spinner = findViewById(R.id.spinnerPhone);
                    TextView textPhone = findViewById(R.id.textPhone);
                    textPhone.setText(editPhone.getText() +" - "+spinner.getSelectedItem().toString());
                }
                return false;
            }
        });
    }

    protected void showToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}