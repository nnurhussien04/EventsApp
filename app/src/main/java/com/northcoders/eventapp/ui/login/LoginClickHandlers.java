package com.northcoders.eventapp.ui.login;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;

import com.northcoders.eventapp.model.Login;
import com.northcoders.eventapp.ui.mainactivity.MainActivity;
import com.northcoders.eventapp.ui.mainactivity.MainActivityViewModel;

public class LoginClickHandlers
{
    private Login login;
    private Context context;
    private MainActivityViewModel mainActivityViewModel;

    public LoginClickHandlers(Login login, Context context, MainActivityViewModel mainActivityViewModel) {
        this.login = login;
        this.context = context;
        this.mainActivityViewModel = mainActivityViewModel;
    }

    public void LoginCheck(View view){
        if(login.getUsername() == null || login.getPassword() == null){
            Toast.makeText(context,"Username or Password is Empty",Toast.LENGTH_SHORT).show();
        }
        else{
            mainActivityViewModel.getLoginData(login).observe((LifecycleOwner) context, result -> {
                if ("Login Successful".equals(result)) {
                    Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, MainActivity.class);
                    context.startActivity(intent);
                } else {
                    Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    /*public void SignUpDisplay(){
        Intent intent = new Intent(context,);
        context.startActivity();
    }*/
}
