package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

//The map of all the pellets in the game
public class Pellets implements Writable {
    private int score;
    private int[][] pellets  = {
            {1,3},{1,4},{1,5},{1,6},{1,7},{1,8},{1,9},{1,11}, {1,12},{1,13},{1,14},{1,15},{1,16},{1,17},
            {2,2},{2,6},{2,9},{2,11},{2,14},{3,14},{2,18},{3,18},{3,2},{3,6},{3,9},{3,11},{5,16},{6,16},
            {4,2},{4,3},{4,4},{4,5},{4,6},{4,7},{4,8},{4,9},{4,11},{4,12},{4,13},{4,14},{4,15},{4,16},{4,17},{4,18},
            {5,2},{6,2},{5,18},{6,18},{7,18},{7,2},
            {10,2},{10,3},{10,4},{10,5},{10,6},{10,7},{10,8},{10,9},{10,11},{10,12},{10,13},{10,14},
            {7,13},{7,14},{7,15},{7,16},{10,15},{10,16},{10,17},{10,18},{8,13},{9,13},{5,4},{6,4},
            {7,4},{7,5},{7,6},{7,7},{8,7},{9,7},{9,18},{8,18},{9,2},{8,2},{11,4},{12,4},
            {13,5},{13,6},{13,7},{13,8},{12,7},{11,7},{13,9},{13,11},{13,12},{13,13},{13,14},{13,15},
            {11,13},{12,13},{12,16},{11,16},{12,11},{12,9},{12,10},{11,10}
    };

    private int[][] backUp  = {
            {1,3},{1,4},{1,5},{1,6},{1,7},{1,8},{1,9},{1,11}, {1,12},{1,13},{1,14},{1,15},{1,16},{1,17},
            {2,2},{2,6},{2,9},{2,11},{2,14},{3,14},{2,18},{3,18},{3,2},{3,6},{3,9},{3,11},{5,16},{6,16},
            {4,2},{4,3},{4,4},{4,5},{4,6},{4,7},{4,8},{4,9},{4,11},{4,12},{4,13},{4,14},{4,15},{4,16},{4,17},{4,18},
            {5,2},{6,2},{5,18},{6,18},{7,18},{7,2},
            {10,2},{10,3},{10,4},{10,5},{10,6},{10,7},{10,8},{10,9},{10,11},{10,12},{10,13},{10,14},
            {7,13},{7,14},{7,15},{7,16},{10,15},{10,16},{10,17},{10,18},{8,13},{9,13},{5,4},{6,4},
            {7,4},{7,5},{7,6},{7,7},{8,7},{9,7},{9,18},{8,18},{9,2},{8,2},{11,4},{12,4},
            {13,5},{13,6},{13,7},{13,8},{12,7},{11,7},{13,9},{13,11},{13,12},{13,13},{13,14},{13,15},
            {11,13},{12,13},{12,16},{11,16},{12,11},{12,9},{12,10},{11,10}
    };

    //MODIFIES: this
    //EFFECTS: creates new map, and sets score to 0
    public Pellets() {
        score = 0;
    }

    //MODIFIES: this
    //EFFECTS: increase the score by 20
    public int increaseScore() {
        return score += 10;
    }

    //MODIFIES: this
    //EFFECTS: increase the score by 20
    public int increaseScoreGhost() {
        return score += 200;
    }

    //MODIFIES: this
    //EFFECTS: when PacMan touches a pellet, it will be set to a position outside the map.
    public void eatPellet(int posX, int posY) {
        for (int i = 0;  i < pellets.length; i++) {
            if (pellets[i][1] == posX
                    && pellets[i][0] == posY) {
                pellets[i][1] = 32;
                pellets[i][0] = 32;
                increaseScore();
                break;
            }
        }
    }

    //MODIFIES: this
    //EFFECTS: parses the score and pellets into json
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("score", score);
        json.put("pelletX", pelletXToJson());
        json.put("pelletY", pelletYToJson());
        return json;
    }

    //MODIFIES: this
    //EFFECTS: converts all the array values in pellet into position Json
    private JSONArray pelletXToJson() {
        JSONArray jsonArray = new JSONArray();
        for (int w = 0; w < pellets.length; w++) {
            jsonArray.put(pellets[w][1]);
        }
        return jsonArray;
    }

    //MODIFIES: this
    //EFFECTS: converts all the array values in pellet into position Json
    private JSONArray pelletYToJson() {
        JSONArray jsonArray = new JSONArray();
        for (int w = 0; w < pellets.length; w++) {
            jsonArray.put(pellets[w][0]);
        }
        return jsonArray;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int[][] getBackUp() {
        return backUp;
    }

    public int[][] getPellet() {
        return pellets;
    }


    public int getScore() {
        return score;
    }

}
