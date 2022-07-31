package com.example.calculator;

import static android.content.Context.MODE_PRIVATE;

import android.content.ComponentName;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;

import android.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Settings#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Settings extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Settings() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Settings.
     */
    // TODO: Rename and change types and number of parameters
    public static Settings newInstance(String param1, String param2) {
        Settings fragment = new Settings();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);
        Spinner spinner = rootView.findViewById(R.id.dropdown);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this.getContext(), R.array.icons, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        SharedPreferences settings = getActivity().getSharedPreferences("Icon", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        Button applyButton = rootView.findViewById(R.id.apply_settings);
        applyButton.setOnClickListener(view ->{
            editor.putString("icon", "");
            editor.putString("icon", spinner.getSelectedItem().toString());
            Log.println(Log.ASSERT,"icon",spinner.getSelectedItem().toString());
            editor.apply();
            if(spinner.getSelectedItem().toString().equals("Default"))
                ((MainActivity)getActivity()).default_icon();
            if(spinner.getSelectedItem().toString().equals("Themed"))
                ((MainActivity)getActivity()).themed_icon();
        });
        return rootView;
    }


}