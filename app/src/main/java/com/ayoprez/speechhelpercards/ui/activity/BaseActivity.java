package com.ayoprez.speechhelpercards.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ayo on 16.07.16.
 */
public class BaseActivity extends AppCompatActivity {

    public void changeActivity(Class<?> tClass) {
        Intent intent = new Intent(this, tClass);
        startActivity(intent);
        finish();
    }

//    @Override
//    protected void onDestroy() {
////        Realm.getDefaultInstance().close();
//        super.onDestroy();
//    }

}
