package com.example.user.nevigation;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class events extends Fragment {
    TextView textView;
    View view;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_events, container, false);
        textView = (TextView) view.findViewById(R.id.text);
        String mystring = getResources().getString(R.string.cypher);
        textView.setText(mystring);


        return view;
    }



    }

