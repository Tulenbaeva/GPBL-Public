package ui.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config= readConfig();
    static Config readConfig(){
        return ConfigFactory.load("application.conf");
    }
    String BROWSER=readConfig().getString("browser");
    String URL=readConfig().getString("url");
    String USER_LOGIN=readConfig().getString("usersParams.phone");
    String USER_PHONE=readConfig().getString("usersParams.phone");
    String USER_LASTNAME= readConfig().getString("usersParams.lastName");
    String USER_FIRSTNAME= readConfig().getString("usersParams.firstName");
    String USER_MIDDLENAME= readConfig().getString("usersParams.middleName");
    String USER_PASSWORD= readConfig().getString("usersParams.password");
    String VERIFICATION_INPUT=readConfig().getString("verificationInput");


}
