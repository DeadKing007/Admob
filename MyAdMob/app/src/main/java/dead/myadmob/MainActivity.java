package dead.myadmob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(getApplicationContext(),getString(R.string.appid_admob));

        AdView adView=findViewById(R.id.Smart_Banner);

        AdRequest.Builder builder=new AdRequest.Builder();
        builder.addTestDevice(AdRequest.DEVICE_ID_EMULATOR);


        AdRequest adRequest=builder.build();
        adView.loadAd(adRequest);

        Button interstitialAD=findViewById(R.id.interstitial);
        interstitialAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,InterstitialAdActivity.class);
                startActivity(intent);
            }
        });

    }
}
