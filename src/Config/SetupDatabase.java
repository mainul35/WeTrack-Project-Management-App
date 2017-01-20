/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import com.JDBC.JDBCManager;

/**
 *
 * @author Mainul35
 */
class SetupDatabase {

    public SetupDatabase() {
        JDBCManager manager = ConnectionManager.getConnection();
        String sql = "DROP TABLE if EXISTS user;";
        manager.dropTable(sql);
        sql = "DROP TABLE IF EXISTS phase;";
        manager.dropTable(sql);
        sql = "DROP TABLE IF EXISTS phaseDependencies;";
        manager.dropTable(sql);
        sql = "DROP TABLE IF EXISTS milestoneOfPhase;";
        manager.dropTable(sql);
        sql = "DROP TABLE IF EXISTS project;";
        manager.dropTable(sql);
        sql = "DROP TABLE IF EXISTS userInPhases;";
        manager.dropTable(sql);
        sql = "DROP TABLE IF EXISTS phasesInProject;";
        manager.dropTable(sql);
        sql = "DROP TABLE IF EXISTS skill;";
        manager.dropTable(sql);
        sql = "DROP TABLE IF EXISTS skillsOfUser;";
        manager.dropTable(sql);
        sql = "DROP TABLE IF EXISTS skillsForPhase;";
        manager.dropTable(sql);

        sql = "CREATE TABLE if not exists \"user\" (\n"
                + "\"name\"  varchar not null,\n"
                + "\"email\"  varchar not null,\n"
                + "\"password\"  varchar not null,\n"
                + "\"availabilityDuration\" REAL,\n"
                + "PRIMARY KEY (\"email\" ASC)\n"
                + ");";

        boolean flag = manager.createTable(sql);
        if (flag == true) {
            System.err.println("Table 'User' created successfully.");
        }
        sql = "CREATE TABLE if not exists \"phase\" (\n"
                + "\"phaseId\"  INTEGER AUTO_INCREMENT,\n"
                + "\"phaseName\"  varchar,\n"
                + "\"phaseLength\"  INTEGER,\n"
                + "PRIMARY KEY (\"phaseId\")\n"
                + ");";
        flag = manager.createTable(sql);
        if (flag == true) {
            System.err.println("Table 'phase' created successfully.");
        }
        sql = "CREATE TABLE if not exists \"phaseDependencies\"(\n"
                + "\"independentPhaseId\"  INTEGER,\n"
                + "\"dependentPhaseId\"  INTEGER,\n"
                + "PRIMARY KEY (\"independentPhaseId\", \"dependentPhaseId\"),\n"
                + "FOREIGN KEY (\"independentPhaseId\") REFERENCES \"phase\" (\"phaseId\"),\n"
                + "FOREIGN KEY (\"dependentPhaseId\") REFERENCES \"phase\" (\"phaseId\")\n"
                + ");";
        flag = manager.createTable(sql);
        if (flag == true) {
            System.err.println("Table 'phaseDependencies' created successfully.");
        }

        sql = "CREATE TABLE if not exists \"milestoneOfPhase\" (\n"
                + "\"milestoneId\"  INTEGER AUTO_INCREMENT,\n"
                + "\"milestoneName\"  varchar NOT NULL,\n"
                + "\"isComplete\"  integer NOT NULL,\n"
                + "\"daysTaken\"  integer NOT NULL,\n"
                + "\"phaseId\"  integer NOT NULL,\n"
                + "PRIMARY KEY (\"milestoneId\")\n"
                + "FOREIGN KEY (\"phaseId\") REFERENCES \"phase\" (\"phaseId\")\n"
                + ");";
        flag = manager.createTable(sql);
        if (flag == true) {
            System.err.println("Table 'milestoneOfPhase' created successfully.");
        }

        sql = "CREATE TABLE if not exists \"project\" (\n"
                + "\"projectId\"  INTEGER AUTO_INCREMENT,\n"
                + "\"projectName\"  VARCHAR NOT NULL,\n"
                + "\"userEmail\"  VARCHAR NOT NULL,\n"
                + "PRIMARY KEY (\"projectId\"),\n"
                + "FOREIGN KEY (\"userEmail\") REFERENCES \"User\" (\"email\")\n"
                + ");";
        flag = manager.createTable(sql);
        if (flag == true) {
            System.err.println("Table 'project' created successfully.");
        }

        sql = "CREATE TABLE if not exists \"userInPhases\" (\n"
                + "\"phaseId\"  INTEGER,\n"
                + "\"userEmail\"  VARCHAR NOT NULL,\n"
                + "PRIMARY KEY (\"userEmail\", \"phaseId\"),\n"
                + "FOREIGN KEY (\"userEmail\") REFERENCES \"User\" (\"email\"),\n"
                + "FOREIGN KEY (\"phaseId\") REFERENCES \"phase\" (\"phaseId\")\n"
                + ");";
        flag = manager.createTable(sql);
        if (flag == true) {
            System.err.println("Table 'userInPhases' created successfully.");
        }

        sql = "CREATE TABLE if not exists \"phasesInProject\" (\n"
                + "\"projectId\"  INTEGER,\n"
                + "\"phaseId\"  INTEGER,\n"
                + "PRIMARY KEY (\"projectId\", \"phaseId\"),\n"
                + "FOREIGN KEY (\"phaseId\") REFERENCES \"phase\" (\"phaseId\"),\n"
                + "FOREIGN KEY (\"projectId\") REFERENCES \"project\" (\"projectId\")\n"
                + ");";
        flag = manager.createTable(sql);
        if (flag == true) {
            System.err.println("Table 'phasesInProject' created successfully.");
        }

        sql = "CREATE TABLE if not exists \"skill\" (\n"
                + "\"skillId\"  INTEGER,\n"
                + "\"skillName\"  varchar NOT NULL,\n"
                + "PRIMARY KEY (\"skillId\")\n"
                + ");";
        flag = manager.createTable(sql);
        if (flag == true) {
            System.err.println("Table 'skill' created successfully.");
        }

        sql = "CREATE TABLE if not exists \"skillsOfUser\" (\n"
                + "\"userEmail\"  VARCHAR NOT NULL,\n"
                + "\"skillId\"  INTEGER,\n"
                + "PRIMARY KEY (\"skillId\", \"userEmail\"),\n"
                + "FOREIGN KEY (\"userEmail\") REFERENCES \"User\" (\"email\"),\n"
                + "FOREIGN KEY (\"skillId\") REFERENCES \"skill\" (\"skillId\")\n"
                + ");";
        flag = manager.createTable(sql);
        if (flag == true) {
            System.err.println("Table 'skillsOfUser' created successfully.");
        }

        sql = "CREATE TABLE if not exists \"skillsForPhase\" (\n"
                + "\"skillId\"  INTEGER,\n"
                + "\"phaseId\"  INTEGER,\n"
                + "PRIMARY KEY (\"skillId\", \"phaseId\"),\n"
                + "FOREIGN KEY (\"skillId\") REFERENCES \"skill\" (\"skillId\"),\n"
                + "FOREIGN KEY (\"phaseId\") REFERENCES \"phase\" (\"phaseId\")\n"
                + ");";
        flag = manager.createTable(sql);
        if (flag == true) {
            System.err.println("Table 'skill' created successfully.");
        }
    }
    
    public static void main(String[] args) {
        new SetupDatabase();
    }
}
