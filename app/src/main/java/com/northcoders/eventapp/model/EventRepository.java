package com.northcoders.eventapp.model;

import android.app.Application;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.northcoders.eventapp.service.EventAPIService;
import com.northcoders.eventapp.service.RetrofitInstance;
import com.northcoders.eventapp.ui.mainactivity.MainActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;

public class EventRepository {
    private MutableLiveData<List<Event>> mutableLiveData = new MutableLiveData<>();
    private MutableLiveData<String> loginMutableLiveData = new MutableLiveData<>();
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

    public MutableLiveData<String> getLoginData(@Body Login login){
        EventAPIService service = RetrofitInstance.getService();
        Call<String> call = service.customerLogin(login);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful() && response.body()!=null){
                    loginMutableLiveData.setValue(response.toString());
                }
                else{
                    Toast.makeText(application.getApplicationContext(),"Login Unsuccessful",Toast.LENGTH_SHORT).show();
                    loginMutableLiveData.setValue(response.toString());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("EventRepositoryError",t.getMessage());
               Toast.makeText(application.getApplicationContext(),"Connection Failed",Toast.LENGTH_SHORT).show();
            }
        });
        return loginMutableLiveData;
    }


}
