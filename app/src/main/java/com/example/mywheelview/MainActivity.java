package com.example.mywheelview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private TextView tv;

    private List list = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        tv=findViewById(R.id.tv);

        for (int i = 0; i < 6; i++) {
            list.add("选项" + i);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomStyleDialog.dialogShow(MainActivity.this, list, true, 2, new BottomStyleDialog.ResultEditListener() {
                    @Override
                    public void SureListener(String s) {
                        tv.setText(s);
                    }
                });
            }
        });
    }
}
