package com.northcoders.eventapp.ui.homepage;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.northcoders.eventapp.R;
import com.northcoders.eventapp.databinding.HomepageBinding;
import com.northcoders.eventapp.databinding.LoginPageBinding;

public class HomepageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.homepage);
        HomepageBinding binding =  DataBindingUtil.setContentView(this,R.layout.homepage);
        HomepageClickHandlers clickHandlers = new HomepageClickHandlers(this);
        binding.setClickHandler(clickHandlers);
    }
}