package com.shabsudemy.viewpagerrecyclerviewpoc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.viewpager2.widget.ViewPager2;

import com.shabsudemy.viewpagerrecyclerviewpoc.adapter.ImageViewAdapter;
import com.shabsudemy.viewpagerrecyclerviewpoc.models.DataModel;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder> {

    private Context context;
    private List<DataModel> dataModelList;
    private ItemOnclickHandler itemOnclickHandler;

    public RecyclerViewAdapter(Context context, List<DataModel> dataModelList, ItemOnclickHandler itemOnclickHandler) {
        this.context = context;
        this.dataModelList = dataModelList;
        this.itemOnclickHandler = itemOnclickHandler;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_row_layout_card, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.CustomViewHolder holder, int position) {
        DataModel currentDataModel = dataModelList.get(position);
        holder.bindData(currentDataModel);
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    interface ItemOnclickHandler {
        void onItemClicked(DataModel dataModel);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        ViewPager2 viewPager2;
        TextView productName, productCategory, actualMRP, sellingPrice;
        ImageViewAdapter imageViewAdapter;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
//            viewPager2 = itemView.findViewById(R.id.viewPager);
            recyclerView = itemView.findViewById(R.id.imageRecyclerview);
            productName = itemView.findViewById(R.id.productName);
            productCategory = itemView.findViewById(R.id.productCategory);
            actualMRP = itemView.findViewById(R.id.actualMRP);
            sellingPrice = itemView.findViewById(R.id.sellingPrice);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemOnclickHandler.onItemClicked(dataModelList.get(getAdapterPosition()));
                }
            });
        }

        void bindData(DataModel dataModel) {
            imageViewAdapter = new ImageViewAdapter(context, dataModel.getProductImage());

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setHasFixedSize(true);
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setAdapter(imageViewAdapter);

            SnapHelper snapHelper = new LinearSnapHelper();
            recyclerView.setOnFlingListener(null);
            snapHelper.attachToRecyclerView(recyclerView);

            productName.setText(dataModel.getProductName());
            productCategory.setText(dataModel.getProductCategory());
            actualMRP.setText(String.valueOf(dataModel.getActualMRP()));
            sellingPrice.setText(String.valueOf(dataModel.getSellingPrice()));
        }
    }
}
