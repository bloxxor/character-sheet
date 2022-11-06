package CharacterGenerator.Model;

public class Character {

    private String characterName;
    private String characterDescription;
    private int characterStrength;
    private int characterDexterity;

    public Character(String characterName, String characterDescription, int characterStrength, int characterDexterity) {
        this.characterName = characterName;
        this.characterDescription = characterDescription;
        this.characterStrength = characterStrength;
        this.characterDexterity = characterDexterity;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getCharacterDescription() {
        return characterDescription;
    }

    public void setCharacterDescription(String characterDescription) {
        this.characterDescription = characterDescription;
    }

    public int getCharacterStrength() {
        return characterStrength;
    }

    public void setCharacterStrength(int characterStrength) {
        this.characterStrength = characterStrength;
    }

    public int getCharacterDexterity() {
        return characterDexterity;
    }

    public void setCharacterDexterity(int characterDexterity) {
        this.characterDexterity = characterDexterity;
    }
}
