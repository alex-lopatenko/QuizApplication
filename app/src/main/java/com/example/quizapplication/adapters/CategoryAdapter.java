package com.example.quizapplication.adapters;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapplication.R;
import com.example.quizapplication.listeners.ListItemClickListener;
import com.example.quizapplication.quiz.CategoryModel;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private Context mContext;
    private Activity mActivity;

    private ArrayList<CategoryModel> categoryList;
    private ListItemClickListener itemClickListener;

    public CategoryAdapter(Context mContext, Activity mActivity, ArrayList<CategoryModel> categoryList) {
        this.mContext = mContext;
        this.mActivity = mActivity;
        this.categoryList = categoryList;
    }

    public void setItemClickListener(ListItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category_recycler, parent, false);
        return new ViewHolder(view, viewType, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
        final  CategoryModel model = categoryList.get(position);

        String categoryName = model.getCategoryName();
        holder.tvCategoryTitle.setText(Html.fromHtml(categoryName));
        holder.tvCategoryId.setText(String.valueOf(position + 1));

        switch (position) {
            case 0:
                holder.lytContainer.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rectangle_yellow));
                break;
            case 1:
                holder.lytContainer.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rectangle_green));
                break;
            case 2:
                holder.lytContainer.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rectangle_blue));
                break;
            case 3:
                holder.lytContainer.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rectangle_orange));
                break;
            case 4:
                holder.lytContainer.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rectangle_red));
                break;
            case 5:
                holder.lytContainer.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rectangle_purple));
                break;
            case 6:
                holder.lytContainer.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rectangle_yellow));
                break;
            case 7:
                holder.lytContainer.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rectangle_green));
                break;
            case 8:
                holder.lytContainer.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rectangle_blue));
                break;
            case 9:
                holder.lytContainer.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rectangle_orange));
                break;
            case 10:
                holder.lytContainer.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rectangle_red));
                break;
            case 11:
                holder.lytContainer.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rectangle_purple));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return (null != categoryList ? categoryList.size() : 0);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private RelativeLayout lytContainer;
        private TextView tvCategoryTitle, tvCategoryId;
        private ListItemClickListener itemClickListener;

        public ViewHolder(View itemView, int viewType, ListItemClickListener itemClickListener) {
            super(itemView);

            this.itemClickListener = itemClickListener;
            lytContainer = (RelativeLayout) itemView.findViewById(R.id.lytContainer);
            tvCategoryId = (TextView) itemView.findViewById(R.id.categoryId);
            tvCategoryTitle = (TextView) itemView.findViewById(R.id.titleText);

            lytContainer.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (itemClickListener != null) {
                itemClickListener.onItemClick(getLayoutPosition(), view);
            }
        }
    }
}
