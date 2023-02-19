package model;

import java.util.ArrayList;

public class Map {
    private int[][] walls  = {
            {0,1}, {0,2},{0,3},{0,4},{0,5},{0,6},{0,7},{0,8},{0,9},{0,10},{0,11},{0,12},{0,13},{0,14},{0,15},{0,16},
            {0,17},{0,18},{0,19}, {1,1}, {1,10}, {1,19}, {2,1}, {2,3},{2,4},{2,5}, {2,7},{2,8}, {2,10}, {2,12},{2,13},
            {2,15},{2,16},{2,17},{2,19}, {3,1}, {3,3},{3,4},{3,5},{3,7},{3,8}, {3,10}, {3,12},{3,13}, {3,15},{3,16},
            {3,17},{3,19},{4,1}, {4,10}, {4,19}, {5,1},{5,3},{5,5},{5,6},{5,7},{5,8},{5,12},{3,12},{5,13},{5,14},{5,15},
            {5,17},{5,19}, {6,1},{6,3},{6,5},{6,6},{6,7},{6,8},{6,9},{6,11},{6,12},{6,13},{6,14},{6,15},{6,17},{6,19},
            {7,1},{7,3},{7,8},{7,12},{7,17},{7,19},{8,1},{8,3},{8,4},{8,5},{8,6},{8,8},{8,12},{8,14},{8,15},{8,16},
            {8,17},{8,19},{9,1},{9,3},{9,4},{9,5},{9,6},{9,8},{9,9},{9,10},{9,11},{9,12},{9,14},{9,15},{9,16},{9,17},
            {9,19},{10,1},{10,19},{11,1},{11,2},{11,3},{11,5},{11,6},{11,8},{11,9},{11,11},{11,12},{11,14},{11,15},
            {11,17},{11,18},{11,19}, {12,1},{12,2},{12,3},{12,5},{12,6},{12,8},{12,12},{12,14},{12,15},{12,17},{12,18},
            {12,19}, {13,1},{13,2},{13,3},{13,10},{13,17},{13,18},{13,19},{14,1},{14,2},{14,3},{14,4},{14,5},{14,6},
            {14,7},{14,8},{14,9},{14,10},{14,11},{14,12},{14,13},{14,14},{14,15},{14,16},{14,17},{14,18},{14,19},
    };


    public ArrayList<Position> makeMap() {
        ArrayList<Position> map = new ArrayList<>();
        for (int i = 0; i < walls.length; i++) {
            Position pixel = new Position(walls[i][1], walls[i][0]);
            map.add(pixel);
        }
        return map;
    }


    public int[][] getWalls() {
        return walls;
    }


}
