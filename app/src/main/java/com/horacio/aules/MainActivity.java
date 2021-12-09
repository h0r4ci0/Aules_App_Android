package com.horacio.aules;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

import com.horacio.aules.fragments.InicioFragment;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        TimerTask tarea = new TimerTask() {

            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, InicioFragment.class);
                    startActivity(intent);
                    finish();
            }
        };

        Timer tiempo = new Timer();
        tiempo.schedule(tarea, 1000);

        Toast.makeText(MainActivity.this, "¡Bienvenid@!", Toast.LENGTH_SHORT).show();
    }

   // @Override
   // protected void onCreate(Bundle savedInstanceState) {
   //     super.onCreate(savedInstanceState);
    //    setContentView(R.layout.activity_main);

    //    verficarPermisos();
    //}
    //private void verficarPermisos(){
     //   ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
   // }
}