package wxy189050131.beatbox;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

public class SoundViewModel extends BaseObservable {
    private Sound mSound;
    private  BeatBox mBeatBox;

    public SoundViewModel(BeatBox beatBox) {
        mBeatBox = beatBox;
    }

    public BeatBox getBeatBox() {
        return mBeatBox;
    }

    public void setBeatBox(BeatBox beatBox) {
        mBeatBox = beatBox;
    }

    @Bindable
    public Sound getSound() {
        return mSound;
    }

    @Bindable
    public String getTitle() {
        return mSound.getName();
    }

    @Bindable
    public String getSpeed() {
        String s = "播放速度: " + mBeatBox.getRate() + "%";
        return s;
    }



    public void setSound(Sound sound) {
        mSound = sound;
        //notifyChange();
        //单独通知
        notifyPropertyChanged(BR.sound);
    }

    public void onButtonClicked() {
        mBeatBox.play(mSound);
    }
}
