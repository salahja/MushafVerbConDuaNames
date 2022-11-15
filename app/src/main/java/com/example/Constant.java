package com.example;

import static android.graphics.Color.CYAN;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.graphics.Color.YELLOW;

import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;

import androidx.core.content.ContextCompat;

import com.example.mushafconsolidated.R;
import com.example.utility.QuranGrammarApplication;

import java.util.HashMap;
import java.util.Map;

public class Constant {
    public final static String BIHIHEADER = "مفعول  به".concat("\n");
    public final static String HALHEADER = "حالية/حال/في محل".concat("\n");
    public final static String AJLIHIHEADER = "مفعول لأجله ".concat("\n");
    public final static String MUTLAQHEADER = "فعولا  مطلق".concat("\n");
    public final static String BADALHEADER = "بدل".concat("\n");
    public final static String TAMEEZHEADER = "تمييز".concat("\n");
    public final static String BIHI = "مفعول  به";
    public final static String HAL = "حالية/حال/في محل";
    public final static String AJLIHI = "مفعول لأجله ";
    public final static String MUTLAQ = "فعولا  مطلق";
    public final static String BADAL = "بدل";
    public final static String TAMEEZ = "تمييز";
    public final static String FATHA = "a";
    public final static String KASARA = "i";
    public final static String DHUMMA = "u";
    public final static String RA = "r";
    public final static String FATHATAIN = "F";
    public final static String KASARATAIN = "K";
    public final static String DHUMMATAIN = "N";
    public final static String ALIF = "A";
    public final static String MADDAH = "ٓ ";
    public final static String SUKUN = "o";
    public final static String MEEM = "m";
    public final static String MUTTADI = "م";
    public final static String LAZIM = "ل";
    public final static String MUTTADILAZIM = "ك";
    public final static String LALIFMAKSURA = "ى";
    public final static String ALIFHAMZABELOW = "<";
    public final static String ALIFHAMZAABOVE = ">";
    public final static String ALIFMAKSURA = "Y";
    public final static String HAMZA = "'";
    public final static String YAHAMZAABOVE = "}";
    public final static String SMALLYA = ".";
    public final static String WAWHAMZAABOVE = "&";
    public final static String WAW = "w";
    public final static String LAM = "l";
    public final static String TA = "t";
    public final static String MEEMWITHFATHA = "m" + "a";
    public final static String MEEMWITHKESARA = "m" + "i";
    public final static String TAAMARBOOTA = "p";
    public final static String NUUN = "n";
    public final static String NOON = "ن";
    public static final String SHADDA = "~";
    public static final String YU = "y" + "u";
    public static final String MU = "m" + "u";
    public static final String YA = "y";
    public static final String SEEN = "s";
    public static final String MADDA = "ٓ ";
    public static final String COMMA = ",";
    public static final String HAMZAABOVE = "#";
    public final static String DAL = "d";
    public final static String ZAAL = "*";
    public final static String ZAIN = "z";
    public final static String SAD = "S";
    public final static String DHAD = "D";
    public final static String TOA = "T";
    public final static String ZOA = "Z";
    public final static String ALIFKHANJAR = "`";
    public static final String PASTHUMA = "A";
    public static final String RELATIVE = "rel";
    public static final String CONDITIONAL = "cond";
    public static final String DEMONSTRATIVE = "dem";
    public static final String PREPOSITION = "prep";
    public static final String ACCUSATIVE = "accusative";
    public static final String VERBMOOD = "verbcase";
    public static final String INDICATIVE = "Indicative";
    public static final String VERBTYPE = "verbtype";
    public static final String NOUNCASE = "nouncase";
    public static final String ISPARTICPLE = "particple";
    public static final String IMPERATIVE = "imperative";
    public static final String QURAN_VERB_WAZAN = "form";
    public static final String SARFKABEER = "sarfkabeer";
    public static final String QURAN_VERB_ROOT = "root";
    public static final String QURAN_VOCUBALORY_ROOT = "vroot";
    public static final String MUJARRADVERBTAG = "thulathiverblist";
    public static final String TAFEEL = "تَفْعِيل-II";
    public static final String MUFAALA = "مُفَاعَلَة-III";
    public static final String IFAL = "إِفْعَال-IV";
    public static final String TAFAUL = "تَفَعُّل-V";
    public static final String TAFAAUL = "تَفَاعُل-VI";
    public static final String INFAAL = "اِنْفِعَال-VII";
    public static final String IFTAALA = "اِفْتِعَال-VIII";
    public static final String ISTAFALA = "اِسْتِفْعَال-X1";
    public static final String MITHAL = "Mithal";
    public static final String AJFAW = "Ajwaf";
    public static final String MUDHAAF = "Mudhaf";
    public static final String NAQIS = "Naqis";
    public static final String MAQROON = "Lafeef Maqroon";
    public static final String MAFROOQ = "Lafeef Mafrooq";
    public static final String MAHMOOZ = "Mahmooz";
    public final static String BNASARA = "نصر"; //   A-U // NASRA-YANSURU
    public final static String BZARABA = "ضرب";  //   A-I // ZARABA-YASZRIBU
    public final static String BFATAH = "فتح";  //  A-A // FATHA-YAFTAHU
    public final static String BSAMIA = "سمح";   //  I-A  //SAMIA-YASMAHU
    public final static String BKARUMU = "كرم";   //   U-U  //KARUMA-YAKRUMU
    public final static String BHASIBA = "حسب";    //  I-I  //HASIBA-YAHSIU
    public final static String NASARA = "nasara"; //   A-U // NASRA-YANSURU
    public final static String ZARABA = "zaraba";  //   A-I // ZARABA-YASZRIBU
    public final static String FATAHA = "fatha";  //  A-A // FATHA-YAFTAHU
    public final static String SAMIA = "samia";   //  I-A  //SAMIA-YASMAHU
    public final static String KARUMA = "karuma";   //   U-U  //KARUMA-YAKRUMU
    public final static String HASIBA = "hasiba";    //  I-I  //HASIBA-YAHSIU
    public final static String SARFKABEERWEAKNESS = "skverb";
    public static final String ASALEM = "سالم";
    public static final String AMAHMOOZFA = " المهموز ف";
    public static final String AMAHMOOZAYN = "  المهموز ع";
    public static final String AMAHMOOZLAM = " المهموز ل";
    public static final String AMITHALWAWI = "ميثال  واوي";
    public static final String AMITHALYAYI = "ميثال   يايئ";
    public static final String AAJWAFWAWI = " الأَجوَف   واوي";
    public static final String AAJWAFYAYI = "الأَجوَف    يايئ";
    public static final String ANAQISWAWI = "الناقص  واوي";
    public static final String ANAQISYAYI = "الناقص    يايئ";
    public static final String ALAFEEFMAFROOQ = "لقيق مفروق";//F AND L ARE VOWELS
    public static final String ALAFEEFMAQROON = "لقيق مقرون";//AYN AND LA ARE VOWELS;
    public static final String AMUDHAF = "مضاعف"; //AYN AND LAM ARE SAME
    public static final String SURAHFRAGTAG = "surah";
    public static final String BOOKMARKTAG = "bookmarktag";
    public static final String MUFRADATFRAGTAG = "mufrad";
    public static final String READINGSURAHPART = "readingsurahpart";
    public static final String VERSESCOUNT = "versescount";
    public static final String RUKUCOUNT = "rukucount";
    public static final String WBW = "wbw";
    public static final String AYAHNUMBER = "aya";
    public static final String SURAH_ARABIC_NAME = "arabicname";
    public static final String CHAPTER = "chapter";
    public static final String CHAPTERORPART = "chapterorpart";
    public static final String MAKKI_MADANI = "makkimadani";
    public static final String WORDNUMBER = "wordnumber";
    public static final String AYAH_ID = "ayah_id";
    public static final String SURAH_ID = "surah_id";
    public static final String RECKT = "reckt";
    public static final String OVAL = "oval";
    public static final String ARC = "arc";
    //verb
//AGFINST
    public static final String DATABASE_URL = "http://127.0.0.1/drupal/sites/default/files/2021-04/QuranDatabase.db.zip";
    public static final String DATABAWSE_FILENAME = "QuranDatabase.db.zip";
    public static final int PURPLE = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.purple);
    public static final int PeachPuff = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.PeachPuff);
    public static final int BBLUE = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.RoyalBlue);
    public static final int BCYAN = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.cyan);
    public static final int BYELLOW = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.yellow);
    public static final int BWHITE = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.white);
    public static final int TEAL = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.teal300);
    public static final int GOLD = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.Gold);
    public static final int DARKGOLDENROD = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.DarkGoldenrod);
    public static final int WMIDNIHTBLUE = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.midnightblue);
    public static final int WBURNTUMBER = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.burntamber);
    public static final int GREENDARK = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.DarkGreen);
    public static final int WHOTPINK = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.hotred);
    public static final int FORESTGREEN = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.sforestgreen);
    public static final int LIME = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.Lime);
    public static final int KASHMIRIGREEN = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.kashmirigreen);
    public static final int MIDNIGHTBLUE = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.midnightblue);
    public static final int INDIGO = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.indigo);
    public static final int ORANGE400 = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.orange400);
    public static final int DARKMAGENTA = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.DarkMagenta);
    public static final int TEAL400 = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.teal400);
    public static final int ORANGE100 = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.orange100);
    public static final int LIGHTPINK = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.LightPink);
    public static final int CYANLIGHT = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.cyan_light);
    public static final int CYANLIGHTEST = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.cyan_lightest);
    public static final int ORANGERED = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.OrangeRed);
    public static final int GREENYELLOW = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.GreenYellow);
    public static final int HOTPINK = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.HotPink);
    public static final int SALMON = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.Salmon);
    public static final int BROWN = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.LightSlateGray);
    public static final int MEDIUMSLATEBLUE = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.MediumSlateBlue);
    public static final int DarkTurquoise = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.Lavender);
    public static final int DeepPink = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.DeepPink);
    public static final int Fuchsia = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.Fuchsia);
    public static final int pinkshade = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.pinkshade);
    public static final int Magenta = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.Magenta);
    public static final int prussianblue = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.prussianblue);
    public static final int deepburnsienna = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.deepburnsienna);
    public static final Map<String, String> mazeedsignificance;
    //lgiht
    public static ForegroundColorSpan nounspanLight = new ForegroundColorSpan(BBLUE);
    public static ForegroundColorSpan verbspanLight = new ForegroundColorSpan(GREENDARK);
    public static ForegroundColorSpan verbalnounspanLight = new ForegroundColorSpan(GREENDARK);
    public static ForegroundColorSpan adjectivespanLight = new ForegroundColorSpan(PURPLE);
    public static ForegroundColorSpan propernounspanLight = new ForegroundColorSpan(prussianblue);
    public static ForegroundColorSpan particlespanLight = new ForegroundColorSpan(BBLUE);
    public static ForegroundColorSpan prepositionspanLight = new ForegroundColorSpan(ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.rustred));
    public static ForegroundColorSpan resumtionspanLight = new ForegroundColorSpan(HOTPINK);
    public static ForegroundColorSpan pronounspanLight = new ForegroundColorSpan(ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.steelemetal));
    public static ForegroundColorSpan attachedpronounspanLight = new ForegroundColorSpan(ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.steelemetal));
    public static ForegroundColorSpan determinerspanLight = new ForegroundColorSpan(ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.steelemetal));
    public static ForegroundColorSpan timeadverbspanLight = new ForegroundColorSpan(BROWN);
    public static ForegroundColorSpan locationadverspanLight = new ForegroundColorSpan(ORANGE400);
    public static ForegroundColorSpan demonstrativespanLight = new ForegroundColorSpan(BROWN);
    public static ForegroundColorSpan relativespanLight = new ForegroundColorSpan(DARKGOLDENROD);
    public static ForegroundColorSpan nasabspanLight = new ForegroundColorSpan(HOTPINK);
    public static ForegroundColorSpan negativespanLight = new ForegroundColorSpan(RED);
    public static ForegroundColorSpan eqspanlight = new ForegroundColorSpan(DeepPink);
    public static ForegroundColorSpan restrictivespanLight = new ForegroundColorSpan(WHOTPINK);
    public static ForegroundColorSpan prohibitionspanLight = new ForegroundColorSpan(RED);
    public static ForegroundColorSpan preventivespanLight = new ForegroundColorSpan(ORANGERED);
    public static ForegroundColorSpan inceptivepartile = new ForegroundColorSpan(WHOTPINK);
    public static ForegroundColorSpan ammendedparticle = new ForegroundColorSpan(WHOTPINK);
    public static ForegroundColorSpan supplementspanLight = new ForegroundColorSpan(WHOTPINK);
    public static BackgroundColorSpan sifaspansLight = new BackgroundColorSpan(WBURNTUMBER);
    public static BackgroundColorSpan sifaspanLight = new BackgroundColorSpan(CYANLIGHTEST);
    public static BackgroundColorSpan mudhafspanLight = new BackgroundColorSpan(CYANLIGHT);
    public static BackgroundColorSpan mudhafspansLight = new BackgroundColorSpan(MIDNIGHTBLUE);
    public static ForegroundColorSpan harfinnaspanLight = new ForegroundColorSpan(GREEN);
    public static ForegroundColorSpan harfismspanLight = new ForegroundColorSpan(BCYAN);
    public static ForegroundColorSpan harfkhabarspanLight = new ForegroundColorSpan(YELLOW);
    public static ForegroundColorSpan harfshartspanLight = new ForegroundColorSpan(PeachPuff);
    public static ForegroundColorSpan shartspanLight = new ForegroundColorSpan(GREENDARK);
    public static ForegroundColorSpan jawabshartspanLight = new ForegroundColorSpan(CYAN);
    public static ForegroundColorSpan interrogativespanLight = new ForegroundColorSpan(RED);
    public static ForegroundColorSpan emphspanLight = new ForegroundColorSpan(WHOTPINK);
    public static ForegroundColorSpan lamtaleelspandLight = new ForegroundColorSpan(SALMON);
    public static ForegroundColorSpan masdariaspanLight = new ForegroundColorSpan(GREENDARK);
    public static ForegroundColorSpan harfsababiaspanLight = new ForegroundColorSpan(DARKMAGENTA);
    public static ForegroundColorSpan halspanLight = new ForegroundColorSpan(DARKMAGENTA);
    public static ForegroundColorSpan resultparticlespanLight = new ForegroundColorSpan(LIGHTPINK);
    public static ForegroundColorSpan lamimpvspanLight = new ForegroundColorSpan(ORANGE100);
    public static ForegroundColorSpan answerspanLight = new ForegroundColorSpan(BROWN);
    public static ForegroundColorSpan surprisespanLight = new ForegroundColorSpan(DarkTurquoise);
    public static ForegroundColorSpan certainityspanLight = new ForegroundColorSpan(DeepPink);
    //dark
    public static ForegroundColorSpan timeadverbspanDark = new ForegroundColorSpan(CYANLIGHT);
    public static ForegroundColorSpan locationadverspanDark = new ForegroundColorSpan(CYANLIGHTEST);
    public static final Map<String, String> spanhash = new HashMap<String, String>() {
        {
            put("RSLT", "resultspan");
            put("P", "prepositionspan");
            put("N", "nounspan");
            put("T", String.valueOf(timeadverbspanDark));
            put("LOC", String.valueOf(locationadverspanDark));
            put("N", "nounspan");
        }

    };
    public static ForegroundColorSpan verbalnounspanDark = new ForegroundColorSpan(WHOTPINK);
    public static ForegroundColorSpan nounspanDark = new ForegroundColorSpan(YELLOW);
    public static BackgroundColorSpan sifaspansDark = new BackgroundColorSpan(WBURNTUMBER);
    public static BackgroundColorSpan sifaspanDark = new BackgroundColorSpan(CYANLIGHTEST);
    //   public static BackgroundColorSpan mudhafspanDark = new BackgroundColorSpan(CYANLIGHT);
    public static BackgroundColorSpan mudhafspansDark = new BackgroundColorSpan(MIDNIGHTBLUE);
    public static ForegroundColorSpan harfinnaspanDark = new ForegroundColorSpan(GREEN);
    public static ForegroundColorSpan harfismspanDark = new ForegroundColorSpan(BCYAN);
    public static ForegroundColorSpan harfkhabarspanDark = new ForegroundColorSpan(YELLOW);
    public static ForegroundColorSpan harfshartspanDark = new ForegroundColorSpan(PURPLE);
    public static ForegroundColorSpan shartspanDark = new ForegroundColorSpan(GREENDARK);
    public static ForegroundColorSpan jawabshartspanDark = new ForegroundColorSpan(CYAN);
    public static ForegroundColorSpan propernounspanDark = new ForegroundColorSpan(GOLD);
    public static ForegroundColorSpan verbspanDark = new ForegroundColorSpan(CYAN);
    public static ForegroundColorSpan adjectivespanDark = new ForegroundColorSpan(GREENYELLOW);
    public static ForegroundColorSpan attachedpronounspanDark = new ForegroundColorSpan(ORANGE400);
    public static ForegroundColorSpan relativespanDark = new ForegroundColorSpan(DARKGOLDENROD);
    public static ForegroundColorSpan demonstrativespanDark = new ForegroundColorSpan(TEAL);
    public static ForegroundColorSpan pronounspanDark = new ForegroundColorSpan(YELLOW);
    public static ForegroundColorSpan particlespanDark = new ForegroundColorSpan(WHOTPINK);
    public static ForegroundColorSpan interrogativespanDark = new ForegroundColorSpan(RED);
    public static ForegroundColorSpan determinerspanDark = new ForegroundColorSpan(ORANGE100);
    public static ForegroundColorSpan emphspanDark = new ForegroundColorSpan(WHOTPINK);
    public static ForegroundColorSpan lamtaleelspandDark = new ForegroundColorSpan(SALMON);
    public static ForegroundColorSpan masdariaspanDark = new ForegroundColorSpan(LIME);
    public static ForegroundColorSpan harfsababiaspanDark = new ForegroundColorSpan(ORANGE400);
    public static ForegroundColorSpan halspanDark = new ForegroundColorSpan(DARKMAGENTA);
    public static ForegroundColorSpan nasabspanDark = new ForegroundColorSpan(TEAL400);
    public static ForegroundColorSpan resultparticlespanDark = new ForegroundColorSpan(LIGHTPINK);
    public static ForegroundColorSpan negativespanDark = new ForegroundColorSpan(Fuchsia);
    public static ForegroundColorSpan prohibitionspanDark = new ForegroundColorSpan(ORANGERED);
    public static ForegroundColorSpan prepositionspanDark = new ForegroundColorSpan(GREENYELLOW);
    public static ForegroundColorSpan resumtionspanDark = new ForegroundColorSpan(HOTPINK);
    public static ForegroundColorSpan lamimpvspanDark = new ForegroundColorSpan(ORANGE100);
    public static ForegroundColorSpan answerspanDark = new ForegroundColorSpan(BROWN);
    public static ForegroundColorSpan supplementspoanDark = new ForegroundColorSpan(MEDIUMSLATEBLUE);
    public static ForegroundColorSpan surprisespanDark = new ForegroundColorSpan(DarkTurquoise);
    public static ForegroundColorSpan restrictivespanDark = new ForegroundColorSpan(Fuchsia);
    public static ForegroundColorSpan certainityspanDark = new ForegroundColorSpan(DeepPink);
    public static String htmltwo = "<!DOCTYPE html> <html> <head>   <style>      \n" +
            "             text-align: left;}  \n" +
            "             h2{font-style: italic;  \n" +
            "              font-size: 30px;  \n" +
            "              color: #f08080;}  \n" +
            "            p{font-size: 20px;}  \n" +
            "      </style>  \n" +
            "    </head>  ";
    public static String html = "<!DOCTYPE html> <html> <head>   <style>                body{background-color:lavender;  \n" +
            "             text-align: center;}  \n" +
            "             h1{font-style: italic;  \n" +
            "              font-size: 40px;  \n" +
            "              color: #f08080;}  \n" +
            "            p{font-size: 20px;" +
            "              color-blue}  \n" +
            "      </style>  \n" +
            "    </head>  ";

    static {
        mazeedsignificance = new HashMap<String, String>() {
            {
                put("II", "                   Form II\n" +
                        "                   F-a-33-a-L-a(فَعَّلَ)\n" +
                        "                   3-a-LL-a-M-a()\n" +
                        "                   (\"to teach\")\n" +
                        "EG.1              Causative:\n" +
                        "                   (96:4:2)\n" +
                        "                   ʿallama()\n" +
                        "                    taught\n" +
                        "\n" +
                        "EG.2              Intensity:\n" +
                        "                  (12:23:8)\n" +
                        "                  waghallaqati()\n" +
                        "                  And she closed\n" +
                        "\n" +
                        "A verb that is already transitive becomes doubly so,\n" +
                        " as it takes a meaning of \"make do\" or \"make become\", \n" +
                        "so the meaning could be \"to make one learn\" i.e. \"to teach\". \n" +
                        "This form reflects meaning in three ways:  \n" +
                        "\n" +
                        "   1. Intensity of the verb (repetition or the energy in which the action is performed).\n" +
                        "   2. He made himself do (to make himself).\n" +
                        "   3.Causative (to make another do).\n" +
                        "In the intensity example on the right, the form of the verb shows  " +
                        "the intensity and the repetition of the action, \n" +
                        "i.e. she closed all the doors and bolted them.");
                put("III", "                   Form III\n" +
                        "                   F-aa-3-a-L-a(فَاعَلَ)\n" +
                        "                   Q-aa-T-a-L-a()\n" +
                        "                   (\"to fight\")\n" +
                        "EG.1              Causative:\n" +
                        "                   (12:26:7)\n" +
                        "                   shāhidun()\n" +
                        "                   a witness\n" +
                        "\n" +
                        "EG.2              Intensity:\n" +
                        "                  (2:244:1)\n" +
                        "                  waqātilū()\n" +
                        "                  And fight\n" +
                        "\n" +
                        "This form implies that there is someone or something else present and\n" +
                        " that the action is performed upon him/her/it.\n" +
                        " This forms reflects meaning in two ways:   \n" +
                        "\n" +
                        "   1. Causative (\"to be\") as an active participle.\n" +
                        "   2. Mutual action (he made him do the same).\n" +
                        "\n" +
                        "  In the causative example  ,\n" +
                        " the active participle is derived from form I SH-a-H-i-D-a\n" +
                        " \"to witness\" or \"to be present\", which also occurs in the same verse.\n" +
                        " So here it is almost as if to say \"he caused himself to witness\".\n" +
                        "\n" +
                        "In the second example, the verb \"fight\" requires someone\n" +
                        " to be fought with, and so the action is mutual.");
                put("IV", "                Form IV\n" +
                        "                    a-F-3-a-L-a(أَفْعَلَ)\n" +
                        "                    a-H-L-a-K-a()\n" +
                        "                   (\"to destory\")\n" +
                        "Example 1:                      Example 2:      Example 3:" +
                        "(2:205:8)                       (12:25:15)      (5:30:7)  " +
                        "wayuh'lika()                    arāda()         fa-aṣbaḥa()" +
                        "and destroys                    intended        and became" +
                        "This pattern is similar to form II in that it makes\n" +
                        "intransitive verbs transitive, and transitive verbs doubly so.\n" +
                        "This form has the meaning of:\n" +
                        "\n" +
                        "    He made himself do or perform an action.\n" +
                        "    A reflexive causative, i.e. he made himself do something transformative to a place or a state.\n" +
                        "\n" +
                        "In the first example on the right, he made himself \"destroy the crops\".\n" +
                        "\n" +
                        "In the second example, the verb is causative, so that he made himself \"want to harm\".\n" +
                        "In the third example, he was not of the losers before this action of killing,\n" +
                        " but now was transformed into that state. ");
                put("V", "                    Form V\n" +
                        "                   t-a-F-33-a-L-a(تَفَعَّلَ)\n" +
                        "                    t-a-DH-KK-a-RR-a()\n" +
                        "                   (\"to receive admonition\")\n" +
                        "Form 5 is linked to form 2. Whatever action is done through a F-a-33-a-L-a form 2 verb,\n" +
                        "the t-a-F-33-a-L-a form 5 verb is from the point of view of the object of the verb.\n" +
                        "This usually reflects the reflexive or effective meaning, e.g. \"he made himself\" or \n" +
                        "\"he made something undergo an action\".\n" +
                        "\n" +
                        "In the first example on the right, DH-a-KK-a-R-a \"to remind\" is form II, \n" +
                        "and now in form V it is from the point of view of the object, i.e. \"he received the reminder\".\n" +
                        "\n" +
                        "In the second example, the verb here is t-a-GH-a-YY-a-R-a \"to undergo change\",\n" +
                        " so these rivers in paradise do not undergo any change of state or taste \n" +
                        "even if ones tries to do that (in relation to form II: GH-a-YY-a-R-a \"to cause to change\")");
                put("VI", "                   Form VI\n" +
                        "                   t-a-F-aa-3-a-L-a(تَفَاعَلَ)\n" +
                        "                    t-a-DH-aa-H-a-R-a()\n" +
                        "                   (\"to support one another\")\n" +
                        "Form 6 is the reflection of how the object underwent the action of form 3 (F-aa-3-a-L-a).\n" +
                        " Notice that as in form 5, this is obtained by adding ta- before the verb.\n" +
                        " Since form 3 implies an action done on someone, form 6 implies reciprocity\n" +
                        " as in the English sentence \"they looked at each other\".\n" +
                        "\n" +
                        "The subject cannot be singular in this function of the form. For example, t-a-K-aa-T-a-B-a\n" +
                        " itself would mean \"they corresponded with each other\" (they wrote to each other).\n" +
                        " Here they support one another in this particular action. This usually reflects the meaning of:\n" +
                        "\n" +
                        "    1.Pure mutuality, e.g. t-a-B-aa-D-a-L-a \"he exchanged\" takes one object,\n" +
                        "      or t-a-3-aa-W-a-N-a \"he became assisting\". More than one party needs to be involved in this action\n" +
                        "    2.Conative - he made himself be the doer.\n" +
                        "    3.Pretension – he made himself do something, e.g. \"He made himself appear to forget\"");
                put("VII", "                   Form VII\n" +
                        "                   i-n-F-a-3-a-L-a(إِنْفَعَلَ)\n" +
                        "                    i-n-Q-a-L-a-B-a()\n" +
                        "                   (\"to turn away\")\n" +
                        " EG.1           Reflexive:\n" +
                        "                (3:144:18)\n" +
                        "                yanqalib()\n" +
                        "                turns back\n" +
                        "\n" +
                        "EG.2           Agentless passive:\n" +
                        "               (73:18:2)\n" +
                        "               munfaṭirun()\n" +
                        "               (will) break apart\n" +
                        "\n" +
                        "This form expresses submission to an action or effect. \n" +
                        "In the case of an animate being, this is an involuntary submission.\n" +
                        "The form reflects meaning on two levels: \n" +
                        "\n" +
                        "   1. Reflexive (to let oneself be put through).\n" +
                        "   2. Angentless passive (non-reciprocal of form I).\n" +
                        "In the second example, the verb is i-n-F-a-T-a-R-a \"to be taken apart\". \n" +
                        "In the Quranic sense, the agent of the action is God, as the skies do not\n" +
                        " split without a cause. But here it serves the heaven's submission\n" +
                        " to be broken apart.  ");
                put("VIII", "<body>  <h1>Form VIII\n" +
                        "i-F-t-a-3-a-L-a(إِفْتَعَلَ)<br>" +
                        "\n" +
                        "i-3-t-a-R-a-DH-a<br>" +
                        "(\"to excuse oneself\")<br>" +
                        "</h1>" +
                        "<h1>Example 1:\n" +
                        "Conative:\n" +
                        "(9:94:8)\n" +
                        "taʿtadhirū\n" +
                        "make excuse,\n" +
                        "</h1>" +
                        "<h1>Example 2:\n" +
                        "Causative :\n" +
                        "(2:51:7)\n" +
                        "ittakhadhtumu\n" +
                        "you took\n" +
                        "</h1><p>" +
                        " \n" +
                        "This form is generally the reflexive of the simple\n" +
                        "\t\t\tform\n" +
                        "\t\t\t<span class=\"r1\">K</span>-a-<span class=\"r2\">T</span>-a-<span class=\"r3\">B</span>-a\n" +
                        "\t\t\t\"he wrote\", where the object of form 1 becomes its own object. This form reflects two meanings:\n" +
                        "\t\t\t<ol>\n" +
                        "\t\t\t\t<li>Either conative or causative (to make oneself do).</li>\n" +
                        "\t\t\t\t<li>Reciprocal.</li>\n" +
                        "\t\t\t</ol>\n" +
                        "\t\t\tIn the conative example on the right, the verb is\n" +
                        "\t\t\ti-<span class=\"r1\">3</span>-t-a-<span class=\"r2\">R</span>-a-<span class=\"r3\">DH</span>-a\n" +
                        "\t\t\t\"to excuse oneself\". Here in the second person, the meaning becomes \"do not excuse yourselves\".\n" +
                        "\t\t\t<p>\n" +
                        "\t\t\tIn the causative example, they made themselves take a conscious effortful action.</body>");
                put("IX", "Form IX\n" +
                        "i-F-3-a-LL-a(إِفْعَلَّ)\n" +
                        "i-S-W-a-DD-a\n" +
                        "(\"to turn black in color\")\n" +
                        "\n" +
                        "Color:\n" +
                        "\n" +
                        "(3:106:4)\n" +
                        "wataswaddu\n" +
                        " \n" +
                        "This form usually reflects the meaning of stativity,\n" +
                        " and typically refers to bodily defects and colors. For example, i-3-W-a-JJ-a \"to be crocked or lame\"");
                put("X", "<b>Form X</b><br>\n" +
                        "\t\t\t\ti-s-t-a-<span class=\"r1\">F</span>-<span class=\"r2\">3</span>-a-<span class=\"r3\">L</span>-a<br>\n" +
                        "\t\t\t\t<span class=\"at\">إِسْتَفْعَلَ</span>\n" +
                        "\t\t\t</td>\n" +
                        "\t\t\t<td class=\"c2\">i-s-t-a-<span class=\"r1\">H</span>-<span class=\"r2\">Z</span>-a-<span class=\"r3\">A</span>-a<br>(\"to make oneself mock at\")</td>\n" +
                        "Reflexive causative:\n" +
                        "\n" +
                        "(13:32:2)\n" +
                        "us'tuh'zi-a\n" +
                        "were mocked\n" +
                        "\n" +
                        "Causative:\n" +
                        "\n" +
                        "(4:106:1)\n" +
                        "wa-is'taghfiri\n" +
                        "And seek forgiveness<br>\n" +
                        "The tenth form usually reflects the meaning of\n" +
                        "\t\t\tsomeone seeking something. Typically the form reflects the meaning\n" +
                        "\t\t\tof:\n" +
                        "\t\t\t<ol>\n" +
                        "\t\t\t\t<li>Causative -\n" +
                        "\t\t\t\ti-s-t-<span class=\"r1\">KH</span>-<span class=\"r2\">R</span>-a-<span class=\"r3\">J</span>-a\n" +
                        "\t\t\t\t\"to effortfully make come out\"\n" +
                        "\t\t\t\t(i.e. he extracted) .</li>\n" +
                        "\t\t\t\t<li>Reflexive causative -\n" +
                        "\t\t\t\ti-s-t-a-<span class=\"r1\">H</span>-<span class=\"r2\">Z</span>-a-<span class=\"r3\">A</span>-a\n" +
                        "\t\t\t\t\"he made himself\n" +
                        "\t\t\t\tderide\".\n" +
                        "\t\t\t\t<br>\n" +
                        "\t\t\t\tReflexive transformative - \"he made be himself be something\", e.g.\n" +
                        "\t\t\t\ti-s-t-a-<span class=\"r1\">3</span>-<span class=\"r2\">R</span>-a-<span class=\"r3\">B</span>-a\n" +
                        "\t\t\t\t\"he made himself an Arab\"</li>\n" +
                        "\t\t\t\t<li>Causative - \"to do to the self\", e.g. \"he made the object do himself\"\n" +
                        "\t\t\t\t(as the subject), or \"He sought to be done by the object\".\n" +
                        "\t\t\t\ti-s-t-<span class=\"r1\">GH</span>-<span class=\"r2\">F</span>-a-<span class=\"r3\">R</span>-a\n" +
                        "\t\t\t\t\"he sought to be forgiven by someone else\".</li>\n" +
                        "\t\t\t</ol>");
            }

        };
    }
    //  EMPH = "Emphatic lām prefix(لام التوكيد) ",
    // IMPV = "Imperative lāmprefix(لام الامر)",
    // PRP = "Purpose lāmprefix(لام التعليل)",
    // CONJ = "Coordinating conjunction(حرف عطف)",
    // SUB = "	Subordinating conjunction(حرف مصدري)",
    //  ACC = "	Accusative particle(حرف نصب)",
    //  AMD = "	Amendment particle(حرف استدراك)	",
    //  ANS = "	Answer particle	(حرف جواب)",
    //  AVR = "	Aversion particle	(حرف ردع)",
    //  CAUS = "Particle of cause	(حرف سببية)",
    //  CERT = "Particle of certainty	(حرف تحقيق)",
    // CIRC = "Circumstantial particle	(حرف حال)",

    interface Particles {
        String P = "Prepositions(حرف جر)",
                DET = "determiner()",
                EMPH = "Emphatic lām prefix(لام التوكيد) ",
                IMPV = "Imperative lāmprefix(لام الامر)",
                PRP = "Purpose lāmprefix(لام التعليل)",
                CONJ = "Coordinating conjunction(حرف عطف)",
                SUB = "	Subordinating conjunction(حرف مصدري)",
                ACC = "	Accusative particle(حرف نصب)",
                AMD = "	Amendment particle(حرف استدراك)	",
                ANS = "	Answer particle	(حرف جواب)",
                AVR = "	Aversion particle	(حرف ردع)",
                CAUS = "Particle of cause	(حرف سببية)",
                CERT = "Particle of certainty	(حرف تحقيق)",
                CIRC = "Circumstantial particle	(حرف حال)",
                COM = "	Comitative particle	(واو المعية)",
                COND = "Conditional particle(حرف شرط)",
                EQ = "	Equalization particle(حرف تسوية)",
                EXH = "	Exhortation particle(حرف تحضيض)",
                EXL = "	Explanation particle(حرف تفصيل)",
                EXP = "	Exceptive particle	(أداة استثناء)",
                FUT = "	Future particle	(حرف استقبال)",
                INC = "	Inceptive particle	(حرف ابتداء)",
                INT = "	Particle of interpretation(حرف تفسير)",
                INTG = "Interogative particle	(حرف استفهام)",
                NEG = "	Negative particle(حرف نفي)",
                PREV = "Preventive particle	(حرف كاف)",
                PRO = "	Prohibition particle(حرف نهي)",
                REM = "	Resumption particle	(حرف استئنافية)",
                RES = "	Restriction particle(أداة حصر)",
                RET = "	Retraction particle	(حرف اضراب)",
                RSLT = "Result particle(حرف واقع في جواب الشرط)",
                SUP = "	Supplemental particle	(حرف زائد)",
                SUR = "	Surprise particle	(حرف فجاءة)",
                VOC = "	Vocative particle	(حرف نداء)",
                INL = "	Quranic initials(	(حروف مقطعة	";
    }

}
