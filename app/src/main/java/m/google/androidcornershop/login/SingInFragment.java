package m.google.androidcornershop.login;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import m.google.androidcornershop.R;
import m.google.androidcornershop.categoria.CategoriaActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class SingInFragment extends Fragment  {



    private Button btnSignIn;
    private FrameLayout frameLayout;

    public SingInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sing_in, container, false);
        btnSignIn= view.findViewById(R.id.IdbuttonSigIn);
        frameLayout=view.findViewById(R.id.IdFrame);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), CategoriaActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }
}
