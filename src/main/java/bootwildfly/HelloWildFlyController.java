package bootwildfly;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.*;

@RestController
public class HelloWildFlyController {
    @RequestMapping("hello")
    public String sayHello() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            return ("Can't create driver ;_;");
        }
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@10.72.0.4:1521:kredki1", "admki", "admki");
        } catch (Exception e) {
            Boolean isReachable = false;

            try {
                isReachable = InetAddress.getByAddress(new byte[] { 10, 72, 0, 4 }).isReachable(5000);
            } catch (IOException e1) {
                return (isReachable.toString());
            }
            return (isReachable.toString());
        }

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM BANK WHERE ROWNUM <= 5");
        StringBuilder stringBuilder = new StringBuilder();
        while (resultSet.next()){
            for (int i = 1; i <= resultSet.getFetchSize(); i++) {
                stringBuilder.append(resultSet.getString(i)+ " ");
            }
            stringBuilder.append("   XDDD  <br>");
        }
        connection.close();
        return (stringBuilder.toString());

    }
}