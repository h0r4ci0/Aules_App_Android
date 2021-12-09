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

public class Bachillerato extends AppCompatActivity {

    private WebView web_Bachillerato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bachillerato);
        web_Bachillerato = findViewById(R.id.web_Bachillerato);
        web_Bachillerato.getSettings().setJavaScriptEnabled(true);
        web_Bachillerato.setWebViewClient(new WebViewClient());
        web_Bachillerato.getSettings().setDomStorageEnabled(true);
        web_Bachillerato.loadUrl("https://aules.edu.gva.es/batxillerat/login/index.php");

        web_Bachillerato.setDownloadListener(new DownloadListener() {
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
        if(web_Bachillerato.canGoBack()){
            web_Bachillerato.goBack();
        }

        else {
            super.onBackPressed();
        }
    }
}