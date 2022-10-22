
package org.sj.conjugator.activity;


import static com.example.Constant.AYAH_ID;
import static com.example.Constant.CHAPTER;
import static com.example.Constant.QURAN_VERB_ROOT;
import static com.example.Constant.QURAN_VERB_WAZAN;
import static com.example.Constant.SARFKABEER;
import static com.example.Constant.SURAH_ARABIC_NAME;
import static com.example.Constant.SURAH_ID;
import static com.example.Constant.VERBMOOD;
import static com.example.Constant.VERBTYPE;


import android.content.Context;
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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;

import com.example.mushafconsolidated.Activity.QuranGrammarAct;
import com.example.utility.CorpusUtilityorig;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.sj.conjugator.fragments.SettingsFragmentVerb;
import org.sj.conjugator.utilities.SharedPref;

import com.example.mushafconsolidated.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import database.DatabaseUtils;
import database.entity.Mazeed;
import database.entity.MujarradVerbs;
import ru.dimorinny.floatingtextbutton.FloatingTextButton;


public class ConjugatorAct extends BaseActivity implements View.OnClickListener {
    Button quranbtn,
            settingbtn;
  public static Context contextOfApplication;
    FloatingActionButton floatingActionButton;
    RelativeLayout layoutBottomSheet;
    BottomSheetBehavior sheetBehavior;

    private EditText editTextAuto;
  private EditText editText;

  private RadioGroup verbmood;
  private RadioButton indicative;
    private RadioButton subjunctive;


  private String radioText;


  private String inputtext;

  private View keyboard;
  private String hint;
  private final SparseArray<String> keyValues = new SparseArray<>();
  private InputConnection inputConnection;

  ListView tlist;
  ListView mlist;
  private ArrayList<Mazeed> mazeedVerb = new ArrayList<>();
  Chip nasara, zaraba, samia, fataha, karuma, haseeba;
  Chip tafeel, mufala, ifal, tafaul, tafaaul, infala, iftiala, istifala;
 MaterialButton mujarradbtn,mazeedbtn;

  public void setIsautocomplete(boolean isautocomplete) {
    this.isautocomplete = isautocomplete;
  }

  boolean isSarfKabeed;

  private boolean isautocomplete;


  ArrayList<MujarradVerbs> mujarradVerbs = new ArrayList<>();

  public void setSarfKabeed(boolean sarfKabeed) {
    isSarfKabeed = sarfKabeed;
  }

    public static Context getContextOfApplication() {
    return contextOfApplication;
  }


    public String getInputtext() {
    return inputtext;
  }

  public void setInputtext(String inputtext) {
    this.inputtext = inputtext;
  }


    @Override
    public void onBackPressed() {
        super.onBackPressed();


    }

    @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);









      setContentView(R.layout.conjugator_key_activity_autocomplete);

    KeyboardUtil.hideKeyboard(ConjugatorAct.this);
    keyboard = findViewById(R.id.arabic_keyboard);
   FloatingTextButton callButton = findViewById(R.id.action_buttons);

    callButton.setOnClickListener(view -> {
      ConjugatorAct.super.finish();
        super.onBackPressed();
      /*
        HashMap<String, String> map = CorpusUtilityorig.getpreferences();
        Bundle dataBundle=new Bundle();
        map.get(SURAH_ARABIC_NAME);
        dataBundle.putString(SURAH_ARABIC_NAME,map.get(SURAH_ARABIC_NAME));
        dataBundle.putInt(CHAPTER, Integer.parseInt(map.get(CHAPTER)));
        dataBundle.putInt(AYAH_ID, Integer.parseInt(map.get(AYAH_ID)));

            Intent intent = new Intent(ConjugatorAct.this, QuranGrammarAct.class);
        intent.putExtras(dataBundle);
        finish();
        startActivity(intent);
       */

     //  Snackbar.make(viewById, "Call button clicked", Snackbar.LENGTH_SHORT).show();
    });



    //    hideKeyboardSoft();


    contextOfApplication = getApplicationContext();


    InputConnection ic;


      SetUpAutoComplete();
      ic = editTextAuto.onCreateInputConnection(new EditorInfo());




    // InputConnection ic = editTextAuto.onCreateInputConnection(new EditorInfo());
    setInputConnection(ic);
    init();
    // kb. getCharSequence();


  }

