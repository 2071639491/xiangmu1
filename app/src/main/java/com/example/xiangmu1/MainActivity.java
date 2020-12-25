package com.example.xiangmu1;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.xiangmu1.fragments.FristFragment;
import com.example.xiangmu1.fragments.MyFragment;
import com.example.xiangmu1.fragments.OneFragment;
import com.example.xiangmu1.fragments.ShopFragment;
import com.example.xiangmu1.fragments.SortFragment;

public class MainActivity extends AppCompatActivity {

    private RadioGroup mRg;
    private RadioButton mRb1;
    private RadioButton mRb2;
    private RadioButton mRb3;
    private RadioButton mRb4;
    private RadioButton mRb5;
    private FragmentManager supportFragmentManager;
    private FristFragment fristFragment;
    private MyFragment myFragment;
    private OneFragment oneFragment;
    private ShopFragment shopFragment;
    private SortFragment sortFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mRg = (RadioGroup) findViewById(R.id.rg);
        mRb1 = (RadioButton) findViewById(R.id.rb1);
        mRb2 = (RadioButton) findViewById(R.id.rb2);
        mRb3 = (RadioButton) findViewById(R.id.rb3);
        mRb4 = (RadioButton) findViewById(R.id.rb4);
        mRb5 = (RadioButton) findViewById(R.id.rb5);


        fristFragment = new FristFragment();
        myFragment = new MyFragment();
        oneFragment = new OneFragment();
        shopFragment = new ShopFragment();
        sortFragment = new SortFragment();
        supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frag,fristFragment).add(R.id.frag,myFragment).add(R.id.frag,oneFragment).add(R.id.frag,shopFragment).add(R.id.frag,sortFragment)
                .hide(myFragment).hide(oneFragment).hide(shopFragment).hide(sortFragment).commit();


        mRb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
                fragmentTransaction.show(fristFragment).hide(myFragment).hide(oneFragment).hide(shopFragment).hide(sortFragment).commit();
            }
        });


        mRb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
                fragmentTransaction.show(sortFragment).hide(fristFragment).hide(oneFragment).hide(shopFragment).hide(myFragment).commit();
            }
        });

        mRb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
                fragmentTransaction.show(oneFragment).hide(fristFragment).hide(shopFragment).hide(myFragment).hide(sortFragment).commit();
            }
        });

        mRb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
                fragmentTransaction.show(shopFragment).hide(fristFragment).hide(oneFragment).hide(myFragment).hide(sortFragment).commit();
            }
        });

        mRb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
                fragmentTransaction.show(myFragment).hide(fristFragment).hide(oneFragment).hide(shopFragment).hide(sortFragment).commit();
            }
        });
    }
}