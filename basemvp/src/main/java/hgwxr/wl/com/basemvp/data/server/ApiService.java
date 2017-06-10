package hgwxr.wl.com.basemvp.data.server;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import hgwxr.wl.com.basemvp.BuildConfig;
import hgwxr.wl.com.basemvp.DemoApp;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author wl
 * @version :
 * @date 2017/4/14
 * @描述
 */

public class ApiService {

    public  static final String BASE_URL=BuildConfig.URL;//"http://www.tngou.net/";

        public static <S> S createService(Class<S> sClass) {
            Gson gson = new GsonBuilder()
                   /* .registerTypeAdapterFactory(new TypeAdapterFactory() {
                        @Override
                        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
                            return  new AutoValueGson_MyGsonTypeAdapterFactory();
                        }
                    })*/
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                    .create();
            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(HttpUrl.parse(BASE_URL))
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
           // builder.client(provideOkHttpClient());
            return (S) builder.build().create(sClass);
    }

   private   static   OkHttpClient provideOkHttpClient() {
        Cache cache = new Cache(DemoApp.getAppContext().getCacheDir(), 10240 * 1024);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
           // builder.addNetworkInterceptor(new StethoInterceptor());
        }
        builder.addNetworkInterceptor(new CacheInterceptor())
                .cache(cache)
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS);
        return builder.build();
    }

    private static class CacheInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response response = chain.proceed(request);
            return response.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    //cache for 30 days
                    .header("Cache-Control", "max-age=" + 3600 * 24 * 30)
                    .build();
        }
    }
}
