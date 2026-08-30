package filesystem.entities;

public abstract class FileSystemEntry {
    private String name;
    private Folder parent;

    public FileSystemEntry(String name  , Folder parent){
        this.name = name;
        this.parent = parent;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Folder getParent(){
        return this.parent;
    }

    public void getParent(Folder folder){
        this.parent = folder;
    }

    public abstract boolean isFolder();

}
