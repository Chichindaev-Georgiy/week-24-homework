package org.example;

import org.apache.xmlbeans.impl.xb.xsdschema.All;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "root element")
@XmlAccessorType(XmlAccessType.FIELD)
public class AllInfo {
    @XmlElementWrapper(name = "studentsInfo")
    @XmlElement(name = "student")
    private List<Student> studentList;
    @XmlElementWrapper(name = "universityInfo")
    @XmlElement(name = "university")
    private List<University> universityList;
    @XmlElementWrapper(name = "statsInfo")
    @XmlElement(name = "statistics")
    private List<Statistics> statisticsList;
    @XmlElement(name = "currentTime")
    private Date currentDate;

    public AllInfo() {}

    public List<Student> getStudentList() {
        return studentList;
    }

    public AllInfo setStudentList(List<Student> studentList) {
        this.studentList = studentList;
        return this;
    }

    public List<University> getUniversityList() {
        return universityList;
    }

    public AllInfo setUniversityList(List<University> universityList) {
        this.universityList = universityList;
        return this;
    }

    public List<Statistics> getStatisticsList() {
        return statisticsList;
    }

    public AllInfo setStatisticsList(List<Statistics> statisticsList) {
        this.statisticsList = statisticsList;
        return this;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public AllInfo setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
        return this;
    }
}
