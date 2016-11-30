/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enemy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class charEnemy extends Sprite {
    World world;
    Vector2 playerVec;
    Vector2 enemyVec;
    SpriteBatch batch;
    
    TextureAtlas atlas;
    Animation animation;
    float elapsedTime = 0;
    
    public charEnemy(World world,Vector2 playerVec,Vector2 enemyVec,SpriteBatch batch){
        this.world = world;
        this.playerVec = playerVec;
        this.enemyVec = enemyVec;
        this.batch = batch;
        atlas = new TextureAtlas("run/megapack.pack");
        animation = new Animation(1/10f,atlas.getRegions());
        setX(enemyVec.x);
        setY(enemyVec.y);
        setSize(50,50);
    }
    
    public void update() {
        //Called to follow the ai
        setX(followAi(playerVec,enemyVec).x);
        setY(followAi(playerVec,enemyVec).y);
        batch.draw(animation.getKeyFrame(elapsedTime += Gdx.graphics.getDeltaTime(), true), getX(), getY());
    }
    
    public Vector2 followAi(Vector2 playerVec,Vector2 enemyVec){
        Vector2 tempVec = new Vector2(playerVec);
        tempVec.sub(enemyVec).nor();
        enemyVec.x += tempVec.x;
        enemyVec.y += tempVec.y;
        return enemyVec;
    }

//    @Override
//    public void draw(Batch batch){
//        super.draw(batch);
//    }

}
