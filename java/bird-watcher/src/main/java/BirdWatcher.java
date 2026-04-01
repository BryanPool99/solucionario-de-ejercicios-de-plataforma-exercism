
class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return this.birdsPerDay;
    }

    public int getToday() {
        int count = this.birdsPerDay.length;
        return this.birdsPerDay[count - 1];
    }

    public void incrementTodaysCount() {
        this.birdsPerDay[this.birdsPerDay.length - 1] += 1;
    }

    public boolean hasDayWithoutBirds() {
        for (int countBird : this.birdsPerDay) {
            if (countBird==0) return true;
        }
        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int total = 0;
        // Determinamos el límite: el menor entre los días pedidos y los días que tenemos
        int limite = Math.min(numberOfDays, this.birdsPerDay.length);
        for (int i = 0; i < limite; i++) {
            total += this.birdsPerDay[i];
        }
        return total;
    }

    public int getBusyDays() {
        int totalDays = 0;
        for(int bird : this.birdsPerDay){
            if(bird>=5) totalDays++;
        }
        return  totalDays;
    }
}
