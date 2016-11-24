/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;


public class charPlayer extends Sprite {
    World world;
    Vector2 playerVec;
    Vector2 enemyVec;
    float angle;
    SpriteBatch batch;
    public charPlayer(World world, Vector2 playerVec,Vector2 enemyVec,SpriteBatch batch){
        this.world = world;
        this.playerVec = playerVec;
        this.enemyVec = enemyVec;
        this.batch = batch;
        setX(playerVec.x);
        setY(playerVec.y); 
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
        setRegion();
        
        
    }
           
}
