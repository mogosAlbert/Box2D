package GamDev.Misc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
public class hudMain {
    public  TbMain tbPause;
    public Stage stgMain;
    public int nTime;
    private Table tblMain;
    private Label lblMain;
    private Label lblScore;
    private Label lblTime;
    private Label lblCTime;
    private Label lblCScore;
    private Label lblCWorld;
    private int nScore, nCounter;
    private Viewport Vp;
    
    public hudMain(SpriteBatch Sb) {
        nTime = 300;
        nScore = 0;
        Vp = new FitViewport(1000,700, new OrthographicCamera());
        stgMain = new Stage(Vp, Sb);
        tblMain = new Table();
        tblMain.top();
        tblMain.setFillParent(true);
        lblMain = new Label("World", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        lblScore = new Label("Score", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        lblTime = new Label("Time", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        lblCWorld = new Label("1-1", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        tbPause = new TbMain ("", new TbPauseSkin());
        tbPause.setBounds(20, Gdx.graphics.getHeight() - 90, 70, 20);
        stgMain.addActor(tbPause);
        Gdx.input.setInputProcessor(stgMain);
    }
    public void draw() {
        nCounter++;
        if(nCounter % 60 == 0) {
            nTime--;
        }
        lblCTime = new Label(String.format("%03d", nTime), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        lblCScore = new Label(String.format("%06d", nScore), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        tblMain.reset();
        tblMain.top();
        tblMain.add(lblMain).expandX().padTop(20);
        tblMain.add(lblScore).expandX().padTop(20);
        tblMain.add(lblTime).expandX().padTop(20);
        tblMain.row();
        tblMain.add(lblCWorld).expandX();
        tblMain.add(lblCScore).expandX();
        tblMain.add(lblCTime).expandX();
        stgMain.addActor(tblMain);
        stgMain.draw();
    }
}
