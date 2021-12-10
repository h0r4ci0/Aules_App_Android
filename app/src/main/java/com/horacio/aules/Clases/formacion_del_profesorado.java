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

public class formacion_del_profesorado extends AppCompatActivity {

    private WebView web_formación_del_profesorado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fp);
        web_formación_del_profesorado = findViewById(R.id.web_Fp);
        web_formación_del_profesorado.getSettings().setJavaScriptEnabled(true);
        web_formación_del_profesorado.setWebViewClient(new WebViewClient());
        web_formación_del_profesorado.getSettings().setDomStorageEnabled(true);
        web_formación_del_profesorado.loadUrl("https://aules.edu.gva.es/formaciodelprofessorat/login/index.php");

        //DESCARGAS
        web_formación_del_profesorado.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

                Toast.makeText(formacion_del_profesorado.this, "Inicia sesión para descargar el archivo", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(web_formación_del_profesorado.canGoBack()){
            web_formación_del_profesorado.goBack();
        }

        else {
            super.onBackPressed();
        }
    }
}