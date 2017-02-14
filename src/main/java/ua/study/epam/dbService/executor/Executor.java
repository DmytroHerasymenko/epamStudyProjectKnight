package ua.study.epam.dbService.executor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by dima on 12.02.17.
 */
public class Executor {
    private final Connection connection;

    public Executor(Connection connection) {
        this.connection = connection;
    }

    public void executorUpdate(String update) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(update);
            stmt.close();
        }
    }

    public <T> T executorQuery(String query, ResultHandler<T> handler) throws SQLException {
        T value;
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(query);
            try (ResultSet result = stmt.getResultSet()) {
                value = handler.handle(result);
                result.close();
            }
            stmt.close();
        }

        return value;
    }
}
