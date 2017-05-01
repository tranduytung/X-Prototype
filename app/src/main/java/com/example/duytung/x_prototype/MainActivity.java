package com.example.duytung.x_prototype;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button anti_theft_off_btn;
    Button anti_theft_on_btn;
    Button trunk_on_btn;
    Button trunk_off_btn;
    Button change_status_car_btn;
    TextView status_car;

    int status = 0; // đang dừng = 0, đang đi = 1
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        // chảng status car và vô hiệu hóa cốp xe
        change_status_car_btn = (Button)findViewById(R.id.change_status_car);
        status_car = (TextView)findViewById(R.id.status_car);
        change_status_car_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status == 1) {
                    status = 0;
                    status_car.setText("Xe Đang Dừng");
                    trunk_off_btn.setEnabled(true);
                } else {
                    status = 1;
                    status_car.setText("Xe Đang Chạy");
                    trunk_off_btn.setEnabled(false);
                }
            }
        });
        // báo chố trộm
        anti_theft_off_btn = (Button)findViewById(R.id.anti_theft_off);
        anti_theft_on_btn = (Button)findViewById(R.id.anti_theft_on);
        anti_theft_off_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(final View v) {
                new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Bật báo chống trộm")
                    .setMessage("Bạn có muốn bật chức năng báo chống trộm từ xa?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        //                    Button chong_trom_off = (Button)findViewById(R.id.chong_trom_off);
                        public void onClick(DialogInterface dialog, int which) {
                            // ẩn màn hình
                            v.setVisibility(View.GONE);
                            anti_theft_on_btn.setVisibility(View.VISIBLE);
                            // chuyển màn hình
//                            Intent inten = new Intent(MainActivity.this, Main3Activity.class);
//                            startActivity(inten);
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
            }
        });
        anti_theft_on_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(final View v) {
                new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tắt báo chống trộm")
                    .setMessage("Bạn có muốn tắt chức năng báo chống trộm từ xa?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        //                    Button chong_trom_off = (Button)findViewById(R.id.chong_trom_off);
                        public void onClick(DialogInterface dialog, int which) {
                            // ẩn màn hình
                            v.setVisibility(View.GONE);
                            anti_theft_off_btn.setVisibility(View.VISIBLE);
                            // chuyển màn hình
//                            Intent inten = new Intent(MainActivity.this, Main3Activity.class);
//                            startActivity(inten);
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
            }
        });
       // cốp xe
        trunk_off_btn = (Button)findViewById(R.id.trunk_off);
        trunk_on_btn = (Button)findViewById(R.id.trunk_on);

        // vô hiệu hóa cốp xe khi xe đang chạy
        if(status == 1) {
            trunk_off_btn.setEnabled(false);
        } else {
            trunk_off_btn.setEnabled(true);
        }
        trunk_off_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(final View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Mở Cốp Xe")
                        .setMessage("Bạn có muốn mở cốp xe?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            //                    Button chong_trom_off = (Button)findViewById(R.id.chong_trom_off);
                            public void onClick(DialogInterface dialog, int which) {
                                // ẩn màn hình
                                v.setVisibility(View.GONE);
                                trunk_on_btn.setVisibility(View.VISIBLE);
                                // chuyển màn hình
//                            Intent inten = new Intent(MainActivity.this, Main3Activity.class);
//                            startActivity(inten);
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
        trunk_on_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(final View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Đóng cốp x")
                        .setMessage("Bạn có muốn đóng cốp xe?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            //                    Button chong_trom_off = (Button)findViewById(R.id.chong_trom_off);
                            public void onClick(DialogInterface dialog, int which) {
                                // ẩn màn hình
                                v.setVisibility(View.GONE);
                                trunk_off_btn.setVisibility(View.VISIBLE);
                                // chuyển màn hình
//                            Intent inten = new Intent(MainActivity.this, Main3Activity.class);
//                            startActivity(inten);
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
