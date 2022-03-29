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

public class ChapitreBaseSqlite
        extends SQLiteOpenHelper {

    public static final int VERSION = 1;
    public static final String NAME_DB = "chapitre.db";
    public static final String TABLE_CHAPITRE = "table_chapitre";
    public static final String TABLE_CHAPITRE_COL_ID = "ID";
    public static final String TABLE_CHAPITRE_COL_NAME = "NAME";
    public static final String TABLE_CHAPITRE_COL_DESC = "DESCRIPTION";
    public static final String CREATE_TABLE_CHAPITRE =
            "CREATE TABLE " + TABLE_CHAPITRE +
                    " (" + TABLE_CHAPITRE_COL_ID +
                    " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    TABLE_CHAPITRE_COL_NAME + " TEXT NOT NULL, " +
                    TABLE_CHAPITRE_COL_DESC + " TEXT NOT NULL);";
    public static final String TABLE_PERSON = "table_person";
    public static final String TABLE_PERSON_COL_ID = "ID";
    public static final String TABLE_PERSON_COL_FIRST_NAME = "FIRST_NAME";
    public static final String TABLE_PERSON_COL_LAST_NAME = "LAST_NAME";
    public static final String CREATE_TABLE_PERSON =
            "CREATE TABLE " + TABLE_PERSON +
                    " (" + TABLE_PERSON_COL_ID +
                    " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    TABLE_PERSON_COL_FIRST_NAME + " TEXT NOT NULL, " +
                    TABLE_PERSON_COL_LAST_NAME + " TEXT NOT NULL);";
    public static final String CREATE_TABLES = CREATE_TABLE_CHAPITRE
            + CREATE_TABLE_PERSON;


    public ChapitreBaseSqlite(@Nullable Context context,
                              @Nullable String name,
                              @Nullable CursorFactory factory,
                              int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,
                          int oldVersion,
                          int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE "
                + TABLE_CHAPITRE);
        sqLiteDatabase.execSQL("DROP TABLE "
                + TABLE_PERSON);
        onCreate(sqLiteDatabase);
    }
}
