package com.example.zoom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imgTokyo;
    private ScaleGestureDetector detector;

    private float xBegin = 0;
    private float yBegin = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgTokyo=findViewById(R.id.imgTokyo);
        xBegin=imgTokyo.getScaleX();
        yBegin=imgTokyo.getScaleY();

        detector= new ScaleGestureDetector(this, new ScaleListener(imgTokyo));
    }
    public void reset(View view){
        imgTokyo.setScaleY(yBegin);
        imgTokyo.setScaleX(xBegin);
        detector = new ScaleGestureDetector(this,new ScaleListener((imgTokyo)));
    }
    public boolean onTouchEvent(MotionEvent event){
        detector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}