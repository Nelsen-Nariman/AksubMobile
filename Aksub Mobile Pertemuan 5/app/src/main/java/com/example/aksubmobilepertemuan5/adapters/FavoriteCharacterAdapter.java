package com.example.aksubmobilepertemuan5.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aksubmobilepertemuan5.R;
import com.example.aksubmobilepertemuan5.database.CharacterDB;
import com.example.aksubmobilepertemuan5.models.FavoriteCharacter;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FavoriteCharacterAdapter extends RecyclerView.Adapter<FavoriteCharacterAdapter.viewHolder> {
    List<FavoriteCharacter> favoriteCharacterList;
    Context context;
    CharacterDB characterDB;

    public FavoriteCharacterAdapter(List<FavoriteCharacter> favoriteCharacterList, Context context) {
        this.favoriteCharacterList = favoriteCharacterList;
        this.context = context;
        this.characterDB = new CharacterDB(context);
    }

    @NonNull
    @Override
    public FavoriteCharacterAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_character, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteCharacterAdapter.viewHolder holder, int position) {
        FavoriteCharacter character = favoriteCharacterList.get(position);
        holder.tvName.setText(character.getName());
        holder.tvKanji.setText(character.getNameKanji());
        holder.tvFavorites.setText(character.getFavorites() + " Likes");
        holder.detailButton.setOnClickListener(v -> {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(character.getUrl())));
        });
        Picasso.with(context)
                .load(character.getImageUrl())
                .resize(250, 250)
                .placeholder(R.drawable.load_image)
                .error(R.drawable.no_image_placeholder_svg)
                .centerCrop()
                .into(holder.ivThumbnail);

        holder.favoriteButton.setOnClickListener(v -> {
            if(characterDB.deleteCharacter(character.getId()) > 0) {
                Toast.makeText(context, "Character removed from favorites!", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, "Failed to remove character!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return favoriteCharacterList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvKanji, tvFavorites;
        ImageView ivThumbnail;
        Button detailButton;
        ImageButton favoriteButton;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_character_name);
            tvKanji = itemView.findViewById(R.id.tv_character_kanji);
            tvFavorites = itemView.findViewById(R.id.tv_favorites);
            ivThumbnail = itemView.findViewById(R.id.iv_thumbnail);
            detailButton = itemView.findViewById(R.id.detail_btn);
            favoriteButton = itemView.findViewById(R.id.favorite_btn);
        }
    }
}
