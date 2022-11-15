package org.sj.conjugator.CustomKeyboard;

import static com.example.Constant.QURAN_VERB_ROOT;
import static com.example.Constant.QURAN_VERB_WAZAN;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;

import com.example.mushafconsolidated.R;

import org.sj.conjugator.activity.ConjugatorAct;

public class CustomKeyboard extends LinearLayout implements View.OnClickListener {
    private final SparseArray<String> keyValues = new SparseArray<>();
    private final String LogTag = "Keyboard";
    public Context mycontext;
    CustomKeyboard keyboard;
    private Button key1, key2, key3, key4, key5, key6, key7, key8, key9, key0, key00;
    private Button key_delete, key_AC, key_dot, key_enter;
    private Button dhad, suwad, qaf, fa, ghain, ayn, haaa, kha, ha, jeem;
    private Button sheen, seen, ya, ba, lam, alif, ta, nun, meem, kaf;
    private Button zoay, toay, dhal, dal, zaa, raa, waw, tamarboot, tha;
    private RadioGroup formone, formtwo;
    private RadioButton nasara, zaraba, samia, fatha, karuma, hasiba;
    private RadioButton two, three, four, five, six, seven, eight, ten;
    private String inputtext;
    private InputConnection inputConnection;
    private CharSequence charSequence;
    //  private com.sjconjugatortwo.keyboard.KeyBoardInitActivity InitActivity;
    private String radioText;
    private String bab;

    public CustomKeyboard(ConjugatorAct keyBoardInitActivity) {
        super(keyBoardInitActivity);
        mycontext = keyBoardInitActivity;
    }

    public CustomKeyboard(ConjugatorAct context, String s) {
        super(context);
        this.bab = s;
    }

    public CustomKeyboard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomKeyboard(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public String getInputtext() {
        return inputtext;
    }

    public void setInputtext(String inputtext) {
        this.inputtext = inputtext;
    }

    public String getRadioText() {
        return radioText;
    }

    public void setRadioText(String radioText) {
        this.radioText = radioText;
    }

    public CharSequence getCharSequence() {
        return charSequence;
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.round_arabic_keyboard, this, true);
        key_delete = findViewById(R.id.key_delete);
        key_AC = findViewById(R.id.key_AC);
        key_enter = findViewById(R.id.key_enter);
        keyboard = findViewById(R.id.arabic_keyboard);
        /*
        nasara = findViewById(R.id.nasara);
        zaraba = findViewById(R.id.zaraba);
        samia = findViewById(R.id.samia);
        fatha = findViewById(R.id.fatha);
        karuma = findViewById(R.id.karuma);
        hasiba = findViewById(R.id.hasiba);
        two = findViewById(R.id.two);

        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        ten = findViewById(R.id.ten);

*/
        dhad = findViewById(R.id.dhad);
        suwad = findViewById(R.id.suwad);
        qaf = findViewById(R.id.qaf);
        fa = findViewById(R.id.fa);
        ghain = findViewById(R.id.ghain);
        ayn = findViewById(R.id.ayn);
        haaa = findViewById(R.id.haaa);
        kha = findViewById(R.id.kha);
        ha = findViewById(R.id.ha);
        jeem = findViewById(R.id.jeem);
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
        sheen = findViewById(R.id.sheen);
        seen = findViewById(R.id.seen);
        ya = findViewById(R.id.ya);
        ba = findViewById(R.id.ba);
        lam = findViewById(R.id.lam);
        alif = findViewById(R.id.hamza);
        ta = findViewById(R.id.ta);
        nun = findViewById(R.id.nun);
        meem = findViewById(R.id.meem);
        kaf = findViewById(R.id.kaf);
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
        keyValues.put(R.id.hamza, "ا");
        keyValues.put(R.id.ta, "ت");
        keyValues.put(R.id.nun, "ن");
        keyValues.put(R.id.meem, "م");
        keyValues.put(R.id.kaf, "ك");
        zoay = findViewById(R.id.zoay);
        toay = findViewById(R.id.toay);
        dhal = findViewById(R.id.dhal);
        dal = findViewById(R.id.dal);
        zaa = findViewById(R.id.zaa);
        raa = findViewById(R.id.raa);
        waw = findViewById(R.id.waw);
        tamarboot = findViewById(R.id.tamarboota);
        tha = findViewById(R.id.tha);
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
        //    keyValues.put(R.id.key_00, "00");
        //    keyValues.put(R.id.key_dot, ".");
    }

    public Button getKey_enter() {
        return key_enter;
    }

    public void setInputConnection(InputConnection ic) {
        inputConnection = ic;
    }

    private void InitDiaalog(String root) {
        Context applicationContext = ConjugatorAct.getContextOfApplication();
        //   GRadioGroup gr=new GRadioGroup(nasara,zaraba,samia,fatha,karuma,hasiba);
        SharedPreferences sp = applicationContext.getSharedPreferences("key", 0);
        String babs = sp.getString("bab", "");
        Bundle dataBundle = new Bundle();
        dataBundle.putString(QURAN_VERB_WAZAN, getRadioText());
        dataBundle.putString(QURAN_VERB_WAZAN, babs);
        dataBundle.putString(QURAN_VERB_ROOT, root);
        //   QuranVerbConjDialog dialog = new QuranVerbConjDialog(getContext());
        //  dialog.setArguments(dataBundle);
        //   Intent i = new Intent(getContext(), VerbQueryActivity.class);
        //   i.putExtra(QURAN_VERB_ROOT,root);
        //   i.putExtra(QURAN_VERB_FORM,babs);
        //   getContext().startActivity(i);
        //      FragmentActivity activity = (FragmentActivity) getContext();
        //      final FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        //     transaction.add(R.id.frame_container ,dialog,VERSEFRAGMENT);
        //     transaction.commit();
    }

    private void inputConnectionCommitText(View view) {
        String value = keyValues.get(view.getId());
        inputConnection.commitText(value, 1);
    }

    @Override
    public void onClick(View view) {
    }
}
