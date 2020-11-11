package com.gabriel.tempo.model;

import lombok.Data;

@Data
public class Main {

    private Long temp;
    private Long feels_like;
    private Long temp_min;
    private Long temp_max;
    private Integer pressure;
    private Integer humidity;

}
