import lombok.var;

public class App {
  public static final String JNDI_SERVICE_A = "serviceA";
  public static final String JNDI_SERVICE_B = "serviceB";

  // Program entry point
  public static void main(String[] args) {
    var service = ServiceLocator.getService(JNDI_SERVICE_A);
    service.execute();
    service = ServiceLocator.getService(JNDI_SERVICE_B);
    service.execute();
    service = ServiceLocator.getService(JNDI_SERVICE_A);
    service.execute();
    service = ServiceLocator.getService(JNDI_SERVICE_A);
    service.execute();
  }
}
