package com.example.mushafconsolidated.fragments;

import static com.example.utility.CorpusConstants.verbfeaturesenglisharabic.IMPF;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.example.mushafconsolidated.Entities.NewCorpusExpandWbwPOJO;
import com.example.mushafconsolidated.Entities.NounCorpus;
import com.example.mushafconsolidated.Entities.VerbCorpus;
import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.model.CorpusWbwWord;
import com.example.utility.CorpusConstants;
import com.example.utility.CorpusUtilityorig;
import com.example.utility.SharedPref;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class QuranMorphologyDetails {
    int form = 0;
    String Thulathi;
    private CorpusWbwWord word;
    private ArrayList<NounCorpus> corpusNoun;
    private ArrayList<NewCorpusExpandWbwPOJO> corpusSurahWord;
    private ArrayList<VerbCorpus> verbcorpusform;

    public QuranMorphologyDetails() {
    }

    public QuranMorphologyDetails(ArrayList<NewCorpusExpandWbwPOJO> corpusSurahWord, ArrayList<NounCorpus> corpusNounWord, ArrayList<VerbCorpus> verbCorpuses, Context context) {
        this.corpusSurahWord = corpusSurahWord;
        this.verbcorpusform = verbCorpuses;
        this.corpusNoun = corpusNounWord;
        String dark = SharedPref.themePreferences();
        int indigo;
        int cyan;
        int yellow;
        int green;
        if (dark.equals("dark")) {
            indigo = ContextCompat.getColor(context, R.color.indigo);
            cyan = ContextCompat.getColor(context, R.color.cyan);
            yellow = ContextCompat.getColor(context, R.color.yellow);
            green = ContextCompat.getColor(context, R.color.green);
        } else {
            indigo = ContextCompat.getColor(context, R.color.indigo);
            cyan = ContextCompat.getColor(context, R.color.red);
            yellow = ContextCompat.getColor(context, R.color.hotpink);
            green = ContextCompat.getColor(context, R.color.deeppink);

        }

    }

    public static String getFormName(String form) {
        String formdetails = "";
        switch (form) {
            case "IV":
                formdetails = "Form-IV(إِفْعَال)";
                break;
            case "II":
                formdetails = "Form-II(تَفْعِيل)";
                break;
            case "III":
                formdetails = "Form-II(فَاعَلَ)";
                break;
            case "VII":
                formdetails = "Form-VII(اِنْفِعَال)";
                break;
            case "VIII":
                formdetails = "Form-VIII(اِفْتِعَال)";
                break;
            case "VI":
                formdetails = "Form-VI(تَفَاعُل)";
                break;
            case "V":
                formdetails = "Form-V(تَفَعُّل)";
                break;
            case "X":
                formdetails = "Form-X(اِسْتِفْعَال)";
                break;
            default:
                String s = "";

        }
        return formdetails;
    }

    @NonNull
    public static StringBuilder getThulathiName(String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(("Form I-"));
        switch (s) {
            case "N":
                sb.append(CorpusConstants.thulathi.NASARA);
                break;
            case "Z":
                sb.append(CorpusConstants.thulathi.ZARABA);
                break;
            case "F":
                sb.append(CorpusConstants.thulathi.FATAH);
                break;
            case "S":
                sb.append(CorpusConstants.thulathi.SAMIA);
                break;
            case "K":
                sb.append(CorpusConstants.thulathi.KARUMU);
                break;
            case "H":
                sb.append(CorpusConstants.thulathi.HASIBA);
                break;
        }
        sb.append(")");
        return sb;
    }

    @NotNull
    public static StringBuilder getGenderNumberdetails(String gendernumber) {
        String person;
        String gender;
        String number;
        StringBuilder sb = new StringBuilder();
        if (gendernumber.length() == 3) {
            person = gendernumber.substring(0, 1);
            gender = gendernumber.substring(1, 2);
            number = gendernumber.substring(2, 3);
            switch (person) {
                case "1":
                    sb.append("1st Person ");
                    break;
                case "2":
                    sb.append("2nd Person ");
                    break;
                case "3":
                    sb.append("3rd Person ");
                    break;
            }
            sb.append(" ");
            if (gender.equals("M")) {
                sb.append("Masculine");
            } else if (gender.equals("F")) {
                sb.append("Feminine");
            }
            sb.append(" ");
            switch (number) {
                case "S":
                    sb.append("Singular");
                    break;
                case "P":
                    sb.append("Plural");
                    break;
                case "D":
                    sb.append("Dual");
                    break;
            }

        } else if (gendernumber.length() == 2) {
            person = gendernumber.substring(0, 1);
            number = gendernumber.substring(1, 2);
            char[] chars = gendernumber.toCharArray();
            if ((chars[0] >= 'a' && chars[0] <= 'z') || (chars[0] >= 'A' && chars[0] <= 'Z')) {
                switch (person) {
                    case "M":
                        sb.append("Masculine");
                        sb.append(" ");
                        break;
                    case "F":
                        sb.append("Feminine");
                        sb.append(" ");
                        break;
                }
            } else {
                switch (person) {
                    case "1":
                        sb.append("1st Person");
                        break;
                    case "2":
                        sb.append("2nd Person");
                        break;
                    case "3":
                        sb.append("3rd Person");
                        break;
                }
            }
            switch (number) {
                case "S":
                    sb.append("Singular");
                    break;
                case "P":
                    sb.append("Plural");
                    break;
                case "D":
                    sb.append("Dual");
                    break;
            }

        } else if (gendernumber.length() == 2) {
            person = gendernumber.substring(0, 1);
            number = gendernumber.substring(1, 2);
            switch (person) {
                case "1":
                    sb.append("1st Person");
                    break;
                case "2":
                    sb.append("2nd Person");
                    break;
                case "3":
                    sb.append("3rd Person");
                    break;
            }
            switch (number) {
                case "S":
                    sb.append("Singular");
                    break;
                case "P":
                    sb.append("Plural");
                    break;
                case "D":
                    sb.append("Dual");
                    break;
            }

        } else if (gendernumber.length() == 1) {
            person = gendernumber.substring(0, 1);
            switch (person) {
                case "S":
                    sb.append("Singular");
                    break;
                case "P":
                    sb.append("Plural");
                    break;
                case "D":
                    sb.append("Dual");
                    break;
                case "1":
                    sb.append("1st Person");
                    break;
                case "2":
                    sb.append("2nd Person");
                    break;
                case "3":
                    sb.append("3rd Person");
                    break;
                case "M":
                    sb.append("Masculine");
                    break;
                case "F":
                    sb.append("Feminine");
                    break;

            }

        }
        return sb;
    }

    public static String expandTags(String tagtwo) {
        switch (tagtwo) {
            case "PASS":
                tagtwo = CorpusConstants.verbfeaturesenglisharabic.PASS;
                break;
            case "PERF":
                tagtwo = CorpusConstants.verbfeaturesenglisharabic.PERF;
                break;
            case "IMPF":
                tagtwo = CorpusConstants.verbfeaturesenglisharabic.IMPF;
                break;
            case "ACTPCPL":
                tagtwo = CorpusConstants.NominalsProp.ACTPCPL;
                break;
            case "PASSPCPL":
                tagtwo = CorpusConstants.NominalsProp.PASSPCPL;
                break;
            case "V":
                tagtwo = CorpusConstants.verbfeaturesenglisharabic.V;
                break;
            case "N":
                tagtwo = CorpusConstants.Nominals.N;
                break;
            case "PN":
                tagtwo = CorpusConstants.Nominals.PN;
                break;
            case "ADJ":
                tagtwo = CorpusConstants.Nominals.ADJ;
                break;
            case "PRON":
                tagtwo = CorpusConstants.Nominals.PRON;
                break;
            case "DEM":
                tagtwo = CorpusConstants.Nominals.DEM;
                break;
            case "REL":
                tagtwo = CorpusConstants.Nominals.REL;
                break;
            case "T":
                tagtwo = CorpusConstants.Nominals.T;
                break;
            case "LOC":
                tagtwo = CorpusConstants.Nominals.LOC;
                break;
            case "ACT":
                tagtwo = CorpusConstants.NominalsProp.PASS;
                break;
            case "VN":
                tagtwo = CorpusConstants.NominalsProp.VN;
                break;
            case "INDEF":
                tagtwo = CorpusConstants.NominalsProp.INDEF;
                break;
            case "DEF":
                tagtwo = CorpusConstants.NominalsProp.DEF;
                break;
            case "DET":
                tagtwo = CorpusConstants.Particles.DET;
                break;
            case "NOM":
                tagtwo = CorpusConstants.NominalsProp.NOM;
                break;
            case "ACC":
                tagtwo = CorpusConstants.NominalsProp.ACC;
                break;
            case "P":
                tagtwo = CorpusConstants.Particles.P;
                break;
            case "EMPH":
                tagtwo = CorpusConstants.Particles.EMPH;
                break;
            case "IMPV":
                tagtwo = CorpusConstants.Particles.IMPV;
                break;
            case "PRP":
                tagtwo = CorpusConstants.Particles.PRP;
                break;
            case "CONJ":
                tagtwo = CorpusConstants.Particles.CONJ;
                break;
            case "SUB":
                tagtwo = CorpusConstants.Particles.SUB;
                break;
            case "AMD":
                tagtwo = CorpusConstants.Particles.AMD;
                break;
            case "ANS":
                tagtwo = CorpusConstants.Particles.ANS;
                break;
            case "AVR":
                tagtwo = CorpusConstants.Particles.AVR;
                break;
            case "CAUS":
                tagtwo = CorpusConstants.Particles.CAUS;
                break;
            case "CERT":
                tagtwo = CorpusConstants.Particles.CERT;
                break;
            case "CIRC":
                tagtwo = CorpusConstants.Particles.CIRC;
                break;
            case "COM":
                tagtwo = CorpusConstants.Particles.COM;
                break;
            case "COND":
                tagtwo = CorpusConstants.Particles.COND;
                break;
            case "EQ":
                tagtwo = CorpusConstants.Particles.EQ;
                break;
            case "EXH":
                tagtwo = CorpusConstants.Particles.EXH;
                break;
            case "EXL":
                tagtwo = CorpusConstants.Particles.EXL;
                break;
            case "EXP":
                tagtwo = CorpusConstants.Particles.EXP;
                break;
            case "FUT":
                tagtwo = CorpusConstants.Particles.FUT;
                break;
            case "INC":
                tagtwo = CorpusConstants.Particles.INC;
                break;
            case "INT":
                tagtwo = CorpusConstants.Particles.INT;
                break;
            case "INTG":
                tagtwo = CorpusConstants.Particles.INTG;
                break;
            case "NEG":
                tagtwo = CorpusConstants.Particles.NEG;
                break;
            case "PREV":
                tagtwo = CorpusConstants.Particles.PREV;
                break;
            case "PRO":
                tagtwo = CorpusConstants.Particles.PRO;
                break;
            case "REM":
                tagtwo = CorpusConstants.Particles.REM;
                break;
            case "RES":
                tagtwo = CorpusConstants.Particles.RES;
                break;
            case "RET":
                tagtwo = CorpusConstants.Particles.RET;
                break;
            case "RSLT":
                tagtwo = CorpusConstants.Particles.RSLT;
                break;
            case "SUP":
                tagtwo = CorpusConstants.Particles.SUP;
                break;
            case "SUR":
                tagtwo = CorpusConstants.Particles.SUR;
                break;
            case "VOC":
                tagtwo = CorpusConstants.Particles.VOC;
                break;
            case "INL":
                tagtwo = CorpusConstants.Particles.INL;
                break;
        }
        return tagtwo;
    }

    public void setThulathi(String thulathi) {
        Thulathi = thulathi;
    }

    public int getForm() {
        return form;
    }

    public void setForm(int form) {
        this.form = form;
    }

    public HashMap<String, String> getVerbDetails() {
        HashMap<String, String> vbdetail = new HashMap<>();
        String roots;
        roots = verbcorpusform.get(0).getRoot_a();
        vbdetail.put("root", roots);
        if (verbcorpusform.size() > 0) {
            if (!verbcorpusform.get(0).getForm().equals("I")) {
                String mform = verbcorpusform.get(0).getForm();
                convertForms(mform);
                vbdetail.put("formnumber", mform);
                vbdetail.put("form", String.valueOf(getForm()));

            } else {
                String thulathibab = verbcorpusform.get(0).getThulathibab();
                if (thulathibab.length() == 0)
                    vbdetail.put("thulathi", null);
                else if (thulathibab.length() == 1) {
                    String s = verbcorpusform.get(0).getThulathibab();
                    final StringBuilder sb = getThulathiName(s);
                    vbdetail.put("thulathi", sb.toString());
                    vbdetail.put("wazan", thulathibab);

                } else if (thulathibab.length() > 1) {
                    String s = thulathibab.substring(0, 1);
                    final StringBuilder sb = getThulathiName(s);
                    vbdetail.put("thulathi", sb.toString());
                    vbdetail.put("wazan", s);

                }

            }
        }
        String gendernumber = verbcorpusform.get(0).getGendernumber();
        StringBuilder pngsb = getGenderNumberdetails(gendernumber);
        if (vbdetail.get("form") != null) {
            String formdetails = getFormName(verbcorpusform.get(0).getForm());
            pngsb.append(",").append(formdetails);
            //     pngsb.append("," + "(form").append(verbcorpusform.get(0).getForm()).append(")");
            vbdetail.put("png", pngsb.toString());
        } else {
            vbdetail.put("png", null);
            //    pngsb.append(",").append(verbcorpusform.get(0).getThulathibab());
        }
        vbdetail.put("png", pngsb.toString());
        String tense = verbcorpusform.get(0).getTense();
        switch (tense) {
            case "IMPF":
                vbdetail.put("tense", IMPF);
                break;
            case "IMPV":
                vbdetail.put("tense", CorpusConstants.verbfeaturesenglisharabic.IMPV);
                break;
            case "PERF":
                vbdetail.put("tense", CorpusConstants.verbfeaturesenglisharabic.PERF);
                break;

        }
        String voice = verbcorpusform.get(0).getVoice();
        switch (voice) {
            case "ACT":
                vbdetail.put("voice", CorpusConstants.verbfeaturesenglisharabic.ACT);
                break;
            case "PASS":
                vbdetail.put("voice", CorpusConstants.verbfeaturesenglisharabic.PASS);
                break;

        }
        if (roots.equals("كون")) {
            String kana_mood = verbcorpusform.get(0).getKana_mood();
            switch (kana_mood) {
                case "MOOD:SUBJ":
                    vbdetail.put("mood", CorpusConstants.verbfeaturesenglisharabic.IND);
                    vbdetail.put("verbmood", "subjunctive");
                    break;
                case "JUS":
                    vbdetail.put("mood", CorpusConstants.verbfeaturesenglisharabic.JUS);
                    vbdetail.put("verbmood", "Jussive");
                    break;
                case "SUBJ":
                    vbdetail.put("mood", CorpusConstants.verbfeaturesenglisharabic.SUBJ);
                    vbdetail.put("verbmood", "Subjunctive");
                    break;
                default:
                    vbdetail.put("mood", CorpusConstants.verbfeaturesenglisharabic.IND);
                    vbdetail.put("verbmood", "Indicative");
                    break;
            }
        } else {
            String mood = verbcorpusform.get(0).getMood_kananumbers();
            switch (mood) {
                case "IND":
                    vbdetail.put("mood", CorpusConstants.verbfeaturesenglisharabic.IND);
                    vbdetail.put("verbmood", "Indicative");
                    break;
                case "JUS":
                    vbdetail.put("mood", CorpusConstants.verbfeaturesenglisharabic.JUS);
                    vbdetail.put("verbmood", "Jussive");
                    break;
                case "SUBJ":
                    vbdetail.put("mood", CorpusConstants.verbfeaturesenglisharabic.SUBJ);
                    vbdetail.put("verbmood", "Subjunctive");
                    break;

            }
        }
        vbdetail.put("lemma", verbcorpusform.get(0).getLemma_a());
        return vbdetail;
    }

    void convertForms(String mform) {
        switch (mform) {
            case "IV":
                setForm(1);
                break;
            case "II":
                setForm(2);
                break;
            case "III":
                setForm(3);
                break;
            case "VII":
                setForm(4);
                break;
            case "VIII":
                setForm(5);
                break;
            case "VI":
                setForm(7);
                break;
            case "V":
                setForm(8);
                break;
            case "X":
                setForm(9);
                break;
            default:
                String s = "";
                try {
                    s = verbcorpusform.get(0).getThulathibab();
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Exception occurred . . . . . . . . ");

                }
                if (s.length() > 0)
                    setThulathi(s);
                else {
                    setThulathi(null);
                }
                break;
        }
    }

    private String getVerbRoot() {
        String roots = null;
        if (corpusSurahWord.get(0).getWordcount() == 1) {
            if (corpusSurahWord.get(0).getTagone().equals("V")) {
                roots = corpusSurahWord.get(0).getRoot_a();
            }
        } else if (corpusSurahWord.get(0).getWordcount() == 2) {
            if (corpusSurahWord.get(0).getTagone().equals("V")) {
                roots = corpusSurahWord.get(0).getRootaraone();
            } else if (corpusSurahWord.get(0).getTagtwo().equals("V")) {
                roots = corpusSurahWord.get(0).getRootaratwo();
            }
        } else if (corpusSurahWord.get(0).getWordcount() == 3) {
            if (corpusSurahWord.get(0).getTagone().equals("V")) {
                roots = corpusSurahWord.get(0).getRootaraone();
            } else if (corpusSurahWord.get(0).getTagtwo().equals("V")) {
                roots = corpusSurahWord.get(0).getRootaratwo();
            } else if (corpusSurahWord.get(0).getTagthree().equals("V")) {
                roots = corpusSurahWord.get(0).getRootarathree();

            }

        } else if (corpusSurahWord.get(0).getWordcount() == 4) {
            if (corpusSurahWord.get(0).getTagone().equals("V")) {
                roots = corpusSurahWord.get(0).getRootaraone();
            } else if (corpusSurahWord.get(0).getTagtwo().equals("V")) {
                roots = corpusSurahWord.get(0).getRootaratwo();
            } else if (corpusSurahWord.get(0).getTagthree().equals("V")) {
                roots = corpusSurahWord.get(0).getRootarathree();

            } else if (corpusSurahWord.get(0).getTagfour().equals("V")) {
                roots = corpusSurahWord.get(0).getRootarafour();

            }

        } else if (corpusSurahWord.get(0).getWordcount() == 5) {
            if (corpusSurahWord.get(0).getTagone().equals("V")) {
                roots = corpusSurahWord.get(0).getRootaraone();
            } else if (corpusSurahWord.get(0).getTagtwo().equals("V")) {
                roots = corpusSurahWord.get(0).getRootaratwo();
            } else if (corpusSurahWord.get(0).getTagthree().equals("V")) {
                roots = corpusSurahWord.get(0).getRootarathree();

            } else if (corpusSurahWord.get(0).getTagfour().equals("V")) {
                roots = corpusSurahWord.get(0).getRootarafour();

            } else if (corpusSurahWord.get(0).getTagfive().equals("V")) {
                roots = corpusSurahWord.get(0).getRootarafive();
            }

        }
        return roots;
    }

    public HashMap<String, SpannableStringBuilder> getWordDetails() {
        HashMap<String, SpannableStringBuilder> wordbdetail = new HashMap<>();
        int surah = corpusSurahWord.get(0).getSurah();
        wordbdetail.put("surahid", SpannableStringBuilder.valueOf(String.valueOf(corpusSurahWord.get(0).getSurah())));
        wordbdetail.put("ayahid", SpannableStringBuilder.valueOf(String.valueOf(corpusSurahWord.get(0).getAyah())));
        wordbdetail.put("wordno", SpannableStringBuilder.valueOf(String.valueOf(corpusSurahWord.get(0).getWordno())));
        wordbdetail.put("wordtranslation", SpannableStringBuilder.valueOf(corpusSurahWord.get(0).getEn()));
        String arabicword = corpusSurahWord.get(0).getAraone().concat(corpusSurahWord.get(0).getAratwo().concat(corpusSurahWord.get(0).getArathree()
                .concat(corpusSurahWord.get(0).getArafour().concat(corpusSurahWord.get(0).getArafour()))));
        wordbdetail.put("arabicword", SpannableStringBuilder.valueOf(arabicword));
        if (corpusNoun.size() > 0) {
            if (corpusNoun.get(0).getProptwo().equals(CorpusConstants.NominalsProp.PCPL)) {
                String form = corpusNoun.get(0).getForm();
                final String mform = form.replaceAll("[()]", "");
                //   String mform = corpusNoun.get(0).getForm();
                if (!mform.equals("I")) {
                    convertForms(mform);
                    wordbdetail.put("form", SpannableStringBuilder.valueOf(String.valueOf(getForm())));
                    getRoot(corpusSurahWord, wordbdetail);
                    //chedk if particple
                    if (corpusNoun.get(0).getProptwo().equals("PCPL")) {
                        wordbdetail.put("PCPL", SpannableStringBuilder.valueOf(corpusNoun.get(0).getPropone().concat(corpusNoun.get(0).getProptwo())));
                        wordbdetail.put("particple", SpannableStringBuilder.valueOf("PART"));
                        //    wordbdetail.put("form", SpannableStringBuilder.valueOf("I"));
                    } else {
                        wordbdetail.put("PCPL", SpannableStringBuilder.valueOf("NONE"));
                        wordbdetail.put("particple", SpannableStringBuilder.valueOf("PART"));
                        //   wordbdetail.put("form", SpannableStringBuilder.valueOf("I"));
                    }
                } else {
                    wordbdetail.put("form", SpannableStringBuilder.valueOf(corpusNoun.get(0).getForm()));
                    if (corpusNoun.get(0).getProptwo().equals("PCPL")) {
                        wordbdetail.put("PCPL", SpannableStringBuilder.valueOf(corpusNoun.get(0).getPropone().concat(corpusNoun.get(0).getProptwo())));
                        wordbdetail.put("particple", SpannableStringBuilder.valueOf("PART"));
                        //    wordbdetail.put("form", SpannableStringBuilder.valueOf("I"));
                    } else {
                        wordbdetail.put("PCPL", SpannableStringBuilder.valueOf("NONE"));
                        wordbdetail.put("particple", SpannableStringBuilder.valueOf("PART"));
                        //   wordbdetail.put("form", SpannableStringBuilder.valueOf("I"));
                    }

                }

            }
        }
        GetPronounDetails(corpusSurahWord, wordbdetail);
        GetLemmArabicwordWordDetails(corpusSurahWord, wordbdetail);
        StringBuilder sb = new StringBuilder();
        //get the root,since vercopus is not checked
        getRoot(corpusSurahWord, wordbdetail);
        getNdetails(corpusNoun, wordbdetail, sb);
        getProperNounDetails(corpusNoun, wordbdetail, sb);
        int length = wordbdetail.get("worddetails").length();
        boolean isNoun = wordbdetail.get("worddetails").toString().contains("Noun");
        if (wordbdetail.get("worddetails") != null) {//todo need refactor based on wordcount
            if (!isNoun) {
                final boolean relative = wordbdetail.get("worddetails").toString().contains("Relative Pronoun");
                final boolean prep = Objects.requireNonNull(wordbdetail.get("worddetails")).toString().contains("Prepositions");
                final boolean cond = wordbdetail.get("worddetails").toString().contains("Conditional particle");
                final boolean pron = wordbdetail.get("worddetails").toString().contains("Pronouns");
                final boolean dem = wordbdetail.get("worddetails").toString().contains("Demonstrative Pronoun");
                final boolean time = wordbdetail.get("worddetails").toString().contains("Time Adverb");
                boolean harfnasb = wordbdetail.get("worddetails").toString().contains("Accusative(حرف نصب)");
                if (relative) {
                    wordbdetail.put("relative", SpannableStringBuilder.valueOf("relative"));
                } else if (cond || time) {
                    wordbdetail.put("cond", SpannableStringBuilder.valueOf("cond"));
                } else if (harfnasb) {
                    wordbdetail.put("harfnasb", SpannableStringBuilder.valueOf("harfnasb"));
                } else if (prep) {
                    wordbdetail.put("prep", SpannableStringBuilder.valueOf("prep"));
                } else if (dem) {
                    wordbdetail.put("dem", SpannableStringBuilder.valueOf("dem"));
                }
            }
        }
        return wordbdetail;
    }

    private void getProperNounDetails(ArrayList<NounCorpus> corpusNoun, HashMap<String, SpannableStringBuilder> wordbdetail, StringBuilder sbs) {
        StringBuilder sb = new StringBuilder();
        if (corpusNoun.size() > 0) {
            if (corpusNoun.get(0).getTag().equals("PN") || corpusNoun.get(0).getTag().equals("ADJ")) {
                String propone = corpusNoun.get(0).getPropone();
                String proptwo = corpusNoun.get(0).getProptwo();
                String pcpl = "";
                if (!propone.equals("null") && !proptwo.equals("null")) {
                    pcpl = pcpl.concat(propone + proptwo);
                }
                if (corpusNoun.get(0).getPropone().equals("VN")) {
                    sb.append("Proper/Verbal Noun");
                } else if (corpusNoun.get(0).getTag().equals("ADJ")) {
                    sb.append("Adjective:");

                } else {
                    sb.append("Proper Noun:");
                }
                String form = corpusNoun.get(0).getForm();
                String gendernumber = corpusNoun.get(0).getGendernumber();
                String type = corpusNoun.get(0).getType();
                String cases = corpusNoun.get(0).getCases();
                // sb.append("Proper Noun:");
                if (!cases.equals("null")) {
                    switch (cases) {
                        case "NOM":
                            sb.append(CorpusConstants.NominalsProp.NOM);
                            break;
                        case "ACC":
                            sb.append(CorpusConstants.NominalsProp.ACC);
                            break;
                        case "GEN":
                            sb.append(CorpusConstants.NominalsProp.GEN);
                            sb.append(CorpusConstants.NominalsProp.GEN);
                            break;
                    }
                }
                if (!gendernumber.equals("null")) {
                    if (gendernumber.length() == 1) {
                        switch (gendernumber) {
                            case "M":
                                sb.append(CorpusConstants.png.M + " ");
                                break;
                            case "F":
                                sb.append(CorpusConstants.png.F + " ");
                                break;
                            case "P":
                                sb.append(CorpusConstants.png.P + " ");
                                break;
                        }
                    } else if (gendernumber.length() == 2) {
                        String gender = gendernumber.substring(0, 1);
                        String number = gendernumber.substring(1, 2);
                        switch (gender) {
                            case "M":
                                sb.append(CorpusConstants.png.M + " ");
                                break;
                            case "F":
                                sb.append(CorpusConstants.png.F + " ");
                                break;

                        }
                        switch (number) {
                            case "P":
                                sb.append(CorpusConstants.png.P + " ");
                                break;
                            case "S":
                                sb.append(CorpusConstants.png.S + " ");
                                break;
                            case "D":
                                sb.append(CorpusConstants.png.D + " ");
                                break;
                        }

                    }
                }
                if (!form.equals("null")) {
                    sb.append("(form ").append(form).append(")");
                    wordbdetail.put("formnumber", SpannableStringBuilder.valueOf(form));
                }
                if (!propone.equals("null") && !proptwo.equals("null")) {
                    if (pcpl.equals("ACTPCPL")) {
                        sb.append(CorpusConstants.NominalsProp.ACTPCPL);
                        wordbdetail.put("particple", SpannableStringBuilder.valueOf("PART"));
                    } else if (pcpl.equals("PASSPCPL")) {
                        sb.append(CorpusConstants.NominalsProp.PASSPCPL);
                        wordbdetail.put("particple", SpannableStringBuilder.valueOf("PART"));
                    }
                }
                if (!type.equals("null")) {
                    sb.append(CorpusConstants.NominalsProp.INDEF);
                    sb.append(",");
                }
                if (sb.length() > 5) {
                    wordbdetail.put("noun", SpannableStringBuilder.valueOf(sb.toString()));
                }
            }
        }
    }

    void getNdetails(ArrayList<NounCorpus> corpusNoun, HashMap<String, SpannableStringBuilder> wordbdetail, StringBuilder sb) {
        if (corpusNoun.size() > 0) {
            if (corpusNoun.get(0).getTag().equals("N") || corpusNoun.get(0).getTag().equals("PN") ||
                    corpusNoun.get(0).getTag().equals("VN") ||
                    corpusNoun.get(0).getTag().equals("ADJ")) {
                //   if (corpusNoun.get(0).getTag().equals("N")) {
                String propone = corpusNoun.get(0).getPropone();
                String proptwo = corpusNoun.get(0).getProptwo();
                String pcpl = "";
                if (!propone.equals("null") && !proptwo.equals("null")) {
                    pcpl = pcpl.concat(propone + proptwo);
                }
                String form = corpusNoun.get(0).getForm();
                String gendernumber = corpusNoun.get(0).getGendernumber();
                String type = corpusNoun.get(0).getType();
                String cases = corpusNoun.get(0).getCases();
                //   sb.append("Noun:");
                switch (corpusNoun.get(0).getTag()) {
                    case "N":
                        sb.append("Noun:".concat(" "));
                        break;
                    case "ADJ":
                        sb.append("Adjective:".concat(" "));
                        break;
                    case "PN":
                        sb.append("Porper Noun:".concat(" "));
                        break;
                    case "VN":
                        sb.append("Verbal Noun:".concat(" "));
                        break;
                }
                //   sb.append(corpusNoun.get(0).getTag().concat(" "));
                if (!cases.equals("null")) {
                    switch (cases) {
                        case "NOM":
                            wordbdetail.put("nouncase", SpannableStringBuilder.valueOf("NOM"));
                            sb.append(CorpusConstants.NominalsProp.NOM + " ");
                            break;
                        case "ACC":
                            wordbdetail.put("nouncase", SpannableStringBuilder.valueOf("ACC"));
                            sb.append(CorpusConstants.NominalsProp.ACC + " ");
                            break;
                        case "GEN":
                            wordbdetail.put("nouncase", SpannableStringBuilder.valueOf("GEN"));
                            sb.append(CorpusConstants.NominalsProp.GEN + " ");
                            break;
                    }
                }
                if (!gendernumber.equals("null")) {
                    if (gendernumber.length() == 1) {
                        switch (gendernumber) {
                            case "M":
                                sb.append(CorpusConstants.png.M);
                                break;
                            case "F":
                                sb.append(CorpusConstants.png.F);
                                break;
                            case "P":
                                sb.append(CorpusConstants.png.P);
                                break;
                        }
                    } else if (gendernumber.length() == 2) {
                        String gender = gendernumber.substring(0, 1);
                        String number = gendernumber.substring(1, 2);
                        switch (gender) {
                            case "M":
                                sb.append(CorpusConstants.png.M + " ");
                                break;
                            case "F":
                                sb.append(CorpusConstants.png.F + " ");
                                break;

                        }
                        switch (number) {
                            case "P":
                                sb.append(CorpusConstants.png.P + " ");
                                break;
                            case "S":
                                sb.append(CorpusConstants.png.S + " ");
                                break;
                            case "D":
                                sb.append(CorpusConstants.png.D + " ");
                                break;
                        }

                    }
                }
                if (!form.equals("null")) {
                    sb.append("(form").append(" ").append(form).append(")");
                }
                if (!propone.equals("null") && !proptwo.equals("null")) {
                    if (pcpl.equals("ACTPCPL")) {
                        sb.append(CorpusConstants.NominalsProp.ACTPCPL);

                    } else if (pcpl.equals("PASSPCPL")) {
                        sb.append(CorpusConstants.NominalsProp.PASSPCPL);
                    }
                }
                if (!type.equals("null")) {
                    sb.append(CorpusConstants.NominalsProp.INDEF);
                    sb.append(",");
                }
                if (sb.length() > 5) {
                    wordbdetail.put("noun", SpannableStringBuilder.valueOf(sb.toString()));
                }
            } else if (corpusNoun.get(0).getTag().equals("PN") ||
                    corpusNoun.get(0).getTag().equals("VN") ||
                    corpusNoun.get(0).getTag().equals("ADJ")
            ) {
                String cases = corpusNoun.get(0).getCases();
                //  sb.append("Noun:");
                if (!cases.equals("null")) {
                    switch (cases) {
                        case "NOM":
                            wordbdetail.put("nouncase", SpannableStringBuilder.valueOf("NOM"));
                            //   sb.append(CorpusConstants.NominalsProp.NOM + " ");
                            break;
                        case "ACC":
                            wordbdetail.put("nouncase", SpannableStringBuilder.valueOf("ACC"));
                            //  sb.append(CorpusConstants.NominalsProp.ACC + " ");
                            break;
                        case "GEN":
                            wordbdetail.put("nouncase", SpannableStringBuilder.valueOf("GEN"));
                            //   sb.append(CorpusConstants.NominalsProp.GEN + " ");
                            break;
                    }
                }

            }

        }
    }

    private void getRoot(ArrayList<NewCorpusExpandWbwPOJO> corpusSurahWord, HashMap<String, SpannableStringBuilder> wordbdetail) {
        if (corpusSurahWord.size() > 0) {
            if (corpusSurahWord.get(0).getWordcount() == 1) {
                if (corpusSurahWord.get(0).getRootaraone().length() > 0) {
                    wordbdetail.put("root", SpannableStringBuilder.valueOf(corpusSurahWord.get(0).getRootaraone()));
                }

            } else if (corpusSurahWord.get(0).getWordcount() == 2) {
                if (corpusSurahWord.get(0).getRootaraone().length() > 0) {
                    wordbdetail.put("root", SpannableStringBuilder.valueOf(corpusSurahWord.get(0).getRootaraone()));
                } else if (corpusSurahWord.get(0).getRootaratwo().length() > 0) {
                    wordbdetail.put("root", SpannableStringBuilder.valueOf(corpusSurahWord.get(0).getRootaratwo()));
                }

            } else if (corpusSurahWord.get(0).getWordcount() == 3) {
                if (corpusSurahWord.get(0).getRootaraone().length() > 0) {
                    wordbdetail.put("root", SpannableStringBuilder.valueOf(corpusSurahWord.get(0).getRootaraone()));
                } else if (corpusSurahWord.get(0).getRootaratwo().length() > 0) {
                    wordbdetail.put("root", SpannableStringBuilder.valueOf(corpusSurahWord.get(0).getRootaratwo()));
                } else if (corpusSurahWord.get(0).getRootarathree().length() > 0) {
                    wordbdetail.put("root", SpannableStringBuilder.valueOf(corpusSurahWord.get(0).getRootarathree()));
                }

            } else if (corpusSurahWord.get(0).getWordcount() == 4) {
                if (corpusSurahWord.get(0).getRootaraone().length() > 0) {
                    wordbdetail.put("root", SpannableStringBuilder.valueOf(corpusSurahWord.get(0).getRootaraone()));
                } else if (corpusSurahWord.get(0).getRootaratwo().length() > 0) {
                    wordbdetail.put("root", SpannableStringBuilder.valueOf(corpusSurahWord.get(0).getRootaratwo()));
                } else if (corpusSurahWord.get(0).getRootarathree().length() > 0) {
                    wordbdetail.put("root", SpannableStringBuilder.valueOf(corpusSurahWord.get(0).getRootarathree()));
                } else if (corpusSurahWord.get(0).getRootarafour().length() > 0) {
                    wordbdetail.put("root", SpannableStringBuilder.valueOf(corpusSurahWord.get(0).getRootarafour()));
                }

            } else if (corpusSurahWord.get(0).getWordcount() == 5) {
                if (corpusSurahWord.get(0).getRootaraone().length() > 0) {
                    wordbdetail.put("root", SpannableStringBuilder.valueOf(corpusSurahWord.get(0).getRootaraone()));
                } else if (corpusSurahWord.get(0).getRootaratwo().length() > 0) {
                    wordbdetail.put("root", SpannableStringBuilder.valueOf(corpusSurahWord.get(0).getRootaratwo()));
                } else if (corpusSurahWord.get(0).getRootarathree().length() > 0) {
                    wordbdetail.put("root", SpannableStringBuilder.valueOf(corpusSurahWord.get(0).getRootarathree()));
                } else if (corpusSurahWord.get(0).getRootarafour().length() > 0) {
                    wordbdetail.put("root", SpannableStringBuilder.valueOf(corpusSurahWord.get(0).getRootarafour()));
                } else if (corpusSurahWord.get(0).getRootarafive().length() > 0) {
                    wordbdetail.put("root", SpannableStringBuilder.valueOf(corpusSurahWord.get(0).getRootarafive()));

                }

            }

        }
    }

    private void GetLemmArabicwordWordDetails
            (ArrayList<NewCorpusExpandWbwPOJO> corpusSurahWord, HashMap<String, SpannableStringBuilder> wordbdetail) {
        String tagone = corpusSurahWord.get(0).getTagone();
        String tagtwo = corpusSurahWord.get(0).getTagtwo();
        String tagthree = corpusSurahWord.get(0).getTagthree();
        String tagfour = corpusSurahWord.get(0).getTagfour();
        String tagfive = corpusSurahWord.get(0).getTagfive();
        String araone = corpusSurahWord.get(0).getAraone();
        String aratwo = corpusSurahWord.get(0).getAratwo();
        String arathree = corpusSurahWord.get(0).getArathree();
        String arafour = corpusSurahWord.get(0).getArafour();
        String arafive = corpusSurahWord.get(0).getArafive();
        if (corpusSurahWord.get(0).getWordcount() == 1) {
            //noun yelllo
            //verb cyan
            //
            int one = corpusSurahWord.get(0).getAraone().length();//2
            String expandTagsone = expandTags(tagone);
            wordbdetail.put("lemma", SpannableStringBuilder.valueOf(corpusSurahWord.get(0).getLemaraone()));


            SpannableString spannableString = CorpusUtilityorig.NewSetWordSpan(tagone, "", "", "", "", araone, "", "", "", "");
            SpannableString tagspannables = CorpusUtilityorig.NewSetWordSpanTag(tagone, "", "", "", "", araone, "", "", "", expandTagsone);
            wordbdetail.put("word", SpannableStringBuilder.valueOf(spannableString));
            wordbdetail.put("worddetails", SpannableStringBuilder.valueOf(tagspannables));


            if (corpusSurahWord.get(0).getDetailsone().contains("SP:kaAn")) {
                wordbdetail.put("spkana", SpannableStringBuilder.valueOf("spkana"));
            }

        } else if (corpusSurahWord.get(0).getWordcount() == 2) {
            wordbdetail.put("lemma", SpannableStringBuilder.valueOf(corpusSurahWord.get(0).getLemaraone() + corpusSurahWord.get(0).getLemaratwo()));
            SpannableStringBuilder arabicspannable = new SpannableStringBuilder(araone + aratwo
            );
            String expandTagsone = expandTags(tagone);
            String expandTagstwo = expandTags(tagtwo);
            if (corpusSurahWord.get(0).getDetailsone().contains("SP:kaAn")) {
                wordbdetail.put("spkana", SpannableStringBuilder.valueOf("spkana"));
            } else if (corpusSurahWord.get(0).getDetailstwo().contains("SP:kaAn")) {
                wordbdetail.put("spkana", SpannableStringBuilder.valueOf("spkana"));
            }
            int one = corpusSurahWord.get(0).getAraone().length();//2
            int two = corpusSurahWord.get(0).getAratwo().length();//3
            int secondend = one + two;
            int twotag = expandTagsone.length();//1
            int onetag = expandTagstwo.length();//3
            SpannableString spannableString = CorpusUtilityorig.NewSetWordSpan(tagone, tagtwo, "", "", "", araone, aratwo, "", "", "");
            SpannableString tagspannables = CorpusUtilityorig.NewSetWordSpanTag(tagone, tagtwo, "", "", "", araone, aratwo, "", expandTagstwo, expandTagsone);
            wordbdetail.put("word", SpannableStringBuilder.valueOf(spannableString));
            wordbdetail.put("worddetails", SpannableStringBuilder.valueOf(tagspannables));

        } else if (corpusSurahWord.get(0).getWordcount() == 3) {
            StringBuilder sb = new StringBuilder();
            wordbdetail.put("lemma", SpannableStringBuilder.valueOf(corpusSurahWord.get(0).getLemaraone() + corpusSurahWord.get(0).getLemaratwo() +
                    corpusSurahWord.get(0).getLemrathree()));
            int one = corpusSurahWord.get(0).getAraone().length();//2
            int two = corpusSurahWord.get(0).getAratwo().length();//3
            int three = corpusSurahWord.get(0).getArathree().length();//10
            int secondend = one + two;
            int thirdstart = one + two;
            String expandTagsone = expandTags(corpusSurahWord.get(0).getTagone());
            String expandTagstwo = expandTags(corpusSurahWord.get(0).getTagtwo());
            String expandTagsthree = expandTags(corpusSurahWord.get(0).getTagthree());
            sb.append(corpusSurahWord.get(0).getTagthree());
            sb.append("|");
            sb.append(corpusSurahWord.get(0).getTagtwo());
            sb.append("|");
            sb.append(corpusSurahWord.get(0).getTagone());
            // 0,tagthree
            // tagthree,tagtwo
            // tagtwo,tagone
            SpannableString spannableString = CorpusUtilityorig.NewSetWordSpan(tagone, tagtwo, tagthree, "", "", araone, aratwo, arathree, "", "");
            SpannableString tagspannables = CorpusUtilityorig.NewSetWordSpanTag(tagone, tagtwo, tagthree, "", "", " ", " ", expandTagsthree, expandTagstwo, expandTagsone);
            wordbdetail.put("word", SpannableStringBuilder.valueOf(spannableString));
            wordbdetail.put("worddetails", SpannableStringBuilder.valueOf(tagspannables));
            if (corpusSurahWord.get(0).getDetailsone().contains("SP:kaAn")) {
                wordbdetail.put("spkana", SpannableStringBuilder.valueOf("spkana"));
            } else if (corpusSurahWord.get(0).getDetailstwo().contains("SP:kaAn")) {
                wordbdetail.put("spkana", SpannableStringBuilder.valueOf("spkana"));
            } else if (corpusSurahWord.get(0).getDetailsthree().contains("SP:kaAn")) {
                wordbdetail.put("spkana", SpannableStringBuilder.valueOf("spkana"));
            }

        } else if (corpusSurahWord.get(0).
                getWordcount() == 4) {
            wordbdetail.put("lemma", SpannableStringBuilder.valueOf(corpusSurahWord.get(0).getLemaraone() + corpusSurahWord.get(0).getLemaratwo() +
                    corpusSurahWord.get(0).getLemrathree()));
            int one = corpusSurahWord.get(0).getAraone().length();//2
            int two = corpusSurahWord.get(0).getAratwo().length();//3

            int onetag = corpusSurahWord.get(0).getTagone().length();//1
            int twotag = corpusSurahWord.get(0).getTagtwo().length();//3
            int threetag = corpusSurahWord.get(0).getTagthree().length();//1
            int thirdstart = one + two;

            int thirdstarttag = onetag + twotag + 1;

            String expandTagsone = expandTags(corpusSurahWord.get(0).getTagone());
            String expandTagstwo = expandTags(corpusSurahWord.get(0).getTagtwo());
            String expandTagsthree = expandTags(corpusSurahWord.get(0).getTagthree());
            String expandTagsfour = expandTags(corpusSurahWord.get(0).getTagfour());
            SpannableString spannableString = CorpusUtilityorig.NewSetWordSpan(tagone, tagtwo, tagthree, tagfour, "", araone, aratwo, arathree, arafour, "");
            // SpannableString tagspannables = CorpusUtilityorig.NewSetWordSpanTag(tagone, tagtwo, tagthree, tagfour, tagfive," ", expandTagsfour, expandTagsthree, expandTagstwo, expandTagsone);
            SpannableString tagspannables = CorpusUtilityorig.NewSetWordSpanTag(tagone, tagtwo, tagthree,
                    tagfour, tagfive, " ", expandTagsfour, expandTagsthree, expandTagstwo, expandTagsone);
            wordbdetail.put("word", SpannableStringBuilder.valueOf(spannableString));
            wordbdetail.put("worddetails", SpannableStringBuilder.valueOf(tagspannables));
            if (corpusSurahWord.get(0).getDetailsone().contains("SP:kaAn")) {
                wordbdetail.put("spkana", SpannableStringBuilder.valueOf("spkana"));
            } else if (corpusSurahWord.get(0).getDetailstwo().contains("SP:kaAn")) {
                wordbdetail.put("spkana", SpannableStringBuilder.valueOf("spkana"));
            } else if (corpusSurahWord.get(0).getDetailsthree().contains("SP:kaAn")) {
                wordbdetail.put("spkana", SpannableStringBuilder.valueOf("spkana"));
            } else if (corpusSurahWord.get(0).getDetailsfour().contains("SP:kaAn")) {
                wordbdetail.put("spkana", SpannableStringBuilder.valueOf("spkana"));
            }

        } else if (corpusSurahWord.get(0).
                getWordcount() == 5) {
            String expandTagsone = expandTags(corpusSurahWord.get(0).getTagone());
            String expandTagstwo = expandTags(corpusSurahWord.get(0).getTagtwo());
            String expandTagsthree = expandTags(corpusSurahWord.get(0).getTagthree());
            String expandTagsfour = expandTags(corpusSurahWord.get(0).getTagfour());
            String expandTagsfive = expandTags(corpusSurahWord.get(0).getTagfive());
            StringBuilder sb = new StringBuilder();
            wordbdetail.put("lemma", SpannableStringBuilder.valueOf(corpusSurahWord.get(0).getLemaraone() + corpusSurahWord.get(0).getLemaratwo() +
                    corpusSurahWord.get(0).getLemrathree() + corpusSurahWord.get(0).getLemarafour() + corpusSurahWord.get(0).getLemarafive()));
            SpannableString tagspannables = CorpusUtilityorig.NewSetWordSpanTag(tagone, tagtwo, tagthree,
                    tagfour, tagfive, expandTagsfive, expandTagsfour, expandTagsthree, expandTagstwo, expandTagsone);
            sb.append(corpusSurahWord.get(0).getTagfive());
            sb.append("|");
            sb.append(corpusSurahWord.get(0).getTagfour());
            sb.append("|");
            sb.append(corpusSurahWord.get(0).getTagthree());
            sb.append("|");
            sb.append(corpusSurahWord.get(0).getTagtwo());
            sb.append("|");
            sb.append(corpusSurahWord.get(0).getTagone());
            wordbdetail.put("word", SpannableStringBuilder.valueOf(corpusSurahWord.get(0).getAraone() + corpusSurahWord.get(0).getAratwo() +
                    corpusSurahWord.get(0).getArathree() + corpusSurahWord.get(0).getArafour() + corpusSurahWord.get(0).getTagfive()));
         //   wordbdetail.put("worddetails", SpannableStringBuilder.valueOf(sb));
            wordbdetail.put("worddetails", SpannableStringBuilder.valueOf(tagspannables));
            if (corpusSurahWord.get(0).getDetailsone().contains("SP:kaAn")) {
                wordbdetail.put("spkana", SpannableStringBuilder.valueOf("spkana"));
            } else if (corpusSurahWord.get(0).getDetailstwo().contains("SP:kaAn")) {
                wordbdetail.put("spkana", SpannableStringBuilder.valueOf("spkana"));
            } else if (corpusSurahWord.get(0).getDetailsthree().contains("SP:kaAn")) {
                wordbdetail.put("spkana", SpannableStringBuilder.valueOf("spkana"));
            } else if (corpusSurahWord.get(0).getDetailsfour().contains("SP:kaAn")) {
                wordbdetail.put("spkana", SpannableStringBuilder.valueOf("spkana"));
            } else if (corpusSurahWord.get(0).getDetailsfive().contains("SP:kaAn")) {
                wordbdetail.put("spkana", SpannableStringBuilder.valueOf("spkana"));
            }

        }

    }

    private void GetPronounDetails
            (ArrayList<NewCorpusExpandWbwPOJO> corpusSurahWord, HashMap<String, SpannableStringBuilder> wordbdetail) {
        if (corpusSurahWord.get(0).getWordcount() == 1) {
            if (corpusSurahWord.get(0).getTagone().equals("PRON")) {
                //   String[] parts = corpusSurahWord.get(0).getDetailsone().toString().split("\"|");
                String gendernumber = corpusSurahWord.get(0).getDetailsone().replaceAll("^.*?(\\w+)\\W*$", "$1");
                System.out.println(gendernumber);
                // String gendernumber = parts[parts.length - 1];
                StringBuilder builder = getGenderNumberdetails(gendernumber);
                wordbdetail.put("PRON", SpannableStringBuilder.valueOf(builder));

            }
        } else if (corpusSurahWord.get(0).getWordcount() == 2) {
            if (corpusSurahWord.get(0).getTagtwo().equals("PRON")) {
                String gendernumber = corpusSurahWord.get(0).getDetailstwo().replaceAll("^.*?(\\w+)\\W*$", "$1");
                //   String gendernumber = parts[parts.length - 1];
                StringBuilder builder = getGenderNumberdetails(gendernumber);
                wordbdetail.put("PRON", SpannableStringBuilder.valueOf(builder));

            }
        } else if (corpusSurahWord.get(0).getWordcount() == 3) {
            if (corpusSurahWord.get(0).getTagthree().equals("PRON")) {
                //   String[] parts = corpusSurahWord.get(0).getDetailsthree().toString().split("|");
                String gendernumber = corpusSurahWord.get(0).getDetailsthree().replaceAll("^.*?(\\w+)\\W*$", "$1");
                //    String gendernumber = parts[parts.length - 1];
                StringBuilder builder = getGenderNumberdetails(gendernumber);
                wordbdetail.put("PRON", SpannableStringBuilder.valueOf(builder));

            }
        } else if (corpusSurahWord.get(0).getWordcount() == 4) {
            if (corpusSurahWord.get(0).getTagfour().equals("PRON")) {
                String[] parts = corpusSurahWord.get(0).getDetailsfour().split("\\|");
                String gendernumber = parts[parts.length - 1];
                StringBuilder builder = getGenderNumberdetails(gendernumber);
                wordbdetail.put("PRON", SpannableStringBuilder.valueOf(builder));

            }
        } else if (corpusSurahWord.get(0).getWordcount() == 5) {
            if (corpusSurahWord.get(0).getTagfive().equals("PRON")) {
                String[] parts = corpusSurahWord.get(0).getDetailsfive().split("\\|");
                String gendernumber = parts[parts.length - 1];
                StringBuilder builder = getGenderNumberdetails(gendernumber);
                wordbdetail.put("PRON", SpannableStringBuilder.valueOf(builder));

            }
        }
    }

    private void GetHarfDetail
            (ArrayList<NewCorpusExpandWbwPOJO> corpusSurahWord, HashMap<String, SpannableStringBuilder> wordbdetail) {
        if (corpusSurahWord.get(0).getWordcount() == 1) {
            if (corpusSurahWord.get(0).getTagone().equals("PRON")) {
                //   String[] parts = corpusSurahWord.get(0).getDetailsone().toString().split("\"|");
                String gendernumber = corpusSurahWord.get(0).getDetailsone().replaceAll("^.*?(\\w+)\\W*$", "$1");
                System.out.println(gendernumber);
                // String gendernumber = parts[parts.length - 1];
                StringBuilder builder = getGenderNumberdetails(gendernumber);
                wordbdetail.put("PRON", SpannableStringBuilder.valueOf(builder));

            }
        } else if (corpusSurahWord.get(0).getWordcount() == 2) {
            if (corpusSurahWord.get(0).getTagtwo().equals("PRON")) {
                String gendernumber = corpusSurahWord.get(0).getDetailstwo().replaceAll("^.*?(\\w+)\\W*$", "$1");
                //   String gendernumber = parts[parts.length - 1];
                StringBuilder builder = getGenderNumberdetails(gendernumber);
                wordbdetail.put("PRON", SpannableStringBuilder.valueOf(builder));

            }
        } else if (corpusSurahWord.get(0).getWordcount() == 3) {
            if (corpusSurahWord.get(0).getTagthree().equals("PRON")) {
                //   String[] parts = corpusSurahWord.get(0).getDetailsthree().toString().split("|");
                String gendernumber = corpusSurahWord.get(0).getDetailsthree().replaceAll("^.*?(\\w+)\\W*$", "$1");
                //    String gendernumber = parts[parts.length - 1];
                StringBuilder builder = getGenderNumberdetails(gendernumber);
                wordbdetail.put("PRON", SpannableStringBuilder.valueOf(builder));

            }
        } else if (corpusSurahWord.get(0).getWordcount() == 4) {
            if (corpusSurahWord.get(0).getTagfour().equals("PRON")) {
                String[] parts = corpusSurahWord.get(0).getDetailsfour().split("\\|");
                String gendernumber = parts[parts.length - 1];
                StringBuilder builder = getGenderNumberdetails(gendernumber);
                wordbdetail.put("PRON", SpannableStringBuilder.valueOf(builder));

            }
        } else if (corpusSurahWord.get(0).getWordcount() == 5) {
            if (corpusSurahWord.get(0).getTagfive().equals("PRON")) {
                String[] parts = corpusSurahWord.get(0).getDetailsfive().split("\\|");
                String gendernumber = parts[parts.length - 1];
                StringBuilder builder = getGenderNumberdetails(gendernumber);
                wordbdetail.put("PRON", SpannableStringBuilder.valueOf(builder));

            }
        }
    }

}



