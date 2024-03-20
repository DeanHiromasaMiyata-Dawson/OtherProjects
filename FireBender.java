package com.java.cs1331;

public class FireBender extends Bender{
    private static double fireSourceStrength = 1;

    public FireBender (String name, int strength, int health) {
        super(name, strength, health);
    }

    public FireBender (String name) {
        this(name, 60, 50);
    }

    public void attack (Bender b) {
        if (super.isAlive()) {
            if (b instanceof WaterBender) {
                b.setHealth((int) (b.getHealth() - (super.getStrength() * getFireSourceStrength())));
            } else if (b instanceof FireBender) {
                b.setHealth((int) (b.getHealth() - getFireSourceStrength()));
            }

            if (b.getHealth() < 0) {
                b.setHealth(0);
            }

            fireSourceStrength -= 0.05;
        }
    }

    public void replenishFireSources() {
        if (super.getStrength() < 50) {
            fireSourceStrength = 0.8;
        } else {
            fireSourceStrength = 1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof FireBender) {
            FireBender fb = (FireBender) o;
            return super.equals(fb);
        }

        return false;
    }

    public static double getFireSourceStrength() {
        return fireSourceStrength;
    }

    @Override
    public String toString() {
        return super.toString() + " I bend fire.";
    }
}