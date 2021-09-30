package general_classes;




import model.repository.CityReportRepositortyimpl;
import model.repository.SupporterRepository;
import model.repository.SupporterRepositoryImpl;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import static java.util.stream.Collectors.toMap;

public class CityReport implements Serializable {
    private String name;
    private LocalDate date;
    private int size;
    HashMap<String, Integer> Rates_by_cities = new HashMap<String, Integer>();

    @Override
    public String toString() {
        return "CityReport: " +
                "name='" + name + '\'' +
                ", date=" + date+ "}";
    }

    public CityReport() {
        this.name = "report of " + LocalDate.now();;
        this.date = LocalDate.now();
    }

    public LocalDate getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Integer> getRates_by_cities() {
        return Rates_by_cities;
    }


    public void show_report() throws Exception {
        create_Report();
        Rates_by_cities = sortByValue(Rates_by_cities); //descending order
        Map.Entry<String, Integer> entry = Rates_by_cities.entrySet().iterator().next();
        String key = entry.getKey();
        int value = entry.getValue();
        System.out.println("Total supporters: " + size);
        System.out.println("The  city with most supporters is " + key + " number of supporters = " + value);
        for (Map.Entry<String, Integer> en : Rates_by_cities.entrySet()) {
            if (en.getKey() == key) {
                continue;
            }
            System.out.println("City = " + en.getKey() +
                    ", number of supporters in the city = " + en.getValue());
        }


    }

    public void create_Report() throws Exception {
        SupporterRepository supporters_list = SupporterRepositoryImpl.getInstance();
        Set<Supporter_details> supporters = supporters_list.showallsupporters();
        size = supporters.size();
        for (Supporter_details supporter1 : supporters) {
            String city = supporter1.getSupporter_city();
            if (!Rates_by_cities.containsKey(city)) {
                Set<Supporter_details> city1 = supporters_list.findbycity(city);
                int howmuchpeople = city1.size();
                Rates_by_cities.put(city, howmuchpeople);
            }
        }
        Rates_by_cities = sortByValue(Rates_by_cities); //descending order
        CityReportRepositortyimpl reports = CityReportRepositortyimpl.getInstance();
        reports.add(this);
    }

    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
       /* LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
//Use Comparator.reverseOrder() for reverse ordering
        hm.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
        return hm; */

       Map<String, Integer> sortedByValueDesc = hm
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer> comparingByValue().reversed())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
                        LinkedHashMap::new));
        return (HashMap<String, Integer>) sortedByValueDesc;
    }
}
