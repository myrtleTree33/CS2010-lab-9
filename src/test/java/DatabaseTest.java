import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DatabaseTest {

  private Database db;
  private BusStop a,b;

  @Before
  public void setUp() throws Exception {
    db = new Database();

    a = new BusStop("Adam Road"
            , "Bef SICC"
            , "41141"
            , new double[]{0, 0, 0}
            , new String[]{"95B", "2"});

    b = new BusStop("Adam Road"
            , "Opp SICC"
            , "41149"
            , new double[]{0.5, 0, 0}
            , new String[]{"95A", "1"});

    db.insert(a);
    db.insert(b);

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testInsert() throws Exception {

  }

  @Test
  public void testGetRoadName() throws Exception {
    System.out.print("Get Road Name: ");
    System.out.println(db.getRoadName(a.getId()));
  }

  @Test
  public void testGetQualifier() throws Exception {
    System.out.print("Get Qualifier: ");
    System.out.println(db.getQualifier(a.getId()));
  }

  @Test
  public void testGetBusStop() throws Exception {
    System.out.print("Get Bus Stop: ");
    System.out.println(db.getBusStop(a.getId()));
  }

  @Test
  public void testGetGPS() throws Exception {
    System.out.print("Get GPS: ");
    System.out.println(db.getGPS(a.getId()));
  }

  @Test
  public void testGetBusStopAtThisStation() throws Exception {
    System.out.print("Get Buses: ");
    System.out.println(db.getBusStopAtThisStation(a.getId()));
  }

  @Test
  public void testGetDistance() throws Exception {
    double dist = db.getDistance(a.getId(),b.getId());
    System.out.print("Get Distance: ");
    System.out.println(dist);
    assertEquals(0.5, dist, 0.0000001);
  }
}