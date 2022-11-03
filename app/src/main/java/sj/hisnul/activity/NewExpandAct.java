package sj.hisnul.activity;


        import android.app.SearchManager;
        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.ExpandableListView;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.appcompat.widget.SearchView;
        import androidx.appcompat.widget.Toolbar;
        import androidx.fragment.app.Fragment;
        import androidx.fragment.app.FragmentTransaction;

        ;


        import com.example.mushafconsolidated.Activity.BaseActivity;
        import com.example.mushafconsolidated.R;
        import com.example.mushafconsolidated.Utils;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;


        import sj.hisnul.fragments.HDuaNamesfrag;
        import sj.hisnul.entity.hduanames;

public class NewExpandAct extends BaseActivity implements SearchView.OnQueryTextListener, SearchView.OnCloseListener  {

    private int previousGroup = -1;
    private HashMap<String,ParentItem> subjects;
    private ArrayList<ParentItem> parentItemsList;

  //  ExpandableListView expandableListView;

    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;
    private ExpandableListView expandableListView;

    private ArrayList<ChildItem> childItemsList;

    private Toolbar toolbar;
    private ArrayList<hduanames> hduanamesArrayList =new ArrayList<>();
    private CustomAdapter customAdapter;
    ArrayList<String>  dataheader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expand_act);
   //     setContentView(R.layout.activity_dua_group);
        toolbar =   findViewById(R.id.my_action_bar);
       // setSupportActionBar(toolbar);
        setSupportActionBar(toolbar);
        ;

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
     //   String list=   bundle.getString("list");
        int dua_id = bundle.getInt("dua_id");
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
      //  expandableListDetail = ExpandableListDataPump.getData();
        expandableListView = findViewById(R.id.expandableListView);

      //  iv_groupIndicator = findViewById(R.id.iv_groupIndicator);
        Utils utils=new Utils(this);
        hduanamesArrayList = utils.getDunamesbyid(String.valueOf(dua_id));

        subjects = new HashMap<>();
        parentItemsList = new ArrayList<>();
        childItemsList = new ArrayList<>();
        loadDatas();
        displayList();

       dataheader=new ArrayList<>();
        for (hduanames duanamesDetail : hduanamesArrayList) {
            dataheader.add(duanamesDetail.getDuaname());

        }





    }

    private void loadDatas() {
        String header="";


        for (hduanames hduanames : hduanamesArrayList) {
         header =    hduanames.getChapname();
         addItem(hduanames.getChapname(),hduanames.getDuaname(),hduanames.getID());


        }


    }

    private int addItem(String parentItemName, String childItemName, String id)
    {
        int groupPosition = 0;
       if(parentItemName.isEmpty()){
           parentItemName=parentItemsList.get(0).getName();
       }
        //check the hash map if the group already exists
        ParentItem parentItemObj = subjects.get(parentItemName);

        //add the group if doesn't exists
        if(parentItemObj == null)
        {
            parentItemObj = new ParentItem();
            parentItemObj.setName(parentItemName);
            subjects.put(parentItemName,parentItemObj);

            parentItemsList.add(parentItemObj);

        }

        //get the children for the group
        childItemsList = parentItemObj.getChildList();

        //size of the children list
        int listSize = childItemsList.size();

        //add to the counter
        listSize++;

        //create a new child and add that to the group

        ChildItem childItemObj = new ChildItem();
        childItemObj.setName(childItemName);
        childItemObj.setID(id);
        childItemsList.add(childItemObj);
        parentItemObj.setChildList(childItemsList);

        //find the group position inside the list
        groupPosition = parentItemsList.indexOf(parentItemObj);
        return groupPosition;
    }

    private void displayList() {
      //  loadData();
        customAdapter = new CustomAdapter(this,parentItemsList,dataheader);
        expandableListView.setAdapter(customAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                if (expandableListView.isGroupExpanded(groupPosition)) {
                    expandableListView.collapseGroup(groupPosition);
                    previousGroup=-1;
                } else {
                    expandableListView.expandGroup(groupPosition);
                    if(previousGroup!=-1){
                        expandableListView.collapseGroup(previousGroup);
                    }
                    previousGroup=groupPosition;
                }

                return true;
            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                /* Auto Scrolling */
                expandableListView.setSelectedGroup(groupPosition);
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {



           String data= String.valueOf(parentItemsList.get(groupPosition).getChildList().get(childPosition));
        String name=        parentItemsList.get(groupPosition).getChildList().get(childPosition).getName();
        String did=        parentItemsList.get(groupPosition).getChildList().get(childPosition).getID();
           //     String data=      expandableListDetail.get(expandableListTitle.get(groupPosition)).get(childPosition);


                getSupportActionBar().hide();


                Bundle bundle1=new Bundle();
                bundle1.putString("id",  did);
                bundle1.putString("list","list");
                //  bundle.putString("ref",ref);
                Fragment fragvsi = HDuaNamesfrag.newInstance(did,"list");
                fragvsi.setArguments(bundle1);

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction.replace(R.id.frame_container, fragvsi, "items");
                //     transaction.addToBackStack("setting");
                transaction.addToBackStack("items");
                transaction.commit();

                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        getSupportActionBar().show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        View actionView = menu.findItem(R.id.search).getActionView();

        searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo
                (searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(this);
        searchView.requestFocus();

        return true;

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.backup) {
            int count = getSupportFragmentManager().getBackStackEntryCount();

            if (count == 0) {
                super.onBackPressed();
                //additional code
            } else {
                getSupportFragmentManager().popBackStack();
            }

        }






        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onClose() {
        customAdapter.filterData("");
      //  expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        customAdapter.filterData(query);
       expandAll();
        return false;
    }

    private void expandAll()
    {
        int count = customAdapter.getGroupCount();
        for(int i = 0; i < count; i++)
        {
            expandableListView.expandGroup(i);
        }
    }
    @Override
    public boolean onQueryTextChange(String newText) {
        customAdapter.filterData(newText);
       expandAll();
        return false;
    }






}
