public interface Service {
  // the human-readable name of the service
  String getName();

  // UniqueID of the particular service
  int getId();

  // The workflow method that defines what this service does
  void execute();
}
