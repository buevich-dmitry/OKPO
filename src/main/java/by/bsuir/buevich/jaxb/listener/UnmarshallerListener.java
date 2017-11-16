package by.bsuir.buevich.jaxb.listener;

import by.bsuir.buevich.jaxb.Characteristic;
import by.bsuir.buevich.jaxb.Metric;
import by.bsuir.buevich.jaxb.SubCharacteristic;
import org.springframework.stereotype.Component;

import javax.xml.bind.Unmarshaller;

@Component
public class UnmarshallerListener extends Unmarshaller.Listener {

    @Override
    public void afterUnmarshal(Object target, Object parent) {
        if (target.getClass() == Metric.class) {
            ((Metric)target).setSubCharacteristic((SubCharacteristic)parent);
        } else if (target.getClass() == SubCharacteristic.class) {
            ((SubCharacteristic)target).setCharacteristic((Characteristic)parent);
        }
    }
}
