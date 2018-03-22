package com.kokoroguruma.musicsitefragmenthotta;


import android.content.Intent;
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
public class LoginFragment extends Fragment {

    MyApplication application;


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        application = (MyApplication) getActivity().getApplication();



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.onClickList();

    }

    // ここからClick用
    private void onClickList() {
        this.onClickLoginSubmitButton();
        this.onClickLoginIntentRegistButton();
    }


    private void onClickLoginSubmitButton() {
        Button button = getActivity().findViewById(R.id.loginSubmitButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                application.login();
            }
        });
    }


    private void onClickLoginIntentRegistButton() {
        Button button = getActivity().findViewById(R.id.loginIntentRegistButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Regist画面を開く
                Intent intent = new Intent(getContext(), RegistActivity.class);
                startActivity(intent);
            }
        });
    }

}
