package education.cccp.tp9contentprovider;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;
import static education.cccp.tp9contentprovider.DataBaseHelper.TABLE_CHAPITRE_COL_DESC;
import static education.cccp.tp9contentprovider.DataBaseHelper.TABLE_CHAPITRE_COL_ID;
import static education.cccp.tp9contentprovider.DataBaseHelper.TABLE_CHAPITRE_COL_NAME;
import static education.cccp.tp9contentprovider.DataBaseHelper.TABLE_PERSON_COL_FIRST_NAME;
import static education.cccp.tp9contentprovider.DataBaseHelper.TABLE_PERSON_COL_ID;
import static education.cccp.tp9contentprovider.DataBaseHelper.TABLE_PERSON_COL_LAST_NAME;
import static education.cccp.tp9contentprovider.ChapitreContentProvider.CHAPITRE_CONTENT_URI;
import static education.cccp.tp9contentprovider.PersonContentProvider.PERSON_CONTENT_URI;
import static education.cccp.tp9contentprovider.R.layout.activity_main;

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
        setContentView(activity_main);
    }

    private void insertDbValues() {
        insertChapitresValues();
//        insertPersonsValues();
    }

    private void display() {
        displayChapitres();
//        displayPersons();
    }

    private void insertChapitresValues() {
        ContentValues chapitre = new ContentValues();
        chapitre.put(
                TABLE_CHAPITRE_COL_NAME,
                "chapitre 1");
        chapitre.put(
                TABLE_CHAPITRE_COL_DESC,
                "description chapitre 1");
        getContentResolver().insert(
                CHAPITRE_CONTENT_URI,
                chapitre);
    }

    private void insertPersonsValues() {
        ContentValues personValue = new ContentValues();
        personValue.put(
                TABLE_PERSON_COL_FIRST_NAME,
                "John");
        personValue.put(
                TABLE_PERSON_COL_LAST_NAME,
                "Doe");
        getContentResolver().insert(
                PERSON_CONTENT_URI,
                personValue);
    }

    @SuppressLint("Range")
    private void displayChapitres() {
        Cursor cursor = getContentResolver().query(
                CHAPITRE_CONTENT_URI,
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
                                cursor.getColumnIndex(TABLE_CHAPITRE_COL_ID)))
                        .append(" name : ")
                        .append(cursor.getString(cursor
                                .getColumnIndex(TABLE_CHAPITRE_COL_NAME)))
                        .append(" description : ")
                        .append(cursor.getString(cursor
                                .getColumnIndex(TABLE_CHAPITRE_COL_DESC)))
                        .toString();
                Log.d(MainActivity.class.getSimpleName(),
                        "queryResult : " + queryResult);
                makeText(this,
                        queryResult,
                        LENGTH_SHORT)
                        .show();
            } while (cursor.moveToNext());
        }
    }


    @SuppressLint("Range")
    private void displayPersons() {
        Cursor cursor = getContentResolver().query(
                PERSON_CONTENT_URI,
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
                                cursor.getColumnIndex(TABLE_PERSON_COL_ID)))
                        .append(" firstName : ")
                        .append(cursor.getString(cursor
                                .getColumnIndex(TABLE_PERSON_COL_FIRST_NAME)))
                        .append(" lastName : ")
                        .append(cursor.getString(cursor
                                .getColumnIndex(TABLE_PERSON_COL_LAST_NAME)))
                        .toString();
                Log.d(MainActivity.class.getSimpleName(),
                        "queryResult : " + queryResult);
                makeText(this,
                        queryResult,
                        LENGTH_SHORT)
                        .show();
            } while (cursor.moveToNext());
        }
    }
}