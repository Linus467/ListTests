package com.example.listtest

import android.net.http.SslError
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.SslErrorHandler
import android.webkit.WebView
import android.webkit.WebViewClient

class WebviewActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        var president = intent.getStringExtra("president")
        // replace all spaces with the underscore character
        president = president?.replace(" ", "_");
        // All of our wikipedia pages will start with the same string and then the name of the president
        val fullURL = "http://en.m.wikipedia.org/wiki/$president"
        webView.webViewClient = USNAWebViewClient()
        webView.loadUrl(fullURL)
    }
    //extend WebViewCLient class
    private class USNAWebViewClient :  WebViewClient() {

        //these errors might be sent due to missing CA
        override fun onReceivedSslError(
            view: WebView?,
            handler: SslErrorHandler?,
            error: SslError?
        ) {
            Log.e("IT472", "SSL error: " + error.toString())
            //not recommended, but needed due to missing CA on AVDs
            handler?.proceed()
            //super.onReceivedSslError(view, handler, error)
        }

    }
}