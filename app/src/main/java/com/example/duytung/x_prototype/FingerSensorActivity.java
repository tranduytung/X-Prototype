package com.example.duytung.x_prototype;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class FingerSensorActivity extends AppCompatActivity {
    ImageView finger_sensor_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger_sensor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        // Back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        finger_sensor_img = (ImageView)findViewById(R.id.finger_sensor_img);
        finger_sensor_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                int a = r.nextInt(2);
                if(a == 0){
                    new AlertDialog.Builder(FingerSensorActivity.this)
                            .setTitle("Kiểm tra Vân Tay")
                            .setMessage("Khớp vân tay - Cửa mở")
                            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                //                    Button chong_trom_off = (Button)findViewById(R.id.chong_trom_off);
                                public void onClick(DialogInterface dialog, int which) {
                                    onBackPressed();
                                }
                            })
                            .setIcon(R.drawable.btn_check_buttonless_on)
                            .show();
                } else {
                    new AlertDialog.Builder(FingerSensorActivity.this)
                            .setTitle("Kiểm tra Vân Tay")
                            .setMessage("Không khớp vân tay - Thử lại")
                            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                //                    Button chong_trom_off = (Button)findViewById(R.id.chong_trom_off);
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            })
                            .setIcon(R.drawable.ic_delete)
                            .show();
                }
            }
        });
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

}
