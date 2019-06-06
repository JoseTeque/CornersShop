package m.google.androidcornershop.root;

import javax.inject.Singleton;

import dagger.Component;
import m.google.androidcornershop.categoria.CategoriaActivity;
import m.google.androidcornershop.categoria.CategoriaModule;
import m.google.androidcornershop.http.CategoriaModuleHttp;
import m.google.androidcornershop.login.LoginActivity;

@Singleton
@Component(modules = {ApplicationModule.class, CategoriaModule.class, CategoriaModuleHttp.class})
public interface ApplicationComponent {

     void inject(CategoriaActivity target);
}
