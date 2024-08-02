package com.example.appghost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btn_ir_fiesta, btnCuenta, btn_mis_fiestas, btn_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras();
        String email = null;
        if (bundle != null) {
            email = bundle.getString("email");
        } else{
            Intent miIntent= new Intent(MainActivity.this, AuthActivity.class);
            startActivity(miIntent);
        }

        setup(email);

    }

    public void setup(String email){
        setTitle("Inicio");

        btn_ir_fiesta = findViewById(R.id.btn_ir_fiesta);
        btnCuenta = findViewById(R.id.btnCuenta);
        btn_mis_fiestas = findViewById(R.id.btn_mis_fiestas);
        btn_home = findViewById(R.id.btn_home);

        btn_ir_fiesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent miIntent= new Intent(MainActivity.this, FiestaActivity.class);
                miIntent.putExtra("email", email);
                startActivity(miIntent);
            }
        });

        btnCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent miIntent= new Intent(MainActivity.this, CuentaActivity.class);
                miIntent.putExtra("email", email);
                startActivity(miIntent);
            }
        });

        btn_mis_fiestas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent miIntent= new Intent(MainActivity.this, CuentaActivity.class);
                miIntent.putExtra("email", email);
                startActivity(miIntent);
            }
        });

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent miIntent= new Intent(MainActivity.this, MainActivity.class);
                miIntent.putExtra("email", email);
                startActivity(miIntent);
            }
        });
    }

}