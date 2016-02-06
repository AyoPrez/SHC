package com.ayoprez.database;

import android.content.Context;

import java.util.List;

import SHC_Schema.GroupCard;
import SHC_Schema.GroupCardDao;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;

/**
 * Created by AyoPrez on 11/08/15.
 */
public class CardsGroupDatabaseFunctions {

    public static void insertOrUpdateGroupCards(Context context, GroupCard groupCard) {
        getGroupCardDao(context).insertOrReplace(groupCard);
    }

    public long getIdFromData(Context context, GroupCard groupCard){
        QueryBuilder qb = getGroupCardDao(context).queryBuilder();
        qb.where(new WhereCondition.StringCondition("Name = '"+ groupCard.getName() +"' "));

        List<GroupCard> idList = qb.list();
        return idList.get(0).getId();
    }

    public long getLastId(Context context){
        List<GroupCard> userMomentsList = getGroupCardDao(context).loadAll();

        if(userMomentsList.size() == 0){
            return 0;
        }else{
            long lastId = getGroupCardDao(context).loadAll().get(getRowsCount(context) - 1).getId();
            return lastId + 1;
        }
    }

    public int getRowsCount(Context context){
        int totalSize = getGroupCardDao(context).loadAll().size();
        return totalSize;
    }

    public static void clearAllGroups(Context context) {
        getGroupCardDao(context).deleteAll();
    }

    public static void deleteGroupWithId(Context context, long id) {
        getGroupCardDao(context).delete(getGroupById(context, id));
    }

    public static List<GroupCard> getAllGroups(Context context) {
        return getGroupCardDao(context).loadAll();
    }

    public static GroupCard getGroupById(Context context, long id) {
        return getGroupCardDao(context).load(id);
    }

    private static GroupCardDao getGroupCardDao(Context c) {
        return new CreateDatabase(c).getDaoSession().getGroupCardDao();
    }

}
