package com.example.mushafconsolidated.fragments;

import static com.example.utility.CorpusConstants.verbfeaturesenglisharabic.IMPF;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

import com.example.mushafconsolidated.Entities.NewCorpusExpandWbwPOJO;
import com.example.mushafconsolidated.Entities.NounCorpus;
import com.example.mushafconsolidated.Entities.VerbCorpus;
import com.example.utility.CorpusConstants;

import java.util.ArrayList;
import java.util.HashMap;

public class SentenceQuranMorphologyDetails extends QuranMorphologyDetails {
    private final Context context;
    int form = 0;
    String Thulathi;
    private final int index;
    private final ArrayList<NounCorpus> corpusNoun;
    private int indigo, cyan, yellow, green;
    private final ArrayList<NewCorpusExpandWbwPOJO> corpusSurahWord;
    private final ArrayList<VerbCorpus> verbcorpusform;

    public SentenceQuranMorphologyDetails(int index,
                                          ArrayList<NewCorpusExpandWbwPOJO> corpusSurahWord,
                                          ArrayList<NounCorpus> corpusNounWord, ArrayList<VerbCorpus> verbCorpuses,
                                          Context context) {
        super();
        this.index = index - 1;
        this.corpusSurahWord = corpusSurahWord;
        this.verbcorpusform = verbCorpuses;
        this.corpusNoun = corpusNounWord;
        this.context = context;

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
        vbdetail.put("surahid", String.valueOf(verbcorpusform.get(index).getChapterno()));
        vbdetail.put("ayahid", String.valueOf(verbcorpusform.get(index).getVerseno()));
        vbdetail.put("wordno", String.valueOf(verbcorpusform.get(index).getWordno()));
        String roots;
        roots = getVerbRoot();
        roots = getVerbCorpusRoot();
        vbdetail.put("root", roots);
        if (verbcorpusform.size() > 0) {
            if (!verbcorpusform.get(index).getForm().equals("I")) {
                String mform = verbcorpusform.get(index).getForm();
                convertForms(mform);
                vbdetail.put("form", String.valueOf(getForm()));
                vbdetail.put("wazan", "null");
                //    setSarfSagheer(true);
                //  mazeedQuery = sm.getMazeedQuery(roots, getForm());
            } else {
                String thulathibab = verbcorpusform.get(index).getThulathibab();
                if (thulathibab.length() == 0)
                    vbdetail.put("thulathi", "null");
                else if (thulathibab.length() == 1) {
                    String s = verbcorpusform.get(index).getThulathibab();
                    final StringBuilder sb = getThulathiName(s);
                    vbdetail.put("thulathi", sb.toString());
                    vbdetail.put("wazan", thulathibab);
                    vbdetail.put("form", "null");

                } else if (thulathibab.length() > 1) {
                    String s = thulathibab.substring(0, 1);
                    final StringBuilder sb = getThulathiName(s);
                    vbdetail.put("thulathi", sb.toString());
                    vbdetail.put("wazan", s);

                }

            }
        }
        String gendernumber = verbcorpusform.get(index).getGendernumber();
        StringBuilder pngsb = getGenderNumberdetails(gendernumber);
        if (vbdetail.get("form") != null) {
            String formdetails = getFormName(verbcorpusform.get(index).getForm());
            pngsb.append("," + "(form").append(formdetails);
            //     pngsb.append("," + "(form").append(verbcorpusform.get(index).getForm()).append(")");
            vbdetail.put("png", pngsb.toString());
        } else {
            vbdetail.put("png", null);
            //    pngsb.append(",").append(verbcorpusform.get(index).getThulathibab());
        }
        vbdetail.put("png", pngsb.toString());
        String tense = verbcorpusform.get(index).getTense();
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
        String voice = verbcorpusform.get(index).getVoice();
        switch (voice) {
            case "ACT":
                vbdetail.put("voice", CorpusConstants.verbfeaturesenglisharabic.ACT);
                break;
            case "PASS":
                vbdetail.put("voice", CorpusConstants.verbfeaturesenglisharabic.PASS);
                break;

        }
        if (roots.equals("كون")) {
            String kana_mood = verbcorpusform.get(index).getKana_mood();
            switch (kana_mood) {
                case "MOOD:SUBJ":
                    vbdetail.put("mood", CorpusConstants.verbfeaturesenglisharabic.IND);
                    vbdetail.put("verbmood", "Indicative");
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
            String mood = verbcorpusform.get(index).getMood_kananumbers();
            switch (mood) {
                case "IND":
                    vbdetail.put("mood", CorpusConstants.verbfeaturesenglisharabic.IND);
                    vbdetail.put("verbmood", "Indicative");
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
        vbdetail.put("lemma", verbcorpusform.get(index).getLemma_a());
        return vbdetail;
    }

    private String getVerbCorpusRoot() {
        String roots = null;
        roots = verbcorpusform.get(index).getRoot_a();
        return roots;
    }

    private String getVerbRoot() {
        String roots = null;
        if (corpusSurahWord.get(index).getWordcount() == 1) {
            if (corpusSurahWord.get(index).getTagone().equals("V")) {
                roots = corpusSurahWord.get(index).getRoot_a();
            }
        } else if (corpusSurahWord.get(index).getWordcount() == 2) {
            if (corpusSurahWord.get(index).getTagone().equals("V")) {
                roots = corpusSurahWord.get(index).getRootaraone();
            } else if (corpusSurahWord.get(index).getTagtwo().equals("V")) {
                roots = corpusSurahWord.get(index).getRootaratwo();
            }
        } else if (corpusSurahWord.get(index).getWordcount() == 3) {
            if (corpusSurahWord.get(index).getTagone().equals("V")) {
                roots = corpusSurahWord.get(index).getRootaraone();
            } else if (corpusSurahWord.get(index).getTagtwo().equals("V")) {
                roots = corpusSurahWord.get(index).getRootaratwo();
            } else if (corpusSurahWord.get(index).getTagthree().equals("V")) {
                roots = corpusSurahWord.get(index).getRootarathree();

            }

        } else if (corpusSurahWord.get(index).getWordcount() == 4) {
            if (corpusSurahWord.get(index).getTagone().equals("V")) {
                roots = corpusSurahWord.get(index).getRootaraone();
            } else if (corpusSurahWord.get(index).getTagtwo().equals("V")) {
                roots = corpusSurahWord.get(index).getRootaratwo();
            } else if (corpusSurahWord.get(index).getTagthree().equals("V")) {
                roots = corpusSurahWord.get(index).getRootarathree();

            } else if (corpusSurahWord.get(index).getTagfour().equals("V")) {
                roots = corpusSurahWord.get(index).getRootarafour();

            }

        } else if (corpusSurahWord.get(index).getWordcount() == 5) {
            if (corpusSurahWord.get(index).getTagone().equals("V")) {
                roots = corpusSurahWord.get(index).getRootaraone();
            } else if (corpusSurahWord.get(index).getTagtwo().equals("V")) {
                roots = corpusSurahWord.get(index).getRootaratwo();
            } else if (corpusSurahWord.get(index).getTagthree().equals("V")) {
                roots = corpusSurahWord.get(index).getRootarathree();

            } else if (corpusSurahWord.get(index).getTagfour().equals("V")) {
                roots = corpusSurahWord.get(index).getRootarafour();

            } else if (corpusSurahWord.get(index).getTagfive().equals("V")) {
                roots = corpusSurahWord.get(index).getRootarafive();
            }

        }
        return roots;
    }

    HashMap<String, SpannableStringBuilder> getNoundetails() {
        HashMap<String, SpannableStringBuilder> wordbdetail = new HashMap<>();
        StringBuilder sb = new StringBuilder();

      /*
        if (corpusNoun.size() > 0) {
            if (corpusNoun.get(index).getProptwo().equals(CorpusConstants.NominalsProp.PCPL)) {
                String form = corpusNoun.get(index).getForm();


                final String mform = form.replaceAll("\\(|\\)", "");

                //   String mform = corpusNoun.get(0).getForm();

                if (!mform.equals("I")) {
                    convertForms(mform);
                    wordbdetail.put("form", SpannableStringBuilder.valueOf(String.valueOf(getForm())));

                    getRoot(corpusSurahWord, wordbdetail);
                } else {
                    if (corpusNoun.get(index).getProptwo().equals("PCPL")) {
                        wordbdetail.put("PCPL", SpannableStringBuilder.valueOf(corpusNoun.get(index).getPropone().concat(corpusNoun.get(index).getProptwo())));
                    } else {
                        wordbdetail.put("PCPL", SpannableStringBuilder.valueOf("NONE"));
                    }


                }

            }
        }
       */
        if (corpusNoun.size() > 0) {
            if (corpusNoun.get(index).getProptwo().equals(CorpusConstants.NominalsProp.PCPL)) {
                String form = corpusNoun.get(index).getForm();
                //   String form = corpusNoun.get(0).getForm();
                final String mform = form.replaceAll("\\(|\\)", "");
                //   String mform = corpusNoun.get(0).getForm();
                wordbdetail.put("PART", SpannableStringBuilder.valueOf("PCPL"));
                if (mform.equals("I")) {
                    wordbdetail.put("form", SpannableStringBuilder.valueOf(form));

                }
                if (!mform.equals("I")) {
                    if (!mform.equals("null")) {
                        convertForms(mform);
                        wordbdetail.put("form", SpannableStringBuilder.valueOf(String.valueOf(getForm())));
                        getRoot(corpusSurahWord, wordbdetail);
                    }
                } else {
                    if (corpusNoun.get(index).getProptwo().equals("PCPL")) {
                        wordbdetail.put("PCPL", SpannableStringBuilder.valueOf(corpusNoun.get(index).getPropone().concat(corpusNoun.get(index).getProptwo())));
                        wordbdetail.put("PART", SpannableStringBuilder.valueOf("PCPL"));
                        wordbdetail.put("particple", SpannableStringBuilder.valueOf("PART"));
                        wordbdetail.put("form", SpannableStringBuilder.valueOf("I"));
                    } else {
                        wordbdetail.put("PART", SpannableStringBuilder.valueOf("NONE"));
                        wordbdetail.put("particple", SpannableStringBuilder.valueOf("PART"));
                        wordbdetail.put("form", SpannableStringBuilder.valueOf("I"));
                    }

                }

            }
        }
        if (corpusNoun.size() > 0) {
            if (corpusNoun.get(index).getTag().equals("N")) {
                String propone = corpusNoun.get(index).getPropone();
                String proptwo = corpusNoun.get(index).getProptwo();
                String pcpl = "";
                if (!propone.equals("null") && !proptwo.equals("null")) {
                    pcpl = pcpl.concat(propone + proptwo);
                }
                String form = corpusNoun.get(index).getForm();
                String gendernumber = corpusNoun.get(index).getGendernumber();
                String type = corpusNoun.get(index).getType();
                String cases = corpusNoun.get(index).getCases();
                sb.append("Noun:");
                if (!cases.equals("null")) {
                    switch (cases) {
                        case "NOM":
                            sb.append(CorpusConstants.NominalsProp.NOM + " ");
                            break;
                        case "ACC":
                            sb.append(CorpusConstants.NominalsProp.ACC + " ");
                            break;
                        case "GEN":
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
                    sb.append("(form").append(form).append(")");
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
        getProperNounDetails(corpusNoun, wordbdetail, sb);
        return wordbdetail;
    }

    public HashMap<String, SpannableStringBuilder> getWordDetails() {
        HashMap<String, SpannableStringBuilder> wordbdetail = new HashMap<>();
        int surah = corpusSurahWord.get(index).getSurah();
        wordbdetail.put("surahid", SpannableStringBuilder.valueOf(String.valueOf(corpusSurahWord.get(index).getSurah())));
        wordbdetail.put("ayahid", SpannableStringBuilder.valueOf(String.valueOf(corpusSurahWord.get(index).getAyah())));
        wordbdetail.put("wordno", SpannableStringBuilder.valueOf(String.valueOf(corpusSurahWord.get(index).getWordno())));
        wordbdetail.put("wordtranslation", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getEn()));
        String arabicword = corpusSurahWord.get(index).getAraone().concat(corpusSurahWord.get(index).getAratwo().concat(corpusSurahWord.get(index).getArathree()
                .concat(corpusSurahWord.get(index).getArafour().concat(corpusSurahWord.get(index).getArafour()))));
        if (corpusNoun.size() > 0) {
            if (corpusNoun.get(0).getProptwo().equals(CorpusConstants.NominalsProp.PCPL)) {
                String form = corpusNoun.get(0).getForm();
                final String mform = form.replaceAll("\\(|\\)", "");
                //   String mform = corpusNoun.get(0).getForm();
                if (!mform.equals("I")) {
                    convertForms(mform);
                    wordbdetail.put("form", SpannableStringBuilder.valueOf(String.valueOf(getForm())));
                    getRoot(corpusSurahWord, wordbdetail);
                } else {
                    if (corpusNoun.get(0).getProptwo().equals("PCPL")) {
                        wordbdetail.put("PCPL", SpannableStringBuilder.valueOf(corpusNoun.get(0).getPropone().concat(corpusNoun.get(0).getProptwo())));
                        wordbdetail.put("particple", SpannableStringBuilder.valueOf("PART"));
                    } else {
                        wordbdetail.put("PCPL", SpannableStringBuilder.valueOf("NONE"));
                        wordbdetail.put("particple", SpannableStringBuilder.valueOf("PART"));
                    }

                }

            }
        }
        int size = corpusNoun.size();
        int corpousindex = 0;
        GetPronounDetails(corpusSurahWord, wordbdetail);
        GetLemmArabicwordWordDetails(corpusSurahWord, wordbdetail);
        StringBuilder sb = new StringBuilder();
        //get the root,since vercopus is not checked
        getRoot(corpusSurahWord, wordbdetail);
        // getProperNounDetails(corpusNoun, wordbdetail, sb);
        return wordbdetail;
    }

    private void getProperNounDetails(ArrayList<NounCorpus> corpusNoun, HashMap<String, SpannableStringBuilder> wordbdetail, StringBuilder sb) {
        if (corpusNoun.size() > 0) {
            if (corpusNoun.get(index).getTag().equals("PN") || corpusNoun.get(index).getTag().equals("ADJ")) {
                String propone = corpusNoun.get(index).getPropone();
                String proptwo = corpusNoun.get(index).getProptwo();
                String pcpl = "";
                if (!propone.equals("null") && !proptwo.equals("null")) {
                    pcpl = pcpl.concat(propone + proptwo);
                }
                if (corpusNoun.get(index).getPropone().equals("VN")) {
                    sb.append("Proper/Verbal Noun");
                } else if (corpusNoun.get(index).getTag().equals("ADJ")) {
                    sb.append("Adjective:");

                } else {
                    sb.append("Proper Noun:");
                }
                String form = corpusNoun.get(index).getForm();
                String gendernumber = corpusNoun.get(index).getGendernumber();
                String type = corpusNoun.get(index).getType();
                String cases = corpusNoun.get(index).getCases();
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
            }
        }
    }

    private void getRoot(ArrayList<NewCorpusExpandWbwPOJO> corpusSurahWord, HashMap<String, SpannableStringBuilder> wordbdetail) {
        int wordno = corpusSurahWord.get(index).getWordno();
        for (VerbCorpus verb : verbcorpusform) {
            if (verb.getWordno() == wordno && (verb.getVoice().equals("ACTI") || verb.getVoice().equals("PASS"))) {
                if (!verb.getForm().equals("I")) {
                    String mform = verb.getForm();
                    convertForms(mform);
                    wordbdetail.put("form", SpannableStringBuilder.valueOf(String.valueOf(getForm())));
                    wordbdetail.put("wazan", SpannableStringBuilder.valueOf("null"));
                    //    setSarfSagheer(true);
                    //  mazeedQuery = sm.getMazeedQuery(roots, getForm());
                } else {
                    String thulathibab = verb.getThulathibab();
                    if (thulathibab.length() == 0)
                        wordbdetail.put("thulathi", null);
                    else if (thulathibab.length() == 1) {
                        String s = verb.getThulathibab();
                        final StringBuilder sb = getThulathiName(s);
                        wordbdetail.put("thulathi", SpannableStringBuilder.valueOf(sb.toString()));
                        wordbdetail.put("wazan", SpannableStringBuilder.valueOf(thulathibab));
                        wordbdetail.put("form", SpannableStringBuilder.valueOf("null"));

                    } else if (thulathibab.length() > 1) {
                        String s = thulathibab.substring(0, 1);
                        final StringBuilder sb = getThulathiName(s);
                        wordbdetail.put("thulathi", SpannableStringBuilder.valueOf(sb.toString()));
                        wordbdetail.put("wazan", SpannableStringBuilder.valueOf(s));
                        wordbdetail.put("form", SpannableStringBuilder.valueOf("null"));
                    }

                }
                String gendernumber = verb.getGendernumber();
                StringBuilder pngsb = getGenderNumberdetails(gendernumber);
                if (wordbdetail.get("form") != null) {
                    String formdetails = verb.getForm();
                    pngsb.append("," + "(form").append(formdetails);
                    //     pngsb.append("," + "(form").append(verbcorpusform.get(index).getForm()).append(")");
                    wordbdetail.put("png", SpannableStringBuilder.valueOf(pngsb.toString()));
                } else {
                    wordbdetail.put("png", null);
                    //    pngsb.append(",").append(verbcorpusform.get(index).getThulathibab());
                }
                wordbdetail.put("png", SpannableStringBuilder.valueOf(pngsb.toString()));
                String tense = verb.getTense();
                switch (tense) {
                    case "IMPF":
                        wordbdetail.put("tense", SpannableStringBuilder.valueOf(IMPF));
                        break;
                    case "IMPV":
                        wordbdetail.put("tense", SpannableStringBuilder.valueOf(CorpusConstants.verbfeaturesenglisharabic.IMPV));
                        break;
                    case "PERF":
                        wordbdetail.put("tense", SpannableStringBuilder.valueOf(CorpusConstants.verbfeaturesenglisharabic.PERF));
                        break;

                }
                String voice = verb.getVoice();
                switch (voice) {
                    case "ACT":
                        wordbdetail.put("voice", SpannableStringBuilder.valueOf(CorpusConstants.verbfeaturesenglisharabic.ACT));
                        break;
                    case "PASS":
                        wordbdetail.put("voice", SpannableStringBuilder.valueOf(CorpusConstants.verbfeaturesenglisharabic.PASS));
                        break;

                }
                String mood = verb.getMood_kananumbers();
                switch (mood) {
                    case "IND":
                        wordbdetail.put("mood", SpannableStringBuilder.valueOf(CorpusConstants.verbfeaturesenglisharabic.IND));
                        break;
                    case "JUS":
                        wordbdetail.put("mood", SpannableStringBuilder.valueOf(CorpusConstants.verbfeaturesenglisharabic.JUS));
                        break;
                    case "SUBJ":
                        wordbdetail.put("mood", SpannableStringBuilder.valueOf(CorpusConstants.verbfeaturesenglisharabic.SUBJ));
                        break;
                }
                wordbdetail.put("lemma", SpannableStringBuilder.valueOf(verb.getLemma_a()));
                wordbdetail.put("root", SpannableStringBuilder.valueOf(verb.getRoot_a()));
                //   wordbdetail.put("form", SpannableStringBuilder.valueOf(verb.getForm() ));
                //  wordbdetail.put("wazan", SpannableStringBuilder.valueOf(verb.getThulathibab() ));
            }
        }
        if (corpusSurahWord.size() > 0) {
            if (corpusSurahWord.get(index).getWordcount() == 1) {
                if (corpusSurahWord.get(index).getRootaraone().length() > 0) {
                    wordbdetail.put("tag", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getTagone()));
                    wordbdetail.put("root", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getRootaraone()));

                } else {
                    wordbdetail.put("tag", SpannableStringBuilder.valueOf("none"));

                }

            } else if (corpusSurahWord.get(index).getWordcount() == 2) {
                if (corpusSurahWord.get(index).getRootaraone().length() > 0) {
                    wordbdetail.put("tag", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getTagone()));
                    wordbdetail.put("root", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getRootaraone()));
                } else if (corpusSurahWord.get(index).getRootaratwo().length() > 0) {
                    wordbdetail.put("root", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getRootaratwo()));
                    wordbdetail.put("tag", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getTagtwo()));
                } else {
                    wordbdetail.put("tag", SpannableStringBuilder.valueOf("none"));
                }

            } else if (corpusSurahWord.get(index).getWordcount() == 3) {
                if (corpusSurahWord.get(index).getRootaraone().length() > 0) {
                    wordbdetail.put("root", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getRootaraone()));
                    wordbdetail.put("tag", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getTagone()));
                } else if (corpusSurahWord.get(index).getRootaratwo().length() > 0) {
                    wordbdetail.put("root", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getRootaratwo()));
                    wordbdetail.put("tag", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getTagtwo()));
                } else if (corpusSurahWord.get(index).getRootarathree().length() > 0) {
                    wordbdetail.put("root", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getRootarathree()));
                    wordbdetail.put("tag", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getTagthree()));
                } else {
                    wordbdetail.put("tag", SpannableStringBuilder.valueOf("none"));
                }

            } else if (corpusSurahWord.get(index).getWordcount() == 4) {
                if (corpusSurahWord.get(index).getRootaraone().length() > 0) {
                    wordbdetail.put("root", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getRootaraone()));
                    wordbdetail.put("tag", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getTagone()));
                } else if (corpusSurahWord.get(index).getRootaratwo().length() > 0) {
                    wordbdetail.put("root", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getRootaratwo()));
                    wordbdetail.put("tag", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getTagtwo()));
                } else if (corpusSurahWord.get(index).getRootarathree().length() > 0) {
                    wordbdetail.put("root", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getRootarathree()));
                    wordbdetail.put("tag", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getTagthree()));
                } else if (corpusSurahWord.get(index).getRootarafour().length() > 0) {
                    wordbdetail.put("root", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getRootarafour()));
                    wordbdetail.put("tag", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getTagfour()));
                } else {
                    wordbdetail.put("tag", SpannableStringBuilder.valueOf("none"));
                }

            } else if (corpusSurahWord.get(index).getWordcount() == 5) {
                if (corpusSurahWord.get(index).getRootaraone().length() > 0) {
                    wordbdetail.put("root", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getRootaraone()));
                    wordbdetail.put("tag", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getTagone()));
                } else if (corpusSurahWord.get(index).getRootaratwo().length() > 0) {
                    wordbdetail.put("root", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getRootaratwo()));
                    wordbdetail.put("tag", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getTagtwo()));
                } else if (corpusSurahWord.get(index).getRootarathree().length() > 0) {
                    wordbdetail.put("tag", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getTagthree()));
                    wordbdetail.put("root", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getRootarathree()));
                } else if (corpusSurahWord.get(index).getRootarafour().length() > 0) {
                    wordbdetail.put("root", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getRootarafour()));
                    wordbdetail.put("tag", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getTagfour()));
                } else if (corpusSurahWord.get(index).getRootarafive().length() > 0) {
                    wordbdetail.put("root", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getRootarafive()));
                    wordbdetail.put("tag", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getTagfive()));
                } else {
                    wordbdetail.put("tag", SpannableStringBuilder.valueOf("none"));
                }

            } else {
                wordbdetail.put("tag", SpannableStringBuilder.valueOf("none"));
            }

        }

    }

    private void GetLemmArabicwordWordDetails
            (ArrayList<NewCorpusExpandWbwPOJO> corpusSurahWord, HashMap<String, SpannableStringBuilder> wordbdetail) {
        if (corpusSurahWord.get(index).getWordcount() == 1) {
            String tagone = corpusSurahWord.get(index).getTagone();
            String expandTagsone = expandTags(tagone);
            wordbdetail.put("lemma", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getLemaraone()));
            wordbdetail.put("word", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getAraone()));
            wordbdetail.put("worddetails", SpannableStringBuilder.valueOf(expandTagsone));

        } else if (corpusSurahWord.get(index).getWordcount() == 2) {
            wordbdetail.put("lemma", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getLemaraone() + corpusSurahWord.get(index).getLemaratwo()));
            final String araone = corpusSurahWord.get(index).getAraone();
            final String aratwo = corpusSurahWord.get(index).getAratwo();
            SpannableStringBuilder arabicspannable = new SpannableStringBuilder(araone + aratwo
            );
            String tagtwo = corpusSurahWord.get(index).getTagtwo();
            String tagone = corpusSurahWord.get(index).getTagone();
            String expandTagsone = expandTags(tagone);
            String expandTagstwo = expandTags(tagtwo);
            SpannableStringBuilder tagspannable = new SpannableStringBuilder(expandTagstwo + "|" +
                    expandTagsone);
            int one = corpusSurahWord.get(index).getAraone().length();//2
            int two = corpusSurahWord.get(index).getAratwo().length();//3
            int secondend = one + two;
            int twotag = expandTagsone.length();//1
            int onetag = expandTagstwo.length();//3
            int secondendtag = onetag + twotag;
            arabicspannable.setSpan(new ForegroundColorSpan(cyan), 0, one, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            arabicspannable.setSpan(new ForegroundColorSpan(yellow), one, secondend, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            tagspannable.setSpan(new ForegroundColorSpan(yellow), 0, onetag + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            tagspannable.setSpan(new ForegroundColorSpan(cyan), onetag + 1, secondendtag + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            wordbdetail.put("word", arabicspannable);
            wordbdetail.put("worddetails", tagspannable);

        } else if (corpusSurahWord.get(index).
                getWordcount() == 3) {
            StringBuilder sb = new StringBuilder();
            wordbdetail.put("lemma", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getLemaraone() + corpusSurahWord.get(index).getLemaratwo() +
                    corpusSurahWord.get(index).getLemrathree()));
            int one = corpusSurahWord.get(index).getAraone().length();//2
            int two = corpusSurahWord.get(index).getAratwo().length();//3
            int three = corpusSurahWord.get(index).getArathree().length();//10
            int secondend = one + two;
            int thirdstart = one + two;
            int thirdend = thirdstart + three;
            String expandTagsone = expandTags(corpusSurahWord.get(index).getTagone());
            String expandTagstwo = expandTags(corpusSurahWord.get(index).getTagtwo());
            String expandTagsthree = expandTags(corpusSurahWord.get(index).getTagthree());
            int tagone = expandTagsone.length();//4
            int tagtwo = expandTagstwo.length();//1
            int tagthree = expandTagsthree.length();//8
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(corpusSurahWord.get(index).getAraone() + corpusSurahWord.get(index).getAratwo()
                    + corpusSurahWord.get(index).getArathree());
            SpannableStringBuilder tagspannable = new SpannableStringBuilder(expandTagsthree + "|" +
                    expandTagstwo + "|"
                    + expandTagsone);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(cyan), 0, one, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(yellow), one, secondend, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(green), thirdstart, thirdend, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            sb.append(corpusSurahWord.get(index).getTagthree());
            sb.append("|");
            sb.append(corpusSurahWord.get(index).getTagtwo());
            sb.append("|");
            sb.append(corpusSurahWord.get(index).getTagone());
            // 0,tagthree
            // tagthree,tagtwo
            // tagtwo,tagone
/*

tagspannable.subSequence(0,tagthree+1)
tagspannable.subSequence(tagthree+1,tagthree+tagtwo+2)
tagspannable.subSequence(tagthree+tagtwo+2,tagthree+tagtwo+tagone+2)
 */
            tagspannable.setSpan(new ForegroundColorSpan(green), 0, tagthree + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            tagspannable.setSpan(new ForegroundColorSpan(yellow), tagthree + 1, tagthree + tagtwo + 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            tagspannable.setSpan(new ForegroundColorSpan(cyan), tagthree + tagtwo + 2, tagthree + tagtwo + tagone + 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            wordbdetail.put("word", spannableStringBuilder);
            //      wordbdetail.put("worddetails", sb.toString());
            wordbdetail.put("worddetails", tagspannable);

        } else if (corpusSurahWord.get(index).
                getWordcount() == 4) {
            StringBuilder sb = new StringBuilder();
            wordbdetail.put("lemma", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getLemaraone() + corpusSurahWord.get(index).getLemaratwo() +
                    corpusSurahWord.get(index).getLemrathree()));
            int one = corpusSurahWord.get(index).getAraone().length();//2
            int two = corpusSurahWord.get(index).getAratwo().length();//3
            int three = corpusSurahWord.get(index).getArathree().length();//5
            int four = corpusSurahWord.get(index).getArafour().length();//6
            int onetag = corpusSurahWord.get(index).getTagone().length();//1
            int twotag = corpusSurahWord.get(index).getTagtwo().length();//3
            int threetag = corpusSurahWord.get(index).getTagthree().length();//1
            int secondend = one + two;
            int thirdstart = one + two;
            int thirdend = thirdstart + three;
            int secondendtag = onetag + twotag;
            int thirdstarttag = onetag + twotag + 1;
            int thirdendtag = thirdstarttag + threetag;
            String expandTagsone = expandTags(corpusSurahWord.get(index).getTagone());
            String expandTagstwo = expandTags(corpusSurahWord.get(index).getTagtwo());
            String expandTagsthree = expandTags(corpusSurahWord.get(index).getTagthree());
            String expandTagsfour = expandTags(corpusSurahWord.get(index).getTagfour());
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(corpusSurahWord.get(index).getAraone() + corpusSurahWord.get(index).getAratwo()
                    + corpusSurahWord.get(index).getArathree() + corpusSurahWord.get(index).getArafour());
            SpannableStringBuilder tagspannable = new SpannableStringBuilder(expandTagsfour + "|" + expandTagsthree + "|" +
                    expandTagstwo + "|"
                    + expandTagsone);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(cyan), 0, one, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(yellow), one, secondend, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(green), thirdstart, thirdend, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(indigo), thirdend, thirdend + four, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            tagspannable.setSpan(new ForegroundColorSpan(green), 0, onetag + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            tagspannable.setSpan(new ForegroundColorSpan(yellow), onetag + 1, secondendtag + 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            tagspannable.setSpan(new ForegroundColorSpan(cyan), thirdstarttag, thirdendtag + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            sb.append(corpusSurahWord.get(index).getTagfour());
            sb.append("|");
            sb.append(corpusSurahWord.get(index).getTagthree());
            sb.append("|");
            sb.append(corpusSurahWord.get(index).getTagtwo());
            sb.append("|");
            sb.append(corpusSurahWord.get(index).getTagone());
            wordbdetail.put("word", spannableStringBuilder);
            //      wordbdetail.put("worddetails", sb.toString());
            wordbdetail.put("worddetails", tagspannable);
        } else if (corpusSurahWord.get(index).
                getWordcount() == 5) {
            StringBuilder sb = new StringBuilder();
            wordbdetail.put("lemma", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getLemaraone() + corpusSurahWord.get(index).getLemaratwo() +
                    corpusSurahWord.get(index).getLemrathree() + corpusSurahWord.get(index).getLemarafour() + corpusSurahWord.get(index).getLemarafive()));
            sb.append(corpusSurahWord.get(index).getTagfive());
            sb.append("|");
            sb.append(corpusSurahWord.get(index).getTagfour());
            sb.append("|");
            sb.append(corpusSurahWord.get(index).getTagthree());
            sb.append("|");
            sb.append(corpusSurahWord.get(index).getTagtwo());
            sb.append("|");
            sb.append(corpusSurahWord.get(index).getTagone());
            wordbdetail.put("word", SpannableStringBuilder.valueOf(corpusSurahWord.get(index).getAraone() + corpusSurahWord.get(index).getAratwo() +
                    corpusSurahWord.get(index).getArathree() + corpusSurahWord.get(index).getArafour() + corpusSurahWord.get(index).getTagfive()));
            wordbdetail.put("worddetails", SpannableStringBuilder.valueOf(sb));

        }

    }

    private void GetPronounDetails
            (ArrayList<NewCorpusExpandWbwPOJO> corpusSurahWord, HashMap<String, SpannableStringBuilder> wordbdetail) {
        if (corpusSurahWord.get(index).getWordcount() == 1) {
            if (corpusSurahWord.get(index).getTagone().equals("PRON")) {
                //   String[] parts = corpusSurahWord.get(index).getDetailsone().toString().split("\"|");
                String gendernumber = corpusSurahWord.get(index).getDetailsone().replaceAll("^.*?(\\w+)\\W*$", "$1");
                System.out.println(gendernumber);
                // String gendernumber = parts[parts.length - 1];
                StringBuilder builder = getGenderNumberdetails(gendernumber);
                wordbdetail.put("PRON", SpannableStringBuilder.valueOf(builder));

            }
        } else if (corpusSurahWord.get(index).getWordcount() == 2) {
            if (corpusSurahWord.get(index).getTagtwo().equals("PRON")) {
                String gendernumber = corpusSurahWord.get(index).getDetailstwo().replaceAll("^.*?(\\w+)\\W*$", "$1");
                //   String gendernumber = parts[parts.length - 1];
                StringBuilder builder = getGenderNumberdetails(gendernumber);
                wordbdetail.put("PRON", SpannableStringBuilder.valueOf(builder));

            }
        } else if (corpusSurahWord.get(index).getWordcount() == 3) {
            if (corpusSurahWord.get(index).getTagthree().equals("PRON")) {
                //   String[] parts = corpusSurahWord.get(index).getDetailsthree().toString().split("|");
                String gendernumber = corpusSurahWord.get(index).getDetailsthree().replaceAll("^.*?(\\w+)\\W*$", "$1");
                //    String gendernumber = parts[parts.length - 1];
                StringBuilder builder = getGenderNumberdetails(gendernumber);
                wordbdetail.put("PRON", SpannableStringBuilder.valueOf(builder));

            }
        } else if (corpusSurahWord.get(index).getWordcount() == 4) {
            if (corpusSurahWord.get(index).getTagfour().equals("PRON")) {
                String[] parts = corpusSurahWord.get(index).getDetailsfour().split("\\|PRON:");
                String gendernumber = parts[parts.length - 1];
                StringBuilder builder = getGenderNumberdetails(gendernumber);
                wordbdetail.put("PRON", SpannableStringBuilder.valueOf(builder));

            }
        } else if (corpusSurahWord.get(index).getWordcount() == 5) {
            if (corpusSurahWord.get(index).getTagfive().equals("PRON")) {
                String[] parts = corpusSurahWord.get(index).getDetailsfive().split("\\|");
                String gendernumber = parts[parts.length - 1];
                StringBuilder builder = getGenderNumberdetails(gendernumber);
                wordbdetail.put("PRON", SpannableStringBuilder.valueOf(builder));

            }
        }
    }

}



