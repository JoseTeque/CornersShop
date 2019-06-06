package m.google.androidcornershop.categoria;

import android.support.annotation.Nullable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import m.google.androidcornershop.modelo.Modelo;

public class CategoriaPresenter implements CategoriaMVP.Presenter {

    @Nullable
    private CategoriaMVP.View view;
    private CategoriaMVP.Model model;

    private Disposable subscription;

    public CategoriaPresenter(CategoriaMVP.Model model) {
        this.model = model;
    }

    @Override
    public void loadData() {
        model.results()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Modelo>() {
                    @Override
                    public void onNext(Modelo modelo) {
                        if (view!=null){
                            view.updateCategoria(modelo);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        if (view!=null){
                            view.showSnackbar("Error al descargar las Comidas..");
                        }
                    }

                    @Override
                    public void onComplete() {
                        if (view!=null){
                            view.showSnackbar("Informacion descargada con exito..");
                        }
                    }
                });
    }

    @Override
    public void rxjavaUnsuscribe() {
        if (subscription!=null && !subscription.isDisposed())
        {
            subscription.dispose();
        }

    }

    @Override
    public void setView(CategoriaMVP.View view) {
           this.view= view;
    }
}
