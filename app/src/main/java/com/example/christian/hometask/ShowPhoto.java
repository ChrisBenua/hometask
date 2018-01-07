package com.example.christian.hometask;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowPhoto extends AppCompatActivity {
    public static final String KEY_NAME = "KEY_NAME";
    private ImageView imageView;
    private TextView txtv;
    private Bitmap bm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_photo);
        imageView = findViewById(R.id.imgview);
        txtv = findViewById(R.id.txtvw);
        txtv.setText(getIntent().getStringExtra(KEY_NAME));
        imageView.setImageBitmap(MainActivity.BTMP);

    }
}
