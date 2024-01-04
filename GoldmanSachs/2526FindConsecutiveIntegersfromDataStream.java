class DataStream {
    int currentStreak = 0;
    int value, k;

    public DataStream(int value, int k) {
        this.k = k;
        this.value = value;
    }

    public boolean consec(int num) {
        if (num != value) {
            currentStreak = 0;
        } else {
            currentStreak++;
        }

        return currentStreak >= k;
    }
}