package com.example.dhc.service

import com.example.dhc.model.*
import com.example.dhc.service.response.*
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @POST("/api/registerCustomer")
    suspend fun registerCustomer(@Field("uuid") uuid: String,
                                 @Field("nickname") nickname: String): Response<RegisterCustomerResponse>

    @POST("/api/setOrder")
    suspend fun setOrder(@Body order: Order): Response<SetOrderResponse>


    @GET("/api/getCounseling?id={id}&sex={sex}")
    suspend fun getCounseling(@Path("id") id: Int,
                              @Path("sex") sex: Int): Response<GetCounselingResponse>

    @POST("/api/getCounselingResult")
    suspend fun getCounselingResult(@Field("counseling_id") counselingId: Int): Response<GetCounselingResultResponse>

    @POST("/api/registerCounselingResult")
    suspend fun registerCounselingResult(@Field("uuid") uuid: String,
                                         @Field("counseling_id") counselingId: Int,
                                         @Field("selected") selected: String): Response<RegisterCounselingResultResponse>

    @POST("/api/getMedicalResult")
    suspend fun getMedicalResult(@Field("sex") sex: Int,
                                 @Field("medical_id") medicalId: Int): Response<GetMedicalResultResponse>

    @POST("/api/registerMedicalResult")
    suspend fun registerMedicalResult(@Body medicalExam: MedicalExam): Response<RegisterMedicalResultResponse>

    @GET("/api/getComponent")
    suspend fun getComponent(): Response<GetComponentResponse>
}