package com.horacio.aules.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

import com.horacio.aules.Clases.Infantil;
import com.horacio.aules.Clases.eso;
import com.horacio.aules.Clases.primaria;
import com.horacio.aules.R;

public class InicioFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.fragment_inicio);
    }

    public void Infantil(View view) {
        Intent infantil = new Intent(InicioFragment.this, Infantil.class);
        startActivity(infantil);
    }

    public void Primaria(View view) {
        Intent primaria = new Intent (InicioFragment.this, primaria.class);
        startActivity(primaria);
    }

    public void ESO(View view) {
        Intent ESO = new Intent (InicioFragment.this, eso.class);
        startActivity(ESO);
    }

    public void Bachillerato(View view) {
        Intent Bachillerato = new Intent(InicioFragment.this, com.horacio.aules.Clases.Bachillerato.class);
        startActivity(Bachillerato);
    }

    public void Fp (View view) {
        Intent Fp = new Intent(InicioFragment.this, com.horacio.aules.Clases.Fp.class);
        startActivity(Fp);
    };

    public void Fp_Semipresencial (View view) {
        Intent Fp_Semipresencial = new Intent(InicioFragment.this, com.horacio.aules.Clases.fp_semipresencial.class);
        startActivity(Fp_Semipresencial);
    }

    public void FPA(View view) {
        Intent FPA = new Intent(InicioFragment.this, com.horacio.aules.Clases.fpa.class);
        startActivity(FPA);
    }

    public void especials(View view) {
        Intent especials = new Intent(InicioFragment.this, com.horacio.aules.Clases.especials.class);
        startActivity(especials);
    }

    public void educación_a_distancia(View view) {
        Intent educación_a_distancia = new Intent(InicioFragment.this, com.horacio.aules.Clases.educacion_a_distancia.class);
        startActivity(educación_a_distancia);
    }

    public void formacioń_del_profesorado(View view) {
        Intent formación_del_profesorado = new Intent(InicioFragment.this, com.horacio.aules.Clases.formacion_del_profesorado.class);
        startActivity(formación_del_profesorado);
    }

    public void docentes(View view) {
        Intent docentes = new Intent(InicioFragment.this, com.horacio.aules.Clases.docentes.class);
        startActivity(docentes);
    }

    public void GitHub(View view) {
        Intent GitHub = new Intent (Intent.ACTION_VIEW);
        GitHub.setData(Uri.parse("https://github.com/horacio507/Aules_App_Android"));
        startActivity(GitHub);
    }
}