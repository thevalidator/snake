/*
 * Copyright (C) 2023 thevalidator
 */
package ru.thevalidator.snake.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.Timer;
import ru.thevalidator.snake.Food;
import ru.thevalidator.snake.Snake;

/**
 * @author thevalidator <the.validator@yandex.ru>
 */
public class GamePanel extends javax.swing.JPanel implements ActionListener {

    public static final int BOARD_SIZE = 500;
    public static final int ELEMENT_SIZE = 20;
    public static final int LENGTH = BOARD_SIZE / ELEMENT_SIZE;
    public static final int MAX_ELEMENTS = LENGTH * LENGTH;
    private final Dimension dimension;
    private int speed;
    private final Snake snake;
    private final Timer timer;

    /**
     * Creates new form GamePanel
     * @param snake
     */
    public GamePanel(Snake snake) {
        //dimension = new java.awt.Dimension(BOARD_SIZE, BOARD_SIZE + DATA_BLOCK_SIZE);
        dimension = new java.awt.Dimension(BOARD_SIZE, BOARD_SIZE);
        initComponents();
        speed = 50;
        this.snake = snake;
        timer = new Timer(speed, this);
        //timer.setInitialDelay(pause);
        //System.out.println("board=" + board.length);
        timer.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new Color(0, 102, 102));
        setMaximumSize(dimension);
        setMinimumSize(dimension);
        setPreferredSize(dimension);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.moveSnake();
        if (snake.hasCollision()) {
            System.out.println("GAME OVER");
            timer.stop();
        } else if (snake.isFull()) {
            System.out.println("YOU WIN");
            timer.stop();
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Food.drawFood(g2d);
        snake.drawSnake(g2d);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
