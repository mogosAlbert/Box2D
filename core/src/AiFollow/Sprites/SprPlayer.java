/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AiFollow.Sprites;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import AiFollow.Tools.GameEngine;
import com.badlogic.gdx.physics.box2d.World;


public final class SprPlayer extends Sprite {
    TextureAtlas atlas;
    Animation animation;
    boolean bFlip;
    public Vector2 vecLocation;
    GameEngine geMain;
    public SprPlayer(World wTemp){
        atlas = new TextureAtlas("run/megapack.pack");
        animation = new Animation(1/10f,atlas.getRegions());
        vecLocation = new Vector2(200, 300);
        geMain = new GameEngine();
        setSize(50, 50);
        geMain.createBody(wTemp, vecLocation, (int) getWidth(), (int) getHeight());
    }
    
    public void update(){
        setPosition(geMain.bTemp.getPosition().x, geMain.bTemp.getPosition().y);
    }
}
