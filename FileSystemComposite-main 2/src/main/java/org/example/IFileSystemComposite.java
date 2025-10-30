package org.example;

public interface IFileSystemComposite
        extends IFileSystemComponent{
    void add(IFileSystemComponent storageObject);
    void remove(IFileSystemComponent storageObject);
}
