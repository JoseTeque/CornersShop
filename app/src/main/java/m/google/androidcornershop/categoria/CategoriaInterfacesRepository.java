package m.google.androidcornershop.categoria;

import java.util.List;

import io.reactivex.Observable;
import m.google.androidcornershop.modelo.Modelo;

public interface CategoriaInterfacesRepository {

    Observable<Modelo> getResultFromNetwork();
    Observable<Modelo> getResultFromCache();
    Observable<Modelo> getResultData();
}
