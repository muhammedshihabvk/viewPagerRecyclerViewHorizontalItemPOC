package com.shabsudemy.viewpagerrecyclerviewpoc.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.shabsudemy.viewpagerrecyclerviewpoc.R;

import java.util.List;

public class ImageViewAdapter extends RecyclerView.Adapter<ImageViewAdapter.CustomViewHolder> {

    List<String> imageList;
    private Context context;

    public ImageViewAdapter(Context context, List<String> imageList) {
        this.context = context;
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_imageview_layout, parent, false);
        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewAdapter.CustomViewHolder holder, int position) {
        Glide.with(context).load(imageList.get(position)).into(holder.imageView);
        Log.d("TAG", String.valueOf(imageList.get(position)));
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewForViewPager);
        }

    }
}
