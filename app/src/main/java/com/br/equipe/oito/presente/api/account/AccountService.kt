package com.br.equipe.oito.presente.api.account

import com.br.equipe.oito.presente.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface AccountService {

    @POST("${BASE_URL}signin/")
    suspend fun signIn(@Body credentials: Credentials): Response<SignInResult>

    @POST("${BASE_URL}signup/")
    suspend fun signUp(@Body newApprentice: NewApprentice): Response<SignUpResult>

    companion object {

        private const val BASE_URL = "http://25.3.22.99:3000/api/v1/auth/"

        fun create(): AccountService {
            var client: OkHttpClient? = null
            if (BuildConfig.DEBUG) {
                val logger =
                    HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
                client = OkHttpClient.Builder()
                    .addInterceptor(logger)
                    .build()
            }

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client ?: OkHttpClient.Builder().build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(AccountService::class.java)
        }

    }

}