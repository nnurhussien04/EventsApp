package com.northcoders.eventapp.service;

import com.northcoders.eventapp.model.Customer;
import com.northcoders.eventapp.model.Event;
import com.northcoders.eventapp.model.Login;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface EventAPIService {
    @GET("Event")
    Call<List<Event>> displayEvents();

    @POST("CustomerLogin")
    Call<ResponseBody> customerLogin(@Body Login login);

    @POST("StaffLogin")
    Call<ResponseBody> staffLogin(@Body Login login);

    @POST("CustomerSignup")
    Call<Customer> customerSignUp(@Body Customer customer);



}
