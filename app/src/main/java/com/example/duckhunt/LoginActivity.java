package com.example.duckhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.duckhunt.common.Constantes;

public class LoginActivity extends AppCompatActivity {
    EditText etNick;
    Button btnStart;
    String nick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etNick = findViewById(R.id.editTextTextNickName);
        btnStart = findViewById(R.id.button_start);

        //Realizamos un evento click
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nick = etNick.getText().toString();
                if(nick.isEmpty())
                {
                    etNick.setError("!Escribe tu nombre de usuario¡");
                }
                else if(nick.length()<3)
                {
                    etNick.setError("Debe escribir al menos 3 caracteres");
                }
                else
                {
                    Intent i = new Intent(LoginActivity.this, GameActivity.class);
                    i.putExtra(Constantes.EXTRA_NICK, nick);
                    startActivity(i);
                }
            }
        });
    }
}