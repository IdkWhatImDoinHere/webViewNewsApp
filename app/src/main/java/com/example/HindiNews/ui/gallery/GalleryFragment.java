package com.example.HindiNews.ui.gallery;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.HindiNews.R;
import com.example.HindiNews.WebViewController;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        WebView webView= root.findViewById(R.id.webview_Aljazeera);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.prabhatkhabar.com/");
        webView.setWebViewClient(new WebViewController());


        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction()== KeyEvent.ACTION_DOWN)
                    if(keyCode==KeyEvent.KEYCODE_BACK){
                        if(webView!=null){
                            if(webView.canGoBack()){
                                webView.goBack();
                            }
                            else{
                                getActivity().onBackPressed();
                            }
                        }
                    }


                return true;
            }
        });

        return root;
    }
}