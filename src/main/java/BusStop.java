import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * Created by joel on 3/18/15.
 */
public class BusStop {

  private String roadName;
  private String qualifier;
  private String id;  // bus stop number
  private double[] gps;
  private String[] buses;

  public BusStop() {

  }

  public BusStop(String roadName, String qualifier, String id, double[] gps, String[] buses) {
    this.roadName = roadName;
    this.qualifier = qualifier;
    this.id = id;
    this.gps = gps;
    this.buses = buses;
  }

  @Override
  public String toString() {
    String output = roadName + "-." +
            qualifier +
            "(B" + id + ")" +
            getGpsFormatted() +
            getBusesFormatted();

    return output;
  }


  public String getBusesFormatted() {
    return Arrays.toString(buses);
  }


  public String getGpsFormatted() {
    DecimalFormat df = new DecimalFormat();
    df.setMaximumFractionDigits(1);
    df.setMinimumFractionDigits(1);
    return "("
            + df.format(gps[0]) + ","
            + df.format(gps[1]) + ","
            + df.format(gps[2])
            + ")";
  }


  public double[] getGps() {
    return gps;
  }

  public void setGps(double[] gps) {
    this.gps = gps;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getQualifier() {
    return qualifier;
  }

  public void setQualifier(String qualifier) {
    this.qualifier = qualifier;
  }

  public String getRoadName() {
    return roadName;
  }

  public void setRoadName(String roadName) {
    this.roadName = roadName;
  }

  public String[] getBuses() {
    return buses;
  }

  public void setBuses(String[] buses) {
    this.buses = buses;
  }


}
