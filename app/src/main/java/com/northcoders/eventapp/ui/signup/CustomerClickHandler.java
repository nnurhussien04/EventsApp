package com.northcoders.eventapp.ui.signup;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;

import com.northcoders.eventapp.model.Customer;
import com.northcoders.eventapp.ui.homepage.HomepageActivity;
import com.northcoders.eventapp.ui.login.LoginActivity;
import com.northcoders.eventapp.ui.mainactivity.MainActivityViewModel;
import androidx.lifecycle.LifecycleOwner;

public class CustomerClickHandler {
    private MainActivityViewModel viewModel;
    private Customer customer;
    private Context context;

    public CustomerClickHandler(MainActivityViewModel viewModel, Customer customer, Context context) {
        this.viewModel = viewModel;
        this.customer = customer;
        this.context = context;
    }

    public void signUpCustomer(View view){
        if (customer.getFirst_name() == null || customer.getFirst_name().isEmpty() ||
                customer.getLast_name() == null || customer.getLast_name().isEmpty() ||
                customer.getBirth_date() == null || customer.getBirth_date().isEmpty() ||
                customer.getEmailAddress() == null || customer.getEmailAddress().isEmpty() ||
                customer.getUsername() == null || customer.getUsername().isEmpty() ||
                customer.getPassword() == null || customer.getPassword().isEmpty()) {
            Toast.makeText(context, "Form Uncompleted", Toast.LENGTH_SHORT).show();
            return;
        }
        viewModel.getCustomerSignup(customer).observe((LifecycleOwner) context,result ->{
            if(result != null){
                Toast.makeText(context, "Signup Successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, LoginActivity.class);
                context.startActivity(intent);
            }
            else{
                Toast.makeText(context, "Signup Unsuccessful", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
