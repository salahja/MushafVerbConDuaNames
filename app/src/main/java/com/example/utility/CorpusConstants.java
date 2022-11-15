package com.example.utility;

public interface CorpusConstants {
    interface Nominals {
        String N = "Noun(اسم)",
                PN = "Proper Noun(اسم علم)",
                ADJ = "Adjective(صفة)",
                VN = "Verbal noun(مصدر)",
                IMPN = "Imperative Verbal Noun(اسم فعل أمر)",
                PRON = "Pronouns(ضمير)",
                DEM = "Demonstrative Pronoun(اسم اشارة)",
                REL = "Relative Pronoun(اسم موصول)",
                T = "Time Adverb(ظرف زمان)",
                LOC = "Location Adverb(ظرف مكان)";
    }

    interface NominalsEnglish {
        String N = "Noun ",
                PN = "Proper Noun ",
                ADJ = "Adjective ",
                VN = "Verbal noun ",
                IMPN = "Imperative Verbal Noun ",
                PRON = "Pronouns(ضمير)",
                DEM = "Demonstrative Pronoun ",
                REL = "Relative Pronoun ",
                T = "Time Adverb ",
                LOC = "Location Adverb ";
    }

    interface NominalsProp {
        String ACT = "Active ",
                PCPL = "PCPL",
                PASS = "Passive ",
        ACTPCPL = "Active participle(اسم فاعل) ",
                PASSPCPL = "Passive participle(سم مفعول) ",
                VN = "Verbal noun(مصدر)",
                INDEF = "Indefinite(نكرة)",
                DEF = " Definite(معرفة) ",
                NOM = "Nominative(مرفوع)",
                ACC = "Accusative( نصب)",
                GEN = " Genitive(نكرة)",
                T = "Time Adverb(ظرف زمان)",
                LOC = "Location Adverb(ظرف مكان)";
    }

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

    interface verbfeaturesenglisharabic {
        String PERF = "Perfect verb(فعل ماض)",
                IMPF = "Imperfect verb(فعل مضارع)",
                IMPV = "	Imperative verb(فعل أمر )",
                IND = "Indicative mood (مرفوع)",
                SUBJ = "	Subjunctive mood(منصوب)",
                JUS = "	Jussive mood(مجزوم)",
                ACT = "	Active voice(مبني للمعلوم)",
                V = "Verb(فعل)",
                PASS = "	Passive voice(مبني للمجهول)";

    }

    interface verbfeaturesenglish {
        String PERF = "Perfect ",
                IMPF = "Imperfect",
                IMPV = "Imperative",
                IND = "Indicative ",
                SUBJ = "Subjunctive. ",
                JUS = "	Jussive  ",
                ACT = "	Active",
                PASS = "Passive";

    }

    interface png {
        String one = "First person ",
                two = "Second Person ",
                three = "Third Person ",
                M = "Masculine ",
                F = "Feminine ",
                S = "Singular ",
                P = "Plural ",
                D = "Dual ";
    }

    interface thulathi {
        String NASARA = "نصر",
                ZARABA = "ضرب",
                FATAH = "فتح",  //  A-A // FATHA-YAFTAHU
                SAMIA = "سمح",   //  I-A  //SAMIA-YASMAHU
                KARUMU = "كرم",   //   U-U  //KARUMA-YAKRUMU
                HASIBA = "حسب";    //  I-I  //HASIBA-YAHSIU

    }

}
