package com.artifactmmo;

import org.openapitools.client.model.DestinationSchema;
import org.openapitools.client.model.SimpleItemSchema;

public class Data {
    public static DestinationSchema LOC_CHICKENS = (new DestinationSchema()).x(0).y(1);
    public static DestinationSchema LOC_COWS = (new DestinationSchema()).x(0).y(2);
    public static DestinationSchema LOC_PIGS = (new DestinationSchema()).x(-3).y(-3);
    public static DestinationSchema LOC_WOLF = (new DestinationSchema()).x(-2).y(1);
    public static DestinationSchema LOC_SERPENT = (new DestinationSchema()).x(5).y(4);
    public static DestinationSchema LOC_MUSHMUSH = (new DestinationSchema()).x(5).y(3);
    public static DestinationSchema LOC_OWLBEAR = (new DestinationSchema()).x(10).y(1);

    public static DestinationSchema LOC_YELLOW_SLIME = (new DestinationSchema()).x(4).y(-1);
    public static DestinationSchema LOC_BLUE_SLIME = (new DestinationSchema()).x(2).y(-1);
    public static DestinationSchema LOC_RED_SLIME = (new DestinationSchema()).x(1).y(-1);
    public static DestinationSchema LOC_GREEN_SLIME = (new DestinationSchema()).x(0).y(-1);

    public static DestinationSchema LOC_WORKSHOP_COOKING = (new DestinationSchema()).x(1).y(1);
    public static DestinationSchema LOC_WORKSHOP_WEAPON = (new DestinationSchema()).x(2).y(1);
    public static DestinationSchema LOC_WORKSHOP_GEAR = (new DestinationSchema()).x(3).y(1);
    public static DestinationSchema LOC_WORKSHOP_JEWELERY = (new DestinationSchema()).x(1).y(3);
    public static DestinationSchema LOC_WORKSHOP_MINING = (new DestinationSchema()).x(1).y(5);
    public static DestinationSchema LOC_WORKSHOP_WOODCUTTING = (new DestinationSchema()).x(-2).y(-3);

    public static DestinationSchema LOC_BANK = (new DestinationSchema()).x(4).y(1);
    public static DestinationSchema LOC_GE = (new DestinationSchema()).x(5).y(1);

    public static DestinationSchema LOC_COPPER = (new DestinationSchema()).x(2).y(0);//0
    public static DestinationSchema LOC_COAL = (new DestinationSchema()).x(1).y(6);//10
    public static DestinationSchema LOC_IRON = (new DestinationSchema()).x(1).y(7);//20
    public static DestinationSchema LOC_GOLD = (new DestinationSchema()).x(10).y(-4);//30


    public static DestinationSchema LOC_GUDGEON = (new DestinationSchema()).x(4).y(2);//0
    public static DestinationSchema LOC_SHRIMP = (new DestinationSchema()).x(5).y(2);//10
    public static DestinationSchema LOC_TROUT = (new DestinationSchema()).x(-2).y(6);//20
    public static DestinationSchema LOC_BASS = (new DestinationSchema()).x(-3).y(6);//30

    public static DestinationSchema LOC_ASH = (new DestinationSchema()).x(-1).y(0);//0
    public static DestinationSchema LOC_SPRUCE = (new DestinationSchema()).x(-2).y(5);//10
    public static DestinationSchema LOC_BIRCH = (new DestinationSchema()).x(3).y(5);//20
    public static DestinationSchema LOC_DEAD_TREE = (new DestinationSchema()).x(9).y(8);//30
    public static SimpleItemSchema[] REAG_COPPER_HELMET = new SimpleItemSchema[]{(new SimpleItemSchema()).code("copper").quantity(3)};
    public static SimpleItemSchema[] REAG_COPPER_DAGGER = new SimpleItemSchema[]{(new SimpleItemSchema()).code("copper").quantity(3)};
    public static SimpleItemSchema[] REAG_COPPER_BOOTS = new SimpleItemSchema[]{(new SimpleItemSchema()).code("copper").quantity(3)};
    public static SimpleItemSchema[] REAG_COPPER_RING = new SimpleItemSchema[]{(new SimpleItemSchema()).code("copper").quantity(4)};
    public static SimpleItemSchema[] REAG_WOODEN_SHIELD = new SimpleItemSchema[]{(new SimpleItemSchema()).code("ash_plank").quantity(3)};

    public static SimpleItemSchema[] REAG_COPPER_ARMOR = new SimpleItemSchema[]{(new SimpleItemSchema()).code("copper").quantity(5)};
    public static SimpleItemSchema[] REAG_COPPER_LEGS = new SimpleItemSchema[]{(new SimpleItemSchema()).code("copper").quantity(4)};


    public static SimpleItemSchema[] REAG_IRON_HELMET = new SimpleItemSchema[]{(new SimpleItemSchema()).code("iron").quantity(3),(new SimpleItemSchema()).code("feather").quantity(2)};
    public static SimpleItemSchema[] REAG_IRON_SWORD = new SimpleItemSchema[]{(new SimpleItemSchema()).code("iron").quantity(8)};
    public static SimpleItemSchema[] REAG_IRON_BOOTS = new SimpleItemSchema[]{(new SimpleItemSchema()).code("iron").quantity(6)};
    public static SimpleItemSchema[] REAG_IRON_RING = new SimpleItemSchema[]{(new SimpleItemSchema()).code("iron").quantity(6)};
    public static SimpleItemSchema[] REAG_IRON_ARMOR = new SimpleItemSchema[]{(new SimpleItemSchema()).code("iron").quantity(5),(new SimpleItemSchema()).code("cowhide").quantity(2)};
    public static SimpleItemSchema[] REAG_IRON_LEGS = new SimpleItemSchema[]{(new SimpleItemSchema()).code("iron").quantity(4),(new SimpleItemSchema()).code("cowhide").quantity(2)};
}
