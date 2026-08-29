package amazon.locker.entities;

import amazon.locker.enums.Size;

public class Parcel {
    private final String id;
    private final Size size;

    public Parcel(String id, Size size) {
        this.id = id;
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public Size getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "id='" + id + '\'' +
                ", size=" + size +
                '}';
    }
}
