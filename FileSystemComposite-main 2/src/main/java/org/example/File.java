package org.example;

public class File implements IFileSystemComponent {
    private String _name;
    private String _content;

    public File(String name, String content)
    {
        _name = name;
        _content = content;
    }

    @Override
    public double getSize() {
        return _content.length();
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name=name;
    }

    @Override
    public String getContent() {
        return _content;
    }
}
