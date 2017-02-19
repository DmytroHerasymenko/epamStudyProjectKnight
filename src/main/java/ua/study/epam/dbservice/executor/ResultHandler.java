package ua.study.epam.dbservice.executor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by dima on 12.02.17.
 */
public interface ResultHandler<T> {
    T handle(ResultSet resultSet) throws SQLException;

}
