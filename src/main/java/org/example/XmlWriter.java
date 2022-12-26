package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlWriter {
    private static final Logger logger = Logger.getLogger(XmlWriter.class.getName());
    private XmlWriter() {}

    public static void xmlGenerator(AllInfo allInfo) {
        logger.log(Level.INFO, "generating xml file...");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(AllInfo.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            try {
                Files.createDirectory(Paths.get("xmlReqs"));
                logger.log(Level.INFO, "XML directory created successfully.");
            } catch (IOException e) {
                logger.log(Level.FINE, "XML directory already exists.");
            }
            File file = new File("xmlReqs/infoReq" + new Date().getTime() + ".xml");
            marshaller.marshal(allInfo, file);
        } catch (JAXBException e) {
            logger.log(Level.SEVERE, "XML was not created...", e);
        }
        logger.log(Level.INFO, "XML file created successfully.");
    }
}
