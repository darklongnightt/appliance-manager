package com.capgemini.interview;

import java.util.*;
import com.capgemini.interview.Exceptions.*;

public class ApplianceResource {
    private ArrayList<Appliance> applianceList;
    private HashMap<String, Appliance> applianceMap;

    public ApplianceResource() {
        applianceList = new ArrayList<Appliance>();
        applianceMap = new HashMap<String, Appliance>();

        add(new Appliance("128713A", "SolaRay", "A", "USING", "2020-06-27"));
        add(new Appliance("128714A", "SolaRay", "B", "OLD", "2020-06-17"));
        add(new Appliance("142915C", "Now", "A", "UNUSED", "2020-06-11"));
        add(new Appliance("152915C", "Now", "C", "SOLD", "2020-06-17"));
    }

    public ArrayList<Appliance> getApplianceList() {
        return applianceList;
    }

    /* Add to existing appliance list of validation using hashmap */
    public void add(Appliance newAppliance) {
        String identifier = newAppliance.getIdentifier();
        if (exists(identifier)) {
            throw new NotUniqueException();
        }

        applianceList.add(newAppliance);
        applianceMap.put(identifier, newAppliance);
    }

    /* Remove appliance from list and hashmap */
    public void remove(String id) {
        for (int i=0; i<this.applianceList.size(); i++) {
            Appliance current = this.applianceList.get(i);
            if (id.equals(current.getId())) {
                applianceList.remove(i);
                applianceMap.remove(current.getIdentifier());
                return;
            }
        }

        throw new NotFoundException();
    }

    /* Update an existing appliance */
    public Appliance update(String id, Appliance newAppliance) {
        for (int i=0; i<this.applianceList.size(); i++) {
            Appliance current = this.applianceList.get(i);
            if (id.equals(current.getId())) {
                if (!same(current, newAppliance) && exists(newAppliance.getIdentifier())) {
                    throw new NotUniqueException();
                }

                this.applianceMap.remove(current.getIdentifier());
                current.update(newAppliance);
                applianceMap.put(current.getIdentifier(), current);

                return current;
            }
        }

        throw new NotFoundException();
    }

    /* Checks if an item already exists using hashmap */
    private boolean exists(String identifier) {
        if (this.applianceMap.containsKey(identifier)) {
            return true;
        }
        return false;
    }

    /* Checks if two items are differs in identifier */
    private boolean same(Appliance a, Appliance b) {
        if (a.getIdentifier().equals(b.getIdentifier())) {
            return true;
        }
        return false;
    }

}