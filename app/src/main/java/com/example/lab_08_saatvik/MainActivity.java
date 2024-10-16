package com.example.lab_08_saatvik;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    DrawView drawView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        drawView=findViewById(R.id.drawView);

    }

    public void reverseY(View view) {
        drawView.setdX(drawView.getdX()*-1);
        drawView.setDx2(drawView.getDx2()*-1);

    }

    public void jump(View view) {
        drawView.isJumping = true;

    }
}
