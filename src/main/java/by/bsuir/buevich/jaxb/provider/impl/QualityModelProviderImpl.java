package by.bsuir.buevich.jaxb.provider.impl;

import by.bsuir.buevich.jaxb.QualityModel;
import by.bsuir.buevich.jaxb.listener.UnmarshallerListener;
import by.bsuir.buevich.jaxb.provider.QualityModelProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Component
public class QualityModelProviderImpl implements QualityModelProvider {

    private static final String JAXB_PACKAGE = "by.bsuir.buevich.jaxb";

    private final UnmarshallerListener unmarshallerListener;

    @Autowired
    public QualityModelProviderImpl(UnmarshallerListener unmarshallerListener) {
        this.unmarshallerListener = unmarshallerListener;
    }

    @Override
    public QualityModel getQualityModel(String fileName) throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(JAXB_PACKAGE);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        unmarshaller.setListener(unmarshallerListener);
        return (QualityModel) unmarshaller.unmarshal(new FileInputStream(fileName));
    }
}
