package com.horacio.aules.Clases;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.horacio.aules.Clases.ESO.eso_alicante;
import com.horacio.aules.Clases.ESO.eso_valencia;
import com.horacio.aules.R;

public class Infantil extends AppCompatActivity {

    private WebView web_Infantil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infantil);
        web_Infantil = findViewById(R.id.web_infantil);
        web_Infantil.getSettings().setJavaScriptEnabled(true);
        web_Infantil.setWebViewClient(new WebViewClient());
        web_Infantil.getSettings().setDomStorageEnabled(true);
        web_Infantil.loadUrl("https://aules.edu.gva.es/infantil/login/index.php");

        //DESCARGAS
        web_Infantil.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

                Toast.makeText(Infantil.this, "Inicia sesión para descargar el archivo", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(web_Infantil.canGoBack()){
            web_Infantil.goBack();
        }

        else {
            super.onBackPressed();
        }
        }
    }
