/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameboard;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;
import javax.swing.JPanel;

/**
 *
 * @author Palmer
 */
public class GameBoard extends JPanel implements MouseListener, MouseMotionListener {

    private int rows;
    private int columns;
    private int squareWidth;
    private Graphics panelG;
    private Square boardSquare1;
    private Square boardSquare2;
    private Piece piece1;
    private JPanel checkerBoard;

    public GameBoard() {
        initComponents();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame demoBoard = new JFrame();
        GameBoard board = new GameBoard();

        demoBoard.setSize(800, 800);
        demoBoard.setTitle("Demo GameBoard");
        Container container = demoBoard.getContentPane();
        container.add(board);
        container.addMouseListener(board);
        container.addMouseMotionListener(board);

        demoBoard.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        demoBoard.setVisible(true);
    }

    private void initComponents() {
        //this.setBackground(Color.red);
        squareWidth = 100;
        piece1 = new Piece(0, 0, squareWidth, squareWidth, 0, 360);
        //boardSquare1 = new Square(0,0,150,150,Color.BLUE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        //super.paintComponent(g);

        updateSquare();
        boardSquare1 = new Square(0, 0, squareWidth, squareWidth, Color.BLUE);
        boardSquare2 = new Square(0, 0, squareWidth, squareWidth, Color.BLACK);
        Graphics2D g2 = (Graphics2D) g;
        int swap = 1;
        for (int k = 0; k <= this.getHeight(); k += (squareWidth)) {
            if (swap % 2 == 1) {
                for (int i = 0; i <= this.getWidth();
                        i += (2 * squareWidth)) {

                    g2.setColor(boardSquare1.getSquareColor());
                    g2.fillRect(i, k,
                            boardSquare1.getWidth(), boardSquare1.getHeight());
                }

                for (int j = squareWidth; j <= this.getWidth(); j += (2 * squareWidth)) {
                    g2.setColor(boardSquare2.getSquareColor());
                    g2.fillRect(j, k,
                            boardSquare1.getWidth(), boardSquare1.getHeight());
                }

                swap++;
            }//end if
            else {
                for (int j = 0; j <= this.getWidth(); j += (2 * squareWidth)) {
                    g2.setColor(boardSquare2.getSquareColor());
                    g2.fillRect(j, k,
                            boardSquare1.getWidth(), boardSquare1.getHeight());
                }//end for loop

                for (int i = squareWidth; i <= this.getWidth();
                        i += (2 * squareWidth)) {

                    g2.setColor(boardSquare1.getSquareColor());
                    g2.fillRect(i, k,
                            boardSquare1.getWidth(), boardSquare1.getHeight());
                }//end for loop
                swap++;
            }//end else
            if (swap > 2) {
                swap = 1;
            }
        }//end for loop

        //draw a piece on the board at the third square

        piece1.setWidth(squareWidth);
        piece1.setHeight(squareWidth);
        piece1.drawPiece(g2);
        /*
        g2.setColor(Color.DARK_GRAY);
        piece1.movePiece(2*squareWidth, squareWidth);
        piece1.drawPiece(g2);
        //g2.fillArc(0, 0, 100, 100, 0, 360);
         * 
         */
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int squareX = 0;
        int squareY = 0;

        //update the square width
        updateSquare();

        //we only want to move the piece if the piece has been selected

        //if the mouse is on top of the piece, the piece should change color
        //if the mouse is to the right of top left corner, but to the left of the
        //top right corner
        if (e.getX() > piece1.getxPos()
                && e.getX() < (piece1.getxPos() + squareWidth)
                && e.getY() > piece1.getyPos() 
                && e.getY() < (piece1.getyPos() + squareWidth)){
         
                //if the piece has not been selected
                if (!piece1.isSelected) {
                    //set isSelected to true
                    piece1.isSelected = true;
                }//end if
                else {
                    piece1.isSelected = false;
                }//end else
        }//end if
        
        //if the mouse is not over the piece, and the piece is selected, then you
        //should move the piece to where the mouse is
        else {
            if (piece1.isSelected) {
                //we want the piece to be drawn in the square the mouse is over
                //the square the mouse is over
                squareX = e.getX() / squareWidth;
                squareY = e.getY() / squareWidth;

                //move the piece coordinates to the appropriate square
                piece1.setxPos((squareX * squareWidth));
                piece1.setyPos(squareY * squareWidth);
                piece1.isSelected = false;
            }
        }
        //redraw the screen
        repaint();

        //throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @return the rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * @param rows the rows to set
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * @return the columns
     */
    public int getColumns() {
        return columns;
    }

    /**
     * @param columns the columns to set
     */
    public void setColumns(int columns) {
        this.columns = columns;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //user clicks on the piece
        //we want the piece to move with the mouse
        //set the piece coordinates to that of the mouse coordinates
        /*
        updateSquare();
        piece1.setxPos(e.getX()- (squareWidth / 2));
        piece1.setyPos(e.getY()- (squareWidth / 2));
        repaint();
         * 
         */
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int squareX = 0;
        int squareY = 0;

        //update the square width
        updateSquare();/*
        //when the user releases the mouse
        //we want the piece to be drawn in the square the mouse is over
        //the square the mouse is over
        squareX = e.getX() / squareWidth;
        squareY = e.getY() / squareWidth;
        piece1.setxPos((squareX * squareWidth));
        piece1.setyPos(squareY * squareWidth);*/
        repaint();

        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {/*
        // throw new UnsupportedOperationException("Not supported yet.");
        piece1.setxPos(e.getX()- (squareWidth / 2));
        piece1.setyPos(e.getY()- (squareWidth / 2)); */
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * updateSquare - updates the width of the squares on the board.
     */
    private void updateSquare() {
        squareWidth = this.getWidth() / 8;
    }
}
