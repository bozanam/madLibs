package com.example.bozana.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class first_choose extends AppCompatActivity {

    Button btnTarzan, btnSimple, btnUniversity, btnDance, btnClothes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstchoose);





    }






    public void onClick(View view) {
        String filename = null;
        switch (view.getId()) {
            case R.id.btnClothes:
                filename = new String();
                filename = "madlibs3_clothes.txt";
                break;
            case R.id.btnDance:
                filename = "madlibs4_dance.txt";
                break;
            case R.id.btnSimple:
                filename = "madlibs0_simple.txt";
                break;
            case R.id.btnTarzan:
                filename = "madlibs1_tarzan.txt";
                break;
            case R.id.btnUniversity:
                filename = "madlibs2_university.txt";
                break;
            default:
                break;
        }
        Intent intent = new Intent(this, InputActivity.class);
        intent.putExtra("Story", filename);
        startActivity(intent);
        finish();
    }



}
