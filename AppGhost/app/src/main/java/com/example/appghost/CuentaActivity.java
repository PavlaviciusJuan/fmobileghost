package com.example.appghost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class CuentaActivity extends AppCompatActivity {

    TextView textViewEmail;
    Button btnCerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta);

        Bundle bundle = getIntent().getExtras();
        String email = null;
        if (bundle != null) {
            email = bundle.getString("email");
        }

        setup(email);

    }

    public void setup (String email){
        setTitle("Cuenta");

        textViewEmail.setText(email);

        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent miIntent = new Intent(CuentaActivity.this, AuthActivity.class);
                startActivity(miIntent);
            }
        });




    }




}