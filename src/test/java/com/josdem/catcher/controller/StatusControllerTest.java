package com.josdem.catcher.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class StatusControllerTest {

  private final WebTestClient webTestClient;

  @Test
  @DisplayName("it stores status")
  void shouldStoreStatus(TestInfo testInfo) {
    log.info("Running: {}", testInfo.getDisplayName());
    webTestClient.post().uri("/catcher/sku/100").exchange().expectStatus().isOk();
  }
}