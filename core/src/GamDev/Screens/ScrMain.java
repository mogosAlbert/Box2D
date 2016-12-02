package GamDev.Screens;

import GamDev.Misc.TbMain;
import GamDev.Misc.TbMainSkin;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ScrMain implements Screen {
    
    public TbMain tbuStart, tbuLevels;
    
    private Stage stgMain;
    private Table tblMain;
    private Label lblMain;
    private Viewport vpMain;
    
    public ScrMain() {
        vpMain = new FitViewport(1000, 700, new OrthographicCamera());
        stgMain = new Stage(vpMain, GamDev.GamDev.sbMain);
        tblMain = new Table();
        tbuStart = new TbMain("Start", new TbMainSkin());
        tbuLevels = new TbMain("Levels", new TbMainSkin());
        lblMain = new Label("Welcome!", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        lblMain.setFontScale(3);
        lblMain.setPosition(500, 500);
        tbuStart.setBounds(20, 20, 70, 30);
        tbuLevels.setBounds(800, 20, 70, 30);
    }
    @Override
    public void show() {
        stgMain.addActor(tbuStart);
        stgMain.addActor(tbuLevels);
        stgMain.addActor(lblMain);
        Gdx.input.setInputProcessor(stgMain);
    }

    @Override
    public void render(float f) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
        stgMain.dispose();
    }  
}
