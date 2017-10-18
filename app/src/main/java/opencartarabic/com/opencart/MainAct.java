package opencartarabic.com.opencart;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * Created by Inzimam on 18-Oct-17.
 */

public class MainAct extends AppCompatActivity{
    Context context;
    String link = "http://www.opensourcecart.com/index.php?route=mobile_app/home";// global variable
    private WebView mWebview;
    private static final String TAG = "Main";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = this;

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        this.mWebview = (WebView)findViewById(R.id.myWebView);

        WebSettings settings = mWebview.getSettings();
        settings.setJavaScriptEnabled(true);
        mWebview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);

        mWebview.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.i(TAG, "Processing mWebview url click...");
                view.loadUrl(url);
                return true;
            }

            public void onPageFinished(WebView view, String url) {
                Log.i(TAG, "Finished loading URL: " +url);

            }

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Log.e(TAG, "Error: " + description);
                Toast.makeText(context, "Oh no! " + description,
                        Toast.LENGTH_SHORT).show();
            }
        });
        mWebview.loadUrl("http://www.google.com");
    }
}
