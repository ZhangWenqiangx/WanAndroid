package com.example.module_usercenter.api

import retrofit2.http.POST
import retrofit2.http.FormUrlEncoded
import com.example.common_base.base.data.BaseResponse
import com.example.module_usercenter.bean.LoginResult
import com.example.module_usercenter.bean.RegisterResult
import com.example.module_usercenter.bean.UserInfoResult
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.GET

/**
 * Description:
 */
interface UserCenterApiService {

    @POST("user/login")
    @FormUrlEncoded
    fun login(
        @Field("username") name: String?,
        @Field("password") pwd: String?
    ): Observable<BaseResponse<LoginResult?>?>?

    @POST("user/register")
    @FormUrlEncoded
    fun register(
        @Field("username") name: String?,
        @Field("password") pwd: String?,
        @Field("repassword") repwd: String?
    ): Observable<BaseResponse<RegisterResult?>?>?

    @GET("user/lg/userinfo/json")
    suspend fun getUserInfo(): BaseResponse<UserInfoResult>
}