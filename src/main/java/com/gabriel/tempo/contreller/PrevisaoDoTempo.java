package com.gabriel.tempo.contreller;

import com.gabriel.tempo.model.BodyWeather;
import com.gabriel.tempo.model.Main;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/tempo")
public class PrevisaoDoTempo {

    @Value("${url.api}")
    private String url;

    @Value("${api.key}")
    private String apiKey;

    @GetMapping("/{cidade}")
    public Main getTempo(@PathVariable String cidade)    {
        RestTemplate restTemplate = new RestTemplate();

        StringBuilder stringBuilder = new StringBuilder();
        String urlFinal = stringBuilder.append(url).append(cidade).append("&appid=").append(apiKey).toString();

        ResponseEntity<BodyWeather> entity =
                restTemplate.getForEntity(urlFinal, BodyWeather.class);

        System.out.println(entity.getBody().getMain().getTemp_max());

        return entity.getBody().getMain();
    }
}
