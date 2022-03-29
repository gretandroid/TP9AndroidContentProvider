package education.cccp.tp9contentprovider;

import static android.database.sqlite.SQLiteDatabase.CursorFactory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


// Cette classe nous fournis un helper(une classe d'aide)
// Elle contient deux méthodes qui font partis du cycle de vie
// de la classe SQLiteOpenHelper.
// Lorsque l'on ouvre la base de données en écriture
// alors la méthode onCreate(sqLiteDatabase) est appelé.
// De plus si la version(schéma) de la base de données change,
// alors c'est la méthode onUpgrade(sqLiteDatabase) qui est appelé.

public class ChapitreBaseSqlite extends SQLiteOpenHelper {

    public static final int VERSION = 1;
    public static final String NAME_DB = "chapitre.db";
    public static final String TABLE_CHAPITRE = "table_chapitre";
    public static final String COL_ID = "ID";
    public static final String COL_NAME = "NAME";
    public static final String COL_DESC = "DESCRIPTION";
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_CHAPITRE +
                    " (" + COL_ID +
                    " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_NAME + " TEXT NOT NULL, " +
                    COL_DESC + " TEXT NOT NULL);";

    public ChapitreBaseSqlite(@Nullable Context context,
                              @Nullable String name,
                              @Nullable CursorFactory factory,
                              int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,
                          int i,
                          int i1) {

    }
}
