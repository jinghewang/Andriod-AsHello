package com.hbdworld.ashello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ImageActivity extends AppCompatActivity implements View.OnClickListener, ViewSwitcher.ViewFactory  {


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
    private ImageSwitcher imageSwitcher = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        //--
        my_btn = (Button) this.findViewById(R.id.my_btn);
        btnFirst = (Button)this.findViewById(R.id.btnFirst);
        btnNext = (Button)this.findViewById(R.id.btnNext);
        btnPre = (Button)this.findViewById(R.id.btnPre);
        btnLast = (Button)this.findViewById(R.id.btnLast);
        tv = (TextView)this.findViewById(R.id.tv);
        switch1 = (Switch)this.findViewById(R.id.switch1);
        switchText = (TextView)this.findViewById(R.id.switchText);
        imageSwitcher = (ImageSwitcher)this.findViewById(R.id.imageSwitcher);
        imageSwitcher.setFactory(this);
        imageSwitcher.setImageResource(images[currentIndex]);

        btnNext.setOnClickListener(this);
        btnPre.setOnClickListener(this);
        btnLast.setOnClickListener(this);

        my_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                tv.setText(format2.format(new Date()));
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
        imageSwitcher.setImageResource(images[Math.abs(currentIndex)]);
    }

    public void show(String text){
        tv.setText(text);
        Toast.makeText(getApplicationContext(), text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public View makeView() {
        return new ImageView(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
//            case R.id.btnFirst:
//                break;

            case R.id.btnNext:
                currentIndex++;
                imageSwitcher.setImageResource(images[Math.abs(currentIndex)%4]);
                show(currentIndex.toString());
                break;

            case R.id.btnPre:
                currentIndex--;
                imageSwitcher.setImageResource(images[Math.abs(currentIndex)%4]);
                show(currentIndex.toString());
                break;

            case R.id.btnLast:
                currentIndex = images.length-1;
                imageSwitcher.setImageResource(images[Math.abs(currentIndex)%4]);
                show(currentIndex.toString());
                break;

            default:
                break;
        }
    }
}
