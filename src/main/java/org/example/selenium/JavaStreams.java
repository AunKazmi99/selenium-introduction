package org.example.selenium;

import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreams {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();
        names.add("AunAbbasKazmi");
        names.add("Junaid");
        names.add("Ali");
        names.add("AliRaza");
        names.add("Wajahat");
        names.add("Uzair");
        names.add("Haider");
        names.forEach(System.out::println);
        int count = 0;
        for (String name : names)
        {
            if (name.startsWith("A")) count++;
        }
        System.out.println(count);

        long a = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(a);

        System.out.println(Stream.of("Aun", "Junaid", "Ali", "Wajahat", "Haider", "Uzair").filter(s -> s.startsWith("A")).count());

        //for (String name : names) if (name.startsWith("A")) System.out.println(name);
        //names.stream().filter(s->s.startsWith("A")).forEach(System.out::println);
        System.out.println("*******************************************************");
        names.stream().filter(s -> s.startsWith("A")).forEach(System.out::println);
        System.out.println("*******************************************************");
        names.stream().filter(s -> s.length() > 4).filter(s -> s.startsWith("A")).forEach(System.out::println);
        System.out.println("*******************************************************");
        names.stream().filter(s -> s.length() > 4).limit(1).forEach(System.out::println);
        System.out.println("*******************************************************");
        names.stream().filter(s -> s.length() > 4).sorted().limit(1).forEach(System.out::println);
        System.out.println("*******************************************************");
        names.stream().filter(s -> s.endsWith("i")).map(String::toUpperCase).forEach(System.out::println);
        System.out.println("*******************************************************");
        names.stream().filter(s -> s.length() > 4).filter(s -> s.startsWith("A")).sorted().map(String::toUpperCase)
                .forEach(System.out::println);
        System.out.println("*******************************************************");
        names.stream().filter(s -> s.length() > 4).filter(s -> s.startsWith("A")).sorted().limit(1).map(String::toUpperCase)
                .forEach(System.out::println);
        System.out.println("*******************************************************");

        List<String> listOfNames = Arrays.asList("Aun", "Junaid", "Ali", "Wajahat", "Haider", "Uzair");
        List<String> listOfNames2 = Arrays.asList("Zaid", "Adnan", "Abdullah", "Osama", "Usama", "Turab");

        Stream<String> newStream = Stream.concat(listOfNames.stream(), listOfNames2.stream());
        newStream.forEach(System.out::println);
        System.out.println("*******************************************************");
        Stream<String> newStream1 = Stream.concat(listOfNames.stream(), listOfNames2.stream());
        newStream1.sorted().forEach(System.out::println);
        System.out.println("*******************************************************");
        Stream<String> newStream2 = Stream.concat(listOfNames.stream(), listOfNames2.stream());
        newStream2.sorted().map(String::toUpperCase).forEach(System.out::println);
        Stream<String> newStream4 = Stream.concat(listOfNames.stream(), listOfNames2.stream());
        boolean flag = newStream4.anyMatch(s -> s.equalsIgnoreCase("Aun"));
        Assert.assertTrue(flag);
        System.out.println("*******************************************************");

        List<String> namesStaringWithA = Stream.of("Aun", "Junaid", "Ali", "Wajahat", "Haider", "Uzair").filter(s -> s.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(namesStaringWithA.get(0));

        List<Integer> listOfNumbers = Arrays.asList(3, 2, 2, 7, 5, 1, 9, 7);
        listOfNumbers.stream().distinct().sorted().forEach(System.out::println);
        System.out.println("*******************************************************");
        List<Integer> list = listOfNumbers.stream().distinct().sorted().toList();
        System.out.println(list.get(2));
        System.out.println("*******************************************************");
        int num = listOfNumbers.stream().distinct().sorted().toList().get(2);
        System.out.println(num);
        System.out.println("*******************************************************");

    }


}

