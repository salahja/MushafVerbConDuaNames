package sj.hisnul.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.Utils;

import java.util.ArrayList;

import sj.hisnul.activity.NewExpandAct;
import sj.hisnul.adapter.CatTwoAdapter;
import sj.hisnul.entity.hcategory;

public class CatTwoFrag extends Fragment {
    RecyclerView recyclerView;

    public static CatTwoFrag newInstance() {
        return new CatTwoFrag();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_catwo_drawble, container, false);
        recyclerView = view.findViewById(R.id.recview);
        Utils utils = new Utils(getContext());
        ArrayList<hcategory> duagrouptwo = Utils.getHcategory();
        CatTwoAdapter adapter = new CatTwoAdapter(duagrouptwo, getContext());
        GridLayoutManager layoutManager;
        layoutManager = new GridLayoutManager(getActivity(), 3);

     /*
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup()
        {
            @Override
            public int getSpanSize(int position)
            {
             //   return position == 0 ? 3 : 1;
            }
        });

      */
        recyclerView.setHasFixedSize(true);
        // recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.SetOnItemClickListener((v, position) -> {
            hcategory catTwo = duagrouptwo.get(position);
            if (!catTwo.getTitle().isEmpty()) {
                Intent intent = new Intent(getActivity(), NewExpandAct.class);
                intent.putExtra("PARENT_ACTIVITY_REF", "ParentActivityIsA");
                startActivity(intent);
                int catid = catTwo.getId();
                intent.putExtra("dua_id", catid);
                startActivity(intent);

            }
        });
        return view;
    }

}
