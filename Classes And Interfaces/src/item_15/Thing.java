package item_15;

@SuppressWarnings("unused")
class Thing {
    private final String NAME;
    private final String TYPE;

    Thing(String name, String type) {
        NAME = name;
        TYPE = type;
    }

    public String getNAME() {
        return NAME;
    }

    public String getTYPE() {
        return TYPE;
    }
}
