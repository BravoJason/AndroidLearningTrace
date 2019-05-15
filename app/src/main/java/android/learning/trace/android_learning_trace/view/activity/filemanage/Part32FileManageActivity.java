package android.learning.trace.android_learning_trace.view.activity.filemanage;

import android.content.Context;
import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Internal storage: Can only be accessed by the application itself.
 * External storage: Can be accessed by other applications.
 */

public class Part32FileManageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part32_file_manage);
    }


    /**
     * Read private jsonfile.
     * The private jsonfile path is /data/data/package.name/jsonfile/filename.
     *
     * @param view
     */
    public void writePrivateFileClick(View view) {
        OutputStream out = null;

        try {
            out = openFileOutput("PrivateFile.txt", Context.MODE_APPEND);
            String info = "Private jsonfile write test. ";
            byte[] bytes = info.getBytes();
            out.write(bytes, 0, bytes.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Read private jsonfile.
     * The private jsonfile path is /data/data/package.name/jsonfile/filename
     *
     * @param view
     */
    public void readPrivateFileClick(View view) {
        InputStream in = null;

        try {
            in = openFileInput("PrivateFile.txt");
            byte[] buffer = new byte[1024];
            int len = -1;
            StringBuffer outputBuffer = new StringBuffer();
            while ((len = in.read(buffer, 0, buffer.length)) != -1) {
                outputBuffer.append(new String(buffer));
            }

            Toast.makeText(this, outputBuffer, Toast.LENGTH_SHORT).show();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Read raw jsonfile from resource.
     *
     * @param view
     */
    public void readRawFileClick(View view) {
        InputStream in = null;
        try {
            in = getResources().openRawResource(R.raw.rawfile);
            byte[] bytes = new byte[1024];
            StringBuffer buffer = new StringBuffer();
            int len = -1;

            while ((len = in.read(bytes, 0, 1024)) != -1) {
                buffer.append(new String(bytes));
            }
            Toast.makeText(this, "Raw---" + buffer, Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * Write jsonfile into private cache.
     * Path:/data/data/<package name>/cache
     *
     * @param view
     */
    public void writeCacheFileClick(View view) {

        //String path = getCacheDir().toString();
        String fileName = "temp.tmp";
        //String completePath = path + "/" + fileName;

        FileOutputStream out = null;
        try {
            File temp = File.createTempFile(fileName, null, getCacheDir());
            out = new FileOutputStream(temp);
            PrintStream ps = new PrintStream(out);
            ps.print("Cache jsonfile test.");
            ps.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    public void checkExternalStorageClick(View view) {
        if (isExternalStorage()) {
            Toast.makeText(this, "The device has SD card.", Toast.LENGTH_SHORT).show();
            System.out.println(Environment.getExternalStorageDirectory().getPath());
            System.out.println(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
        } else {
            Toast.makeText(this, "The device doesn't have SD card.", Toast.LENGTH_SHORT).show();
        }

    }

    public boolean isExternalStorage() {
        boolean isExternal = false;

        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            isExternal = true;
        }
        return isExternal;
    }

    public boolean isSDCardOnlyReadable() {
        boolean isOnlyRead = false;

        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
            isOnlyRead = true;
        }

        return isOnlyRead;
    }

    public void checkSDCardReadOnlyClick(View view) {

        if (isExternalStorage()) {
            if (isSDCardOnlyReadable()) {
                Toast.makeText(this, "The SD card is read-only mode.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "The SD card is not read-only mode.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "The SD card doesn't exist.", Toast.LENGTH_SHORT).show();
        }
    }

    public void writePrivateFileExternalClick(View view) {
        FileOutputStream outputStream = null;
        File externalFile = getExternalFilesDir(null);
        if (externalFile != null) {
            try {
                outputStream = new FileOutputStream(externalFile + "/external_private_file.txt");
                PrintStream ps = new PrintStream(outputStream);
                ps.println("This is the external private jsonfile test.");
                ps.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    public void writePrivateCacheFileExternalClick(View view) {

        FileOutputStream outputStream = null;


        try {
            File externalPrivateCacheFile = File.createTempFile("private_cache", null, getExternalCacheDir());

            if (externalPrivateCacheFile != null) {
                Toast.makeText(this, externalPrivateCacheFile.toString(), Toast.LENGTH_SHORT).show();

                outputStream = new FileOutputStream(externalPrivateCacheFile);
                PrintStream ps = new PrintStream(outputStream);
                ps.println("This is the external private cache jsonfile test.");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
