package org.example.items;

import org.example.NPCs.Player;

public class Sword implements IItem, IEquipable {
    private Player player;
    private final int damageIncrease = 20; // Amount of damage the sword adds

    public Sword(Player player) {
        this.player = player;
    }

    @Override
    public String getName() {
        return "Sword";
    }

    @Override
    public boolean canBeEquiped() {
        return true;
    }

    @Override
    public void onEquip() {
        player.setDMG(player.getDMG() + damageIncrease);
    }

}