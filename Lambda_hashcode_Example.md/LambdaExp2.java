```java
package org.mthree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class LambdaExp2 {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people = createList(people);

        List<Person> over30 = people.stream()
                .filter(p -> p.getAge() > 30)
                .collect(Collectors.toList());

        List<Person> under30 = people.stream()
                .filter(p -> p.getAge() < 30)
                .collect(Collectors.toList());

        Double averageAge = people
                .stream()
                .mapToInt(p -> p.getAge())
                .average()
                .orElse(0.0);

        System.out.println(over30);
        System.out.println(under30);
        System.out.println(String.format("%.2f", averageAge));
    }

    public static List<Person> createList(List<Person> people) {
        Person p = new Person();
        p.setfName("David");
        p.setAge(45);
        people.add(p);

        Person p2 = new Person();
        p2.setfName("Jane");
        p2.setAge(24);
        people.add(p2);

        Person p3 = new Person();
        p3.setfName("Christophe");
        p3.setAge(22);
        people.add(p3);

        Person p4 = new Person();
        p4.setfName("Farrah");
        p4.setAge(28);
        people.add(p4);

        Person p5 = new Person();
        p5.setfName("Kate");
        p5.setAge(18);
        people.add(p5);

        Person p6 = new Person();
        p6.setfName("Farshad");
        p6.setAge(37);
        people.add(p6);

        Person p7 = new Person();
        p7.setfName("Somya");
        p7.setAge(33);
        people.add(p7);

        return people;
    }
}
```