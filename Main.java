public class Main {
    public static void main(String[] args) {
        String input = args[0].toUpperCase();
        char[] inputArr = input.toCharArray();
        int start = input.indexOf("AUG");
        if (start == -1) {
            System.out.println("Error, start codon not found.");
            return;
        }
        StringBuilder result = new StringBuilder().append("N-");
        for (int i = start; i < inputArr.length; i += 3) {
            String codon = input.substring(i, i + 3);
            if (codon.equals("UAA") || codon.equals("UAG") || codon.equals("UGA")) {
                result.append("C");
                System.out.println("Polypeptide chain: " + result);
                return;
            }
            String aminoAcid = GeneticCode.geneticCode.get(codon);
            result.append(aminoAcid).append("-");
        }
        System.out.println("Error, stop codon not found.");
    }
}
