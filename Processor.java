public class Processor{

    public static void process_gene(Person target){
        String gene = target.getGene_info();
        int sequence_count = target.getOccurrence_count();
        int gene_length = gene.length();
        int char_id = 0;

        while(char_id < gene_length){
            char cur_char = gene.charAt(char_id);
            if (cur_char == 'G'){
                char_id += 1;
                if (gene.charAt(char_id) == 'T'){
                    char_id += 1;
                    if (gene.charAt(char_id) == 'C') {
                        sequence_count += 1;
                        char_id += 1;
                    }
                }
            }
            else{
                char_id += 1;
            }
        }
        target.setOccurrence_count(sequence_count);
        String output_string;
        if (sequence_count > 10){
            output_string = String.format("sequence \"GTC\" appeared %d times; infection chance is high", sequence_count);
        }
        else{
            output_string = String.format("sequence GTC appeared %d times.", sequence_count);
        }
        System.out.println(output_string);
    }

    public static void main(String[] args){
        Person john = new Person("John");
        john.setGeneInfo("ATCTGAAATGAACTGGTCTATGCGACAGAAACTGTGCAGCTACCTAATCTCCTTAGTGTAGGTTCTGACCGATTCGTGCTTCGTTGAGAACTCACAATTTAACAACAGAGGACATAAGCCCTACGCCCATGATCTACTGACGTCCCTGAGGCTGCAATTCATGTAATGGGACAGTATCCGCGGCAAGTCCTAGTGCAATGGCGGTATTCTACCCTCGTACTGTAGTAGAGGCGACGCGGGTGCGGTCATCACTAATAAGGATATTGGGAAGACTCACAGGCCTCCGCCTTTAGGCGGTGCTTACTCTTACATAAAGGGGCTGTTAGTATTACCCCGCGAGGATTCGAAAAGGTGAGCCAACCCGGCCGATCCGGAGAGACGGGCCTCAAAGCCGCGTGACGACGGCTGTGGGCCCGTAACAAAATCCCCGCAATAAGCTCCCGTGAGCGTCGGTTGAACAGCCCTGGTCGGCCCCATCAGTAGCCCGAATATGTCGCTTTACGGGTCCTGGGCCGGGGTGCGATACCTTGCAGAAATCGAGGCCGTTCGTTAATTCCTGTTGCATTCGTACCGCCTATATTTGTCTCTTTGCCGGCTTATATGGACAAGCATAGCATAGCCATTTATCGGAGCGCCTCCGTACACGGTATGATCGGACGCCTCGTGAGATCAATACGTATACCAGGTGTCCTGTGAGCAGCGAAAGCCTATACGCGAGATACACTGCCAAAAATCCGCGTGATTACGAGTCGTGGCAAATTTGGTCTGGCTGTGGTCTAGACATTCCAGGCGGTGCGTCTGCTCTCGGGTGCCTCTAGTGGCTGGCTAGATAGACTAGCCGCTGGTAAACACACCATGACCCCGGCTCTCCATTGATGCCACGGCGATTGTTGGAGAGCCAGCAGCGACTGCAAACATCAGATCAGAGTAATACTAGCATGCGATAAGTCCCTAACTGACTATGGCCTTCTGTAGAGTCAACTTCACCACATATGCTGTC");

        process_gene(john);
    }
}