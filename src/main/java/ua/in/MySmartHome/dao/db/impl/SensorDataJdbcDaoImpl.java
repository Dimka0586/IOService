package ua.in.MySmartHome.dao.db.impl;

import ua.in.MySmartHome.dao.db.AbstractJdbcDao;
import ua.in.MySmartHome.dao.db.SensorDataJdbcDao;
import ua.in.MySmartHome.model.SensorData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shevchenko on 06.12.2016.
 */
public class SensorDataJdbcDaoImpl extends AbstractJdbcDao<SensorData> implements SensorDataJdbcDao {
    private final String CREATE_SQL = "INSERT INTO sensor_values (sensor_id, eng, " +
            "engMin, engMax, r, rMin, rMax) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private final String SELECT_SQL = "SELECT * FROM sensor_values";
    private final String UPDATE_SQL = "UPDATE sensor SET name=? WHERE id=?";
    private final String DELETE_SQL = "DELETE FROM sensor WHERE id=?";

    public SensorDataJdbcDaoImpl(Connection connection){
        super(connection);
    }

    @Override
    public String getCreateQuery() {
        return CREATE_SQL;
    }

    @Override
    public String getSelectQuery() {
        return SELECT_SQL;
    }

    @Override
    public String getUpdateQuery() {
        return UPDATE_SQL;
    }

    @Override
    public String getDeleteQuery() {
        return DELETE_SQL;
    }

    @Override
    public PreparedStatement prepareStatementForInsert(PreparedStatement statement, SensorData sensorData) throws SQLException {
        statement.setInt(1, sensorData.getSensor_id());
        statement.setInt(2, sensorData.getEng());
        statement.setInt(3, sensorData.getEngMin());
        statement.setInt(4, sensorData.getEngMax());
        statement.setFloat(5, sensorData.getOut());
        statement.setFloat(6, sensorData.getOutMin());
        statement.setFloat(7, sensorData.getOutMax());
        return statement;
    }

    @Override
    public PreparedStatement prepareStatementForUpdate(PreparedStatement statement, SensorData sensorData) throws SQLException {
        return null;
    }

    @Override
    public PreparedStatement prepareStatementForDelete(PreparedStatement statement, SensorData sensorData) throws SQLException {
        return null;
    }

    @Override
    public List<SensorData> parseResultSet(ResultSet rs) throws SQLException {
        List<SensorData> sensorDataList = new ArrayList<SensorData>();
        while(rs.next()){
            sensorDataList.add(new SensorData(rs.getInt("id"), rs.getInt("sensor_id"), rs.getInt("eng"),
                    rs.getInt("engMin"), rs.getInt("engMax"), rs.getFloat("rMin"), rs.getFloat("rMax")));
        }
        return sensorDataList;
    }

    @Override
    public List<SensorData> getSensorDataBySensorId() {

        return null;
    }
}
