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
    String VERIFICATION_INPUT=readConfig().getString("verificationInput");

}
