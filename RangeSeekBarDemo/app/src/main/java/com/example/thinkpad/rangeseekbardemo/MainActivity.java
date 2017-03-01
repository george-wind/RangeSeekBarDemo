package com.example.thinkpad.rangeseekbardemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.seekBar1)
    RangeSeekBar1 seekBar1;
    @BindView(R.id.bt1)
    Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        seekBar1.setOnRangeChangedListener(new RangeSeekBar1.OnRangeChangedListener() {
            @Override
            public void onRangeChanged(float lowerRange, float upperRange) {
                Log.i("main lowerrange: ",lowerRange+"");
                Log.i("main upperRange: ",upperRange+"");
            }
        });
        seekBar1.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                seekBar1.setCurrentRange(5,11);
                seekBar1.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    @OnClick({R.id.bt1})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.bt1:
                if(seekBar1.isEnabled()){
                    seekBar1.setForbiddened(true);
                }else {
                    seekBar1.setForbiddened(false);
                }
                break;
        }
    }
}
