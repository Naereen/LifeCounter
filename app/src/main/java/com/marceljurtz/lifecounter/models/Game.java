package com.marceljurtz.lifecounter.models;

import android.content.SharedPreferences;

import com.marceljurtz.lifecounter.enums.ClickTypeEnum;
import com.marceljurtz.lifecounter.enums.OperatorEnum;
import com.marceljurtz.lifecounter.enums.PlayerIdEnum;

public class Game {

    private SharedPreferences preferences;

    private final int DEFAULT_POISONPOINTS = 0;
    private final int DEFAULT_LIFEPOINTS = 20;
    private int customLifepoints;

    private Player[] players;

    public Game(SharedPreferences preferences, Player[] players) {
        this.preferences = preferences;
        this.players = players;

        startGame();
    }

    public void saveGameState(SharedPreferences preferences) {
        if(players.length == 4) {
            PreferenceManager.save4PlayerPointsData(preferences, players);
        } else {
            PreferenceManager.save2PlayerPointsData(preferences, players);
        }
    }

    public void loadGameState(SharedPreferences preferences, int playeramount) {
        if(playeramount == 4) {
            players = PreferenceManager.load4PlayerPointsData(preferences);
        } else {
            players = PreferenceManager.load2PlayerPointsData(preferences);
        }
    }

    public Player[] getPlayers() {
        return players;
    }

    static int lifepoints = 20;

    public int getColor(String colorString, int nullReturn) {
        return preferences.getInt(colorString, nullReturn);
    }

    public void startGame() {
        int lifepoints = PreferenceManager.getDefaultLifepoints(preferences);
        if(lifepoints == 0) {
            lifepoints = DEFAULT_LIFEPOINTS;
        }
    }

    public void updateLifepoints(PlayerIdEnum playerIdEnum, ClickTypeEnum clickTypeEnum, OperatorEnum operatorEnum) {

        int amount = PreferenceManager.getDefaultShortclickPoints();
        if(clickTypeEnum.equals(ClickTypeEnum.LONG)) amount = PreferenceManager.getLongclickPoints(preferences);

        if(operatorEnum.equals(OperatorEnum.SUBSTRACT)) amount *= -1;

        switch(playerIdEnum) {
            case ONE:
                players[0].updateLifepoints(amount);
                break;
            case TWO:
                players[1].updateLifepoints(amount);
                break;
            case THREE:
                players[2].updateLifepoints(amount);
                break;
            case FOUR:
                players[3].updateLifepoints(amount);
                break;
            default:
                // Nothing to do
                break;
        }
    }

    public void updatePoisonpoints(PlayerIdEnum playerIdEnum, ClickTypeEnum clickTypeEnum, OperatorEnum operatorEnum) {

        int amount = PreferenceManager.getDefaultShortclickPoints();
        if(clickTypeEnum.equals(ClickTypeEnum.LONG)) amount = PreferenceManager.getLongclickPoints(preferences);

        if(operatorEnum.equals(OperatorEnum.SUBSTRACT)) amount *= -1;

        switch(playerIdEnum) {
            case ONE:
                players[0].updatePoisonpoints(amount);
                break;
            case TWO:
                players[1].updatePoisonpoints(amount);
                break;
            case THREE:
                players[2].updatePoisonpoints(amount);
                break;
            case FOUR:
                players[3].updatePoisonpoints(amount);
                break;
            default:
                // Nothing to do
                break;
        }
    }

    public int getPlayerLifepoints(PlayerIdEnum playerIdEnum) {
        switch(playerIdEnum) {
            case ONE :
                return players[0].getLifePoints();
            case TWO:
                return players[1].getLifePoints();
            case THREE:
                return players[2].getLifePoints();
            case FOUR:
                return players[3].getLifePoints();
            default:
                return 0;
        }
    }

    public int getPlayerPoisonpoints(PlayerIdEnum playerIdEnum) {
        switch(playerIdEnum) {
            case ONE :
                return players[0].getPoisonPoints();
            case TWO:
                return players[1].getPoisonPoints();
            case THREE:
                return players[2].getPoisonPoints();
            case FOUR:
                return players[3].getPoisonPoints();
            default:
                return 0;
        }
    }
}