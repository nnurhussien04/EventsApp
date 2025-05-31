package com.northcoders.eventapp.service;

import com.northcoders.eventapp.model.Event;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface EventAPIService {
    @GET("Event")
    Call<List<Event>> displayEvents();


}
