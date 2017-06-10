package hgwxr.wl.com.basemvp.data.server;

import hgwxr.wl.com.basemvp.data.other.CaipuBase;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Administrator on 2017/6/9.
 */

public interface IServerApi {

    //http://www.tngou.net/api/cook/classify
    @GET("api/cook/classify")
    Observable<CaipuBase> getCaiPuBase();
}
