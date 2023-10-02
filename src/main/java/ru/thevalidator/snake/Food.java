/*
 * Copyright (C) 2023 thevalidator
 */
package ru.thevalidator.snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;
import static ru.thevalidator.snake.gui.GamePanel.ELEMENT_SIZE;
import static ru.thevalidator.snake.gui.GamePanel.LENGTH;

/**
 * @author thevalidator <the.validator@yandex.ru>
 */
public class Food {

    private static final Random random = new Random();
    private static int x;
    private static int y;
    private static boolean isEaten = false;
    
    static {
        generateFood();
    }

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }

    public static void setIsEaten(boolean isEaten) {
        Food.isEaten = isEaten;
    }

    public static void drawFood(Graphics2D g2d) {
        if (isEaten) {
            generateFood();
        }
        g2d.setColor(Color.GREEN);
        g2d.fillOval(ELEMENT_SIZE * x, ELEMENT_SIZE * y, ELEMENT_SIZE, ELEMENT_SIZE);
    }

    private static void generateFood() {
        x = random.nextInt(LENGTH);
        y = random.nextInt(LENGTH);
        setIsEaten(false);
    }
}
