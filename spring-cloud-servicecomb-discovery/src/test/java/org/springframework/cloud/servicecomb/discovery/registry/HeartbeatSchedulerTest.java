package org.springframework.cloud.servicecomb.discovery.registry;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.cloud.servicecomb.discovery.client.ServiceCombClient;
import org.springframework.cloud.servicecomb.discovery.discovery.ServiceCombDiscoveryProperties;

import mockit.Expectations;
import mockit.Injectable;

/**
 * @Author wangqijun
 * @Date 11:16 2019-08-16
 **/
public class HeartbeatSchedulerTest {

  @Injectable
  ServiceCombClient serviceCombClient;

  @Injectable
  ServiceCombDiscoveryProperties serviceCombDiscoveryProperties;

  @Test
  public void addAndRemove() {
    new Expectations() {
      {
        serviceCombDiscoveryProperties.isHealthCheck();
        result = true;
        serviceCombDiscoveryProperties.getHealthCheckInterval();
        result = 10;
      }
    };
    HeartbeatScheduler heartbeatScheduler = new HeartbeatScheduler(serviceCombDiscoveryProperties, serviceCombClient);
    heartbeatScheduler.add("11", "22");
    heartbeatScheduler.remove("11");
  }
}