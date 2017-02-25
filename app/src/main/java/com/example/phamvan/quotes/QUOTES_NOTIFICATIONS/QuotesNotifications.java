package com.example.phamvan.quotes.QUOTES_NOTIFICATIONS;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

import com.example.phamvan.quotes.QUOTES_ACTIVITY.MainActivity;
import com.example.phamvan.quotes.QUOTES_DB.Beautiful;
import com.example.phamvan.quotes.QUOTES_DB.BeautifulDao;
import com.example.phamvan.quotes.QUOTES_DB.DaoSession;
import com.example.phamvan.quotes.QUOTES_DB.Family;
import com.example.phamvan.quotes.QUOTES_DB.FamilyDao;
import com.example.phamvan.quotes.QUOTES_DB.Friendship;
import com.example.phamvan.quotes.QUOTES_DB.FriendshipDao;
import com.example.phamvan.quotes.QUOTES_DB.Happiness;
import com.example.phamvan.quotes.QUOTES_DB.HappinessDao;
import com.example.phamvan.quotes.QUOTES_DB.HeartSpirit;
import com.example.phamvan.quotes.QUOTES_DB.HeartSpiritDao;
import com.example.phamvan.quotes.QUOTES_DB.Knowledge;
import com.example.phamvan.quotes.QUOTES_DB.KnowledgeDao;
import com.example.phamvan.quotes.QUOTES_DB.Love;
import com.example.phamvan.quotes.QUOTES_DB.LoveDao;
import com.example.phamvan.quotes.QUOTES_DB.LoveLife;
import com.example.phamvan.quotes.QUOTES_DB.LoveLifeDao;
import com.example.phamvan.quotes.QUOTES_DB.Man;
import com.example.phamvan.quotes.QUOTES_DB.ManDao;
import com.example.phamvan.quotes.QUOTES_DB.ManWoman;
import com.example.phamvan.quotes.QUOTES_DB.ManWomanDao;
import com.example.phamvan.quotes.QUOTES_DB.Marriage;
import com.example.phamvan.quotes.QUOTES_DB.MarriageDao;
import com.example.phamvan.quotes.QUOTES_STATIC.JoinDatabase;
import com.example.phamvan.quotes.R;

import org.greenrobot.greendao.query.QueryBuilder;
import java.util.List;
import java.util.Random;

/**
 * Created by PhamVan on 2/19/2017.
 */
public class QuotesNotifications extends BroadcastReceiver {
    public static String sentence;

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent notificationIntent = new Intent(context, MainActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(notificationIntent);

        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);

