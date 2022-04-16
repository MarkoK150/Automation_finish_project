package selenium_core;

public class DriverManagerFactory {
    public static DriverManagerInterface getDriverManager(String type){
        DriverManagerInterface driverManager;

        switch (type){
            case "CHROME":
                driverManager=new ChromeDriverManager();
                break;

            default:
                driverManager=new ChromeDriverManager();
                break;
        }
        return driverManager;
    }
}
