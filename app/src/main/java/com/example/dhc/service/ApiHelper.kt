package com.example.dhc.service

import com.example.dhc.BuildConfig
import com.example.dhc.model.Component
import com.example.dhc.model.MedicalExam
import com.example.dhc.model.Order
import com.example.dhc.service.response.*
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiHelper {

    val okHttpClient = OkHttpClient().newBuilder().addInterceptor(getInterceptor()).build()
    lateinit var apiService: ApiService

    init {
        makeService()
    }

    private fun makeService() {
        val retrofit: Retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        this.apiService = retrofit.create(ApiService::class.java)
    }

    private fun getInterceptor(): Interceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    suspend fun <T : Any>  safeApiCall(call: suspend () -> Response<T>): Result<T> {
        return try {
            val response = call.invoke()
            if (response.isSuccessful) {
                Result.Success(response.body()!!)
            } else {
                Result.Error(response.errorBody()?.string() ?: "Something goes wrong")
            }
        } catch (e: Exception) {
            Result.Error(e.message ?: "Internet error runs")
        }
    }

    /**
     * Register Customer
     */
    suspend fun registerCustomer(uuid:String, nickname: String): Result<RegisterCustomerResponse> {
        return safeApiCall(call = { apiService.registerCustomer(uuid, nickname) })
    }

    /**
     * Set Order
     */
    suspend fun setOrder(order: Order): Result<SetOrderResponse> {
        return safeApiCall(call = { apiService.setOrder(order) })
    }

    /**
     * Get Counseling
     */
    suspend fun getCounseling(counselingId: Int, sex: Int): Result<GetCounselingResponse> {
        return safeApiCall(call = { apiService.getCounseling(counselingId, sex) })
    }

    /**
     * Get Counseling Result
     */
    suspend fun getCounselingResult(counselingId: Int): Result<GetCounselingResultResponse> {
        return safeApiCall(call = { apiService.getCounselingResult(counselingId) })
    }

    /**
     * Register Counseling Result
     */
    suspend fun registerCounselingResult(uuid: String, counselingId: Int, selected: String): Result<RegisterCounselingResultResponse> {
        return safeApiCall(call = { apiService.registerCounselingResult(uuid, counselingId, selected) })
    }

    /**
     * Get Medical Result
     */
    suspend fun getMedicalResult(sex: Int, medicalId: Int): Result<GetMedicalResultResponse> {
        return safeApiCall(call = { apiService.getMedicalResult(sex, medicalId) })
    }

    /**
     * Register Medical Result
     */
    suspend fun registerMedicalResult(medicalExam: MedicalExam): Result<RegisterMedicalResultResponse> {
        return safeApiCall(call = { apiService.registerMedicalResult(medicalExam) })
    }

    /**
     * Get Component
     */
    suspend fun getComponent(): Result<GetComponentResponse> {
        return safeApiCall(call = { apiService.getComponent() })
    }

}