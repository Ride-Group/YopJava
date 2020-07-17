package com.ridegroup.yop.test;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class CollectionTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testHashSet() {
        Set set = new HashSet();
        set.add("1");//map.put(e, PRESENT)==null;

        Map linked = new LinkedHashMap();
        linked.put("1", "1");
        linked.get("1");

        Set tree = new TreeSet();
        tree.add("1");

        Map table = new Hashtable();
        Map concurrent = new ConcurrentHashMap();

        List list = new ArrayList();
        List linkedList = new LinkedList();
        List vector = new Vector();

        System.out.println(AbstractQueuedSynchronizer.class);
    }
}
