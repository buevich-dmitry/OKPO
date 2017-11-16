package by.bsuir.buevich.validation.impl;

import by.bsuir.buevich.jaxb.Characteristic;
import by.bsuir.buevich.jaxb.Metric;
import by.bsuir.buevich.jaxb.SubCharacteristic;
import by.bsuir.buevich.validation.MetricValidator;
import by.bsuir.buevich.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class MetricValidatorImpl implements MetricValidator {

    @Override
    public void validateMetric(Metric metric) throws ValidationException {
        if (metric.getMaximalValue() != null) {
            if (metric.getReferenceValue() != null) {
                throw new ValidationException(generateErrorMessage(metric,
                        "Метрика может содержать ТОЛЬКО ОДИН из параметров <reference-value>, <maximal-value>"));
            } else if  (metric.getValue() > metric.getMaximalValue()) {
                throw new ValidationException((generateErrorMessage(metric,
                        "Значение параметра <value> должно быть не больше значения параметра <maximal-value>")));
            }
        } else if (metric.getReferenceValue() != null) {
            if (metric.getValue() > metric.getReferenceValue()) {
                throw new ValidationException((generateErrorMessage(metric,
                        "Значение параметра <value> должно быть не больше значения параметра <reference-value>")));
            }
        } else {
            throw new ValidationException(generateErrorMessage(metric,
                    "Mетрика должна содержать один из параметров: <reference-value> или <maximal-value>"));
        }
    }

    private String generateErrorMessage(Metric metric, String causeMessage) {
        SubCharacteristic subCharacteristic = metric.getSubCharacteristic();
        Characteristic characteristic = subCharacteristic.getCharacteristic();
        return "Характеристика: " + characteristic.getName() + "\n" +
                "Под-характеристика: " + subCharacteristic.getName() + "\n" +
                causeMessage;
    }
}
