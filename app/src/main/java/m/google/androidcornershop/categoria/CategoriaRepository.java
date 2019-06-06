package m.google.androidcornershop.categoria;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import m.google.androidcornershop.http.HttpInterfaces;
import m.google.androidcornershop.modelo.Modelo;

public class CategoriaRepository  implements CategoriaInterfacesRepository{

    private static final String TAG = "CategoriaRepository ";
    private HttpInterfaces interfaces;


    private List<Modelo> results;
    private long lastTimes;

    private static final long CACHE_LIFETIME = 20 * 1000; //cache de durara 20seg

    public CategoriaRepository(HttpInterfaces interfaces ) {
        this.interfaces = interfaces;
        this.lastTimes = System.currentTimeMillis();
        this.results = new ArrayList<>();
    }

    public boolean isUpdated() {
        return (System.currentTimeMillis() - lastTimes) < CACHE_LIFETIME;
    }

    @Override
    public Observable<Modelo> getResultFromNetwork() {

           Observable<List<Modelo>> getCategory= interfaces.getCategoria();

           return getCategory.concatMap(new Function<List<Modelo>, Observable<Modelo>>() {
               @Override
               public Observable< Modelo> apply(List<Modelo> modelos) {
                   return Observable.fromIterable(modelos);
               }
           }).doOnNext(new Consumer<Modelo>() {
               @Override
               public void accept(Modelo modelo) {
                 results.add(modelo);

               }
           });

    }

    @Override
    public Observable<Modelo> getResultFromCache() {
        if (isUpdated()) {
            return Observable.fromIterable(results);
        } else {
            lastTimes = System.currentTimeMillis();
            results.clear();
            return Observable.empty();
        }
    }

    @Override
    public Observable<Modelo> getResultData() {
        return getResultFromCache().switchIfEmpty(getResultFromNetwork());
    }

}
