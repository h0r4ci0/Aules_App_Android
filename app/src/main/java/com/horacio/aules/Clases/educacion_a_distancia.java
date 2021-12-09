package com.horacio.aules.Clases;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.horacio.aules.Clases.ESO.eso_valencia;
import com.horacio.aules.R;

public class educacion_a_distancia extends AppCompatActivity {

    private WebView web_educación_a_distancia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fp);
        web_educación_a_distancia = findViewById(R.id.web_Fp);
        web_educación_a_distancia.getSettings().setJavaScriptEnabled(true);
        web_educación_a_distancia.setWebViewClient(new WebViewClient());
        web_educación_a_distancia.getSettings().setDomStorageEnabled(true);
        web_educación_a_distancia.loadUrl("https://aules.edu.gva.es/ed/login/index.php");

        web_educación_a_distancia.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

    }


    @Override
    public void onBackPressed() {
        if(web_educación_a_distancia.canGoBack()){
            web_educación_a_distancia.goBack();
        }

        else {
            super.onBackPressed();
        }
    }
}