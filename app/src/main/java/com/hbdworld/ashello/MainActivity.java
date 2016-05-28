package com.hbdworld.ashello;

import android.content.Intent;
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
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewSwitcher.ViewFactory {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        Button btn = (Button)this.findViewById(R.id.btnImage);
        btn.setOnClickListener(this);

        btn = (Button)this.findViewById(R.id.btnListView);
        btn.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        Intent intent = null;
        switch (view.getId()) {
            case R.id.btnImage:
                intent = new Intent();
                intent.setClass(this, ImageActivity.class);
                startActivity(intent);
                break;

            case R.id.btnListView:
                intent = new Intent();
                intent.setClass(this, ListViewActivity.class);
                startActivity(intent);
                break;

            default:
                break;
        }
    }

    @Override
    public View makeView() {
        return null;
    }
}
