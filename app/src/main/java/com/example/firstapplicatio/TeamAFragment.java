package com.example.firstapplicatio;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

import java.util.Objects;


public class TeamAFragment extends Fragment implements View.OnClickListener {
View vi,vii,viii;
int scoreTeamA=0,wicketTeamA=0,ballTeamA=0,overTeamA=0;
    int over=0;
Button btn6,btn4,btn3,btn2,btn1,Reset;
Button wicket,ball;
private AdView adView;
private RewardedAd rewardedAd;



    public TeamAFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_team_a, container, false);
        btn6=view.findViewById(R.id.btn1);
        btn4=view.findViewById(R.id.btn2);
        btn3=view.findViewById(R.id.btn3);
        btn2=view.findViewById(R.id.btn4);
        btn1=view.findViewById(R.id.btn5);
        wicket=view.findViewById(R.id.team_a_wicket);
        ball=view.findViewById(R.id.balls);
        Reset=view.findViewById(R.id.reset);


        btn6.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn1.setOnClickListener(this);
        wicket.setOnClickListener(this);
        ball.setOnClickListener(this);
        Reset.setOnClickListener(this);

        LayoutInflater layoutInflater=getLayoutInflater();
        vi= layoutInflater.inflate(R.layout.toast, (ViewGroup) view.findViewById(R.id.toast_layout));
        LayoutInflater layoutInflater2=getLayoutInflater();
        vii= layoutInflater2.inflate(R.layout.toast_four, (ViewGroup) view.findViewById(R.id.toast_layout_four));
        LayoutInflater layoutInflater3=getLayoutInflater();
        viii= layoutInflater3.inflate(R.layout.toast_out, (ViewGroup) view.findViewById(R.id.toast_layout_out));
        adView=view.findViewById(R.id.adView);
        AdRequest adRequest= new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        rewardedAd = new RewardedAd(getContext(),
                "ca-app-pub-4875345024018177/5649327673");

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



        return  view;



    }

    private void displayTeamA(int scoreTeamA) {
        TextView scoreview=getView().findViewById(R.id.team_a_score);
        scoreview.setText(String.valueOf(scoreTeamA));
    }


    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btn1:
                Toast mytoast = new Toast(getContext());
                mytoast.setDuration(Toast.LENGTH_SHORT);
                mytoast.setGravity(Gravity.FILL,0,0);
                mytoast.setView(vi);
                mytoast.show();
                MediaPlayer mp=MediaPlayer.create(getContext(),R.raw.for_six);
                mp.start();
                scoreTeamA=scoreTeamA+6;
                displayTeamA(scoreTeamA);
                break;
            case R.id.btn2:
                Toast mytoast2 = new Toast(getContext());
                mytoast2.setDuration(Toast.LENGTH_SHORT);
                mytoast2.setGravity(Gravity.FILL,0,0);
                mytoast2.setView(vii);
                mytoast2.show();
                MediaPlayer mp2=MediaPlayer.create(getContext(),R.raw.for_four);
                mp2.start();
                scoreTeamA=scoreTeamA+4;
                displayTeamA(scoreTeamA);
                break;
            case R.id.btn3:
                scoreTeamA=scoreTeamA+3;
                displayTeamA(scoreTeamA);
                break;
            case R.id.btn4:
                scoreTeamA=scoreTeamA+2;
                displayTeamA(scoreTeamA);
                break;
            case R.id.btn5:
                scoreTeamA=scoreTeamA+1;
                displayTeamA(scoreTeamA);
                break;
            case R.id.team_a_wicket:
                Toast mytoast3 = new Toast(getContext());
                mytoast3.setDuration(Toast.LENGTH_SHORT);
                mytoast3.setGravity(Gravity.FILL,0,0);
                mytoast3.setView(viii);
                mytoast3.show();
                MediaPlayer mp3=MediaPlayer.create(getContext(),R.raw.for_wicket);
                mp3.start();
                wicketTeamA=wicketTeamA+1;
                displayTeamWicket(wicketTeamA);
                if(wicketTeamA==11)
                {
                    displayTeamWicket(0);
                    wicketTeamA=0;
                }
                break;
            case R.id.balls:

                ballTeamA=ballTeamA+1;
                displayBallA(ballTeamA);
                if (ballTeamA==7)
                {
                    over=over+1;
                    Toast.makeText(getContext(),String.valueOf(over)+" Over",Toast.LENGTH_SHORT).show();
                    overTeamA=overTeamA+1;
                    displayOverA(overTeamA);
                    displayBallA(0);
                    ballTeamA=0;
                }
                break;
            case R.id.reset:
            {
                displayBallA(0);
                displayTeamWicket(0);
                displayOverA(0);
                displayTeamA(0);
                scoreTeamA=0;
                ballTeamA=0;
                wicketTeamA=0;
                overTeamA=0;
                Toast.makeText(getContext(),"Data Erased",Toast.LENGTH_SHORT).show();
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

    private void displayOverA(int overTeamA) {
        TextView overText=getView().findViewById(R.id.team_a_over);
        overText.setText(String.valueOf(overTeamA));
    }


    private void displayBallA(int ballTeamA) {
        TextView balltext= getView().findViewById(R.id.team_a_ball);
        balltext.setText(String.valueOf(ballTeamA));
    }

    private void displayTeamWicket(int wicketTeamA) {
        TextView out=getView().findViewById(R.id.wicket);
        out.setText(String.valueOf(wicketTeamA));
    }
}



