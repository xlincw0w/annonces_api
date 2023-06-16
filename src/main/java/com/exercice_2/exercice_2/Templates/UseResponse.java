package com.exercice_2.exercice_2.Templates;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class UseResponse<T> {

  private T payload;
  private String error;
  private T message;
  private LocalDateTime time = LocalDateTime.now();
}
