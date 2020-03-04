package com.example.sdbitacora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main3Activity extends AppCompatActivity {
    WebView wb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        wb1 = (WebView)findViewById(R.id.wb1);

        String tener = getIntent().getStringExtra("fb");
        wb1.setWebViewClient(new WebViewClient());
        wb1.loadUrl(tener);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);
    }
}
