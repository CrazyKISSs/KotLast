package ru.krisproject.kotucheniy2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class Level_Fragment extends Fragment {

    ImageView image_choise_level_fragment;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button = view.findViewById(R.id.back_from_level_fragment);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

 //      image_choise_level_fragment = getView().findViewById(R.id.image_choise_level_fragment);
//                view.findViewById(R.id.image_choise_level_fragment);
        //       image_choise_level_fragment.setImageResource(DataBase.image[MainActivity4.index_level]);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_level, container, false);
    }
}