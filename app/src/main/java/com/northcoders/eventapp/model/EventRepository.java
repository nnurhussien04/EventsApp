package com.northcoders.eventapp.model;

import android.app.Application;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.northcoders.eventapp.service.EventAPIService;
import com.northcoders.eventapp.service.RetrofitInstance;
import com.northcoders.eventapp.ui.mainactivity.MainActivity;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;

public class EventRepository {
    private MutableLiveData<List<Event>> mutableLiveData = new MutableLiveData<>();
    private MutableLiveData<String> loginMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<Customer> customerMutableLiveData = new MutableLiveData<>();
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
        Call<ResponseBody> call = service.customerLogin(login);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful() && response.body()!=null){
                    try {
                        String answer = response.body().string();
                        if(answer.equals("Login Successful")){
                            loginMutableLiveData.setValue(answer);
                        }
                        else{
                            getStaffLoginData(login);
                        }
                    } catch (IOException e) {
                        Toast.makeText(application.getApplicationContext(),"Network Error",Toast.LENGTH_SHORT).show();
                        throw new RuntimeException(e);
                    }
                }
                else{
                    Toast.makeText(application.getApplicationContext(),"Login Unsuccessful",Toast.LENGTH_SHORT).show();
                    loginMutableLiveData.setValue(response.toString());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("EventRepositoryError",t.getMessage());
               Toast.makeText(application.getApplicationContext(),"Connection Failed",Toast.LENGTH_SHORT).show();
            }
        });
        return loginMutableLiveData;
    }

    public MutableLiveData<String> getStaffLoginData(@Body Login login){
        EventAPIService service = RetrofitInstance.getService();
        Call<ResponseBody> call = service.staffLogin(login);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String answer = response.body().string();
                    loginMutableLiveData.setValue(answer);
                } catch (IOException e) {
                    Toast.makeText(application.getApplicationContext(), "Network Error", Toast.LENGTH_SHORT).show();
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(application.getApplicationContext(), "Connection Failed", Toast.LENGTH_SHORT).show();
            }
        });
    return loginMutableLiveData;
    }

    public MutableLiveData<Customer> CustomerSignUp(Customer customer){
        EventAPIService service = RetrofitInstance.getService();
        Call<Customer> call = service.customerSignUp(customer);
        call.enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call<Customer> call, Response<Customer> response) {
                if(response.isSuccessful() & response != null){
                    customerMutableLiveData.setValue(response.body());
                    Toast.makeText(application.getApplicationContext(), "Sign Up Successful", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Customer> call, Throwable t) {
                Toast.makeText(application.getApplicationContext(), "Connection Failed", Toast.LENGTH_SHORT).show();
            }
        });
        return customerMutableLiveData;
    }


}
