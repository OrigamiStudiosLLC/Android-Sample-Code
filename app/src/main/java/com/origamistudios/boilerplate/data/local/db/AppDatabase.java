package com.origamistudios.boilerplate.data.local.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.origamistudios.boilerplate.data.local.db.dao.OptionDao;
import com.origamistudios.boilerplate.data.local.db.dao.QuestionDao;
import com.origamistudios.boilerplate.data.local.db.dao.UserDao;
import com.origamistudios.boilerplate.data.model.db.Option;
import com.origamistudios.boilerplate.data.model.db.Question;
import com.origamistudios.boilerplate.data.model.db.User;

@Database(entities = {User.class, Question.class, Option.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    public abstract OptionDao optionDao();

    public abstract QuestionDao questionDao();

    public abstract UserDao userDao();
}
