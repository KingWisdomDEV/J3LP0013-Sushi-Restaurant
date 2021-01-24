package entity;

/**
 *
 * @author hoang
 */
public class Menu {
    private int id;
    private String name;
    private double price;
    private String shortDesc;
    private String detailDesc;

    public Menu() {
    }

    public Menu(int id, String name, double price, String shortDesc, String detailDesc) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.shortDesc = shortDesc;
        this.detailDesc = detailDesc;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getDetailDesc() {
        return detailDesc;
    }

    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
    }
    
}
