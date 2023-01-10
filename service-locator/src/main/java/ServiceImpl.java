import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServiceImpl implements Service{

  private final String serviceName;
  private final int id;

  // Constructor
  public ServiceImpl(String serviceName) {
    this.serviceName = serviceName;
    this.id = (int) Math.floor(Math.random() * 1000) + 1;
  }

  @Override
  public String getName() {
    return this.serviceName;
  }

  @Override
  public int getId() {
    return this.id;
  }

  @Override
  public void execute() {
    log.info("Service {} is now executing with id {}", getName(), getId());
  }

  public static void main(String[] args) {
    ServiceImpl a = new ServiceImpl("test");
    a.execute();
  }
}
