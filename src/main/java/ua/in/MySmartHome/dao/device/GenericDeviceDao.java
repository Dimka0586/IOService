package ua.in.MySmartHome.dao.device;

/**
 * Interface of control states object
 * @param <T> type of object
 */
public interface GenericDeviceDao<T> {
    /**Return object from device*/
    public T read(T t);
    /**Update object in device*/
    public void update(T t);
}
