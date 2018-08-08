package com.example.user.nevigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 17-06-2018.
 */

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<String> name;
    ArrayList<String> number;
    ArrayList<String> branch;
    private ItemClicked itemClicked;


    public CustomRecyclerAdapter(Context context, ArrayList<String> name, ArrayList<String> number,ArrayList<String> branch) {

        this.context = context;
        this.name = name;
        this.number = number;
        this.branch = branch;
    }
    public void setClickListner(ItemClicked item)
    {
        itemClicked=item;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @SuppressLint("WrongConstant")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if(position%2==0)
        {

            holder.pName.setText(name.get(position));
            holder.number.setText(number.get(position));
            holder.branch.setText(branch.get(position));
            holder.imageView.setImageResource(R.drawable.call);
        }

else {
            holder.pName.setText(name.get(position));
            holder.number.setText(number.get(position));
            holder.branch.setText(branch.get(position));
            holder.imageView.setImageResource(R.drawable.call);
        }



    }

    @Override
    public int getItemCount() {
        return name.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView pName;
        public TextView number;
        public TextView branch;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            pName =  itemView.findViewById(R.id.pNametxt);
            number =  itemView.findViewById(R.id.number);
            branch = itemView.findViewById(R.id.branch);
            imageView=itemView.findViewById(R.id.userImg);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            itemClicked.onClick(view,getAdapterPosition());


        }

    }
}
