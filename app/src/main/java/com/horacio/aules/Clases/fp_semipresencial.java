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

public class fp_semipresencial extends AppCompatActivity {

    private WebView web_Fp_Semipresencial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fp_semipresencial);
        web_Fp_Semipresencial = findViewById(R.id.web_Fp_Semipresencial);
        web_Fp_Semipresencial.getSettings().setJavaScriptEnabled(true);
        web_Fp_Semipresencial.setWebViewClient(new WebViewClient());
        web_Fp_Semipresencial.getSettings().setDomStorageEnabled(true);
        web_Fp_Semipresencial.loadUrl("https://aules.edu.gva.es/semipresencial/login/index.php");

        //DESCARGAS
        web_Fp_Semipresencial.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

                Toast.makeText(fp_semipresencial.this, "Inicia sesión para descargar el archivo", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(web_Fp_Semipresencial.canGoBack()){
            web_Fp_Semipresencial.goBack();
        }

        else {
            super.onBackPressed();
        }
    }
}