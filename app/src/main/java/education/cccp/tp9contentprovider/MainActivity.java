package education.cccp.tp9contentprovider;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ContentValues chapitre = new ContentValues();
        chapitre.put(
                ChapitreBaseSqlite.COL_NAME,
                "chapitre 1");
        chapitre.put(
                ChapitreBaseSqlite.COL_DESC,
                "description chapitre 1");
        getContentResolver().insert(
                ChapitreContentProvider.CONTENTURI,
                chapitre);
        display();
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("Range")
    private void display() {
        Cursor cursor = getContentResolver().query(
                ChapitreContentProvider.CONTENTURI,
                null,
                null,
                null,
                null,
                null
        );
        if (cursor.moveToFirst()) {
            String queryResult = null;
            do {
                queryResult = new StringBuilder("chapitre ")
                        .append("id: ")
                        .append(cursor.getString(
                                cursor.getColumnIndex(ChapitreBaseSqlite
                                .COL_ID)))
                        .append(" name : ")
                        .append(cursor.getString(cursor.getColumnIndex(ChapitreBaseSqlite
                                .COL_NAME)))
                        .append(" description : ")
                        .append(cursor.getString(cursor.getColumnIndex(ChapitreBaseSqlite
                                .COL_DESC)))
                        .toString();
                Log.d(MainActivity.class.getSimpleName(),
                        "queryResult : "+queryResult);
                Toast.makeText(this,
                        queryResult,
                        Toast.LENGTH_SHORT)
                        .show();
            } while (cursor.moveToNext());
        }
    }
}