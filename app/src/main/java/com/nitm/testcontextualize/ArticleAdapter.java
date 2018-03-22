package com.nitm.testcontextualize;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jibesh Bhattacharjee on 21-03-2018.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private List<Article> articleItems;
    private Context context;

    public ArticleAdapter(List<Article> articleItems, Context context) {
        this.articleItems = articleItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Article articleItem = articleItems.get(position);

        holder.headTextView.setText(articleItem.getHeading());
        holder.descTextView.setText(articleItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return articleItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView headTextView;
        public TextView descTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            headTextView = (TextView) itemView.findViewById(R.id.cardHeading);
            descTextView = (TextView) itemView.findViewById(R.id.cardDescription);

        }
    }
}
