package manager;

import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.assertEquals;

/**
 * Created by Yevgeniy_Alexeyenko on 4/7/2017.
 */
public class PropertyManagerTest {
    private PropertyManager manager;
    private Properties properties;

    @Before
    public void init() {
        this.manager = new PropertyManager();
    }

    @Test
    public void shouldCreateOracleJdbcProperties() {
        properties = manager.getOracleJdbcProperties();
        assertEquals("system", properties.getProperty("username"));

        assertEquals("sysadmin1", properties.getProperty("password"));
//        assertEquals("admin", properties.getProperty("password"));
    }

}