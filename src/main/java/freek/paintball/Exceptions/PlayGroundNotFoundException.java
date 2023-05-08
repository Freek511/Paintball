package freek.paintball.Exceptions;

import java.util.NoSuchElementException;

public class PlayGroundNotFoundException extends NoSuchElementException {
    public PlayGroundNotFoundException(String s) { super(s); }
}
