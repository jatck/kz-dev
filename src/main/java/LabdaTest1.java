import model.Person;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LabdaTest1 {

    public static void main(String[] args) {

        List<Person> lista = List.of(new Person("jacek", Person.Sex.MALE,"zaak.jek@gmail.com",45),
                                     new Person("janek", Person.Sex.MALE,"isk.janek@gmail.com",25),
                                     new Person("baska", Person.Sex.FEMALE,"wisa.baska@gmail.com",18)
                                    );
        Predicate<Person> predicate = p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
        Function<Person,String> funkcja=p -> p.getEmailAddress();
        Consumer<String> consument=email -> System.out.println(email);


        processPersonsWithFunction(lista,predicate,funkcja,consument);

    }


    public static void processPersonsWithFunction(
            List<Person> lista,
            Predicate<Person> pred,
            Function<Person, String> funct,
            Consumer<String> cons) {
        for (Person p : lista) {
            if (pred.test(p)) {
                String data = funct.apply(p);
                cons.accept(data);
            }
        }
    }


}
