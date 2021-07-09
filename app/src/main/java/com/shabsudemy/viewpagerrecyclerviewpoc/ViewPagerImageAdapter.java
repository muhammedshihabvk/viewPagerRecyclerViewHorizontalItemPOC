package com.shabsudemy.viewpagerrecyclerviewpoc;

import android.content.Context;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ViewPagerImageAdapter extends RecyclerView.Adapter<ViewPagerImageAdapter.CustomViewHolder> {

    List<String> imageList;
    private Context context;

    public ViewPagerImageAdapter(Context context, List<String> imageList) {
        this.context = context;
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_imageview_layout, parent, false);
        view.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                Log.d("TAG",String.valueOf(event.getAction()));
                return false;
            }
        });
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerImageAdapter.CustomViewHolder holder, int position) {
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
