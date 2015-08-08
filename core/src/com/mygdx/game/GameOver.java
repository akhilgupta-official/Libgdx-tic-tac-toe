/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameOver implements Screen {
    SpriteBatch batch;
    OrthographicCamera camera;
    BitmapFont font;
    Stage stage;
    
    public GameOver(){
        camera=new OrthographicCamera();
        camera.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        stage=new Stage();
    }

    @Override
    public void show() {
        System.out.println("show");
    }

    @Override
    public void render(float f) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); 
        camera.update();
        
        stage.act(f);
        stage.draw();
        
        batch.setProjectionMatrix(camera.combined);
        System.out.println("before batch");
        batch.begin();
        font.draw(batch, "GAME OVER", 300, 300);
        
       // font.draw(batch, "Tap anywhere to begin!", 100, 100);
        batch.end();
        System.out.println("after batch");
        
       
        
    }

    @Override
    public void resize(int i, int i1) {
        System.out.println("resize");
    }

    @Override
    public void pause() {
        System.out.println("pause");
    }

    @Override
    public void resume() {
        System.out.println("resume");
    }

    @Override
    public void hide() {
        System.out.println("hide");
        render(Gdx.graphics.getDeltaTime());
        
       
        
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
    
}
