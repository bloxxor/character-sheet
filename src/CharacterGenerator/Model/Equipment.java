package CharacterGenerator.Model;

public class Equipment {

    String equipmentName;

    String equipmentDescription;

    String equipmentType;

    int equipmentAttack;

    int equipmentDefense;

    public Equipment(String equipmentName, String equipmentDescription, String equipmentType, int equipmentAttack, int equipmentDefense) {
        this.equipmentName = equipmentName;
        this.equipmentDescription = equipmentDescription;
        this.equipmentType = equipmentType;
        this.equipmentAttack = equipmentAttack;
        this.equipmentDefense = equipmentDefense;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentDescription() {
        return equipmentDescription;
    }

    public void setEquipmentDescription(String equipmentDescription) {
        this.equipmentDescription = equipmentDescription;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public int getEquipmentAttack() {
        return equipmentAttack;
    }

    public void setEquipmentAttack(int equipmentAttack) {
        this.equipmentAttack = equipmentAttack;
    }

    public int getEquipmentDefense() {
        return equipmentDefense;
    }

    public void setEquipmentDefense(int equipmentDefense) {
        this.equipmentDefense = equipmentDefense;
    }

}
