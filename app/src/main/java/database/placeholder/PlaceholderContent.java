package database.placeholder;

import com.example.mushafconsolidated.Entities.GrammarRules;
import com.example.mushafconsolidated.Utils;
import com.example.utility.QuranGrammarApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import database.entity.DuaGroup;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class PlaceholderContent {

    /**
     * An array of sample (placeholder) items.
     */
    public static final List<DuaGroup> ITEMS = new ArrayList<DuaGroup>();

    /**
     * A map of sample (placeholder) items, by ID.
     */


    public static final Map<String, DuaGroup> ITEM_MAP = new HashMap<String, DuaGroup>();
    private static final int COUNT = 25;

    static {
        Utils util = new Utils(QuranGrammarApplication.getContext());
        ArrayList<DuaGroup> rules = util.getDuagroup();
        for (DuaGroup s : rules) {
            addItems(s);

        }



    }
    private static void addItems(DuaGroup item) {
        ITEMS.add(item);
        ITEM_MAP.put(String.valueOf(item.get_id()), item);
    }



    private static PlaceholderItem createPlaceholderItem(int position) {
        return new PlaceholderItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A placeholder item representing a piece of content.
     */
    public static class PlaceholderItem {
        public final String id;
        public final String content;
        public final String details;

        public PlaceholderItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}