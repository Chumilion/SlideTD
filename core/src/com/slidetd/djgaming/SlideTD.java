package com.slidetd.djgaming;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.slidetd.djgaming.handler.Content;
import com.slidetd.djgaming.states.GSM;
import com.slidetd.djgaming.states.MenuState;
import com.slidetd.djgaming.states.PlayState;
public class SlideTD extends ApplicationAdapter {
  SpriteBatch batch;
  Texture img;
  public static final String TITLE = "SlideTD";
  public static final int WIDTH = 480;
  public static final int HEIGHT = 800;
  public static Content res;
  private GSM gsm;
  @Override
  public void create() {
    Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
    res = new Content();
    res.loadAtlas("kate6x6.pack", "kate6x6");
    res.loadAtlas("kate3x3.pack", "kate3x3");
    res.loadAtlas("buttons.pack", "buttons");
    batch = new SpriteBatch();
    gsm = new GSM();
//    gsm.push(new PlayState(gsm));
    gsm.push(new MenuState(gsm));
  }
  @Override
  public void render() {
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    gsm.update(Gdx.graphics.getDeltaTime());
    gsm.render(batch);
  }
}
