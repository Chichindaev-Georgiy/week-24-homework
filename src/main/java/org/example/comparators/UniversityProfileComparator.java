package org.example.comparators;

import org.apache.commons.lang3.StringUtils;
import org.example.University;

public class UniversityProfileComparator implements UniversityComparator{
    @Override
    public int compare(University o1, University o2) {
        if (null == o1.getMainProfile()) {
            return 1;
        } else if (null == o2.getMainProfile()) {
            return -1;
        }
        return StringUtils.compare(o1.getMainProfile().getProfileName(), o2.getMainProfile().getProfileName());
    }
}
