package com.example.findyourself;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Q9Activity extends AppCompatActivity {
    private static final String TAG = "Q9Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.question9);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent1 = getIntent();
        int[] intArray = intent1.getIntArrayExtra("MbtiIntArray");
        if (intArray == null) {
            Log.e(TAG, "intArray is null");
            intArray = new int[8]; // 기본 배열 생성
        } else {
            Log.d(TAG, "intArray received: " + java.util.Arrays.toString(intArray));
        }

        Button b1 = findViewById(R.id.button1);
        int[] finalIntArray1 = intArray;
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Q10Activity.class);
                finalIntArray1[5] += 1;
                intent.putExtra("MbtiIntArray", finalIntArray1);
                startActivity(intent);
            }
        });

        Button b2 = findViewById(R.id.button2);
        int[] finalIntArray = intArray;
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Q10Activity.class);
                finalIntArray[4] += 1;
                intent.putExtra("MbtiIntArray", finalIntArray);
                startActivity(intent);
            }
        });
    }
}