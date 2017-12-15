package ru.sbt.mipt.oop;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class SaverXML {

    private final SmartHome smartHome;

    public SaverXML(SmartHome smartHome)  {
        this.smartHome = smartHome;
    }

    public void save()
        throws ParserConfigurationException, TransformerException, FileNotFoundException {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.newDocument();
        Element smartHomeXML = document.createElement("SmartHome");
        for (Room room: this.smartHome.getRooms()) {
            Element roomXML = document.createElement("Room");
            for (Light light: room.getLights()) {
                Element lightXML = document.createElement("Light");
                Element id = document.createElement("id");
                id.setTextContent(light.getId());
                Element isOn = document.createElement("isOn");
                isOn.setTextContent(String.valueOf(light.isOn()));
                lightXML.appendChild(id);
                lightXML.appendChild(isOn);
                roomXML.appendChild(lightXML);
            }
            for (Door door: room.getDoors()) {
                Element doorXML = document.createElement("Door");
                Element id = document.createElement("id");
                id.setTextContent(door.getId());
                Element isOpen = document.createElement("isOpen");
                isOpen.setTextContent(Boolean.toString(door.isOpen()));
                doorXML.appendChild(id);
                doorXML.appendChild(isOpen);
                roomXML.appendChild(doorXML);
            }
            if (room.getAlarmSystem() != null) {
                Element alarmSystemXML = document.createElement("AlarmSystem");
                Element id = document.createElement("id");
                id.setTextContent(room.getAlarmSystem().getId());
                Element state = document.createElement("state");
                state.setTextContent(String.valueOf(room.getAlarmSystem().getState()));
                alarmSystemXML.appendChild(id);
                alarmSystemXML.appendChild(state);
                roomXML.appendChild(alarmSystemXML);
            }
            smartHomeXML.appendChild(roomXML);
        }
        Transformer tr = TransformerFactory.newInstance().newTransformer();
        DOMSource source = new DOMSource(smartHomeXML);
        FileOutputStream fos = new FileOutputStream("smart-home.xml");
        StreamResult result = new StreamResult(fos);
        tr.transform(source, result);
    }
}
