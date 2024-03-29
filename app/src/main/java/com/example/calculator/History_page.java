package com.example.calculator;

import static android.content.Context.MODE_PRIVATE;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link History_page#newInstance} factory method to
 * create an instance of this fragment.
 */
public class History_page extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public History_page() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment History_page.
     */
    // TODO: Rename and change types and number of parameters
    public static History_page newInstance(String param1, String param2) {
        History_page fragment = new History_page();
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
        View rootView = inflater.inflate(R.layout.fragment_history_page, container, false);
        TextView historyView = rootView.findViewById(R.id.HistoryView);
        Button clear = rootView.findViewById(R.id.clear);
        historyView.setMovementMethod(new ScrollingMovementMethod());
        SharedPreferences settings = getActivity().getSharedPreferences("Calculations", MODE_PRIVATE);
        historyView.setText("");
        historyView.setText(settings.getString("Calc", ""));
        clear.setOnClickListener(view -> {
            historyView.setText("");
            SharedPreferences.Editor editor = settings.edit();
            editor.putString("Calc", "");
            editor.apply();
        });
        return rootView;
    }

}