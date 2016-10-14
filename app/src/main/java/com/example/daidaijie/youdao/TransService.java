package com.example.daidaijie.youdao;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by daidaijie on 2016/5/31.
 */
public interface TransService {

    @GET("openapi.do?keyfrom=daidaijie&key=1448573306&type=data&doctype=json&version=1.1")
    Observable<TransResult> getTrans(@Query("q") String words);
}
