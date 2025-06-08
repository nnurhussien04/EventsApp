package com.northcoders.eventapp.ui.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;

import com.northcoders.eventapp.R;
import com.northcoders.eventapp.databinding.HomepageBinding;
import com.northcoders.eventapp.databinding.LoginPageBinding;
import com.northcoders.eventapp.ui.mainactivity.MainActivityViewModel;

public class HomepageActivity extends AppCompatActivity implements LifecycleOwner{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.homepage);
        HomepageBinding binding =  DataBindingUtil.setContentView(this,R.layout.homepage);
        HomepageClickHandlers clickHandlers = new HomepageClickHandlers(this);
        binding.setClickHandler(clickHandlers);
        checkRole();
    }

    public void checkRole(){
        MainActivityViewModel viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.getStaffData().observe(this, staff -> {
            Button addEventButton = findViewById(R.id.AddEvent);
            if (staff != null) {
                addEventButton.setEnabled(true);
            } else {
                addEventButton.setVisibility(View.INVISIBLE);
                return;
            }
        });
    }
}