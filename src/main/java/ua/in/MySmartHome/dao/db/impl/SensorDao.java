package ua.in.MySmartHome.dao.db.impl;

import ua.in.MySmartHome.dao.db.AbstractJDBCDao;
import ua.in.MySmartHome.model.Sensor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implemen
 */
public class SensorDao extends AbstractJDBCDao<Sensor> {
    private final String CREATE_SQL = "INSERT INTO sensor (name) VALUES (?)";
    private final String SELECT_SQL = "SELECT * FROM sensor";
    private final String UPDATE_SQL = "UPDATE sensor SET name=? WHERE id=?";
    private final String DELETE_SQL = "DELETE FROM sensor WHERE id=?";

    public SensorDao(Connection connection){
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
    public PreparedStatement prepareStatementForInsert(PreparedStatement statement, Sensor sensor) throws SQLException{
        statement.setString(1, sensor.getName());
        return statement;
    }

    @Override
    public PreparedStatement prepareStatementForUpdate(PreparedStatement statement, Sensor sensor) throws SQLException{
        statement.setString(1, sensor.getName());
        statement.setInt(2, sensor.getId());
        return statement;
    }

    @Override
    public PreparedStatement prepareStatementForDelete(PreparedStatement statement, Sensor sensor) throws SQLException {
        statement.setInt(1, sensor.getId());
        return statement;
    }

    @Override
    public List<Sensor> parseResultSet(ResultSet rs) throws SQLException{
        List<Sensor> sensorList = new ArrayList<Sensor>();
        while(rs.next()){
            sensorList.add(new Sensor(rs.getInt("id"), rs.getString("name")));
        }
        return sensorList;
    }
}
