package com.example.bozana.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class InputActivity extends AppCompatActivity {

    public Story stry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        if (savedInstanceState != null) {
            stry = (Story) savedInstanceState.getSerializable("stry");
            // check mObjectA == mObjectA.getObjectBList().get(0).getParent();

        } else {
            Intent intent = getIntent();
            String text = intent.getStringExtra("filename");
            InputStream is = null;
            try {
                is = getAssets().open(text);

            } catch (IOException e) {
                e.printStackTrace();
            }

            stry = new Story(is);
        }
        EditText test = (EditText) findViewById(R.id.placeholder);
        test.setHint(stry.getNextPlaceholder());
        TextView left = (TextView) findViewById(R.id.wordLeft);
        left.setText(stry.getPlaceholderRemainingCount() + " word(s) left");
        TextView type = (TextView) findViewById(R.id.type);
        type.setText("Please fill in a " + stry.getNextPlaceholder());

    }

    public void doThings(View view){
        EditText placeholder = (EditText) findViewById(R.id.placeholder);
        if (!placeholder.getText().toString().isEmpty()) {
            stry.fillInPlaceholder(placeholder.getText().toString());
            if (stry.isFilledIn() == true) {
                Intent intent = new Intent(this, showText.class);
                intent.putExtra("story", stry.toString());
                stry.clear();
                startActivity(intent);
                finish();
            } else {
                EditText test = (EditText) findViewById(R.id.placeholder);
                test.setText("");
                test.setHint(stry.getNextPlaceholder());
                TextView left = (TextView) findViewById(R.id.wordLeft);
                left.setText(stry.getPlaceholderRemainingCount() + " word(s) left");
                TextView type = (TextView) findViewById(R.id.type);
                type.setText("Please fill in a " + stry.getNextPlaceholder());
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putSerializable("stor", stry);
    }

}



