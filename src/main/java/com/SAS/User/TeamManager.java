/**
 * The class represents a team manager
 */

package com.SAS.User;

import com.SAS.team.Team;

import java.util.HashSet;
import java.util.LinkedList;

public class TeamManager extends Role {

    private User user;
    private Team team;
    private TeamOwner nominatedBy;

    /**
     * Constructor
     * @param user
     */
    public TeamManager(User user, String fullName) {
        super(fullName);
        this.user = user;
        myPrivileges.addAll(user.myPrivileges);
    }

    /**
     * The function returns the user
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * The function sets the team of the manager
     * @param team
     */
    public void setTeam (Team team) {
        this.team = team;
    }

    /**
     * The function returns the team of the manager
     */
    public Team getTeam() {
        return team;
    }

    /**
     * The function returns the user that nominated this user to team manager
     * @return user
     */
    public User getNominatedBy() {
        return nominatedBy;
    }

    /**
     * The function sets the user that nominated this user to team manager
     * @param nominatedBy
     */
    public void setNominatedBy(TeamOwner nominatedBy) {
        this.nominatedBy = nominatedBy;
    }


    /**
     * The function returns all the privileges of the user
     * @return
     */
    public HashSet<String> getMyPrivileges() {
        return myPrivileges;
    }

    @Override
    public String getRole() {
        return "TeamManager";
    }
}
