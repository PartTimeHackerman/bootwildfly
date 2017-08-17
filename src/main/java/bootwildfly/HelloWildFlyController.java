package bootwildfly;

import oracle.jdbc.driver.OracleDriver;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;

@RestController
public class HelloWildFlyController {
    @RequestMapping("hello")
    public String sayHello() {
        OracleDriver od = new OracleDriver();
        System.out.println(od.toString());
        try {
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:kredki1", "admki", "admki");
            connection.close();
        } catch (Exception e) {
            return ("Can't connect ;_;");
        }
        return ("Connected! :3");

    }
}