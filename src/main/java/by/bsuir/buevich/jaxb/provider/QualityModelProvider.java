package by.bsuir.buevich.jaxb.provider;

import by.bsuir.buevich.jaxb.QualityModel;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface QualityModelProvider {
    QualityModel getQualityModel(String fileName) throws JAXBException, FileNotFoundException;
}
