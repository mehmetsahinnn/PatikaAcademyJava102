package PatikaStore;

public class Brand extends PatikaStore implements Comparable<Brand> {
    Integer id;
    String name;

    public Brand(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Brand o) {
        return this.name.compareTo(o.name);
    }
}
