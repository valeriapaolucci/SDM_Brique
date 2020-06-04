package BriqueTest;

import Logic.Settings;
import org.junit.Test;
import org.junit.Assert;

import java.awt.*;


class SettingsTest {

    @Test
    void getResolution() {
        Assert.assertEquals(Settings.getResolution(), new Dimension(720, 720));
    }

    @Test
    void setResolution() {
        Settings.setResolution(0);
        Assert.assertEquals(Settings.getResolution(), new Dimension(480, 480));
    }

    @Test
    void toDimension() {
        Assert.assertEquals(new Dimension(720, 720), Settings.toDimension("720x720"));
    }
}
