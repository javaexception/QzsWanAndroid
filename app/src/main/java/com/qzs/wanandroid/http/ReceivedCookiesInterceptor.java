package com.qzs.wanandroid.http;

import com.qzs.wanandroid.utils.LogUtils;
import com.qzs.wanandroid.utils.SpUtils;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

public class ReceivedCookiesInterceptor  implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        Response originalResponse = chain.proceed(chain.request());

        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            //解析Cookie
            for (String header : originalResponse.headers("Set-Cookie")) {

                stringBuilder.append(header);


                if(header.contains("JSESSIONID")){

                    String cookie = header.substring(header.indexOf("JSESSIONID"), header.indexOf(";"));
                    SpUtils.SetConfigString("cookie", cookie);
                    LogUtils.d("cookie---qzs   "+cookie);


                }
            }
            LogUtils.d("cookie全部-----   " + stringBuilder.toString());
        }

        return originalResponse;

    }
}
