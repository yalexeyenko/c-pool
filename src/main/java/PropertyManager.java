import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Yevgeniy_Alexeyenko on 4/7/2017.
 */
public class PropertyManager {

    public Properties getOracleJdbcProperties() {
        Properties properties = new Properties();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("oracleJdbc.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }
}
