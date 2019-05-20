package android.learning.trace.android_learning_trace.view.activity.SQLite;

import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * SQLite support data types:
 * 1. NULL
 * 2. INTEGER (decimal(p, s) will be convert to Integer)
 * 3. REAL
 * 4. TEXT (varchar, char will be converted to TEXT)
 * 5. BLOB
 * <p>
 * It is weak type database.
 */

public class Part35SQLiteActivity extends AppCompatActivity {

    DatabaseAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part35_sqlite);
        dbAdapter = new DatabaseAdapter(this);
    }


    public void addDogTableClick(View view) {
        Dog dog = new Dog(1, "Doge", 5);
        dbAdapter.add(dog);
        Toast.makeText(this, "Add dog successful.", Toast.LENGTH_SHORT).show();
    }

    public void deleteDogTableClick(View view) {
        dbAdapter.delete(1);
        Toast.makeText(this, "Delete successful", Toast.LENGTH_SHORT).show();
    }

    public void updateDogTableClick(View view) {
        Dog dog = dbAdapter.findById(1);
        dog.setName("Dog new name");

        dbAdapter.update(dog);
        Toast.makeText(this, "Update successful.", Toast.LENGTH_SHORT).show();
    }

    public void findDogTableClick(View view) {
        Dog dog = dbAdapter.findById(1);
        if (dog != null) {
            Toast.makeText(this, dog.toString(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Couldn't find the dog.", Toast.LENGTH_SHORT).show();
        }

    }

    public void addDogSQLClick(View view) {
        Dog dog = new Dog("Raw dog", 12);
        dbAdapter.rawAdd(dog);
        Toast.makeText(this, "Raw sql add dog successful.", Toast.LENGTH_SHORT).show();
    }


    public void findDogSQLClick(View view) {

        Dog dog = dbAdapter.rawFindDogById(2);
        if (dog != null) {
            Toast.makeText(this, dog.toString(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No data found.", Toast.LENGTH_SHORT).show();
        }

    }

    public void addDogsSQLClick(View view) {
        dbAdapter.addDogsTransection();
    }
}
