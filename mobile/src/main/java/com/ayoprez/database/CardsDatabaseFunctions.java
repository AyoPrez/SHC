package com.ayoprez.database;

import android.content.Context;

import java.util.List;

import SHC_Schema.Card;
import SHC_Schema.CardDao;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;

/**
 * Created by AyoPrez on 11/08/15.
 */
public class CardsDatabaseFunctions {

    public static void insertOrUpdateCards(Context context, Card card) {
        getCardDao(context).insertOrReplace(card);
    }


    public long getIdFromData(Context context, Card card){
        QueryBuilder qb = getCardDao(context).queryBuilder();
        qb.where(new WhereCondition.StringCondition("Text = '"+ card.getText() +"' " ));

        List<Card> idList = qb.list();
        return idList.get(0).getId();
    }

    public long getLastId(Context context){
        List<Card> userMomentsList = getCardDao(context).loadAll();

        if(userMomentsList.size() == 0){
            return 0;
        }else{
            long lastId = getCardDao(context).loadAll().get(getRowsCount(context) - 1).getId();
            return lastId + 1;
        }
    }

    public int getRowsCount(Context context){
        int totalSize = getCardDao(context).loadAll().size();
        return totalSize;
    }

    public static void clearAllCards(Context context) {
        getCardDao(context).deleteAll();
    }

    public static void deleteCardWithId(Context context, long id) {
        getCardDao(context).delete(getMomentForId(context, id));
    }

    public static List<Card> getAllCards(Context context) {
        return getCardDao(context).loadAll();
    }

    public static Card getMomentForId(Context context, long id) {
        return getCardDao(context).load(id);
    }

    private static CardDao getCardDao(Context c) {
        return new CreateDatabase(c).getDaoSession().getCardDao();
    }
}
