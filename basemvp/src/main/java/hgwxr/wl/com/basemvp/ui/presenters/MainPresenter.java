package hgwxr.wl.com.basemvp.ui.presenters;

import android.util.Log;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.TimeUnit;

import hgwxr.wl.com.basemvp.DemoApp;
import hgwxr.wl.com.basemvp.data.DataManager;
import hgwxr.wl.com.basemvp.data.other.CaipuBase;
import hgwxr.wl.com.basemvp.ui.actions.IMainView;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/6/9.
 */

public class MainPresenter extends  BasePresenter<IMainView> {
    private static final String TAG = MainPresenter.class.getSimpleName();

    public MainPresenter(){

    }
    private CaipuBase mCaipuBase;
    public void loadDataCaiPu(){
        if (mCaipuBase!=null){
              Observable.from(mCaipuBase.getTngou())
                      .onBackpressureBuffer()
                      .sample(1,TimeUnit.SECONDS)
                      .doOnNext(new Action1<CaipuBase.TngouBean>() {
                          @Override
                          public void call(CaipuBase.TngouBean tngouBean) {
                              Log.d(TAG, "call() called with: tngouBean = [" + tngouBean.toString() + "]");
                          }
                      }).subscribe();
                     /* .observeOn(AndroidSchedulers.mainThread())
                      .subscribe(new Subscriber<CaipuBase.TngouBean>() {
                          @Override
                          public void onCompleted() {
                              Toast.makeText(DemoApp.getAppContext(),"complete",Toast.LENGTH_SHORT).show();
                          }

                          @Override
                          public void onError(Throwable e) {

                          }

                          @Override
                          public void onNext(CaipuBase.TngouBean tngouBean) {
                              Log.d(TAG, "onNext() called with: tngouBean = [" + tngouBean.toString() + "]");
                              mActionView.handleCaiPuTianGou(tngouBean);
                          }
                      });*/

           /* Observable .from(mCaipuBase.getTngou())
                    .toSortedList()
                    .interval(2, TimeUnit.SECONDS)
                   .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        CaipuBase.TngouBean tngouBean = mCaipuBase.getTngou().get(aLong.intValue());
                        Log.d(TAG, "onNext() called with: tngouBean = [" + tngouBean.toString() + "]");
                        mActionView.handleCaiPuTianGou(tngouBean);
                    }
                });
*/
             /* Observable.from(mCaipuBase.getTngou())
                      //.observeOn(AndroidSchedulers.mainThread())
                      .timeout(10,TimeUnit.SECONDS)
                      .subscribe(new Subscriber<CaipuBase.TngouBean>() {
                          @Override
                          public void onCompleted() {
                              Toast.makeText(DemoApp.getAppContext(),"complete",Toast.LENGTH_SHORT).show();
                          }

                          @Override
                          public void onError(Throwable e) {

                          }

                          @Override
                          public void onNext(CaipuBase.TngouBean tngouBean) {
                              Log.d(TAG, "onNext() called with: tngouBean = [" + tngouBean.toString() + "]");
                              mActionView.handleCaiPuTianGou(tngouBean);
                          }
                      });*/
        }else{
        Observable<CaipuBase> caiPuBase = DataManager.getInstance().getmIServerApi().getCaiPuBase();
        caiPuBase.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Func1<CaipuBase, Observable<CaipuBase.TngouBean>>() {
                    @Override
                    public Observable<CaipuBase.TngouBean> call(CaipuBase caipuBase) {
                        mCaipuBase=caipuBase;
                        return createListObserable(caipuBase);
                    }
                })

                .subscribe(new Subscriber<CaipuBase.TngouBean>() {
                    @Override
                    public void onCompleted() {
                        Toast.makeText(DemoApp.getAppContext(),"complete",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(CaipuBase.TngouBean tngouBean) {
                    //   if (mCaipuBase==null) {
                           mActionView.handleCaiPuTianGou(tngouBean);
                           Log.d(TAG, "onNext() called with: tngouBean = [" + tngouBean + "]");
                      // }
                    }
                });}
        /* caiPuBase.subscribeOn(Schedulers.io())
                 .map(new Func1<CaipuBase, List<CaipuBase.TngouBean>>() {
                     @Override
                     public List<CaipuBase.TngouBean> call(CaipuBase caipuBase) {
                         return caipuBase.getTngou();
                     }
                 })
              .observeOn(AndroidSchedulers.mainThread())
             .subscribe(new Subscriber<List<CaipuBase.TngouBean>>() {
                 @Override
                 public void onCompleted() {
                     Toast.makeText(DemoApp.getAppContext(),"complete",Toast.LENGTH_LONG).show();
                 }

                 @Override
                 public void onError(Throwable e) {

                 }

                 @Override
                 public void onNext(List<CaipuBase.TngouBean> tngouBeans) {
                     mActionView.handleCaiPuNum(tngouBeans.size());
                 }
             });*/

    }

    private Observable<CaipuBase.TngouBean> createListObserable(CaipuBase tngou) {
        return Observable.from(tngou.getTngou()).sample(2000,TimeUnit.SECONDS);
    }
}
