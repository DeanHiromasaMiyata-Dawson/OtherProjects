public class WaterBender extends Bender {
    private boolean healer;

    public WaterBender(String name, int strength, int health, boolean healer) {
        super(name, strength, health);
        this.healer = healer;
    }

    public WaterBender(String name) {
        this(name, 40, 80, false);
    }

    public void attack(Bender b) {
        if (super.isAlive()) {
            if (b instanceof FireBender) {
                b.setHealth(b.getHealth() - super.getStrength());
            } else if (b instanceof WaterBender) {
                b.setHealth(b.getHealth() - 1);
            }

            if (b.getHealth() < 0) {
                b.setHealth(0);
            }
        }
    }

    public void heal(WaterBender wb) {
        if (!wb.isAlive()) {
            return;
        } else if (!wb.getHealer()) {
            wb.setHealth(wb.getHealth() + 20);
        } else {
            wb.setHealth(wb.getHealth() + 40);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof WaterBender) {
            WaterBender wb = (WaterBender) o;
            return super.equals(wb) && this.getHealer() == wb.getHealer();
        }

        return false;
    }

    public boolean getHealer() {
        return healer;
    }

    public void setHealer(boolean healer) {
        this.healer = healer;
    }

    @Override
    public String toString() {
        if (this.getHealer()) {
            return super.toString() + " With my waterbending, I can heal others.";
        } else {
            return super.toString() + " With my waterbending, I cannot heal others.";
        }
    }
}
