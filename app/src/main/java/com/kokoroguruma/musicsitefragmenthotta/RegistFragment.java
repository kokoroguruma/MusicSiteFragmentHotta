package com.kokoroguruma.musicsitefragmenthotta;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegistFragment extends Fragment {

    MyApplication application;


    public RegistFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        application = (MyApplication) getActivity().getApplication();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_regist, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        this.onClickRegistSubmitButton();

        super.onViewCreated(view, savedInstanceState);
    }


    private void onClickRegistSubmitButton() {
        Button button = getActivity().findViewById(R.id.registSubmitButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {System.out.println("aaaaaaa");
                application.getMainActivity().setMainFragment(new LoginFragment());
            }
        });
    }

}
