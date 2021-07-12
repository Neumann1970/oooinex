package task2;

import java.util.*;

public class StationTask {

    private static List<Station> STATION_LIST = Arrays.asList(
            new Station("МОСКВА"),
            new Station("МОЖГА"),
            new Station("МОЗДОК"),
            new Station("САНКТ-ПЕТЕРБУРГ"),
            new Station("САМАРА"));

    private static HashMap<String, List<Station>> searchStationsMap = new HashMap<>();

    public static void main(String[] args) {
        StationTask task = new StationTask(STATION_LIST);
        System.out.println(task.getStationsByTwoFirstLetters("МО"));
        System.out.println(task.getStationsByTwoFirstLetters("СА"));
    }

    private StationTask(List<Station> stationList) {
        for (Station station : stationList){
            List<Station> groupByNameList = searchStationsMap.get(station.getName().substring(0,2));
            if(groupByNameList==null){
                groupByNameList = new ArrayList<>();
                groupByNameList.add(station);
                searchStationsMap.put(station.getName().substring(0,2),groupByNameList);
            }else {
                groupByNameList.add(station);
            }
        }
    }

    private Collection<Station> getStationsByTwoFirstLetters(String prefix) {
        return searchStationsMap.get(prefix);
    }

    private static class Station {

        private String name;

        public Station(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Station{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
