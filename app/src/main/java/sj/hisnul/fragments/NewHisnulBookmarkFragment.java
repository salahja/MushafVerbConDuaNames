package sj.hisnul.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.Utils;
import com.example.mushafconsolidated.intrface.OnItemClickListener;
import com.example.utility.SwipeToDeleteCallback;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import sj.hisnul.adapter.NewHisnulBookmarksShowAdapter;
import sj.hisnul.entity.hduanames;

/**
 * Bookmark fragment class
 */
public class NewHisnulBookmarkFragment extends Fragment implements AdapterView.OnItemClickListener {
    CoordinatorLayout coordinatorLayout;
    RecyclerView.LayoutManager layoutManager;
    private NewHisnulBookmarksShowAdapter bookmarksShowAdapter;
    private RecyclerView mRecview;

    public static NewHisnulBookmarkFragment newInstance() {
        NewHisnulBookmarkFragment ff = new NewHisnulBookmarkFragment();
        return ff;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookmark, container, false);
        Utils utils = new Utils(getActivity());
        //    List<BookMarks> bookMarksNew = utils.getBookMarksNew();
        ArrayList<hduanames> bookmarked = utils.getBookmarked(1);
        //  List<BookMarks> bookmarks = new DatabaseAccess().getBookmarks();
        bookmarksShowAdapter = new NewHisnulBookmarksShowAdapter(getActivity());
        mRecview = view.findViewById(R.id.recyclerViewAdapterTranslation);
        coordinatorLayout = view.findViewById(R.id.coordinatorLayout);
        this.layoutManager = new LinearLayoutManager(getActivity());
        mRecview.setLayoutManager(layoutManager);
        //    bookmarksShowAdapter.setBookMarkArrayList((ArrayList<String>) bookmarstringarray);
        bookmarksShowAdapter.setBookMarkArrayList(bookmarked);
        mRecview.setAdapter(bookmarksShowAdapter);
        //    mRecview.setLayoutManager(new LinearLayoutManager(getActivity()));
        enableSwipeToDeleteAndUndo();
        return view;
    }

    private void enableSwipeToDeleteAndUndo() {
        SwipeToDeleteCallback swipeToDeleteCallback = new SwipeToDeleteCallback(getActivity()) {
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                //    final int position = viewHolder.getAdapterPosition();
                //  final String item = mAdapter.getData().get(position);
                //   mAdapter.removeItem(position);
                final int position = viewHolder.getAdapterPosition();
                final hduanames item = bookmarksShowAdapter.getBookMarkArrayList().get(position);
                //   final int code = item.hashCode();
                bookmarksShowAdapter.getItemId(position);
                bookmarksShowAdapter.removeItem(position);
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Item was removed from the list.", Snackbar.LENGTH_LONG);
                snackbar.setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //     bookmarksShowAdapter.restoreItem(item, position);
                        mRecview.scrollToPosition(position);
                    }
                });
                snackbar.setActionTextColor(Color.CYAN);
                snackbar.show();
                final long itemId = bookmarksShowAdapter.getItemId(position);
                final int bookmarkid = bookmarksShowAdapter.getBookmarid();
                bookmarksShowAdapter.getBookChapterno();
                //      bookmarksShowAdapter.getBookMarkArrayList(bookmarkid)
                Utils butils = new Utils(getActivity());
                //       butils.deleteBookmarks(bookmarid);
                butils.updateFav(0, item.getChap_id());
                //    Utils.deleteBookMarks(item);
            }
        };
        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeToDeleteCallback);
        itemTouchhelper.attachToRecyclerView(mRecview);
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bookmarksShowAdapter.SetOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Object tag = view.getTag();
                Utils butils = new Utils(getActivity());
                boolean id = tag.equals("id");
                boolean delete = tag.equals("delete");
                hduanames bookid = (hduanames) bookmarksShowAdapter.getItem(position);
                if (id) {
                    Bundle bundle1 = new Bundle();
                    int chap_id = bookid.getChap_id();
                    bundle1.putInt("chap_id", chap_id);
                    FragmentManager fragmentManagers = getActivity().getSupportFragmentManager();
                    FragmentTransaction transactions = fragmentManagers.beginTransaction();
                    transactions.setCustomAnimations(R.anim.slide_down, R.anim.slide_up);
                    DisplayFromBookMark fragvsi = DisplayFromBookMark.newInstance();
                    fragvsi.setArguments(bundle1);
                    transactions.replace(R.id.frame_container, fragvsi);
                    transactions.addToBackStack(null);
                    transactions.commit();

                } else if (delete) {
                    int catid = bookid.getChap_id();
                    butils.updateFav(0, catid);
                    Snackbar snackbar = Snackbar
                            .make(coordinatorLayout, "Item was removed from the list.", Snackbar.LENGTH_LONG);
                    snackbar.setActionTextColor(Color.CYAN);
                    snackbar.show();
                    //     RefreshActivity();
                    //      HisnulMainAct.viewPager.setCurrentItem(2);
                }

            }
        });

    }

    private void loadFragments(Fragment fragment, String fragtag) {
        // load fragment
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.left_slide, android.R.anim.fade_out);
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(fragtag);
        transaction.commit();

    }
}
