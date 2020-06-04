package com.company.object;

public class PeopleImpl implements People {

    static private int count = 0;
    private int stamina = 100;
    private int intellect = 50;

    private String name;

    public PeopleImpl(){
        this("noNamed");
    }

    public PeopleImpl(String name){
        this.name = name;
    }

    @Override
    public void talking(String sentence) {
        if (stamina < 0) {
            System.out.println("에너지가 부족합니다.");
        } else {
            System.out.println(sentence);
            minusStamina(10);
            ++count;
        }
    }

    @Override
    public void eating(String food) {
        System.out.println(food + "를 먹었습니다.");
        addStamina(10);
        ++count;
    }

    @Override
    public void studying(String subject) {
        if (stamina < 0) {
            System.out.println("에너지가 부족합니다.");
        } else {
            System.out.println(subject + "를 공부합니다.");
            minusStamina(20);
            addIntellect(10);
            ++count;
        }
    }

    @Override
    public void nowState() {
        System.out.println("스태미너 : " + stamina + "\n지력 : " + intellect);
    }

    public void readCount() {
        System.out.println("행동 횟수 : " + count);
    }

    public String getName() {
        return this.name;
    }

    private void addStamina(int value) {
        stamina += value;
    }

    private void minusStamina(int value) {
        stamina -= value;
    }

    private void addIntellect(int value) {
        intellect += value;
    }
}
