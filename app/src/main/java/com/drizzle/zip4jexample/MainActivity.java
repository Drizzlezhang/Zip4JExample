package com.drizzle.zip4jexample;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import net.lingala.zip4j.exception.ZipException;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    Button mButton1;
    Button mButton2;
    Button mButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton1 = (Button) findViewById(R.id.button1);
        mButton2 = (Button) findViewById(R.id.button2);
        mButton3 = (Button) findViewById(R.id.button3);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mkFile();
            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CompressUtil.zip(Environment.getExternalStorageDirectory().getPath() + "/test.txt");
            }
        });
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    CompressUtil.unzip(Environment.getExternalStorageDirectory().getPath() + "/test.txt.zip", null);
                }catch (ZipException e){
                    e.printStackTrace();
                }
            }
        });
    }

    private void mkFile() {
        File sdcardfile = Environment.getExternalStorageDirectory();
        File targetFile = new File(sdcardfile.getPath(), "test.txt");
    }
}
