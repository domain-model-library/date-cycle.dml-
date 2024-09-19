package dml.datacycle.service;

import dml.datacycle.repository.DailyIncreasingNumberRepository;
import dml.datacycle.service.repositoryset.DailyIncreasingNumberServiceRepositorySet;
import dml.datacycle.entity.DailyIncreasingNumber;

public class DailyIncreasingNumberService {
    public static DailyIncreasingNumber increaseAndGet(DailyIncreasingNumberServiceRepositorySet repositorySet,
                                                       String id, long currentTime) {
        DailyIncreasingNumberRepository dailyIncreasingNumberRepository = repositorySet.getDailyIncreasingNumberRepository();

        DailyIncreasingNumber dailyIncreasingNumber = new DailyIncreasingNumber();
        dailyIncreasingNumber.setId(id);
        dailyIncreasingNumber.setLastUpdateTime(currentTime);
        dailyIncreasingNumber = dailyIncreasingNumberRepository.takeOrPutIfAbsent(id, dailyIncreasingNumber);
        dailyIncreasingNumber.incrementNumber(currentTime);
        return dailyIncreasingNumber;
    }
}
