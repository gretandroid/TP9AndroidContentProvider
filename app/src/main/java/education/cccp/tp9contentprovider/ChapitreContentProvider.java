package education.cccp.tp9contentprovider;

import static android.content.ContentUris.withAppendedId;
import static android.net.Uri.parse;
import static java.lang.Long.parseLong;
import static education.cccp.tp9contentprovider.Chapitre.TABLE_CHAPITRE;
import static education.cccp.tp9contentprovider.Chapitre.TABLE_CHAPITRE_COL_ID;
import static education.cccp.tp9contentprovider.DataBaseHelper.BASE_CONTENT_URI;
import static education.cccp.tp9contentprovider.DataBaseHelper.NAME_DB;
import static education.cccp.tp9contentprovider.DataBaseHelper.NO_URI_RESOURCE_ID_FOUND_RESULT;
import static education.cccp.tp9contentprovider.DataBaseHelper.VERSION;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ChapitreContentProvider extends ContentProvider {


    public static final Uri CHAPITRE_CONTENT_URI = parse(
            BASE_CONTENT_URI + ChapitreContentProvider.class.getName()
    );

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


    @SuppressLint("DefaultLocale")
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
                TABLE_CHAPITRE,
                columns,
                selection,
                arguments,
                null,
                null,
                sort);
        else return db.query(
                TABLE_CHAPITRE,
                columns,
                new StringBuilder(TABLE_CHAPITRE_COL_ID)
                        .append(" = ")
                        .append(id)
                        .toString(),
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
                    TABLE_CHAPITRE,
                    null,
                    contentValues
            );
            if (id == -1)
                throw new RuntimeException("Failed insertion");
            else {
                Log.d(ChapitreContentProvider.class.getName(),
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
    public long getId(Uri uri) {
        String lastPathSegment = uri
                .getLastPathSegment();
        if (lastPathSegment != null)
            return parseLong(lastPathSegment);
        return NO_URI_RESOURCE_ID_FOUND_RESULT;
    }
}
