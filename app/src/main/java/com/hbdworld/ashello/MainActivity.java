package com.hbdworld.ashello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //--
        final Button my_btn = (Button) this.findViewById(R.id.my_btn);
        final Button btnNext = (Button)this.findViewById(R.id.btnNext);
        final Button btnLast = (Button)this.findViewById(R.id.btgLast);
        final TextView tv = (TextView)this.findViewById(R.id.tv);

        my_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText(new Date().toString());
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText(btnNext.getText());
            }
        });

        btnLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText(btnLast.getText());
            }
        });


//        int[] images = new int[R.drawable.img1];
//        ImageView imageView = (ImageView)this.findViewById(R.id.imageView);
//        imageView.setImageResource(images[0]);


    }
}
