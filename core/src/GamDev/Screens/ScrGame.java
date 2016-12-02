package GamDev.Screens;

import GamDev.Misc.hudMain;
import GamDev.Misc.WorldLoader;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import GamDev.Sprites.SprMain;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ScrGame implements Screen {

    private TiledMap Map1;
    private OrthogonalTiledMapRenderer MapRender;
    private OrthographicCamera MapCam;
    private Viewport Vp;
    private float fChangeX = 0;
    private SprMain Spr1;
    public hudMain hudMain;
    public World worlMain;
    private WorldLoader B2World1;
    private Box2DDebugRenderer B2DR;
    private BodyDef bdWolv;
    private Body bWolv;
    private FixtureDef fdWolv;

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        MapRender.setView(MapCam);
        Input();
        worlMain.step(delta, 6, 2);
        MapCam.translate(fChangeX, 0);
        MapCam.update();
        MapRender.render();
        MapRender.getBatch().begin();
        Spr1.draw(MapRender.getBatch());
        MapRender.getBatch().end();
        hudMain.draw();
        //B2DR.render(worlMain, MapCam.combined);
    }

    @Override
    public void resize(int width, int height) {
        MapCam.viewportHeight = height/ GamDev.GamDev.ppm;
        MapCam.viewportWidth = width / GamDev.GamDev.ppm;
        MapCam.position.x = MapCam.viewportWidth / 2;
        MapCam.position.y = MapCam.viewportHeight / 2;
        MapCam.update();
    }

    @Override
    public void show() {
        Map1 = new TmxMapLoader().load("Maps/map1.tmx");
        MapRender = new OrthogonalTiledMapRenderer(Map1, 1 / GamDev.GamDev.ppm);
        worlMain = new World(new Vector2(0, -10), true);
        MapCam = new OrthographicCamera();
        Vp = new FitViewport(1000 / GamDev.GamDev.ppm, 700 / GamDev.GamDev.ppm, MapCam);
        Spr1 = new SprMain(this, 300 / GamDev.GamDev.ppm, 200 / GamDev.GamDev.ppm);
        hudMain = new hudMain(GamDev.GamDev.sbMain);
        B2DR = new Box2DDebugRenderer();
        B2World1 = new WorldLoader(this, 3, 4, Map1);
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }

    public TiledMap getMap() {
        return Map1;
    }

    public void Input() {
        if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT) && Spr1.bodMain.getLinearVelocity().x > -40f) {
            Spr1.bodMain.applyForce(new Vector2(-10f, 0), Spr1.bodMain.getWorldCenter(), true);
        } else if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT) && Spr1.bodMain.getLinearVelocity().x < 40f) {
            Spr1.bodMain.applyForce(new Vector2(10f, 0), Spr1.bodMain.getWorldCenter(), true);
        } else {
            Spr1.bodMain.setLinearVelocity(new Vector2(0, Spr1.bodMain.getLinearVelocity().y));
        }
    }
}
