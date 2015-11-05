package bAsics;

import java.util.*;

/**
 * Created by hellsapphire on 10/13/2015.
 * securities bloomberg design
 */
public class securityManager {
    private Map<String, securityData> secMap = new HashMap<>();
    private Map<securityData, List<subscriber>> secToSubListMap = new HashMap<>();
    private PriorityQueue<securityData> topSecurities = new PriorityQueue<>(100, new CustomComparator()); // fluctuation comparator
    private List<subscriber> allSubList = new ArrayList<>(); // when adding a subscriber to this remove it from map of sec to sub list

    public static void main(String[] args) {
    }


    public void setSecurity(String name, float price) {
        securityData sD;

        if (secMap.containsKey(name)) {
            sD = secMap.get(name);
            topSecurities.remove(sD);
            sD.updatePrice(price);
            topSecurities.add(sD);
        } else {
            sD = new securityData(name, price);
            topSecurities.add(sD);
        }

        informAllSubs(sD, price);
    }

    public void informAllSubs(securityData sD, float price) {
        for (subscriber s : secToSubListMap.get(sD)) {
            s.notifyChange(sD.getName(), price);
        }
    }

    public void subToAll(subscriber s) {
        s.subToAll();
    }

    class CustomComparator implements Comparator<securityData> {

        public int compare(securityData o1, securityData o2) {
            float x = o2.getPrice() - o1.getPrice();
            return (int) x;
        }
    }
}


class securityData {
    private String name;
    private float price;
    private Bond bN;
    private Equity eQ;

    public securityData() {

    }

    public securityData(String name, float price) {
        this.name = name;
        this.price = price;
        bN = new Bond();
        eQ = new Equity();
    }

    public synchronized void updatePrice(float p) {
        this.price = p;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    private class Bond {

    }

    private class Equity {

    }
}


class subscriber {
    private long id;
    private Set<securityData> subList;
    private boolean subToAll;

    public subscriber(long id) {
        this.id = id;
        subList = new HashSet<>();
    }

    public void addSecurity(securityData s) {
        subList.add(s);
    }

    public void subToAll() {
        subList.clear();
        this.subToAll = true;
    }

    public void notifyChange(String name, float p) {
        System.out.println(name + " price changed to: " + p);
    }
}