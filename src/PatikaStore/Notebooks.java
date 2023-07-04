package PatikaStore;

public class Notebooks extends Brand {
    Integer price;
    Integer stock;
    Integer sale;
    String brand;
    Integer screenSize;
    Integer ram;
    Integer batteryPower;
    String color;

    public Notebooks(Integer id,
                     String name,
                     Integer price,
                     Integer stock,
                     Integer sale,
                     String brand,
                     Integer screenSize,
                     Integer ram,
                     Integer batteryPower,
                     String color) {
        super(id, name);
        this.price = price;
        this.stock = stock;
        this.sale = sale;
        this.brand = brand;
        this.screenSize = screenSize;
        this.ram = ram;
        this.batteryPower = batteryPower;
        this.color = color;
    }


    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(Integer screenSize) {
        this.screenSize = screenSize;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(Integer batteryPower) {
        this.batteryPower = batteryPower;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
