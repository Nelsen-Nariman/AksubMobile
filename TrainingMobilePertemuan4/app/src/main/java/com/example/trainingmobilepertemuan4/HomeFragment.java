package com.example.trainingmobilepertemuan4;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeFragment extends Fragment {
    TextView textDisplay;
    EditText editDisplay;
    Button saveButton;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        textDisplay = view.findViewById(R.id.tv_display_text);
        editDisplay = view.findViewById(R.id.et_display_text);
        saveButton = view.findViewById(R.id.btn_save);

        sharedPreferences = getActivity().getSharedPreferences("sharedPreference", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        textDisplay.setText(sharedPreferences.getString("textDisplay", "Text default"));

        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Please wait...");

        saveButton.setOnClickListener(v -> {
            String newText = editDisplay.getText().toString();
            if(!newText.equals("")){
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                // set title, message, tombol
                builder
                    .setTitle("Are you sure?")
                    .setMessage("Do you want to change text to " + newText)
                    .setPositiveButton("Save", (dialog, which) -> {
                        textDisplay.setText(newText);
                        editor.putString("textDisplay", newText);
                        editor.apply();
                        progressDialog.show();
                        Toast.makeText(getActivity(), "Save success", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("Cancel", ((dialog, which) -> {
                        Toast.makeText(getActivity(), "Cancelled", Toast.LENGTH_SHORT).show();
                    }));

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        return view;
    }
}