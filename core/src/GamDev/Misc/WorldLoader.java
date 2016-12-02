package GamDev.Misc;

import GamDev.GamDev;
import GamDev.Screens.ScrGame;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class WorldLoader {

    public WorldLoader(ScrGame scrMain, int nStaticLayers, int nStartingObjLayer, TiledMap tilMap1) {
        World wor1 = scrMain.worlMain;
        TiledMap tilmap1 = tilMap1;
        BodyDef bdefMain = new BodyDef();
        PolygonShape psMain = new PolygonShape();
        FixtureDef fixdefMain = new FixtureDef();
        Body bodMain;
        float fricSet = 0.01f;
        nStaticLayers += nStartingObjLayer;
        for (int i = nStartingObjLayer; i < nStaticLayers; i++) {
            for (MapObject mapobMain : tilmap1.getLayers().get(i).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rectObject = ((RectangleMapObject) mapobMain).getRectangle();
                bdefMain.type = BodyDef.BodyType.StaticBody;
                bdefMain.position.set((rectObject.getX() + rectObject.width / 2) / GamDev.ppm, (rectObject.getY() + rectObject.height / 2) / GamDev.ppm);
                bodMain = wor1.createBody(bdefMain);
                psMain.setAsBox(rectObject.getWidth() / 2 / GamDev.ppm, rectObject.getHeight() / 2 / GamDev.ppm);
                fixdefMain.shape = psMain;
                bodMain.createFixture(fixdefMain);
            }
        }
    }
}
