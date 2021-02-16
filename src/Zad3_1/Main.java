/**
 *
 *  @author Sroczyński Mikołaj S18840
 *
 */

package Zad3_1;


import java.util.*;

public class Main {

  static List<String> getPricesInPLN(List<String> destinations, double xrate) {
    return ListCreator.collectFrom(destinations)
                       .when(e-> {
                         if (e.startsWith("WAW"))
                           return true;
                         else return false;
                       })

                       .mapEvery(e->{
                               String[] tab = ((String) e).split(" ");
                               int price=(int)(xrate*Integer.parseInt(tab[2]));
                               String temp = Integer.toString(price);
                               return "to "+tab[1]+" - price in PLN: "+" "+temp;

                       });
  }

  public static void main(String[] args) {
    // Lista destynacji: port_wylotu port_przylotu cena_EUR 
    List<String> dest = Arrays.asList(
      "bleble bleble 2000",
      "WAW HAV 1200",
      "xxx yyy 789",
      "WAW DPS 2000",
      "WAW HKT 1000"
    );
    double ratePLNvsEUR = 4.30;
    List<String> result = getPricesInPLN(dest, ratePLNvsEUR);
    for (String r : result) System.out.println(r);
  }
}
