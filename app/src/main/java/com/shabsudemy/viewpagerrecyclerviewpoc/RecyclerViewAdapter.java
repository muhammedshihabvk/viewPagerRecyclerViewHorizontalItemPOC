package com.shabsudemy.viewpagerrecyclerviewpoc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.viewpager2.widget.ViewPager2;

import com.shabsudemy.viewpagerrecyclerviewpoc.models.DataModel;
import com.smarteist.autoimageslider.SliderView;

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
        ViewPagerImageAdapter viewPagerImageAdapter;

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
            viewPagerImageAdapter = new ViewPagerImageAdapter(context, dataModel.getProductImage());
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
            //            viewPager2.setAdapter(viewPagerImageAdapter);



            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setHasFixedSize(true);
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setAdapter(viewPagerImageAdapter);

            SnapHelper snapHelper = new LinearSnapHelper();
            recyclerView.setOnFlingListener(null);
            snapHelper.attachToRecyclerView(recyclerView);


            recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
                @Override
                public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                    return false;
                }

                @Override
                public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                    Toast.makeText(context, "onTouch even happed", Toast.LENGTH_SHORT).show();
                    int action = e.getAction();
                    switch (action) {
                        case MotionEvent.ACTION_SCROLL:
                            recyclerView.getParent().requestDisallowInterceptTouchEvent(true);
                            break;
                        case MotionEvent.ACTION_UP:
                            recyclerView.getParent().requestDisallowInterceptTouchEvent(false);
                            break;

                        case MotionEvent.ACTION_MOVE:
                            recyclerView.getParent().requestDisallowInterceptTouchEvent(true);
                            break;
                    }
                }

                @Override
                public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

                }
            });

            productName.setText(dataModel.getProductName());
            productCategory.setText(dataModel.getProductCategory());
            actualMRP.setText(String.valueOf(dataModel.getActualMRP()));
            sellingPrice.setText(String.valueOf(dataModel.getSellingPrice()));
        }
    }
}
