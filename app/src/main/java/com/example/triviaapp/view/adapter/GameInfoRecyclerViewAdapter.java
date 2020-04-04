package com.example.triviaapp.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.triviaapp.R;
import com.example.triviaapp.model.GameInfo;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class GameInfoRecyclerViewAdapter extends RecyclerView.Adapter<GameInfoRecyclerViewAdapter.ViewHolder> {
    Context context;
    List<GameInfo> gameInfoList;

    public GameInfoRecyclerViewAdapter(List<GameInfo> gameInfoList, Context context) {
        this.gameInfoList = gameInfoList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View listItem = layoutInflater.inflate(R.layout.recyclerview_page_history_item, viewGroup, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.render(viewHolder, position);
    }

    @Override
    public int getItemCount() {
        return gameInfoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder holder;
        int position;
        GameInfo gameInfo;
        TextView gameIdTV, gameStartTimeTV, gameUserNameTV, gameBestCricketerTV, gameFlagColorTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gameIdTV = itemView.findViewById(R.id.saved_game_id);
            gameStartTimeTV = itemView.findViewById(R.id.saved_game_start_time);
            gameUserNameTV = itemView.findViewById(R.id.saved_user_name);
            gameBestCricketerTV = itemView.findViewById(R.id.saved_cricketer_name);
            gameFlagColorTV = itemView.findViewById(R.id.saved_flag_colors);
        }

        public void render(ViewHolder viewHolder, int position) {
            this.holder = viewHolder;
            this.position = position;
            gameInfo = gameInfoList.get(position);
            setGameInfo();
        }

        private void setGameInfo() {
            gameIdTV.setText(Integer.toString(gameInfo.getId()));
            gameStartTimeTV.setText(gameInfo.getStartTime());
            gameUserNameTV.setText(gameInfo.getUserName());
            gameBestCricketerTV.setText(gameInfo.getBestCricketerName());
            gameFlagColorTV.setText(gameInfo.getIndianFlagColors());
        }
    }

}
