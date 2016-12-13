package ua.in.MySmartHome.dao.db;

import ua.in.MySmartHome.model.Sensor;
import ua.in.MySmartHome.model.SensorData;

import java.util.List;

/**
 * Created by Shevchenko on 09.12.2016.
 */
public interface SensorJdbcDao extends GenericDao<Sensor>{
    SensorData getLastSensorData(Sensor sensor);
}
