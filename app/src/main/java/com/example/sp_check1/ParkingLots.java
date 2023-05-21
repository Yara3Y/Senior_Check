package com.example.sp_check1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

public class ParkingLots extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_lots);

        Button state1=findViewById(R.id.state1);
        Button state2=findViewById(R.id.state2);
        Button state3=findViewById(R.id.state3);
        Button state4=findViewById(R.id.state4);


        state1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
//                code of change state
                state1.setBackgroundResource(R.drawable.btn_shape2);

                Toast.makeText(ParkingLots.this,
                        " red ",Toast.LENGTH_SHORT).show();;



            }
        });


        state2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                code of change state

            }
        });


        state3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                code of change state
            }
        });

        state4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                code of change state
            }
        });
    }

    public void changeState1(){



    }



}