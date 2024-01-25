class DataStream {

    int[] stream;
    int value;
    int index;

    public DataStream(int value, int k) {
        this.value = value;
        stream = new int[k];
        index = 0;
    }
    
    public boolean consec(int num) {
        stream[index] = num;
        boolean result = true;
        for (int val : stream)
        {
            if (val != value)
            {
                result = false;
                break;
            }
        }
        index = (index + 1) % stream.length;
        return result;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */