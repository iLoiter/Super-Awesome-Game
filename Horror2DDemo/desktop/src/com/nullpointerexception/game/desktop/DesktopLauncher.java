package com.nullpointerexception.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.nullpointerexception.game.Horror2DDemo;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height =1080;
		config.width = 1920;
		config.vSyncEnabled = true;
		config.useGL30 = true;
		new LwjglApplication(new Horror2DDemo(), config);
	}
}
