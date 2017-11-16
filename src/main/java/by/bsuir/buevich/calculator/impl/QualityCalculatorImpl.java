package by.bsuir.buevich.calculator.impl;

import by.bsuir.buevich.calculator.QualityCalculator;
import by.bsuir.buevich.jaxb.Metric;
import by.bsuir.buevich.jaxb.QualityModel;
import by.bsuir.buevich.jaxb.SubCharacteristic;
import by.bsuir.buevich.validation.MetricValidator;
import by.bsuir.buevich.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class QualityCalculatorImpl implements QualityCalculator {

    private final MetricValidator metricValidator;

    @Autowired
    public QualityCalculatorImpl(MetricValidator metricValidator) {
        this.metricValidator = metricValidator;
    }

    public double calculateQuality(QualityModel qualityModel) throws ValidationException {
        double importanceSum = calculateImportanceSum(qualityModel);
        double metricSum = calculateMetricSum(qualityModel);
        return metricSum / importanceSum;
    }

    private double calculateImportanceSum(QualityModel qualityModel) {
        return getMetricStream(qualityModel)
                .mapToDouble(Metric::getImportanceFactor)
                .sum();
    }

    private double calculateMetricSum(QualityModel qualityModel) {
        return getMetricStream(qualityModel)
                .mapToDouble(this::calculateMetricQuality)
                .sum();
    }

    private Stream<Metric> getMetricStream(QualityModel qualityModel) {
        return qualityModel.getCharacteristic().stream()
                .flatMap(characteristic -> characteristic.getSubCharacteristic().stream())
                .map(SubCharacteristic::getMetric);
    }

    private double calculateMetricQuality(Metric metric) throws ValidationException {
        metricValidator.validateMetric(metric);
        if (metric.getReferenceValue() != null) {
            return metric.getImportanceFactor() * metric.getValue() / metric.getReferenceValue();
        } else {
            return metric.getImportanceFactor() * (1 - metric.getValue() / metric.getMaximalValue());
        }
    }

}
