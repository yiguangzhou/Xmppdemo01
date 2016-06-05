package com.example.mac.xmppdemo01.data;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextClock;
import android.widget.TextView;

/**
 * Created by mac on 16/6/5.
 */
public class LoginActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new TextView(this));
    }
}
