public class Person{
    public String name;
    private String gene_info;
    private int occurrence_count;

    // Constructor
    public Person(String name){
        this.name = name;
        this.occurrence_count = 0;
    }

    // Setter Methods
    public void setGeneInfo(String gene_input){
        this.gene_info = gene_input;
    }
    public void setOccurrence_count(int sequence_count){
        this.occurrence_count = sequence_count;
    }

    // Getter Methods
    public String getGene_info() {
        return gene_info;
    }
    public int getOccurrence_count() {
        return occurrence_count;
    }
}