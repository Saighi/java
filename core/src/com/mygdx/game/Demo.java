package com.mygdx.game;

import Elements.Pièces.Equipe;
import Elements.Plateau;
import Elements.Pièces.Pion;
import Elements.Pièces.Reine;
import Elements.Pièces.Roi;
import Elements.Pièces.Tour;
import Elements.Pièces.Fou;
import Elements.Pièces.Cavalier;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;


public class Demo extends Game {
	private SpriteBatch batch;
	private Texture plateau_img;

    private Texture bPion;
	private Texture bTour;
	private Texture bFou;
	private Texture bCavalier;
	private Texture bRoi;
	private Texture bReine;

	private Texture nPion;
	private Texture nTour;
	private Texture nFou;
	private Texture nCavalier;
	private Texture nRoi;
	private Texture nReine;

	private Plateau p;


	
	@Override
	public void create () {
		batch = new SpriteBatch();
		plateau_img=new Texture("plateau.jpg");

		bPion= new Texture("WhitePawn.png");
		bTour= new Texture("WhiteRook.png");
		bFou= new Texture("WhiteBishop.png");
		bCavalier= new Texture("WhiteKnight.png");
		bRoi= new Texture("WhiteKing.png");
		bReine= new Texture("WhiteQueen.png");

		nPion= new Texture("BlackPawn.png");
		nTour= new Texture("BlackRook.png");
		nFou= new Texture("BlackBishop.png");
		nCavalier= new Texture("BlackKnight.png");
		nRoi= new Texture("BlackKing.png");
		nReine= new Texture("BlackQueen.png");

        p = new Plateau();


	}


    @Override
	public void render () {
		//super.render();
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);




		batch.begin();
		affichage_plateau(p);
		batch.end();
	}

	private void affichage_plateau(Plateau p){
        batch.draw(plateau_img,0,0);
	    for (int i =0; i<8; i++){
            for (int j =0; j<8; j++){

            	int a = 81;
            	int b = 80;
            	int c = 75;

                if (p.getCase(i,j) instanceof Pion && p.getCase(i,j).e == Equipe.Blanc){
                    //System.out.println("pion");
                    batch.draw(bPion,(i*a)+b,(j*a)+c);

                }

                else if (p.getCase(i,j) instanceof Tour && p.getCase(i,j).e == Equipe.Blanc){
					//System.out.println("tour");
					batch.draw(bTour,(i*a)+b,(j*a)+c);

				}

				else if (p.getCase(i,j) instanceof Fou && p.getCase(i,j).e == Equipe.Blanc){
					//System.out.println("Fou");
					batch.draw(bFou,(i*a)+b,(j*a)+c);

				}

				else if (p.getCase(i,j) instanceof Cavalier && p.getCase(i,j).e == Equipe.Blanc){
					//System.out.println("Cavalier");
					batch.draw(bCavalier,(i*a)+b,(j*a)+c);

				}

				else if (p.getCase(i,j) instanceof Reine && p.getCase(i,j).e == Equipe.Blanc){
					//System.out.println("Reine");
					batch.draw(bReine,(i*a)+b,(j*a)+c);

				}

				else if (p.getCase(i,j) instanceof Roi && p.getCase(i,j).e == Equipe.Blanc){
					//System.out.println("Roi");
					batch.draw(bRoi,(i*a)+b,(j*a)+c);

				}

				//Noir

				else if (p.getCase(i,j) instanceof Pion && p.getCase(i,j).e == Equipe.Noir){
					//System.out.println("pion");
					batch.draw(nPion,(i*a)+b,(j*a)+c);

				}

				else if (p.getCase(i,j) instanceof Tour && p.getCase(i,j).e == Equipe.Noir){
					//System.out.println("tour");
					batch.draw(nTour,(i*a)+b,(j*a)+c);

				}

				else if (p.getCase(i,j) instanceof Fou && p.getCase(i,j).e == Equipe.Noir){
					//System.out.println("Fou");
					batch.draw(nFou,(i*a)+b,(j*a)+c);

				}

				else if (p.getCase(i,j) instanceof Cavalier && p.getCase(i,j).e == Equipe.Noir){
					//System.out.println("Cavalier");
					batch.draw(nCavalier,(i*a)+b,(j*a)+c);

				}

				else if (p.getCase(i,j) instanceof Reine && p.getCase(i,j).e == Equipe.Noir){
					//System.out.println("Reine");
					batch.draw(nReine,(i*a)+b,(j*a)+c);

				}

				else if (p.getCase(i,j) instanceof Roi && p.getCase(i,j).e == Equipe.Noir){
					//System.out.println("Roi");
					batch.draw(nRoi,(i*a)+b,(j*a)+c);

				}
            }

        }
    }

}
