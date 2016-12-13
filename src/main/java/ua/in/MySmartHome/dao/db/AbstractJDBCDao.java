package ua.in.MySmartHome.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Abstract class provides base implementation CRUD using JDBC
 */
public abstract class AbstractJdbcDao<T> implements GenericDao<T>{

    private Connection connection;

    public AbstractJdbcDao(Connection connection){
        this.connection = connection;
    }

    /**Return sql query for creating new record*/
    public abstract String getCreateQuery();

    /**Return sql query for selecting records*/
    public abstract String getSelectQuery();

    /**Return sql query for updating record*/
    public abstract String getUpdateQuery();

    /**Return sql query for deleting record*/
    public abstract String getDeleteQuery();

    /**Set params to prepare statement for insert record*/
    public abstract PreparedStatement prepareStatementForInsert(PreparedStatement statement, T t) throws SQLException;

    /**Set params to prepare statement for update record*/
    public abstract PreparedStatement prepareStatementForUpdate(PreparedStatement statement, T t) throws SQLException;

    /**Set params to prepare statement for delete record*/
    public abstract PreparedStatement prepareStatementForDelete(PreparedStatement statement, T t) throws SQLException;

    /**Parse ResultSet and return List of objects*/
    public abstract List<T> parseResultSet(ResultSet rs) throws SQLException;

    @Override
    public T create(T t) throws SQLException{
        PreparedStatement statement = connection.prepareStatement(getCreateQuery());
        prepareStatementForInsert(statement, t);
        int count = statement.executeUpdate();
        if (count > 0){
            PreparedStatement statement1 = connection.prepareStatement(getSelectQuery()+ " WHERE id = last_insert_id();");
            ResultSet rs = statement1.executeQuery();
            List<T> tList = parseResultSet(rs);
            return tList.get(0);
        }
        return null;
    }

    @Override
    public T readById(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(getSelectQuery()+" WHERE id=?");
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        List<T> tList = parseResultSet(rs);
        if (tList != null){
            return tList.get(0);
        }
        return null;
    }

    @Override
    public void update(T t) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(getUpdateQuery());
        statement = prepareStatementForUpdate(statement, t);
        statement.executeUpdate();
    }

    @Override
    public void delete(T t) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(getDeleteQuery());
        statement = prepareStatementForDelete(statement, t);
        statement.executeUpdate();
    }

    @Override
    public List<T> readAll() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(getSelectQuery());
        ResultSet rs = statement.executeQuery();
        List tList = parseResultSet(rs);
        return tList;
    }
}
