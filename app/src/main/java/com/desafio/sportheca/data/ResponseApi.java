package com.desafio.sportheca.data;

import com.desafio.sportheca.domain.ResponseObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ResponseApi {
    @GET("teste.json")
    Call<ResponseObject> getResponseObject();
}
