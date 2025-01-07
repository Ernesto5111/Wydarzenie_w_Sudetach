package com.example.wydarzenie_w_sudetach;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MainActivity extends AppCompatActivity {
    private Button polubButton;
    private Button usunButton;
    private TextView text_polub;
    private Button zapisz;
    private Button zobacz;
    private String ostatni;
    private TextView text_opis2;

    private int tealColor = Color.parseColor("#008080");
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        polubButton = findViewById(R.id.polub);
        usunButton = findViewById(R.id.usun);
        text_polub = findViewById(R.id.text_polub);
        zapisz = findViewById(R.id.zapisz);
        zobacz = findViewById(R.id.zobacz);
        text_opis2 = findViewById(R.id.text_opis2);

        polubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                text_polub.setText(count + " polubień");

            }
        });
        usunButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count > 0){
                    count--;
                    text_polub.setText(count + " polubień");
                }
                else{
                    text_polub.setText(count + " polubień");
                }

            }
        });

        findViewById(R.id.zapisz).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String email1 = ((EditText)findViewById(R.id.email)).getText().toString().trim();
                String haslo1 = ((EditText)findViewById(R.id.haslo1)).getText().toString().trim();
                String haslo2 = ((EditText)findViewById(R.id.haslo2)).getText().toString().trim();

                if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email1).matches()){
                    text_opis2.setText("Nieprawdiłowy adres e-mail");
                }
                else if(!haslo1.equals(haslo2)){
                    text_opis2.setText("Hasła się różnią");
                }
                else{
                    text_opis2.setText("Zarejestrowano: " + email1);
                    ostatni = email1;
                }
            }
        });

        findViewById(R.id.zobacz).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                text_opis2.setText(ostatni);
            }
        });

    };
}