package com.order66.team66.spacetraderapp.models;

/**
 * Stores skill types
 */
public enum Skill {

    /** Skill Types */
    PILOT("Pilot"),
    FIGHTER("Fighter"),
    TRADER("Trader"),
    ENGINEER("Engineer"),
    NULL("N/A");

    //Formatted name of the skill
    private final String name;
    //Level of the skill, a number from 0 to Integer.MAX_VALUE
    private int level;

    /**
     * Makes a skill
     *
     * @param name name of skill
     */
    Skill(String name) {
        this.name = name;
        level = 0;
    }

    /**
     * Gets Skill Name
     *
     * @return skill name
     */
    public String getName() { return name; }

    /**
     * Gets Skill level
     *
     * @return skill level
     */
    public int getLevel() { return level;
    }

    /**
     * levels skill up
     */
    public void levelUp() {
        if(level < Integer.MAX_VALUE) { level++; }
    }

    /**
     * levels skill down
     */
    public void levelDown() {
        if(level > 0) { level--; }
    }

}