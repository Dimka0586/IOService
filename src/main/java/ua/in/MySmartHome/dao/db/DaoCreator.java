package ua.in.MySmartHome.dao.db;

/**
 * Created by Shevchenko on 14.11.2016.
 */
public interface DaoCreator<Context> {
    public GenericDao create(Context context);
}
