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
