public class Character {
    private String name;
    private String charClass;
    private Equipment weapon;
    private Equipment armor;

    public Character(String name, String charClass, String weapon, String weaponType, String armor, String armorType) {
        this.name = name;
        this.charClass = charClass;
        this.weapon = new Equipment(weapon, weaponType);
        this.armor = new Equipment(armor, armorType);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharClass() {
        return charClass;
    }

    public void setCharClass(String charClass) {
        this.charClass = charClass;
    }

    // Menggunakan metode getter dari kelas Equipment untuk mengakses atribut dari objek weapon dan armor
    public String getWeapon() {
        return weapon.getName();
    }

    public String getWeaponType() {
        return weapon.getType();
    }

    public String getArmor() {
        return armor.getName();
    }

    public String getArmorType() {
        return armor.getType();
    }

    // Menggunakan metode setter dari kelas Equipment untuk mengatur atribut dari objek weapon dan armor
    public void setWeapon(String weapon, String weaponType) {
        this.weapon.setName(weapon);
        this.weapon.setType(weaponType);
    }

    public void setArmor(String armor, String armorType) {
        this.armor.setName(armor);
        this.armor.setType(armorType);
    }

    // Kelas Equipment tidak diubah karena sudah cukup sederhana
    static class Equipment {
        private String name;
        private String type;

        public Equipment(String name, String type) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
