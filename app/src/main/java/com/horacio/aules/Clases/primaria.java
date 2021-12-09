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

public class primaria extends AppCompatActivity {

    private WebView web_Primaria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infantil);
        web_Primaria = findViewById(R.id.web_infantil);
        web_Primaria.getSettings().setJavaScriptEnabled(true);
        web_Primaria.setWebViewClient(new WebViewClient());
        web_Primaria.getSettings().setDomStorageEnabled(true);
        web_Primaria.loadUrl("https://aules.edu.gva.es/primaria/login/index.php");

        web_Primaria.setDownloadListener(new DownloadListener() {
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
        if(web_Primaria.canGoBack()){
            web_Primaria.goBack();
        }

        else {
            super.onBackPressed();
        }
    }
}
