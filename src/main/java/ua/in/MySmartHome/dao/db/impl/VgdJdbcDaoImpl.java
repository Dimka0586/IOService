package ua.in.MySmartHome.dao.db.impl;

import ua.in.MySmartHome.dao.db.AbstractJdbcDao;
import ua.in.MySmartHome.dao.db.VgdJdbcDao;
import ua.in.MySmartHome.model.Sensor;
import ua.in.MySmartHome.model.Vgd;
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
public class VgdJdbcDaoImpl extends AbstractJdbcDao<Vgd> implements VgdJdbcDao{

    private final String CREATE_SQL = "INSERT INTO vgd (name) VALUES (?)";
    private final String SELECT_SQL = "SELECT * FROM vgd";
    private final String UPDATE_SQL = "UPDATE vgd SET name=? WHERE id=?";
    private final String DELETE_SQL = "DELETE FROM vgd WHERE id=?";

    public VgdJdbcDaoImpl(Connection connection){
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
    public PreparedStatement prepareStatementForInsert(PreparedStatement statement, Vgd vgd) throws SQLException {
        statement.setString(1, vgd.getName());
        return statement;
    }

    @Override
    public PreparedStatement prepareStatementForUpdate(PreparedStatement statement, Vgd vgd) throws SQLException {
        statement.setString(1, vgd.getName());
        statement.setInt(2, vgd.getId());
        return statement;
    }

    @Override
    public PreparedStatement prepareStatementForDelete(PreparedStatement statement, Vgd vgd) throws SQLException {
        statement.setInt(1, vgd.getId());
        return statement;
    }

    @Override
    public List<Vgd> parseResultSet(ResultSet rs) throws SQLException {
        List<Vgd> vgdList = new ArrayList<Vgd>();
        while(rs.next()){
            vgdList.add(new Vgd(rs.getInt("id"), rs.getString("name")));
        }
        return vgdList;
    }


}
