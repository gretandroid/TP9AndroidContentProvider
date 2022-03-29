package education.cccp.tp9contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.os.Bundle;

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
        setContentView(R.layout.activity_main);
    }
}