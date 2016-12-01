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
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
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
    
    BodyDef bodDef;
    Body body;
    PolygonShape ps;
    FixtureDef fixDef;
    
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
        
        
        //Add box 2d
        bodDef = new BodyDef();
        bodDef.type = BodyType.DynamicBody;
        bodDef.position.set(getX(), getY());
        
        //Adding the bodyDef to the world
        body = world.createBody(bodDef);
        
        
        //Make a physics shape
        ps = new PolygonShape();
        ps.setAsBox(getWidth()/2, getHeight()/2);
        
        //Fixture is for physical properties
        fixDef = new FixtureDef();
        fixDef.shape = ps;
        fixDef.density = 1f;
        
        Fixture fixture = body.createFixture(fixDef);
        
    }
    
    //To draw and move
    public void update(){
       
        if(Gdx.input.isKeyPressed(Keys.UP)){
            body.applyAngularImpulse(50, true);
        } else if(Gdx.input.isKeyPressed(Keys.DOWN)){
            playerVec.y -= 10;
        } else if(Gdx.input.isKeyPressed(Keys.RIGHT)){
            playerVec.x += 10;
        } else if(Gdx.input.isKeyPressed(Keys.LEFT)){
            playerVec.x -= 10;
        }
        setX(playerVec.x);
        setY(playerVec.y);
        
        setPosition(body.getPosition().x, body.getPosition().y);
        batch.draw(animation.getKeyFrame(elapsedTime += Gdx.graphics.getDeltaTime(), true), getX(), getY());
        //this.setRegion(new Texture(Gdx.files.internal("run/0.png")));
        
       // batch.draw(this, getX(), getY());
    }

    
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
