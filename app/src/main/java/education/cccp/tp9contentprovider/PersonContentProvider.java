package education.cccp.tp9contentprovider;

import static android.content.ContentUris.withAppendedId;
import static android.net.Uri.parse;
import static java.lang.Long.parseLong;
import static education.cccp.tp9contentprovider.DataBaseHelper.NAME_DB;
import static education.cccp.tp9contentprovider.DataBaseHelper.TABLE_CHAPITRE;
import static education.cccp.tp9contentprovider.DataBaseHelper.TABLE_PERSON;
import static education.cccp.tp9contentprovider.DataBaseHelper.TABLE_PERSON_COL_ID;
import static education.cccp.tp9contentprovider.DataBaseHelper.VERSION;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/*
Developers usually create content URIs from the authority
by appending paths that point to individual tables.
For example, if you have two tables table1 and table2,
you combine the authority from the previous example
to yield the content URIs com.example.<appname>.provider/table1
and com.example.<appname>.provider/table2.
Paths aren't limited to a single segment,
and there doesn't have to be a table for each level of the path.
 */
public class PersonContentProvider extends ContentProvider {

    public static final Uri PERSON_CONTENT_URI = parse(
            "content://education.cccp.tp9contentprovider.PersonContentProvider");
    public static final int ID_ALL = -1;

    private DataBaseHelper dbHelper;

    @Override
    public boolean onCreate() {
        dbHelper = new DataBaseHelper(
                getContext(),
                NAME_DB,
                null,
                VERSION
        );
        return true;
    }


    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri,
                        @Nullable String[] columns,
                        @Nullable String selection,
                        @Nullable String[] arguments,
                        @Nullable String sort) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        long id = getId(uri);
        if (id < 0) return db.query(
                TABLE_PERSON,
                columns,
                selection,
                arguments,
                null,
                null,
                sort);
        else return db.query(
                TABLE_PERSON,
                columns,
                TABLE_PERSON_COL_ID + " = " + id,
                arguments,
                null,
                null,
                sort);
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri,
                      @Nullable ContentValues contentValues) {
        try (SQLiteDatabase db = dbHelper.getWritableDatabase()) {
            long id = db.insertOrThrow(
                    TABLE_PERSON,
                    null,
                    contentValues
            );
            if (id == -1) throw new RuntimeException("Failed insertion");
            else {
                Log.d(PersonContentProvider.class.getName(),
                        "uri: " + uri
                                + " id: " + id);
                return withAppendedId(uri, id);
            }
        }
    }

    @Override
    public int delete(@NonNull Uri uri,
                      @Nullable String s,
                      @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri,
                      @Nullable ContentValues contentValues,
                      @Nullable String s,
                      @Nullable String[] strings) {
        return 0;
    }


    // Récupère la derniere partie de l'URI
    // (content://education.cccp.tp9contentprovider.PersonContentProvider/#)
    public long getId(Uri uri) {
        String lastPathSegment = uri
                .getLastPathSegment();
        if (lastPathSegment != null)
            return parseLong(lastPathSegment);
        return ID_ALL;
    }
}
