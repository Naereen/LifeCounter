package com.marceljurtz.lifecounter.Game;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;

import com.marceljurtz.lifecounter.R;

public class GameModel {

    private final Context context;
    private final SharedPreferences sPrefs;

    public static final int default_black = Color.parseColor("#CCC2C0");
    public static final int default_blue = Color.parseColor("#AAE0FA");
    public static final int default_green = Color.parseColor("#9BD3AE");
    public static final int default_red = Color.parseColor("#FAAA8F");
    public static final int default_white = Color.parseColor("#FFFCD6");

    public GameModel(Context context) {
        this.context = context;
        sPrefs = context.getSharedPreferences(context.getString(R.string.shared_preferences_name), Activity.MODE_PRIVATE);
    }

    static int lifepoints = 20;

    public int getColor(String colorString, int nullReturn) {
        return sPrefs.getInt(colorString, nullReturn);
    }
}
