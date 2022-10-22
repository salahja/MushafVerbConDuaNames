package database;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.example.mushafconsolidated.R;
import com.example.utility.QuranGrammarApplication;
import com.mikepenz.iconics.view.IconicsButton;

import java.util.List;

import database.entity.DuaDetails;

public class DuaDetailAdapter extends BaseAdapter {
    private static Typeface sCachedTypeface = null;
    private final Typeface prefArabicFontTypeface;
    private final int prefArabicFontSize;
    private final SharedPreferences sharedPreferences;
    private final Context context;

    private List<DuaDetails> mList;
    private LayoutInflater mInflater;

    //public CardView cardview;


    private String myToolbarTitle;

    public DuaDetailAdapter(Context context, List<DuaDetails> items, String toolbarTitle) {
        mInflater = LayoutInflater.from(context);
        mList = items;
     sharedPreferences = android.preference.PreferenceManager.getDefaultSharedPreferences(context);
       String fontCategory = sharedPreferences.getString("arabic_font_category", "kitab.ttf");
      prefArabicFontTypeface = Typeface.createFromAsset(QuranGrammarApplication.getContext().getAssets(), fontCategory);
        prefArabicFontSize = sharedPreferences.getInt("pref_font_arabic_key",20);
        this.context=context
;
    //    final Integer prefArabicFontSize = sharedPreferences.getInt("pref_font_arabic_key",20);


      /*
        if (sCachedTypeface == null) {
            sCachedTypeface = Typeface.createFromAsset(
                    context.getAssets(), prefArabicFontTypeface);
        }

       */
        myToolbarTitle = toolbarTitle;

    }

    public void setData(List<DuaDetails> items) {
        mList = items;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public DuaDetails getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        final ViewHolder mHolder;
        final DuaDetails p = getItem(position);

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.dua_detail_item_card, parent, false);

            mHolder = new ViewHolder();
            mHolder.tvDuaNumber = (TextView) convertView.findViewById(R.id.txtDuaNumber);
            mHolder.cardview=  convertView.findViewById(R.id.card_view);
            String theme = sharedPreferences.getString("themepref", "dark");

            if (theme.equals("dark")) {
                mHolder.cardview.setCardBackgroundColor(context.getResources().getColor(R.color.color_background_overlay));


            } else if (theme.equals("blue")) {
                mHolder.cardview.setCardBackgroundColor(context.getResources().getColor(R.color.solarizedBase02));

            }

            if (theme.equals("dark")) {
                mHolder.cardview.setCardBackgroundColor(context.getResources().getColor(R.color.bg_dark_blue));


            } else if (theme.equals("blue")) {
                mHolder.cardview.setCardBackgroundColor(context.getResources().getColor(R.color.bg_dark_blue));

            }
            else if (theme.equals("white")) {
                mHolder.cardview.setCardBackgroundColor(context.getResources().getColor(R.color.md_theme_dark_inversePrimary));

            }





            mHolder.tvDuaArabic = (TextView) convertView.findViewById(R.id.txtDuaArabic);
            mHolder.tvDuaArabic.setTypeface(sCachedTypeface);
            mHolder.tvDuaArabic.setTextSize(prefArabicFontSize);

            mHolder.tvDuaTranslation = (TextView) convertView.findViewById(R.id.txtDuaTranslation);
            mHolder.tvDuaTranslation.setTextSize(prefArabicFontSize);

            mHolder.tvDuaReference = (TextView) convertView.findViewById(R.id.txtDuaReference);
            mHolder.tvDuaReference.setTextSize(prefArabicFontSize);

            mHolder.shareButton =  convertView.findViewById(R.id.button_share);
            mHolder.favButton =  convertView.findViewById(R.id.button_star);

            final ViewHolder finalHolder = mHolder;
            mHolder.shareButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View convertView) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_TEXT,
                            myToolbarTitle + "\n\n" +
                                    finalHolder.tvDuaArabic.getText() + "\n\n" +
                                    finalHolder.tvDuaTranslation.getText() + "\n\n" +
                                    finalHolder.tvDuaReference.getText() + "\n\n" +
                                    convertView.getResources().getString(R.string.action_share_credit)
                    );
                    intent.setType("text/plain");
                    convertView.getContext().startActivity(
                            Intent.createChooser(
                                    intent,
                                    convertView.getResources().getString(R.string.action_share_title)
                            )
                    );
                }
            });

            final View finalConvertView = convertView;
            mHolder.favButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View ConvertView) {
              //      boolean isFav = !p.getFav();

                    // Following snippet taken from:
                    // http://developer.android.com/training/basics/data-storage/databases.html#UpdateDbRow
                 //   mDbHelper = new ExternalDbOpenHelper(finalConvertView.getContext().getApplicationContext());

                //    SQLiteDatabase db = mDbHelper.getReadableDatabase();

                    // New value for one column
                  //  ContentValues values = new ContentValues();
                 //   values.put(HisnDatabaseInfo.DuaTable.FAV, isFav);

                    // Which row to update, based on the ID
               //     String selection = HisnDatabaseInfo.DuaTable.DUA_ID + " LIKE ?";
                    String[] selectionArgs = {String.valueOf(finalHolder.tvDuaNumber.getText().toString())};



                }
            });
            convertView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) convertView.getTag();
        }


        if (p != null) {

            mHolder.tvDuaNumber.setText("" + p.get_id());
            mHolder.tvDuaArabic.setText(Html.fromHtml(p.getAr_dua()));
            mHolder.tvDuaTranslation.setText(Html.fromHtml(p.getEn_translation()));

            if (p.getEn_reference() != null)
                mHolder.tvDuaReference.setText(Html.fromHtml(p.getEn_reference()));





            else
                mHolder.tvDuaReference.setText("null");

         /*
            if (p.getFav()) {
                mHolder.favButton.setText("{faw-star}");
            } else {
                mHolder.favButton.setText("{faw-star-o}");
            }
          */

            Log.d("DuaDetailAdapter", "getFav");
            Log.d("DuaDetailAdapter", "asdasds");
           // Log.d("DuaDetailAdapter", Boolean.toString(p.getFav()));
        }


        return convertView;
    }

    public static class ViewHolder {

        public CardView cardview;
        TextView tvDuaNumber;
        TextView tvDuaArabic;
        TextView tvDuaReference;
        TextView tvDuaTranslation;
        ImageView shareButton;
        ImageView favButton;
    }
}