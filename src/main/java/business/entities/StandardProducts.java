package business.entities;

public class StandardProducts {

    private int length;
    private int width;
    private int price;
    private String title;
    private String description;

    public StandardProducts(int length, int width, int price, String title, String description) {
        this.length = length;
        this.width = width;
        this.price = price;
        this.title = title;
        this.description = description;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
