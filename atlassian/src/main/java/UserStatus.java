import java.time.LocalDateTime;

public class UserStatus {
    LocalDateTime lastWindowTime;
    int count;

    public UserStatus(LocalDateTime lastWindowTime, int count) {
        this.lastWindowTime = lastWindowTime;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public LocalDateTime getLastWindowTime() {
        return lastWindowTime;
    }

    public void setLastWindowTime(LocalDateTime lastWindowTime) {
        this.lastWindowTime = lastWindowTime;
    }

}
