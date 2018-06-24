package dead.myadmob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class InterstitialAdActivity extends AppCompatActivity {

    private static final String TAG = InterstitialAdActivity.class.getName();
    InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial_ad);
        interstitialAd=new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));

        AdRequest.Builder builder=new AdRequest.Builder();
        builder.addTestDevice(AdRequest.DEVICE_ID_EMULATOR);


        AdRequest adRequest=builder.build();
        interstitialAd.loadAd(adRequest);

        interstitialAd.setAdListener(new AdListener(){

            @Override
            public void onAdClosed() {
                super.onAdClosed();
                Log.d(TAG,"Ad Closed");
                finish();
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                Log.d(TAG,"Failed to load Ad: "+i);
                Toast.makeText(InterstitialAdActivity.this,"Failed to load Ad",Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onAdLeftApplication() {
                super.onAdLeftApplication();
                Log.d(TAG,"Ad left application");
                finish();
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                Log.d(TAG,"Ad is loaded");
                showAd();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();

            }
        });



    }

    private void showAd() {

        if (interstitialAd.isLoaded()){

            interstitialAd.show();
        }else {
            Toast.makeText(this,"Error with Loading Ads",Toast.LENGTH_SHORT).show();
        }
    }
}
