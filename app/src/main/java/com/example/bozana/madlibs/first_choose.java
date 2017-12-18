package com.example.bozana.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.Random;

public class first_choose extends AppCompatActivity {

    Button btnTarzan, btnSimple, btnUniversity, btnDance, btnClothes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstchoose);

    }

    public void simple(View v){
        Intent intent = new Intent(this, InputActivity.class);
        intent.putExtra("filename","madlib0_simple.txt");
        startActivity(intent);
        finish();
    }
    public void tarzan(View v){
        Intent intent = new Intent(this, InputActivity.class);
        intent.putExtra("filename","madlib1_tarzan.txt");
        startActivity(intent);
        finish();
    }
    public void university(View v){
        Intent intent = new Intent(this, InputActivity.class);
        intent.putExtra("filename","madlib2_university.txt");
        startActivity(intent);
        finish();
    }
    public void clothes(View v){
        Intent intent = new Intent(this, InputActivity.class);
        intent.putExtra("filename","madlib3_clothes.txt");
        startActivity(intent);
        finish();
    }
    public void dance(View v){
        Intent intent = new Intent(this, InputActivity.class);
        intent.putExtra("filename","madlib4_dance.txt");
        startActivity(intent);
        finish();
    }


}

