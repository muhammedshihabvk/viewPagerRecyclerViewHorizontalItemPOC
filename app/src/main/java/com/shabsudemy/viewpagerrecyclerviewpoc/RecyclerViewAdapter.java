package com.shabsudemy.viewpagerrecyclerviewpoc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.shabsudemy.viewpagerrecyclerviewpoc.models.DataModel;
import com.shabsudemy.viewpagerrecyclerviewpoc.models.SliderAdapter;
import com.smarteist.autoimageslider.SliderView;
import com.smarteist.autoimageslider.SliderViewAdapter;


import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder> {

    private  Context context;
    private List<DataModel> dataModelList;
    private ItemOnclickHandler itemOnclickHandler;

    public RecyclerViewAdapter(Context context, List<DataModel> dataModelList, ItemOnclickHandler itemOnclickHandler) {
        this.context = context;
        this.dataModelList = dataModelList;
        this.itemOnclickHandler = itemOnclickHandler;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_row_layout_card,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerViewAdapter.CustomViewHolder holder, int position) {
        DataModel currentDataModel = dataModelList.get(position);
        holder.bindData(currentDataModel);
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        ViewPager2 viewPager2;
        SliderView sliderView;
        SliderViewAdapter sliderViewAdapter;
        TextView productName,productCategory,actualMRP,sellingPrice;
        ViewPagerImageAdapter viewPagerImageAdapter;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            viewPager2 = itemView.findViewById(R.id.viewPager);
//            sliderView = itemView.findViewById(R.id.slider);
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

        void bindData(DataModel dataModel){
            viewPagerImageAdapter = new ViewPagerImageAdapter(context,dataModel.getProductImage());
//            viewPager2.canScrollVertically(View.SCROLL_AXIS_HORIZONTAL);
//            float pageMargin = 400;
//            float pageOffset = 400;
//            viewPager2.setPageTransformer((page, position) -> {
//                float myOffset = position * -(2 * pageOffset + pageMargin);
//                if (position < -1) {
//                    page.setTranslationX(-myOffset);
//                } else if (position <= 1) {
//                    float scaleFactor = Math.max(0.7f, 1 - Math.abs(position - 0.14285715f));
//                    page.setTranslationX(myOffset);
//                    page.setScaleY(scaleFactor);
//                    page.setAlpha(scaleFactor);
//                } else {
//                    page.setAlpha(0);
//                    page.setTranslationX(myOffset);
//                }
//            });
            viewPager2.setAdapter(viewPagerImageAdapter);

//            sliderViewAdapter = new SliderAdapter(context,dataModel.getProductImage());
//            sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
//            sliderView.setSliderAdapter(sliderViewAdapter);
//            sliderView.setScrollTimeInSec(3);
//            sliderView.setAutoCycle(true);
//            sliderView.startAutoCycle();

            productName.setText(dataModel.getProductName());
            productCategory.setText(dataModel.getProductCategory());
            actualMRP.setText(String.valueOf(dataModel.getActualMRP()));
            sellingPrice.setText(String.valueOf(dataModel.getSellingPrice()));
        }
    }

    interface ItemOnclickHandler{
        void onItemClicked(DataModel dataModel);
    }
}
