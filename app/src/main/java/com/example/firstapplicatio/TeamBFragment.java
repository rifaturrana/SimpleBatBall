package com.example.firstapplicatio;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;


public class TeamBFragment extends Fragment implements View.OnClickListener {
    View vi,vii,viii;
    int scoreTeamB=0,wicketTeamB=0,ballTeamB=0,overTeamB=0;
    Button btn6B,btn4B,btn3B,btn2B,btn1B,ResetB;
    Button wicketB,ballB;
   private InterstitialAd interstitialAd;
    private RewardedAd rewardedAd;
    public TeamBFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_team_b, container, false);
        btn6B=view.findViewById(R.id.sixB);
        btn4B=view.findViewById(R.id.fourB);
        btn3B=view.findViewById(R.id.threeB);
        btn2B=view.findViewById(R.id.twoB);
        btn1B=view.findViewById(R.id.oneB);
        wicketB=view.findViewById(R.id.team_b_wicket);
        ballB=view.findViewById(R.id.ballsB);
        ResetB=view.findViewById(R.id.resetB);
        btn6B.setOnClickListener(this);
        btn4B.setOnClickListener(this);
        btn3B.setOnClickListener(this);
        btn2B.setOnClickListener(this);
        btn1B.setOnClickListener(this);
        wicketB.setOnClickListener(this);
        ballB.setOnClickListener(this);
        ResetB.setOnClickListener(this);
        LayoutInflater layoutInflater=getLayoutInflater();
        vi= layoutInflater.inflate(R.layout.toast, (ViewGroup) view.findViewById(R.id.toast_layout));
        LayoutInflater layoutInflater2=getLayoutInflater();
        vii= layoutInflater2.inflate(R.layout.toast_four, (ViewGroup) view.findViewById(R.id.toast_layout_four));
        LayoutInflater layoutInflater3=getLayoutInflater();
        viii= layoutInflater3.inflate(R.layout.toast_out, (ViewGroup) view.findViewById(R.id.toast_layout_out));
        interstitialAd=new InterstitialAd(getContext());
        interstitialAd.setAdUnitId("ca-app-pub-4875345024018177/8637618948");//have to put interstitialAdUnitId
        interstitialAd.loadAd(new AdRequest.Builder().build());
       interstitialAd.setAdListener(new AdListener(){
           @Override
           public void onAdLoaded() {
               if(interstitialAd.isLoaded())
               {
                   interstitialAd.show();
               }
           }

       });
        rewardedAd = new RewardedAd(getContext(),
                "ca-app-pub-4875345024018177/5649327673");//have to put RewardedAdUnitId

        RewardedAdLoadCallback adLoadCallback = new RewardedAdLoadCallback() {
            @Override
            public void onRewardedAdLoaded() {
                // Ad successfully loaded.
            }

            @Override
            public void onRewardedAdFailedToLoad(LoadAdError adError) {
                // Ad failed to load.
            }
        };
        rewardedAd.loadAd(new AdRequest.Builder().build(), adLoadCallback);




        return view;

    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.sixB:
                MediaPlayer mp=MediaPlayer.create(getContext(),R.raw.for_six);
                mp.start();
                Toast mytoast = new Toast(getContext());
                mytoast.setDuration(Toast.LENGTH_SHORT);
                mytoast.setGravity(Gravity.FILL,0,0);
                mytoast.setView(vi);
                mytoast.show();

                scoreTeamB=scoreTeamB+6;
                displayTeamB(scoreTeamB);
                break;
            case R.id.fourB:
                Toast mytoast2 = new Toast(getContext());
                mytoast2.setDuration(Toast.LENGTH_SHORT);
                mytoast2.setGravity(Gravity.FILL,0,0);
                mytoast2.setView(vii);
                mytoast2.show();
                MediaPlayer mp2=MediaPlayer.create(getContext(),R.raw.for_four);
                mp2.start();
                scoreTeamB=scoreTeamB+4;
                displayTeamB(scoreTeamB);
                break;
            case R.id.threeB:
                scoreTeamB=scoreTeamB+3;
                displayTeamB(scoreTeamB);
                break;
            case R.id.twoB:
                scoreTeamB=scoreTeamB+2;
                displayTeamB(scoreTeamB);
                break;
            case R.id.oneB:
                scoreTeamB=scoreTeamB+1;
                displayTeamB(scoreTeamB);
                break;
            case R.id.team_b_wicket:
                Toast mytoast3 = new Toast(getContext());
                mytoast3.setDuration(Toast.LENGTH_SHORT);
                mytoast3.setGravity(Gravity.FILL,0,0);
                mytoast3.setView(viii);
                mytoast3.show();
                MediaPlayer mp3=MediaPlayer.create(getContext(),R.raw.for_wicket);
                mp3.start();
                wicketTeamB=wicketTeamB+1;
                displayTeamWicketB(wicketTeamB);
                if(wicketTeamB==11)
                {
                    displayTeamWicketB(0);
                    wicketTeamB=0;
                }
                break;
            case R.id.ballsB:
                ballTeamB=ballTeamB+1;
                displayBallB(ballTeamB);
                if (ballTeamB==7)
                {
                    overTeamB=overTeamB+1;
                    displayOverB(overTeamB);
                    displayBallB(0);
                    ballTeamB=0;
                }
                break;
            case R.id.resetB:
            {
                displayBallB(0);
                displayTeamWicketB(0);
                displayOverB(0);
                displayTeamB(0);
                scoreTeamB=0;
                ballTeamB=0;
                wicketTeamB=0;
                overTeamB=0;
                if (rewardedAd.isLoaded()) {

                    RewardedAdCallback adCallback = new RewardedAdCallback() {
                        @Override
                        public void onRewardedAdOpened() {
                            // Ad opened.
                        }

                        @Override
                        public void onRewardedAdClosed() {
                            // Ad closed.
                        }

                        @Override
                        public void onUserEarnedReward(@NonNull RewardItem reward) {
                            // User earned reward.
                        }

                        @Override
                        public void onRewardedAdFailedToShow(AdError adError) {
                            // Ad failed to display.
                        }
                    };
                    rewardedAd.show((Activity) getContext(),adCallback);
                } else {
                    Log.d("TAG", "The rewarded ad wasn't loaded yet.");
                }


            }

            break;




        }
    }
    private void displayTeamB(int scoreTeamB) {
        TextView scoreview=getView().findViewById(R.id.team_b_score);
        scoreview.setText(String.valueOf(scoreTeamB));
    }
    private void displayOverB(int overTeamB) {
        TextView overText=getView().findViewById(R.id.team_b_over);
        overText.setText(String.valueOf(overTeamB));
    }


    private void displayBallB(int ballTeamB) {
        TextView balltext= getView().findViewById(R.id.team_b_ball);
        balltext.setText(String.valueOf(ballTeamB));
    }

    private void displayTeamWicketB(int wicketTeamB) {
        TextView out=getView().findViewById(R.id.wicketB);
        out.setText(String.valueOf(wicketTeamB));
    }
}