package com.br.equipe.oito.presente

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.br.equipe.oito.presente.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setWebView()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setWebView() {
        binding.webView.apply {
            loadUrl("https://www.google.com/")
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            setOnKeyListener(object : View.OnKeyListener {
                override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {
                    if (event.action == KeyEvent.ACTION_DOWN) {
                        val webView = v as WebView
                        when (keyCode) {
                            KeyEvent.KEYCODE_BACK -> if (webView.canGoBack()) {
                                webView.goBack()
                                return true
                            }
                        }
                    }
                    return false
                }
            })
        }
    }

}