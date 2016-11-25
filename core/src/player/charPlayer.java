/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class charPlayer extends Sprite {
    World world;
    Vector2 playerVec;
    Vector2 enemyVec;
    float angle;
    SpriteBatch batch;
    TextureAtlas atlas;
    Animation animation;
    float elapsedTime = 0;
    boolean bFlip;
    
    public charPlayer(World world, Vector2 playerVec,Vector2 enemyVec,SpriteBatch batch){
        this.world = world;
        this.playerVec = playerVec;
        this.enemyVec = enemyVec;
        this.batch = batch;
        atlas = new TextureAtlas("run/megapack.pack");
        animation = new Animation(1/8f,atlas.getRegions());
        setX(playerVec.x);
        setY(playerVec.y); 
        setSize(50, 50);
    }
    //To draw and move
    public void update(){
        elapsedTime += Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Keys.UP)){
            playerVec.y += 10;
        } else if(Gdx.input.isKeyPressed(Keys.DOWN)){
            playerVec.y -= 10;
        } else if(Gdx.input.isKeyPressed(Keys.RIGHT)){
            flipTheTextures(animation.getKeyFrames(),bFlip = false);
            playerVec.x += 10;
        } else if(Gdx.input.isKeyPressed(Keys.LEFT)){
            flipTheTextures(animation.getKeyFrames(),bFlip = true);
            playerVec.x -= 10;
        }
        setX(playerVec.x);
        setY(playerVec.y);
        batch.draw(animation.getKeyFrame(elapsedTime,true), getX(), getY());
    
        
    }
    
    public void flipTheTextures(TextureRegion regions[],boolean bFlip){
        //loop through the regions
        for(int i = 0;i<regions.length;i++){
            animation.getKeyFrames()[i].flip(bFlip, false);
        }
        
        
    }
           
}
