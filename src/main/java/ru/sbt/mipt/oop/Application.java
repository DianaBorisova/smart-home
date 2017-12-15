package ru.sbt.mipt.oop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class  Application {

    public static void main(String... args)
        throws IOException, TransformerException, ParserConfigurationException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
        SensorEventObserver sensorEventObserver = (SensorEventObserver) ctx.getBean("sensorEventObserver");
        sensorEventObserver.observe();
        SaverXML saverXML = (SaverXML) ctx.getBean("saverXML");
        saverXML.save();
    }

    static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }

}
