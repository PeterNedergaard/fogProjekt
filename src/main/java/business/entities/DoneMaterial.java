package business.entities;

public class DoneMaterial {

    private int id;
    private String name;
    private int unitAmount;
    private String unitType;

    public DoneMaterial(String name, int unitAmount, String unitType) {
        this.name = name;
        this.unitAmount = unitAmount;
        this.unitType = unitType;
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

    public int getUnitAmount() {
        return unitAmount;
    }

    public void setUnitAmount(int unitAmount) {
        this.unitAmount = unitAmount;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }
}
