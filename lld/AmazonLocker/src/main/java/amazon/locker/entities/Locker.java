package amazon.locker.entities;


import amazon.locker.enums.Size;
import amazon.locker.enums.Status;

public class Locker {
    private final String id;
    private final Size size;
    private Status status;

    public Locker(String id, Size size , Status status ) {
        this.id = id;
        this.size = size;
        this.status = Status.AVAILABLE;
    }

    public String getId() {
        return id;
    }

    public Size getSize() {
        return size;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
