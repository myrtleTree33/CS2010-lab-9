import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by joel on 3/18/15.
 */
public class Terminal {

  private Scanner input;
  private Database db;

  public Terminal() {
  }

  private int getNumEntries() {
    int num = input.nextInt();
    input.nextLine(); // to flush input
    return num;
  }

  private void makeNewRecord() {
    BusStop station;
    String roadName, qualifier, id;
    double[] gps;
    String[] buses;

    roadName = getInputRoadName();
    qualifier = getInputQualifier();
    id = getInputId();
    gps = getInputGPS();
    buses = getInputBuses();
    station = new BusStop(roadName, qualifier, id, gps, buses);
    db.insert(station);
  }

  public String getInputRoadName() {
    System.out.println("Enter road name: ");
    return input.nextLine();
  }


  public String getInputQualifier() {
    System.out.println("Enter Qualifier: ");
    return input.nextLine();
  }


  public String getInputId() {
    System.out.println("Enter ID: ");
    return input.nextLine();
  }


  public double[] getInputGPS() {
    String[] arg = {};
    double[] result;

    while (arg.length != 3) {
      System.out.println("Enter GPS: ");
      arg = input.nextLine().split(" ");
    }

    result = new double[arg.length];
    for (int i = 0; i < arg.length; i++) {
      result[i] = Double.parseDouble(arg[i]);
    }

    return result;
  }


  public String[] getInputBuses() {
    String arg;
    System.out.println("Enter Buses: ");
    arg = input.nextLine();
    return arg.split(" ");
  }


  public void run() {
    db = new Database();
    input = new Scanner(System.in);
    generateDb();
    db.display();
    runQueryDaemon();
  }


  private void queryProcessor(Query q) {
    String result = null;
    String id = "";

    if (q.getArgs().length > 0) {
      id = q.getArgs()[0];
    }

    if (q.getOpr().equals("getRoadName")) {
      result = db.getRoadName(id);

    } else if (q.getOpr().equals("getQualifier")) {
      result = db.getQualifier(id);

    } else if (q.getOpr().equals("getBusStop")) {
      result = db.getBusStop(id);

    } else if (q.getOpr().equals("getGPS")) {
      result = db.getGPS(id);

    } else if (q.getOpr().equals("getBusStopAtThisStation")) {
      result = db.getBusStopAtThisStation(id);

    } else if (q.getOpr().equals("distance")) {
      if (q.getArgs().length != 2) {
        return;
      }
      String idK = q.getArgs()[0], idM = q.getArgs()[1];
      result = "" + db.getDistance(idK, idM);
    } else {
    }

    if (result != null) {
      System.out.println(result);
    }

  }


  private void runQueryDaemon() {
    Query q;
    while (true) {
      String raw = input.nextLine();
      q = new Query(raw);
      System.out.println(raw); // echo query
      queryProcessor(q); // process query
    }
  }


  public static void main(String[] args) {
    Terminal t = new Terminal();
    t.run();
  }


  private void generateDb() {
    int len = getNumEntries();
    for (int i = 0; i < len; i++) {
      System.out.println("-- New Station --");
      makeNewRecord();
    }
  }
}
