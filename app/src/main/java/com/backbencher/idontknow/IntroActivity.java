package com.backbencher.idontknow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class IntroActivity extends AppCompatActivity {
ImageView app_name,logo,splashimg;
LottieAnimationView lotte;

private static final int NUM_PAGER=3;
private ViewPager viewPager;
private ScreenSlidePagerAdapter pagerAdapter;

Animation anim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        lotte=findViewById(R.id.Lotte);
        splashimg=findViewById(R.id.Splashimg);
        logo=findViewById(R.id.Logo);
        app_name=findViewById(R.id.App_name);

        viewPager=findViewById(R.id.pager);
        pagerAdapter=new ScreenSlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);


        anim= AnimationUtils.loadAnimation(this,R.anim.o_b_anim);
        viewPager.startAnimation(anim);


        splashimg.animate().translationY(-1600).setDuration(1000).setStartDelay(4000);
        logo.animate().translationY(1400).setDuration(1000).setStartDelay(4000);
        app_name.animate().translationY(1400).setDuration(1000).setStartDelay(4000);
        lotte.animate().translationY(1400).setDuration(1000).setStartDelay(4000);

    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter{


        public ScreenSlidePagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    OnBordingFragment1 tab1=new OnBordingFragment1();
                    return tab1;
                    case 1:
                    OnBordingFragment2 tab2=new OnBordingFragment2();
                    return tab2;
                    case 2:
                    OnBordingFragment3 tab3=new OnBordingFragment3();
                    return tab3;
            }
            return  null;
        }

        @Override
        public int getCount() {
            return NUM_PAGER;
        }
    }
}