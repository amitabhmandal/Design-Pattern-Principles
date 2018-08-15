package design.pattern.behavorial.iterator;

public enum ThemeColor {

    RED, ORANGE, BLACK, WHITE;

    public static Iterator<ThemeColor> getIterator() {
        return new ThemeColorIterator();
    }

    private static class ThemeColorIterator implements Iterator<ThemeColor> {

        private int position;

        @Override
        public boolean hasNext() {
            return position < ThemeColor.values().length;
        }

        @Override
        public ThemeColor next() {
            // TODO Auto-generated method stub
            return ThemeColor.values()[position++];
        }

    }
}
