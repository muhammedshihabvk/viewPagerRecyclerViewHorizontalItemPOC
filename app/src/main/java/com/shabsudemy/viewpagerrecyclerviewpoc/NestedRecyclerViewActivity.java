package com.shabsudemy.viewpagerrecyclerviewpoc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.Toast;

import com.shabsudemy.viewpagerrecyclerviewpoc.adapter.ImageViewAdapter;
import com.shabsudemy.viewpagerrecyclerviewpoc.models.DataModel;

import java.util.ArrayList;
import java.util.List;

public class NestedRecyclerViewActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemOnclickHandler{

    RecyclerView recyclerView;
    List<DataModel> dataModelList = new ArrayList<DataModel>();
    RecyclerViewAdapter recyclerViewAdapter;
    ViewPager2 viewPager2;
    ImageViewAdapter imageViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested_recycler_view);

        generateData();
        recyclerView = findViewById(R.id.recyclerview);
        viewPager2 = findViewById(R.id.viewPageTry);

        imageViewAdapter = new ImageViewAdapter(this, dataModelList.get(0).getProductImage());
        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        viewPager2.setAdapter(imageViewAdapter);

        recyclerViewAdapter = new RecyclerViewAdapter(this, dataModelList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setNestedScrollingEnabled(true);
    }

    void generateData() {
        List<String> productImage = new ArrayList<>();
        productImage.add("https://images-na.ssl-images-amazon.com/images/I/81JfxwJxYqL._UL1500_.jpg");
        productImage.add("https://m.media-amazon.com/images/I/81JjXCby7uL._UL1500_.jpg");
        productImage.add("https://m.media-amazon.com/images/I/71q3XiFrqSL._UL1500_.jpg");

        DataModel.setCurrency("AED");
        String productId = "product00";
        String productName = "Product Name";
        String productCategory = "product";
        double sellingPrice = 258.50;
        double actualMRP = 436.75;
        boolean saleFlag = true;

        for (int i = 1; i < 15; i++) {
            dataModelList.add(new DataModel(productId + String.valueOf(i), productName + String.valueOf(i), productCategory + String.valueOf(i), sellingPrice*i, actualMRP*i, saleFlag, productImage));
        }
    }

    @Override
    public void onItemClicked(DataModel dataModel) {
        Toast.makeText(this, String.valueOf(dataModel.getProductName()), Toast.LENGTH_SHORT).show();
    }
}