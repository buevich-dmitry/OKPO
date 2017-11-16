package by.bsuir.buevich.executor;

import by.bsuir.buevich.calculator.QualityCalculator;
import by.bsuir.buevich.jaxb.QualityModel;
import by.bsuir.buevich.jaxb.provider.QualityModelProvider;
import by.bsuir.buevich.messenger.Messenger;
import by.bsuir.buevich.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

@Component
public class MainExecutor {

    private final QualityModelProvider qualityModelProvider;
    private final QualityCalculator qualityCalculator;

    @Autowired
    public MainExecutor(QualityModelProvider qualityModelProvider, QualityCalculator qualityCalculator) {
        this.qualityModelProvider = qualityModelProvider;
        this.qualityCalculator = qualityCalculator;
    }

    public void run(String fileName) {
        try {
            QualityModel qualityModel = qualityModelProvider.getQualityModel(fileName);
            double result = qualityCalculator.calculateQuality(qualityModel);
            Messenger.showInfoMessage(String.format("Интегральная оценка качество системы: %.2f", result));
        } catch (FileNotFoundException | JAXBException e) {
            e.printStackTrace();
            Messenger.showErrorMessage("Предосталенный вами документ не соответствует формату. Формат документа описан в schema.xsd");
        } catch (ValidationException e) {
            Messenger.showErrorMessage("Ошибка валидации.\n" + e.getLocalizedMessage());
        }
    }

}
