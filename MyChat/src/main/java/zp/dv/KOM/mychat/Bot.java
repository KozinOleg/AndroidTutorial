package zp.dv.KOM.mychat;

import android.graphics.Color;
import android.provider.CalendarContract;

import java.util.Date;
import java.util.Random;

public class Bot {
    private int mColor = Color.BLUE;
    private String mBotName = "Bot";
    private String[] mBotSentence = {"Да", "Нет", "Возможно", "Я не уверен", "Так точно", "Ты тоже?",
            "Возможно ты прав!", "Я здесь"};
    private Random mRandom = new Random();

    public Bot() {
    }

    public Bot(String name, int color) {
        this.mBotName = name;
        this.mColor = color;
    }

    public int getColor() {
        return mColor;
    }

    public String getBotName() {
        return mBotName;
    }

    public void setBotName(String mBotName) {
        this.mBotName = mBotName;
    }

    public String genBotMessage() {
        return mBotSentence[mRandom.nextInt(mBotSentence.length)];
    }
}
