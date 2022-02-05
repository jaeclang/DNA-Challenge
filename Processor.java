public class Processor{
	public static void process_gene(Person target){

		String gene = target.getGene_info(); // Retrieve respective gene from target person
		int sequence_count = target.getOccurrence_count();
		int gene_length = gene.length();
		int char_id = 0;

		// Iterating Respective Gene
		while(char_id < gene_length){
			/*
			As the specified sequence of 'GTC' starts with 'G', we will look out for the char 'G'
			And if a 'G' is found, we would iterate the subsequent 2 chars looking for --> 'T' & 'C'
			char_id is incremented at this subsequent 2 iterations as we wouldn't need to repeatedly check again for 'T' & 'C'
			*/
			if (gene.charAt(char_id) == 'G'){
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
				char_id += 1; // Increments if NOT 'G'
			}
		}
		target.setOccurrence_count(sequence_count);

		// Determining the chance of infection, checks if sequence appeared more than 10 times
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
		// Creates an object 'John' from the 'Person' Class
		Person john = new Person("John");
		john.setGeneInfo("ATCTGAAATGAACTGGTCTATGCGACAGAAACTGTGCAGCTACCTAATCTCCTTAGTGTAGGTTCTGACCGATTCGTGCTTCGTTGAGAACTCACAATTTAACAACAGAGGACATAAGCCCTACGCCCATGATCTACTGACGTCCCTGAGGCTGCAATTCATGTAATGGGACAGTATCCGCGGCAAGTCCTAGTGCAATGGCGGTATTCTACCCTCGTACTGTAGTAGAGGCGACGCGGGTGCGGTCATCACTAATAAGGATATTGGGAAGACTCACAGGCCTCCGCCTTTAGGCGGTGCTTACTCTTACATAAAGGGGCTGTTAGTATTACCCCGCGAGGATTCGAAAAGGTGAGCCAACCCGGCCGATCCGGAGAGACGGGCCTCAAAGCCGCGTGACGACGGCTGTGGGCCCGTAACAAAATCCCCGCAATAAGCTCCCGTGAGCGTCGGTTGAACAGCCCTGGTCGGCCCCATCAGTAGCCCGAATATGTCGCTTTACGGGTCCTGGGCCGGGGTGCGATACCTTGCAGAAATCGAGGCCGTTCGTTAATTCCTGTTGCATTCGTACCGCCTATATTTGTCTCTTTGCCGGCTTATATGGACAAGCATAGCATAGCCATTTATCGGAGCGCCTCCGTACACGGTATGATCGGACGCCTCGTGAGATCAATACGTATACCAGGTGTCCTGTGAGCAGCGAAAGCCTATACGCGAGATACACTGCCAAAAATCCGCGTGATTACGAGTCGTGGCAAATTTGGTCTGGCTGTGGTCTAGACATTCCAGGCGGTGCGTCTGCTCTCGGGTGCCTCTAGTGGCTGGCTAGATAGACTAGCCGCTGGTAAACACACCATGACCCCGGCTCTCCATTGATGCCACGGCGATTGTTGGAGAGCCAGCAGCGACTGCAAACATCAGATCAGAGTAATACTAGCATGCGATAAGTCCCTAACTGACTATGGCCTTCTGTAGAGTCAACTTCACCACATATGCTGTC");
		process_gene(john);
	}
}