// --Commented out by Inspection START (17/12/21, 7:55 AM):
//  private void hideKeyboardSoft() {
//    InputMethodManager imm = (InputMethodManager) getBaseContext()
//          .getSystemService(INPUT_METHOD_SERVICE);
//    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
//    final ComponentName activity = getCallingActivity();
//    getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
//  }
// --Commented out by Inspection STOP (17/12/21, 7:55 AM)

  private void SetUpEditText() {
    KeyboardUtil.hideKeyboard(ConjugatorAct.this);
    String[] root;
    DatabaseUtils util = new DatabaseUtils(ConjugatorAct.this);
    ArrayList<MujarradVerbs> verbAll = util.getMujarradAall();
    int size = verbAll.size();
    root = new String[size];
    int i = 0;
    for (MujarradVerbs entity : verbAll) {
      String roots = entity.getRoot();

      root[i++] = roots;
    }




    keyboard = findViewById(R.id.arabic_keyboard);

    editText.setTextIsSelectable(true);
    editText.setOnFocusChangeListener((view, hasFocus) -> {
      if (hasFocus) {
          clearParameters();
        keyboard.setVisibility(LinearLayout.VISIBLE);
        if (tlist != null)
          tlist.setAdapter(null);
        if (mlist != null)
          mlist.setAdapter(null);

      }  //   keyboard.setVisibility(LinearLayout.GONE);

    });

  }

  private void SetUpAutoComplete() {
    KeyboardUtil.hideKeyboard(ConjugatorAct.this);

    String[] root;
    DatabaseUtils util = new DatabaseUtils(ConjugatorAct.this);
    ArrayList<MujarradVerbs> verbAll = util.getMujarradAall();


    int size = verbAll.size();
    root = new String[size];
    int i = 0;
    for (MujarradVerbs entity : verbAll) {
      String roots = entity.getRoot();


      root[i++] = roots;
    }

    HashSet h = new HashSet(Arrays.asList(root));
    List aList2 = new ArrayList(h);

    ArrayAdapter<String> adapter = new ArrayAdapter<String>
          (this, R.layout.dropdown_item_list, aList2);

    //       ArrayAdapter<String> adapter = new ArrayAdapter<String>
    //          (this, R.layout.dropdown_item_list, root);


    //Getting the instance of AutoCompleteTextView
    AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
    int sizes = 1300;

    actv.setDropDownHeight(sizes);

    actv.setThreshold(1);//will start working from first character
    actv.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
    actv.setTextColor(Color.RED);
    //   actv.setTextSize((float) 50.00);
    editTextAuto = findViewById(R.id.autoCompleteTextView);


    actv.setRawInputType(InputType.TYPE_CLASS_TEXT);
    actv.setTextIsSelectable(true);
    //   KeyboardUtil.hideKeyboard(this);
    actv.setShowSoftInputOnFocus(false);
    actv.setOnFocusChangeListener((view, hasFocus) -> {
      if (hasFocus) {
        keyboard.setVisibility(LinearLayout.VISIBLE);
        if (tlist != null)
          tlist.setAdapter(null);
        if (mlist != null)
          mlist.setAdapter(null);

      }  //   keyboard.setVisibility(LinearLayout.GONE);

    });

  }


  private void init() {

      quranbtn=findViewById(R.id.qurangrammar);
      settingbtn=findViewById(R.id.conjugatorsetting);
     layoutBottomSheet = findViewById(R.id.bottom_sheet);
    sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);
      floatingActionButton = findViewById(R.id.fab);
    mujarradbtn=findViewById(R.id.mujarradbtn);
    mazeedbtn=findViewById(R.id.mazeedbtn);
    nasara = findViewById(R.id.nasara);
    zaraba = findViewById(R.id.zaraba);

    samia = findViewById(R.id.samia);
    fataha = findViewById(R.id.fataha);
    karuma = findViewById(R.id.karuma);
    haseeba = findViewById(R.id.hasiba);


    tafeel = findViewById(R.id.tafeel);
    mufala = findViewById(R.id.mufala);

    ifal = findViewById(R.id.ifal);
    tafaul = findViewById(R.id.tafaul);
    tafaaul = findViewById(R.id.tafaaaul);
    infala = findViewById(R.id.infala);

    iftiala = findViewById(R.id.iftiala);
    istifala = findViewById(R.id.istifala);


    verbmood = findViewById(R.id.verbcase);
    indicative = findViewById(R.id.rdindicative);
    subjunctive = findViewById(R.id.rdsubjunctive);
      RadioButton jussive = findViewById(R.id.rdjussive);
      RadioButton emphasized = findViewById(R.id.emphasized);
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

    //     GRadioGroup gr = new GRadioGroup(nasara,zaraba,samia,fatha,karuma,hasiba,two,three,four,five,six,seven,eight,ten);
    quranbtn.setOnClickListener(this);
    settingbtn.setOnClickListener(this);
      floatingActionButton.setOnClickListener(this);
