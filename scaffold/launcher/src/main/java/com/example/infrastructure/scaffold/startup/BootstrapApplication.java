package com.example.infrastructure.scaffold.startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class BootstrapApplication {

    public static final Logger log = LoggerFactory.getLogger(BootstrapApplication.class);
    private static final int LINE_CHARACTER_NUM = 64;
    private static final String CHAR_1 = "+";
    private static final String CHAR_2 = "=";

    public static void main(String[] args) {
        SpringApplication.run(BootstrapApplication.class, args);
    }

    private static void extracted(StringBuilder stBu, String linePrompt) {
        int length = linePrompt.length();
        int promptLocation = (LINE_CHARACTER_NUM - length) / 2;
        String lineFormat = "%" + promptLocation + "s";
        String lineSpace = String.format(lineFormat, "");
        stBu.append(lineSpace).append(linePrompt).append(lineSpace).append((LINE_CHARACTER_NUM - length & 0x01) == 1 ? " " : "").append(CHAR_1).append("\n");
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> start() {
        return event -> {
            ConfigurableEnvironment environment = event.getApplicationContext().getEnvironment();
            String hostAddress = "";
            try {
                InetAddress localHost = Inet4Address.getLocalHost();
                hostAddress = localHost.getHostAddress();
            } catch (UnknownHostException e) {
                log.error("Start listening error, can not get 'LocalHost'.", e);
            }

            String host = hostAddress == null || hostAddress.length() == 0 ? "localhost" : hostAddress;
            String port = environment.getProperty("server.port") == null ? "8080" : environment.getProperty("server.port");
            StringBuilder stBu = new StringBuilder();
            // line 1
            stBu.append(CHAR_1);
            for (int i = 0; i < LINE_CHARACTER_NUM; i++) {
                stBu.append(CHAR_2);
            }
            stBu.append(CHAR_1).append("\n");
            String headAndTail = stBu.toString();
            // line 2
            stBu.append(CHAR_1);
            String appNamePrompt = "Application Started.";
            extracted(stBu, appNamePrompt);
            // line 3
            stBu.append(CHAR_1);
            String appAddressPrompt = "Project address is: http://" + host + ":" + port;
            extracted(stBu, appAddressPrompt);
            //
            stBu.append(headAndTail);
            log.info("\n" + stBu);
        };
    }

}
