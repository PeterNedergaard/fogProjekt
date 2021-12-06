package business.entities;

import java.util.Comparator;

public class WorkableMaterial{

    private int id;
    private String name;
    private String type;
    private int length;
    private int width;
    private int height;

    public WorkableMaterial(String name, String type, int length, int width, int height) {
        this.name = name;
        this.type = type;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
