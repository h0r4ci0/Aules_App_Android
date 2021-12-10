package com.horacio.aules.Clases.ESO;

import android.app.DownloadManager;
import android.app.VoiceInteractor;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.horacio.aules.R;

public class eso_valencia extends AppCompatActivity {

    private WebView web_eso_valencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eso_valencia);
        web_eso_valencia = findViewById(R.id.web_eso_valencia);
        web_eso_valencia.getSettings().setJavaScriptEnabled(true);
        web_eso_valencia.setWebViewClient(new WebViewClient());
        web_eso_valencia.getSettings().setDomStorageEnabled(true);
        web_eso_valencia.loadUrl("https://aules.edu.gva.es/eso46/login/index.php"); //https://aules.edu.gva.es/eso46/login/index.php

     /*   //COLORES SYSTEMUI

         String primaryDark = "#3b8480";
         String primary = "#3b8480";
         String background = "#3b8480";

         private void cambiarColor(primaryDark, primary, background){
            //Color primary dark
            getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor(primaryDark)));

            //Color Primary

            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(primary)));

            //Background

            getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor(background)));
        } */

        //DESCARGAS
        web_eso_valencia.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

                Toast.makeText(eso_valencia.this, "Inicia sesión para descargar el archivo", Toast.LENGTH_LONG).show();
            }
        });
    }

      /*  web_eso_valencia.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {

                DownloadManager.Request myRequest = new DownloadManager.Request(Uri.parse(url));
                myRequest.allowScanningByMediaScanner();
                myRequest.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                DownloadManager myManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                myManager.enqueue(myRequest);

                Toast.makeText(eso_valencia.this, "Descargando...", Toast.LENGTH_SHORT).show();

            }
        });
    } */

    @Override
    public void onBackPressed() {
        if(web_eso_valencia.canGoBack()){
            web_eso_valencia.goBack();
        }

        else {
            super.onBackPressed();
        }
    }
}