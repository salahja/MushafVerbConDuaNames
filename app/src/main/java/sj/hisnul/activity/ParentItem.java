package sj.hisnul.activity;

import java.util.ArrayList;

/**
 * Created by sana on 26/7/18.
 */
public class ParentItem {
    private String name;
    private String title;
    private String activeFilter;
    private int chapterid;
    private ArrayList<ChildItem> childList = new ArrayList<ChildItem>();

    public ParentItem() {
    }

    public ParentItem(String title, String activeFilter) {
        this.title = title;
        this.activeFilter = activeFilter;
    }

    public ParentItem(String name, ArrayList<ChildItem> childList) {
        this.name = name;
        this.childList = childList;
    }

    public int getChapterid() {
        return chapterid;
    }

    public void setChapterid(int chapterid) {
        this.chapterid = chapterid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActiveFilter() {
        return activeFilter;
    }

    public void setActiveFilter(String activeFilter) {
        this.activeFilter = activeFilter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ChildItem> getChildList() {
        return childList;
    }

    public void setChildList(ArrayList<ChildItem> childList) {
        this.childList = childList;
    }
}
