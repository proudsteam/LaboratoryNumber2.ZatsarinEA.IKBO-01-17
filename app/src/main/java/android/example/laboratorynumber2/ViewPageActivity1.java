package android.example.laboratorynumber2;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class ViewPageActivity1 extends MainActivity {

    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page1);
        Intent intent = getIntent();
        int iter = intent.getIntExtra("iterator",0);


       viewPager = findViewById(R.id.viewPager);
       Log.d("Zheka", "" +arrayList.size());

      MyViewPagerAdapter adapter = new MyViewPagerAdapter(arrayList,ViewPageActivity1.this);
      viewPager.setAdapter(adapter);
      viewPager.setCurrentItem(iter);
    }
}
