import lombok.extern.slf4j.Slf4j;
import lombok.var;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ServiceCache {
  private final Map<String, Service> serviceCache;

  public ServiceCache() {
    this.serviceCache = new HashMap<>();
  }

  /**
   * Get the service from cache. null if no service is found matching the name
   *
   * @param serviceName: a string
   * @return {@link Service}
   */
  public Service getService(String serviceName) {
    if (serviceCache.containsKey(serviceName)) {
      var cacheService = serviceCache.get(serviceName);
      var name = cacheService.getName();
      var id = cacheService.getId();
      log.info("(cache call) Fetched service {}({}) from cache ...!", name, id);
      return cacheService;
    } else {
      return null;
    }
  }

  /**
   * Adds the service into the cache map.
   *
   * @param newService: a {@link Service}
   */
  public void addService(Service newService) {
    serviceCache.put(newService.getName(), newService);
  }
}