        Notification notification = builder.setContentTitle("Quotes")
                .setContentText(sentence)
                .setSmallIcon(R.mipmap.quotes_icon)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent).build();

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);
    }


    public static String randomSentence() {

        int sizeList;
        Random random = new Random();
        int position = random.nextInt(10);
        DaoSession daoSession = JoinDatabase.daoSession;
        int postion2 ;
        switch (position){
            case 0:
                sizeList = (int) daoSession.getFriendshipDao().queryBuilder().count();
                postion2 = random.nextInt(sizeList - 1);
                if(postion2>1) {
                    QueryBuilder<Friendship> fr = daoSession.getFriendshipDao().queryBuilder();
                    fr.where(FriendshipDao.Properties.Id.eq(postion2)); // cau quryBuider
                    List<Friendship> friendships = fr.list();
                    sentence = friendships.get(0).getSentence();
                }
                break;
            case 1:
                sizeList = (int) daoSession.getBeautifulDao().queryBuilder().count();
                postion2 = random.nextInt(sizeList - 1);
                if(postion2>1) {
                    QueryBuilder<Beautiful> fr = daoSession.getBeautifulDao().queryBuilder();
                    fr.where(BeautifulDao.Properties.Id.eq(postion2)); // cau quryBuider
                    List<Beautiful> beautifuls = fr.list();
                    sentence = beautifuls.get(0).getSentence();
                }
                break;
            case 2:
                sizeList = (int) daoSession.getFamilyDao().queryBuilder().count();
                postion2 = random.nextInt(sizeList - 1);
                if(postion2>1) {
                    QueryBuilder<Family> fr = daoSession.getFamilyDao().queryBuilder();
                    fr.where(FamilyDao.Properties.Id.eq(postion2)); // cau quryBuider
                    List<Family> families = fr.list();
                    sentence = families.get(0).getSentence();
                }
                break;
            case 3:
                sizeList = (int) daoSession.getHappinessDao().queryBuilder().count();
                postion2 = random.nextInt(sizeList - 1);
                if(postion2>1) {
                    QueryBuilder<Happiness> fr = daoSession.getHappinessDao().queryBuilder();
                    fr.where(HappinessDao.Properties.Id.eq(postion2)); // cau quryBuider
                    List<Happiness> happinesses = fr.list();
                    sentence = happinesses.get(0).getSentence();
                }
                break;
            case 4:
                sizeList = (int) daoSession.getHeartSpiritDao().queryBuilder().count();
                postion2 = random.nextInt(sizeList - 1);
                if(postion2>1) {
                    QueryBuilder<HeartSpirit> tmp = daoSession.getHeartSpiritDao().queryBuilder();
                    tmp.where(HeartSpiritDao.Properties.Id.eq(postion2)); // cau quryBuider
                    List<HeartSpirit> heartSpirits = tmp.list();
                    sentence = heartSpirits.get(0).getSentence();
                }
                break;
            case 5:
                sizeList = (int) daoSession.getKnowledgeDao().queryBuilder().count();
                postion2 = random.nextInt(sizeList - 1);
                if(postion2>1) {
                    QueryBuilder<Knowledge> fr = daoSession.getKnowledgeDao().queryBuilder();
                    fr.where(KnowledgeDao.Properties.Id.eq(postion2)); // cau quryBuider
                    List<Knowledge> knowledges = fr.list();
                    sentence = knowledges.get(0).getSentence();
                }
                break;
            case 6:
                sizeList = (int) daoSession.getLoveDao().queryBuilder().count();
                postion2 = random.nextInt(sizeList - 1);
                if(postion2>1) {
                    QueryBuilder<Love> fr = daoSession.getLoveDao().queryBuilder();
                    fr.where(LoveDao.Properties.Id.eq(postion2)); // cau quryBuider
                    List<Love> loves = fr.list();
                    sentence = loves.get(0).getSentence();
                }
                break;
            case 7:
                sizeList = (int) daoSession.getLoveLifeDao().queryBuilder().count();
                postion2 = random.nextInt(sizeList - 1);
                if(postion2>1) {
                    QueryBuilder<LoveLife> fr = daoSession.getLoveLifeDao().queryBuilder();
                    fr.where(LoveLifeDao.Properties.Id.eq(postion2)); // cau quryBuider
                    List<LoveLife> loveLifes = fr.list();
                    sentence = loveLifes.get(0).getSentence();
                }
                break;
            case 8:
                sizeList = (int) daoSession.getManDao().queryBuilder().count();
                postion2 = random.nextInt(sizeList - 1);
                if(postion2>1) {
                    QueryBuilder<Man> fr = daoSession.getManDao().queryBuilder();
                    fr.where(ManDao.Properties.Id.eq(postion2)); // cau quryBuider
                    List<Man> men = fr.list();
                    sentence = men.get(0).getSentence();
                }
                break;
            case 9:
                sizeList = (int) daoSession.getManWomanDao().queryBuilder().count();
                postion2 = random.nextInt(sizeList - 1);
                if(postion2>1) {
                    QueryBuilder<ManWoman> fr = daoSession.getManWomanDao().queryBuilder();
                    fr.where(ManWomanDao.Properties.Id.eq(postion2)); // cau quryBuider
                    List<ManWoman> manWomanList = fr.list();
                    sentence = manWomanList.get(0).getSentence();
                }
                break;
            case 10:
                sizeList = (int) daoSession.getMarriageDao().queryBuilder().count();
                postion2 = random.nextInt(sizeList - 1);
                if(postion2>1) {
                    QueryBuilder<Marriage> fr = daoSession.getMarriageDao().queryBuilder();
                    fr.where(MarriageDao.Properties.Id.eq(postion2)); // cau quryBuider
                    List<Marriage> marriages = fr.list();
                    sentence = marriages.get(0).getSentence();
                }
                break;

        }
        return sentence;
    }
}
