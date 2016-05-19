package com.hbdworld.ashello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    private int[] images = new int[]{R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4};
    private ImageView imageView ;
    private Integer currentIndex =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //--
        final Button my_btn = (Button) this.findViewById(R.id.my_btn);
        final Button btnFirst = (Button)this.findViewById(R.id.btnFirst);
        final Button btnNext = (Button)this.findViewById(R.id.btnNext);
        final Button btnPre = (Button)this.findViewById(R.id.btnPre);
        final Button btnLast = (Button)this.findViewById(R.id.btnLast);
        final TextView tv = (TextView)this.findViewById(R.id.tv);
        imageView = (ImageView)this.findViewById(R.id.imageView);

        my_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText(new Date().toString());
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex++;
                imageView.setImageResource(images[Math.abs(currentIndex)%4]);
                show(currentIndex.toString());
            }
        });

        btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex--;
                imageView.setImageResource(images[Math.abs(currentIndex)%4]);
                show(currentIndex.toString());
            }
        });

        btnLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = images.length-1;
                imageView.setImageResource(images[Math.abs(currentIndex)%4]);
                show(currentIndex.toString());
            }
        });
    }

    public void btnFirst_Click(View view) {
        currentIndex = 0;
        show(currentIndex.toString());
        imageView.setImageResource(images[Math.abs(currentIndex)]);
    }

    public void show(String text){
        final TextView tv = (TextView)this.findViewById(R.id.tv);
        tv.setText(text);
        Toast.makeText(getApplicationContext(), text,Toast.LENGTH_SHORT).show();
    }
}
