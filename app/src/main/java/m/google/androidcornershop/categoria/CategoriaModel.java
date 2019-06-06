package m.google.androidcornershop.categoria;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.BiFunction;
import m.google.androidcornershop.modelo.Modelo;

public class CategoriaModel implements CategoriaMVP.Model {

    private CategoriaInterfacesRepository repository;

    public CategoriaModel(CategoriaInterfacesRepository repository) {
        this.repository = repository;
    }


    @Override
    public Observable<Modelo> results() {
        return Observable.zip(repository.getResultData(), repository.getResultFromNetwork(), new BiFunction<Modelo, Modelo, Modelo>() {
            @Override
            public Modelo apply(Modelo modelo, Modelo modelo2) throws Exception {
                return new Modelo(modelo.getImagen(),modelo2.getNombre());
            }
        });
    }
}
