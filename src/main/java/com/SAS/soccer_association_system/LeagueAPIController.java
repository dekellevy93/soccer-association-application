/**
 * The class represents the api of team in the sas application
 */
package com.SAS.soccer_association_system;

import com.SAS.Controllers.sasApplication.SASApplication;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value ="/team")
@RestController
public class LeagueAPIController {

    @Autowired
    private static SASApplication app = new SASApplication();

    /**
     * The function receives league name and returns response success if the league created,
     * otherwise returns false
     * @return String - success or fail
     */
    @PostMapping(value ="/createLeague")
    public String postLeague(@RequestBody String details) {
        JSONObject json = new JSONObject(details);
        String leagueName = json.get("leagueName").toString();
        String userCreated = json.get("user").toString();
        return app.createLeague(leagueName, userCreated) ? "success" : "fail";
    }

    /**
     * The function receives league name and the year of the season returns response success if the league attached to season,
     *      otherwise returns false
     * @param details
     * @return String - success or fail
     */
    @PostMapping(value ="/addSeasonToLeague")
    public String postSeasonToLeague(@RequestBody String details) {
        JSONObject json = new JSONObject(details);
        String leagueName = json.get("leagueName").toString();
        int seasonYear = (Integer)json.get("seasonName");
        return app.addSeasonToLeague(leagueName, seasonYear) ? "success" : "fail";
    }

    /**
     * gets the league, season and referee id and assign him to the league in the specific season
     * @param details
     * @return
     */
    @PostMapping(value ="/assignRefereeToLeague")
    public String postAssignRefereeToLeague(@RequestBody String details) {
        JSONObject json = new JSONObject(details);
        String leagueName = json.get("leagueName").toString();
        String seasonYear = json.get("seasonName").toString();
        String userId = json.get("userId").toString();
        return app.assignRefereeToLeague(leagueName, seasonYear, userId) ? "success" : "fail";
    }
    /**
     *gets the id of the wanted referee and remove it
     * @param details
     * @return
     */
    @PostMapping(value ="/removeReferee")
    public String postRemoveReferee(@RequestBody String details) {
        JSONObject json = new JSONObject(details);
        String userId = json.get("userId").toString();
        return app.deleteUser(userId) ? "success" : "fail";
    }
    /**
     *gets the league, season and policies and the user who wants to assign them and assign the policies to the league in a specific season
     * @param details
     * @return
     */
    @PostMapping(value ="/definePolicies")
    public String postDefinePolicies(@RequestBody String details) {
        JSONObject json = new JSONObject(details);
        String leagueName = json.get("leagueName").toString();
        int seasonYear = (Integer)json.get("seasonName");
        String gamePolicy = json.get("gamePolicy").toString();
        String rankPolicy = json.get("leagueRankPolicy").toString();
        String pointsPolicy = json.get("pointsPolicy").toString();
        String username= json.get("username").toString();
        return app.setPolicies(leagueName,seasonYear, rankPolicy,pointsPolicy,gamePolicy,username) ? "success" : "fail";
    }
        /**
         * The function receives team owner and the team name returns response success if the team registered,
         * otherwise returns false
         * @return String - success or fail
         */
    @PostMapping(value ="/registerTeam")
    public String postTeam(@RequestBody String details) {
        JSONObject json = new JSONObject(details);
        String teamOwner = json.get("teamOwner").toString();
        String teamName = json.get("teamName").toString();
        return app.registerTeam(teamOwner, teamName) ? "success" : "fail";
    }

    /**
     * The function receives team name, representative username and confirmation status and returns response success
     * if the team confirmed successfully, otherwise returns false
     * @return String - success or fail
     */
    @PostMapping(value ="/confirmTeamRegistration")
    public String postTeamConfirmation(@RequestBody String details) {
        JSONObject json = new JSONObject(details);
        String representative = json.get("representative").toString();
        String teamName = json.get("teamName").toString();
        boolean isConfirm = (boolean) json.get("confirm");
        return app.confirmTeam(teamName, representative, isConfirm) ? "success" : "fail";
    }

    /**
     * The function receives team name and owner username and returns response success
     * if the team closed successfully, otherwise returns false
     * @return String - success or fail
     */
    @PostMapping(value ="/closeTeam")
    public String postCloseTeam(@RequestBody String details) {
        JSONObject json = new JSONObject(details);
        String teamName = json.get("teamName").toString();
        String owner = json.get("owner").toString();
        return app.closeTeam(teamName, owner) ? "success" : "fail";
    }

    /**
     * The function receives team name and owner username and returns response success
     * if the team opened successfully, otherwise returns false
     * @return String - success or fail
     */
    @PostMapping(value ="/openTeam")
    public String postOpenTeam(@RequestBody String details) {
        JSONObject json = new JSONObject(details);
        String teamName = json.get("teamName").toString();
        String owner = json.get("owner").toString();
        return app.openTeam(teamName, owner) ? "success" : "fail";
    }

    /**
     * The function receives the team name, new team owner username and nominated by username
     * and returns success if added, otherwise returns fail
     * @return String - success or fail
     */
    @PostMapping(value ="/addTeamOwner")
    public String postAddTeamOwner(@RequestBody String details) {
        JSONObject json = new JSONObject(details);
        String teamName = json.get("teamName").toString();
        String newTeamOwner = json.get("newTeamOwner").toString();
        String nominatedBy = json.get("nominatedBy").toString();
        return app.addTeamOwner(teamName, newTeamOwner, nominatedBy) ? "success": "fail";
    }

