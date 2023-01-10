import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InitContext {

  /**
   * Perform the lookup based on the service name.
   * The return object will need to be cast into a {@link Service}
   *
   * @param serviceName: a name
   * @return : an {@link Service}
   */
  public ServiceImpl lookup(String serviceName) {
    if ("serviceA".equals(serviceName)) {
      log.info("Looking up service A and creating new service for A");
      return new ServiceImpl("serviceA");
    } else if ("serviceB".equals(serviceName)) {
      log.info("Looking up service B and creating new service for B");
      return new ServiceImpl("serviceB");
    } else {
      return null;
    }
  }
}
