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
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;



public class Demo extends Game {
	private SpriteBatch batch;
	private Texture plateau_img;

	private int caseSelectx=0;
    private int caseSelecty=2;

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
	private Texture point;

	private Texture selecT;
	private Sprite selec;

	private Plateau p;

    int a = 84;
    int b = 55;
    int c = 70;

    int joueur=0;


	
	@Override
	public void create () {
		batch = new SpriteBatch();
		plateau_img=new Texture("plateau.png");

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

		point = new  Texture("point.png");

		selecT = new Texture("selec.png");
		selec= new Sprite(selecT,82,83);
		selec.setAlpha(0.3f);

        p = new Plateau();


	}


    @Override
	public void render () {
		//super.render();
		//System.out.println(joueur);

        p.updateDeplacements();
        clics();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        batch.begin();
        affichage_plateau(p);
        affichage_selection(caseSelectx, caseSelecty);
        batch.end();
        p.isWon();

		//System.out.print(p.isWon().toString() + " a gagné");
	}

	public void affichage_selection(int x,int y){
	    if (p.getCase(x,y)!=null) {
            for (int[] coordonées : p.getCase(x, y).deplacements) {
            	selec.setPosition((coordonées[0]*a)+b,(coordonées[1]*a)+c);
				selec.draw(batch);
                //batch.draw(point,(coordonées[0]*a)+b,(coordonées[1]*a)+c);
            }
        }
    }

    private void clics() {


        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)){

            for (int i =0; i<8; i++) {
                for (int j = 0; j < 8; j++) {


                    if((Gdx.input.getX()>(i*a)+b && Gdx.input.getX()<(i*a)+b+a) && ((Gdx.graphics.getHeight() - Gdx.input.getY())>(j*a)+c && (Gdx.graphics.getHeight() - Gdx.input.getY())<(j*a)+c+a)){


                    	if (p.getCase(caseSelectx, caseSelecty)!=null) {
							for (int[] coordonées : p.getCase(caseSelectx, caseSelecty).deplacements) {
								if ((i==coordonées[0])&&(j==coordonées[1])&&p.getCase(caseSelectx, caseSelecty).getE().EquipeParNombre(joueur)){
									p.changeCase(p.getCase(caseSelectx,caseSelecty),i,j);
									p.getCase(i,j).setX(i);
									p.getCase(i,j).setY(j);
									
									if(p.getCase(caseSelectx,caseSelecty)instanceof Pion && p.getCase(caseSelectx, caseSelecty).getE()==Equipe.Blanc && j==7 ){
										p.changeCase(new Reine(Equipe.Blanc,i,j,p), i,j);
									}

									if(p.getCase(caseSelectx,caseSelecty)instanceof Pion && p.getCase(caseSelectx, caseSelecty).getE()==Equipe.Noir && j==0){
										p.changeCase(new Reine(Equipe.Noir,i,j,p), i,j);
									}

									if(p.getCase(caseSelectx,caseSelecty)instanceof Roi && !((Roi) p.getCase(caseSelectx, caseSelecty)).isBougé()) {

										if (p.getCase(caseSelectx,caseSelecty).getE()==Equipe.Blanc) {

											((Roi) p.getCase(4, 0)).setBougé(true);
											if (i == 2) {
												p.changeCase(new Tour(Equipe.Blanc, 3, 0, p), 3, 0);
												p.changeCase(null, 0, 0);
												((Tour) p.getCase(3, 0)).setBougé(true);


											}
											if (i == 6) {
												p.changeCase(new Tour(Equipe.Blanc, 5, 0, p), 5, 0);
												p.changeCase(null, 7, 0);
												((Tour) p.getCase(5, 0)).setBougé(true);


											}
										}

										else{

												((Roi) p.getCase(4, 7)).setBougé(true);
												if (i == 2) {
													p.changeCase(new Tour(Equipe.Noir, 3, 7, p), 3, 7);
													p.changeCase(null, 0, 7);
													((Tour) p.getCase(3, 7)).setBougé(true);


												}
												if (i == 6) {
													p.changeCase(new Tour(Equipe.Noir, 5, 7, p), 5, 7);
													p.changeCase(null, 7, 7);
													((Tour) p.getCase(5, 7)).setBougé(true);




												}
										}
									}

									p.changeCase(null,caseSelectx,caseSelecty);


									joueur=(joueur+1)%2;
								}

							}
						}

                        //System.out.println(p.getCase(i,j));
                        caseSelectx=i;
                        caseSelecty=j;

                    	}

                	}
            	}

	    }
	}

	private void affichage_plateau(Plateau p){
        batch.draw(plateau_img,0,0);
	    for (int i =0; i<8; i++){
            for (int j =0; j<8; j++){



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
