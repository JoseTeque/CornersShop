package m.google.androidcornershop.login;

public interface LoginMVP {

    interface view{

        void  showSnackbarNotAvailable();
        void  showSnackbarError();
        void showSaveUser();

        void setFirstName(String name);
        void setLastName(String apellido);

    }

    interface presenter{

    }

    interface model{

    }


}
