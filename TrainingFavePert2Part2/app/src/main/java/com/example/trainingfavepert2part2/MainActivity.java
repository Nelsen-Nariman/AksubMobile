package com.example.trainingfavepert2part2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.btn1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), "On Pressed!", Toast.LENGTH_SHORT).show();
                Snackbar.make(button1, "Button Clicked!", Snackbar.LENGTH_INDEFINITE).setAction("Close", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).setActionTextColor(getResources().getColor(R.color.white)).show();
            }
        });

        Button button2 = findViewById(R.id.btn2);
        button2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(getApplicationContext(), "On Long Pressed!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        EditText editText = findViewById(R.id.edit1);
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(hasFocus){
                    Toast.makeText(getApplicationContext(), "You focus!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "You not focus!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button button3 = findViewById(R.id.btn3);
        button3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    Toast.makeText(getApplicationContext(), "On Pressed!", Toast.LENGTH_SHORT).show();
                }
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    Toast.makeText(getApplicationContext(), "Unpressed!", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_A){
            Toast.makeText(getApplicationContext(), "You Pressed A!", Toast.LENGTH_SHORT).show();
        }
        return super.onKeyDown(keyCode, event);
    }
}