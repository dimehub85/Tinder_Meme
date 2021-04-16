package dimemtl.com.Configuration;


import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import dimemtl.com.Exception.ApplicationException;
import dimemtl.com.Model.Meme;
import dimemtl.com.Model.MemeReview;
import dimemtl.com.Model.User;
import dimemtl.com.Model.UserInteraction;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import java.sql.SQLException;

public class JdbcDatabaseConfiguration implements DatabaseConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcDatabaseConfiguration.class);

    private final ConnectionSource connectionSource;


    public JdbcDatabaseConfiguration(String jdbcConnectionString) {
        try {
            connectionSource = new JdbcConnectionSource(jdbcConnectionString);
            LOGGER.debug(String.format("JdbcConnectionSource is build from {%s}", jdbcConnectionString));
            createTables();
        } catch (SQLException throwables) {
            LOGGER.error(ExceptionUtils.getStackTrace(throwables));
            throw new ApplicationException(String.format("Couldn't construct connection source from {%s}", jdbcConnectionString));
        }
    }

    private void createTables() throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, User.class);
        TableUtils.createTableIfNotExists(connectionSource, UserInteraction.class);
        TableUtils.createTableIfNotExists(connectionSource, Meme.class);
        TableUtils.createTableIfNotExists(connectionSource, MemeReview.class);

    }

    @Override
    public ConnectionSource connectionSource() {
        return connectionSource;
    }

}