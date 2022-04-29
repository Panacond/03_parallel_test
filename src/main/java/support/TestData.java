package support;

public class TestData {
    private String product;
    private String brand;
    private Integer minPrice;
    private Integer realPrice;
    public TestData(){}

    public TestData(String product, String brand, Integer minPrice) {
        this.product = product;
        this.brand = brand;
        this.minPrice = minPrice;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(Integer realPrice) {
        this.realPrice = realPrice;
    }

    @Override
    public String toString() {
        return "TestData{" +
                "product='" + product + '\'' +
                ", brand='" + brand + '\'' +
                ", minPrice=" + minPrice +
                ", realPrice=" + realPrice +
                '}';
    }
}
