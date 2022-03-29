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
        insertDbValues();
        display();
        setContentView(R.layout.activity_main);
    }

    private void insertDbValues() {
        insertChapitresValues();
        insertPersonsValues();
    }

    private void display() {
//        displayChaptitres();
        displayPersons();
    }

    private void insertChapitresValues() {
        ContentValues chapitre = new ContentValues();
        chapitre.put(
                ChapitreBaseSqlite.TABLE_CHAPITRE_COL_NAME,
                "chapitre 1");
        chapitre.put(
                ChapitreBaseSqlite.TABLE_CHAPITRE_COL_DESC,
                "description chapitre 1");
        getContentResolver().insert(
                ChapitreContentProvider.CONTENTURI,
                chapitre);
    }

    private void insertPersonsValues() {
        ContentValues chapitre = new ContentValues();
        chapitre.put(
                ChapitreBaseSqlite.TABLE_CHAPITRE_COL_NAME,
                "chapitre 1");
        chapitre.put(
                ChapitreBaseSqlite.TABLE_CHAPITRE_COL_DESC,
                "description chapitre 1");
        getContentResolver().insert(
                ChapitreContentProvider.CONTENTURI,
                chapitre);
    }

    @SuppressLint("Range")
    private void displayChaptitres() {
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
                                        .TABLE_CHAPITRE_COL_ID)))
                        .append(" name : ")
                        .append(cursor.getString(cursor
                                .getColumnIndex(ChapitreBaseSqlite
                                        .TABLE_CHAPITRE_COL_NAME)))
                        .append(" description : ")
                        .append(cursor.getString(cursor
                                .getColumnIndex(ChapitreBaseSqlite
                                        .TABLE_CHAPITRE_COL_DESC)))
                        .toString();
                Log.d(MainActivity.class.getSimpleName(),
                        "queryResult : " + queryResult);
                Toast.makeText(this,
                        queryResult,
                        Toast.LENGTH_SHORT)
                        .show();
            } while (cursor.moveToNext());
        }
    }


    @SuppressLint("Range")
    private void displayPersons() {
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
                queryResult = new StringBuilder("person ")
                        .append("id: ")
                        .append(cursor.getString(
                                cursor.getColumnIndex(ChapitreBaseSqlite
                                        .TABLE_PERSON_COL_ID)))
                        .append(" firstName : ")
                        .append(cursor.getString(cursor
                                .getColumnIndex(ChapitreBaseSqlite
                                        .TABLE_PERSON_COL_FIRST_NAME)))
                        .append(" lastName : ")
                        .append(cursor.getString(cursor
                                .getColumnIndex(ChapitreBaseSqlite
                                        .TABLE_PERSON_COL_LAST_NAME)))
                        .toString();
                Log.d(MainActivity.class.getSimpleName(),
                        "queryResult : " + queryResult);
                Toast.makeText(this,
                        queryResult,
                        Toast.LENGTH_SHORT)
                        .show();
            } while (cursor.moveToNext());
        }
    }
}