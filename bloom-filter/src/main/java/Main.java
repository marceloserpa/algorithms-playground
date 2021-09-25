public class Main {

    public static void main(String[] args) {

        BloomFilter bloomFilter = new BloomFilter(32);
        bloomFilter.add(2010);
        bloomFilter.add(2013);
        System.out.println(bloomFilter.render());;

        System.out.println("-----------");
        System.out.println(bloomFilter.render(true));


    }
    
    
}
