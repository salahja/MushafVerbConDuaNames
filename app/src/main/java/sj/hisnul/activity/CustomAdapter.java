package sj.hisnul.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mushafconsolidated.R;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomAdapter extends BaseExpandableListAdapter {
    private final Context context;
    private final ArrayList<ParentItem> parentItemArrayList;
    private final ArrayList<ParentItem> originalList;
    int currentgrouposition;
    HashMap<Integer, Integer> childCheckboxState = new HashMap<>();
    ArrayList<String> listOfStatusFilters = new ArrayList<>();
    ArrayList<Selected> selectedfilters = new ArrayList<>();
    private ArrayList<ChildItem> childItemArrayList;

    public CustomAdapter(Context context, ArrayList<ParentItem> parentItemArrayList) {
        this.context = context;
        this.parentItemArrayList = parentItemArrayList;
        this.originalList = new ArrayList<>();
        this.originalList.addAll(parentItemArrayList);
    }

    @Override
    public int getGroupCount() {
        return parentItemArrayList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        childItemArrayList = parentItemArrayList.get(i).getChildList();
        return childItemArrayList.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return parentItemArrayList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        childItemArrayList = parentItemArrayList.get(groupPosition).getChildList();
        return childItemArrayList.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup parent) {
        ParentItem parentItemInfo = (ParentItem) getGroup(groupPosition);
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //  view = inflater.inflate(R.layout.group_items,null);
            view = inflater.inflate(R.layout.nlist_group, null);
        }
        TextView tv_parentItem = (TextView) view.findViewById(R.id.tv_parentItem);
        ImageView iv_groupIndicator = (ImageView) view.findViewById(R.id.iv_groupIndicator);
        tv_parentItem.setText(parentItemInfo.getName());
        if (isExpanded) {
            iv_groupIndicator.setImageResource(R.drawable.baseline_expand_24);
        } else {
            iv_groupIndicator.setImageResource(R.drawable.baseline_close_24);
        }
        iv_groupIndicator.setSelected(isExpanded);
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup viewGroup) {
        ChildItem childItemInfo = (ChildItem) getChild(groupPosition, childPosition);
        getGroup(groupPosition);
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //    view = layoutInflater.inflate(R.layout.child_items,null);
            view = layoutInflater.inflate(R.layout.list_item, null);
        }
        TextView tv_childItem = (TextView) view.findViewById(R.id.tv_childItem);
        tv_childItem.setText(childItemInfo.getName());
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    public void filterData(String query) {
        query = query.toLowerCase();
        parentItemArrayList.clear();
        if (query.isEmpty()) {
            parentItemArrayList.addAll(originalList);
        } else {
            for (ParentItem parentItem : originalList) {
                ArrayList<ChildItem> childList = parentItem.getChildList();
                ArrayList<ChildItem> newlist = new ArrayList<ChildItem>();
                for (ChildItem childRow : childList) {
                    if (childRow.getName().toLowerCase().contains(query)) {
                        newlist.add(childRow);
                    }
                }
                if (newlist.size() > 0) {
                    ParentItem nParentRow = new ParentItem(parentItem.getName(), newlist);
                    parentItemArrayList.add(nParentRow);
                }
            }

        } // end else
        notifyDataSetChanged();
    }

}
