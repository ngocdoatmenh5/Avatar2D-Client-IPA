package javax.microedition.media;

public interface VolumeControl extends Control {
    int setLevel(int level);
    int getLevel();
    void setMute(boolean mute);
    boolean isMuted();
}
