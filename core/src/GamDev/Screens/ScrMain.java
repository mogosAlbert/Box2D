package GamDev.Screens;

import GamDev.Misc.tbButtonMain;
import GamDev.Misc.tbSkin;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ScrMain implements Screen {
    
    public tbButtonMain tbuStart;
    private Table tblMain;
    private Stage stgMain;
    private SpriteBatch sbMain;
    private Viewport vpMain;
    public ScrMain(SpriteBatch sb) {
        sbMain = sb;
        vpMain = new FitViewport(1000, 700, new OrthographicCamera());
        stgMain = new Stage(vpMain, sbMain);
        tblMain = new Table();
        tbuStart = new tbButtonMain("Start", new tbSkin());
        tbuStart.setBounds(20, 20, 70, 30);
    }
    @Override
    public void show() {
        tblMain.bottom();
        tblMain.add(tbuStart).padBottom(20);
        stgMain.addActor(tbuStart);
        Gdx.input.setInputProcessor(stgMain);
        
    }

    @Override
    public void render(float f) {
        stgMain.draw();
    }

    @Override
    public void resize(int i, int i1) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
    }  
}
