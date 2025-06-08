package com.northcoders.eventapp.service;

import com.northcoders.eventapp.model.Customer;
import com.northcoders.eventapp.model.Event;
import com.northcoders.eventapp.model.Login;
import com.northcoders.eventapp.model.Staff;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface EventAPIService {
    @GET("Event")
    Call<List<Event>> displayEvents();

    @POST("CustomerLogin")
    Call<ResponseBody> customerLogin(@Body Login login);

    @POST("StaffLogin")
    Call<ResponseBody> staffLogin(@Body Login login);

    @POST("CustomerSignup")
    Call<Customer> customerSignUp(@Body Customer customer);

    @POST("Event")
    Call<Event> createEvent(@Body Event event);

    @POST("StaffDetails")
    Call<Staff> staffDetails(@Body Login login);

    @PUT("Event/{id}")
    Call<Event> updateEvent(@Body Event event,@Path("id") Long id);

    @DELETE("Event/{id}")
    Call<Void> deleteEvent(@Path("id") Long id);




}
