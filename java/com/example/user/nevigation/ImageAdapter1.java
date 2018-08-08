package com.example.user.nevigation; /**
 * Created by user on 21-06-2018.
 */

import android.content.Context;

import android.support.v4.view.PagerAdapter;

import android.support.v4.view.ViewPager;

import android.view.View;

import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.nevigation.R;


/**

 * Created by SrceCde on 18-09-2015.

 */

public class ImageAdapter1 extends PagerAdapter {

    Context context;


    private int[] GalImages = new int[] {


              //Here first,second,third... are the name of the jpeg files placed in drawable folder

            R.drawable.b,
            R.drawable.c,
            R.drawable.a1,
            R.drawable.b2

    };

    ImageAdapter1(Context context){

        this.context=context;

    }

    @Override

    public int getCount() {

        return GalImages.length;

    }


    @Override

    public boolean isViewFromObject(View view, Object object) {

        return view == ((ImageView) object);

    }


    @Override

    public Object instantiateItem(ViewGroup container, int position) {

        TouchImageView imageView = new TouchImageView(context);
        TextView textView=new TextView(context);
        imageView.setImageResource(GalImages[position]);
        textView.setText("hii");
        textView.setTextColor(context.getResources().getColor(R.color.colorAccent));


        ((ViewPager) container).addView(imageView,50,50);
        ((ViewPager) container).addView(textView,10,10);

        return imageView;

    }


    @Override

    public void destroyItem(ViewGroup container, int position, Object object) {

        ((ViewPager) container).removeView((ImageView) object);

    }

}


