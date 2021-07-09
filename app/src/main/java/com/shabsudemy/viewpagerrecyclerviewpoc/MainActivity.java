package com.shabsudemy.viewpagerrecyclerviewpoc;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.shabsudemy.viewpagerrecyclerviewpoc.models.DataModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemOnclickHandler {

    RecyclerView recyclerView;
    List<DataModel> dataModelList = new ArrayList<DataModel>();
    RecyclerViewAdapter recyclerViewAdapter;


    ViewPager2 viewPager2;
    ViewPagerImageAdapter viewPagerImageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateData();

        recyclerView = findViewById(R.id.recyclerview);

//        NestedScrollView scrollView = findViewById (R.id.nest_scrollview);
//        scrollView.setFillViewport (true);



        viewPager2 = findViewById(R.id.viewPageTry);
        viewPagerImageAdapter = new ViewPagerImageAdapter(this,dataModelList.get(0).getProductImage());
        viewPager2.setAdapter(viewPagerImageAdapter);

        recyclerViewAdapter = new RecyclerViewAdapter(this,dataModelList,this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    void generateData(){
        List<String> productImage = new ArrayList<>();
        productImage.add("https://images-na.ssl-images-amazon.com/images/I/81JfxwJxYqL._UL1500_.jpg");
        productImage.add("https://m.media-amazon.com/images/I/81JjXCby7uL._UL1500_.jpg");
        productImage.add("https://m.media-amazon.com/images/I/71q3XiFrqSL._UL1500_.jpg");

        DataModel.setCurrency("AED");
        String productId = "product00";
        String productName = "Product Name";
        String productCategory = "product";
        double sellingPrice = 200.50;
        double actualMRP = 400.75;
        boolean saleFlag = true;

        for (int i = 0; i < 10; i++) {
            dataModelList.add(new DataModel(productId + String.valueOf(i), productName + String.valueOf(i), productCategory, sellingPrice, actualMRP, saleFlag, productImage));
        }
    }

    @Override
    public void onItemClicked(DataModel dataModel) {
        Log.d("TAG",dataModel.getProductName());
    }
}