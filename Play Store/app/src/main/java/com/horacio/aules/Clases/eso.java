package com.horacio.aules.Clases;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.horacio.aules.R;

public class eso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_eso);
    }

    public void eso_castellón(View view) {
        Intent eso_castellón = new Intent(eso.this, com.horacio.aules.Clases.ESO.eso_castellon.class);
        startActivity(eso_castellón);
    }

    public void eso_valencia(View view) {
        Intent eso_valencia = new Intent(eso.this, com.horacio.aules.Clases.ESO.eso_valencia.class);
        startActivity(eso_valencia);
    }

    public void eso_alicante(View view) {
        Intent eso_valencia = new Intent(eso.this, com.horacio.aules.Clases.ESO.eso_alicante.class);
        startActivity(eso_valencia);
    }
}
