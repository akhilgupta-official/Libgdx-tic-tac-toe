package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class GameWorking extends Game{
	SpriteBatch batch;
	Texture img;
        Sprite board;
        int count,i=0;
        OrthographicCamera camera;
        int[] boardEntry;
        int flag;

        boolean flagcross1=false,flagcross2=false,flagcross3=false,flagcross4=false,flagcross5=false;
        boolean flagcircle1=false,flagcircle2=false,flagcircle3=false,flagcircle4=false;
        
        Texture imgcross1,imgcross2,imgcross3,imgcross4,imgcross5;
        Texture imgcircle1,imgcircle2,imgcircle3,imgcircle4;
        Sprite cross1,cross2,cross3,cross4,cross5;
        Sprite circle1,circle2,circle3,circle4;
        
        Texture imgwon,imglost,imgover;
        Sprite gamewon,gamelost,gameover;
        
	
        @Override
	public void create () {
        
		batch = new SpriteBatch();
		img = new Texture("tictactoe.jpg");
                board=new Sprite(img);
                board.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());  
                
                imgcross1=new Texture("cross.png");
                imgcross2=new Texture("cross.png");
                imgcross3=new Texture("cross.png");
                imgcross4=new Texture("cross.png");
                imgcross5=new Texture("cross.png");
                  
                imgcircle1=new Texture("circle.png");
                imgcircle2=new Texture("circle.png");
                imgcircle3=new Texture("circle.png");
                imgcircle4=new Texture("circle.png");
                
                imgwon=new Texture("gamewon.jpg");
                imglost=new Texture("lostgame.jpg");
                imgover=new Texture("gameover.png");
                
                cross1=new Sprite(imgcross1);
                cross2=new Sprite(imgcross2);
                cross3=new Sprite(imgcross3);
                cross4=new Sprite(imgcross4);
                cross5=new Sprite(imgcross5);
                
                circle1=new Sprite(imgcircle1);
                circle2=new Sprite(imgcircle2);
                circle3=new Sprite(imgcircle3);
                circle4=new Sprite(imgcircle4);
                
                gamewon=new Sprite(imgwon);
                gamelost=new Sprite(imglost);
                gameover=new Sprite(imgover);
      
                camera=new OrthographicCamera();
                camera.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
                boardEntry=new int[9]; 
                
                for(int i=0;i<9;i++){
                    boardEntry[i]=-1;
                }
                count=0;
                flag=0;
	}

	@Override
	public void render () {
                Gdx.graphics.setContinuousRendering(false);
	        Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); 
                batch.setProjectionMatrix(camera.combined);
               
                batch.begin();
                board.draw(batch);
                batch.end();

             //event handled on mouse click
                if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
                    int Ypos=Gdx.graphics.getHeight()-Gdx.input.getY();
                    int Xpos=Gdx.input.getX();  

                    if(count==0){ 
                      flagcross1=true; 
                      cross1.setPosition(Xpos, Ypos);
                      count++; 
                    }
                    else if(count==1){  
                     flagcircle1=true;  
                     circle1.setPosition(Xpos, Ypos);
                     count++;    
                    }
                    else if(count==2){
                      flagcross2=true;
                      cross2.setPosition(Xpos, Ypos);
                      count++;
                    }
                     else if(count==3){  
                     flagcircle2=true;  
                     circle2.setPosition(Xpos, Ypos);
                     count++; 
                    }
                    else if(count==4){ 
                      flagcross3=true; 
                      cross3.setPosition(Xpos, Ypos);
                      count++; 
                    }
                     else if(count==5){  
                     flagcircle3=true;  
                     circle3.setPosition(Xpos, Ypos);
                     count++; 
                    }
                    else if(count==6){ 
                      flagcross4=true; 
                      cross4.setPosition(Xpos, Ypos);
                      count++; 
                    }
                     else if(count==7){  
                     flagcircle4=true;  
                     circle4.setPosition(Xpos, Ypos);
                     count++; 
                    }
                    else if(count==8){ 
                      flagcross5=true; 
                      cross5.setPosition(Xpos, Ypos);
                      count++; 
                    }

                 //setting position i in boardentry array
                    if((Xpos>0)&&(Xpos<200)&&(Ypos>0)&&(Ypos<200)){
                        i=6;
                    }
                    else if((Xpos>0)&&(Xpos<200)&&(Ypos>200)&&(Ypos<400)){
                        i=3;
                    }
                    else if((Xpos>0)&&(Xpos<200)&&(Ypos>400)&&(Ypos<400)){
                        i=0;
                    }
                    else if((Xpos>200)&&(Xpos<400)&&(Ypos>0)&&(Ypos<200)){
                        i=7;
                    }
                    else if((Xpos>200)&&(Xpos<400)&&(Ypos>200)&&(Ypos<400)){
                        i=4;
                    }
                    else if((Xpos>200)&&(Xpos<400)&&(Ypos>400)&&(Ypos<600)){
                        i=1;   
                    }
                    else if((Xpos>400)&&(Xpos<600)&&(Ypos>0)&&(Ypos<200)){
                        i=8;
                    }
                    else if((Xpos>400)&&(Xpos<600)&&(Ypos>200)&&(Ypos<400)){
                        i=5;
                    }
                    else if((Xpos>400)&&(Xpos<600)&&(Ypos>400)&&(Ypos<600)){
                        i=2;
                    }
                    
                    System.out.println("x="+Xpos);
                    System.out.println("y="+Ypos);
                    
                }
               
             //drawing elements cross and circle
               boardEntry[i]=-1;
               batch.begin();
               if(flagcross1==true){
                      cross1.draw(batch);
                      camera.update();
                      boardEntry[i]=1;   
               }
               if(flagcircle1==true){
                      circle1.draw(batch);    
                      camera.update();
                      boardEntry[i]=0;
                }
              if(flagcross2==true){
                      cross2.draw(batch);
                      camera.update();
                      boardEntry[i]=1;
               }
               if(flagcircle2==true){
                      circle2.draw(batch);    
                      camera.update();
                      boardEntry[i]=0;
                }
               if(flagcross3==true){
                      cross3.draw(batch);
                      camera.update(); 
                      boardEntry[i]=1;
               }
               if(flagcircle3==true){
                      circle3.draw(batch);    
                      camera.update();
                      boardEntry[i]=0;
                }
               if(flagcross4==true){
                      cross4.draw(batch);
                      camera.update();
                      boardEntry[i]=1;
               }
                if(flagcircle4==true){
                      circle4.draw(batch);    
                      camera.update(); 
                      boardEntry[i]=0;
                }
               if(flagcross5==true){
                      cross5.draw(batch);
                      camera.update(); 
                      boardEntry[i]=1;
               }

              winstatus();
              batch.end();
               
              
	}
        
        public void winstatus(){
            
            //checking the win status
            
           boolean wincross=false;
           boolean wincircle=false;
           
           if((boardEntry[0]==boardEntry[1])&&(boardEntry[1]==boardEntry[2])){
               if((boardEntry[0]==1)&&(boardEntry[1]==1)&&(boardEntry[2]==1)){
               wincross=true;
               System.out.println("player1 wins");
                   System.out.println("game over");
                   gamewon.setSize(600, 200);
                   gamewon.setPosition(0, 0);
                   gameover.setSize(600, 400);
                   gameover.setPosition(0, 200);
                   gamewon.draw(batch);
                   gameover.draw(batch);  
               }
               else if((boardEntry[0]==0)&&(boardEntry[1]==0)&&(boardEntry[2]==0)){
                   wincircle=true;
                   System.out.println("player2 wins");
                   gamelost.setSize(600, 600);
                   gamelost.setPosition(0, 0);
                   gamelost.draw(batch);
               }  
           }
           
            if((boardEntry[3]==boardEntry[4])&&(boardEntry[4]==boardEntry[5])){
               if((boardEntry[3]==1)&&(boardEntry[4]==1)&&(boardEntry[5]==1)){
               wincross=true;
               System.out.println("player1 wins");
               gamewon.setSize(600, 200);
               gamewon.setPosition(0, 0);
               gameover.setSize(600, 400);
               gameover.setPosition(0, 200);
               gamewon.draw(batch);
               gameover.draw(batch);
               }
               else if((boardEntry[3]==0)&&(boardEntry[4]==0)&&(boardEntry[5]==0)){
                   wincircle=true;
                   System.out.println("player2 wins");
                   gamelost.setSize(600, 600);
                   gamelost.setPosition(0, 0);
                   gamelost.draw(batch);
                   
               }  
           }
            
            if((boardEntry[6]==boardEntry[7])&&(boardEntry[7]==boardEntry[8])){
               if((boardEntry[6]==1)&&(boardEntry[7]==1)&&(boardEntry[8]==1)){
               wincross=true;
               System.out.println("player1 wins");
               gamewon.setSize(600, 200);
                   gamewon.setPosition(0, 0);
                   gameover.setSize(600, 400);
                   gameover.setPosition(0, 200);
                   gamewon.draw(batch);
                   gameover.draw(batch);
               }
               else if((boardEntry[6]==0)&&(boardEntry[7]==0)&&(boardEntry[8]==0)){
                   wincircle=true;
                   System.out.println("player2 wins");
                   gamelost.setSize(600, 600);
                   gamelost.setPosition(0, 0);
                   gamelost.draw(batch);
               }   
           }
            
            if((boardEntry[0]==boardEntry[3])&&(boardEntry[3]==boardEntry[6])){
               if((boardEntry[0]==1)&&(boardEntry[3]==1)&&(boardEntry[6]==1)){
               wincross=true;
               System.out.println("player1 wins");
               gamewon.setSize(600, 200);
                   gamewon.setPosition(0, 0);
                   gameover.setSize(600, 400);
                   gameover.setPosition(0, 200);
                   gamewon.draw(batch);
                   gameover.draw(batch);
               }
               else if((boardEntry[0]==0)&&(boardEntry[3]==0)&&(boardEntry[6]==0)){
                   wincircle=true;
                   System.out.println("player2 wins");
                   gamelost.setSize(600, 600);
                   gamelost.setPosition(0, 0);
                   gamelost.draw(batch);
               }   
           }
            
            if((boardEntry[1]==boardEntry[4])&&(boardEntry[4]==boardEntry[7])){
               if((boardEntry[1]==1)&&(boardEntry[4]==1)&&(boardEntry[7]==1)){
               wincross=true;
               System.out.println("player1 wins");
               gamewon.setSize(600, 200);
                   gamewon.setPosition(0, 0);
                   gameover.setSize(600, 400);
                   gameover.setPosition(0, 200);
                   gamewon.draw(batch);
                   gameover.draw(batch);
               }
               else if((boardEntry[1]==0)&&(boardEntry[4]==0)&&(boardEntry[7]==0)){
                   wincircle=true;
                   System.out.println("player2 wins");
                   gamelost.setSize(600, 600);
                   gamelost.setPosition(0, 0);
                   gamelost.draw(batch);
               }  
           }
            
            if((boardEntry[2]==boardEntry[5])&&(boardEntry[5]==boardEntry[8])){
               if((boardEntry[2]==1)&&(boardEntry[5]==1)&&(boardEntry[8]==1)){
               wincross=true;
               System.out.println("player1 wins");
               gamewon.setSize(600, 200);
                   gamewon.setPosition(0, 0);
                   gameover.setSize(600, 400);
                   gameover.setPosition(0, 200);
                   gamewon.draw(batch);
                   gameover.draw(batch);
               }
               else if((boardEntry[2]==0)&&(boardEntry[5]==0)&&(boardEntry[8]==0)){
                   wincircle=true;
                   System.out.println("player2 wins");
                   gamelost.setSize(600, 600);
                   gamelost.setPosition(0, 0);
                   gamelost.draw(batch);
               }
           }
            
            if((boardEntry[0]==boardEntry[4])&&(boardEntry[4]==boardEntry[8])){
               if((boardEntry[0]==1)&&(boardEntry[4]==1)&&(boardEntry[8]==1)){
               wincross=true;
               System.out.println("player1 wins");
               gamewon.setSize(600, 200);
                   gamewon.setPosition(0, 0);
                   gameover.setSize(600, 400);
                   gameover.setPosition(0, 200);
                   gamewon.draw(batch);
                   gameover.draw(batch);
               }
               else if((boardEntry[0]==0)&&(boardEntry[4]==0)&&(boardEntry[8]==0)){
                   wincircle=true;
                   System.out.println("player2 wins");
                   gamelost.setSize(600, 600);
                   gamelost.setPosition(0, 0);
                   gamelost.draw(batch);
               }  
           }
            
            if((boardEntry[2]==boardEntry[4])&&(boardEntry[4]==boardEntry[6])){
               if((boardEntry[2]==1)&&(boardEntry[4]==1)&&(boardEntry[6]==1)){
               wincross=true;
               System.out.println("player1 wins");
               gamewon.setSize(600, 200);
                   gamewon.setPosition(0, 0);
                   gameover.setSize(600, 400);
                   gameover.setPosition(0, 200);
                   gamewon.draw(batch);
                   gameover.draw(batch);
               }
               else if((boardEntry[2]==0)&&(boardEntry[4]==0)&&(boardEntry[6]==0)){
                   wincircle=true;
                   System.out.println("player2 wins");
                   gamelost.setSize(600, 600);
                   gamelost.setPosition(0, 0);
                   gamelost.draw(batch);
               } 
           }   
           
        }
        
        @Override
        public void dispose(){
            img.dispose();
            imgcross1.dispose();
            imgcross2.dispose();
            imgcross3.dispose();
            imgcross4.dispose();
            imgcross5.dispose();
            imgcircle1.dispose();
            imgcircle2.dispose();
            imgcircle3.dispose();
            imgcircle4.dispose();
            imgwon.dispose();
            imglost.dispose();
            imgover.dispose();
            batch.dispose();    
        } 
}
