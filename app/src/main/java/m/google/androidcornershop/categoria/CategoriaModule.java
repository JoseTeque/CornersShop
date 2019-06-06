package m.google.androidcornershop.categoria;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import m.google.androidcornershop.http.HttpInterfaces;


@Module
public class CategoriaModule {

    @Provides
    @Singleton
    public CategoriaMVP.Presenter providesPresenter(CategoriaMVP.Model model){
        return new CategoriaPresenter(model);
    }

    @Provides
    @Singleton
    public CategoriaMVP.Model providesModel(CategoriaInterfacesRepository repository){
        return new CategoriaModel(repository);
    }

    @Singleton
    @Provides
    public  CategoriaInterfacesRepository providesRepository(HttpInterfaces interfaces){
        return new CategoriaRepository(interfaces);
    }
}
