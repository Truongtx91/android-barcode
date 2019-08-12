package com.xtruong.scanner.data.db;

import android.content.Context;

import com.xtruong.scanner.data.db.model.DaoMaster;
import com.xtruong.scanner.data.db.model.DaoSession;
import com.xtruong.scanner.di.ApplicationContext;
import com.xtruong.scanner.di.DatabaseInfo;
import com.xtruong.scanner.utils.AppLogger;

import org.greenrobot.greendao.database.Database;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by truongtx on 8/12/2019
 */
@Singleton
public class DbOpenHelper extends DaoMaster.OpenHelper {


    @Inject
    public DbOpenHelper(@ApplicationContext Context context, @DatabaseInfo String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        AppLogger.d("DEBUG", "DB_OLD_VERSION : " + oldVersion + ", DB_NEW_VERSION : " + newVersion);
        switch (oldVersion) {
            case 1:
            case 2:
                //db.execSQL("ALTER TABLE " + UserDao.TABLENAME + " ADD COLUMN "
                // + UserDao.Properties.Name.columnName + " TEXT DEFAULT 'DEFAULT_VAL'");
        }
    }

}
