package AiFollow;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import AiFollow.Sprites.SprEnemy;
import AiFollow.Sprites.SprPlayer;
import AiFollow.Tools.GameEngine;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class BoxAi extends Game {

    public static int ppm = 16;
    OrthographicCamera ocMain;
    Viewport vpMain;
    Box2DDebugRenderer B2DR;
    SpriteBatch batch;
    World wMain;
    SprPlayer sprPlayer;
    SprEnemy sprEnemy;
    GameEngine GE;

    @Override
    public void create() {
        GE = new GameEngine();
        B2DR = new Box2DDebugRenderer();
        ocMain = new OrthographicCamera();
        vpMain = new FitViewport(1000 / ppm, 600 / ppm, ocMain);
        wMain = new World(new Vector2(0, -2f), false);
        batch = new SpriteBatch();
        sprPlayer = new SprPlayer(wMain);
        sprEnemy = new SprEnemy(wMain);
    }

    @Override
    public void resize(int Width, int Height) {
        super.resize(Width, Height);
        GE.createFloor(wMain, Width, Height);
        ocMain.viewportWidth = Width / ppm;
        ocMain.viewportHeight = Height / ppm;
        ocMain.position.x = ocMain.viewportWidth / ppm / 2;
        ocMain.position.y = ocMain.viewportHeight  / ppm / 2;
        ocMain.update();
    }

    @Override
    public void render() {
        super.render();
        input();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        wMain.step(Gdx.graphics.getDeltaTime(), 6, 2);
        batch.getProjectionMatrix().set(ocMain.combined);
        sprEnemy.update(sprPlayer.vecLocation);
        batch.begin();
        sprEnemy.draw(batch);
        sprPlayer.draw(batch);
        batch.end();
        B2DR.render(wMain, ocMain.combined);
    }
    
    public void input() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            sprPlayer.bMain.applyForce(new Vector2( -6f, 0), sprPlayer.bMain.getLocalCenter(), true);
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            sprPlayer.bMain.applyForce(new Vector2( 6f, 0), sprPlayer.bMain.getLocalCenter(), true);
        }
    }
}
