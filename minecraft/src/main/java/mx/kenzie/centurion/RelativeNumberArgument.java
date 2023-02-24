package mx.kenzie.centurion;

public class RelativeNumberArgument extends HashedArg<RelativeNumber> {

    public RelativeNumberArgument() {
        super(RelativeNumber.class);
        this.label = "number";
    }

    @Override
    public boolean matches(String input) {
        try {
            this.lastValue = this.parseNew(input);
            this.lastHash = input.hashCode();
            return true;
        } catch (Throwable ex) {
            return false;
        }
    }

    @Override
    public RelativeNumber parseNew(String input) {
        if (input.startsWith("~"))
            return new RelativeNumber(Double.parseDouble(input.substring(1)), true);
        return new RelativeNumber(Double.parseDouble(input.trim()), false);
    }

}
