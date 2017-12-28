package com.example.zxl.guidepage.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.zxl.guidepage.R;
import com.example.zxl.guidepage.adapter.SelectAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/28.
 */

public class SelectActivity extends AppCompatActivity implements SelectAdapter.OnItemClickListener {

    private RecyclerView mRvSelect;
    private List<String> selectList=new ArrayList<>();
    private SelectAdapter selectAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        initView();
        initListener();
        initData();
    }

    private void initData() {
        selectList.add("Style0");
        mRvSelect.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        selectAdapter = new SelectAdapter(this,selectList);
        selectAdapter.setOnItemClickListener(this);
        mRvSelect.setAdapter(selectAdapter);
    }

    private void initListener() {

    }

    private void initView() {
        mRvSelect =(RecyclerView)findViewById(R.id.select_recyclerview);
    }

    @Override
    public void OnItemClick(View view, int position) {
        switch (position){
            case 0:
                Guide0Activity.startAction(this);
                break;
        }
    }

}
