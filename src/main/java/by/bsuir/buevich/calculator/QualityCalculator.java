package by.bsuir.buevich.calculator;

import by.bsuir.buevich.jaxb.QualityModel;
import by.bsuir.buevich.validation.ValidationException;

public interface QualityCalculator {
    double calculateQuality(QualityModel qualityModel) throws ValidationException;
}
