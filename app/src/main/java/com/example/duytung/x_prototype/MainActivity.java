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
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button anti_theft_off_btn;
    Button anti_theft_on_btn;
    Button trunk_on_btn;
    Button trunk_off_btn;
    Button change_status_car_btn;
    Button capo_on_btn;
    Button capo_off_btn;
    Button camera_sensor_btn;
    Button air_conditioner_on_btn;
    Button air_conditioner_off_btn;
    Button finger_sensor_btn;
    Button seat_change_btn;
    TextView status_car;
    Button mirror_off_btn;
    Button mirror_on_btn;
    Button light_off_btn;
    Button light_on_btn;
    Button device_off_btn;
    Button device_on_btn;
    Button maps_btn;

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
                Intent inten = new Intent(MainActivity.this, SpeakActivity.class);
                startActivity(inten);
            }
        });

        change_status_car_btn = (Button)findViewById(R.id.change_status_car);
        status_car = (TextView)findViewById(R.id.status_car);
        trunk_off_btn = (Button)findViewById(R.id.trunk_off);
        trunk_on_btn = (Button)findViewById(R.id.trunk_on);
        anti_theft_off_btn = (Button)findViewById(R.id.anti_theft_off);
        anti_theft_on_btn = (Button)findViewById(R.id.anti_theft_on);
        capo_off_btn = (Button)findViewById(R.id.capo_off);
        capo_on_btn = (Button)findViewById(R.id.capo_on);
        camera_sensor_btn = (Button)findViewById(R.id.camera_sensor);
        air_conditioner_off_btn = (Button)findViewById(R.id.air_conditioner_off);
        air_conditioner_on_btn = (Button)findViewById(R.id.air_conditioner_on);
        finger_sensor_btn = (Button)findViewById(R.id.finger_sensor);
        seat_change_btn = (Button)findViewById(R.id.seat_change);
        mirror_off_btn = (Button)findViewById(R.id.mirror_off);
        mirror_on_btn = (Button)findViewById(R.id.mirror_on);
        light_off_btn = (Button)findViewById(R.id.light_off);
        light_on_btn = (Button)findViewById(R.id.light_on);
        device_off_btn = (Button)findViewById(R.id.device_off);
        device_on_btn = (Button)findViewById(R.id.device_on);
        maps_btn = (Button)findViewById(R.id.maps);

        // chảng status car và vô hiệu hóa cốp xe
        change_status_car_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status == 1) {
                    status = 0;
                    status_car.setText("Xe Đang Dừng");
                    trunk_off_btn.setEnabled(true);
                    capo_off_btn.setEnabled(true);
                } else {
                    status = 1;
                    status_car.setText("Xe Đang Chạy");
                    trunk_off_btn.setEnabled(false);
                    capo_off_btn.setEnabled(false);
                }
            }
        });
        // báo chố trộm
        anti_theft_off_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(final View v) {
                new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Bật báo chống trộm")
                    .setMessage("Bạn có muốn bật chức năng báo chống trộm từ xa?")
                    .setPositiveButton("Có", new DialogInterface.OnClickListener() {
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
                    .setNegativeButton("Không", new DialogInterface.OnClickListener() {
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
                    .setPositiveButton("Có", new DialogInterface.OnClickListener() {
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
                    .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
            }
        });

        // vô hiệu hóa cốp xe va capo khi xe đang chạy
        if(status == 1) {
            trunk_off_btn.setEnabled(false);
            capo_off_btn.setEnabled(false);
        } else {
            trunk_off_btn.setEnabled(true);
            capo_off_btn.setEnabled(true);
        }

        trunk_off_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(final View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Mở Cốp Xe")
                        .setMessage("Bạn có muốn mở cốp xe?")
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
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
                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
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
                        .setTitle("Đóng cốp xe")
                        .setMessage("Bạn có muốn đóng cốp xe?")
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
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
                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
        capo_off_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(final View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Mở Capo")
                        .setMessage("Bạn có muốn mở Capo xe?")
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            //                    Button chong_trom_off = (Button)findViewById(R.id.chong_trom_off);
                            public void onClick(DialogInterface dialog, int which) {
                                // ẩn màn hình
                                v.setVisibility(View.GONE);
                                capo_on_btn.setVisibility(View.VISIBLE);
                                // chuyển màn hình
//                            Intent inten = new Intent(MainActivity.this, Main3Activity.class);
//                            startActivity(inten);
                            }
                        })
                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
        capo_on_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(final View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Đóng Capo")
                        .setMessage("Bạn có muốn đóng Capo xe?")
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            //                    Button chong_trom_off = (Button)findViewById(R.id.chong_trom_off);
                            public void onClick(DialogInterface dialog, int which) {
                                // ẩn màn hình
                                v.setVisibility(View.GONE);
                                capo_off_btn.setVisibility(View.VISIBLE);
                                // chuyển màn hình
//                            Intent inten = new Intent(MainActivity.this, Main3Activity.class);
//                            startActivity(inten);
                            }
                        })
                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });

        // camera sensor
        camera_sensor_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Mở camera cảm biến")
                        .setMessage("Bạn có muốn mở camera cảm biến?")
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            //                    Button chong_trom_off = (Button)findViewById(R.id.chong_trom_off);
                            public void onClick(DialogInterface dialog, int which) {
                            //chuyển màn hình
                            Intent inten = new Intent(MainActivity.this, CameraSensorActivity.class);
                            startActivity(inten);
                            }
                        })
                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });

        // điều hòa
        air_conditioner_off_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(final View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Điều hòa - Đang Tắt")
                        .setMessage("Bạn có muốn bật chức năng điều hòa tự động theo lịch?")
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            //                    Button chong_trom_off = (Button)findViewById(R.id.chong_trom_off);
                            public void onClick(DialogInterface dialog, int which) {
                                // ẩn màn hình
                                v.setVisibility(View.GONE);
                                air_conditioner_on_btn.setVisibility(View.VISIBLE);
                                // chuyển màn hình
//                            Intent inten = new Intent(MainActivity.this, Main3Activity.class);
//                            startActivity(inten);
                            }
                        })
                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
        air_conditioner_on_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(final View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Điều hòa - Đang Bật")
                        .setMessage("Bạn có muốn tắt chức năng bật điều hòa tự động?")
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            //                    Button chong_trom_off = (Button)findViewById(R.id.chong_trom_off);
                            public void onClick(DialogInterface dialog, int which) {
                                // ẩn màn hình
                                v.setVisibility(View.GONE);
                                air_conditioner_off_btn.setVisibility(View.VISIBLE);
                                // chuyển màn hình
//                            Intent inten = new Intent(MainActivity.this, Main3Activity.class);
//                            startActivity(inten);
                            }
                        })
                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });

        //finger sensor
        finger_sensor_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                //chuyển màn hình
                Intent inten = new Intent(MainActivity.this, FingerSensorActivity.class);
                startActivity(inten);
            }
        });

        //change seat
        seat_change_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                //chuyển màn hình
                Intent inten = new Intent(MainActivity.this, SeatActivity.class);
                startActivity(inten);
            }
        });

        // guong xe
        mirror_off_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(final View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Mở gương xe")
                        .setMessage("Bạn có muốn mở gương xe?")
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            //                    Button chong_trom_off = (Button)findViewById(R.id.chong_trom_off);
                            public void onClick(DialogInterface dialog, int which) {
                                // ẩn màn hình
                                v.setVisibility(View.GONE);
                                mirror_on_btn.setVisibility(View.VISIBLE);
                                // chuyển màn hình
//                            Intent inten = new Intent(MainActivity.this, Main3Activity.class);
//                            startActivity(inten);
                            }
                        })
                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
        mirror_on_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(final View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Đóng gương xe")
                        .setMessage("Bạn có muốn đóng gương xe?")
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            //                    Button chong_trom_off = (Button)findViewById(R.id.chong_trom_off);
                            public void onClick(DialogInterface dialog, int which) {
                                // ẩn màn hình
                                v.setVisibility(View.GONE);
                                mirror_off_btn.setVisibility(View.VISIBLE);
                                // chuyển màn hình
//                            Intent inten = new Intent(MainActivity.this, Main3Activity.class);
//                            startActivity(inten);
                            }
                        })
                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
        // den xe
        light_off_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(final View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Đèn xe tự động")
                        .setMessage("Bạn có bật chắc năng tự điểu chỉnh đèn xe?")
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            //                    Button chong_trom_off = (Button)findViewById(R.id.chong_trom_off);
                            public void onClick(DialogInterface dialog, int which) {
                                // ẩn màn hình
                                v.setVisibility(View.GONE);
                                light_on_btn.setVisibility(View.VISIBLE);
                                // chuyển màn hình
//                            Intent inten = new Intent(MainActivity.this, Main3Activity.class);
//                            startActivity(inten);
                            }
                        })
                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
        light_on_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(final View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Đèn xe tự động")
                        .setMessage("Bạn có tắt chắc năng tự điểu chỉnh đèn xe?")
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            //                    Button chong_trom_off = (Button)findViewById(R.id.chong_trom_off);
                            public void onClick(DialogInterface dialog, int which) {
                                // ẩn màn hình
                                v.setVisibility(View.GONE);
                                light_off_btn.setVisibility(View.VISIBLE);
                                // chuyển màn hình
//                            Intent inten = new Intent(MainActivity.this, Main3Activity.class);
//                            startActivity(inten);
                            }
                        })
                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });

        // thiet bi xe
        device_off_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(final View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Điều khiển thiết bị xe")
                        .setMessage("Bạn có bật chắc năng điểu khiển thiết bị xe?")
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            //                    Button chong_trom_off = (Button)findViewById(R.id.chong_trom_off);
                            public void onClick(DialogInterface dialog, int which) {
                                // ẩn màn hình
                                v.setVisibility(View.GONE);
                                device_on_btn.setVisibility(View.VISIBLE);
                                // chuyển màn hình
//                            Intent inten = new Intent(MainActivity.this, Main3Activity.class);
//                            startActivity(inten);
                            }
                        })
                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
        device_on_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(final View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Điều khiển thiết bị xe")
                        .setMessage("Bạn có tắt chắc năng điểu khiển thiết bị xe?")
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            //                    Button chong_trom_off = (Button)findViewById(R.id.chong_trom_off);
                            public void onClick(DialogInterface dialog, int which) {
                                // ẩn màn hình
                                v.setVisibility(View.GONE);
                                device_off_btn.setVisibility(View.VISIBLE);
                                // chuyển màn hình
//                            Intent inten = new Intent(MainActivity.this, Main3Activity.class);
//                            startActivity(inten);
                            }
                        })
                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
        // maps
        maps_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(inten);
            }
        });;
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
            Intent inten = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(inten);
        }

        return super.onOptionsItemSelected(item);
    }
}
