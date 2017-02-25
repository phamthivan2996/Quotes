package com.example.phamvan.quotes.QUOTES_STATIC;

import com.example.phamvan.quotes.QUOTES_DB.Beautiful;

import com.example.phamvan.quotes.QUOTES_DB.Family;
import com.example.phamvan.quotes.QUOTES_DB.Friendship;
import com.example.phamvan.quotes.QUOTES_DB.Happiness;
import com.example.phamvan.quotes.QUOTES_DB.HeartSpirit;
import com.example.phamvan.quotes.QUOTES_DB.Knowledge;
import com.example.phamvan.quotes.QUOTES_DB.Love;
import com.example.phamvan.quotes.QUOTES_DB.LoveLife;
import com.example.phamvan.quotes.QUOTES_DB.Man;
import com.example.phamvan.quotes.QUOTES_DB.ManWoman;
import com.example.phamvan.quotes.QUOTES_DB.Marriage;
import com.example.phamvan.quotes.QUOTES_OBJECTS.QuotesObject;

import java.util.List;

/**
 * Created by PhamVan on 2/10/2017.
 */
public class SupportItem {
    public static Long id;
    public static String author, sentence,vietnamese;

    public static void transferBeautiful(List<Beautiful> beautifuls, List<QuotesObject> listItem) {
        for(int i = 0; i<beautifuls.size();i++) {
            id = beautifuls.get(i).getId();
            author = beautifuls.get(i).getAuthor();
            sentence = beautifuls.get(i).getSentence();
            vietnamese = beautifuls.get(i).getVietnamese();
            listItem.add(new QuotesObject(id,author,sentence,vietnamese));
        }
    }
    public static void transferFriendShip(List<Friendship> friendships, List<QuotesObject> listItem) {
        for(int i = 0; i<friendships.size();i++) {
            id = friendships.get(i).getId();
            author = friendships.get(i).getAuthor();
            sentence = friendships.get(i).getSentence();
            vietnamese = friendships.get(i).getVietnamese();
            listItem.add(new QuotesObject(id,author,sentence,vietnamese));
        }
    }
    public static void transferFamily(List<Family> families, List<QuotesObject> listItem) {
        for(int i = 0; i<families.size();i++) {
            id = families.get(i).getId();
            author = families.get(i).getAuthor();
            sentence = families.get(i).getSentence();
            vietnamese = families.get(i).getVietnamese();
            listItem.add(new QuotesObject(id,author,sentence,vietnamese));
        }
    }
    public static void transferHappiness(List<Happiness> happinesses, List<QuotesObject> listItem) {
        for(int i = 0; i<happinesses.size();i++) {
            id = happinesses.get(i).getId();
            author = happinesses.get(i).getAuthor();
            sentence = happinesses.get(i).getSentence();
            vietnamese = happinesses.get(i).getVietnamese();
            listItem.add(new QuotesObject(id,author,sentence,vietnamese));
        }
    }
    public static void transferHeartSpirit(List<HeartSpirit> heartSpirits, List<QuotesObject> listItem) {
        for(int i = 0; i<heartSpirits.size();i++) {
            id = heartSpirits.get(i).getId();
            author = heartSpirits.get(i).getAuthor();
            sentence = heartSpirits.get(i).getSentence();
            vietnamese = heartSpirits.get(i).getVietnamese();
            listItem.add(new QuotesObject(id,author,sentence,vietnamese));
        }
    }
    public static void transferKnowLedge(List<Knowledge> knowledges, List<QuotesObject> listItem) {
        for(int i = 0; i<knowledges.size();i++) {
            id = knowledges.get(i).getId();
            author = knowledges.get(i).getAuthor();
            sentence = knowledges.get(i).getSentence();
            vietnamese = knowledges.get(i).getVietnamese();
            listItem.add(new QuotesObject(id,author,sentence,vietnamese));
        }
    }
    public static void transferLove(List<Love> loves, List<QuotesObject> listItem) {
        for(int i = 0; i<loves.size();i++) {
            id = loves.get(i).getId();
            author = loves.get(i).getAuthor();
            sentence = loves.get(i).getSentence();
            vietnamese = loves.get(i).getVietnamese();
            listItem.add(new QuotesObject(id,author,sentence,vietnamese));
        }
    }
    public static void transferLoveLife(List<LoveLife> loveLifes, List<QuotesObject> listItem) {
        for(int i = 0; i<loveLifes.size();i++) {
            id = loveLifes.get(i).getId();
            author = loveLifes.get(i).getAuthor();
            sentence = loveLifes.get(i).getSentence();
            vietnamese = loveLifes.get(i).getVietnamese();
            listItem.add(new QuotesObject(id,author,sentence,vietnamese));
        }
    }
    public static void transferMan(List<Man> manList, List<QuotesObject> listItem) {
        for(int i = 0; i<manList.size();i++) {
            id = manList.get(i).getId();
            author = manList.get(i).getAuthor();
            sentence = manList.get(i).getSentence();
            vietnamese = manList.get(i).getVietnamese();
            listItem.add(new QuotesObject(id,author,sentence,vietnamese));
        }
    }
    public static void transferManWoman(List<ManWoman> manWomanList, List<QuotesObject> listItem) {
        for(int i = 0; i<manWomanList.size();i++) {
            id = manWomanList.get(i).getId();
            author = manWomanList.get(i).getAuthor();
            sentence = manWomanList.get(i).getSentence();
            vietnamese = manWomanList.get(i).getVietnamese();
            listItem.add(new QuotesObject(id,author,sentence,vietnamese));
        }
    }
    public static void transferMarriage(List<Marriage> marriages, List<QuotesObject> listItem) {
        for(int i = 0; i<marriages.size();i++) {
            id = marriages.get(i).getId();
            author = marriages.get(i).getAuthor();
            sentence = marriages.get(i).getSentence();
            vietnamese = marriages.get(i).getVietnamese();
            listItem.add(new QuotesObject(id,author,sentence,vietnamese));
        }
    }


}
