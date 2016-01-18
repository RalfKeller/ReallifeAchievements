package de.stefanralf.rlachievements;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;

import java.nio.ReadOnlyBufferException;
import java.util.ArrayList;
import java.util.List;

import co.mobiwise.library.ProgressLayout;
import mehdi.sakout.fancybuttons.FancyButton;

/**
 * Created by Ralf on 17.01.2016.
 */
public class MyAdapter extends RecyclerView.Adapter {
    private ArrayList<Achievement> achievements;
    public MyAdapter(ArrayList<Achievement> achievements) {
        this.achievements = achievements;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RelativeLayout layout = (RelativeLayout)LayoutInflater.from(parent.getContext())
                .inflate(R.layout.achievement_progress_layout, parent, false);
        AchievementHolder vh = new AchievementHolder(layout);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final AchievementHolder Aholder = (AchievementHolder)holder;
        Aholder.achievementName.setText(achievements.get(position).getTitel());

        Aholder.minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float currentProgress = Aholder.bar.getProgress();
                if (currentProgress > 0)
                    Aholder.bar.setProgress(currentProgress - 1);
            }
        });

        Aholder.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float currentProgress = Aholder.bar.getProgress();
                if (currentProgress < 100)
                    Aholder.bar.setProgress(currentProgress + 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return achievements.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class AchievementHolder extends android.support.v7.widget.RecyclerView.ViewHolder
    {
        RelativeLayout layout;
        TextView achievementName;
        FancyButton minusButton;
        FancyButton plusButton;
        RoundCornerProgressBar bar;
        public AchievementHolder(RelativeLayout layout) {
            super(layout);
            this.layout = layout;
            achievementName = (TextView)layout.findViewById(R.id.achievementName);
            minusButton = (FancyButton)layout.findViewById(R.id.buttonMinus);
            plusButton = (FancyButton)layout.findViewById(R.id.buttonPlus);
            bar = (RoundCornerProgressBar)layout.findViewById(R.id.pbar);
        }
    }
}
