package com.example.aksubmobilepertemuan5.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Layout;
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
import com.example.aksubmobilepertemuan5.models.Character;
import com.example.aksubmobilepertemuan5.models.FavoriteCharacter;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.viewHolder> {
    List<Character> characterList;
    Context context;
    CharacterDB characterDB;

    public CharacterAdapter(List<Character> characterList, Context context){
        this.characterList = characterList;
        this.context = context;
        this.characterDB = new CharacterDB(context);
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_character, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Character c = characterList.get(position);
        holder.tvName.setText(c.getName());
        holder.tvKanji.setText(c.getNameKanji());
        holder.tvFavorites.setText(c.getFavorites() + " Likes");
        holder.detailButton.setOnClickListener(v -> {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(c.getUrl())));
        });
        Picasso.with(context)
                .load(c.getImages().getJpg().getImageUrl())
                .resize(250, 250)
                .placeholder(R.drawable.load_image)
                .error(R.drawable.no_image_placeholder_svg)
                .centerCrop()
                .into(holder.ivThumbnail);

        holder.favoriteButton.setOnClickListener(v -> {
            FavoriteCharacter favoriteCharacter = new FavoriteCharacter(
                    0,
                    c.getName(),
                    c.getNameKanji(),
                    c.getUrl(),
                    c.getImages().getJpg().getImageUrl(),
                    c.getFavorites()
            );
            if(characterDB.insertCharacter(favoriteCharacter) != -1){
                Toast.makeText(context, "Character added to favorites!", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, "Fail to add character!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }

    public void setCharacterList(List<Character> characterList) {
        this.characterList = characterList;
        notifyDataSetChanged();
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
