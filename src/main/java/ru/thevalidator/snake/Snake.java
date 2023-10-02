/*
 * Copyright (C) 2023 thevalidator
 */
package ru.thevalidator.snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.LinkedList;
import static ru.thevalidator.snake.Direction.*;
import static ru.thevalidator.snake.gui.GamePanel.ELEMENT_SIZE;

/**
 * @author thevalidator <the.validator@yandex.ru>
 */
public class Snake {

    private LinkedList<Point> snake;
    private Direction direction;

    public Snake() {
        initSnake();
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction d) {
        if (isCorrect(d)) {
            this.direction = d;
        }
    }

    public void moveSnake() {
        Point p = snake.getFirst();
        switch (direction) {
            case UP -> snake.addFirst(new Point(p.y - 1, p.x));
            case DOWN -> snake.addFirst(new Point(p.y + 1, p.x));
            case LEFT -> snake.addFirst(new Point(p.y, p.x - 1));
            case RIGHT -> snake.addFirst(new Point(p.y, p.x + 1));
            default -> {
            }
        }
        snake.pollLast();
    }

    public void drawSnake(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        for (Point p: snake) {
            g2d.fillRect(ELEMENT_SIZE * p.x, ELEMENT_SIZE * p.y, ELEMENT_SIZE, ELEMENT_SIZE);
        }
    }

    private void initSnake() {
        snake = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            snake.addFirst(new Point(0, i));
        }
        direction = RIGHT;
    }

    private boolean isCorrect(Direction d) {        
        return ( (direction.equals(UP) || direction.equals(DOWN)) && (d.equals(LEFT) || d.equals(RIGHT)) )
                || 
               ( (direction.equals(LEFT) || direction.equals(RIGHT)) && (d.equals(UP) || d.equals(DOWN)) );
    }

    class Point {

        private final int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

    }
}
