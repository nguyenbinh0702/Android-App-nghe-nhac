package com.example.appnhac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView_casi;
    ArrayList<list_casi> list_casi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView_casi = (ListView) findViewById(R.id.list_casi);

    list_casi = new ArrayList<list_casi>();

    list_casi.add(new list_casi("Sơn Tùng MTP", R.drawable.son_tung));
    list_casi.add(new list_casi("Soobin Hoàng sơn", R.drawable.soobin_hoang_son));
    list_casi.add(new list_casi("Bích Phương", R.drawable.bich_phuong));
    list_casi.add(new list_casi("Đen Vâu", R.drawable.den_vau));
    list_casi.add(new list_casi("Phí Phương Anh", R.drawable.phi_phuong_anh));
    list_casi.add(new list_casi("MR.siro", R.drawable.mr_siro));
    list_casi.add(new list_casi("Jack", R.drawable.jack));

    Adapter_casi adapter_casi = new Adapter_casi(MainActivity.this, R.layout.list_ca_si, list_casi);

    listView_casi.setAdapter(adapter_casi);

    listView_casi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(MainActivity.this, Activity2_bai_hat.class);
            intent.putExtra("position", position);
            intent.putExtra("tencasi", list_casi.get(position).ten_casi);
            startActivity(intent);
        }
    });

    }
}