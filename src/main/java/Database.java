import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Created by joel on 3/18/15.
 */
public class Database {

  Map<String, BusStop> table;

  public Database() {
    table = new HashMap<String, BusStop>();
  }

  public void insert(BusStop target) {
    table.put(target.getId(), target);
  }


  /**
   * Query commands *
   */

  /**
   * Retrieves elem BusStop by ID.  Else return null.
   * @param id
   * @return
   */
  private BusStop getEntry(String id) {
    if (table.containsKey(id)) {
      return table.get(id);
    }
    return null;
  }

  public String getRoadName(String id) {
    BusStop elem = getEntry(id);
    if (elem == null) {
      return "Invalid Entry.";
    }
    return elem.getRoadName();
  }

  public String getQualifier(String id) {
    BusStop elem = getEntry(id);
    if (elem == null) {
      return "Invalid Entry.";
    }
    return elem.getQualifier();
  }

  public String getBusStop(String id) {
    BusStop elem = getEntry(id);
    if (elem == null) {
      return "Invalid Entry.";
    }
    return elem.toString();
  }

  public String getGPS(String id) {
    BusStop elem = getEntry(id);
    if (elem == null) {
      return "Invalid Entry.";
    }
    return elem.getGpsFormatted();
  }

  public String getBusStopAtThisStation(String id) {
    BusStop elem = getEntry(id);
    if (elem == null) {
      return "Invalid Entry.";
    }
    return elem.getBusesFormatted();
  }

  public double getDistance(String idK, String idM) {
    BusStop k = getEntry(idK), m = getEntry(idM);
    if ((k == null) || (m == null)) {
      return -1;
    }
    double[] gpsK = k.getGps();
    double[] gpsM = m.getGps();
    double distance = sqrt(pow(gpsK[0] - gpsM[0], 2)
            + pow(gpsK[1] - gpsM[1], 2)
            + pow(gpsK[2] - gpsM[2], 2));
    return distance;
  }

  public void display() {
    System.out.println("-- Database Dump --");
    for (Map.Entry<String, BusStop> elem : table.entrySet()) {
      System.out.println(elem.getValue());
    }
  }

}
