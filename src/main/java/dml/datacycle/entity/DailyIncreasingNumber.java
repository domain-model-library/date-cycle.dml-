package dml.datacycle.entity;

/**
 * 每日自增数字，0开始自增，0点后重启计算
 */
public class DailyIncreasingNumber {
    private String id;
    private long number;
    private long lastUpdateTime;

    public void incrementNumber(long currentTime) {
        //计算currentTime相对lastUpdateTime有没有跨天
        long lastUpdateTimeDay = lastUpdateTime / 86400000;
        long currentTimeDay = currentTime / 86400000;
        if (currentTimeDay > lastUpdateTimeDay) {
            number = 0;
        } else {
            number++;
        }
        lastUpdateTime = currentTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }


}
