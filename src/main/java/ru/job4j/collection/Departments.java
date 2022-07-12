package ru.job4j.collection;

import java.util.*;

public class Departments {

    /*
"K1/SK1"
"K1/SK2"
"K1/SK1/SSK1"
"K1/SK1/SSK2"
"K2"
"K2/SK1/SSK1"
"K2/SK1/SSK2"
    разработать класс, который будет добавлять пропущенные
подразделения, а также производить сортировку
подразделений.
     */

    /*
    добавляет не существующие подразделения
    должен сформировать список строк, при этом требуется учесть все возможно отсутствующие коды
подразделений;
     */
    public static List<String> fillGaps(List<String> deps) {
        List<String> rsl = new ArrayList<>(); // создаём временную коллекцию с уникальными значениями
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (String i : deps) {                      // массив состоит из строк
            String[] j = i.split("/");          // разбиваем каждую строку по очреди
            String el = "";
            for (String h : j) {
                set.add(el + h);
                el += h + "/";
            }
        }
        rsl.addAll(set);
        return rsl;
    }

    /*
    метод sortAsc() должен просто отсортировать по возрастанию список строк, который он принимает на вход, вызывать
дополнительно fillGaps() в этом методе не нужно;
     */
    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    /*
    метод sortDesc() должен просто отсортировать в соответствии с компаратором DepDescComp список строк, который он
принимает на вход, вызывать дополнительно fillGaps() в этом методе не нужно;
     */
    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }

}
