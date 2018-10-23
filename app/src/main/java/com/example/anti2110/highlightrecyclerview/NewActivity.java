package com.example.anti2110.highlightrecyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anti2110.highlightrecyclerview.Common.Common;

public class NewActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_item);

        Toast.makeText(this, ""+Common.currentItem.isChecked(), Toast.LENGTH_SHORT).show();

        textView = findViewById(R.id.text_view);
        imageView = findViewById(R.id.image_view);

        textView.setText(Common.currentItem.getName());

        if(Common.currentItem.isChecked()) {
            imageView.setImageResource(R.drawable.ic_check_black_24dp);
        } else {
            imageView.setImageResource(R.drawable.ic_clear_black_24dp);
        }

    }


}
