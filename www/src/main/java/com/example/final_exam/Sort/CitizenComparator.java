package com.example.final_exam.Sort;

import com.example.final_exam.Entity.Citizen;

import java.util.Comparator;

public class CitizenComparator implements Comparator<Citizen> {
    @Override
    public int compare(Citizen o1, Citizen o2) {
        return o1.getRegion().getName().compareTo(o2.getRegion().getName());
    }
}
