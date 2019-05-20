package android.learning.trace.android_learning_trace.view.activity.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseAdapter {

    private DatabaseHelper dbHelper;

    public DatabaseAdapter(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void add(Dog dog) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PetMetaData.Dog.NAME, dog.getName());
        values.put(PetMetaData.Dog.AGE, dog.getAge());

        db.insert(PetMetaData.Dog.TABLE_NAME, PetMetaData.Dog.AGE, values);
        db.close();

    }

    public void delete(int id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String whereClause = PetMetaData.Dog._ID + "=?";
        String[] whereArgs = {String.valueOf(id)};
        db.delete(PetMetaData.Dog.TABLE_NAME, whereClause, whereArgs);
        db.close();

    }

    public void update(Dog dog) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PetMetaData.Dog.NAME, dog.getName());
        values.put(PetMetaData.Dog.AGE, dog.getAge());
        String whereClause = PetMetaData.Dog._ID + "=?";
        String[] whereArgs = {String.valueOf(dog.getId())};

        db.update(PetMetaData.Dog.TABLE_NAME, values, whereClause, whereArgs);
        db.close();

    }

    public Dog findById(int id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] columns = {PetMetaData.Dog._ID, PetMetaData.Dog.NAME, PetMetaData.Dog.AGE};
        String selection = PetMetaData.Dog._ID + "=?";
        String[] selectionArgs = {String.valueOf(id)};
        Cursor cursor = db.query(true, PetMetaData.Dog.TABLE_NAME, columns, selection, selectionArgs, null, null, null, null);
        Dog targetDog = null;
        while (cursor.moveToNext()) {
            targetDog = new Dog(
                    cursor.getInt(cursor.getColumnIndexOrThrow(PetMetaData.Dog._ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(PetMetaData.Dog.NAME)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(PetMetaData.Dog.AGE)));
        }
        cursor.close();
        db.close();
        return targetDog;
    }

    public void rawAdd(Dog dog) {
        String sql = "INSERT INTO dog(name, age) values (?, ?)";
        Object[] args = {dog.getName(), dog.getAge()};

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.execSQL(sql, args);

        db.close();
    }

    public Dog rawFindDogById(int id) {
        String sql = "SELECT * FROM dog where _id=?";
        String[] args = {String.valueOf(id)};
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor c = db.rawQuery(sql, args);

        Dog dog = null;

        while (c.moveToNext()) {
            dog = new Dog();
            dog.setName(c.getString(c.getColumnIndexOrThrow(PetMetaData.Dog.NAME)));
            dog.setAge(c.getInt(c.getColumnIndexOrThrow(PetMetaData.Dog.AGE)));
            dog.setId(c.getInt(c.getColumnIndexOrThrow(PetMetaData.Dog._ID)));
        }

        c.close();

        db.close();

        return dog;
    }

    public void addDogsTransection() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.beginTransaction();
        try {
            db.execSQL("INSERT INTO dog(name, age) VALUES('Transection Dog1', 10)");
            db.execSQL("INSERT INTO dog(name, age) VALUES('Transection Dog2', 12)");
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            db.close();
        }


    }
}
