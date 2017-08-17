package bootwildfly;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;

@RestController
public class HelloWildFlyController {
    @RequestMapping("hello")
    public String sayHello() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            return ("Can't create driver ;_;");
        }
        try {
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@10.72.0.4:1521:kredki1", "admki", "admki");
            connection.close();
        } catch (Exception e) {
            Boolean isReachable = false;

            try {
                isReachable = InetAddress.getByAddress(new byte[] { 10, 72, 0, 4 }).isReachable(5000);
            } catch (IOException e1) {
                return (isReachable.toString());
            }
            return (isReachable.toString());
        }
        return ("Connected! :3");

    }
}