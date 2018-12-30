package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by 16301029 on 2018/12/13.
 */

public class MyDatabase extends SQLiteOpenHelper
{
    public static final String Create_coach = "create table private_coach ("
            + "name text primary key," + "des text," + "res text)";

    private Context mcontext;

    public MyDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
        mcontext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(Create_coach);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
    }
}
