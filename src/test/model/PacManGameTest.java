package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PacManGameTest {
    private PacManGame game;
    private ArrayList<Ghost> listOfGhost;
    private PacMan pacMan;

    @BeforeEach
    void runBefore() {
        game = new PacManGame();
        listOfGhost = game.getListOfGhost();
        pacMan = game.getPacMan();
    }

    @Test
    void isPelletTest() {
        assertTrue(game.isPellet());
        game.tick();
        assertFalse(game.isPellet());
        assertFalse(game.noMorePellets());
        assertNotEquals(32,game.getPellets().getMap().get(0).getPosX());
        assertNotEquals(32,game.getPellets().getMap().get(0).getPosY());
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                game.getPellets().eatPellet(i,j);
            }
        }
        assertEquals(32,game.getPellets().getMap().get(0).getPosX());
        assertEquals(32,game.getPellets().getMap().get(3).getPosX());
        assertEquals(32,game.getPellets().getMap().get(3).getPosY());
        assertEquals(32,game.getPellets().getMap().get(14).getPosX());
        assertEquals(32,game.getPellets().getMap().get(14).getPosY());
        game.tick();
        assertTrue(game.noMorePellets());
        assertTrue(game.isEnded());


    }


    @Test
    void collisionWithGhostTest() {
        for (int i = 0; i < listOfGhost.size(); i++) {
            listOfGhost.get(i).setPos(5,5);
            pacMan.setBody(5,5);
            listOfGhost.get(i).setLastBody(5,4);
            pacMan.setLastBody(6,5);
            assertTrue(game.hasCollidedWithGhost());
            game.tick();
            if(game.hasCollidedWithGhost()) {
                assertTrue(game.isEnded());
            }
            game.tick();
            if(game.hasCollidedWithGhost()) {
                assertTrue(game.isEnded());
            }
            game.tick();
            if(game.hasCollidedWithGhost()) {
                assertTrue(game.isEnded());
            }
            game.tick();
            if(game.hasCollidedWithGhost()) {
                assertTrue(game.isEnded());
            }
            game.tick();
            if(game.hasCollidedWithGhost()) {
                assertTrue(game.isEnded());
            }
            game.tick();
            if(game.hasCollidedWithGhost()) {
                assertTrue(game.isEnded());
            }
            game.tick();
            if(game.hasCollidedWithGhost()) {
                assertTrue(game.isEnded());
            }

            listOfGhost.get(i).setPos(5,5);
            pacMan.setBody(5,4);
            listOfGhost.get(i).setLastBody(6,5);
            pacMan.setLastBody(5,5);
            assertTrue(game.hasCollidedWithGhost());
            listOfGhost.get(i).setPos(5,6);
            pacMan.setBody(5,5);
            listOfGhost.get(i).setLastBody(5,5);
            pacMan.setLastBody(4,5);
            assertTrue(game.hasCollidedWithGhost());
            listOfGhost.get(i).setPos(9,7);
            pacMan.setBody(5,4);
            listOfGhost.get(i).setLastBody(8,7);
            pacMan.setLastBody(4,4);
            assertFalse(game.hasCollidedWithGhost());
        }

    }


    @Test
    void gettersTest() {
        for (int i = 0; i < listOfGhost.size(); i++) {
            assertEquals(new Ghost().getPos().getPosX(), listOfGhost.get(i).getPos().getPosX());
            assertEquals(new Ghost().getPos().getPosY(), listOfGhost.get(i).getPos().getPosY());
        }
        assertEquals(new PacMan().getPos().getPosX(), game.getPacMan().getPos().getPosX());
        assertEquals(new PacMan().getPos().getPosY(), game.getPacMan().getPos().getPosY());
        assertEquals(4, game.getTickPerSec());
        assertEquals(165,game.getMap().makeMap().size());
        assertEquals(111,game.getPellets().makePellets().size());
    }

}