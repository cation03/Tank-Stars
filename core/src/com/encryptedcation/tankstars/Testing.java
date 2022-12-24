package com.encryptedcation.tankstars;
import com.encryptedcation.tankstars.screens.InGameScreen;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Testing {

    @Test
    public void testPlayer1(InGameScreen inGameScreen) {
        Player player = inGameScreen.getPlayer1();
        assertEquals(player.getId(), 1);
        assert player.getTank() != null;
        assert player.getHealth() <= 100;
        assert player.getHealth() > 0;
    }

    @Test
    public void testPlayer2(InGameScreen inGameScreen) {
        Player player = inGameScreen.getPlayer2();
        assertEquals(player.getId(), 1);
        assert player.getTank() != null;
        assert player.getHealth() <= 100;
        assert player.getHealth() > 0;
    }

    @Test
    public void testTank(InGameScreen inGameScreen) {
        Tank tank1 = inGameScreen.getPlayer1().getTank();
        Tank tank2 = inGameScreen.getPlayer2().getTank();
        assert tank1 != tank2;
        assert tank1.getFuel() <= 100;
        assert tank1.getFuel() > 0;
        assert tank2.getFuel() <= 100;
        assert tank2.getFuel() > 0;
    }

    // test that both the players are not null
    @Test
    public void testPlayers(InGameScreen inGameScreen) {
        Player player1 = inGameScreen.getPlayer1();
        Player player2 = inGameScreen.getPlayer2();
        assert player1 != null;
        assert player2 != null;
    }
}
