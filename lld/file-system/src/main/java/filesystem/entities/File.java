package filesystem.entities;

public class File extends FileSystemEntry {
    private String content;
    public File(String name, Folder parent) {
        super(name, parent);
        this.content = "";
    }

    @Override
    public boolean isFolder() {
        return false;
    }

    public void addContent(String content){
        this.content = this.content + content;
    }

    public void removeContent(){
        this.content = "";
    }

    public void showContent(){
        System.out.println(this.content);
    }
}
