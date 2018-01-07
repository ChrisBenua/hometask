package com.example.christian.hometask;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String KEY_SUBJECT = "subject";

    private Button btn;
    public static Bitmap BTMP;
    private EditText edt;
    public static final int CAMERA_PIC_REQ = 228;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn_photo);
        edt = findViewById(R.id.edt_txt);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!edt.getText().toString().isEmpty()) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, CAMERA_PIC_REQ);
                } else {
                    Toast.makeText(getApplicationContext(), R.string.emptystr, Toast.LENGTH_LONG);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_PIC_REQ && resultCode == RESULT_OK) {
            BTMP = (Bitmap) data.getExtras().get("data");
            Intent intent = new Intent(getApplicationContext(), ShowPhoto.class);
            intent.putExtra(ShowPhoto.KEY_NAME, edt.getText().toString());
            startActivity(intent);
        }
    }
}
