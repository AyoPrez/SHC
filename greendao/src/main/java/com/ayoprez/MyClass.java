package com.ayoprez;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MyClass {

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1000, "SHC_Schema");
        addCard(schema);
        addGroup_Cards(schema);
        new DaoGenerator().generateAll(schema, "/home/ayo/Proyectos/Speechhelpcards/mobile/src/main/java-gen");
    }

    private static void addCard(Schema schema) {
        Entity entity_card = schema.addEntity("Card");
        entity_card.addIdProperty().autoincrement();
        entity_card.addStringProperty("text").notNull();
        entity_card.addIntProperty("n_card");
        entity_card.addIntProperty("id_g");
    }

    private static void addGroup_Cards(Schema schema){
        Entity entity_group = schema.addEntity("GroupCard");
        entity_group.addIdProperty();
        entity_group.addStringProperty("name").notNull();
        entity_group.addIntProperty("amount_cards");
    }
}
