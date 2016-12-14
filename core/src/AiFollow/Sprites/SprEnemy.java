/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AiFollow.Sprites;

import AiFollow.Screens.ScrMain;
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
        vecLocation = new Vector2(500 / ScrMain.ppm, 300 / ScrMain.ppm);
        setSize(30 / ScrMain.ppm, 30 / ScrMain.ppm);
        bMain = wTemp.createBody(GE.createBodyDef(wTemp, vecLocation));
        bMain.createFixture(GE.createFixtureDef(getWidth(), getHeight(), bMain.getLocalCenter()));
    }

    @Override
    public void draw(Batch bMain) {
        super.draw(bMain);
    }

    public void update(Vector2 playerVec) {
        followAi(playerVec);
        setPosition(bMain.getPosition().x - getWidth() / 2, bMain.getPosition().y - getHeight() / 2);
        setRegion(animation.getKeyFrame(Gdx.graphics.getDeltaTime()));
    }

    public void followAi(Vector2 playerVec) {
        int nChange = 0;
        int nSpeed = 5;
        System.out.println(Math.abs(playerVec.x * ScrMain.ppm - getX() * ScrMain.ppm));
        if(Math.abs(playerVec.x * ScrMain.ppm - getX() * ScrMain.ppm) < 200) {
            if(playerVec.x > getX()) {
                bMain.applyForce(new Vector2(nSpeed, 0), bMain.getLocalCenter(), true);
            } else if (playerVec.x < getX()) {
                bMain.applyForce(new Vector2(nSpeed * -1, 0), bMain.getLocalCenter(), true);
            }
        }
    }
}
