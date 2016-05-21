package com.example.animation;

/**
 * Created by Administrator on 2016/5/21.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class ListActivity extends Activity {
    private ListView listView;
    private ArrayList list = new ArrayList<String>();
    public ListActivity() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.list_layout);
        this.listView = (ListView)this.findViewById(R.id.listView);
        for(int i = 0; i < 20; ++i) {
            list.add("慕课网" + i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListActivity.this,android.R.layout.activity_list_item, list);
        this.listView.setAdapter(adapter);
        LayoutAnimationController lac = new LayoutAnimationController(AnimationUtils.loadAnimation(this, R.anim.zoom_in));
        lac.setOrder(LayoutAnimationController.ORDER_RANDOM); //随机顺序
        listView.setLayoutAnimation(lac);
        listView.startLayoutAnimation();
    }
}

