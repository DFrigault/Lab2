package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvLoveAndroid = findViewById(R.id.tv_love_android);
        EditText editLoveAndroid = findViewById(R.id.edit_love_android);
        Button btnPressMe = findViewById(R.id.btn_press_me);
        CheckBox checkThisOut = findViewById(R.id.check_this_out);

        btnPressMe.setOnClickListener(v -> {
            tvLoveAndroid.setText(editLoveAndroid.getText().toString());
            Toast.makeText(MainActivity.this, getResources().getString(R.string.toast_message), Toast.LENGTH_SHORT).show();
        });

        checkThisOut.setOnCheckedChangeListener((cb, isChecked) -> {
            String snackbarMessage = "The checkbox is now " + (isChecked ? "on" : "off");
            Snackbar.make(findViewById(R.id.root_view), snackbarMessage, Snackbar.LENGTH_LONG)
                    .setAction("Undo", click -> cb.setChecked(!isChecked))
                    .show();
        });
    }
}