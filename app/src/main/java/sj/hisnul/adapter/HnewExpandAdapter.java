package sj.hisnul.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.intrface.OnItemClickListener;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class HnewExpandAdapter extends RecyclerView.Adapter<HnewExpandAdapter.ViewHolder> {
    OnItemClickListener mItemClickListener;
    //    private final Integer arabicTextColor;
    HashMap<String, List<String>> catOneArrayList;
    private Context context;

    @NonNull
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sarfkabeercolumn, parent, false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bookmark_act, parent, false);
        //    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.thulathisarfsagheer, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(@NotNull ViewHolder holder, int position) {
        Set<String> keys = catOneArrayList.keySet();
        for (String key : keys) {
            List<String> strings1 = catOneArrayList.get(key);
            holder.title.setText(key);
            assert strings1 != null;
            for (String s : strings1) {
                holder.content.setText(s);
            }
            System.out.println(key + " -- "
                    + catOneArrayList.get(key));
        }

    }

    @Override
    public long getItemId(int position) {
        //  Surah surah = surahArrayList.get(position);
        return catOneArrayList.size();
    }

    public Object getItem(int position) {
        return catOneArrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return catOneArrayList.size();

    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener // current clickListerner
    {
        public final TextView title;
        final TextView content;

        public ViewHolder(View view) {
            super(view);
            content = view.findViewById(R.id.expandedListItem);
            title = view.findViewById(R.id.header_text);
            title.setOnClickListener(this);
            content.setOnClickListener(this);
            title.setOnClickListener(view1 -> {
                if (content.getVisibility() == View.GONE) {
                    content.setVisibility(View.VISIBLE);
                } else {
                    content.setVisibility(View.GONE);
                }

            });
            title.setOnClickListener(view12 -> {
            });
            view.setOnClickListener(this);
            //imageView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getLayoutPosition());
            }
        }

    }

}

