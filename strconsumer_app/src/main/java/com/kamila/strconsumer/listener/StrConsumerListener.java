package com.kamila.strconsumer.listener;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListener {

    // Os dois métodos estão inscritos no mesmo grupo de consumo.
    // Dessa maneira as partições são distribuídas por estes métodos.
    // Como há duas partições (0 e 1) cada um dos métodos abaixo assina apenas uma das partições.
    // Ouvindo apenas as mensagens produzidas nessa determinada partição.
    // para garantir que os 3 recebam a mesma mensagem seria necessário cada um utilizar um grupo de consumo (groupId) diferente.
    @KafkaListener(groupId = "group-1", topics = "str-topic", containerFactory = "strContainerFactory")
    public void create(String message) {
        log.info("CREATE ::: Receive message: {}", message);
    }

    @KafkaListener(groupId = "group-1", topics = "str-topic", containerFactory = "strContainerFactory")
    public void log(String message) {
        log.info("LOG ::: Receive message: {}", message);
    }

}
