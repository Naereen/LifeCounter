package com.marceljurtz.lifecounter.About;

import android.content.SharedPreferences;

import com.marceljurtz.lifecounter.Helper.BaseInterface.IView;

public interface IAboutView extends IView {
    void loadAboutPage(String url);
    void startGameActivity();
    void startSettingsActivity();
    void startDicingActivity();
    SharedPreferences getPreferences();
}
