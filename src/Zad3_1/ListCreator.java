package Zad3_1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListCreator <T,V> { // Uwaga: klasa musi być sparametrtyzowana
    List<T> list;
    public ListCreator(List<T> listC){
        this.list=listC;
    }

    public static <T,V> ListCreator <T,V> collectFrom(List<T> listC){
        return  new ListCreator<>(listC);

    }


    public ListCreator<T, V> when(Predicate<T> predicate) {
        List<T> warunki;
        warunki = new ArrayList<>();
        for (T t:list
        ) {if(predicate.test(t))
            warunki.add(t);


        }
        //return new ListCreator<T>(warunki);
        //return new ListCreator<V>(warunki);
        return new ListCreator<T,V>(warunki);

    };

    public <V> List <V> mapEvery (Function<T,V> warunek){
        List <V> warunki;
        warunki= new ArrayList<>();
        for (T t:list
        ) {warunki.add(warunek.apply(t));
        }
        return warunki;
    }
}
