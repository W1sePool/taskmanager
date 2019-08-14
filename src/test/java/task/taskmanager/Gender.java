package task.taskmanager;

public enum Gender {
    MAN("пол мужской"),
    WOMAN("пол женский");

    private String name;
    private Gender(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return name;
    }
}
