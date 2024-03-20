public abstract class Bender {
    private String name;
    private int strength;
    private int health;

    public Bender(String name, int strength, int health) {
        this.name = name;
        this.strength = strength;
        this.health = health;
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public abstract void attack(Bender b);

    public boolean equals(Object o) {
        if (o instanceof Bender) {
            Bender b = (Bender) o;
            return (this.getName()).equals(b.getName()) && this.getStrength() == b.getStrength()
                && this.getHealth() == b.getHealth();
        }

        return false;
    }

    public String getName() {
        return this.name;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getHealth() {
        return this.health;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String toString() {
        return "My name is " + this.name + ". I am a bender. My strength is " + this.strength +
            " and my current health is " + this.health + ".";
    }
}
