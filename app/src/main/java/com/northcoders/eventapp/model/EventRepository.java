package com.northcoders.eventapp.model;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.northcoders.eventapp.service.EventAPIService;
import com.northcoders.eventapp.service.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventRepository {
    private MutableLiveData<List<Event>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public EventRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Event>> getMutableLiveData(){
        EventAPIService service = RetrofitInstance.getService();
        Call<List<Event>> call = service.displayEvents();
        call.enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                List<Event> events = response.body();
                mutableLiveData.setValue(events);
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                Log.i("EventRepositoryError", "onFailure: " + t.getMessage());
            }
        });
        return mutableLiveData;
    }
}
