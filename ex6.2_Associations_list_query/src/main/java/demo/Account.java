package demo;

import javax.annotation.PostConstruct;

public class Account {

    public float amt = 10;
    private String name;
    private String type;
    private int id;

    public float getAmt() {
        return amt;
    }

    public void setAmt(float amt) {
        this.amt = amt;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account() {
        System.out.println("Lifecycle1...Instantiate");
    }

    @PostConstruct
    public void init() {
        // Remote object initialize, datasource
        System.out.println("Lifecycle5...@Postconstruct method (Account)");
    }


}
