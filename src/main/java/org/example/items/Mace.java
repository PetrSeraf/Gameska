package org.example.items;

import org.example.NPCs.Player;

public class Mace implements IItem, IEquipable {
    private Player player;
    private final int damageIncrease = 30; // Amount of damage the sword adds

    public Mace(Player player) {
        this.player = player;
    }

    @Override
    public String getName() {
        return "Mace";
    }

    @Override
    public boolean canBeEquiped() {
        return true;
    }

    @Override
    public void onEquip() {
        player.setDMG(player.getDMG() + damageIncrease);
        System.out.println("You fell stronger :D");
    }

}