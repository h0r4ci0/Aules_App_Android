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

public class Fp extends AppCompatActivity {

    private WebView web_Fp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fp);
        web_Fp = findViewById(R.id.web_Fp);
        web_Fp.getSettings().setJavaScriptEnabled(true);
        web_Fp.setWebViewClient(new WebViewClient());
        web_Fp.getSettings().setDomStorageEnabled(true);
        web_Fp.getSettings().setDomStorageEnabled(true);
        web_Fp.loadUrl("https://aules.edu.gva.es/fp/login/index.php");

        //DESCARGAS
        web_Fp.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

                Toast.makeText(Fp.this, "Inicia sesión para descargar el archivo", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(web_Fp.canGoBack()){
            web_Fp.goBack();
        }

        else {
            super.onBackPressed();
        }
    }
}