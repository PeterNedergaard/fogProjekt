package business.entities;

public class Order {

    private int productId;
    private String productType;
    private int userId;
    private int userOrderId;
    private String status;

    public Order(int productId, String productType, int userId, int userOrderId, String status) {
        this.productId = productId;
        this.productType = productType;
        this.userId = userId;
        this.userOrderId = userOrderId;
        this.status = status;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserOrderId() {
        return userOrderId;
    }

    public void setUserOrderId(int userOrderId) {
        this.userOrderId = userOrderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
