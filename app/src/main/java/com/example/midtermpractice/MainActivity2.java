package com.example.midtermpractice;

import static com.example.midtermpractice.R.*;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    Button multiples;
    Button square;
    Button cube;
    Button divisors;

    Button newNum;

    TextView output;

    int[] multi;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        multiples = findViewById(R.id.button2);
        square = findViewById(R.id.button3);
        cube = findViewById(R.id.button4);
        divisors = findViewById(R.id.button5);
        newNum = findViewById(R.id.button8);
        output = findViewById(R.id.textView);
        Intent intent = getIntent();
        number = intent.getIntExtra("number", 0);
        multiples.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multi = getMuti(number);
                String result = "";
                for(int i = 1; i < multi.length; i++){
                    result += multi[i] + " ";
                }

                output.setText(result);
            }
        });

        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int square = getSquare(number);
                String result = String.valueOf(square);
                output.setText(result);
            }
        });

        cube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cube = getCube(number);
                String result = String.valueOf(cube);
                output.setText(result);
            }
        });

        divisors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] div = getDivisors(number);
                String result = "";
                for(int i = 0; i < div.length; i++){

                    if(div[i] != 0){
                        result += div[i] + " ";
                    }
                }
                output.setText(result);
            }
        });

        newNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(i2);
            }
        });
    }

    private int[] getMuti(int num){
        int[] number = new int[13];

        for(int i = 1; i < number.length; i++){
            number[i] = num * i;
        }

        return number;
    }

    private int getSquare(int num){
        return num * num;
    }

    private int getCube(int num){
        return num * num * num;
    }

    private int[] getDivisors(int num){
        int[] numbers = new int[num];
        for(int i = 1; i < numbers.length; i++){
            if(num % i == 0){
                numbers[i] = i;
            }
        }
        return numbers;
    }


}