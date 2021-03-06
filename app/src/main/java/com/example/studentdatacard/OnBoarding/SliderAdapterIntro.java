package com.example.studentdatacard.OnBoarding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.airbnb.lottie.LottieAnimationView;
import com.example.studentdatacard.R;

public class SliderAdapterIntro extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapterIntro(Context context){
        this.context=context;
    }
    //array of images
    public String[] slide_images={

            "welcome.json",

            "yourdata.json",

            "uploading.json",

            "preview.json",

            "security.json"


    };

    //array of images
    public String[] slide_title={
            "Student Data Card"
            ,"Your Documents"
            ,"Upload"
            ,"Preview Your Documents"
            ,"Secured"
    };

    //array of images
    public String[] slide_description={
            "Student Data Card is app which can store your important documents"
            ," Document are important in day to day life"
            ," Upload your files with encryption"
            ,"Manage and  preview your Documents"
            ,"Don't worry Your documents are safe in our data base"
    };

    @Override
    public int getCount() {
        return slide_title.length;
    }



    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(RelativeLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view =layoutInflater.inflate(R.layout.slide_layout,container,false);

        //ImageView slideImageView=(ImageView)view.findViewById(R.id.intro_img);
        TextView slideTitle=(TextView) view.findViewById(R.id.intro_title);
        LottieAnimationView slideImageView=(LottieAnimationView)view.findViewById(R.id.intro_img);
        //slideImageView.setSpeed(200f);


        TextView slideDescription=(TextView) view.findViewById(R.id.intro_description);

        slideImageView.setAnimation(slide_images[position]);
        slideTitle.setText(slide_title[position]);
        slideDescription.setText(slide_description[position]);

        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
