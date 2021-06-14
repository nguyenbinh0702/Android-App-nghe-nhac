package com.example.appnhac;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Activity2_bai_hat extends AppCompatActivity {

    TextView txt_tencasi, txt_tenbaihatdangphat, txt_tgdangphat, txt_tgketthuc;
    ImageButton IMGB_play, IMGB_next, IMGB_back;
    ListView listView_baihat;
    SeekBar seekBar;

    int vitri;

    ArrayList<list_baihat> list_baihats;

    MediaPlayer player = new MediaPlayer();

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2_bai_hat);

        Intent intent = getIntent();
        int vt = intent.getIntExtra("position", 0);
        String cs = intent.getStringExtra("tencasi");

        txt_tencasi = (TextView) findViewById(R.id.txt_casi);
        txt_tenbaihatdangphat = (TextView) findViewById(R.id.txt_dang_phat);
        txt_tgdangphat = (TextView) findViewById(R.id.txt_time_play);
        txt_tgketthuc = (TextView) findViewById(R.id.txt_time_out);
        IMGB_next = (ImageButton) findViewById(R.id.bt_next);
        IMGB_play = (ImageButton) findViewById(R.id.bt_pause);
        IMGB_back = (ImageButton) findViewById(R.id.bt_back);

        listView_baihat = (ListView) findViewById(R.id.list_nhac);
        seekBar = (SeekBar) findViewById(R.id.seebar);
        txt_tencasi.setText("Ca sĩ: "+ cs);
        list_baihats = new ArrayList<list_baihat>();

        switch (vt) {
            case 0:
                list_baihats.add(new list_baihat("Có Chắc Yêu Là Đây",                      time(R.raw.sontung_cochacyeuladay), R.raw.sontung_cochacyeuladay));
                list_baihats.add(new list_baihat("Không Phải Dạng vừa Đâu",                 time(R.raw.sontung_khongphaidangvuadau), R.raw.sontung_khongphaidangvuadau));
                list_baihats.add(new list_baihat("Muộn Rồi Mà Sao Còn",                     time(R.raw.sontung_muonroimasaocon), R.raw.sontung_muonroimasaocon));
                break;
            case 1:
                list_baihats.add(new list_baihat("Tháng Năm",                               time(R.raw.soobinhoangson_thangnamspecialperformance), R.raw.soobinhoangson_thangnamspecialperformance));
                 break;
            case 2:
                list_baihats.add(new list_baihat("Mình Yêu Nhau ĐI",                        time(R.raw.bichphuong_minyeunhaudi), R.raw.bichphuong_minyeunhaudi));
                 break;
            case 3:
                list_baihats.add(new list_baihat("Cho Tôi Lang Thang",                      time(R.raw.den_chotoilangthangngot), R.raw.den_chotoilangthangngot));
                break;
            case 4:
                list_baihats.add(new list_baihat("Răng Khôn",                               time(R.raw.phiphuonganh_rangkhon), R.raw.phiphuonganh_rangkhon));
                break;
            case 5:
                list_baihats.add(new list_baihat("Day Dứt Nỗi Đau",                         time(R.raw.mrsiro_daydutnoidau), R.raw.mrsiro_daydutnoidau));
                list_baihats.add(new list_baihat("Lặng Lẽ Tổn Thương",                      time(R.raw.mrsiro_langletonthuong), R.raw.mrsiro_langletonthuong));
                list_baihats.add(new list_baihat("Tiếng Sét Trong Anh",                     time(R.raw.mrsiro_tiengsettronganh), R.raw.mrsiro_tiengsettronganh));
                list_baihats.add(new list_baihat("Vô Hình Trong Tim Em",                    time(R.raw.mrsiro_vohinhtrongtimem), R.raw.mrsiro_vohinhtrongtimem));
                list_baihats.add(new list_baihat("Yêu Người Không Thể Yêu",                 time(R.raw.mrsiro_yeunguoikhongtheyeucover), R.raw.mrsiro_yeunguoikhongtheyeucover));
                break;
            case 6:
                list_baihats.add(new list_baihat("Bà Tôi",                                  time(R.raw.jack_batoi), R.raw.jack_batoi));
                list_baihats.add(new list_baihat("Hoa Hải Đường",                           time(R.raw.jack_hoahaiduong), R.raw.jack_hoahaiduong));
                list_baihats.add(new list_baihat("LAYLALAY",                                time(R.raw.jack_laylalay), R.raw.jack_laylalay));
                break;
        }
       Adapter_listbaihat adapter_listbaihat = new Adapter_listbaihat(Activity2_bai_hat.this, R.layout.list_baihat, list_baihats);
        listView_baihat.setAdapter(adapter_listbaihat);
        khoitao();
        player.start();
        IMGB_play.setBackgroundResource(R.drawable.pause);
        thoigian_hientai();
        listView_baihat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (player.isPlaying()) {
                    player.stop();
                } else {
                    vitri = position;
                    khoitao();
                }
                IMGB_play.setBackgroundResource(R.drawable.pause);
            }
        });

        IMGB_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(player.isPlaying()){
                    player.pause();
                    IMGB_play.setBackgroundResource(R.drawable.play);

                }
                else {
                    player.start();
                    IMGB_play.setBackgroundResource(R.drawable.pause);
                }
            }
        });
        IMGB_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vitri++;
                if (vitri > list_baihats.size()-1){
                    vitri = 0;
                }
                player.stop();
                khoitao();
            }
        });
        IMGB_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vitri--;
                if (vitri < 0){
                    vitri = list_baihats.size()-1;
                }
                player.stop();
                khoitao();
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                player.seekTo(seekBar.getProgress());
            }
        });
    }
    void thoigian_hientai(){
        Handler handler = new Handler();
        boolean b = handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                    SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("mm:ss");
                    txt_tgdangphat.setText(simpleDateFormat.format(player.getCurrentPosition()));
                    seekBar.setProgress(player.getCurrentPosition());
                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            vitri++;
                            if (vitri > list_baihats.size()-1){
                                vitri =0;
                                player.stop();
                                IMGB_play.setBackgroundResource(R.drawable.play);
                            }
                            else {
                                player.stop();
                                khoitao();
                                player.start();
                            }
                        }
                    });
                    handler.postDelayed(this, 500);
            }
        },100);
    }
    private void khoitao() {
        player = MediaPlayer.create(Activity2_bai_hat.this, list_baihats.get(vitri).baihat);
        txt_tenbaihatdangphat.setText("Đang Phát: "+list_baihats.get(vitri).tenbaihat);
        txt_tgketthuc.setText(time(list_baihats.get(vitri).baihat));
        seekBar.setMax(player.getDuration() );
        player.start();
    }

    private String time(int baihat){
        String t;
        MediaPlayer player = new MediaPlayer();
        player = MediaPlayer.create(Activity2_bai_hat.this, baihat);
        SimpleDateFormat tg = new SimpleDateFormat("mm:ss");
        t = tg.format(player.getDuration());
        return t;
    }

    @Override
    protected void onStop() {
        player.stop();
        super.onStop();
    }
}