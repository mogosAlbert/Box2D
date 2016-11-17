package GamDev;

import com.badlogic.gdx.Game;
import GamDev.Screens.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class GamDev extends Game {

    public static float ppt = 16;
    public static SpriteBatch sbMain;
    private ScrMain scrMain;
    private ScrGame scrGame;
    private ScrLevels scrLevels;

    @Override
    public void create() {
        sbMain = new SpriteBatch();
        scrMain = new ScrMain();
        scrLevels = new ScrLevels();
        setScreen(scrMain);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void render() {
        super.render();
        if (scrMain.tbuStart.isPressed()) {
            scrMain.dispose();
            setScreen(new ScrGame());
        }
        if (scrMain.tbuLevels.isPressed()) {
            scrMain.dispose();
            setScreen(new ScrLevels());
        }
        if (scrLevels.tbuBack.isPressed()) {
            scrLevels.dispose();
            setScreen(new ScrMain());
        }
        if (scrLevels.tbuStart.isPressed()) {
            scrLevels.dispose();
            setScreen(new ScrGame());
        }
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.render();
    }
    public void toGame() {
        
    }
}
