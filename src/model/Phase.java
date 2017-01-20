package model;

import java.util.ArrayList;

public class Phase {

    private int phaseId;

    private int phaseLength;

    private ArrayList<User> assignedUsers;

    private ArrayList<Integer> dependencies;

    private ArrayList<String> milestones;

    Phase(){
        assignedUsers = UserList.getUserList().getAll();
        dependencies = new ArrayList<>();
        milestones = new ArrayList<>();
    }

    public int getPhaseId() {
        return this.phaseId;
    }

    public void setPhaseId(int phaseId) {
        this.phaseId = phaseId;
    }

    public int getPhaseLength() {
        return this.phaseLength;
    }

    public void setPhaseLength(int length) {
        this.phaseLength = length;
    }

    public ArrayList<String> getMileStones() {
        return this.milestones;
    }

    public void addMilestome(String milestome) {
        this.milestones.add(milestome);
    }

    public void removeMilestone(String milestone) {
        this.milestones.remove(milestone);
    }

    public ArrayList<User> getAssignedUsers() {
        return assignedUsers;
    }

    public ArrayList<Integer> getDependencies() {
        return this.dependencies;
    }
}
