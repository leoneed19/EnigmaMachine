package enigma;
public class Reflector {

    // Reflector wires, arrays will store the jump distance to get to the end of the wire
    private int rotorOut[] = new int[26];

    protected Reflector(String reflector){
        setReflector(reflector);
    }


    protected int getOutputOf(int pos){
        return (pos + rotorOut[pos]) % 26;
    }


    public int getAnOutWire(int pos){
        return (rotorOut[pos] + pos ) % 26;
    }

    public void setReflector(String reflector){
        for (int i = 0; i < 26; i++){
            int from = (char) ('A' + i);
            int to = reflector.charAt(i);
            rotorOut[i] = from < to ? to - from : (26 - (from - to)) % 26;
        }
    }
}