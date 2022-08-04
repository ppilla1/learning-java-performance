package demo;


import javax.management.*;
import java.io.IOException;
import java.lang.management.ManagementFactory;

public class ConsumeHeap {


    static MBeanServer mbs = null;

    public static void main(String[] args) throws IOException, InterruptedException, MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException {
        ObjectName helloName = null;

        mbs = ManagementFactory.getPlatformMBeanServer();


        helloName = new ObjectName("CustomeMbean:name=HelloBean");

        HeapManagement account = new HeapManagement();
        account.getData();
        mbs.registerMBean(account, helloName);


        //     account.clear();

        Thread.sleep(500000000);

    }


}