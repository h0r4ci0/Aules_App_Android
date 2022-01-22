package com.horacio.aules.Clases.ESO;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.horacio.aules.R;

public class eso_castellon extends AppCompatActivity {

    private WebView web_eso_castellón;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eso_castellon);
        web_eso_castellón = findViewById(R.id.web_eso_castellón);
        web_eso_castellón.getSettings().setJavaScriptEnabled(true);
        web_eso_castellón.setWebViewClient(new WebViewClient());
        web_eso_castellón.getSettings().setDomStorageEnabled(true);
        web_eso_castellón.loadUrl("https://aules.edu.gva.es/eso12/login/index.php");

        //DESCARGAS
        web_eso_castellón.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

                Toast.makeText(eso_castellon.this, "Inicia sesión para descargar el archivo", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(web_eso_castellón.canGoBack()){
            web_eso_castellón.goBack();
        }

        else {
            super.onBackPressed();
        }
    }
}