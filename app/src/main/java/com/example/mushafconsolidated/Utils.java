package com.example.mushafconsolidated;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.sqlite.db.SimpleSQLiteQuery;

import com.example.mushafconsolidated.Entities.AllahNamesDetails;
import com.example.mushafconsolidated.Entities.BadalErabNotesEnt;
import com.example.mushafconsolidated.Entities.BookMarks;
import com.example.mushafconsolidated.Entities.ChaptersAnaEntity;
import com.example.mushafconsolidated.Entities.CorpusExpandWbwPOJO;
import com.example.mushafconsolidated.Entities.CorpusNounWbwOccurance;
import com.example.mushafconsolidated.Entities.CorpusVerbWbwOccurance;
import com.example.mushafconsolidated.Entities.GrammarRules;
import com.example.mushafconsolidated.Entities.HalEnt;
import com.example.mushafconsolidated.Entities.KanaPOJO;
import com.example.mushafconsolidated.Entities.LiajlihiEnt;
import com.example.mushafconsolidated.Entities.MafoolBihi;
import com.example.mushafconsolidated.Entities.MafoolMutlaqEnt;
import com.example.mushafconsolidated.Entities.MudhafPOJO;
import com.example.mushafconsolidated.Entities.NewCorpusExpandWbwPOJO;
import com.example.mushafconsolidated.Entities.NewKanaEntity;
import com.example.mushafconsolidated.Entities.NewMudhafEntity;
import com.example.mushafconsolidated.Entities.NewNasbEntity;
import com.example.mushafconsolidated.Entities.NewShartEntity;
import com.example.mushafconsolidated.Entities.NounCorpus;
import com.example.mushafconsolidated.Entities.NounCorpusBreakup;
import com.example.mushafconsolidated.Entities.QuranEntity;
import com.example.mushafconsolidated.Entities.ShartPOJO;
import com.example.mushafconsolidated.Entities.SifaEntity;
import com.example.mushafconsolidated.Entities.SifaPOJO;
import com.example.mushafconsolidated.Entities.TameezEnt;
import com.example.mushafconsolidated.Entities.TameezPOJO;
import com.example.mushafconsolidated.Entities.TameezPojoList;
import com.example.mushafconsolidated.Entities.VerbCorpus;
import com.example.mushafconsolidated.Entities.VerbCorpusBreakup;
import com.example.mushafconsolidated.Entities.hanslexicon;
import com.example.mushafconsolidated.Entities.lanelexicon;
import com.example.mushafconsolidated.Entities.lughat;
import com.example.mushafconsolidated.Entities.qurandictionary;
import com.example.mushafconsolidated.Entities.quranexplorer;
import com.example.mushafconsolidated.Entities.surahsummary;
import com.example.mushafconsolidated.Entities.wbwentity;

import java.util.ArrayList;
import java.util.List;

import database.entity.AllahNames;
import database.entity.DuaDetails;
import database.entity.DuaGroup;
import sj.hisnul.entity.hcategory;
import sj.hisnul.entity.hduadetails;
import sj.hisnul.entity.hduanames;
//import com.example.mushafconsolidated.Entities.JoinVersesTranslationDataTranslation;

public class Utils {
    private static final String TAG = "Utils";
    private static QuranAppDatabase database;
    final Context thiscontext;

    public Utils(Context context) {
        database = QuranAppDatabase.getInstance(context);
        this.thiscontext = context;

    }

    public static List<BookMarks> getBookMarksNew() {
        return database.BookMarkDao().getBookMarks();

    }

    public static List<QuranEntity> getsurahayahVerses(int id, int aid) {
        return database.QuranDao().getsurahayahVerses(id, aid);

    }

    public static List<QuranEntity> getQuranbySurah(int id) {
        return database.QuranDao().getQuranVersesBySurah(id);

    }

    public static List<QuranEntity> getQuran() {
        return database.QuranDao().getAllQuran();

    }

