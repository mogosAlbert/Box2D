/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AiFollow.Sprites;

import AiFollow.BoxAi;
import AiFollow.Tools.GameEngine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

public class SprEnemy extends Sprite {

    TextureAtlas atlas;
    Animation animation;
    Vector2 vecLocation;
    Vector2 vecNLocation;
    boolean isFlip;
    Body bMain;
    GameEngine GE;

    public SprEnemy(World wTemp) {
        GE = new GameEngine();
        atlas = new TextureAtlas("run/megapack.pack");
        animation = new Animation(1 / 10f, atlas.getRegions());
        vecLocation = new Vector2(500 / BoxAi.ppm, 300 / BoxAi.ppm);
        setSize(50 / BoxAi.ppm, 50 / BoxAi.ppm);
        bMain = wTemp.createBody(GE.createBodyDef(wTemp, vecLocation));
        bMain.createFixture(GE.createFixtureDef(getWidth(), getHeight(), bMain.getLocalCenter()));
    }

    @Override
    public void draw(Batch bMain) {
        super.draw(bMain);
    }

    public void update(Vector2 playerVec) {
        vecNLocation = followAi(playerVec, vecLocation);
        if (vecNLocation.x < getX()) {
            isFlip = true;
        } else if (vecNLocation.x > getX()) {
            isFlip = false;
        }
        bMain.setTransform(new Vector2(vecLocation.x, bMain.getPosition().y), 0);
        setPosition(vecNLocation.x - getWidth() / 2, bMain.getPosition().y - getHeight() / 2);
        setRegion(getRegion(animation, isFlip));
    }

    public Vector2 followAi(Vector2 playerVec, Vector2 enemyVec) {
        Vector2 tempVec = playerVec;
        tempVec.sub(enemyVec).nor();
        enemyVec.x += tempVec.x / BoxAi.ppm;
        return enemyVec;
    }

    public TextureRegion getRegion(Animation aniTemp, boolean isFlip) {
        TextureRegion texTemp;
        texTemp = aniTemp.getKeyFrame(Gdx.graphics.getDeltaTime(), true);
        if (isFlip && !texTemp.isFlipX()) {
            texTemp.flip(true, false);
        } else if (!isFlip && texTemp.isFlipX()) {
            texTemp.flip(true, false);
        }
        return texTemp;
    }
}
