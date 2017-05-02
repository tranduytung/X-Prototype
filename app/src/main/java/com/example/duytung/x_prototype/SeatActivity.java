package com.example.duytung.x_prototype;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;

public class SeatActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView seat_1_img;
    ImageView seat_2_img;
    ImageView seat_3_img;
    ImageView seat_4_img;
    Button change_90_btn;
    Button change_100_btn;
    Button change_110_btn;
    Button change_120_btn;
    TextView seat_1_text;
    TextView seat_2_text;
    TextView seat_3_text;
    TextView seat_4_text;
    int clicked_seat;
    AlertDialog show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten = new Intent(SeatActivity.this, SpeakActivity.class);
                startActivity(inten);
            }
        });
        // Back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        seat_1_img = (ImageView)findViewById(R.id.seat_1);
        seat_2_img = (ImageView)findViewById(R.id.seat_2);
        seat_3_img = (ImageView)findViewById(R.id.seat_3);
        seat_4_img = (ImageView)findViewById(R.id.seat_4);

        seat_1_text = (TextView)findViewById(R.id.seat_text_1);
        seat_2_text = (TextView)findViewById(R.id.seat_text_2);
        seat_3_text = (TextView)findViewById(R.id.seat_text_3);
        seat_4_text = (TextView)findViewById(R.id.seat_text_4);

        final View view = LayoutInflater.from(this).inflate(R.layout.change_seat, null);
        seat_1_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (show == null) {
                    show = new AlertDialog.Builder(SeatActivity.this)
                        .setTitle("Chỉnh tư thế ghế")
                        .setView(view)
                        .show();
                } else {
                    show.show();
                }
                clicked_seat = 1;
            }
        });
        seat_2_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (show == null) {
                    show = new AlertDialog.Builder(SeatActivity.this)
                            .setTitle("Chỉnh tư thế ghế")
                            .setView(view)
                            .show();
                } else {
                    show.show();
                }
                clicked_seat = 2;
            }
        });
        seat_3_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (show == null) {
                    show = new AlertDialog.Builder(SeatActivity.this)
                            .setTitle("Chỉnh tư thế ghế")
                            .setView(view)
                            .show();
                } else {
                    show.show();
                }
                clicked_seat = 3;
            }
        });
        seat_4_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (show == null) {
                    show = new AlertDialog.Builder(SeatActivity.this)
                            .setTitle("Chỉnh tư thế ghế")
                            .setView(view)
                            .show();
                } else {
                    show.show();
                }
                clicked_seat = 4;
            }
        });
        change_90_btn = (Button)view.findViewById(R.id.change_90);
        change_90_btn.setOnClickListener(this);
        change_100_btn = (Button)view.findViewById(R.id.change_100);
        change_100_btn.setOnClickListener(this);
        change_110_btn = (Button)view.findViewById(R.id.change_110);
        change_110_btn.setOnClickListener(this);
        change_120_btn = (Button)view.findViewById(R.id.change_120);
        change_120_btn.setOnClickListener(this);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // API 5+ solution
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void setStatus_seat_1(String s) {

    }

    @Override
    public void onClick(View v) {
        if(clicked_seat == 1){
            switch (v.getId()) {
                case R.id.change_90:
                    seat_1_text.setText("Ghế 1 - 90 độ");
                    show.dismiss();
                    break;
                case R.id.change_100:
                    seat_1_text.setText("Ghế 1 - 100 độ");
                    show.dismiss();
                    break;
                case R.id.change_110:
                    seat_1_text.setText("Ghế 1 - 110 độ");
                    show.dismiss();
                    break;
                case R.id.change_120:
                    seat_1_text.setText("Ghế 1 - 120 độ");
                    show.dismiss();
                    break;
            }
        }
        if(clicked_seat == 2){
            switch (v.getId()) {
                case R.id.change_90:
                    seat_2_text.setText("Ghế 2 - 90 độ");
                    show.dismiss();
                    break;
                case R.id.change_100:
                    seat_2_text.setText("Ghế 2 - 100 độ");
                    show.dismiss();
                    break;
                case R.id.change_110:
                    seat_2_text.setText("Ghế 2 - 110 độ");
                    show.dismiss();
                    break;
                case R.id.change_120:
                    seat_2_text.setText("Ghế 2 - 120 độ");
                    show.dismiss();
                    break;
            }
        }
        if(clicked_seat == 3){
            switch (v.getId()) {
                case R.id.change_90:
                    seat_3_text.setText("Ghế 3 - 90 độ");
                    show.dismiss();
                    break;
                case R.id.change_100:
                    seat_3_text.setText("Ghế 3 - 100 độ");
                    show.dismiss();
                    break;
                case R.id.change_110:
                    seat_3_text.setText("Ghế 3 - 110 độ");
                    show.dismiss();
                    break;
                case R.id.change_120:
                    seat_3_text.setText("Ghế 3 - 120 độ");
                    show.dismiss();
                    break;
            }
        }
        if(clicked_seat == 4){
            switch (v.getId()) {
                case R.id.change_90:
                    seat_4_text.setText("Ghế 4 - 90 độ");
                    show.dismiss();
                    break;
                case R.id.change_100:
                    seat_4_text.setText("Ghế 4 - 100 độ");
                    show.dismiss();
                    break;
                case R.id.change_110:
                    seat_4_text.setText("Ghế 4 - 110 độ");
                    show.dismiss();
                    break;
                case R.id.change_120:
                    seat_4_text.setText("Ghế 4 - 120 độ");
                    show.dismiss();
                    break;
            }
        }
    }
}
