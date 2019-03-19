package przyklady;

import model.Person;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;


public class Calculator {

    private Runnable runnable;

    interface IntegerMath {
        int operation(int a, int b);
    }

    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }

    public static void main(String... args) {

        Calculator myApp = new Calculator();
        Person osoba = new Person("jacek", Person.Sex.MALE,"jacek@gmail.com",45);
        List<Person> znajomi = List.of(new Person("jacek", Person.Sex.MALE,"jacek@gmail.com",45),
                new Person("marek", Person.Sex.MALE,"marek@gmail.com",5),
                new Person("darek", Person.Sex.MALE,"darek@gmail.com",4),
                new Person("ela", Person.Sex.MALE,"ela@gmail.com",35),
                new Person("iza", Person.Sex.MALE,"iza@gmail.com",25));

        IntegerMath addition = (a, b) -> a + b;
        IntegerMath subtraction = (a, b) -> a - b;
        System.out.println("40 + 2 = " +
                myApp.operateBinary(40, 2, addition));
        System.out.println("20 - 10 = " +
                myApp.operateBinary(20, 10, subtraction));
        //String::compareToIgnoreCase
        String t = " J a c e k ";
        Collection<String> lista = List.of("a","b","c");
        Collection<String> lista1= List.of("1","2","3");
        Consumer<Person> pokazNazwiska = (x) -> System.out.println(x.getName());
        Consumer<Person> pokazWiek = (x) -> System.out.println(x.getAge());

        znajomi.forEach(pokazNazwiska.andThen(pokazWiek));




        //Collection <String> tran =
         //transferElements(lista,lista1);

        Set<String> rosterSet = transferElements(lista, HashSet<String>::new);
        rosterSet.forEach(System.out::println);





    }

    public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>>
    DEST transferElements(
            SOURCE sourceCollection,
            Supplier<DEST> collectionFactory) {

        DEST result = collectionFactory.get();
        for (T t : sourceCollection) {
            result.add(t);
        }
        return result;
    }
}