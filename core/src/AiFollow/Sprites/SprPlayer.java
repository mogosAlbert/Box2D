/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AiFollow.Sprites;

import AiFollow.BoxAi;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import AiFollow.Tools.GameEngine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;


public final class SprPlayer extends Sprite {
    
    TextureAtlas atlas;
    Animation animation;
    GameEngine GE;
    boolean bFlip;
    public Vector2 vecLocation;
    public Body bMain;
    
    public SprPlayer(World wTemp){
        atlas = new TextureAtlas("run/megapack.pack");
        animation = new Animation(10f,atlas.getRegions());
        vecLocation = new Vector2(200 / BoxAi.ppm, 300 / BoxAi.ppm);
        setSize(50 / BoxAi.ppm, 50 / BoxAi.ppm);
        GE = new GameEngine();
        bMain = wTemp.createBody(GE.createBodyDef(wTemp, vecLocation));
        bMain.createFixture(GE.createFixtureDef(getWidth(), getHeight(), bMain.getLocalCenter()));
    }
    
    public void update(){
        vecLocation = bMain.getPosition();
        setPosition(vecLocation.x - getWidth() / 2, vecLocation.y  - getHeight() / 2);
        setRegion(animation.getKeyFrame(Gdx.graphics.getDeltaTime(), true));
    }
    
    @Override
    public void draw(Batch sbMain) {
        update();
        super.draw(sbMain);
    }
}
