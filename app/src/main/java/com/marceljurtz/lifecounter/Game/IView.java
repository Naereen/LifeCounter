package com.marceljurtz.lifecounter.Game;

import android.graphics.Color;

import com.marceljurtz.lifecounter.Helper.MagicColor;
import com.marceljurtz.lifecounter.Helper.PlayerID;

public interface IView {
    /*
    void initColorButtonBlack(int color);
    void initColorButtonBlue(int color);
    void initColorButtonGreen(int color);
    void initColorButtonRed(int color);
    void initColorButtonWhite(int color);
    */
    void initColorButton(MagicColor colorLocation, int color);
    void setLayoutColor(PlayerID playerID, int color);
    void setPlayerLayoutBackgroundColor(PlayerID playerID, int color);
    void setLifepoints(PlayerID id, String points);
    void setPoisonpoints(PlayerID id, String points);
    void enableEnergySaving();
    void disableEnergySaving();
    void loadSettingsActivity();
}
