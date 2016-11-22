package GamDev;

import com.badlogic.gdx.Game;
import GamDev.Screens.*;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class GamDev extends Game {

    public static float ppt = 16;
    public static SpriteBatch sbMain;
    private ScrMain scrMain;
    private ScrGame scrGame;
    private ScrLevels scrLevels;
    Screen scrTemp;

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
        if(this.getScreen() == scrMain) {
            System.out.println("check");
            if (scrMain.tbuLevels.isPressed()) {
                this.getScreen().dispose();
                scrLevels = new ScrLevels();
                setScreen(scrLevels);
            } else if (scrMain.tbuStart.isPressed()){
                this.getScreen().dispose();
                scrGame = new ScrGame();
                setScreen(scrGame);
            }
        } else if (this.getScreen() == scrLevels) {
            if(scrLevels.tbuStart.isPressed()) {
                this.getScreen().dispose();
                scrGame = new ScrGame();
                setScreen(scrGame);
            } else if(scrLevels.tbuBack.isPressed()) {
                this.getScreen().dispose();
                scrMain = new ScrMain();
                setScreen(scrMain);
            }
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
