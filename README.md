# Программа для подсчёта интегральной оценки качества системы

Программа принимает xml документ определённого формата (описанного в схеме /bin/schema.xsd), в котором содержатся все характеристики сисетмы, и на его основе высчитывает интегральную оценку качества.

## Пример докумета
```
<quality-model xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="schema.xsd">
    <characteristic>
        <name>Функциональная пригодность</name>
        <sub-characteristic>
            <name>Функциональная полнота</name>
            <metric>
                <value>10</value>
                <reference-value>15</reference-value>
                <importance-factor>2</importance-factor>
            </metric>
        </sub-characteristic>
        <!-- other sub-characteristics -->
    </characteristic>
    <!-- other characteristics -->
</quality-model>
```
Секция <characteristic> содержит название <name> и одну или несколько секций подхарактеристик <sub-characteristic>.
Секция <sub-characteristic> содержит название <name> и секцию <metric>.
Секция <metric> содержит:
 * <value> - значение метрики, полученное при тестировании
 * <importance-factor> - индекс важности метрики (по умолчанию равен 1)
 * <reference-value> - эталонное значение. При указании данного параметра метрика будет рассчитывать по формуле: 
 
 ```value / referenceValue```
 * <maximal-value> - максимально допустимое значение. При указании данного параметра метрика будет рассчитывать по формуле: 
 
 ```1 - value / maximalValue```

Примечание: программа не даст ввести одновременно <reference-value> и <maximal-value>, а также ввести некорректное значение для value (например, большее чем reference-value). В этих случаях программа выдаст ошибку с указанием места в документе, где была допущена ошибка.

## Запуск программы

В папке /bin находится исполняемый jar архив с программой. Для его запуска необходимо чтобы на компьютере была установлена java.
Также в папке /bin находится документ quality-model.xml c характеристиками, описанными в отчёте.

Для запуска программы, в командной строке зайдите в папку /bin и выполните
```
java -jar exe.jar quality-model.xml
```

В случае отсутствия ошибок во входном файле программа выдаст интегральную оценку качества системы (число от 0 до 1).
