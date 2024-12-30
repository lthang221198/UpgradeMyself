package StreamAPI;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIPractice {


    public static void main(String[] args) {
        List<String> names = Arrays.asList("Tien", "Thang", "Anh");
        Stream<String> stream = names.stream();
        filter(names);
        map(names);
    }

    public static List filter(List<String> names) {
        List filteredList = names.stream().filter(name -> name.startsWith("T")).toList();
        System.out.println(filteredList);
        return filteredList;
    }

    public static List map(List<String> names) {
        List<Integer> namesLengths = names.stream().map(String::length).toList();
        System.out.println(namesLengths);
        return namesLengths;
    }

    public List sorted(Stream stream) {
        return null;
    }

    public List reduce(Stream stream) {
        return null;
    }

}
