package edu.gwu.alohanews.save;

import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.LinkedList;
import java.util.List;
import edu.gwu.alohanews.R;
import edu.gwu.alohanews.common.AlohaFragmentManager;
import edu.gwu.alohanews.retrofit.response.News;
import edu.gwu.alohanews.save.detail.SavedNewsDetailedFragment;

public class SavedNewsAdapter extends RecyclerView.Adapter<SavedNewsAdapter.SavedNewsViewHolder> {

    private List<News> newsList;
    private AlohaFragmentManager fragmentManager;
    private static int[] ICON_ARRAY = new int[]{R.drawable.a_news_icon, R.drawable.g_news_icon,
            R.drawable.c_news_icon, R.drawable.y_news_icon, R.drawable.m_news_icon};

    public SavedNewsAdapter(AlohaFragmentManager alohaFragmentManager) {
        this.fragmentManager = alohaFragmentManager;
        this.newsList = new LinkedList<>();

    }

    public void setNewsList(List<News> newsList) {
        this.newsList.clear();
        this.newsList.addAll(newsList);
        notifyDataSetChanged();
    }


    @Override
    public SavedNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.saved_news_item, parent, false);
        return new SavedNewsViewHolder(view);
    }


    @Override
    public void onBindViewHolder(SavedNewsViewHolder holder, int position) {
        News news = newsList.get(position);
        holder.author.setText(news.getAuthor());
        holder.description.setText(news.getDescription());
        holder.icon.setImageResource(getDrawable());
        holder.itemView.setOnClickListener(v -> {
            fragmentManager.doFragmentTransaction(SavedNewsDetailedFragment.newInstance(news));
        });
    }

    private @DrawableRes
    int getDrawable() {
        return ICON_ARRAY[(int)(Math.random() * 5)];
    }


    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public static class SavedNewsViewHolder extends RecyclerView.ViewHolder {

        TextView author;
        TextView description;
        ImageView icon;

        public SavedNewsViewHolder(View itemView) {
            super(itemView);
            author = itemView.findViewById(R.id.author);
            description = itemView.findViewById(R.id.description);
            icon = itemView.findViewById(R.id.image);
        }
    }
}
