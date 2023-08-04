package com.example.aksubmobilepertemuan5.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.aksubmobilepertemuan5.R;
import com.example.aksubmobilepertemuan5.adapters.FavoriteCharacterAdapter;
import com.example.aksubmobilepertemuan5.database.CharacterDB;
import com.example.aksubmobilepertemuan5.models.FavoriteCharacter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FavoritesFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class FavoritesFragment extends Fragment {
    RecyclerView rvCharacters;
    FavoriteCharacterAdapter favoriteCharacterAdapter;
    CharacterDB characterDB;
    List<FavoriteCharacter> favoriteCharacterList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);

        characterDB = new CharacterDB(getActivity());
        favoriteCharacterList = characterDB.getAllFavoriteCharacters();
        favoriteCharacterAdapter = new FavoriteCharacterAdapter(favoriteCharacterList, getActivity());

        rvCharacters = view.findViewById(R.id.rv_characters);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rvCharacters.setLayoutManager(linearLayoutManager);
        rvCharacters.setAdapter(favoriteCharacterAdapter);

        return view;
    }
}