/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Mainul35
 */
public class PhaseList {

    private ArrayList<Phase> phases;
    private volatile static PhaseList phaseList = null;

    private PhaseList() {
        if (phaseList == null) {
            synchronized (PhaseList.class) {
                phaseList = new PhaseList();
                phases = new ArrayList<>();
            }
        }else{
            throw new RuntimeException("Singleton Can not create a new PhaseList. Use getPhaseList() method.");
        }
    }

    public static PhaseList getPhaseList(){
        return phaseList;
    }
    public void addAll(ArrayList<Phase> phases){
        this.phases = phases;
    }
    
    public Phase get(int i){
        return this.phases.get(i);
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    private Object readResolve(){
        return UserList.getUserList();
    }
}
