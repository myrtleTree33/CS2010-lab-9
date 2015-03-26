import static org.junit.Assert.*;

public class BusStopTest {

  private BusStop busStop;

  @org.junit.Before
  public void setUp() throws Exception {
    busStop = new BusStop("Adam Road"
            , "Bef SICC"
            , "41141"
            , new double[]{0, 0, 0}
            , new String[]{"95B", "2"});

  }

  @org.junit.After
  public void tearDown() throws Exception {

  }

  @org.junit.Test
  public void testToString() throws Exception {
    assertTrue("Adam Road-.Bef SICC(B41141)(0.0,0.0,0.0)[95B, 2]".equals(busStop.toString()));

  }

  @org.junit.Test
  public void testGetBusesFormatted() throws Exception {

  }

  @org.junit.Test
  public void testGetGpsFormatted() throws Exception {

  }

  @org.junit.Test
  public void testGetGps() throws Exception {

  }

  @org.junit.Test
  public void testSetGps() throws Exception {

  }

  @org.junit.Test
  public void testGetId() throws Exception {

  }

  @org.junit.Test
  public void testSetId() throws Exception {

  }

  @org.junit.Test
  public void testGetQualifier() throws Exception {

  }

  @org.junit.Test
  public void testSetQualifier() throws Exception {

  }

  @org.junit.Test
  public void testGetRoadName() throws Exception {

  }

  @org.junit.Test
  public void testSetRoadName() throws Exception {

  }

  @org.junit.Test
  public void testGetBuses() throws Exception {

  }

  @org.junit.Test
  public void testSetBuses() throws Exception {

  }

  @org.junit.Test
  public void testMain() throws Exception {

  }
}