package com.northcoders.eventapp.ui.signup;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.northcoders.eventapp.R;
import com.northcoders.eventapp.databinding.CustomerSignUpBinding;
import com.northcoders.eventapp.model.Customer;
import com.northcoders.eventapp.ui.mainactivity.MainActivityViewModel;
import androidx.lifecycle.LifecycleOwner;

public class CustomerSignUpActivity extends AppCompatActivity implements LifecycleOwner {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.customer_sign_up);
        CustomerSignUpBinding binding = DataBindingUtil.setContentView(this,R.layout.customer_sign_up);
        MainActivityViewModel viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        Customer customer = new Customer();
        CustomerClickHandler clickHandler = new CustomerClickHandler(viewModel,customer,this);
        binding.setClickHandler(clickHandler);
        binding.setCustomer(customer);
    }
}