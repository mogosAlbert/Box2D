/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AiFollow.Tools;

import AiFollow.BoxAi;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 *
 * @author mogoa7209
 */
public class GameEngine {
    
    public BodyDef createBodyDef(World wTemp, Vector2 vecLocation) {  
        BodyDef bdTemp = new BodyDef();
        bdTemp.position.set(vecLocation);
        bdTemp.type = BodyDef.BodyType.DynamicBody;
        return bdTemp;
    }
    
    public FixtureDef createFixtureDef(float fWidth, float fHeight, Vector2 vecLoc) {
        PolygonShape psTemp = new PolygonShape();
        psTemp.setAsBox(fWidth / 2, fHeight / 2, new Vector2(vecLoc.x / 2, vecLoc.y / 2), 0);
        FixtureDef fdMain = new FixtureDef();
        fdMain.shape = psTemp;
        return fdMain;
    }
    public void createFloor(World wTemp, float fWidth, float fHeight) {
        Body bodFloor;
        BodyDef bdTemp = new BodyDef();
        bdTemp.type = BodyDef.BodyType.StaticBody;
        bdTemp.position.set(0, (-fHeight / BoxAi.ppm) / 2 + 30 - 6);
        bodFloor = wTemp.createBody(bdTemp);
        PolygonShape psTemp = new PolygonShape();
        psTemp.setAsBox(fWidth, 30 / BoxAi.ppm, bdTemp.position, 0);
        FixtureDef fdMain = new FixtureDef();
        fdMain.shape = psTemp;
        bodFloor.createFixture(fdMain);
    }
}
