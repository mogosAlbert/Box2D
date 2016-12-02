package AiFollow;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import AiFollow.Sprites.SprEnemy;
import AiFollow.Sprites.SprPlayer;

public class BoxAi extends Game {
	SpriteBatch batch;
        World wMain;
        SprPlayer sprPlayer;
        SprEnemy sprEnemy;
        
	
	@Override
	public void create () {
            wMain = new World(new Vector2(0,-2f), false);
            batch = new SpriteBatch();
            sprPlayer = new SprPlayer(wMain);
            sprEnemy = new SprEnemy();
            
	}
        
    
	@Override
	public void render () {
            super.render();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                wMain.step(Gdx.graphics.getDeltaTime(), 6, 2);
                batch.begin();
		sprPlayer.update();
                sprPlayer.draw(batch);
                batch.end();
	}
        
        
       
}
