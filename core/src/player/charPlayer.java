/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;


public final class charPlayer extends Sprite {
    World world;
    Vector2 playerVec;
    Vector2 enemyVec;
    float angle;
    SpriteBatch batch;
    TextureAtlas atlas;
    Animation animation;
    float elapsedTime = 0,elapsedTimeX = 0;
    boolean bFlip;
 
    Texture[] playerTex;
    
    public charPlayer(World world, Vector2 playerVec,Vector2 enemyVec,SpriteBatch batch){
        this.world = world;
        this.playerVec = playerVec;
        this.enemyVec = enemyVec;
        this.batch = batch;
        atlas = new TextureAtlas("run/megapack.pack");
        animation = new Animation(1/10f,atlas.getRegions());
       // animation = loadTheTextures(atlas,"Run",9,10);
        setX(playerVec.x);
        setY(playerVec.y); 
        setSize(50, 50);
    }
    
    //To draw and move
    public void update(){
        if(Gdx.input.isKeyPressed(Keys.UP)){
            playerVec.y += 10;
        } else if(Gdx.input.isKeyPressed(Keys.DOWN)){
            playerVec.y -= 10;
        } else if(Gdx.input.isKeyPressed(Keys.RIGHT)){
            playerVec.x += 10;
        } else if(Gdx.input.isKeyPressed(Keys.LEFT)){
            playerVec.x -= 10;
        }
        setX(playerVec.x);
        setY(playerVec.y);
        
//        setRegion(animation.getKeyFrame(elapsedTime += Gdx.graphics.getDeltaTime(), true));
        batch.draw(animation.getKeyFrame(elapsedTime += Gdx.graphics.getDeltaTime(), true), getX(), getY());
    }
    //Drawing whatever the region is
//    @Override
//    public void draw(Batch batch){
//        super.draw(batch);
//    }
    
    
    public Animation loadTheTextures(TextureAtlas atlas,String sFile,int length,float fSpeed){
        Animation ani;
        Array<TextureRegion> arrList = new Array<TextureRegion>();
        for(int i = 0;i<length;i++){
            arrList.add(atlas.findRegion(sFile + i));  
        }
        ani = new Animation(fSpeed,arrList);
        return ani;
    }     
}
