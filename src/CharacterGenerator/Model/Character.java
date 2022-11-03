package CharacterGenerator.Model;

public class Character {

    private String characterName;
    private String characterDescription;

    public Character(String characterName, String characterDescription) {
        this.characterName = characterName;
        this.characterDescription = characterDescription;
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

}
