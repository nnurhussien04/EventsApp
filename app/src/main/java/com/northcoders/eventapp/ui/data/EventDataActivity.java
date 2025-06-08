package com.northcoders.eventapp.ui.data;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;

import com.northcoders.eventapp.R;
import com.northcoders.eventapp.databinding.EventDataBinding;
import com.northcoders.eventapp.model.Event;
import com.northcoders.eventapp.ui.mainactivity.MainActivityViewModel;


public class EventDataActivity extends AppCompatActivity implements LifecycleOwner {

    private EventDataBinding eventDataBinding;
    private Event event;

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_data);
        MainActivityViewModel viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        event = getIntent().getParcelableExtra("EVENT_KEY",Event.class);
        EventDataClickHandler eventDataClickHandler = new EventDataClickHandler(event,viewModel,this);
        eventDataBinding = DataBindingUtil.setContentView(this,R.layout.event_data);
        eventDataBinding.setEvent(event);
        eventDataBinding.setClickHandler(eventDataClickHandler);
        checkRole();
    }

    public void checkRole(){
        MainActivityViewModel viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.getStaffData().observe(this, staff -> {
            EditText nameBox = findViewById(R.id.nameBox);
            EditText descriptionBox = findViewById(R.id.descriptionBox);
            EditText dateBox = findViewById(R.id.dateBox);
            EditText timeBox = findViewById(R.id.timeBox);
            EditText locationBox = findViewById(R.id.locationBox);
            EditText staffBox = findViewById(R.id.staffNameBox);
            Button editButton = findViewById(R.id.editButton);
            Button deleteButton = findViewById(R.id.deleteButton);
            if (staff != null) {
                return;
            } else {
                nameBox.setFocusable(false);
                descriptionBox.setFocusable(false);
                dateBox.setFocusable(false);
                timeBox.setFocusable(false);
                locationBox.setFocusable(false);
                staffBox.setFocusable(false);
                editButton.setText("Calendar");
                deleteButton.setText("Sign Up");
                return;
            }
        });
    }
}