package database;

import android.content.Context;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.util.DisplayMetrics;


import database.entity.BuckwaterEntitiy;
import database.entity.DuaDetails;
import database.entity.DuaGroup;
import database.entity.Mazeed;
import database.entity.MujarradVerbs;
import database.entity.QuranVerbsEntity;
import database.entity.QuranicVerbsEntity;
import database.entity.kov;
import database.entity.verbcorpus;

import java.util.ArrayList;
import java.util.List;

public class DatabaseUtils {


    private static VerbDatabase database;


    // {
    //     LiveData<List<wordbyword>> liveUsers = WordbywordPojoDao.getWords(new
    //             SimpleSQLiteQuery("SELECT * FROM "));
    // }


    public DatabaseUtils(Context context) {
        database = VerbDatabase.getInstance(context);

    }

    //  public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
    //   @Override
    //    public void migrate(SupportSQLiteDatabase database) {
    //       database.execSQL("CREATE TABLE IF NOT EXISTS `quranicverbs` (`verb` TEXT, `root` TEXT, `thulathibab` TEXT, `form` INTEGER NOT NULL, `chaptername` TEXT, `frequency` INTEGER NOT NULL, `meaning` TEXT, `id` INTEGER NOT NULL, PRIMARY KEY(`id`))");
    //  }
    //  };







    public ArrayList<kov> getKov() {
        ArrayList<kov> kovs = (ArrayList<kov>) database.kovDao().getRules();
        return kovs;

    }

    public ArrayList<QuranVerbsEntity> getQuranVerbsbyFrequency(int sort) {
        ArrayList<QuranVerbsEntity> quranverbs = (ArrayList<QuranVerbsEntity>) database.QuranVerbsDao().getverbsbyFrequency(sort);
        return quranverbs;

    }
    public ArrayList<QuranicVerbsEntity> getQuranicVerbsMazeed() {
        ArrayList<QuranicVerbsEntity> quranicverbs = (ArrayList<QuranicVerbsEntity>) database.QuranicVerbsDao().getverbsMazeed();
        return quranicverbs;

    }

    public ArrayList<QuranicVerbsEntity> getQuranicVerbsbyForm() {
        ArrayList<QuranicVerbsEntity> quranicverbs = (ArrayList<QuranicVerbsEntity>) database.QuranicVerbsDao().getverbsbyForm();
        return quranicverbs;

    }

    public int updateTrimRoots(String nroot, int id) {
        int updadateRoots = database.QuranicVerbsDao().updadateRoots(nroot, id);

return updadateRoots;
    }
    public int updateThulathibab(String nroot, int id) {
        int updadateThulathi= database.QuranicVerbsDao().updadateThulathibab(nroot, id);

        return updadateThulathi;
    }


    public ArrayList<MujarradVerbs> getMujarradVerbs(String root) {
        ArrayList<MujarradVerbs> mujarrad = (ArrayList<MujarradVerbs>) database.mujarradDao().getverbTri(root);
        return mujarrad;

    }

    public ArrayList<MujarradVerbs> getMujarradAall( ) {
        ArrayList<MujarradVerbs> triverbsall = (ArrayList<MujarradVerbs>) database.mujarradDao().getverbTriAll();
                return triverbsall;
    }
    public ArrayList<MujarradVerbs> getMujarradBYWeakness(String kov ) {
        ArrayList<MujarradVerbs> triverbsall = (ArrayList<MujarradVerbs>) database.mujarradDao().getMujarradWeakness(kov);
        return triverbsall;
    }
    public ArrayList<Mazeed> getMazeedWeakness(String kov ) {
        ArrayList<Mazeed> triverbsall = (ArrayList<Mazeed>) database.mazeedDao().getMazeedWeakness(kov);
        return triverbsall;
    }



    public ArrayList<Mazeed> getMazeedRoot(String root) {
        ArrayList<Mazeed> triverbsmazeed = (ArrayList<Mazeed>) database.mazeedDao().getMazeedRoot(root);
        return triverbsmazeed;

    }



    public ArrayList<verbcorpus> verbcorpuses() {


        ArrayList<verbcorpus> forms = (ArrayList<verbcorpus>) database.verbcorpusDao().getmazeedform("I");
        return forms;
    }
}










