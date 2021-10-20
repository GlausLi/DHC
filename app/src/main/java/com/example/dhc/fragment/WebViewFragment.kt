package com.example.dhc.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.dhc.R

class WebViewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_web_view, container, false)

        val webView = view.findViewById<WebView>(R.id.webView)
        webView.apply {
            settings.apply {
                javaScriptEnabled = true
                setSupportZoom(true)
                loadWithOverviewMode = true
                useWideViewPort = true
                domStorageEnabled = true
            }
            webChromeClient = WebChromeClient()
            webViewClient = WebViewClient()
        }
        webView.loadUrl("https://www.google.com")

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            WebViewFragment().apply {
                arguments = Bundle().apply {
                }
            }

        fun newHelpInstance() =
            WebViewFragment().apply {
                arguments = Bundle().apply {
                }
            }
        fun newTermsInstance() =
            WebViewFragment().apply {
                arguments = Bundle().apply {
                }
            }

        fun newPolicyInstance() =
            WebViewFragment().apply {
                arguments = Bundle().apply {
                }
            }

        fun newContactInstance() =
            WebViewFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
