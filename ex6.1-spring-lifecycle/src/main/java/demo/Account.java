package demo;

import javax.annotation.PostConstruct;

public class Account {

    public float amt = 10;

    public Account() {
        System.out.println("Lifecycle1...Instantiate");
    }

    @PostConstruct
    public void init() {
        // Remote object initialize, datasource
        System.out.println("Lifecycle5...@Postconstruct method (Account)");
    }


}
