package com.example.mushafconsolidated.Activity;

import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.text.HtmlCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.Activity.placeholder.PlaceholderContent;
import com.example.mushafconsolidated.Entities.GrammarRules;
import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.databinding.FragmentGrammarruleListBinding;
import com.example.mushafconsolidated.databinding.GrammarruleListContentBinding;


import java.util.List;

/**
 * A fragment representing a list of GrammarRules. This fragment
 * has different presentations for handset and larger screen devices. On
 * handsets, the fragment presents a list of items, which when touched,
 * lead to a {@link GrammarRuleDetailFragment} representing
 * item details. On larger screens, the Navigation controller presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class GrammarRuleListFragment extends Fragment {

    /**
     * Method to intercept global key events in the
     * item list fragment to trigger keyboard shortcuts
     * Currently provides a toast when Ctrl + Z and Ctrl + F
     * are triggered
     */
    ViewCompat.OnUnhandledKeyEventListenerCompat unhandledKeyEventListenerCompat = (v, event) -> {
        if (event.getKeyCode() == KeyEvent.KEYCODE_Z && event.isCtrlPressed()) {
            Toast.makeText(
                    v.getContext(),
                    "Undo (Ctrl + Z) shortcut triggered",
                    Toast.LENGTH_LONG
            ).show();
            return true;
        } else if (event.getKeyCode() == KeyEvent.KEYCODE_F && event.isCtrlPressed()) {
            Toast.makeText(
                    v.getContext(),
                    "Find (Ctrl + F) shortcut triggered",
                    Toast.LENGTH_LONG
            ).show();
            return true;
        }
        return false;
    };

    private FragmentGrammarruleListBinding binding;
    private FragmentGrammarruleListBinding bindings;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentGrammarruleListBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewCompat.addOnUnhandledKeyEventListener(view, unhandledKeyEventListenerCompat);

        RecyclerView recyclerView = binding.grammarruleList;

        // Leaving this not using view binding as it relies on if the view is visible the current
        // layout configuration (layout, layout-sw600dp)
    //  View itemDetailFragmentContainer = view.findViewById(R.id.grammarrule_detail_nav_container);
       View itemDetailFragmentContainer = view.findViewById(R.id.grammarrule_detail_nav_container);
        /* Click Listener to trigger navigation based on if you have
         * a single pane layout or two pane layout
         */
        View.OnClickListener onClickListener = itemView -> {
            GrammarRules item =
                    (GrammarRules) itemView.getTag();

            Bundle arguments = new Bundle();
            arguments.putString(GrammarRuleDetailFragment.ARG_ITEM_ID, String.valueOf(item.getId()));
    //     if (itemDetailFragmentContainer != null) {
        //      Navigation.findNavController(itemDetailFragmentContainer)
          //            .navigate(R.id.fragment_grammarrule_detail, arguments);
         //   } else {
                Navigation.findNavController(itemView).navigate(R.id.show_grammarrule_detail, arguments);
          //  }
        };

        /*
         * Context click listener to handle Right click events
         * from mice and trackpad input to provide a more native
         * experience on larger screen devices
         */
        View.OnContextClickListener onContextClickListener = itemView -> {
            PlaceholderContent.PlaceholderItem item =
                    (PlaceholderContent.PlaceholderItem) itemView.getTag();
            Toast.makeText(
                    itemView.getContext(),
                    "Context click of item " + item.id,
                    Toast.LENGTH_LONG
            ).show();
            return true;
        };

        setupRecyclerView(recyclerView, onClickListener, onContextClickListener);
    }

    private void setupRecyclerView(
            RecyclerView recyclerView,
            View.OnClickListener onClickListener,
            View.OnContextClickListener onContextClickListener
    ) {

        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(
                PlaceholderContent.ITEMS,
                onClickListener,
                onContextClickListener
        ));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public static class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<GrammarRules> mValues;
        private final View.OnClickListener mOnClickListener;
        private final View.OnContextClickListener mOnContextClickListener;

        SimpleItemRecyclerViewAdapter(List<GrammarRules> items,
                                      View.OnClickListener onClickListener,
                                      View.OnContextClickListener onContextClickListener) {
            mValues = items;
            mOnClickListener = onClickListener;
            mOnContextClickListener = onContextClickListener;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            GrammarruleListContentBinding binding =
                    GrammarruleListContentBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new ViewHolder(binding);

        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            int id = mValues.get(position).getId();
            String s = String.valueOf(id);
            holder.mIdView.setText(s);
         //   holder.mContentView.setText(mValues.get(position).getHarf());
        holder.mContentView.setText(mValues.get(position).getWorddetails());

        //    holder.mContentView.setText(HtmlCompat.fromHtml(mValues.get(position).getWorddetails() ,0));


            holder.itemView.setTag(mValues.get(position));
            holder.itemView.setOnClickListener(mOnClickListener);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                holder.itemView.setOnContextClickListener(mOnContextClickListener);
            }

        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            final TextView mIdView;
            final TextView mContentView;

            ViewHolder(GrammarruleListContentBinding binding) {
                super(binding.getRoot());
                mIdView = binding.idText;
                mContentView = binding.content;
            }

        }
    }
}