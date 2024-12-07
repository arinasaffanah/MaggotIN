package com.capstone.maggotin.ui.article

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.capstone.maggotin.R

class DetailArticleActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_article)
        supportActionBar?.hide()

        webView = findViewById(R.id.webView)

        val url = intent.getStringExtra("URL")
        if (url != null) {
            webView.loadUrl(url)
        }

        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.setSupportMultipleWindows(true)
        webView.settings.javaScriptCanOpenWindowsAutomatically = true
        webView.webViewClient = WebViewClient()
        webView.settings.userAgentString = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36"
    }

    override fun onDestroy() {
        super.onDestroy()
        webView.destroy()
    }
}