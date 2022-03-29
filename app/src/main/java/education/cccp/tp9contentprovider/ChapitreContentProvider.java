package education.cccp.tp9contentprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

public class ChapitreContentProvider extends ContentProvider {

    public static final Uri CONTENTURI = Uri.parse(
            "content://education.cccp.tp9contentprovider.ChapitreContentProvider");
    public final String CONTENT_PROVIDER_MIME =
            "vnd.android.cursor.item/vnd.com.example.contentProvider.chapitres";

    private ChapitreBaseSqlite dbHelper;

    @Override
    public boolean onCreate() {
        dbHelper = new ChapitreBaseSqlite(
                getContext(),
                ChapitreBaseSqlite.NAME_DB,
                null,
                ChapitreBaseSqlite.VERSION
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
                ChapitreBaseSqlite.TABLE_CHAPITRE,
                columns,
                selection,
                arguments,
                null,
                null,
                sort);
        else return db.query(
                ChapitreBaseSqlite.TABLE_CHAPITRE,
                columns,
                ChapitreBaseSqlite.COL_ID + " = " + id,
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
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        try {
            long id = db.insertOrThrow(
                    ChapitreBaseSqlite.TABLE_CHAPITRE,
                    null,
                    contentValues
            );
            if (id == -1)
                throw new RuntimeException("Failed insertion");
            else {
                Log.d(ChapitreContentProvider.class.getName(),
                        "uri: " + uri
                                + " id: " + id);
                return ContentUris.withAppendedId(uri, id);
            }
        } finally {
            db.close();
        }
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
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
    public long getId(Uri uri) {
        String lastPathSegment = uri
                .getLastPathSegment();
        if (lastPathSegment != null)
            return Long.parseLong(lastPathSegment);
        return -1;
    }
}
