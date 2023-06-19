package com.example.pagination.Di

import com.example.pagination.Api.ApiServices
import com.example.pagination.Utils.Cons
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Networkmodule {

    //Base_Url
    @Provides
    @Singleton
    fun Provide_Baseurl():String=Cons.Base_Url
    //Time
    @Provides
    fun Provide_Time():Long=Cons.Time
    //Gson
    @Provides
    @Singleton
    fun Provide_Gson():Gson=GsonBuilder()
        .setLenient().create()
    //Client
    @Provides
    @Singleton
    fun Provide_Client(Time:Long)=OkHttpClient.Builder()
        .readTimeout(Time,TimeUnit.SECONDS)
        .writeTimeout(Time,TimeUnit.SECONDS)
        .connectTimeout(Time,TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .build()
    //Retrofit
    @Provides
    @Singleton
    fun Provide_Retrofit(Base_Url:String,Client:OkHttpClient,gson:Gson)=Retrofit.Builder()
        .baseUrl(Base_Url)
        .client(Client)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(ApiServices::class.java)
}