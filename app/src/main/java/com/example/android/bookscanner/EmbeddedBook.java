package com.example.android.bookscanner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class EmbeddedBook extends AppCompatActivity {

    private WebView webView;
    String isbn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_embedded_book);

        webView= (WebView) findViewById(R.id.embedded_book_view);
        webView.getSettings().setJavaScriptEnabled(true);
        Bundle extras = getIntent().getExtras();

        if(extras !=null) {
            //get isbn
            isbn = extras.getString("isbn");

        }

        try{
            //load asset
            InputStream pageIn = getAssets().open("embedded_book_page.html");
            BufferedReader htmlIn = new BufferedReader(new InputStreamReader(pageIn));
            StringBuilder htmlBuild = new StringBuilder("");
            String lineIn;
            while ((lineIn = htmlIn.readLine()) != null) {
                htmlBuild.append(lineIn);
            }
            htmlIn.close();

            String embeddedPage = htmlBuild.toString().replace("$ISBN$", isbn);
            webView.loadData(embeddedPage, "text/html", "utf-8");
        }
        catch(IOException ioe){
            webView.loadData
                    ("<html><head></head><body>Whoops! Something went wrong.</body></html>",
                            "text/html", "utf-8");
            ioe.printStackTrace();
        }


    }
}
