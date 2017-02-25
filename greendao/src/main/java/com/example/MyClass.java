package com.example;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class MyClass  {
    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1, "com.example.phamvan.quotes.QUOTES_DB");
        Entity userNote = schema.addEntity("UserNote");
        userNote.addLongProperty("id").primaryKey().autoincrement();
        userNote.addStringProperty("sentence");

        // thêm các entity, nó sẽ tạo ra các entity vào dao ở trong mục trên, việc tạo ra các entity, nó sẽ tự động mapping đến bảng tương ứng,
        Entity userLike = schema.addEntity("UserLike");
        userLike.addLongProperty("id").primaryKey().autoincrement();
        userLike.addStringProperty("author");
        userLike.addStringProperty("sentence");
        userLike.addStringProperty("vietnamese");

        Entity Bautiful = schema.addEntity("Beautiful");
        Bautiful.addLongProperty("id").primaryKey().autoincrement();
        Bautiful.addStringProperty("author");
        Bautiful.addStringProperty("sentence");
        Bautiful.addStringProperty("vietnamese");

        Entity Friendship = schema.addEntity("Friendship");
        Friendship.addLongProperty("id").primaryKey().autoincrement();
        Friendship.addStringProperty("author");
        Friendship.addStringProperty("sentence");
        Friendship.addStringProperty("vietnamese");

        Entity Family = schema.addEntity("Family");
        Family.addLongProperty("id").primaryKey().autoincrement();
        Family.addStringProperty("author");
        Family.addStringProperty("sentence");
        Family.addStringProperty("vietnamese");

        Entity Happiness = schema.addEntity("Happiness");
        Happiness.addLongProperty("id").primaryKey().autoincrement();
        Happiness.addStringProperty("author");
        Happiness.addStringProperty("sentence");
        Happiness.addStringProperty("vietnamese");

        Entity HeartSpirit = schema.addEntity("HeartSpirit");
        HeartSpirit.addLongProperty("id").primaryKey().autoincrement();
        HeartSpirit.addStringProperty("author");
        HeartSpirit.addStringProperty("sentence");
        HeartSpirit.addStringProperty("vietnamese");

        Entity Knowledge = schema.addEntity("Knowledge");
        Knowledge.addLongProperty("id").primaryKey().autoincrement();
        Knowledge.addStringProperty("author");
        Knowledge.addStringProperty("sentence");
        Knowledge.addStringProperty("vietnamese");

        Entity Love = schema.addEntity("Love");
        Love.addLongProperty("id").primaryKey().autoincrement();
        Love.addStringProperty("author");
        Love.addStringProperty("sentence");
        Love.addStringProperty("vietnamese");

        Entity LoveLife = schema.addEntity("LoveLife");
        LoveLife.addLongProperty("id").primaryKey().autoincrement();
        LoveLife.addStringProperty("author");
        LoveLife.addStringProperty("sentence");
        LoveLife.addStringProperty("vietnamese");

        Entity Man = schema.addEntity("Man");
        Man.addLongProperty("id").primaryKey().autoincrement();
        Man.addStringProperty("author");
        Man.addStringProperty("sentence");
        Man.addStringProperty("vietnamese");

        Entity ManWoman = schema.addEntity("ManWoman");
        ManWoman.addLongProperty("id").primaryKey().autoincrement();
        ManWoman.addStringProperty("author");
        ManWoman.addStringProperty("sentence");
        ManWoman.addStringProperty("vietnamese");

        Entity Marriage = schema.addEntity("Marriage");
        Marriage.addLongProperty("id").primaryKey().autoincrement();
        Marriage.addStringProperty("author");
        Marriage.addStringProperty("sentence");
        Marriage.addStringProperty("vietnamese");

        DaoGenerator dg = new DaoGenerator();
        dg.generateAll(schema,"D:\\hoc_tap\\cntt\\android_java\\project_android\\Quotes\\app\\src\\main\\java");

    }
}
