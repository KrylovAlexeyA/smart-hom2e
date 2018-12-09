package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.SmartHomeLoading.FileSmartHomeLoader;
import ru.sbt.mipt.oop.SmartHomeLoading.SmartHomeLoader;
import org.springframework.context.annotation.Bean;
import ru.sbt.mipt.oop.remoteController.ControlPanel;
import ru.sbt.mipt.oop.remoteController.IRemoteController;
import ru.sbt.mipt.oop.remoteController.RemoteControllerRegistry;


public class AppConfig {
    @Bean
    SmartHomeLoader smartHomeLoader() {

        return new FileSmartHomeLoader();
    }

    @Bean
    HomeEventsObserver homeEventsObserver() {

        return new HomeEventsObserver(new RandomSensorEventProvider());
    }

    @Bean
    RemoteControllerRegistry remoteControlRegistry() {return new RemoteControllerRegistry();}

    @Bean
    IRemoteController controlPanel() {
        return  new ControlPanel();
    }
}


