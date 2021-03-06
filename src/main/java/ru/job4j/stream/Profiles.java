package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }

   public static List<Address> collectSortWithoutDuplicate(List<Profile> profiles) {
       Comparator<Address> comp = new Comparator<Address>() {
           @Override
           public int compare(Address o1, Address o2) {
               return o1.getCity().compareTo(o2.getCity());
           }
       };
       return profiles.stream()
               .map(Profile::getAddress)
               .sorted(comp)
               .distinct()
               .collect(Collectors.toList());
   }

}
