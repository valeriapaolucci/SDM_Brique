package BriqueTest;

import Data.Settings;
import org.junit.Test;
import org.junit.Assert;

import java.awt.*;


public class SettingsTest {

    @Test
    public void getResolution() {
        Assert.assertEquals(new Dimension(480, 480),Settings.getResolution());
    }

    @Test
    public void setResolution() {
        Settings.setResolution(0);
        Assert.assertEquals(new Dimension(480, 480),Settings.getResolution());
    }

    @Test
    public void toDimension() {
        Assert.assertEquals(new Dimension(720, 720), Settings.toDimension("720x720"));
    }
}
