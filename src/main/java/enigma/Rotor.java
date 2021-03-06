package enigma;
public class Rotor {

    // Rotor wires, arrays will store the jump distance to get to the end of the wire
    private	int rotorOut[] = new int[26];
    private int rotorIn[] = new int[26];
    private int rotorHead;
    private int ringHead;
    private char notch;
    private int rotate;


    protected Rotor(String rotor,char notch){
        setRotor(new String[]{rotor, notch+""});
    }


    protected int getOutputOf(int pos){
        int rotorRingDiff = rotorHead >= ringHead ? rotorHead - ringHead : 26 - ringHead + rotorHead;
        return (pos + rotorOut[ (pos + rotate + rotorRingDiff) % 26]) % 26; // Pos + Jump to mirror with the next rotor
    }


    protected int getInputOf(int pos){
        int rotorRingDiff = rotorHead >= ringHead ? rotorHead - ringHead : 26 - ringHead + rotorHead;
        int posJump = pos - rotorIn[ (pos + rotate + rotorRingDiff) % 26];
        return posJump > 0 ? (posJump % 26) : ( 26 + posJump) % 26; // Pos - Jump to mirror with the next rotor
    }


    public char getNotch(){
        return notch;
    }


    public char getRotorHead(){
        return (char) ('A' + (rotorHead + rotate) % 26);
    }


    public char getRingHead(){
        return (char) ('A' + (ringHead + rotate) % 26);
    }


    protected void rotate(){
        rotate = (rotate + 1) % 26;
    }


    public void setRotorHead(char c){
        if(c < 'A' || c > 'Z')
            throw new RuntimeException("Only upper case letters allowed!");
        rotorHead = c - 'A';
        rotate = 0;
    }


    public void setRingHead(char c){
        if(c < 'A' || c > 'Z')
            throw new RuntimeException("Only upper case letters allowed!");
        ringHead = c - 'A';
    }


    public void setRotor(String[] rotor){
        this.notch = rotor[1].charAt(0);
        for (int i = 0; i < 26; i++){
            int from = (char) ('A' + i);
            int to = rotor[0].charAt(i);
            rotorOut[i] = from < to ? to - from : (26 - (from - to)) % 26;
            rotorIn[ (i + rotorOut[i]) % 26] = rotorOut[i];
        }
    }


    public int getAnOutWire(int pos){
        return getOutputOf(pos);
    }


    public int getAnInWire(int pos){
        return getInputOf(pos);
    }

    public void reset(){
        rotate = 0;
    }
}