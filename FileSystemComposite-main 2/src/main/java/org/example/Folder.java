package org.example;

import java.util.ArrayList;

public class Folder implements IFileSystemComposite{
    private String _name;
    private ArrayList<IFileSystemComponent>
        _items = new ArrayList<>();

    public Folder(String name){
        _name = name;
    }

    @Override
    public double getSize() {
        double size = 0;
        for(int i=0; i<_items.size();i++)
        {
            size+=_items.get(i).getSize();
        }

        return size;
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;
    }

    @Override
    public String getContent() {
        String content = _name;
        content += "\n";
        for(int i=0; i<_items.size();i++)
        {
            content +="___"+_items.get(i).getContent() +"\n";
        }

        return content;
    }

    @Override
    public void add(IFileSystemComponent storageObject) {
        if(!_items.contains(storageObject)) {
            _items.add(storageObject);
        }
    }

    @Override
    public void remove(IFileSystemComponent storageObject) {
        if(_items.contains(storageObject)) {
            _items.remove(storageObject);
        }
    }
}
