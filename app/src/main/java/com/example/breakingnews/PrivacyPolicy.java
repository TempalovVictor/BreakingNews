package com.example.breakingnews;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PrivacyPolicy extends AppCompatActivity {

    String language = Utils.getLanguage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);

        WebView webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);

        switch (language) {
            case "ru" :
                webView.loadUrl("https://docs.google.com/document/d/13jiVMzX0IYAN23nvWKxtFIfNdVZV7wCE1xXLllu5hkE/edit?usp=sharing");
            break;
            case "en" :
                webView.loadUrl("https://docs.google.com/document/d/1Wt5Eo7_xddpJEeiLd71K34Rj8voK_l2Kx2VoGiEcKKU/edit?usp=sharing");
            break;
        }

        WebViewClient webViewClient = new WebViewClient() {
            @SuppressWarnings("deprecation") @Override
            public boolean shouldOverrideUrlLoading(WebView view,String url) {
                view.loadUrl(url);
                return true;
            }

            @TargetApi(Build.VERSION_CODES.N) @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return true;
            }
        };

        webView.setWebViewClient(webViewClient);
    }
}