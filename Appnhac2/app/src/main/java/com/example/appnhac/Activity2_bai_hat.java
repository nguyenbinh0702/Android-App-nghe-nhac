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
        txt_tencasi.setText(cs);
        list_baihats = new ArrayList<list_baihat>();

        switch (vt) {
            case 0:
                list_baihats.add(new list_baihat("1 :Muộn Rồi Mà Sao Còn-Sơn Tùng MTV",                 time(R.raw.sontung_muonroimasaocon), R.raw.sontung_muonroimasaocon));
                list_baihats.add(new list_baihat("2 :Sài Gòn Đau Lòng Qúa-Hứa Kim Tuyền, Kim Duyên",    time(R.raw.topnhactre_saigondaulongqua), R.raw.topnhactre_saigondaulongqua));
                list_baihats.add(new list_baihat("3 :Răng Khôn-Phí Phương Anh",                         time(R.raw.phiphuonganh_rangkhon), R.raw.phiphuonganh_rangkhon));
                list_baihats.add(new list_baihat("4 :Câu Thề Hẹn-Đình Dũng, ACV",                       time(R.raw.topnhactre_cauthehen), R.raw.topnhactre_cauthehen));
                list_baihats.add(new list_baihat("5 :LAYLALAY-Jack",                                    time(R.raw.jack_laylalay), R.raw.jack_laylalay));
                list_baihats.add(new list_baihat("6 :Nàng Thơ-Hoàng Dũng",                              time(R.raw.topnhactre_nangtho), R.raw.topnhactre_nangtho));
                list_baihats.add(new list_baihat("7 :Người Lạ Từng Thương-Như Việt ,ACV",               time(R.raw.topnhactre_nguoilatungthuong), R.raw.topnhactre_nguoilatungthuong));
                list_baihats.add(new list_baihat("8 :Vách Ngọc Ngà-Anh Rồng",                           time(R.raw.topnhactre_vachngocnga), R.raw.topnhactre_vachngocnga));
                list_baihats.add(new list_baihat("9 :Phải Chăng Em Đã Yêu-juky San, RedT",              time(R.raw.topnhactre_phaichangemdayeu), R.raw.topnhactre_phaichangemdayeu));
                list_baihats.add(new list_baihat("10 :Níu Duyên-Lê Bảo Bình",                           time(R.raw.topnhactre_niuduyen), R.raw.topnhactre_niuduyen));
                break;
            case 1:
                list_baihats.add(new list_baihat("Có Chắc Yêu Là Đây",                      time(R.raw.sontung_cochacyeuladay), R.raw.sontung_cochacyeuladay));
                list_baihats.add(new list_baihat("Không Phải Dạng vừa Đâu",                 time(R.raw.sontung_khongphaidangvuadau), R.raw.sontung_khongphaidangvuadau));
                list_baihats.add(new list_baihat("Muộn Rồi Mà Sao Còn",                     time(R.raw.sontung_muonroimasaocon), R.raw.sontung_muonroimasaocon));
                list_baihats.add(new list_baihat("Ấn Nút Nhớ Thả Giấc MƠ",                  time(R.raw.sontung_annutnhothagiacmo), R.raw.sontung_annutnhothagiacmo));
                list_baihats.add(new list_baihat("Anh Sai Rồi",                             time(R.raw.sontung_anhsairoi), R.raw.sontung_anhsairoi));
                list_baihats.add(new list_baihat("Bình Yên Những Phút Giây",                time(R.raw.sontung_binhyennhungphutgiay), R.raw.sontung_binhyennhungphutgiay));
                list_baihats.add(new list_baihat("Buông Đôi Tay Nhau Ra",                   time(R.raw.sontung_buongdoitaynhaura), R.raw.sontung_buongdoitaynhaura));
                list_baihats.add(new list_baihat("Hãy Trao Cho Anh",                        time(R.raw.sontung_haytraochoanh), R.raw.sontung_haytraochoanh));
                list_baihats.add(new list_baihat("Như Ngày Hôm Qua",                        time(R.raw.sontung_nhungayhomqua), R.raw.sontung_nhungayhomqua));
                list_baihats.add(new list_baihat("Tiến Lên Việt Nam Ơi",                    time(R.raw.sontung_tienlenvietnamoi), R.raw.sontung_tienlenvietnamoi));
                list_baihats.add(new list_baihat("You Of Yesterday",                        time(R.raw.sontung_youofyesterday), R.raw.sontung_youofyesterday));
                break;
            case 2:
                list_baihats.add(new list_baihat("Tháng Năm",                               time(R.raw.soobinhoangson_thangnamspecialperformance), R.raw.soobinhoangson_thangnamspecialperformance));
                list_baihats.add(new list_baihat("Câu Chuyện Nhỏ",                          time(R.raw.soobinhoangson_cauchuyennho), R.raw.soobinhoangson_cauchuyennho));
                list_baihats.add(new list_baihat("Đã Đến Lúc",                              time(R.raw.soobinhoangson_dadenluc), R.raw.soobinhoangson_dadenluc));
                list_baihats.add(new list_baihat("Đi ĐỂ Trở Về",                            time(R.raw.soobinhoangson_didetrove), R.raw.soobinhoangson_didetrove));
                list_baihats.add(new list_baihat("Đi Qua Qúa Khứ",                          time(R.raw.soobinhoangson_diquaquakhu), R.raw.soobinhoangson_diquaquakhu));
                list_baihats.add(new list_baihat("Em Không Tồn Tại",                        time(R.raw.soobinhoangson_emkhongtontai), R.raw.soobinhoangson_emkhongtontai));
                list_baihats.add(new list_baihat("Hết Rồi Còn Đâu",                         time(R.raw.soobinhoangson_hetroicondau), R.raw.soobinhoangson_hetroicondau));
                list_baihats.add(new list_baihat("Khoảng Lặng",                             time(R.raw.soobinhoangson_khoanglang), R.raw.soobinhoangson_khoanglang));
                list_baihats.add(new list_baihat("Ngày Mai Em ĐI",                          time(R.raw.soobinhoangson_ngaymaiemdi), R.raw.soobinhoangson_ngaymaiemdi));
                list_baihats.add(new list_baihat("OH OH",                                   time(R.raw.soobinhoangson_ohoh), R.raw.soobinhoangson_ohoh));
                list_baihats.add(new list_baihat("Say Goodbye",                             time(R.raw.soobinhoangson_saygoodbye), R.raw.soobinhoangson_saygoodbye));
                list_baihats.add(new list_baihat("Tan Theo Giấc Mơ",                        time(R.raw.soobinhoangson_tantheogiacmo), R.raw.soobinhoangson_tantheogiacmo));
                list_baihats.add(new list_baihat("Vì Sao Cuối Trời",                        time(R.raw.soobinhoangson_visaocuoitroi), R.raw.soobinhoangson_visaocuoitroi));
                break;
            case 3:
                list_baihats.add(new list_baihat("Mình Yêu Nhau ĐI",                        time(R.raw.bichphuong_minyeunhaudi), R.raw.bichphuong_minyeunhaudi));
                 break;
            case 4:
                list_baihats.add(new list_baihat("Cho Tôi Lang Thang",                      time(R.raw.den_chotoilangthangngot), R.raw.den_chotoilangthangngot));
                break;
            case 5:
                list_baihats.add(new list_baihat("Răng Khôn",                               time(R.raw.phiphuonganh_rangkhon), R.raw.phiphuonganh_rangkhon));
                break;
            case 6:
                list_baihats.add(new list_baihat("Day Dứt Nỗi Đau",                         time(R.raw.mrsiro_daydutnoidau), R.raw.mrsiro_daydutnoidau));
                list_baihats.add(new list_baihat("Lặng Lẽ Tổn Thương",                      time(R.raw.mrsiro_langletonthuong), R.raw.mrsiro_langletonthuong));
                list_baihats.add(new list_baihat("Tiếng Sét Trong Anh",                     time(R.raw.mrsiro_tiengsettronganh), R.raw.mrsiro_tiengsettronganh));
                list_baihats.add(new list_baihat("Vô Hình Trong Tim Em",                    time(R.raw.mrsiro_vohinhtrongtimem), R.raw.mrsiro_vohinhtrongtimem));
                list_baihats.add(new list_baihat("Yêu Người Không Thể Yêu",                 time(R.raw.mrsiro_yeunguoikhongtheyeucover), R.raw.mrsiro_yeunguoikhongtheyeucover));
                break;
            case 7:
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