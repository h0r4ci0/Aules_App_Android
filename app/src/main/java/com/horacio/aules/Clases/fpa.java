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

public class fpa extends AppCompatActivity {

    private WebView web_fpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fpa);
        web_fpa = findViewById(R.id.web_fpa);
        web_fpa.getSettings().setJavaScriptEnabled(true);
        web_fpa.setWebViewClient(new WebViewClient());
        web_fpa.getSettings().setDomStorageEnabled(true);
        web_fpa.loadUrl("https://aules.edu.gva.es/fpa/login/index.php");

        web_fpa.setDownloadListener(new DownloadListener() {
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
        if(web_fpa.canGoBack()){
            web_fpa.goBack();
        }

        else {
            super.onBackPressed();
        }
    }
}