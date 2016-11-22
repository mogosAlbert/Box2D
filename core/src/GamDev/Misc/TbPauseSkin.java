package GamDev.Misc;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class TbPauseSkin extends TextButton.TextButtonStyle {
     private Skin skMain = new Skin();
     private TextureAtlas taMain;
     
     public TbPauseSkin() {
         BitmapFont bmfMain = new BitmapFont();
         skMain.add("default", bmfMain);
         taMain = new TextureAtlas("Misc/Buttons.pack");
         skMain.addRegions(taMain);
         this.up = skMain.getDrawable("ButtonPUp");
         this.down = skMain.getDrawable("ButtonPDown");
         this.checked = skMain.getDrawable("ButtonPUp");
         this.font = bmfMain;
     }
}
