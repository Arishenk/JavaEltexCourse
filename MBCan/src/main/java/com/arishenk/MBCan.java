package com.arishenk;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class MBCan {
    public static void main(String[] args)
            throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException,
            MBeanRegistrationException, InterruptedException {

        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("com.arishenk:type=User");
        User user = new User("arishenk");
        mbs.registerMBean(user, name);
        Thread.sleep(10000);
    }
}
