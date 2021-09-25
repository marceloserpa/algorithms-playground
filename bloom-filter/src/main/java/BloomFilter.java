public class BloomFilter {

    private final int bits;
    private byte[] bitMap;

    public BloomFilter(int bits) {
        this.bits = bits;
        this.bitMap = new byte[bits];
    }

    public void add(int number){
        int hash1 = hash(number, 1);
        int hash2 = hash(number, 2);
        int hash3 = hash(number, 3);

        bitMap[hash1] = 1;
        bitMap[hash2] = 1;
        bitMap[hash3] = 1;

    }

    public boolean contains(int number){
        int hash1 = hash(number, 1);
        int hash2 = hash(number, 2);
        int hash3 = hash(number, 3);

        return (bitMap[hash1] + bitMap[hash2] + bitMap[hash3]) == 3;
    }

    //  hi(x) = ((x ^ 2 +x ^ 3)*i) mod m.
    private int hash(int number, int i){
        int x2 = (int) Math.pow(number, 2);
        int x3 = (int) Math.pow(number, 3);

        int a = (x2 + x3) * i;
        int r = a % bits;
        return Math.abs(r);
    }

    public String render(){
        return render(false);
    }

    public String render(boolean onlyNonEmptyBits){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < bitMap.length; i++){
            if(bitMap[i] == 1) {
                sb.append(i).append("=").append(bitMap[i]).append("\n");
            } else if(!onlyNonEmptyBits) {
                sb.append(i).append("=").append(bitMap[i]).append("\n");
            }
        }
        return sb.toString();
    }

}
