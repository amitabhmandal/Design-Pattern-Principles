package design.pattern.behavorial.nullobject;

public class NullStorageService extends StorageService {

    /* (non-Javadoc)
     * @see design.pattern.behavorial.nullobject.StorageService#save(design.pattern.behavorial.nullobject.Report)
     */
    @Override
    public void save(Report report) {
        System.out.println("Null object save method called: Doing nothing");
    }

}
