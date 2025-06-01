package com.northcoders.eventapp.ui.login;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;

import com.northcoders.eventapp.R;
import com.northcoders.eventapp.databinding.LoginPageBinding;
import com.northcoders.eventapp.model.Login;
import com.northcoders.eventapp.ui.mainactivity.MainActivityViewModel;

public class LoginActivity extends AppCompatActivity implements LifecycleOwner {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login_page);
        LoginPageBinding binding =  DataBindingUtil.setContentView(this,R.layout.login_page);
        MainActivityViewModel viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        Login login = new Login();
        LoginClickHandlers loginClickHandlers= new LoginClickHandlers(login,this,viewModel);
        binding.setClickHandler(loginClickHandlers);
        binding.setLogin(login);
    }
}