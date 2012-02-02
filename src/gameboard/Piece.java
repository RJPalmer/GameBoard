/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameboard;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Piece.java - Represents a piece to be placed on the gameboard
 * @author Palmer
 */
public class Piece {
    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private int startAngle;
    private int endAngle;
    private Color pieceColor;
    public boolean isSelected;

    /**
     * 
     */
    public Piece() {
        this.xPos = 0;
        this.yPos = 0;
        this.width = 0;
        this.height = 0;
        this.startAngle = 0;
        this.endAngle = 0;
        this.pieceColor = new Color(0, 0 ,0);
        this.isSelected = false;
    }

    /**
     * 
     * @param xPos
     * @param yPos
     * @param width
     * @param height
     * @param startAngle
     * @param endAngle 
     */
    public Piece(int xPos, int yPos, int width, int height, int startAngle, int endAngle) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.startAngle = startAngle;
        this.endAngle = endAngle;
        this.pieceColor = Color.WHITE;
        this.isSelected = false;
    }

    /**
     * 
     * @return 
     */
    public int getEndAngle() {
        return endAngle;
    }
    
    /**
     * 
     * @param endAngle 
     */
    public void setEndAngle(int endAngle) {
        this.endAngle = endAngle;
    }

    /**
     * 
     * @return 
     */
    public int getHeight() {
        return height;
    }

    /**
     * 
     * @param height 
     */
    public void setHeight(int height) {
        this.height = height;
    }
    /**
     * 
     * @return 
     */
    public int getStartAngle() {
        return startAngle;
    }
    
    /**
     * 
     * @param startAngle 
     */
    public void setStartAngle(int startAngle) {
        this.startAngle = startAngle;
    }

    /**
     * 
     * @return 
     */
    public int getWidth() {
        return width;
    }

    /**
     * 
     * @param width 
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * 
     * @return 
     */
    public int getxPos() {
        return xPos;
    }

    /**
     * 
     * @param xPos 
     */
    public void setxPos(int xPos) {
        this.xPos = xPos;
    }
    
    /**
     * 
     * @return 
     */
    public int getyPos() {
        return yPos;
    }

    /**
     * 
     * @param yPos 
     */
    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public void drawPiece(Graphics2D g2) {
        if(isSelected)
            g2.setColor(Color.YELLOW);
        else
            g2.setColor(pieceColor);
        g2.fillArc(xPos, yPos, width, height, startAngle, endAngle);
    }

    public void movePiece(int newX, int newY) {
        this.setxPos(newX);
        this.setyPos(newY);
        
    }

    /**
     * @return the pieceColor
     */
    public Color getPieceColor() {
        return pieceColor;
    }

    /**
     * @param pieceColor the pieceColor to set
     */
    public void setPieceColor(Color pieceColor) {
        this.pieceColor = pieceColor;
    }
            
    
}
