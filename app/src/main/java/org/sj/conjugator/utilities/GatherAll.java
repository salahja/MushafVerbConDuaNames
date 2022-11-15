package org.sj.conjugator.utilities;

import androidx.annotation.NonNull;

import org.sj.conjugator.activity.SystemConstants;
import org.sj.nounConjugation.GenericNounSuffixContainer;
import org.sj.nounConjugation.TrilateralUnaugmentedNouns;
import org.sj.nounConjugation.trilateral.augmented.AugmentedTrilateralActiveParticipleConjugator;
import org.sj.nounConjugation.trilateral.augmented.AugmentedTrilateralPassiveParticipleConjugator;
import org.sj.nounConjugation.trilateral.augmented.modifier.activeparticiple.ActiveParticipleModifier;
import org.sj.nounConjugation.trilateral.unaugmented.UnaugmentedTrilateralActiveParticipleConjugator;
import org.sj.nounConjugation.trilateral.unaugmented.UnaugmentedTrilateralPassiveParticipleConjugator;
import org.sj.nounConjugation.trilateral.unaugmented.instrumental.StandardInstrumentalConjugator;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.instrumental.InstrumentalModifier;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.passiveparticiple.PassiveParticipleModifier;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.timeandplace.TimeAndPlaceModifier;
import org.sj.nounConjugation.trilateral.unaugmented.timeandplace.TimeAndPlaceConjugator;
import org.sj.verbConjugation.trilateral.augmented.AugmentedTrilateralRoot;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.active.past.AugmentedActivePastConjugator;
import org.sj.verbConjugation.trilateral.augmented.active.present.AugmentedActivePresentConjugator;
import org.sj.verbConjugation.trilateral.augmented.imperative.AugmentedImperativeConjugator;
import org.sj.verbConjugation.trilateral.augmented.modifier.AugmentedTrilateralModifier;
import org.sj.verbConjugation.trilateral.augmented.passive.past.AugmentedPassivePastConjugator;
import org.sj.verbConjugation.trilateral.augmented.passive.present.AugmentedPassivePresentConjugator;
import org.sj.verbConjugation.trilateral.unaugmented.ConjugationResult;
import org.sj.verbConjugation.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import org.sj.verbConjugation.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier;
import org.sj.verbConjugation.util.KovRulesManager;
import org.sj.verbConjugation.util.SarfDictionary;
import org.sj.verbConjugation.util.TrilateralKovRule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GatherAll {
    private static final GatherAll instance = new GatherAll();

    public GatherAll() {
    }

    public static GatherAll getInstance() {
        return instance;
    }

    public ArrayList<ArrayList> getMujarradListing(String verbmood, String verbroot, String unaugmentedFormula) {
        return buildUnaugmentedLists(verbmood, verbroot, unaugmentedFormula);
    }

    public ArrayList<ArrayList> getMujarradListing(String verbmood, String verbroot) {
        ArrayList<ArrayList> skabeer = buildUnaugmentedLists(verbmood, verbroot);
        return skabeer;
    }

    public ArrayList<ArrayList> getMazeedListing(String verbmood, String verbroot) {
        return buildAugmentedLists(verbmood, verbroot);
    }

    public ArrayList<ArrayList> getMujarradParticiple(String verbroot, String unaugmentedFormula) {
        return buildUnAugmentedParticpleList(verbroot, unaugmentedFormula);
    }

    public ArrayList<ArrayList> getMujarradIsmAla(String verbmood, String verbroot, String unaugmentedFormula) {
        return buildUnAugmentedNounofInstrument(verbmood, verbroot, unaugmentedFormula);

    }

    public ArrayList<ArrayList> getMujarradZarf(String verbmood, String verbroot, String unaugmentedFormula) {
        return buildUnAugmentedNounofTimeAndPlace(verbmood, verbroot, unaugmentedFormula);
    }

    private ArrayList<ArrayList> origbuildUnAugmentedNounofTimeAndPlace(String verbmood, String verbroot, String unaugmentedFormula) {
        ArrayList<ArrayList> skabeer = new ArrayList<>();
        char c1 = verbroot.charAt(0);
        char c2 = verbroot.charAt(1);
        char c3 = verbroot.charAt(2);
        TrilateralKovRule rule = KovRulesManager.getInstance().getTrilateralKovRule(c1, c2, c3);
        final UnaugmentedTrilateralRoot unaugmentedTrilateralRoot = SarfDictionary.getInstance().getUnaugmentedTrilateralRoots(verbroot, unaugmentedFormula);

   /*
    "A" -> "مَفْعَل"
"B" -> "مَفْعِل"
"C" -> "مَفْعَلَة"
     */
        TimeAndPlaceConjugator zarfconjugator = TimeAndPlaceConjugator.getInstance();
        TimeAndPlaceModifier zarfmodifier = TimeAndPlaceModifier.getInstance();
        List mafalconjuationlist = zarfconjugator.createNounList(unaugmentedTrilateralRoot, "مَفْعَل");
        org.sj.nounConjugation.trilateral.unaugmented.modifier.ConjugationResult mafal = zarfmodifier.build(unaugmentedTrilateralRoot, rule.getKov(), mafalconjuationlist, "مَفْعَل");
        List zarfinalmafal = mafal.getFinalResult();
        List mafilconjugationlist = zarfconjugator.createNounList(unaugmentedTrilateralRoot, "مَفْعِل");
        org.sj.nounConjugation.trilateral.unaugmented.modifier.ConjugationResult mafil = zarfmodifier.build(unaugmentedTrilateralRoot, rule.getKov(), mafilconjugationlist, "مَفْعِل");
        List zarffinalmafil = mafal.getFinalResult();
        List mafalatunconjugationlist = zarfconjugator.createNounList(unaugmentedTrilateralRoot, "مَفْعَلَة");
        org.sj.nounConjugation.trilateral.unaugmented.modifier.ConjugationResult mafalatun = zarfmodifier.build(unaugmentedTrilateralRoot, rule.getKov(), mafalatunconjugationlist, "مَفْعَلَة");
        List zarffinalmafalatun = mafal.getFinalResult();
        List<String> zarfmafal = new ArrayList<>();
        List<String> zarfmafil = new ArrayList<>();
        List<String> zarfmafalatun = new ArrayList<>();
        List<String> all = new ArrayList<>();
        all.addAll(zarfinalmafal);
        all.addAll(zarffinalmafalatun);
        all.addAll(zarffinalmafil);
        skabeer.add((ArrayList) all);
        return skabeer;
    }

    private ArrayList<ArrayList> buildUnAugmentedNounofTimeAndPlace(String verbmood, String verbroot, String unaugmentedFormula) {
        ArrayList<ArrayList> skabeer = new ArrayList<>();
        char c1 = verbroot.charAt(0);
        char c2 = verbroot.charAt(1);
        char c3 = verbroot.charAt(2);
        TrilateralKovRule rule = KovRulesManager.getInstance().getTrilateralKovRule(c1, c2, c3);
        final UnaugmentedTrilateralRoot unaugmentedTrilateralRoot = SarfDictionary.getInstance().getUnaugmentedTrilateralRoots(verbroot, unaugmentedFormula);
   /*
    "A" -> "مَفْعَل"
"B" -> "مَفْعِل"
"C" -> "مَفْعَلَة"
     */
        if (unaugmentedTrilateralRoot != null) {
            TrilateralUnaugmentedNouns nounsObject = new TrilateralUnaugmentedNouns(unaugmentedTrilateralRoot);
            List timeAndPlaces = nounsObject.getTimeAndPlaces();
            TimeAndPlaceConjugator zarfconjugator = TimeAndPlaceConjugator.getInstance();
            TimeAndPlaceModifier zarfmodifier = TimeAndPlaceModifier.getInstance();
            List mafalconjuationlist = zarfconjugator.createNounList(unaugmentedTrilateralRoot, "مَفْعَل");
            org.sj.nounConjugation.trilateral.unaugmented.modifier.ConjugationResult mafal = zarfmodifier.build(unaugmentedTrilateralRoot, rule.getKov(), mafalconjuationlist, "مَفْعَل");
            List zarfinalmafal = mafal.getFinalResult();
            List mafilconjugationlist = zarfconjugator.createNounList(unaugmentedTrilateralRoot, "مَفْعِل");
            org.sj.nounConjugation.trilateral.unaugmented.modifier.ConjugationResult mafil = zarfmodifier.build(unaugmentedTrilateralRoot, rule.getKov(), mafilconjugationlist, "مَفْعِل");
            List zarffinalmafil = mafil.getFinalResult();
            List mafalatunconjugationlist = zarfconjugator.createNounList(unaugmentedTrilateralRoot, "مَفْعَلَة");
            org.sj.nounConjugation.trilateral.unaugmented.modifier.ConjugationResult mafalatun = zarfmodifier.build(unaugmentedTrilateralRoot, rule.getKov(), mafalatunconjugationlist, "مَفْعَلَة");
            List zarffinalmafalatun = mafalatun.getFinalResult();
            List<String> zarfmafal = new ArrayList<>();
            List<String> zarfmafil = new ArrayList<>();
            List<String> zarfmafalatun = new ArrayList<>();
            for (Object s : zarfinalmafal) {
                if (s.toString().length() > 0) {
                    zarfmafal.add(s.toString());
                }

            }
            for (Object s : zarffinalmafil) {
                if (s.toString().length() > 0) {
                    zarfmafil.add(s.toString());
                }

            }
            for (Object s : zarffinalmafalatun) {
                if (s.toString().length() > 0) {
                    zarfmafalatun.add(s.toString());
                }

            }
            List<String> all = new ArrayList<>();
            skabeer.add((ArrayList) zarfmafal);
            skabeer.add((ArrayList) zarfmafil);
            skabeer.add((ArrayList) zarfmafalatun);
            return skabeer;
        }
        return skabeer;
    }

    private ArrayList<ArrayList> buildUnAugmentedNounofInstrument(String verbmood, String
            verbroot, String unaugmentedFormula) {
        ArrayList<ArrayList> skabeer = new ArrayList<>();
        char c1 = verbroot.charAt(0);
        char c2 = verbroot.charAt(1);
        char c3 = verbroot.charAt(2);
        TrilateralKovRule rule = KovRulesManager.getInstance().getTrilateralKovRule(c1, c2, c3);
        final UnaugmentedTrilateralRoot unaugmentedTrilateralRoot = SarfDictionary.getInstance().getUnaugmentedTrilateralRoots(verbroot, unaugmentedFormula);
        if (unaugmentedTrilateralRoot != null) {
            TrilateralUnaugmentedNouns nounsObject = new TrilateralUnaugmentedNouns(unaugmentedTrilateralRoot);
            StandardInstrumentalConjugator conjugator = StandardInstrumentalConjugator.getInstance();
            InstrumentalModifier modifier = InstrumentalModifier.getInstance();
            List mifal = conjugator.createNounList(unaugmentedTrilateralRoot, "مِفْعَل");
            ConjugationResult conjResultmifal = modifier.build(unaugmentedTrilateralRoot, rule.getKov(), mifal, "مِفْعَل");
            List finalAlamifal = conjResultmifal.getFinalResult();
            List mifalatun = conjugator.createNounList(unaugmentedTrilateralRoot, "مِفْعَلَة");
            ConjugationResult conjResult = modifier.build(unaugmentedTrilateralRoot, rule.getKov(), mifalatun, "مِفْعَلَة");
            List finalAlamifalatun = conjResult.getFinalResult();
            List mifaal = conjugator.createNounList(unaugmentedTrilateralRoot, "مِفْعَال");
            ConjugationResult conjResultmifaal = modifier.build(unaugmentedTrilateralRoot, rule.getKov(), mifaal, "مِفْعَال");
            List finalAlamifaal = conjResultmifaal.getFinalResult();
            List faalatun = conjugator.createNounList(unaugmentedTrilateralRoot, "فَعَّالَة");
            ConjugationResult conjResultfaalatun = modifier.build(unaugmentedTrilateralRoot, rule.getKov(), faalatun, "فَعَّالَة");
            List<String> alamifal = new ArrayList<>();
            List<String> alamifalatun = new ArrayList<>();
            List<String> alamifaal = new ArrayList<>();
            for (Object s : finalAlamifal) {
                if (s.toString().length() > 0) {
                    alamifal.add(s.toString());
                }

            }
            for (Object s : finalAlamifalatun) {
                if (s.toString().length() > 0) {
                    alamifalatun.add(s.toString());
                }

            }
            for (Object s : finalAlamifaal) {
                if (s.toString().length() > 0) {
                    alamifaal.add(s.toString());
                }

            }
            skabeer.add((ArrayList) alamifal);
            skabeer.add((ArrayList) alamifalatun);
            skabeer.add((ArrayList) alamifaal);
            return skabeer;
        }
        return skabeer;
    }

    private ArrayList<ArrayList> buildUnAugmentedParticpleList(String verbroot, String
            unaugmentedFormula) {
        ArrayList<ArrayList> skabeer = new ArrayList<>();
        char c1 = verbroot.charAt(0);
        char c2 = verbroot.charAt(1);
        char c3 = verbroot.charAt(2);
        TrilateralKovRule rule = KovRulesManager.getInstance().getTrilateralKovRule(c1, c2, c3);
        final UnaugmentedTrilateralRoot unaugmentedTrilateralRoot = SarfDictionary.getInstance().getUnaugmentedTrilateralRoots(verbroot, unaugmentedFormula);
        //ismfale and ismmafool
        List conjugatedIsmFael = UnaugmentedTrilateralActiveParticipleConjugator.getInstance().createNounList(unaugmentedTrilateralRoot,
                unaugmentedTrilateralRoot.getConjugation());
        final org.sj.nounConjugation.trilateral.unaugmented.modifier.ConjugationResult conjugationResult = org.sj.nounConjugation.trilateral.unaugmented.modifier.activeparticiple.ActiveParticipleModifier.
                getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), conjugatedIsmFael, "");
        final List finalIsmFael = conjugationResult.getFinalResult();
        List conjugatedIsmMafool = UnaugmentedTrilateralPassiveParticipleConjugator.getInstance().createNounList(unaugmentedTrilateralRoot,
                unaugmentedTrilateralRoot.getConjugation());
        final org.sj.nounConjugation.trilateral.unaugmented.modifier.ConjugationResult ismmafoolresult =
                PassiveParticipleModifier.
                        getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), conjugatedIsmMafool, "");
        final List ismmafoolresultFinalResult = ismmafoolresult.getFinalResult();
        List<String> listismfael = new ArrayList<>();
        List<String> listismmafool = new ArrayList<>();
        List<String> vdetails = new ArrayList<>();
        vdetails.add(String.valueOf(rule.getDesc()));
        vdetails.add(unaugmentedTrilateralRoot.getConjugationname());
        // vdetails.add(unaugmentedTrilateralRoot.getVerb());
        vdetails.add(verbroot);
        for (Object s : finalIsmFael) {
            listismfael.add(s.toString());

        }
        for (Object s : ismmafoolresultFinalResult) {
            listismmafool.add(s.toString());

        }
        skabeer.add((ArrayList) listismfael);
        skabeer.add((ArrayList) listismmafool);
        //  skabeer.add((ArrayList) strings);
        return skabeer;

    }

    public ArrayList<ArrayList> getMazeedListing(String verbmood, String verbroot, String
            augmentedFormula) {
        return buildAugmentedLists(verbmood, verbroot, augmentedFormula);
    }

    @NonNull
    private ArrayList<ArrayList> buildUnaugmentedLists(String verbmood, String verbroot) {
        ArrayList<ArrayList> skabeer = new ArrayList<>();
        char c1 = verbroot.charAt(0);
        char c2 = verbroot.charAt(1);
        char c3 = verbroot.charAt(2);
        Character C1 = verbroot.charAt(0);
        Character C2 = verbroot.charAt(1);
        Character C3 = verbroot.charAt(2);
        List madhimajhool;
        List mudharay = null;
        List amr, nahiamr;
        List madhi;
        List mudharaymajhool = null;
        TrilateralKovRule rule = KovRulesManager.getInstance().getTrilateralKovRule(c1, c2, c3);
        final UnaugmentedTrilateralRoot unaugmentedTrilateralRoot = SarfDictionary.getInstance().getUnaugmentedTrilateralRoots(verbroot);
        if (unaugmentedTrilateralRoot != null) {
            //   madhi = org.sj.verb.trilateral.unaugmented.active.ActivePastConjugator.getInstance().createVerbList((UnaugmentedTrilateralRoot) unaugmentedTrilateralRoot);
            madhi = org.sj.verbConjugation.trilateral.unaugmented.active.ActivePastConjugator.getInstance().createVerbList((UnaugmentedTrilateralRoot) unaugmentedTrilateralRoot);
            final ConjugationResult build = UnaugmentedTrilateralModifier.getInstance()
                    .build((UnaugmentedTrilateralRoot) unaugmentedTrilateralRoot, rule.getKov(), madhi,
                            SystemConstants.PAST_TENSE, true, true);
            madhimajhool = org.sj.verbConjugation.trilateral.unaugmented.passive.PassivePastConjugator.getInstance().createVerbList((UnaugmentedTrilateralRoot) unaugmentedTrilateralRoot);
            switch (verbmood) {
                case "Indicative":
                    mudharay = org.sj.verbConjugation.trilateral.unaugmented.active.ActivePresentConjugator.getInstance().
                            createNominativeVerbList((UnaugmentedTrilateralRoot) unaugmentedTrilateralRoot);
                    mudharaymajhool = org.sj.verbConjugation.trilateral.unaugmented.passive.PassivePresentConjugator.getInstance().
                            createNominativeVerbList((UnaugmentedTrilateralRoot) unaugmentedTrilateralRoot);
                    break;
                case "Subjunctive":
                    mudharay = org.sj.verbConjugation.trilateral.unaugmented.active.ActivePresentConjugator.getInstance().
                            createAccusativeVerbList((UnaugmentedTrilateralRoot) unaugmentedTrilateralRoot);
                    mudharaymajhool = org.sj.verbConjugation.trilateral.unaugmented.passive.PassivePresentConjugator.getInstance().
                            createAccusativeVerbList((UnaugmentedTrilateralRoot) unaugmentedTrilateralRoot);
                    break;
                case "Jussive":
                    mudharay = org.sj.verbConjugation.trilateral.unaugmented.active.ActivePresentConjugator.getInstance().
                            createJussiveVerbList((UnaugmentedTrilateralRoot) unaugmentedTrilateralRoot);
                    mudharaymajhool = org.sj.verbConjugation.trilateral.unaugmented.passive.PassivePresentConjugator.getInstance().
                            createJussiveVerbList((UnaugmentedTrilateralRoot) unaugmentedTrilateralRoot);
                    break;
                case "Emphasized":
                    mudharay = org.sj.verbConjugation.trilateral.unaugmented.active.ActivePresentConjugator.getInstance().
                            createEmphasizedVerbList((UnaugmentedTrilateralRoot) unaugmentedTrilateralRoot);
                    mudharaymajhool = org.sj.verbConjugation.trilateral.unaugmented.passive.PassivePresentConjugator.getInstance().
                            createEmphasizedVerbList((UnaugmentedTrilateralRoot) unaugmentedTrilateralRoot);
                    break;
            }
            nahiamr = org.sj.verbConjugation.trilateral.unaugmented.active.ActivePresentConjugator.getInstance().
                    createJussiveVerbList((UnaugmentedTrilateralRoot) unaugmentedTrilateralRoot);
            amr = org.sj.verbConjugation.trilateral.unaugmented.UnaugmentedImperativeConjugator.getInstance().createVerbList(unaugmentedTrilateralRoot);
            //    public ConjugationResult build(UnaugmentedTrilateralRoot root, int kov, List conjugations, String tense, boolean active, boolean applyGemination) {
            //   result =  AugmentedActivePastConjugator.getInstance().createVerbList(augmentedRoot, getForm());
            final ConjugationResult madhiconjresult = UnaugmentedTrilateralModifier.getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), madhi,
                    SystemConstants.PAST_TENSE, true, true);
            final ConjugationResult madhimajhoolconj = UnaugmentedTrilateralModifier.getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), madhimajhool,
                    SystemConstants.PAST_TENSE, false, true);
            final ConjugationResult mudharayconj = UnaugmentedTrilateralModifier.getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), mudharay,
                    SystemConstants.PRESENT_TENSE, true, true);
            final ConjugationResult mudharaymajhoolconj = UnaugmentedTrilateralModifier.getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), mudharaymajhool,
                    SystemConstants.PRESENT_TENSE, false, true);
            final ConjugationResult amrconj = UnaugmentedTrilateralModifier.getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), amr,
                    SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE, true, true);
            final ConjugationResult nahiamrconj = UnaugmentedTrilateralModifier.getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), nahiamr,
                    SystemConstants.PRESENT_TENSE, true, true);
            //ismfale and ismmafool
            List conjugatedIsmFael = UnaugmentedTrilateralActiveParticipleConjugator.getInstance().createNounList(unaugmentedTrilateralRoot,
                    unaugmentedTrilateralRoot.getConjugation());
            final org.sj.nounConjugation.trilateral.unaugmented.modifier.ConjugationResult conjugationResult = org.sj.nounConjugation.trilateral.unaugmented.modifier.activeparticiple.ActiveParticipleModifier.
                    getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), conjugatedIsmFael, "");
            final List finalIsmFael = conjugationResult.getFinalResult();
            List conjugatedIsmMafool = UnaugmentedTrilateralPassiveParticipleConjugator.getInstance().createNounList(unaugmentedTrilateralRoot,
                    unaugmentedTrilateralRoot.getConjugation());
            final org.sj.nounConjugation.trilateral.unaugmented.modifier.ConjugationResult ismmafoolresult =
                    PassiveParticipleModifier.
                            getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), conjugatedIsmMafool, "");
            final List ismmafoolresultFinalResult = ismmafoolresult.getFinalResult();
            ///ismala
    /*
    0 = "مِفْعَل"
1 = "مِفْعَلَة"
2 = "مِفْعَال"
3 = "فَعَّالَة"
     */
            StandardInstrumentalConjugator conjugator = StandardInstrumentalConjugator.getInstance();
            InstrumentalModifier modifier = InstrumentalModifier.getInstance();
            List mifal = conjugator.createNounList(unaugmentedTrilateralRoot, "مِفْعَل");
            ConjugationResult conjResultmifal = modifier.build(unaugmentedTrilateralRoot, rule.getKov(), mifal, "مِفْعَل");
            List finalAlamifal = conjResultmifal.getFinalResult();
            List mifalatun = conjugator.createNounList(unaugmentedTrilateralRoot, "مِفْعَلَة");
            ConjugationResult conjResult = modifier.build(unaugmentedTrilateralRoot, rule.getKov(), mifalatun, "مِفْعَلَة");
            List finalAlamifalatun = conjResult.getFinalResult();
            List mifaal = conjugator.createNounList(unaugmentedTrilateralRoot, "مِفْعَال");
            ConjugationResult conjResultmifaal = modifier.build(unaugmentedTrilateralRoot, rule.getKov(), mifaal, "مِفْعَال");
            List finalAlamifaal = conjResultmifaal.getFinalResult();
            List faalatun = conjugator.createNounList(unaugmentedTrilateralRoot, "فَعَّالَة");
            ConjugationResult conjResultfaalatun = modifier.build(unaugmentedTrilateralRoot, rule.getKov(), faalatun, "فَعَّالَة");
            //zarf
            TimeAndPlaceConjugator zarfconjugator = TimeAndPlaceConjugator.getInstance();
            TimeAndPlaceModifier zarfmodifier = TimeAndPlaceModifier.getInstance();
            List mafalconjuationlist = zarfconjugator.createNounList(unaugmentedTrilateralRoot, "مَفْعَل");
            org.sj.nounConjugation.trilateral.unaugmented.modifier.ConjugationResult mafal = zarfmodifier.build(unaugmentedTrilateralRoot, rule.getKov(), mafalconjuationlist, "مَفْعَل");
            List mafilconjugationlist = zarfconjugator.createNounList(unaugmentedTrilateralRoot, "مَفْعِل");
            org.sj.nounConjugation.trilateral.unaugmented.modifier.ConjugationResult mafil = zarfmodifier.build(unaugmentedTrilateralRoot, rule.getKov(), mafilconjugationlist, "مَفْعِل");
            List zarffinalmafil = mafil.getFinalResult();
            List mafalatunconjugationlist = zarfconjugator.createNounList(unaugmentedTrilateralRoot, "مَفْعَلَة");
            org.sj.nounConjugation.trilateral.unaugmented.modifier.ConjugationResult mafalatun = zarfmodifier.build(unaugmentedTrilateralRoot, rule.getKov(), mafalatunconjugationlist, "مَفْعَلَة");
            List zarffinalmafalatun = mafalatun.getFinalResult();
            madhi = madhiconjresult.getFinalResult();
            madhimajhool = madhimajhoolconj.getFinalResult();
            mudharay = mudharayconj.getFinalResult();
            mudharaymajhool = mudharaymajhoolconj.getFinalResult();
            amr = amrconj.getFinalResult();
            nahiamr = nahiamrconj.getFinalResult();
            amr.removeAll(Collections.singleton(null));
            String la = "لا";
            final List list = nahiamr.subList(6, 11);
            ArrayList<String> nm = new ArrayList<>();
            StringBuilder sb;
            for (Object o : list) {
                sb = new StringBuilder();
                nm.add(sb.append(la).append(" ").append(o.toString()).toString());

            }
            List<String> listmadhi = new ArrayList<>();
            List<String> listmadhimajhool = new ArrayList<>();
            List<String> listmudharay = new ArrayList<>();
            List<String> listmudharymajhool = new ArrayList<>();
            List<String> listamr = new ArrayList<>();
            List<String> listamrnahi = new ArrayList<>();
            List<String> listismfael = new ArrayList<>();
            List<String> listismmafool = new ArrayList<>();
            List<String> listmifal = new ArrayList<>();
            List<String> listmifalatun = new ArrayList<>();
            List<String> listlmifaal = new ArrayList<>();
            List<String> listlzarfmafal = new ArrayList<>();
            List<String> listlzarfmafil = new ArrayList<>();
            List<String> listlzarfmafalatun = new ArrayList<>();
            for (Object s : finalAlamifal) {
                if (s.toString().length() > 0) {
                    listmifal.add(s.toString());
                }

            }
            for (Object s : finalAlamifalatun) {
                if (s.toString().length() > 0) {
                    listmifalatun.add(s.toString());
                }

            }
            for (Object s : finalAlamifaal) {
                if (s.toString().length() > 0) {
                    listlmifaal.add(s.toString());
                }

            }
            for (Object s : zarffinalmafil) {
                if (s.toString().length() > 0) {
                    listlzarfmafal.add(s.toString());
                }
            }
            for (Object s : zarffinalmafil) {
                if (s.toString().length() > 0) {
                    listlzarfmafil.add(s.toString());
                }
            }
            for (Object s : zarffinalmafalatun) {
                if (s.toString().length() > 0) {
                    listlzarfmafalatun.add(s.toString());
                }
            }
            for (Object s : madhi) {
                listmadhi.add(s.toString());

            }
            for (Object s : madhimajhool) {
                try {
                    listmadhimajhool.add(s.toString());

                } catch (NullPointerException e) {
                    listmadhimajhool.add("-");
                }

            }
            for (Object s : mudharay) {
                listmudharay.add(s.toString());

            }
            for (Object s : mudharaymajhool) {
                try {
                    listmudharymajhool.add(s.toString());

                } catch (NullPointerException e) {
                    listmudharymajhool.add("-");
                }

            }
            for (Object s : finalIsmFael) {
                listismfael.add(s.toString());

            }
            for (Object s : ismmafoolresultFinalResult) {
                listismmafool.add(s.toString());

            }
            for (Object s : amr) {
                listamr.add(s.toString());

            }
            for (Object s : nm) {
                listamrnahi.add(s.toString());

            }
            List<String> vdetails = new ArrayList<>();
            vdetails.add(rule.getDesc());
            vdetails.add(unaugmentedTrilateralRoot.getConjugationname());
            vdetails.add(verbroot);
            vdetails.add(listmadhi.get(0));
            vdetails.add(listmadhimajhool.get(0));
            vdetails.add(listmudharay.get(0));
            vdetails.add(listmudharymajhool.get(0));
            vdetails.add(listamr.get(0));
            vdetails.add(listamrnahi.get(0));
            vdetails.add(listismfael.get(0));
            vdetails.add(listismmafool.get(0));
            vdetails.add(listmifal.get(0));
            vdetails.add(listmifalatun.get(0));
            vdetails.add(listlmifaal.get(0));
            // vdetails.add(listlmifaal.get(0));
            vdetails.add(listlzarfmafal.get(0));
            vdetails.add(listlzarfmafil.get(0));
            vdetails.add(listlzarfmafalatun.get(0));
            vdetails.add("mujarrad");
            vdetails.add(unaugmentedTrilateralRoot.getConjugation());
            skabeer.add((ArrayList) vdetails);
            skabeer.add((ArrayList) listmadhi);
            skabeer.add((ArrayList) listmadhimajhool);
            skabeer.add((ArrayList) listmudharay);
            skabeer.add((ArrayList) listmudharymajhool);
            skabeer.add((ArrayList) listamr);
            skabeer.add((ArrayList) listamrnahi);
            skabeer.add((ArrayList) listismfael);
            skabeer.add((ArrayList) listismmafool);
            skabeer.add((ArrayList) listmifal);
            skabeer.add((ArrayList) listlmifaal);
            skabeer.add((ArrayList) listmifalatun);
            skabeer.add((ArrayList) listlzarfmafal);
            skabeer.add((ArrayList) listlzarfmafil);
            skabeer.add((ArrayList) listlzarfmafalatun);
            List<String> strings = new ArrayList<>(madhi.size());
            //  skabeer.add((ArrayList) strings);
            return skabeer;
        }
        return skabeer;
    }

    @NonNull
    private ArrayList<ArrayList> buildUnaugmentedLists(String verbmood, String verbroot, String
            unaugmentedFormula) {
        ArrayList<ArrayList> skabeer = new ArrayList<>();
        char c1 = verbroot.charAt(0);
        char c2 = verbroot.charAt(1);
        char c3 = verbroot.charAt(2);
        Character C1 = verbroot.charAt(0);
        List madhimajhool;
        List mudharay = null;
        List amr, nahiamr;
        List madhi;
        List mudharaymajhool = null;
        TrilateralKovRule rule = KovRulesManager.getInstance().getTrilateralKovRule(c1, c2, c3);
        final UnaugmentedTrilateralRoot unaugmentedTrilateralRoot = SarfDictionary.getInstance().getUnaugmentedTrilateralRoots(verbroot, unaugmentedFormula);
        if (unaugmentedTrilateralRoot != null) {
            //   madhi = org.sj.verb.trilateral.unaugmented.active.ActivePastConjugator.getInstance().createVerbList((UnaugmentedTrilateralRoot) unaugmentedTrilateralRoot);
            madhi = org.sj.verbConjugation.trilateral.unaugmented.active.ActivePastConjugator.getInstance().createVerbList((UnaugmentedTrilateralRoot) unaugmentedTrilateralRoot);
            final ConjugationResult build = UnaugmentedTrilateralModifier.getInstance()
                    .build((UnaugmentedTrilateralRoot) unaugmentedTrilateralRoot, rule.getKov(), madhi,
                            SystemConstants.PAST_TENSE, true, true);
            final List finalResult1 = build.getFinalResult();
            madhimajhool = org.sj.verbConjugation.trilateral.unaugmented.passive.PassivePastConjugator.getInstance().createVerbList((UnaugmentedTrilateralRoot) unaugmentedTrilateralRoot);
            switch (verbmood) {
                case "Indicative":
                    mudharay = org.sj.verbConjugation.trilateral.unaugmented.active.ActivePresentConjugator.getInstance().
                            createNominativeVerbList((UnaugmentedTrilateralRoot) unaugmentedTrilateralRoot);
                    mudharaymajhool = org.sj.verbConjugation.trilateral.unaugmented.passive.PassivePresentConjugator.getInstance().
                            createNominativeVerbList((UnaugmentedTrilateralRoot) unaugmentedTrilateralRoot);
                    break;
                case "Subjunctive":
                    mudharay = org.sj.verbConjugation.trilateral.unaugmented.active.ActivePresentConjugator.getInstance().
                            createAccusativeVerbList((UnaugmentedTrilateralRoot) unaugmentedTrilateralRoot);
                    mudharaymajhool = org.sj.verbConjugation.trilateral.unaugmented.passive.PassivePresentConjugator.getInstance().
                            createAccusativeVerbList((UnaugmentedTrilateralRoot) unaugmentedTrilateralRoot);
                    break;
                case "Jussive":
                    mudharay = org.sj.verbConjugation.trilateral.unaugmented.active.ActivePresentConjugator.getInstance().
                            createJussiveVerbList((UnaugmentedTrilateralRoot) unaugmentedTrilateralRoot);
                    mudharaymajhool = org.sj.verbConjugation.trilateral.unaugmented.passive.PassivePresentConjugator.getInstance().
                            createJussiveVerbList((UnaugmentedTrilateralRoot) unaugmentedTrilateralRoot);
                    break;
                case "Emphasized":
                    mudharay = org.sj.verbConjugation.trilateral.unaugmented.active.ActivePresentConjugator.getInstance().
                            createEmphasizedVerbList((UnaugmentedTrilateralRoot) unaugmentedTrilateralRoot);
                    mudharaymajhool = org.sj.verbConjugation.trilateral.unaugmented.passive.PassivePresentConjugator.getInstance().
                            createEmphasizedVerbList((UnaugmentedTrilateralRoot) unaugmentedTrilateralRoot);
                    break;
            }
            nahiamr = org.sj.verbConjugation.trilateral.unaugmented.active.ActivePresentConjugator.getInstance().
                    createJussiveVerbList((UnaugmentedTrilateralRoot) unaugmentedTrilateralRoot);
            amr = org.sj.verbConjugation.trilateral.unaugmented.UnaugmentedImperativeConjugator.getInstance().createVerbList(unaugmentedTrilateralRoot);
            //    public ConjugationResult build(UnaugmentedTrilateralRoot root, int kov, List conjugations, String tense, boolean active, boolean applyGemination) {
            //   result =  AugmentedActivePastConjugator.getInstance().createVerbList(augmentedRoot, getForm());
            final ConjugationResult madhiconjresult = UnaugmentedTrilateralModifier.getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), madhi,
                    SystemConstants.PAST_TENSE, true, true);
            final ConjugationResult madhimajhoolconj = UnaugmentedTrilateralModifier.getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), madhimajhool,
                    SystemConstants.PAST_TENSE, false, true);
            final ConjugationResult mudharayconj = UnaugmentedTrilateralModifier.getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), mudharay,
                    SystemConstants.PRESENT_TENSE, true, true);
            final ConjugationResult mudharaymajhoolconj = UnaugmentedTrilateralModifier.getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), mudharaymajhool,
                    SystemConstants.PRESENT_TENSE, false, true);
            final ConjugationResult amrconj = UnaugmentedTrilateralModifier.getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), amr,
                    SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE, true, true);
            final ConjugationResult nahiamrconj = UnaugmentedTrilateralModifier.getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), nahiamr,
                    SystemConstants.PRESENT_TENSE, true, true);
            //ismfale and ismmafool
            List conjugatedIsmFael = UnaugmentedTrilateralActiveParticipleConjugator.getInstance().createNounList(unaugmentedTrilateralRoot,
                    unaugmentedTrilateralRoot.getConjugation());
            final String formula = "";
            final org.sj.nounConjugation.trilateral.unaugmented.modifier.ConjugationResult conjugationResult = org.sj.nounConjugation.trilateral.unaugmented.modifier.activeparticiple.ActiveParticipleModifier.
                    getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), conjugatedIsmFael, "");
            final List finalIsmFael = conjugationResult.getFinalResult();
            List conjugatedIsmMafool = UnaugmentedTrilateralPassiveParticipleConjugator.getInstance().createNounList(unaugmentedTrilateralRoot,
                    unaugmentedTrilateralRoot.getConjugation());
            final String formulas = "";
            final org.sj.nounConjugation.trilateral.unaugmented.modifier.ConjugationResult ismmafoolresult =
                    PassiveParticipleModifier.
                            getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), conjugatedIsmMafool, "");
            final List ismmafoolresultFinalResult = ismmafoolresult.getFinalResult();
            ///ismala
    /*
    0 = "مِفْعَل"
1 = "مِفْعَلَة"
2 = "مِفْعَال"
3 = "فَعَّالَة"
     */
            StandardInstrumentalConjugator conjugator = StandardInstrumentalConjugator.getInstance();
            InstrumentalModifier modifier = InstrumentalModifier.getInstance();
            GenericNounSuffixContainer instance = GenericNounSuffixContainer.getInstance();
            final String title = "مِفْعَلَة";
            List mifal = conjugator.createNounList(unaugmentedTrilateralRoot, "مِفْعَل");
            ConjugationResult conjResultmifal = modifier.build(unaugmentedTrilateralRoot, rule.getKov(), mifal, "مِفْعَل");
            List finalAlamifal = conjResultmifal.getFinalResult();
            List mifalatun = conjugator.createNounList(unaugmentedTrilateralRoot, "مِفْعَلَة");
            ConjugationResult conjResult = modifier.build(unaugmentedTrilateralRoot, rule.getKov(), mifalatun, "مِفْعَلَة");
            List finalAlamifalatun = conjResult.getFinalResult();
            List mifaal = conjugator.createNounList(unaugmentedTrilateralRoot, "مِفْعَال");
            ConjugationResult conjResultmifaal = modifier.build(unaugmentedTrilateralRoot, rule.getKov(), mifaal, "مِفْعَال");
            List finalAlamifaal = conjResultmifaal.getFinalResult();
            List faalatun = conjugator.createNounList(unaugmentedTrilateralRoot, "فَعَّالَة");
            ConjugationResult conjResultfaalatun = modifier.build(unaugmentedTrilateralRoot, rule.getKov(), faalatun, "فَعَّالَة");
            List finalfaalatun = conjResultfaalatun.getFinalResult();
            //zarf
            TimeAndPlaceConjugator zarfconjugator = TimeAndPlaceConjugator.getInstance();
            TimeAndPlaceModifier zarfmodifier = TimeAndPlaceModifier.getInstance();
            List mafalconjuationlist = zarfconjugator.createNounList(unaugmentedTrilateralRoot, "مَفْعَل");
            org.sj.nounConjugation.trilateral.unaugmented.modifier.ConjugationResult mafal = zarfmodifier.build(unaugmentedTrilateralRoot, rule.getKov(), mafalconjuationlist, "مَفْعَل");
            List zarfinalmafal = mafal.getFinalResult();
            List mafilconjugationlist = zarfconjugator.createNounList(unaugmentedTrilateralRoot, "مَفْعِل");
            org.sj.nounConjugation.trilateral.unaugmented.modifier.ConjugationResult mafil = zarfmodifier.build(unaugmentedTrilateralRoot, rule.getKov(), mafilconjugationlist, "مَفْعِل");
            List zarffinalmafil = mafil.getFinalResult();
            List mafalatunconjugationlist = zarfconjugator.createNounList(unaugmentedTrilateralRoot, "مَفْعَلَة");
            org.sj.nounConjugation.trilateral.unaugmented.modifier.ConjugationResult mafalatun = zarfmodifier.build(unaugmentedTrilateralRoot, rule.getKov(), mafalatunconjugationlist, "مَفْعَلَة");
            List zarffinalmafalatun = mafalatun.getFinalResult();
            madhi = madhiconjresult.getFinalResult();
            madhimajhool = madhimajhoolconj.getFinalResult();
            mudharay = mudharayconj.getFinalResult();
            mudharaymajhool = mudharaymajhoolconj.getFinalResult();
            amr = amrconj.getFinalResult();
            nahiamr = nahiamrconj.getFinalResult();
            amr.removeAll(Collections.singleton(null));
            String la = "لا";
            final List list = nahiamr.subList(6, 11);
            ArrayList<String> nm = new ArrayList<>();
            StringBuilder sb;
            for (Object o : list) {
                sb = new StringBuilder();
                nm.add(sb.append(la).append(" ").append(o.toString()).toString());

            }
            List<String> listmadhi = new ArrayList<>();
            List<String> listmadhimajhool = new ArrayList<>();
            List<String> listmudharay = new ArrayList<>();
            List<String> listmudharymajhool = new ArrayList<>();
            List<String> listamr = new ArrayList<>();
            List<String> listamrnahi = new ArrayList<>();
            List<String> listismfael = new ArrayList<>();
            List<String> listismmafool = new ArrayList<>();
