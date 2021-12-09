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

public class especials extends AppCompatActivity {

    private WebView web_especials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especials);
        web_especials = findViewById(R.id.web_especials);
        web_especials.getSettings().setJavaScriptEnabled(true);
        web_especials.setWebViewClient(new WebViewClient());
        web_especials.getSettings().setDomStorageEnabled(true);
        web_especials.loadUrl("https://aules.edu.gva.es/especials/login/index.php");

        web_especials.setDownloadListener(new DownloadListener() {
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
        if(web_especials.canGoBack()){
            web_especials.goBack();
        }

        else {
            super.onBackPressed();
        }
    }
}