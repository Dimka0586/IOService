package ua.in.MySmartHome.dao.db;

import ua.in.MySmartHome.model.SensorData;

import java.util.List;

/**
 * Created by Shevchenko on 09.12.2016.
 */
public interface SensorDataJdbcDao extends GenericDao<SensorData>{
    List<SensorData> getSensorDataBySensorId();
}
