import lombok.var;

import java.util.Objects;

public class ServiceLocator {
  private static final ServiceCache serviceCache = new ServiceCache();

  private ServiceLocator(){}

  /**
   * Fetch the service with the name param from the cache first,
   * if no service is found, lookup the service from the {@link InitContext}
   * and then add the newly created service into the cache map
   * for future request
   *
   * @param serviceName: astring
   * @return {@link Service}
   */
  public static Service getService(String serviceName) {
    var serviceObj = serviceCache.getService(serviceName);

    if (Objects.isNull(serviceObj)) {
      /*
       * If we are unable to retrieve anything from cache, then lookup the service
       * and add it in the cache map
       */
      var ctx = new InitContext();
      serviceObj = ctx.lookup(serviceName);
      if (Objects.nonNull(serviceObj)) { // Only cache a service if it actually exists
        serviceCache.addService(serviceObj);
      }
    }
    return serviceObj;
  }
}
