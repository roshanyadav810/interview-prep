package filesystem;

import filesystem.entities.File;
import filesystem.entities.Folder;

public class FileSystem {
    private final Folder root;

    public FileSystem() {
        this.root = new Folder("/",null);
    }

    public Folder traverse(String path){

        System.out.println("path : "+path);

        String[] keys = path.split("/");
        System.out.println("keys len : "+keys.length);
        Folder current = this.root;
        for(int i = 0; i < keys.length; i++){
            System.out.println("key : "+keys[i]);
            if(!current.isFolder()) throw new RuntimeException("invalid path");
            current = (Folder) current.getChild(keys[i]);
        }
        return current;

    }


    public void createFolder(String path , String name){
        Folder current = traverse(path);
        Folder newFolder = new Folder(name,current);
        current.addChilds(newFolder);
    }

    public void deleteFolder(String path , String name){
        Folder current = traverse(path);
        current.removeChilds(name);

    }

    public void createFile(String path , String name){
        Folder current = traverse(path);
        File file = new File(name,current);
        current.addChilds(file);
    }

    public void deleteFile(String path , String name){
        Folder current = traverse(path);
        current.removeChilds(name);
    }

    public void getContent(String path , String name){
        Folder current = traverse(path);

        if(current.getChild(name).isFolder()) throw new RuntimeException("this is not file");

        File file = (File) current.getChild(name);
        file.showContent();
    }

    public void list(String path){
        Folder current = traverse(path);
        current.listChilds();
    }


}
