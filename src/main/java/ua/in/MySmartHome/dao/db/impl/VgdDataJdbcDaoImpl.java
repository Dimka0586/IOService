package ua.in.MySmartHome.dao.db.impl;

import ua.in.MySmartHome.dao.db.AbstractJdbcDao;
import ua.in.MySmartHome.dao.db.VgdDataJdbcDao;
import ua.in.MySmartHome.model.SensorData;
import ua.in.MySmartHome.model.VgdData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shevchenko on 10.12.2016.
 */
public class VgdDataJdbcDaoImpl extends AbstractJdbcDao<VgdData> implements VgdDataJdbcDao {
    private final String CREATE_SQL = "INSERT INTO vgd_values (vgd_id, open, " +
            "opened, closed, time_open, time_close, alarm_open, alarm_close) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private final String SELECT_SQL = "SELECT * FROM vgd_values";
    private final String UPDATE_SQL = "UPDATE vgd_values SET name=? WHERE id=?";
    private final String DELETE_SQL = "DELETE FROM vgd_values WHERE id=?";

    public VgdDataJdbcDaoImpl(Connection connection){
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
    public PreparedStatement prepareStatementForInsert(PreparedStatement statement, VgdData vgdData) throws SQLException {
        statement.setInt(1, vgdData.getVgd_id());
        statement.setBoolean(2, vgdData.isOpen());
        statement.setBoolean(3, vgdData.isOpened());
        statement.setBoolean(4, vgdData.isClosed());
        statement.setTime(5, vgdData.getTimeOpen());
        statement.setTime(6, vgdData.getTimeClose());
        statement.setBoolean(7, vgdData.isAlarmOpen());
        statement.setBoolean(8, vgdData.isAlarmClose());
        return statement;
    }

    @Override
    public PreparedStatement prepareStatementForUpdate(PreparedStatement statement, VgdData vgdData) throws SQLException {
        return null;
    }

    @Override
    public PreparedStatement prepareStatementForDelete(PreparedStatement statement, VgdData vgdData) throws SQLException {
        return null;
    }

    @Override
    public List<VgdData> parseResultSet(ResultSet rs) throws SQLException {
        List<VgdData> vgdDataList = new ArrayList<VgdData>();
        while(rs.next()){
            vgdDataList.add(new VgdData(rs.getInt("id"), rs.getInt("vgd_id"), rs.getBoolean("open"),
                    rs.getBoolean("opened"), rs.getBoolean("closed"), rs.getTime("time_open"), rs.getTime("time_close"),
                    rs.getBoolean("alarm_open"), rs.getBoolean("alarm_close")));
        }
        return vgdDataList;
    }
}
