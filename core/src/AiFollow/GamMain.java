package AiFollow;

import AiFollow.Screens.ScrMain;
import com.badlogic.gdx.Game;

public class GamMain extends Game{

    @Override
    public void create() {
        setScreen(new ScrMain());
    }
    
    @Override
    public void resize(int Width, int Height) {
        super.resize(Width, Height);
    }
    
    @Override
    public void render() {
        super.render();
    }
    
    @Override
    public void dispose() {
        super.dispose();
    }
}
