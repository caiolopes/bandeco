package com.caiolopes.bandeco;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent intent = getIntent();
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.webProgress);
        final TextView textView = (TextView)findViewById(R.id.loadingText);
        final WebView webView = (WebView) findViewById(R.id.webView);
        final Activity activity = this;
        if (intent.hasExtra("CAMPUS")) {
            int campus = intent.getIntExtra("CAMPUS", 1);
            String pdf;
            if (campus == 1)
                pdf = "http://www.prefeitura.sc.usp.br/boletim_informegeral/pdf/cardapio_semanal_restaurante_area_1.pdf";
            else
                pdf = "http://www.prefeitura.sc.usp.br/boletim_informegeral/pdf/cardapio_semanal_restaurante_area_2.pdf";

            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url="+pdf);
            webView.setWebChromeClient(new WebChromeClient() {
                @Override
                public void onProgressChanged(WebView view, int newProgress) {
                    if(newProgress < 100 && progressBar.getVisibility() == ProgressBar.GONE) {
                        progressBar.setVisibility(ProgressBar.VISIBLE);
                        textView.setVisibility(View.VISIBLE);
                    }
                    progressBar.setProgress(newProgress);
                    if(newProgress == 100) {
                        progressBar.setVisibility(ProgressBar.GONE);
                        textView.setVisibility(View.GONE);
                    }
                }
            });
        }
    }
}