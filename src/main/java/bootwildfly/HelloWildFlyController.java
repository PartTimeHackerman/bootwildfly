package bootwildfly;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:kredki1", "admki", "admki");
            connection.close();
        } catch (Exception e) {
            return ("Can't connect ;_;");
        }
        return ("Connected! :3");

    }
}