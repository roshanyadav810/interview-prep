## Problem
    Design a file system like linux which supports create , delete , ls and cat


## Entities
    1. FileSystem
        {
        - root Folder
        
        - createFolder(String path , name)
        - deleteFolder(String path)
        - createFile(String path , name)
        - deleteFile(String path )
        - getContent(String path)
        - move(String source , String destination)
        - rename(String path , String oldName , String newName)
        }
    

    2. FSEntry abstract class
        {
        - name string // setter getter
        - parent // setter getter
        - abstract boolean isDirectory()
        }
    
    3. File inherits FSEntry
        {
        - content string // setter getter
        - boolean isDirectory()
        }
    
    4. Folder inherits FSEntry
        {
        - Map<String,FSEntry> childs // setter getter
        }