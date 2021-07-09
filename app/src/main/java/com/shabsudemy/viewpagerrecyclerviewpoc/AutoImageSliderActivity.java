package com.shabsudemy.viewpagerrecyclerviewpoc;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.shabsudemy.viewpagerrecyclerviewpoc.models.DataModel;
import com.shabsudemy.viewpagerrecyclerviewpoc.models.SliderAdapter;
import com.smarteist.autoimageslider.SliderView;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class AutoImageSliderActivity extends AppCompatActivity {

    SliderViewAdapter sliderViewAdapter;
    SliderView sliderView;
    List<DataModel> dataModelList = new ArrayList<DataModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_image_slider);

        generateData();

        sliderView = findViewById(R.id.slider);

        sliderViewAdapter = new SliderAdapter(this, dataModelList.get(0).getProductImage());
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        sliderView.setSliderAdapter(sliderViewAdapter);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();
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
        double sellingPrice = 200.50;
        double actualMRP = 400.75;
        boolean saleFlag = true;

        for (int i = 0; i < 10; i++) {
            dataModelList.add(new DataModel(productId + String.valueOf(i), productName + String.valueOf(i), productCategory + String.valueOf(i), sellingPrice, actualMRP, saleFlag, productImage));
        }
    }
}