    public static void deleteBookMarks(BookMarks bookMarks) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                database.BookMarkDao().deletebookmark(bookMarks);
                return null;
            }
        }.execute();

    }

    public static ArrayList<hduanames> getAllList() {
        ArrayList<hduanames> duat = (ArrayList<hduanames>) database.hDuaNamesDao().getDuanames();
        return duat;

    }

    public static ArrayList<hduanames> getdualistbychapter(int cid) {
        ArrayList<hduanames> duat = (ArrayList<hduanames>) database.hDuaNamesDao().getdualistbychapter(cid);
        return duat;

    }

    public static ArrayList<hcategory> getHcategory() {
        ArrayList<hcategory> duat = (ArrayList<hcategory>) database.hDuaCategoryDao().getcatetory();
        return duat;

    }

    public ArrayList<surahsummary> getSurahSummary(int id) {
        ArrayList<surahsummary> dua = (ArrayList<surahsummary>) database.surahsummaryDao().getSurahSummary(id);
        return dua;

    }

    public ArrayList<AllahNamesDetails> getNamesDetails(int id) {
        ArrayList<AllahNamesDetails> dua = (ArrayList<AllahNamesDetails>) database.NamesDetailsDao().ALLAH_NAMES_DETAILS_DETAILS(id);
        return dua;

    }

    public ArrayList<AllahNames> getNames() {
        ArrayList<AllahNames> names = (ArrayList<AllahNames>) database.NamesDao().ALLAH_NAMES_LIST();
        return names;

    }

    public ArrayList<DuaGroup> getDuagroup() {
        ArrayList<DuaGroup> dua = (ArrayList<DuaGroup>) database.DuaGroupDao().getAllDua();
        return dua;

    }

    public ArrayList<DuaDetails> getDuagroup(int id) {
        ArrayList<DuaDetails> dua = (ArrayList<DuaDetails>) database.DuaDao().getDua(id);
        return dua;

    }

    public ArrayList<NewMudhafEntity> getMudhafSurahNew(int id) {
        return (ArrayList<NewMudhafEntity>) database.NewMudhafDao().getMudhafSurah(id);

    }

    public ArrayList<NewMudhafEntity> getMudhafSurahAyahNew(int id, int aid) {
        return (ArrayList<NewMudhafEntity>) database.NewMudhafDao().getMudhafSurahAyah(id, aid);

    }

    public ArrayList<ChaptersAnaEntity> getAllAnaChapters() {
        Log.d(TAG, "getAllAnaChapters: started");
        return (ArrayList<ChaptersAnaEntity>) database.AnaQuranChapterDao().getChapters();

    }

    public ArrayList<ChaptersAnaEntity> getSingleChapter(int id) {
        Log.d(TAG, "getSingleChapter: started");
        return (ArrayList<ChaptersAnaEntity>) database.AnaQuranChapterDao().getSingleChapters(id);

    }

    public ArrayList<BookMarks> getBookMarks() {
        Log.d(TAG, "getAllItems: started");
        return (ArrayList<BookMarks>) database.BookMarkDao().getBookMarks();
    }

    public ArrayList<VerbCorpus> getQuranRoot(int id, int verseid, int wordid) {
        Log.d(TAG, "getQuranRoot: started");
        return (ArrayList<VerbCorpus>) database.VerbCorpusDao().getQuranRoot(id, verseid, wordid);
    }

    public ArrayList<VerbCorpus> getQuranRootaAyah(int id, int verseid) {
        Log.d(TAG, "getQuranRoot: getQuranRootaAyah");
        return (ArrayList<VerbCorpus>) database.VerbCorpusDao().getQuranRootaAyah(id, verseid);
    }

    public ArrayList<NounCorpus> getQuranNouns(int id, int verseid, int wordid) {
        Log.d(TAG, "getQuranNouns: started");
        return (ArrayList<NounCorpus>) database.NounCorpusDao().getQuranNouns(id, verseid, wordid);
    }

    public ArrayList<NounCorpus> getQuranNounAyah(int id, int verseid) {
        Log.d(TAG, "getQuranNouns: started");
        return (ArrayList<NounCorpus>) database.NounCorpusDao().getQuranNounAyah(id, verseid);
    }

    public ArrayList<wbwentity> getwbwTranslatonbywordNew(int id, int ayaid, int wordid) {
        Log.d(TAG, "getwbwTranslatonbyword: started");
        return (ArrayList<wbwentity>) database.wbwDao().getwbwTranslationbywordno(id, ayaid, wordid);
    }

    public void insertBookMark(BookMarks entity) {
        //    database.BookMarkDao().deleteAllBookMakrs();
        AsyncTask.execute(() -> AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                // and deleting
                database.BookMarkDao().insertBookmark(entity);
                //  runOnUiThread(new Runnable() {
                //  public void run() {
                //   itemTextView.setText("item deleted");
                //    }
                //  });
            }
        }));

    }

    public ArrayList<NewCorpusExpandWbwPOJO> getCorpusWbwBySurahAyahWordid(int tid, int aid, int wid) {
        String sqlverb = "SELECT CorpusExpand.rootaraone || rootaratwo || rootarathree || rootarafour || rootarafive AS root_a,\n" +
                "       CorpusExpand.surah,\n" +
                "       CorpusExpand.ayah,\n" +
                "       CorpusExpand.wordno,\n" +
                "       CorpusExpand.wordcount,\n" +
                "       Qurans.translation,\n" +
                "       Qurans.ur_junagarhi,\n" +
                "       CorpusExpand.araone,\n" +
                "       CorpusExpand.aratwo,\n" +
                "       CorpusExpand.arathree,\n" +
                "       CorpusExpand.arafour,\n" +
                "       CorpusExpand.arafive,\n" +
                "       CorpusExpand.rootaraone,\n" +
                "       CorpusExpand.rootaratwo,\n" +
                "       CorpusExpand.rootarathree,\n" +
                "       CorpusExpand.rootarafour,\n" +
                "       CorpusExpand.rootarafive,\n" +
                "       CorpusExpand.lemaraone,\n" +
                "       CorpusExpand.lemaratwo,\n" +
                "       CorpusExpand.lemarathree,\n" +
                "       CorpusExpand.lemarafour,\n" +
                "       CorpusExpand.lemarafive,\n" +
                "            CorpusExpand.form_one,\n" +
                "       CorpusExpand.form_two,\n" +
                "       CorpusExpand.form_three,\n" +
                "       CorpusExpand.form_four,\n" +
                "       CorpusExpand.form_five,\n" +
                "       CorpusExpand.tagone,\n" +
                "       CorpusExpand.tagtwo,\n" +
                "       CorpusExpand.tagthree,\n" +
                "       CorpusExpand.tagfour,\n" +
                "       CorpusExpand.tagfive,\n" +
                "       CorpusExpand.detailsone,\n" +
                "       CorpusExpand.detailstwo,\n" +
                "       CorpusExpand.detailsthree,\n" +
                "       CorpusExpand.detailsfour,\n" +
                "       CorpusExpand.detailsfive,\n" +
                "       wbw.en,\n" +
                "       wbw.bn,\n" +
                "       wbw.[in],\n" +
                "       wbw.ur,\n" +
                "       qurans.qurantext\n" +
                "  FROM corpusexpand,\n" +
                "       qurans,\n" +
                "       wbw\n" +
                " WHERE CorpusExpand.surah == \""
                + tid + "\""
                + "AND CorpusExpand.ayah== \""
                + aid + "\""
                + "AND CorpusExpand.wordno==\""
                + wid + "\""
                + "AND \n" +
                "       corpusexpand.surah = wbw.surah AND \n" +
                "       corpusexpand.ayah = wbw.ayah AND \n" +
                "       corpusexpand.wordno = wbw.wordno AND\n" +
                "       corpusexpand.surah = qurans.surah AND \n" +
                "       corpusexpand.ayah = qurans.ayah  \n" +
                " ORDER BY corpusexpand.surah,\n" +
                "          corpusexpand.ayah";
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(sqlverb);
        //  List<Book> result = booksDao.getBooks(query);
        return (ArrayList<NewCorpusExpandWbwPOJO>) database.RawDao().getNewCorpusWbw(query);
    }

    public ArrayList<NewCorpusExpandWbwPOJO> getCorpusWbwBySurahAyah(int tid, int aid) {
        String sqlverb = "SELECT CorpusExpand.rootaraone || rootaratwo || rootarathree || rootarafour || rootarafive AS root_a,\n" +
                "       CorpusExpand.surah,\n" +
                "       CorpusExpand.ayah,\n" +
                "       CorpusExpand.wordno,\n" +
                "       CorpusExpand.wordcount,\n" +
                "       Qurans.translation,\n" +
                "       CorpusExpand.araone,\n" +
                "       CorpusExpand.aratwo,\n" +
                "       CorpusExpand.arathree,\n" +
                "       CorpusExpand.arafour,\n" +
                "       CorpusExpand.arafive,\n" +
                "       CorpusExpand.rootaraone,\n" +
                "       CorpusExpand.rootaratwo,\n" +
                "       CorpusExpand.rootarathree,\n" +
                "       CorpusExpand.rootarafour,\n" +
                "       CorpusExpand.rootarafive,\n" +
                "       CorpusExpand.lemaraone,\n" +
                "       CorpusExpand.lemaratwo,\n" +
                "       CorpusExpand.lemarathree,\n" +
                "       CorpusExpand.lemarafour,\n" +
                "       CorpusExpand.lemarafive,\n" +
                "            CorpusExpand.form_one,\n" +
                "       CorpusExpand.form_two,\n" +
                "       CorpusExpand.form_three,\n" +
                "       CorpusExpand.form_four,\n" +
                "       CorpusExpand.form_five,\n" +
                "       CorpusExpand.tagone,\n" +
                "       CorpusExpand.tagtwo,\n" +
                "       CorpusExpand.tagthree,\n" +
                "       CorpusExpand.tagfour,\n" +
                "       CorpusExpand.tagfive,\n" +
                "       CorpusExpand.detailsone,\n" +
                "       CorpusExpand.detailstwo,\n" +
                "       CorpusExpand.detailsthree,\n" +
                "       CorpusExpand.detailsfour,\n" +
                "       CorpusExpand.detailsfive,\n" +
                "       wbw.en,\n" +
                "       wbw.bn,\n" +
                "       wbw.[in],\n" +
                "       wbw.ur,\n" +
                "       qurans.qurantext\n" +
                "  FROM corpusexpand,\n" +
                "       qurans,\n" +
                "       wbw\n" +
                " WHERE CorpusExpand.surah == \""
                + tid + "\""
                + "AND CorpusExpand.ayah== \""
                + aid + "\""
                + "AND \n" +
                "       corpusexpand.surah = wbw.surah AND \n" +
                "       corpusexpand.ayah = wbw.ayah AND \n" +
                "       corpusexpand.wordno = wbw.wordno AND\n" +
                "       corpusexpand.surah = qurans.surah AND \n" +
                "       corpusexpand.ayah = qurans.ayah  \n" +
                " ORDER BY corpusexpand.surah,\n" +
                "          corpusexpand.ayah";
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(sqlverb);
        //  List<Book> result = booksDao.getBooks(query);
        return (ArrayList<NewCorpusExpandWbwPOJO>) database.RawDao().getNewCorpusWbw(query);
    }

    public ArrayList<CorpusExpandWbwPOJO> getCorpusWbwBySurahForTameez(int tid) {
        String sqlverb = "SELECT CorpusExpand.rootaraone || rootaratwo || rootarathree || rootarafour || rootarafive AS root_a,\n" +
                "       CorpusExpand.surah,\n" +
                "       CorpusExpand.ayah,\n" +
                "       CorpusExpand.wordno,\n" +
                "       CorpusExpand.wordcount,\n" +
                "       Qurans.translation,\n" +
                "       CorpusExpand.araone,\n" +
                "       CorpusExpand.aratwo,\n" +
                "       CorpusExpand.arathree,\n" +
                "       CorpusExpand.arafour,\n" +
                "       CorpusExpand.arafive,\n" +
                "       CorpusExpand.tagone,\n" +
                "       CorpusExpand.tagtwo,\n" +
                "       CorpusExpand.tagthree,\n" +
                "       CorpusExpand.tagfour,\n" +
                "       CorpusExpand.tagfive,\n" +
                "       CorpusExpand.detailsone,\n" +
                "       CorpusExpand.detailstwo,\n" +
                "       CorpusExpand.detailsthree,\n" +
                "       CorpusExpand.detailsfour,\n" +
                "       CorpusExpand.detailsfive,\n" +
                "       wbw.en,\n" +
                "       wbw.bn,\n" +
                "       wbw.[in],\n" +
                "       wbw.ur,\n" +
                "       qurans.qurantext\n" +
                "  FROM corpusexpand,\n" +
                "       qurans,\n" +
                "       wbw,\n" +
                "       tameez\n" +
                " WHERE CorpusExpand.surah == \""
                + tid + "\""
                + "AND \n" +
                "       corpusexpand.surah = wbw.surah AND \n" +
                "       corpusexpand.ayah = wbw.ayah AND \n" +
                "       corpusexpand.wordno = wbw.wordno AND\n" +
                "       corpusexpand.surah = qurans.surah AND \n" +
                "       corpusexpand.ayah = qurans.ayah AND \n" +
                "       corpusexpand.surah = tameez.surah AND \n" +
                "       corpusexpand.ayah = tameez.ayah  \n" +
                " ORDER BY corpusexpand.surah,\n" +
                "          corpusexpand.ayah";
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(sqlverb);
        //  List<Book> result = booksDao.getBooks(query);
        return (ArrayList<CorpusExpandWbwPOJO>) database.RawDao().getCorpusWbwfortameez(query);
    }

    public ArrayList<CorpusExpandWbwPOJO> getCorpusWbwBySurah(int tid) {
        String sqlverb = "SELECT CorpusExpand.rootaraone || rootaratwo || rootarathree || rootarafour || rootarafive AS root_a,\n" +
                "       CorpusExpand.surah,\n" +
                "       CorpusExpand.ayah,\n" +
                "       CorpusExpand.wordno,\n" +
                "       CorpusExpand.wordcount,\n" +
                "       Qurans.translation,\n" +
                "       Qurans.passage_no,\n" +
                "       Qurans.ar_irab_two,\n" +
                "       Qurans.tafsir_kathir,\n" +
                "       Qurans.en_transliteration,\n" +
                "       Qurans.en_jalalayn,\n" +
                "       Qurans.en_arberry,\n" +
                "       Qurans.ur_jalalayn,\n" +
                "       Qurans.ur_junagarhi,\n" +
                "       CorpusExpand.araone,\n" +
                "       CorpusExpand.aratwo,\n" +
                "       CorpusExpand.arathree,\n" +
                "       CorpusExpand.arafour,\n" +
                "       CorpusExpand.arafive,\n" +
                "       CorpusExpand.tagone,\n" +
                "       CorpusExpand.tagtwo,\n" +
                "       CorpusExpand.tagthree,\n" +
                "       CorpusExpand.tagfour,\n" +
                "       CorpusExpand.tagfive,\n" +
                "       CorpusExpand.detailsone,\n" +
                "       CorpusExpand.detailstwo,\n" +
                "       CorpusExpand.detailsthree,\n" +
                "       CorpusExpand.detailsfour,\n" +
                "       CorpusExpand.detailsfive,\n" +
                "       wbw.en,\n" +
                "       wbw.bn,\n" +
                "       wbw.[in],\n" +
                "       wbw.ur,\n" +
                "       qurans.qurantext\n" +
                "  FROM corpusexpand,\n" +
                "       qurans,\n" +
                "       wbw\n" +
                " WHERE CorpusExpand.surah == \""
                + tid + "\""
                + "AND \n" +
                "       corpusexpand.surah = wbw.surah AND \n" +
                "       corpusexpand.ayah = wbw.ayah AND \n" +
                "       corpusexpand.wordno = wbw.wordno AND\n" +
                "       corpusexpand.surah = qurans.surah AND \n" +
                "       corpusexpand.ayah = qurans.ayah  \n" +
                " ORDER BY corpusexpand.surah,\n" +
                "          corpusexpand.ayah";
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(sqlverb);
        //  List<Book> result = booksDao.getBooks(query);
        return (ArrayList<CorpusExpandWbwPOJO>) database.RawDao().getCorpusWbw(query);
    }

    public ArrayList<CorpusExpandWbwPOJO> getCorpusWbwBySurahAyahtopic(int tid, int aid) {
        String sqlverb = "SELECT CorpusExpand.rootaraone || rootaratwo || rootarathree || rootarafour || rootarafive AS root_a,\n" +
                "       CorpusExpand.surah,\n" +
                "       CorpusExpand.ayah,\n" +
                "       CorpusExpand.wordno,\n" +
                "       CorpusExpand.wordcount,\n" +
                "       Qurans.translation,\n" +
                "       Qurans.passage_no,\n" +
                "       Qurans.ar_irab_two,\n" +
                "       Qurans.tafsir_kathir,\n" +
                "       Qurans.en_transliteration,\n" +
                "       Qurans.en_jalalayn,\n" +
                "       Qurans.en_arberry,\n" +
                "       Qurans.ur_jalalayn,\n" +
                "       Qurans.ur_junagarhi,\n" +
                "       CorpusExpand.araone,\n" +
                "       CorpusExpand.aratwo,\n" +
                "       CorpusExpand.arathree,\n" +
                "       CorpusExpand.arafour,\n" +
                "       CorpusExpand.arafive,\n" +
                "       CorpusExpand.tagone,\n" +
                "       CorpusExpand.tagtwo,\n" +
                "       CorpusExpand.tagthree,\n" +
                "       CorpusExpand.tagfour,\n" +
                "       CorpusExpand.tagfive,\n" +
                "       CorpusExpand.detailsone,\n" +
                "       CorpusExpand.detailstwo,\n" +
                "       CorpusExpand.detailsthree,\n" +
                "       CorpusExpand.detailsfour,\n" +
                "       CorpusExpand.detailsfive,\n" +
                "       wbw.en,\n" +
                "       wbw.bn,\n" +
                "       wbw.[in],\n" +
                "       wbw.ur,\n" +
                "       qurans.qurantext\n" +
                "  FROM corpusexpand,\n" +
                "       qurans,\n" +
                "       wbw\n" +
                " WHERE CorpusExpand.surah == \""
                + tid + "\""
                + "AND CorpusExpand.ayah== \""
                + aid + "\""
                + "AND \n" +
                "       corpusexpand.surah = wbw.surah AND \n" +
                "       corpusexpand.ayah = wbw.ayah AND \n" +
                "       corpusexpand.wordno = wbw.wordno AND\n" +
                "       corpusexpand.surah = qurans.surah AND \n" +
                "       corpusexpand.ayah = qurans.ayah  \n" +
                " ORDER BY corpusexpand.surah,\n" +
                "          corpusexpand.ayah";
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(sqlverb);
        //  List<Book> result = booksDao.getBooks(query);
        return (ArrayList<CorpusExpandWbwPOJO>) database.RawDao().getCorpusWbwSurahAyah(query);
    }

    public ArrayList<CorpusNounWbwOccurance> getnounoccuranceHarfNasbZarf(String tid) {
        String sqlverb = "SELECT CorpusExpand.rootaraone || rootaratwo || rootarathree || rootarafour || rootarafive as root_a,\n" +
                "       CorpusExpand.surah,\n" +
                "       CorpusExpand.ayah,\n" +
                "       CorpusExpand.wordno,\n" +
                "       CorpusExpand.wordcount,\n" +
                "         Qurans.qurantext,\n" +
                "       qurans.translation,\n" +
                "       CorpusExpand.araone,\n" +
                "       CorpusExpand.aratwo,\n" +
                "       CorpusExpand.arathree,\n" +
                "       CorpusExpand.arafour,\n" +
                "       CorpusExpand.arafive,\n" +
                "       CorpusExpand.tagone,\n" +
                "       CorpusExpand.tagtwo,\n" +
                "       CorpusExpand.tagthree,\n" +
                "       CorpusExpand.tagfour,\n" +
                "       CorpusExpand.tagfive,\n" +
                "       CorpusExpand.detailsone,\n" +
                "       CorpusExpand.detailstwo,\n" +
                "       CorpusExpand.detailsthree,\n" +
                "       CorpusExpand.detailsfour,\n" +
                "       CorpusExpand.detailsfive,\n" +
                "       nouncorpus.tag,\n" +
                "       nouncorpus.propone ,\n" +
                "       nouncorpus.proptwo,\n" +
                "       nouncorpus.form,\n" +
                "       nouncorpus.gendernumber,\n" +
                "       nouncorpus.type,\n" +
                "       nouncorpus.cases,\n" +
                "       wbw.en\n" +
                "      FROM corpusexpand,nouncorpus,\n" +
                "       wbw,qurans\n" +
                "    where   nouncorpus.tag = \""
                + tid + "\""
                + "    AND   corpusexpand.surah = wbw.surah AND  corpusexpand.surah = nouncorpus.surah AND \n" +
                "       corpusexpand.ayah = wbw.ayah AND      corpusexpand.ayah = nouncorpus.ayah AND \n" +
                "       corpusexpand.wordno = wbw.wordno   AND  corpusexpand.wordno = nouncorpus.wordno " +
                "and corpusexpand.surah = qurans.surah AND   corpusexpand.ayah = qurans.ayah  order by corpusexpand.surah,corpusexpand.ayah";
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(sqlverb);
        //  List<Book> result = booksDao.getBooks(query);
        return (ArrayList<CorpusNounWbwOccurance>) database.RawDao().getnounoccurance(query);
    }

    public ArrayList<CorpusVerbWbwOccurance> getVerbOccuranceBreakVerses(String tid) {
        String sqlverb = "SELECT CorpusExpand.rootaraone || rootaratwo || rootarathree || rootarafour || rootarafive as root_a,\n" +
                "       CorpusExpand.surah,\n" +
                "       CorpusExpand.ayah,\n" +
                "       CorpusExpand.wordno,\n" +
                "       CorpusExpand.wordcount,\n" +
                "       Qurans.qurantext,\n" +
                "       Qurans.translation,\n" +
                "       Qurans.ur_jalalayn,\n" +
                "       Qurans.en_jalalayn,\n" +
                "       Qurans.en_arberry,\n" +
                "       CorpusExpand.araone,\n" +
                "       CorpusExpand.aratwo,\n" +
                "       CorpusExpand.arathree,\n" +
                "       CorpusExpand.arafour,\n" +
                "       CorpusExpand.arafive,\n" +
                "       CorpusExpand.tagone,\n" +
                "       CorpusExpand.tagtwo,\n" +
                "       CorpusExpand.tagthree,\n" +
                "       CorpusExpand.tagfour,\n" +
                "       CorpusExpand.tagfive,\n" +
                "       CorpusExpand.detailsone,\n" +
                "       CorpusExpand.detailstwo,\n" +
                "       CorpusExpand.detailsthree,\n" +
                "       CorpusExpand.detailsfour,\n" +
                "       CorpusExpand.detailsfive,\n" +
                "       verbcorpus.voice,\n" +
                "       verbcorpus.form ,\n" +
                "       verbcorpus.thulathibab,\n" +
                "       verbcorpus.tense,\n" +
                "       verbcorpus.gendernumber,\n" +
                "       verbcorpus.mood_kananumbers,\n" +
                "       verbcorpus.kana_mood,\n" +
                "       wbw.en\n" +
                "      FROM corpusexpand,verbcorpus,\n" +
                "       wbw,qurans\n" +
                " WHERE (corpusexpand.tagone = \"V\" OR \n" +
                "        corpusexpand.tagtwo = \"V\" OR \n" +
                "        corpusexpand.tagthree = \"V\" OR \n" +
                "        Corpusexpand.tagfour = \"V\" OR \n" +
                "        corpusexpand.tagfive = \"V\") AND \n" +
                "       corpusexpand.lemaraone||corpusexpand.lemaratwo||corpusexpand.lemarathree||corpusexpand.lemarafour||corpusexpand.lemarafive=  \""
                + tid + "\""
                + "    AND   corpusexpand.surah = wbw.surah AND  corpusexpand.surah = verbcorpus.chapterno AND \n" +
                "       corpusexpand.ayah = wbw.ayah AND      corpusexpand.ayah = verbcorpus.verseno AND \n" +
                "       corpusexpand.wordno = wbw.wordno   AND  corpusexpand.wordno = verbcorpus.wordno and corpusexpand.surah = qurans.surah AND   corpusexpand.ayah = qurans.ayah order by corpusexpand.surah,corpusexpand.ayah";
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(sqlverb);
        //  List<Book> result = booksDao.getBooks(query);
        return (ArrayList<CorpusVerbWbwOccurance>) database.RawDao().getVerbOccuranceBreakVerses(query);
    }

    public ArrayList<CorpusNounWbwOccurance> getNounOccuranceBreakVerses(String tid) {
        String sqlverb = "SELECT CorpusExpand.rootaraone || rootaratwo || rootarathree || rootarafour || rootarafive as root_a,\n" +
                "       CorpusExpand.surah,\n" +
                "       CorpusExpand.ayah,\n" +
                "       CorpusExpand.wordno,\n" +
                "       CorpusExpand.wordcount,\n" +
                "       Qurans.qurantext,\n" +
                "       qurans.translation,\n" +
                "       Qurans.ur_jalalayn,\n" +
                "       Qurans.en_jalalayn,\n" +
                "       Qurans.en_arberry,\n" +
                "       CorpusExpand.araone,\n" +
                "       CorpusExpand.aratwo,\n" +
                "       CorpusExpand.arathree,\n" +
                "       CorpusExpand.arafour,\n" +
                "       CorpusExpand.arafive,\n" +
                "       CorpusExpand.tagone,\n" +
                "       CorpusExpand.tagtwo,\n" +
                "       CorpusExpand.tagthree,\n" +
                "       CorpusExpand.tagfour,\n" +
                "       CorpusExpand.tagfive,\n" +
                "       CorpusExpand.detailsone,\n" +
                "       CorpusExpand.detailstwo,\n" +
                "       CorpusExpand.detailsthree,\n" +
                "       CorpusExpand.detailsfour,\n" +
                "       CorpusExpand.detailsfive,\n" +
                "       nouncorpus.tag,\n" +
                "       nouncorpus.propone ,\n" +
                "       nouncorpus.proptwo,\n" +
                "       nouncorpus.form,\n" +
                "       nouncorpus.gendernumber,\n" +
                "       nouncorpus.type,\n" +
                "       nouncorpus.cases,\n" +
                "       wbw.en\n" +
                "      FROM corpusexpand,nouncorpus,\n" +
                "       wbw,qurans\n" +
                "    where  corpusexpand.lemaraone||corpusexpand.lemaratwo||corpusexpand.lemarathree||corpusexpand.lemarafour||corpusexpand.lemarafive=  \""
                + tid + "\""
                + "    AND   corpusexpand.surah = wbw.surah AND  corpusexpand.surah = nouncorpus.surah AND \n" +
                "       corpusexpand.ayah = wbw.ayah AND      corpusexpand.ayah = nouncorpus.ayah AND \n" +
                "       corpusexpand.wordno = wbw.wordno   AND  corpusexpand.wordno = nouncorpus.wordno" +
                " and corpusexpand.surah = qurans.surah AND   corpusexpand.ayah = qurans.ayah order by corpusexpand.surah,corpusexpand.ayah";
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(sqlverb);
        //  List<Book> result = booksDao.getBooks(query);
        return (ArrayList<CorpusNounWbwOccurance>) database.RawDao().getnounoccurance(query);
    }

    public ArrayList<CorpusNounWbwOccurance> getnounoccurancebysurahayah(int tid, int vid) {
        String sqlverb = "SELECT CorpusExpand.rootaraone || rootaratwo || rootarathree || rootarafour || rootarafive as root_a,\n" +
                "       CorpusExpand.surah,\n" +
                "       CorpusExpand.ayah,\n" +
                "       CorpusExpand.wordno,\n" +
                "       CorpusExpand.wordcount,\n" +
                "       Qurans.qurantext,\n" +
                "       qurans.translation,\n" +
                "       qurans.en_jalalayn,\n" +
                "       qurans.ur_jalalayn,\n" +
                "       CorpusExpand.araone,\n" +
                "       CorpusExpand.aratwo,\n" +
                "       CorpusExpand.arathree,\n" +
                "       CorpusExpand.arafour,\n" +
                "       CorpusExpand.arafive,\n" +
                "       CorpusExpand.tagone,\n" +
                "       CorpusExpand.tagtwo,\n" +
                "       CorpusExpand.tagthree,\n" +
                "       CorpusExpand.tagfour,\n" +
                "       CorpusExpand.tagfive,\n" +
                "       nouncorpus.tag,\n" +
                "       nouncorpus.propone ,\n" +
                "       nouncorpus.proptwo,\n" +
                "       nouncorpus.form,\n" +
                "       nouncorpus.gendernumber,\n" +
                "       nouncorpus.type,\n" +
                "       nouncorpus.cases,\n" +
                "       wbw.en\n" +
                "      FROM corpusexpand,nouncorpus,\n" +
                "       wbw,qurans\n" +
                "    where   CorpusExpand.surah = \""
                + tid + "\""
                + "and Corpusexpand.ayah=\""
                + vid + "\""
                + "    AND   corpusexpand.surah = wbw.surah AND  corpusexpand.surah = nouncorpus.surah AND \n" +
                "       corpusexpand.ayah = wbw.ayah AND      corpusexpand.ayah = nouncorpus.ayah AND \n" +
                "       corpusexpand.wordno = wbw.wordno   AND  corpusexpand.wordno = nouncorpus.wordno " +
                "and corpusexpand.surah = qurans.surah AND   corpusexpand.ayah = qurans.ayah order by corpusexpand.surah,corpusexpand.ayah";
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(sqlverb);
        //  List<Book> result = booksDao.getBooks(query);
        return (ArrayList<CorpusNounWbwOccurance>) database.RawDao().getnounoccurancebysurahayah(query);
    }

    public ArrayList<NewNasbEntity> getHarfNasbIndexesnew(int id) {
        return (ArrayList<NewNasbEntity>) database.NewNasbDao().getHarfNasbIndices(id);

    }

    public ArrayList<NewNasbEntity> getHarfNasbIndSurahAyahSnew(int id, int aid) {
        return (ArrayList<NewNasbEntity>) database.NewNasbDao().getHarfNasbIndicesSurahAyah(id, aid);

    }

    public ArrayList<MudhafPOJO> getMudhaf() {
        String sqlverb = "select mudhaf.surah,mudhaf.ayah,mudhaf.wordno,mudhaf.startindex,mudhaf.endindex,mudhaf.status,  \n" +
                "mudhaf.comment\n" +
                ",qurans.qurantext,qurans.translation from mudhaf,qurans where mudhaf.surah=qurans.surah and \n" +
                "mudhaf.ayah=qurans.ayah";
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(sqlverb);
        //  List<Book> result = booksDao.getBooks(query);
        return (ArrayList<MudhafPOJO>) database.RawDao().getMudhaf(query);
    }

    public ArrayList<SifaPOJO> getMousufSIfa() {
        String sqlverb = "select sifa.surah,sifa.ayah,sifa.wordno,sifa.startindex,sifa.endindex,sifa.phrasetype,sifa.ismousufconnected,\n" +
                "sifa.comment\n" +
                ",qurans.qurantext,qurans.translation from sifa,qurans where sifa.surah=qurans.surah and \n" +
                "sifa.ayah=qurans.ayah";
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(sqlverb);
        //  List<Book> result = booksDao.getBooks(query);
        return (ArrayList<SifaPOJO>) database.RawDao().getMousufSifa(query);
    }

    public ArrayList<ShartPOJO> getSharts() {
        String sqlverb = "select shart.surah,shart.ayah,shart.indexstart,shart.indexend,shart.shartindexstart,shart.shartindexend,\n" +
                "shart.jawabshartindexstart,shart.jawabshartindexend,shart.sharttype,shart.comment\n" +
                ",qurans.qurantext,qurans.translation from shart,qurans where shart.surah=qurans.surah and \n" +
                "shart.ayah=qurans.ayah  order by shart.surah,shart.ayah";
//     "shart.ayah=qurans.ayah and shart.sharttype=\"laula\" order by shart.surah";
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(sqlverb);
        //  List<Book> result = booksDao.getBooks(query);
        return (ArrayList<ShartPOJO>) database.RawDao().getShart(query);
    }

    public ArrayList<TameezPojoList> getTameez() {
        String sqlverb = "select tameez.surah,tameez.ayah,tameez.wordno,tameez.word \n" +
                "                 ,qurans.qurantext,qurans.translation from tameez,qurans where tameez.surah=qurans.surah and  \n" +
                "               tameez.ayah=qurans.ayah  order by tameez.surah,tameez.ayah";
//     "shart.ayah=qurans.ayah and shart.sharttype=\"laula\" order by shart.surah";
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(sqlverb);
        //  List<Book> result = booksDao.getBooks(query);
        return (ArrayList<TameezPojoList>) database.RawDao().getTameez(query);
    }

    public ArrayList<KanaPOJO> getKanaPojo() {
        String sqlverb = "select newkana.surah,newkana.ayah,newkana.indexstart,newkana.indexend,newkana.khabarstart,newkana.khabarend,\n" +
                "newkana.ismkanastart,newkana.ismkanaend,newkana.mahdoof,newkana.comment\n" +
                ",qurans.qurantext,qurans.translation from newkana,qurans where newkana.surah=qurans.surah and \n" +
                "newkana.ayah=qurans.ayah    order by newkana.surah,newkana.ayah ";
//     "shart.ayah=qurans.ayah and shart.sharttype=\"laula\" order by shart.surah";
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(sqlverb);
        //  List<Book> result = booksDao.getBooks(query);
        return (ArrayList<KanaPOJO>) database.RawDao().getKana(query);
    }

    public ArrayList<SifaEntity> getSifabySurah(int id) {
        return (ArrayList<SifaEntity>) database.SifaDao().getSifaindexesBySurah(id);

    }

    public ArrayList<SifaEntity> getSifabySurahAyah(int id, int aid) {
        return (ArrayList<SifaEntity>) database.SifaDao().getSifaindexesBySurahAyah(id, aid);

    }

    public ArrayList<NewShartEntity> getShartSurahNew(int id) {
        return (ArrayList<NewShartEntity>) database.NewShartDAO().getShartBySurah(id);

    }

    public ArrayList<lughat> getRootDictionary(String id) {
        return (ArrayList<lughat>) database.LughatDao().getRootWordDictionary(id.trim());

    }

    public ArrayList<lanelexicon> getLanesDifinition(String id) {
        return (ArrayList<lanelexicon>) database.LaneDao().getLanesDefinition(id.trim());

    }

    public ArrayList<hanslexicon> getHansDifinition(String id) {
        return (ArrayList<hanslexicon>) database.HansDao().getHansDefinition(id.trim());

    }

    public ArrayList<lughat> getArabicWord(String id) {
        return (ArrayList<lughat>) database.LughatDao().getArabicWord(id);

    }

    public ArrayList<qurandictionary> getQuranDictionary() {
        return (ArrayList<qurandictionary>) database.qurandictionaryDao().getDictionary();

    }

    public ArrayList<quranexplorer> getTopicSearch(String id) {
        return (ArrayList<quranexplorer>) database.QuranExplorerDao().getFilter(id);

    }

    public ArrayList<quranexplorer> getTopicSearchAll() {
        return (ArrayList<quranexplorer>) database.QuranExplorerDao().getALL();

    }

    public ArrayList<NewKanaEntity> getKananew(int id) {
        return (ArrayList<NewKanaEntity>) database.NewKanaDao().getkanabysurah(id);

    }

    public ArrayList<NewKanaEntity> getKanaSurahAyahnew(int id, int aid) {
        return (ArrayList<NewKanaEntity>) database.NewKanaDao().getkanabysurahAyah(id, aid);

    }

    public ArrayList<NewShartEntity> getShartSurahAyahNew(int id, int ayah) {
        return (ArrayList<NewShartEntity>) database.NewShartDAO().getShartBySurahAyah(id, ayah);

    }

    public ArrayList<wbwentity> getwbwQuranBySurahAyah(int id, int aid) {
        return (ArrayList<wbwentity>) database.wbwDao().getwbwQuranBySurahAyah(id, aid);

    }

    public ArrayList<wbwentity> getwbwQuranbTranslation(int sid, int aid, int firstwordindex, int lastwordindex) {
        return (ArrayList<wbwentity>) database.wbwDao().getwbwQuranbTranslation(sid, aid, firstwordindex, lastwordindex);
    }

    public ArrayList<NounCorpusBreakup> getNounBreakup(String tid) {
        String sqlverb = "SELECT count(root_a) as count,surah,ayah, lemma_a,form,araword,tag,propone,proptwo FROM nouncorpus where root_a =\""
                + tid + "\""
                + " group by lemma_a,root_a,tag,propone,proptwo order by surah,ayah";
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(sqlverb);
        //  List<Book> result = booksDao.getBooks(query);
        return (ArrayList<NounCorpusBreakup>) database.RawDao().getNounBreakup(query);
    }

    public ArrayList<VerbCorpusBreakup> getVerbBreakUp(String tid) {
        String sqlverb = "SELECT count(root_a) as count,root_a,lemma_a,form,thulathibab,tense,voice FROM verbcorpus where root_a =\""
                + tid + "\""
                + " group by root_a,form order by chapterno,verseno";
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(sqlverb);
        //  List<Book> result = booksDao.getBooks(query);
        return (ArrayList<VerbCorpusBreakup>) database.RawDao().getVerbBreakup(query);
    }

    public ArrayList<GrammarRules> getGrammarRules() {
        return (ArrayList<GrammarRules>) database.grammarRulesDao().getGrammarRules();

    }

    public ArrayList<GrammarRules> getGrammarRulesByRules(String harf) {
        return (ArrayList<GrammarRules>) database.grammarRulesDao().getGrammarRulesByHarf(harf);

    }

    public ArrayList<TameezEnt> getTameezWord(int surah, int ayah, int wordno) {
        return (ArrayList<TameezEnt>) database.tameezDao().getTameezWord(surah, ayah, wordno);

    }

    public ArrayList<TameezEnt> getTameezall() {
        return (ArrayList<TameezEnt>) database.tameezDao().getall();

    }

    public ArrayList<TameezEnt> getTameezsurah(int surah) {
        return (ArrayList<TameezEnt>) database.tameezDao().getTameezSurah(surah);

    }

    public ArrayList<TameezPOJO> gettameezverses() {
        String sql = "SELECT surah,COUNT(ayah) as versescount FROM tameez group by surah order BY surah,ayah";
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(sql);
        //  List<Book> result = booksDao.getBooks(query);
        return (ArrayList<TameezPOJO>) database.RawDao().gettameezversescount(query);

    }

    public ArrayList<hduanames> getDuaCATNAMES(String tid) {
        String verb = String.format("select * from hduanames where (category = '%s'   or category like '%%,%s'   or category like '%s, %% 'or category like '%%,%s,%%'" +
                "", tid, tid, tid, tid);
        String fs = verb.concat(")");
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(fs);
        return (ArrayList<hduanames>) database.RawDao().getDuaCATNAMES(query);

    }

    public ArrayList<LiajlihiEnt> getMafoolLiajlihi(int surah, int ayah, int wordno) {
        return (ArrayList<LiajlihiEnt>) database.liajlihiDao().getMafoolLiajlihi(surah, ayah, wordno);

    }

    public ArrayList<LiajlihiEnt> getMafoolLiajlihisurah(int surah) {
        return (ArrayList<LiajlihiEnt>) database.liajlihiDao().getMafoolLiajlihisurah(surah);

    }

    public ArrayList<MafoolBihi> getMafoolbihiId(int surah, int ayah, int wordno) {
        return (ArrayList<MafoolBihi>) database.MafoolBihiDao().getMafoolbihi(surah, ayah, wordno);

    }

    public ArrayList<MafoolBihi> getMafoolbihiword(int surah, int ayah, int wordno) {
        return (ArrayList<MafoolBihi>) database.MafoolBihiDao().getMafoolbihi(surah, ayah, wordno);

    }

    public int updateMafoolword(int wordn, int id) {
        int updatemafoolrslt = database.MafoolBihiDao().updateMafoolWord(wordn, id);
        return updatemafoolrslt;
    }

    public ArrayList<MafoolBihi> getMafoolbihiquran() {
        return (ArrayList<MafoolBihi>) database.MafoolBihiDao().getMafoolbihiq();

    }

    public ArrayList<MafoolBihi> getMafoolBySurah(int surah) {
        return (ArrayList<MafoolBihi>) database.MafoolBihiDao().getBySurah(surah);

    }

    public ArrayList<HalEnt> getHaliaErab(int surah, int ayah) {
        return (ArrayList<HalEnt>) database.HaliyaDao().getHaliya(surah, ayah);

    }

    public ArrayList<HalEnt> getHaliaErabBysurah(int surah) {
        return (ArrayList<HalEnt>) database.HaliyaDao().getHaliyaSurah(surah);

    }

    public ArrayList<BadalErabNotesEnt> getBadalErabSA(int surah, int ayah) {
        return (ArrayList<BadalErabNotesEnt>) database.BadalErabNotesDao().getBadalNotesSurahAyah(surah, ayah);

    }

    public ArrayList<BadalErabNotesEnt> getBadalrabSurah(int surah) {
        return (ArrayList<BadalErabNotesEnt>) database.BadalErabNotesDao().getBadalNotesSurah(surah);

    }

    public ArrayList<MafoolMutlaqEnt> getMafoolMutlaqword(int surah, int ayah, int wordno) {
        return (ArrayList<MafoolMutlaqEnt>) database.MafoolMutlaqEntDao().getMafoolbihiword(surah, ayah, wordno);

    }

    public ArrayList<MafoolMutlaqEnt> getMutlaqsurah(int surah) {
        return (ArrayList<MafoolMutlaqEnt>) database.MafoolMutlaqEntDao().getMutlaqsurah(surah);

    }

    public int updateFav(int fav, int id) {
        int updadateRoots = database.hDuaNamesDao().updateFav(fav, id);
        return updadateRoots;
    }

    public ArrayList<hduanames> getDunamesbyid(String id) {
        ArrayList<hduanames> dua = (ArrayList<hduanames>) database.hDuaNamesDao().getDuanamesid(id);
        return dua;

    }

    public ArrayList<hduanames> getDunamesbyCatId(String id) {
        ArrayList<hduanames> dua = (ArrayList<hduanames>) database.hDuaNamesDao().getDunamesbyCatId(id);
        return dua;

    }

    public ArrayList<hduanames> getDunamesbyCatIdnew(String id) {
        ArrayList<hduanames> dua = (ArrayList<hduanames>) database.hDuaNamesDao().getDunamesbyCatIdnew(id);
        return dua;

    }

    public ArrayList<hduanames> getDuanamesDetails(String id) {
        ArrayList<hduanames> duas = (ArrayList<hduanames>) database.hDuaNamesDao().getDuanamesByID(id);
        return duas;

    }

    public ArrayList<hduanames> getBookmarked(int id) {
        ArrayList<hduanames> duas = (ArrayList<hduanames>) database.hDuaNamesDao().getBookmarked(id);
        return duas;

    }

    public ArrayList<hduanames> getIsmarked(String id) {
        ArrayList<hduanames> duas = (ArrayList<hduanames>) database.hDuaNamesDao().isBookmarked(id);
        return duas;

    }

    public ArrayList<hduadetails> gethDuadetailsitems(String id) {
        ArrayList<hduadetails> duay = (ArrayList<hduadetails>) database.hDuaItemDao().getDitem(id);
        return duay;

    }

}









