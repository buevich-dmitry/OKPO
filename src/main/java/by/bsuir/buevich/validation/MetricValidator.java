package by.bsuir.buevich.validation;

import by.bsuir.buevich.jaxb.Metric;

public interface MetricValidator {
    void validateMetric(Metric metric) throws ValidationException;
}
