package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Project {

    private String projectName;

    private User projectOwner;

    private LocalDate startDate;

    private int percentageComplete;

    private LocalDate estimatedEndDate;

    private ArrayList<Phase> phaseList;

    Project(){
        phaseList = new ArrayList<Phase>();
        projectOwner = new User();
        startDate = LocalDate.now();
        estimatedEndDate = LocalDate.now();
    }

    public String getProjectName() {
        return this.projectName;
    }

    public void setProjectName(String name) {
        this.projectName = name;
    }

    public User getProjectOwner() {
        return this.projectOwner;
    }

    public void setProjectOwner(User owner) {
        this.projectOwner = owner;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate date) {
        this.startDate = date;
    }

    public int getPercentageComplete() {
        return this.percentageComplete;
    }

    public LocalDate getEstimatedEndDate() {
        return estimatedEndDate;
    }

    public ArrayList<Phase> getPhaseList() {
        return this.phaseList;
    }
}
