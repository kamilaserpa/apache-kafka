# Apache Kafka

Projeto de estudo do [Apache Kafka](http://kafka.apache.org). O Apache Kafka é uma plataforma de streaming de eventos distribuídos de código aberto (mensageria).
Tecnologias:
 - Apache Kafka
 - Java 11
 - Spring Boot
 - Docker
 - Maven


## Zookeeper e Kafdrop

[Apache ZooKeeper](http://zookeeper.apache.org/) é um serviço centralizado para manter informações de configuração, nomear, fornecer sincronização distribuída e oferecer serviços de grupo.

[Kafdrop](https://github.com/obsidiandynamics/kafdrop) é uma interface de usuário da web para visualizar tópicos do Kafka e navegar em grupos de consumidores. A ferramenta exibe informações como agentes, tópicos, partições, consumidores e permite visualizar mensagens.

Para baixar as imagens e executar os containers Zookeeper, Kafdrop execute `docker-compose up -d` .
A interface gráfica Kafdrop será exibida ao acessar `http://localhost:19000`.

![Kafdrop interface](_images/kafdrop.png)

Obs.:
 - `docker-compose down` pode ser executado para parar os containers.

## Conceitos iniciais

Os **produtores** são os aplicativos clientes que publicam (gravam) eventos no Kafka e os **consumidores** são aqueles que assinam (leem e processam) esses eventos.

### Tópicos
Os eventos são organizados e armazenados de forma durável em **tópicos**, um tópico tem a função de conter mensagens semelhante a uma pasta em um sistema de arquivos.<br>
Os tópicos no Kafka são sempre multiprodutores e multiassinantes, podem ter zero, um ou muitos produtores/consumidores.<br>
Os eventos não são excluídos após o consumo. Deve-se definir por quanto tempo o Kafka deve reter seus eventos por meio de uma configuração por tópico.

Para tornar seus dados tolerantes a falhas e altamente disponíveis, todos os tópicos podem ser replicados 

#### Partições
Os tópicos são particionados, divididos em partições importantes para escalabilidade dos dados.<br>
Eventos com a mesma chave são gravados na mesma partição.

![Tópico com partições P1, P2, P3, P4](https://kafka.apache.org/images/streams-and-tables-p1_p4.png)

Uma partição pode conter zero ou vários grupos de consumo.
Não é possível haver maior número de grupos de consumo com o mesmo ID, do que número de partições, pois algum deles não consegue se inscrever em partição nenhuma.

#### Developer

[Kamila Serpa](https://kamilaserpa.github.io)

[1]: https://www.linkedin.com/in/kamila-serpa/
[2]: https://gitlab.com/java-kamila
[3]: https://github.com/kamilaserpa

[![linkedin](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)][1]
[![gitlab](https://img.shields.io/badge/GitLab-330F63?style=for-the-badge&logo=gitlab&logoColor=white)][2]
[![github](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)][3]
