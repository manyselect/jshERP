package com.jsh.erp.config;

import com.gitee.starblues.extension.mybatis.SpringBootMybatisExtension;
import com.gitee.starblues.integration.application.AutoPluginApplication;
import com.gitee.starblues.integration.application.PluginApplication;
import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: jishenghua
 * @Version: 1.0
 * @Create Date Time: 2019-05-30 15:53
 * @Update Date Time:
 * @see
 */
@Configuration
public class PluginBeanConfig {
    @Bean
    public PluginApplication pluginApplication(){
        PluginApplication pluginApplication = new AutoPluginApplication();
        pluginApplication.addExtension(new SpringBootMybatisExtension());
        return pluginApplication;
    }
    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
            @Override
            public void customize(Connector connector) {
                connector.setProperty("relaxedQueryChars", "|{}[]");
            }
        });
        return factory;
    }
}
