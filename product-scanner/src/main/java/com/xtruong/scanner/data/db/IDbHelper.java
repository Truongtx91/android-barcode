package com.xtruong.scanner.data.db;

import com.xtruong.scanner.data.db.model.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by truongtx on 8/12/2019
 */
public interface IDbHelper {

    Observable<Long> insertUser(final User user);

    Observable<List<User>> getAllUsers();

}
