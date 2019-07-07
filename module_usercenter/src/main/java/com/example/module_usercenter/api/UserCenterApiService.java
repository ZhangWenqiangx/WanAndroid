package com.example.module_usercenter.api;

import com.example.common_base.base.BaseResponse;
import com.example.module_usercenter.bean.LoginResult;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Description:
 */
public interface UserCenterApiService {

    @POST("user/login")
    @FormUrlEncoded
    Observable<BaseResponse<LoginResult>> login(@Field("username") String name,
                                                @Field("password") String pwd);

}
