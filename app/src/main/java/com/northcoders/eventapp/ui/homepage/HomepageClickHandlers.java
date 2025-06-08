package com.northcoders.eventapp.ui.homepage;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.northcoders.eventapp.ui.create.EventCreateActivity;
import com.northcoders.eventapp.ui.data.EventDataActivity;
import com.northcoders.eventapp.ui.login.LoginActivity;
import com.northcoders.eventapp.ui.mainactivity.MainActivity;

public class HomepageClickHandlers {
    private Context context;

    public HomepageClickHandlers(Context context) {
        this.context = context;
    }

    public void eventPage(View view){
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public void logoutPage(View view){
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    public void createPage(View view){
        Intent intent = new Intent(context, EventCreateActivity.class);
        context.startActivity(intent);
    }




}
