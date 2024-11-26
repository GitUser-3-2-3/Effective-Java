package item_15;

import java.util.List;

@SuppressWarnings("unused")
class Encapsulation {

    private static Thing Pants = new Thing("Pants", "Casual/Formal");
    private static Thing Shirt = new Thing("Shirt", "Casual/Formal");
    private static Thing Suit = new Thing("Suit", "Formal");

    // Potential Security Hole.
    public static final Thing[] VALUES_1 = {Pants, Shirt, Suit};

    // If the field needs to be public.
    private static final Thing[] PRIVATE_VALUES = {Pants, Shirt, Suit};
    public static final List<Thing> VALUES_2 = List.of(PRIVATE_VALUES);

    public static final Thing[] values() {
        return PRIVATE_VALUES.clone();
    }

    public static void main(String[] args) {
        System.out.println("Data Hiding.");
    }
}







