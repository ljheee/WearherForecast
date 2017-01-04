package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.ljheee.wearherforecast.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class DbManager {

    Context context;
    public DbManager(Context context) {
        this.context = context;

    }

    public SQLiteDatabase getDatabase() {
        return openDatabase();
    }

    private SQLiteDatabase openDatabase() {
//        String path = getFilesDir();
        String dirPath="/data/data/com.ljheee.wearherforecast/databases";//存放所有城市历史天气
        File dir = new File(dirPath);
        if(!dir.exists()) {
            dir.mkdir();
        }
        //数据库文件
        File file = new File(dir, "city.db");
        try {
            if(!file.exists()) {
                file.createNewFile();
                //加载需要导入的数据库
                InputStream is = this.context.getApplicationContext().getResources().openRawResource(R.raw.city);
//            Log.d("size",is.available()+"");
                FileOutputStream fos = new FileOutputStream(file);
                byte[] buffer = new byte[is.available()];
                is.read(buffer);
                fos.write(buffer);
                is.close();
                fos.close();
            }else {
                return SQLiteDatabase.openOrCreateDatabase(file,
                        null);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }


        return  SQLiteDatabase.openOrCreateDatabase(file,
                null);
    }
}
