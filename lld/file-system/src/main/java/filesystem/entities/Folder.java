package filesystem.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Folder extends FileSystemEntry{
    private final Map<String , FileSystemEntry> childs;
    public Folder(String name, Folder parent) {
        if(!"/".equals(name) && Objects.isNull(parent)){
            throw new RuntimeException("Parent should not be null");
        }

        super(name, parent);
        this.childs = new HashMap<>();
    }

    @Override
    public boolean isFolder() {
        return true;
    }

    public void listChilds(){
        System.out.println("--listing--");
        for(String name : childs.keySet())
            System.out.println(name);
    }

    public void addChilds(FileSystemEntry child){
        System.out.println("--adding--"+child.getName());
        if(childs.containsKey(child.getName())) throw new RuntimeException("Already present");
        childs.put(child.getName(),child);
    }

    public FileSystemEntry getChild(String name){
        System.out.println("--getting--"+name);
        if(!childs.containsKey(name)) throw new RuntimeException("Not present present");
        return childs.get(name);
    }

    public void removeChilds(String name){
        System.out.println("--removing--"+name);
        if(!childs.containsKey(name)) throw new RuntimeException("Not present");
        childs.remove(name);
    }

}
