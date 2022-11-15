package com.example.mushafconsolidated.Activity;

import static com.example.Constant.QURAN_VERB_ROOT;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;

import com.example.mushafconsolidated.Entities.qurandictionary;
import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.Utils;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.sj.conjugator.activity.BaseActivity;
import org.sj.conjugator.activity.KeyboardUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import database.DatabaseUtils;
import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class SearchKeyBoardAct extends BaseActivity implements View.OnClickListener {
    private final SparseArray<String> keyValues = new SparseArray<>();
    Button quranbtn,
            settingbtn;
    FloatingActionButton floatingActionButton;
    RelativeLayout layoutBottomSheet;
    BottomSheetBehavior sheetBehavior;
    ListView tlist;
    ListView mlist;
    boolean isSarfKabeed;
    private ArrayList<qurandictionary> qurandictionaryArrayList;
    private View keyboard;
    private InputConnection inputConnection;
    private AutoCompleteTextView actv;

    public void setSarfKabeed(boolean sarfKabeed) {
        isSarfKabeed = sarfKabeed;
    }

    public void setInputtext(String inputtext) {
    }

    @Override
    public void onBackPressed() {
        Log.d("CDA", "onBackPressed Called");
      /*
       Intent setIntent = new Intent(Intent.ACTION_MAIN);
        setIntent.addCategory(Intent.CATEGORY_HOME);
       setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
       startActivity(setIntent);
       */
        SearchKeyBoardAct.super.finish();
        super.onBackPressed();

     /*
        SearchKeyBoardAct.super.finish();

        HashMap<String, String> map = CorpusUtilityorig.getpreferences();
        Bundle dataBundle=new Bundle();
        map.get(SURAH_ARABIC_NAME);
        dataBundle.putString(SURAH_ARABIC_NAME,map.get(SURAH_ARABIC_NAME));
        dataBundle.putInt(CHAPTER, Integer.parseInt(map.get(CHAPTER)));
        dataBundle.putInt(AYAH_ID, Integer.parseInt(map.get(AYAH_ID)));

        Intent intent = new Intent(SearchKeyBoardAct.this, QuranGrammarAct.class);
        intent.putExtras(dataBundle);
        finish();
        startActivity(intent);
      */
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_key_activity_autocomplete);
        KeyboardUtil.hideKeyboard(SearchKeyBoardAct.this);
        keyboard = findViewById(R.id.arabic_keyboard);
        FloatingTextButton callButton = findViewById(R.id.action_buttons);
        callButton.setOnClickListener(view -> {
            SearchKeyBoardAct.super.finish();

  /*
        HashMap<String, String> map = CorpusUtilityorig.getpreferences();
        Bundle dataBundle=new Bundle();
        map.get(SURAH_ARABIC_NAME);
        dataBundle.putString(SURAH_ARABIC_NAME,map.get(SURAH_ARABIC_NAME));
        dataBundle.putInt(CHAPTER, Integer.parseInt(map.get(CHAPTER)));
        dataBundle.putInt(AYAH_ID, Integer.parseInt(map.get(AYAH_ID)));

            Intent intent = new Intent(SearchKeyBoardAct.this, QuranGrammarAct.class);
        intent.putExtras(dataBundle);
        finish();
        startActivity(intent);
   */
            SearchKeyBoardAct.super.finish();
            super.onBackPressed();
            //  Snackbar.make(viewById, "Call button clicked", Snackbar.LENGTH_SHORT).show();
        });
        //    hideKeyboardSoft();
        InputConnection ic;
        SetUpAutoComplete();
        ic = actv.onCreateInputConnection(new EditorInfo());
        // InputConnection ic = editTextAuto.onCreateInputConnection(new EditorInfo());
        setInputConnection(ic);
        init();
        // kb. getCharSequence();
    }

    private void SetUpAutoComplete() {
        KeyboardUtil.hideKeyboard(SearchKeyBoardAct.this);
        String[] root;
        Utils util = new Utils(SearchKeyBoardAct.this);
        //  ArrayList<MujarradVerbs> verbAll = util.getMujarradAall();
        qurandictionaryArrayList = util.getQuranDictionary();
        int size = qurandictionaryArrayList.size();
        root = new String[size];
        int i = 0;
        for (qurandictionary entity : qurandictionaryArrayList) {
            String roots = entity.getRootarabic();
            root[i++] = roots;
        }
        HashSet h = new HashSet(Arrays.asList(root));
        List aList2 = new ArrayList(h);
        ArrayAdapter adapters = new ArrayAdapter
                (this, R.layout.my_simple_list_item, aList2);
        ArrayAdapter listadapters = new ArrayAdapter
                (this, R.layout.my_simple_list_item, root);
        //Getting the instance of AutoCompleteTextView
        actv = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        ListView listdisp = findViewById(R.id.list_item);
        listdisp.setAdapter(listadapters);
        listdisp.setOnItemClickListener((adapterView, view, position, l) -> {
// here you code
            qurandictionary qurandictionary = qurandictionaryArrayList.get(position);
            launchActivity(qurandictionary.getRootarabic());

        });
        int sizes = 1300;
        actv.setDropDownHeight(sizes);
        actv.setThreshold(1);//will start working from first character
        actv.setAdapter(adapters);//setting the adapter data into the AutoCompleteTextView
        actv.setTextColor(Color.RED);
        actv.setTextSize((float) 50.00);
        //   editTextAuto = findViewById(R.id.autoCompleteTextView);
        actv.setRawInputType(InputType.TYPE_CLASS_TEXT);
        actv.setTextIsSelectable(true);
        //   KeyboardUtil.hideKeyboard(this);
        actv.setShowSoftInputOnFocus(false);
        actv.setOnFocusChangeListener((view, hasFocus) -> {
            if (hasFocus) {
                keyboard.setVisibility(LinearLayout.VISIBLE);
                //     actv.showDropDown();
                if (tlist != null)
                    tlist.setAdapter(null);
                if (mlist != null)
                    mlist.setAdapter(null);

            }  //   keyboard.setVisibility(LinearLayout.GONE);

        });

    }

    private void init() {
        quranbtn = findViewById(R.id.qurangrammar);
        layoutBottomSheet = findViewById(R.id.bottom_sheet);
        sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);
        floatingActionButton = findViewById(R.id.fab);
        keyboard = findViewById(R.id.arabic_keyboard);
        Button key_delete = findViewById(R.id.key_delete);
        Button key_AC = findViewById(R.id.key_AC);
        Button key_enter = findViewById(R.id.key_enter);
        keyboard = findViewById(R.id.arabic_keyboard);
        Button dhad = findViewById(R.id.dhad);
        Button suwad = findViewById(R.id.suwad);
        Button qaf = findViewById(R.id.qaf);
        Button fa = findViewById(R.id.fa);
        Button ghain = findViewById(R.id.ghain);
        Button ayn = findViewById(R.id.ayn);
        Button haaa = findViewById(R.id.haaa);
        Button kha = findViewById(R.id.kha);
        Button ha = findViewById(R.id.ha);
        Button jeem = findViewById(R.id.jeem);
        floatingActionButton.setOnClickListener(this);
        dhad.setOnClickListener(this);
        suwad.setOnClickListener(this);
        qaf.setOnClickListener(this);
        fa.setOnClickListener(this);
        ghain.setOnClickListener(this);
        ayn.setOnClickListener(this);
        haaa.setOnClickListener(this);
        kha.setOnClickListener(this);
        ha.setOnClickListener(this);
        jeem.setOnClickListener(this);
        keyValues.put(R.id.dhad, "ض");
        keyValues.put(R.id.suwad, "ص");
        keyValues.put(R.id.qaf, "ق");
        keyValues.put(R.id.fa, "ف");
        keyValues.put(R.id.ghain, "غ");
        keyValues.put(R.id.ayn, "ع");
        keyValues.put(R.id.haaa, "ه");
        keyValues.put(R.id.kha, "خ");
        keyValues.put(R.id.ha, "ح");
        keyValues.put(R.id.jeem, "ج");
        Button sheen = findViewById(R.id.sheen);
        Button seen = findViewById(R.id.seen);
        Button ya = findViewById(R.id.ya);
        Button ba = findViewById(R.id.ba);
        Button lam = findViewById(R.id.lam);
        Button alif = findViewById(R.id.hamza);
        Button ta = findViewById(R.id.ta);
        Button nun = findViewById(R.id.nun);
        Button meem = findViewById(R.id.meem);
        Button kaf = findViewById(R.id.kaf);
        sheen.setOnClickListener(this);
        seen.setOnClickListener(this);
        ya.setOnClickListener(this);
        ba.setOnClickListener(this);
        lam.setOnClickListener(this);
        alif.setOnClickListener(this);
        ta.setOnClickListener(this);
        nun.setOnClickListener(this);
        meem.setOnClickListener(this);
        kaf.setOnClickListener(this);
        //   key00.setOnClickListener(this);
        key_delete.setOnClickListener(this);
        key_AC.setOnClickListener(this);
        key_enter.setOnClickListener(this);
        //  key_dot.setOnClickListener(this);
        keyValues.put(R.id.sheen, "ش");
        keyValues.put(R.id.seen, "س");
        keyValues.put(R.id.ya, "ي");
        keyValues.put(R.id.ba, "ب");
        keyValues.put(R.id.lam, "ل");
        keyValues.put(R.id.hamza, "ء");
        keyValues.put(R.id.ta, "ت");
        keyValues.put(R.id.nun, "ن");
        keyValues.put(R.id.meem, "م");
        keyValues.put(R.id.kaf, "ك");
        Button zoay = findViewById(R.id.zoay);
        Button toay = findViewById(R.id.toay);
        Button dhal = findViewById(R.id.dhal);
        Button dal = findViewById(R.id.dal);
        Button zaa = findViewById(R.id.zaa);
        Button raa = findViewById(R.id.raa);
        Button waw = findViewById(R.id.waw);
        Button tamarboot = findViewById(R.id.tamarboota);
        Button tha = findViewById(R.id.tha);
        zoay.setOnClickListener(this);
        toay.setOnClickListener(this);
        dhal.setOnClickListener(this);
        dal.setOnClickListener(this);
        zaa.setOnClickListener(this);
        raa.setOnClickListener(this);
        waw.setOnClickListener(this);
        tamarboot.setOnClickListener(this);
        tha.setOnClickListener(this);
        keyValues.put(R.id.zoay, "ظ");
        keyValues.put(R.id.toay, "ط");
        keyValues.put(R.id.dhal, "ذ");
        keyValues.put(R.id.dal, "د");
        keyValues.put(R.id.zaa, "ز");
        keyValues.put(R.id.raa, "ر");
        keyValues.put(R.id.waw, "و");
        keyValues.put(R.id.tamarboota, "ة");
        keyValues.put(R.id.tha, "ث");

    }

    @Override
    public void onClick(View view) {
        //   hideKeyboardSoft();
        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                    case BottomSheetBehavior.STATE_DRAGGING:
                    case BottomSheetBehavior.STATE_SETTLING:
                    case BottomSheetBehavior.STATE_HALF_EXPANDED:
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED: {
                        //       btnBottomSheet.setText("Close Sheet");
                    }
                    break;
                    case BottomSheetBehavior.STATE_COLLAPSED: {
                        //      btnBottomSheet.setText("Expand Sheet");
                    }
                    break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            }
        });
        if (inputConnection == null) {
            String logTag = "Keyboard";
            Log.i(logTag, "Input connection == null");
            return;
        }
        CharSequence currentText = inputConnection.getExtractedText(new ExtractedTextRequest(), 0).text;
        CharSequence beforeCursorText = inputConnection.getTextBeforeCursor(currentText.length(), 0);
        CharSequence afterCursorText = inputConnection.getTextAfterCursor(currentText.length(), 0);
        switch (view.getId()) {
            case R.id.fab:
                toggleBottomSheet();
            case R.id.key_enter:
                CharSequence charSequence = inputConnection.getTextBeforeCursor(currentText.length(), 0);
                if (charSequence.toString().length() == 3) {
                    setInputtext(charSequence.toString());
                    InitSelecton(charSequence.toString());
                }
                break;
            case R.id.key_delete:
                CharSequence selectedText = inputConnection.getSelectedText(0);
                CharSequence charSequences = inputConnection.getTextBeforeCursor(10, 10);
                if (TextUtils.isEmpty(selectedText))
                    inputConnection.deleteSurroundingText(1, 0);
                else
                    inputConnection.commitText("", 1);
                break;
            case R.id.key_AC:
                inputConnection.deleteSurroundingText(beforeCursorText.length(), afterCursorText.length());
                break;
            default:
                inputConnectionCommitText(view);
                break;

        }

    }

    public void toggleBottomSheet() {
        if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            //    btnBottomSheet.setText("Close sheet");
        } else {
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            //    btnBottomSheet.setText("Expand sheet");
        }
    }

    public void setInputConnection(InputConnection ic) {
        inputConnection = ic;
    }

    private void inputConnectionCommitText(View view) {
        String value = keyValues.get(view.getId());
        inputConnection.commitText(value, 1);
    }

    private void InitSelecton(String roots) {
        keyboard.setVisibility(LinearLayout.GONE);
        actv.clearFocus();
        String[] split = roots.split(",");
        String root = split[0];
        tlist = new ListView(SearchKeyBoardAct.this);
        mlist = new ListView(SearchKeyBoardAct.this);
        DatabaseUtils utils = new DatabaseUtils(SearchKeyBoardAct.this);
        Utils util = new Utils(SearchKeyBoardAct.this);
        util.getQuranDictionary();
        launchActivity(root);

    }

    private void launchActivity(String root) {
        Bundle bundle = new Bundle();
        //   Intent intent = new Intent(getActivity(), NounOccuranceAsynKAct.class);
        Intent intent = new Intent(SearchKeyBoardAct.this, SearchResult.class);
        //   getTypedValues();
        bundle.putString(QURAN_VERB_ROOT, root);
        intent.putExtras(bundle);
        //   intent.putExtra(QURAN_VERB_ROOT,vb.getRoot());
        startActivity(intent);
    }

}