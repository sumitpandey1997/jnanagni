package com.example.user.nevigation;

/**
 * Created by user on 19-06-2018.
 */

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TabFragment extends Fragment {

    private Integer[] one = {
            R.drawable.t1, R.drawable.t2,
            R.drawable.t3, R.drawable.t4,
    };
    private Integer[] two = {
            R.drawable.nt1, R.drawable.nt2,
            R.drawable.nt3, R.drawable.nt4,
    };
    private Integer[] three = {
            R.drawable.g1, R.drawable.g2,
            R.drawable.g3, R.drawable.g4,
            R.drawable.g5, R.drawable.g6,
    };
    private Integer[] four = {
            R.drawable.mg1, R.drawable.mg2,
            R.drawable.mg3, R.drawable.mg4,

    };
    private Integer[] five = {
            R.drawable.cul1, R.drawable.cul2

    };
    private Integer[] six = {
            R.drawable.fun1, R.drawable.fun2

    };






    int position;
    private ImageView imageView;

    public static Fragment getInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("pos", position);
        TabFragment tabFragment = new TabFragment();
        tabFragment.setArguments(bundle);
        return tabFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("pos");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // imageView = view.findViewById(R.id.textView);

        GridView gridview = (GridView) view.findViewById(R.id.gridview);

        switch (position) {
            case 0:
                gridview.setAdapter(new ImageAdapter(getContext(), one));

                gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View v,
                                            int position, long id) {
                        Toast.makeText(getContext(), "READ CAREFULLY" ,
                                Toast.LENGTH_SHORT).show();
                        final Dialog dialog = new Dialog(getContext());
                        dialog.setContentView(R.layout.eventdiscription);
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        TextView text = (TextView) dialog.findViewById(R.id.dtv);
                        String mystring = getResources().getString(R.string.cypher);
                        text.setText(mystring);
                        ImageView image = (ImageView) dialog.findViewById(R.id.imageV);
                        image.setImageResource(one[position]);
                        Button dialogButton = (Button) dialog.findViewById(R.id.Dbtn);
                        // if button is clicked, close the custom dialog
                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getContext());

                                boolean loggedIn = sharedPref.getBoolean("loggedin", false);
                                if(loggedIn){
                                    String user = sharedPref.getString("LoggedInUser","");
                                    Toast.makeText(getContext(), "register succesfull",
                                            Toast.LENGTH_SHORT).show();
                                }
                                else {


                                    Toast.makeText(getContext(), "pls login first",
                                            Toast.LENGTH_SHORT).show();
                                }

                                dialog.dismiss();
                            }
                        });


                        dialog.show();

                      /*  Display display =((WindowManager)getSystemService(getContext().WINDOW_SERVICE)).getDefaultDisplay();
                        int width = display.getWidth();
                        int height=display.getHeight();

                        Log.v("width", width+"");
                        dialog.getWindow().setLayout((6*width)/7,(4*height)/5);
*/
                        /*if(position==0) {


                            FragmentManager fragmentManager = getFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.eventD, new events());
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                        }*/

                    }

                });
                break;

             case 1:
                gridview.setAdapter(new ImageAdapter(getContext(), two));

                gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View v,
                                            int position, long id) {
                        Toast.makeText(getContext(), "READ CAREFULLY" ,
                                Toast.LENGTH_SHORT).show();
                        final Dialog dialog = new Dialog(getContext());
                        dialog.setContentView(R.layout.eventdiscription);
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        TextView text = (TextView) dialog.findViewById(R.id.dtv);
                        String mystring = getResources().getString(R.string.cypher);
                        text.setText(mystring);
                        ImageView image = (ImageView) dialog.findViewById(R.id.imageV);
                        image.setImageResource(two[position]);
                        Button dialogButton = (Button) dialog.findViewById(R.id.Dbtn);
                        // if button is clicked, close the custom dialog
                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getContext(), "pls login first",
                                        Toast.LENGTH_SHORT).show();

                                dialog.dismiss();
                            }
                        });


                        dialog.show();
                    }
                });
                break;
            case 2:
                gridview.setAdapter(new ImageAdapter(getContext(), three));
                gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View v,
                                            int position, long id) {
                        Toast.makeText(getContext(), "READ CAREFULLY" ,
                                Toast.LENGTH_SHORT).show();
                        final Dialog dialog = new Dialog(getContext());
                        dialog.setContentView(R.layout.eventdiscription);
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        TextView text = (TextView) dialog.findViewById(R.id.dtv);
                        String mystring = getResources().getString(R.string.cypher);
                        text.setText(mystring);
                        ImageView image = (ImageView) dialog.findViewById(R.id.imageV);
                        image.setImageResource(three[position]);
                        Button dialogButton = (Button) dialog.findViewById(R.id.Dbtn);
                        // if button is clicked, close the custom dialog
                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getContext(), "pls login first",
                                        Toast.LENGTH_SHORT).show();

                                dialog.dismiss();
                            }
                        });


                        dialog.show();
                    }


                });
                break;
            case 3:
                gridview.setAdapter(new ImageAdapter(getContext(), four));
                gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View v,
                                            int position, long id) {
                        Toast.makeText(getContext(), "" + position,
                                Toast.LENGTH_SHORT).show();
                    }


                });
                break;
            case 4:
                gridview.setAdapter(new ImageAdapter(getContext(), five));
                gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View v,
                                            int position, long id) {
                        Toast.makeText(getContext(), "" + position,
                                Toast.LENGTH_SHORT).show();
                    }


                });
                break;
            case 5:
                gridview.setAdapter(new ImageAdapter(getContext(), six));
                gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View v,
                                            int position, long id) {
                        Toast.makeText(getContext(), "" + position,
                                Toast.LENGTH_SHORT).show();
                    }


                });
                break;



        }
}
}



