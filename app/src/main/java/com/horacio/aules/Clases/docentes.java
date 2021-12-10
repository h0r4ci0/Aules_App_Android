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

import com.horacio.aules.Clases.ESO.eso_alicante;
import com.horacio.aules.Clases.ESO.eso_valencia;
import com.horacio.aules.R;

public class docentes extends AppCompatActivity {

    private WebView web_Docentes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docentes);
        web_Docentes = findViewById(R.id.web_Docentes);
        web_Docentes.getSettings().setJavaScriptEnabled(true);
        web_Docentes.setWebViewClient(new WebViewClient());
        web_Docentes.getSettings().setDomStorageEnabled(true);
        web_Docentes.loadUrl("https://aules.edu.gva.es/docent/login/index.php");

        //DESCARGAS
        web_Docentes.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

                Toast.makeText(docentes.this, "Inicia sesión para descargar el archivo", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (web_Docentes.canGoBack()) {
            web_Docentes.goBack();
        } else {
            super.onBackPressed();
        }
    }
}