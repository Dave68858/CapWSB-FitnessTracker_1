package com.capgemini.wsb.fitnesstracker.statistics.api;

import java.util.Optional;
public interface StatisticsProvider {

    Optional<Statistics> getStatistics(Long statisticsId);

}
