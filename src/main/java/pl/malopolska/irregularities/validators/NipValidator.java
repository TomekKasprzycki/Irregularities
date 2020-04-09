package pl.malopolska.irregularities.validators;

public class NipValidator {

    public boolean NIPValidator(String NIPNumber) {
        byte NIP[] = new byte[10];
        boolean valid=false;

        if (NIPNumber.length() == 10){
            for (int i = 0; i < 10; i++){
                NIP[i] = Byte.parseByte(NIPNumber.substring(i, i+1));
            }
            valid = checkSum(NIP);
        }
        return valid;
    }


    private boolean checkSum(byte[] NIP) {
        int sum;
        sum = 6 * NIP[0] +
                5 * NIP[1] +
                7 * NIP[2] +
                2 * NIP[3] +
                3 * NIP[4] +
                4 * NIP[5] +
                5 * NIP[6] +
                6 * NIP[7] +
                7 * NIP[8];
        sum %= 11;

        return NIP[9] == sum;
    }
}
