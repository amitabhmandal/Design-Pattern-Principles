package design.pattern.behavorial.iterator;

public class ClientIterator {

    public static void main(String[] args) {

        Iterator<ThemeColor> iterator = ThemeColor.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}
