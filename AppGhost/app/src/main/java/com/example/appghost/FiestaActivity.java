package com.example.appghost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FiestaActivity extends AppCompatActivity {
    TextView texto;
    ImageView imagen;

    Button btn_ir_fiesta, btnCuenta, btn_mis_fiestas, btn_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiesta);

        Bundle bundle = getIntent().getExtras();
        String email = null;
        if (bundle != null) {
            email = bundle.getString("email");
        }

        setup(email);

        texto = (TextView)findViewById(R.id.textView3);
        texto.setText("Ghost Party es una fiesta de generos variados!");
        imagen = (ImageView)findViewById(R.id.imageView);
        Button boton = findViewById(R.id.cambio_descripcion);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout scroll = (LinearLayout) findViewById(R.id.linear_layout);
                    LinearLayout linearLayout = new LinearLayout(boton.getContext());
                        TextView myText = new TextView(boton.getContext());
                        myText.setText("Ven a Ghost Party!!!");
                        linearLayout.setOrientation(LinearLayout.VERTICAL);
                    linearLayout.addView(myText);
                scroll.addView(linearLayout);
            }
        });

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
                Intent miIntent= new Intent(FiestaActivity.this, FiestaActivity.class);
                miIntent.putExtra("email", email);
                startActivity(miIntent);
            }
        });

        btnCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent miIntent= new Intent(FiestaActivity.this, CuentaActivity.class);
                miIntent.putExtra("email", email);
                startActivity(miIntent);
            }
        });

        btn_mis_fiestas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent miIntent= new Intent(FiestaActivity.this, CuentaActivity.class);
                miIntent.putExtra("email", email);
                startActivity(miIntent);
            }
        });

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent miIntent= new Intent(FiestaActivity.this, MainActivity.class);
                miIntent.putExtra("email", email);
                startActivity(miIntent);
            }
        });
    }

}