    /**
     * The function receives the team name, team owner to remove and nominated by username
     * and returns success if removed, otherwise returns fail
     * @return String - success or fail
     */
    @PostMapping(value ="/removeTeamOwner")
    public String postRemoveTeamOwner(@RequestBody String details) {
        JSONObject json = new JSONObject(details);
        String teamName = json.get("teamName").toString();
        String removeTeamOwner = json.get("removeTeamOwner").toString();
        String nominatedBy = json.get("nominatedBy").toString();
        return app.removeTeamOwner(teamName, removeTeamOwner, nominatedBy) ? "success": "fail";
    }

    /**
     * The function receives the team name, new team manager username and nominated by username
     * and returns success if added, otherwise returns fail
     * @return String - success or fail
     */
    @PostMapping(value ="/addTeamManager")
    public String postAddTeamManager(@RequestBody String details) {
        JSONObject json = new JSONObject(details);
        String teamName = json.get("teamName").toString();
        String newTeamManager = json.get("newTeamManager").toString();
        String nominatedBy = json.get("nominatedBy").toString();
        boolean approval = (boolean) json.get("approval");
        return app.addTeamManager(teamName, newTeamManager, nominatedBy, approval) ? "success": "fail";
    }

    /**
     * The function receives the team name, team manager to remove and nominated by username
     * and returns success if removed, otherwise returns fail
     * @return String - success or fail
     */
    @PostMapping(value ="/removeTeamManager")
    public String postRemoveTeamManager(@RequestBody String details) {
        JSONObject json = new JSONObject(details);
        String teamName = json.get("teamName").toString();
        String removeTeamManager = json.get("removeTeamManager").toString();
        String nominatedBy = json.get("nominatedBy").toString();
        return app.removeTeamManager(teamName, removeTeamManager, nominatedBy) ? "success": "fail";
    }

    /**
     * The function receives the team name, team owner and transaction details to add
     * and returns success if it added, otherwise returns fail
     * @return String - success or fail
     */
    @PostMapping(value ="/addTeamTransaction")
    public String postTeamTransaction(@RequestBody String details) {
        JSONObject json = new JSONObject(details);
        String teamName = json.get("teamName").toString();
        String teamOwner = json.get("teamOwner").toString();
        JSONObject transactionDetails = ((JSONObject) json.get("details"));
        return app.addTeamTransaction(teamName, teamOwner, transactionDetails) ? "success": "fail";
    }

    /**
     * The function receives the team name, asset type and details to add
     * and returns success if it added, otherwise returns fail
     * @return String - success or fail
     */
    @PostMapping(value ="/addTeamAsset")
    public String postTeamAsset(@RequestBody String details) {
        JSONObject json = new JSONObject(details);
        String teamName = json.get("teamName").toString();
        String teamOwner = json.get("teamOwner").toString();
        String assetType = json.get("assetType").toString();
        JSONObject assetDetails = ((JSONObject) json.get("details"));
        return app.addTeamAsset(teamName, teamOwner, assetType, assetDetails) ? "success": "fail";
    }

    /**
     * The function receives the team name, asset type and details to edit
     * and returns success if it added, otherwise returns fail
     * @return String - success or fail
     */
    @PutMapping(value ="/editTeamAsset")
    public String putTeamAsset(@RequestBody String details) {
        JSONObject json = new JSONObject(details);
        String teamName = json.get("teamName").toString();
        String assetType = json.get("assetType").toString();
        JSONObject assetDetails = ((JSONObject) json.get("details"));
        return app.editAssetDetails(teamName, assetType, assetDetails) ? "success": "fail";
    }

    /**
     * The function receives the team name, and asset to remove
     * and returns success if it removed, otherwise returns fail
     * @return String - success or fail
     */
    @PostMapping(value ="/removeTeamAsset")
    public String postRemoveTeamAsset(@RequestBody String details) {
        JSONObject json = new JSONObject(details);
        String teamName = json.get("teamName").toString();
        String assetType = json.get("assetType").toString();
        String assetName = json.get("assetName").toString();
        String teamOwner = json.get("teamOwner").toString();
        return app.removeTeamAsset(teamName, assetType, assetName, teamOwner) ? "success": "fail";
    }

    /**
     * The function returns all the teams
     * @return
     */
    @GetMapping(value = "/getTeams")
    public JSONArray getTeams() {
        return app.getTeams();
    }

    /**
     * The function returns all the optional nominees for the team owner
     * @return list of usernames
     */
    @GetMapping(value = "/getOptionalNomineesForTeamOwner")
    public JSONArray getOptionalNomineesForTeam(@RequestBody String details) {
        JSONObject json = new JSONObject(details);
        String teamName = json.get("teamName").toString();
        return app.getOptionalNomineesForTeamOwner(teamName);
    }

    /**
     * The function returns all the optional nominees for the team manager
     * @return list of usernames
     */
    @GetMapping(value = "/getOptionalNomineesForTeamManager")
    public JSONArray getOptionalNomineesForTeamManager(@RequestBody String details) {
        JSONObject json = new JSONObject(details);
        String teamName = json.get("teamName").toString();
        return app.getOptionalNomineesForTeamManager(teamName);
    }

    /**
     * The function returns all the assets of the team
     * @return list of assets
     */
    @GetMapping(value = "/getAssetsForTeam")
    public JSONObject getAssetsForTeam(@RequestBody String details) {
        JSONObject json = new JSONObject(details);
        String teamName = json.get("teamName").toString();
        return app.getAssetsForTeam(teamName);
    }
}
