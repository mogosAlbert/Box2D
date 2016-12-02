/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AiFollow.Tools;

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
    public Body bTemp;
    public GameEngine() {
        
    }
    public void createBody(World wTemp, Vector2 vecLocation, int nWidth, int nHeight) {
        PolygonShape psTemp = new PolygonShape();
        psTemp.setAsBox(nWidth, nHeight);
        FixtureDef fdMain = new FixtureDef();
        fdMain.shape = psTemp;
        BodyDef bdTemp = new BodyDef();
        bdTemp.position.set(vecLocation);
        bdTemp.type =BodyDef.BodyType.DynamicBody;
        bTemp = wTemp.createBody(bdTemp);
        bTemp.createFixture(fdMain);
    }
}