mujarradbtn.setOnClickListener(this);
 mazeedbtn.setOnClickListener(this);
    nasara.setOnClickListener(this);
    zaraba.setOnClickListener(this);
    samia.setOnClickListener(this);
    fataha.setOnClickListener(this);
    karuma.setOnClickListener(this);
    haseeba.setOnClickListener(this);

    tafeel.setOnClickListener(this);
    tafaul.setOnClickListener(this);
    tafaaul.setOnClickListener(this);
    mufala.setOnClickListener(this);
    infala.setOnClickListener(this);
    istifala.setOnClickListener(this);
    iftiala.setOnClickListener(this);
    ifal.setOnClickListener(this);



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
      clearParameters();

  }

    private void clearParameters() {
        nasara.setVisibility(View.GONE);
        zaraba.setVisibility(View.GONE);
        fataha.setVisibility(View.GONE);
        samia.setVisibility(View.GONE);
        karuma.setVisibility(View.GONE);
        haseeba.setVisibility(View.GONE);
        ifal.setVisibility(View.GONE);
        tafeel.setVisibility(View.GONE);
        tafaul.setVisibility(View.GONE);
        tafaaul.setVisibility(View.GONE);
        infala.setVisibility(View.GONE);
        iftiala.setVisibility(View.GONE);
        istifala.setVisibility(View.GONE);
        mufala.setVisibility(View.GONE);
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
        case R.id.conjugatorsetting:


            SettingsFragmentVerb fragment = new SettingsFragmentVerb();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.replace(R.id.frame_container, fragment);
            transaction.addToBackStack("setting");
            transaction.commit();

            break;
        case R.id.qurangrammar:


            Intent intent = new Intent(ConjugatorAct.this, QuranGrammarAct.class);

            finish();
            startActivity(intent);
            break;
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
      case R.id.tafeel:

        getTypedValues();

        //   rivate void InitDiaalog(String root, String wazan, String verbtype) {
        InitDiaalog(mazeedVerb.get(0).getRoot(),"2","mazeed");
        break;
      case R.id.mujarradbtn:



          Bundle dataBundle = new Bundle();
          dataBundle.putString(VERBTYPE, "mujarrad");
          Intent intents = new Intent(ConjugatorAct.this, SarfSagheerActivity.class);
          intents.putExtras(dataBundle);
          finish();
          startActivity(intents);

        break;
        case R.id.mazeedbtn:



            Bundle mdataBundle = new Bundle();
            mdataBundle.putString(VERBTYPE, "mazeed");
            Intent mintent = new Intent(ConjugatorAct.this, SarfSagheerActivity.class);
            mintent.putExtras(mdataBundle);
            finish();
            startActivity(mintent);

            break;
      case R.id.mufala:

        getTypedValues();
        InitDiaalog(mazeedVerb.get(0).getRoot(),"3","mazeed");
        break;
      case R.id.ifal:

        getTypedValues();
        InitDiaalog(mazeedVerb.get(0).getRoot(),"1","mazeed");
        break;
      case R.id.tafaul:
        getTypedValues();
        InitDiaalog(mazeedVerb.get(0).getRoot(),"7","mazeed");
        break;
      case R.id.tafaaaul:
        getTypedValues();
        InitDiaalog(mazeedVerb.get(0).getRoot(),"8","mazeed");
        break;
      case R.id.infala:
        getTypedValues();
        InitDiaalog(mazeedVerb.get(0).getRoot(),"4","mazeed");
        break;
      case R.id.iftiala:

        getTypedValues();
        InitDiaalog(mazeedVerb.get(0).getRoot(),"5","mazeed");
          break;
      case R.id.istifala:

        getTypedValues();
        //   rivate void InitDiaalog(String root, String wazan, String verbtype) {
        InitDiaalog(mazeedVerb.get(0).getRoot(),"9","mazeed");
        break;
      case R.id.nasara:

        getTypedValues();
        InitDiaalog(mujarradVerbs.get(0).getRoot(),"1","mujarrad");
        break;
      case R.id.zaraba:

        getTypedValues();
        InitDiaalog(mujarradVerbs.get(0).getRoot(),"2","mujarrad");
        break;
      case R.id.samia:

        getTypedValues();
        InitDiaalog(mujarradVerbs.get(0).getRoot(),"4","mujarrad");
        break;
      case R.id.fataha:
        getTypedValues();
        InitDiaalog(mujarradVerbs.get(0).getRoot(),"3","mujarrad");
        break;
      case R.id.karuma:
        getTypedValues();
        InitDiaalog(mujarradVerbs.get(0).getRoot(),"5","mujarrad");
        break;
      case R.id.hasiba:
        getTypedValues();
        InitDiaalog(mujarradVerbs.get(0).getRoot(),"6","mujarrad");
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

    private void getTypedValues() {
    CharSequence charSequence;
    CharSequence beforeCursorText;
    CharSequence afterCursorText;
    CharSequence currentText;
    currentText = inputConnection.getExtractedText(new ExtractedTextRequest(), 0).text;
    beforeCursorText = inputConnection.getTextBeforeCursor(currentText.length(), 0);
    afterCursorText = inputConnection.getTextAfterCursor(currentText.length(), 0);
    // inputConnectionCommitText(view);
    charSequence = inputConnection.getTextBeforeCursor(currentText.length(), 0);


    if (charSequence.toString().length() == 3) {
      setInputtext(charSequence.toString());
      InitSelecton(charSequence.toString());
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

      editTextAuto.clearFocus();

    String[] split = roots.split(",");
    String root = split[0];
    SharedPref pref = new SharedPref(this);


    tlist = new ListView(ConjugatorAct.this);
    mlist = new ListView(ConjugatorAct.this);
    DatabaseUtils utils = new DatabaseUtils(ConjugatorAct.this);
    mujarradVerbs = utils.getMujarradVerbs(root);



    for (MujarradVerbs s : mujarradVerbs) {
        switch (s.getBab()) {
            case "1":
                nasara.setText(s.getBabname());
                nasara.setEnabled(true);
                nasara.setVisibility(View.VISIBLE);

                break;
            case "2":
                zaraba.setVisibility(View.VISIBLE);

                zaraba.setEnabled(true);
                zaraba.setText(s.getBabname());
                break;
            case "3":
                fataha.setVisibility(View.VISIBLE);

                fataha.setEnabled(true);
                fataha.setText(s.getBabname());
                break;
            case "4":
                samia.setVisibility(View.VISIBLE);
                samia.setEnabled(true);
                samia.setText(s.getBabname());
                break;
            case "5":
                karuma.setVisibility(View.VISIBLE);

                karuma.setEnabled(true);
                karuma.setText(s.getBabname());
                break;
            case "6":
                haseeba.setVisibility(View.VISIBLE);
                haseeba.setEnabled(true);
                haseeba.setText(s.getBabname());
                break;
        }

    }

    mazeedVerb = utils.getMazeedRoot(root);

    for (Mazeed s : mazeedVerb) {
        switch (s.getForm()) {
            case "1":
                ifal.setText(s.getBabname());
                ifal.setEnabled(true);
                ifal.setVisibility(View.VISIBLE);
                break;
            case "2":
                tafeel.setEnabled(true);
                tafeel.setText(s.getBabname());
                tafeel.setVisibility(View.VISIBLE);
                break;
            case "3":
                mufala.setEnabled(true);
                mufala.setText(s.getBabname());
                mufala.setVisibility(View.VISIBLE);
                break;
            case "4":
                infala.setEnabled(true);
                infala.setText(s.getBabname());
                infala.setVisibility(View.VISIBLE);
                break;
            case "5":
                iftiala.setEnabled(true);
                iftiala.setText(s.getBabname());
                iftiala.setVisibility(View.VISIBLE);
                break;
            case "9":
                istifala.setEnabled(true);
                istifala.setText(s.getBabname());
                istifala.setVisibility(View.VISIBLE);
                break;
            case "7":
                tafaul.setEnabled(true);
                tafaul.setText(s.getBabname());
                tafaul.setVisibility(View.VISIBLE);
                break;
            case "8":
                tafaaul.setEnabled(true);
                tafaaul.setText(s.getBabname());
                tafaaul.setVisibility(View.VISIBLE);
                break;
        }

    }


    ArrayList<String> thulathia = new ArrayList<>();
    ArrayList<String> mazeed = new ArrayList<>();

    for (MujarradVerbs entity : mujarradVerbs) {
      thulathia.add(entity.getBabname());

    }
    for (Mazeed dict : mazeedVerb) {
      mazeed.add(dict.getBabname() + "," + dict.getForm());
    }
    if (thulathia.size() == 0 & mazeed.size() == 0) {

        editTextAuto.setText(R.string.notfound);

    }





  }

  private void InitDiaalog(String root, String wazan, String verbtype) {

    Bundle dataBundle = new Bundle();

    final RadioButton selectedRadioButton = (RadioButton) findViewById(verbmood.getCheckedRadioButtonId());
    //get RadioButton text
    String selected = selectedRadioButton.getText().toString();
    // display it as Toast to the user

    final boolean checked = indicative.isChecked();
    final boolean accusativeChecked = subjunctive.isChecked();
      switch (selected) {
          case "Indicative":
              dataBundle.putString(VERBMOOD, "Indicative");
              break;
          case "Subjunctive":

              dataBundle.putString(VERBMOOD, "Subjunctive");
              break;
          case "Jussive":

              dataBundle.putString(VERBMOOD, "Jussive");
              break;
          case "Emphasized":

              dataBundle.putString(VERBMOOD, "Emphasized");
              break;
      }
    //  ninitThulathiAdapter(root);


      dataBundle.putString(QURAN_VERB_WAZAN, wazan);
    dataBundle.putString(QURAN_VERB_ROOT, root);
    dataBundle.putString(VERBTYPE, verbtype);
    dataBundle.putBoolean(SARFKABEER, isSarfKabeed);


    setSarfKabeed(false);
    Intent intent = new Intent(ConjugatorAct.this, ConjugatorTabsActivity.class);
    intent.putExtras(dataBundle);
    startActivity(intent);


  }


}