//
            List<String> listmifal = new ArrayList<>();
            List<String> listmifalatun = new ArrayList<>();
            List<String> listmifaal = new ArrayList<>();
            List<String> listlzarfmafal = new ArrayList<>();
            List<String> listlzarfmafil = new ArrayList<>();
            List<String> listlzarfmafalatun = new ArrayList<>();
            for (Object s : finalAlamifal) {
                if (s.toString().length() > 0) {
                    listmifal.add(s.toString());
                }

            }
            for (Object s : finalAlamifalatun) {
                if (s.toString().length() > 0) {
                    listmifalatun.add(s.toString());
                }

            }
            for (Object s : finalAlamifaal) {
                if (s.toString().length() > 0) {
                    listmifaal.add(s.toString());
                }

            }
            for (Object s : zarffinalmafil) {
                if (s.toString().length() > 0) {
                    listlzarfmafal.add(s.toString());
                }
            }
            for (Object s : zarffinalmafil) {
                if (s.toString().length() > 0) {
                    listlzarfmafil.add(s.toString());
                }
            }
            for (Object s : zarffinalmafalatun) {
                if (s.toString().length() > 0) {
                    listlzarfmafalatun.add(s.toString());
                }
            }
            for (Object s : madhi) {
                listmadhi.add(s.toString());

            }
            for (Object s : madhimajhool) {
                try {
                    listmadhimajhool.add(s.toString());

                } catch (NullPointerException e) {
                    listmadhimajhool.add("-");
                }

            }
            for (Object s : mudharay) {
                listmudharay.add(s.toString());

            }
            for (Object s : mudharaymajhool) {
                try {
                    listmudharymajhool.add(s.toString());

                } catch (NullPointerException e) {
                    listmudharymajhool.add("-");
                }

            }
            for (Object s : finalIsmFael) {
                listismfael.add(s.toString());

            }
            for (Object s : ismmafoolresultFinalResult) {
                listismmafool.add(s.toString());

            }
            for (Object s : amr) {
                listamr.add(s.toString());

            }
            for (Object s : nm) {
                listamrnahi.add(s.toString());

            }
            List<String> vdetails = new ArrayList<>();
            // vdetails.add(unaugmentedTrilateralRoot.getVerb());
            vdetails.add(rule.getDesc());
            vdetails.add(unaugmentedTrilateralRoot.getConjugationname());
            vdetails.add(verbroot);
            vdetails.add(listmadhi.get(0));
            vdetails.add(listmadhimajhool.get(0));
            vdetails.add(listmudharay.get(0));
            vdetails.add(listmudharymajhool.get(0));
            vdetails.add(listamr.get(0));
            vdetails.add(listamrnahi.get(0));
            vdetails.add(listismfael.get(0));
            vdetails.add(listismmafool.get(0));
            vdetails.add(listmifal.get(0));
            vdetails.add(listmifalatun.get(0));
            vdetails.add(listmifaal.get(0));
            // vdetails.add(listlmifaal.get(0));
            vdetails.add(listlzarfmafal.get(0));
            vdetails.add(listlzarfmafil.get(0));
            vdetails.add(listlzarfmafalatun.get(0));
            vdetails.add("mujarrad");
            vdetails.add(unaugmentedTrilateralRoot.getConjugation());
            skabeer.add((ArrayList) vdetails);
            skabeer.add((ArrayList) listmadhi);
            skabeer.add((ArrayList) listmadhimajhool);
            skabeer.add((ArrayList) listmudharay);
            skabeer.add((ArrayList) listmudharymajhool);
            skabeer.add((ArrayList) listamr);
            skabeer.add((ArrayList) listamrnahi);
            skabeer.add((ArrayList) listismfael);
            skabeer.add((ArrayList) listismmafool);
            skabeer.add((ArrayList) listmifal);
            skabeer.add((ArrayList) listmifalatun);
            skabeer.add((ArrayList) listmifaal);
            skabeer.add((ArrayList) listlzarfmafal);
            skabeer.add((ArrayList) listlzarfmafil);
            skabeer.add((ArrayList) listlzarfmafalatun);
            //  skabeer.add((ArrayList) strings);
            return skabeer;
        }
        return skabeer;
    }

    @NonNull
    private ArrayList<ArrayList> buildAugmentedLists(String verbmood, String verbroot, String
            augmentedFormula) {
        AugmentedTrilateralRoot augmentedRoot = SarfDictionary.getInstance().getAugmentedTrilateralRoot(verbroot, augmentedFormula);
        List ismfael;
        List ismmafool;
        List madhimajhool;
        List mudharay = null;
        List amr, nahiamr;
        List madhi;
        List mudharaymajhool = null;
        char c1 = verbroot.charAt(0);
        char c2 = verbroot.charAt(1);
        char c3 = verbroot.charAt(2);
        ArrayList<ArrayList> skabeer = new ArrayList<>();
        if (augmentedRoot != null) {
            TrilateralKovRule rule = KovRulesManager.getInstance().getTrilateralKovRule(c1, c2, c3);
            madhi = AugmentedActivePastConjugator.getInstance().createVerbList((AugmentedTrilateralRoot) augmentedRoot, Integer.parseInt(augmentedRoot.getForm()));
            madhimajhool = AugmentedPassivePastConjugator.getInstance().createVerbList((AugmentedTrilateralRoot) augmentedRoot, Integer.parseInt(augmentedRoot.getForm()));
            switch (verbmood) {
                case "Indicative":
                    mudharay = AugmentedActivePresentConjugator.getInstance().
                            getNominativeConjugator().createVerbList((AugmentedTrilateralRoot) augmentedRoot, Integer.parseInt(augmentedFormula));
                    mudharaymajhool = AugmentedPassivePresentConjugator.getInstance().
                            getNominativeConjugator().createVerbList((AugmentedTrilateralRoot) augmentedRoot, Integer.parseInt(augmentedFormula));
                    break;
                case "Subjunctive":
                    mudharay = AugmentedActivePresentConjugator.getInstance().
                            getAccusativeConjugator().createVerbList((AugmentedTrilateralRoot) augmentedRoot, Integer.parseInt(augmentedFormula));
                    mudharaymajhool = AugmentedPassivePresentConjugator.getInstance().
                            getAccusativeConjugator().createVerbList((AugmentedTrilateralRoot) augmentedRoot, Integer.parseInt(augmentedFormula));
                    break;
                case "Jussive":
                    mudharay = AugmentedActivePresentConjugator.getInstance().
                            getJussiveConjugator().createVerbList((AugmentedTrilateralRoot) augmentedRoot, Integer.parseInt(augmentedFormula));
                    mudharaymajhool = AugmentedPassivePresentConjugator.getInstance().
                            getJussiveConjugator().createVerbList((AugmentedTrilateralRoot) augmentedRoot, Integer.parseInt(augmentedFormula));
                    break;
                case "Emphasized":
                    mudharay = AugmentedActivePresentConjugator.getInstance().
                            getEmphasizedConjugator().createVerbList((AugmentedTrilateralRoot) augmentedRoot, Integer.parseInt(augmentedFormula));
                    mudharaymajhool = AugmentedPassivePresentConjugator.getInstance().
                            getEmphasizedConjugator().createVerbList((AugmentedTrilateralRoot) augmentedRoot, Integer.parseInt(augmentedFormula));
                    break;
            }
            nahiamr = AugmentedActivePresentConjugator.getInstance().
                    getJussiveConjugator().createVerbList((AugmentedTrilateralRoot) augmentedRoot, Integer.parseInt(augmentedFormula));
            amr = AugmentedImperativeConjugator.getInstance().
                    getNotEmphsizedConjugator().createVerbList((AugmentedTrilateralRoot) augmentedRoot, Integer.parseInt(augmentedFormula));
            final MazeedConjugationResult madhiconjresult = AugmentedTrilateralModifier.getInstance().build((AugmentedTrilateralRoot) augmentedRoot, rule.getKov(), Integer.parseInt(augmentedRoot.getForm()), madhi,
                    SystemConstants.PAST_TENSE, true, true);
            final MazeedConjugationResult madhimajhoolconj = AugmentedTrilateralModifier.getInstance().build((AugmentedTrilateralRoot) augmentedRoot, rule.getKov(), Integer.parseInt(augmentedRoot.getForm()), madhimajhool,
                    SystemConstants.PAST_TENSE, true, true);
            final MazeedConjugationResult mudharayconj = AugmentedTrilateralModifier.getInstance().build((AugmentedTrilateralRoot) augmentedRoot, rule.getKov(), Integer.parseInt(augmentedRoot.getForm()), mudharay,
                    SystemConstants.PRESENT_TENSE, true, true);
            final MazeedConjugationResult mudharaymajhoolconj = AugmentedTrilateralModifier.getInstance().build((AugmentedTrilateralRoot) augmentedRoot, rule.getKov(), Integer.parseInt(augmentedRoot.getForm()), mudharaymajhool,
                    SystemConstants.PRESENT_TENSE, false, true);
            final MazeedConjugationResult amrconj = AugmentedTrilateralModifier.getInstance().build((AugmentedTrilateralRoot) augmentedRoot, rule.getKov(), Integer.parseInt(augmentedRoot.getForm()), amr,
                    SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE, true, true);
            final MazeedConjugationResult nahiamrconj = AugmentedTrilateralModifier.getInstance().build((AugmentedTrilateralRoot) augmentedRoot, rule.getKov(), Integer.parseInt(augmentedRoot.getForm()), nahiamr,
                    SystemConstants.PRESENT_TENSE, true, true);
            ismfael = AugmentedTrilateralActiveParticipleConjugator.getInstance().createNounList((AugmentedTrilateralRoot) augmentedRoot,
                    Integer.parseInt(augmentedFormula));
            MazeedConjugationResult conjResult = ActiveParticipleModifier.getInstance().build((AugmentedTrilateralRoot) augmentedRoot, rule.getKov(),
                    Integer.parseInt(augmentedRoot.getForm()), ismfael, true);
            ismfael = conjResult.getFinalResult();
            ismmafool = AugmentedTrilateralPassiveParticipleConjugator.getInstance().createNounList((AugmentedTrilateralRoot) augmentedRoot,
                    Integer.parseInt(augmentedFormula));
            MazeedConjugationResult ismmafoolresult = ActiveParticipleModifier.getInstance().build((AugmentedTrilateralRoot) augmentedRoot, rule.getKov(),
                    Integer.parseInt(augmentedRoot.getForm()), ismmafool, true);
            ismmafool = conjResult.getFinalResult();
            madhi = madhiconjresult.getFinalResult();
            madhimajhool = madhimajhoolconj.getFinalResult();
            mudharay = mudharayconj.getFinalResult();
            mudharaymajhool = mudharaymajhoolconj.getFinalResult();
            amr = amrconj.getFinalResult();
            nahiamr = nahiamrconj.getFinalResult();
            amr.removeAll(Collections.singleton(null));
            String la = "لا";
            final List list = nahiamr.subList(6, 11);
            ArrayList<String> nm = new ArrayList<>();
            StringBuilder sb;
            for (Object o : list) {
                sb = new StringBuilder();
                nm.add(sb.append(la).append(" ").append(o.toString()).toString());

            }
            List<String> listmadhi = new ArrayList<>();
            List<String> listmadhimajhool = new ArrayList<>();
            List<String> listmudharay = new ArrayList<>();
            List<String> listmudharymajhool = new ArrayList<>();
            List<String> listamr = new ArrayList<>();
            List<String> listamrnahi = new ArrayList<>();
            List<String> listismfael = new ArrayList<>();
            List<String> listismmafool = new ArrayList<>();
            List<String> vdetails = new ArrayList<>();
            vdetails.add(String.valueOf(rule.getDesc()));
            vdetails.add(augmentedRoot.getBabname());
            //vdetails.add(    rule.getDesc());
            vdetails.add(verbroot);
            for (Object s : madhi) {
                listmadhi.add(s.toString());

            }
            for (Object s : madhimajhool) {
                try {
                    listmadhimajhool.add(s.toString());

                } catch (NullPointerException e) {
                    listmadhimajhool.add("-");
                }

            }
            for (Object s : mudharay) {
                listmudharay.add(s.toString());

            }
            for (Object s : mudharaymajhool) {
                try {
                    listmudharymajhool.add(s.toString());

                } catch (NullPointerException e) {
                    listmudharymajhool.add("-");
                }

            }
            for (Object s : ismfael) {
                listismfael.add(s.toString());

            }
            for (Object s : ismmafool) {
                listismmafool.add(s.toString());

            }
            for (Object s : amr) {
                listamr.add(s.toString());

            }
            for (Object s : nm) {
                listamrnahi.add(s.toString());

            }
            vdetails.add(listmadhi.get(0));
            vdetails.add(listmadhimajhool.get(0));
            vdetails.add(listmudharay.get(0));
            vdetails.add(listmudharymajhool.get(0));
            vdetails.add(listamr.get(0));
            vdetails.add(listamrnahi.get(0));
            vdetails.add(listismfael.get(0));
            vdetails.add(listismmafool.get(0));
            vdetails.add("");
            vdetails.add("");
            vdetails.add("");
            vdetails.add("");
            vdetails.add("");
            vdetails.add("");
            vdetails.add("mazeed");
            vdetails.add(augmentedRoot.getForm());
            skabeer.add((ArrayList) vdetails);
            skabeer.add((ArrayList) listmadhi);
            skabeer.add((ArrayList) listmadhimajhool);
            skabeer.add((ArrayList) listmudharay);
            skabeer.add((ArrayList) listmudharymajhool);
            skabeer.add((ArrayList) listamr);
            skabeer.add((ArrayList) listamrnahi);
            skabeer.add((ArrayList) listismfael);
            skabeer.add((ArrayList) listismmafool);
            return skabeer;
        }
        return skabeer;
    }

    @NonNull
    private ArrayList<ArrayList> buildAugmentedLists(String verbmood, String verbroot) {
        AugmentedTrilateralRoot augmentedRoot = SarfDictionary.getInstance().getAugmentedTrilateralRoot(verbroot);
        List ismfael;
        List ismmafool;
        List madhimajhool;
        List mudharay = null;
        List amr, nahiamr;
        List madhi;
        List mudharaymajhool = null;
        char c1 = verbroot.charAt(0);
        char c2 = verbroot.charAt(1);
        char c3 = verbroot.charAt(2);
        ArrayList<ArrayList> skabeer = new ArrayList<>();
        TrilateralKovRule rule = KovRulesManager.getInstance().getTrilateralKovRule(c1, c2, c3);
        if (augmentedRoot != null) {
            //    if (selectionInfo.isAugmented()) {
            madhi = AugmentedActivePastConjugator.getInstance().createVerbList((AugmentedTrilateralRoot) augmentedRoot, Integer.parseInt(augmentedRoot.getForm()));
            madhimajhool = AugmentedPassivePastConjugator.getInstance().createVerbList((AugmentedTrilateralRoot) augmentedRoot, Integer.parseInt(augmentedRoot.getForm()));
            switch (verbmood) {
                case "Indicative":
                    mudharay = AugmentedActivePresentConjugator.getInstance().
                            getNominativeConjugator().createVerbList((AugmentedTrilateralRoot) augmentedRoot, Integer.parseInt(augmentedRoot.getForm()));
                    mudharaymajhool = AugmentedPassivePresentConjugator.getInstance().
                            getNominativeConjugator().createVerbList((AugmentedTrilateralRoot) augmentedRoot, Integer.parseInt(augmentedRoot.getForm()));
                    break;
                case "Subjunctive":
                    mudharay = AugmentedActivePresentConjugator.getInstance().
                            getAccusativeConjugator().createVerbList((AugmentedTrilateralRoot) augmentedRoot, Integer.parseInt(augmentedRoot.getForm()));
                    mudharaymajhool = AugmentedPassivePresentConjugator.getInstance().
                            getAccusativeConjugator().createVerbList((AugmentedTrilateralRoot) augmentedRoot, Integer.parseInt(augmentedRoot.getForm()));
                    break;
                case "Jussive":
                    mudharay = AugmentedActivePresentConjugator.getInstance().
                            getJussiveConjugator().createVerbList((AugmentedTrilateralRoot) augmentedRoot, Integer.parseInt(augmentedRoot.getForm()));
                    mudharaymajhool = AugmentedPassivePresentConjugator.getInstance().
                            getJussiveConjugator().createVerbList((AugmentedTrilateralRoot) augmentedRoot, Integer.parseInt(augmentedRoot.getForm()));
                    break;
                case "Emphasized":
                    mudharay = AugmentedActivePresentConjugator.getInstance().
                            getEmphasizedConjugator().createVerbList((AugmentedTrilateralRoot) augmentedRoot, Integer.parseInt(augmentedRoot.getForm()));
                    mudharaymajhool = AugmentedPassivePresentConjugator.getInstance().
                            getEmphasizedConjugator().createVerbList((AugmentedTrilateralRoot) augmentedRoot, Integer.parseInt(augmentedRoot.getForm()));
                    break;
            }
            nahiamr = AugmentedActivePresentConjugator.getInstance().
                    getJussiveConjugator().createVerbList((AugmentedTrilateralRoot) augmentedRoot, Integer.parseInt(augmentedRoot.getForm()));
            amr = AugmentedImperativeConjugator.getInstance().
                    getNotEmphsizedConjugator().createVerbList((AugmentedTrilateralRoot) augmentedRoot, Integer.parseInt(augmentedRoot.getForm()));
            final MazeedConjugationResult madhiconjresult = AugmentedTrilateralModifier.getInstance().build((AugmentedTrilateralRoot) augmentedRoot, rule.getKov(), Integer.parseInt(augmentedRoot.getForm()), madhi,
                    SystemConstants.PAST_TENSE, true, true);
            final MazeedConjugationResult madhimajhoolconj = AugmentedTrilateralModifier.getInstance().build((AugmentedTrilateralRoot) augmentedRoot, rule.getKov(), Integer.parseInt(augmentedRoot.getForm()), madhimajhool,
                    SystemConstants.PAST_TENSE, true, true);
            final MazeedConjugationResult mudharayconj = AugmentedTrilateralModifier.getInstance().build((AugmentedTrilateralRoot) augmentedRoot, rule.getKov(), Integer.parseInt(augmentedRoot.getForm()), mudharay,
                    SystemConstants.PRESENT_TENSE, true, true);
            final MazeedConjugationResult mudharaymajhoolconj = AugmentedTrilateralModifier.getInstance().build((AugmentedTrilateralRoot) augmentedRoot, rule.getKov(), Integer.parseInt(augmentedRoot.getForm()), mudharaymajhool,
                    SystemConstants.PRESENT_TENSE, false, true);
            final MazeedConjugationResult amrconj = AugmentedTrilateralModifier.getInstance().build((AugmentedTrilateralRoot) augmentedRoot, rule.getKov(), Integer.parseInt(augmentedRoot.getForm()), amr,
                    SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE, true, true);
            final MazeedConjugationResult nahiamrconj = AugmentedTrilateralModifier.getInstance().build((AugmentedTrilateralRoot) augmentedRoot, rule.getKov(), Integer.parseInt(augmentedRoot.getForm()), nahiamr,
                    SystemConstants.PRESENT_TENSE, true, true);
            ismfael = AugmentedTrilateralActiveParticipleConjugator.getInstance().createNounList((AugmentedTrilateralRoot) augmentedRoot,
                    Integer.parseInt(augmentedRoot.getForm()));
            MazeedConjugationResult conjResult = ActiveParticipleModifier.getInstance().build((AugmentedTrilateralRoot) augmentedRoot, rule.getKov(),
                    Integer.parseInt(augmentedRoot.getForm()), ismfael, true);
            ismfael = conjResult.getFinalResult();
            ismmafool = AugmentedTrilateralPassiveParticipleConjugator.getInstance().createNounList((AugmentedTrilateralRoot) augmentedRoot,
                    Integer.parseInt(augmentedRoot.getForm()));
            MazeedConjugationResult ismmafoolresult = ActiveParticipleModifier.getInstance().build((AugmentedTrilateralRoot) augmentedRoot, rule.getKov(),
                    Integer.parseInt(augmentedRoot.getForm()), ismmafool, true);
            ismmafool = conjResult.getFinalResult();
            madhi = madhiconjresult.getFinalResult();
            madhimajhool = madhimajhoolconj.getFinalResult();
            mudharay = mudharayconj.getFinalResult();
            mudharaymajhool = mudharaymajhoolconj.getFinalResult();
            amr = amrconj.getFinalResult();
            nahiamr = nahiamrconj.getFinalResult();
            amr.removeAll(Collections.singleton(null));
            String la = "لا";
            final List list = nahiamr.subList(6, 11);
            ArrayList<String> nm = new ArrayList<>();
            StringBuilder sb;
            for (Object o : list) {
                sb = new StringBuilder();
                nm.add(sb.append(la).append(" ").append(o.toString()).toString());

            }
            List<String> listmadhi = new ArrayList<>();
            List<String> listmadhimajhool = new ArrayList<>();
            List<String> listmudharay = new ArrayList<>();
            List<String> listmudharymajhool = new ArrayList<>();
            List<String> listamr = new ArrayList<>();
            List<String> listamrnahi = new ArrayList<>();
            List<String> listismfael = new ArrayList<>();
            List<String> listismmafool = new ArrayList<>();
            List<String> vdetails = new ArrayList<>();
            vdetails.add(String.valueOf(rule.getDesc()));
            vdetails.add(augmentedRoot.getBabname());
            //vdetails.add(    rule.getDesc());
            vdetails.add(verbroot);
            for (Object s : madhi) {
                listmadhi.add(s.toString());

            }
            for (Object s : madhimajhool) {
                try {
                    listmadhimajhool.add(s.toString());

                } catch (NullPointerException e) {
                    listmadhimajhool.add("-");
                }

            }
            for (Object s : mudharay) {
                listmudharay.add(s.toString());

            }
            for (Object s : mudharaymajhool) {
                try {
                    listmudharymajhool.add(s.toString());

                } catch (NullPointerException e) {
                    listmudharymajhool.add("-");
                }

            }
            for (Object s : ismfael) {
                listismfael.add(s.toString());

            }
            for (Object s : ismmafool) {
                listismmafool.add(s.toString());

            }
            for (Object s : amr) {
                listamr.add(s.toString());

            }
            for (Object s : nm) {
                listamrnahi.add(s.toString());

            }
            vdetails.add(listmadhi.get(0));
            vdetails.add(listmadhimajhool.get(0));
            vdetails.add(listmudharay.get(0));
            vdetails.add(listmudharymajhool.get(0));
            vdetails.add(listamr.get(0));
            vdetails.add(listamrnahi.get(0));
            vdetails.add(listismfael.get(0));
            vdetails.add(listismmafool.get(0));
            vdetails.add("");
            vdetails.add("");
            vdetails.add("");
            vdetails.add("");
            vdetails.add("");
            vdetails.add("");
            vdetails.add("mazeed");
            vdetails.add(augmentedRoot.getForm());
            skabeer.add((ArrayList) vdetails);
            skabeer.add((ArrayList) listmadhi);
            skabeer.add((ArrayList) listmadhimajhool);
            skabeer.add((ArrayList) listmudharay);
            skabeer.add((ArrayList) listmudharymajhool);
            skabeer.add((ArrayList) listamr);
            skabeer.add((ArrayList) listamrnahi);
            skabeer.add((ArrayList) listismfael);
            skabeer.add((ArrayList) listismmafool);
            return skabeer;
        }
        return skabeer;
    }

    public ArrayList<ArrayList> buildAugmenteParticiples(String verbroot, String
            augmentedFormula) {
        char c1 = verbroot.charAt(0);
        char c2 = verbroot.charAt(1);
        char c3 = verbroot.charAt(2);
        Character C1 = verbroot.charAt(0);
        Character C2 = verbroot.charAt(1);
        Character C3 = verbroot.charAt(2);
        int aleph = verbroot.indexOf("ا");
        int alephhamza = verbroot.indexOf("أ");
        if (aleph != -1) {
            verbroot = verbroot.replace("ا", "ء");
        } else if (alephhamza != -1) {
            verbroot = verbroot.replace("أ", "ء");
        }
        AugmentedTrilateralRoot augmentedRoot = SarfDictionary.getInstance().getAugmentedTrilateralRoot(verbroot, augmentedFormula);
        List ismfael;
        List ismmafool;
        ArrayList<ArrayList> skabeer = new ArrayList<>();
        if (augmentedRoot != null) {
            TrilateralKovRule rule = KovRulesManager.getInstance().getTrilateralKovRule(c1, c2, c3);
            ismfael = AugmentedTrilateralActiveParticipleConjugator.getInstance().createNounList((AugmentedTrilateralRoot) augmentedRoot,
                    Integer.parseInt(augmentedFormula));
            MazeedConjugationResult conjResult = ActiveParticipleModifier.getInstance().build((AugmentedTrilateralRoot) augmentedRoot, rule.getKov(),
                    Integer.parseInt(augmentedRoot.getForm()), ismfael, true);
            ismfael = conjResult.getFinalResult();
            ismmafool = AugmentedTrilateralPassiveParticipleConjugator.getInstance().createNounList((AugmentedTrilateralRoot) augmentedRoot,
                    Integer.parseInt(augmentedFormula));
            MazeedConjugationResult ismmafoolresult = ActiveParticipleModifier.getInstance().build((AugmentedTrilateralRoot) augmentedRoot, rule.getKov(),
                    Integer.parseInt(augmentedRoot.getForm()), ismmafool, true);
            ismmafool = ismmafoolresult.getFinalResult();
            List<String> listismfael = new ArrayList<String>(ismfael);
            List<String> listismmafool = new ArrayList<String>(ismmafool);
            List<String> vdetails = new ArrayList<>();
            vdetails.add(String.valueOf(rule.getDesc()));
            vdetails.add(augmentedRoot.getBabname());
            skabeer.add((ArrayList) listismfael);
            skabeer.add((ArrayList) listismmafool);
            return skabeer;
        }
        return skabeer;
    }

}
