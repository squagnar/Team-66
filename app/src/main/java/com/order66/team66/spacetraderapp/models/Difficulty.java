package com.order66.team66.spacetraderapp.models;

/**
 * Stores game difficulty settings
 */
public enum Difficulty {

    /** Difficulty Options */
    BEGINNER("Beginner"),
    EASY("Easy"),
    NORMAL("Normal"),
    HARD("Hard"),
    IMPOSSIBLE("Impossible");

    /** Difficulty Name */
    private String difficulty;

    /**
     * Makes a difficulty
     *
     * @param difficulty name of difficulty setting
     */
    Difficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Gets difficulty name
     *
     * @return difficulty setting
     */
    public String getDifficulty() {
        return difficulty;
    }

}
