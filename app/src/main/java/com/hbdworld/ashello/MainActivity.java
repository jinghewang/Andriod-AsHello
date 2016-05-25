package com.hbdworld.ashello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    private int[] images = new int[]{R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4};
    private ImageView imageView ;
    private Integer currentIndex =0;
    private Button my_btn = null;
    private Button btnFirst= null;
    private Button btnNext= null;
    private Button btnPre = null;
    private Button btnLast= null;
    private TextView tv = null;
    private Switch switch1 = null;
    private TextView switchText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //--
        my_btn = (Button) this.findViewById(R.id.my_btn);
        btnFirst = (Button)this.findViewById(R.id.btnFirst);
        btnNext = (Button)this.findViewById(R.id.btnNext);
        btnPre = (Button)this.findViewById(R.id.btnPre);
        btnLast = (Button)this.findViewById(R.id.btnLast);
        tv = (TextView)this.findViewById(R.id.tv);
        imageView = (ImageView)this.findViewById(R.id.imageView);
        switch1 = (Switch)this.findViewById(R.id.switch1);
        switchText = (TextView)this.findViewById(R.id.switchText);


        my_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                tv.setText(format2.format(new Date()));
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

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                switchText.setText(b ? "打开" : "关闭");
            }
        });
    }

    public void btnFirst_Click(View view) {
        currentIndex = 0;
        show(currentIndex.toString());
        imageView.setImageResource(images[Math.abs(currentIndex)]);
    }

    public void show(String text){
        tv.setText(text);
        Toast.makeText(getApplicationContext(), text,Toast.LENGTH_SHORT).show();
    }
}
