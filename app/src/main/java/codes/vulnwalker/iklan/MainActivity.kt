package codes.vulnwalker.iklan

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.gms.ads.*
import com.google.android.gms.ads.reward.RewardItem
import com.google.android.gms.ads.reward.RewardedVideoAd
import com.google.android.gms.ads.reward.RewardedVideoAdListener

class MainActivity : AppCompatActivity() {

    lateinit var mInterstitialAd: InterstitialAd
    lateinit var mRewardedVideoAd: RewardedVideoAd


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MobileAds.initialize(this,"ca-app-pub-7139939522364878~7212748339");

        //native
//        val mNativeExpressAdView = findViewById(R.id.adView2) as NativeExpressAdView
//
//        val request = AdRequest.Builder()
//                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
//                .addTestDevice("5DD3F07F839D23BB232AF58AA9665118")
//                .build()
//        mNativeExpressAdView.loadAd(request)
//
//        //popup ad
//        mInterstitialAd = InterstitialAd(this)
//        mInterstitialAd.adUnitId = "ca-app-pub-7139939522364878/8497909841"
//        mInterstitialAd.loadAd(AdRequest.Builder()
//                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
//                .addTestDevice("5DD3F07F839D23BB232AF58AA9665118")
//                .build())
//        mInterstitialAd.adListener = object : AdListener() {
//            override fun onAdLoaded() {
//                showInterstitialAd()
//            }
//        }
//
//
//        //baner
//        val adView = findViewById(R.id.adview) as AdView
//        val adRequest = AdRequest.Builder()
//                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
//                .addTestDevice("5DD3F07F839D23BB232AF58AA9665118")
//                .build()
//        adView.loadAd(adRequest)

        //video
        mRewardedVideoAd= MobileAds.getRewardedVideoAdInstance(this)
        mRewardedVideoAd.rewardedVideoAdListener=object : RewardedVideoAdListener {
            override fun onRewarded(rewardItem: RewardItem) {
                Toast.makeText(baseContext, "Ad triggered reward.", Toast.LENGTH_SHORT).show()
            }

            override fun onRewardedVideoAdLoaded() {
                Toast.makeText(baseContext, "Ad loaded.", Toast.LENGTH_SHORT).show()
                mRewardedVideoAd.show()
            }

            override fun onRewardedVideoAdOpened() {
                Toast.makeText(baseContext, "Ad opened.", Toast.LENGTH_SHORT).show()
            }

            override fun onRewardedVideoStarted() {
                Toast.makeText(baseContext, "Ad started.", Toast.LENGTH_SHORT).show()
            }

            override fun onRewardedVideoAdClosed() {
                Toast.makeText(baseContext, "Ad closed.", Toast.LENGTH_SHORT).show()
            }

            override fun onRewardedVideoAdLeftApplication() {
                Toast.makeText(baseContext, "Ad left application.", Toast.LENGTH_SHORT).show()
            }

            override fun onRewardedVideoAdFailedToLoad(i: Int) {
                Toast.makeText(baseContext, "Ad failed to load.", Toast.LENGTH_SHORT).show()
            }
        }
        mRewardedVideoAd.loadAd(("ca-app-pub-7139939522364878/5603442753"), AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("5DD3F07F839D23BB232AF58AA9665118")
                .build())
       // mRewardedVideoAd.show()

        val picuIklan = findViewById(R.id.picuIklan) as Button
        picuIklan.setOnClickListener{
            mRewardedVideoAd.show()
        }

    }

    fun showInterstitialAd() {
        if (mInterstitialAd.isLoaded) {
            mInterstitialAd.show();
        }
    }


}

