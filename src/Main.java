/* Para usarmos datas e horas em java apartir da versao 8 do java usamos o time
o calendar e o date foram descontinuados pois nao tinham muitas opcoes de tratamento,
com isso usamos o LocalDateTime onde conseguimos manipular data e hora,
tambem podemos manipular uma por vez usando o LocalTime e o LocalDate para manipular hora e data separadamente
*/
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
  static LocalDate data;
  static LocalTime tempo;
  public static void main(String[] args) {
    // usamos aqui o Clock da biblioteca time onde usamos o systemDefaultZone
    // para conseguir retornar a data e hora com fuso horario
    Clock hour = Clock.systemDefaultZone();
    // se usarmos o print e imprimirmos so o hour recebemos o timeZone de sao paulo
    // para conseguirmos ter um horario e uma data usamos o instant() e conseguimos retornar
    // o resultado com FUSO HORARIO
    System.out.println(hour.instant());
    // com o LocalDateTime passamos o now() onde temos o resultado da hora e da data sem fuso horario
    LocalDateTime hour2 = LocalDateTime.now();
    System.out.println(hour2);
    diaDeAcad();
    Scanner sc = new Scanner(System.in);
    System.out.println("Vamos marcar seu evento!, informe a data no formato ano/mes/dia e o horário");
    // OBS: por padrao a data nao esta no formato brasileiro e teria que ser posta como ano/mes/dia
    // para conseguirmos usar o formato brasileiro usaremos o DateTimeFormatter para colocar a data em dia/mes/ano
    String consultaData = sc.nextLine();
    String consultaTime = sc.nextLine();
    agendarConsulta(consultaData, consultaTime);
    checkEvent();
    sc.close();
  }

  private static void diaDeAcad() {
    LocalDateTime work = LocalDateTime.now();
    String day = work.getDayOfWeek().toString();
    if (Objects.equals(day, "MONDAY")) {
      System.out.println(day+" é dia de ir para a academia");
    } else if (Objects.equals(day, "WEDNESDAY")) {
      System.out.println(day+" é dia de ir para a academia");
    } else if (Objects.equals(day, "FRIDAY")) {
      System.out.println(day+" é dia de ir para a academia");
    } else {
      System.out.println("Hoje não é dia de academia");
    }
  }

  // criando metodo para agendar consulta recebendo dois parametros string que serao guardados nas
  // variaveis
  private static void agendarConsulta(String d, String h) {
    data = LocalDate.parse(d);
    tempo = LocalTime.parse(h);
  }

  private static void checkEvent() {
    LocalDate hoje = LocalDate.now();
    LocalTime horaHoje = LocalTime.now();
    // usando o DateTimeFormatter para formatar a data e retornar para o usuario a data no formato BR
    String formatData = "dd/MM/yyyy";
    DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern(formatData);
    if (data.equals(hoje)) {
      if (tempo.isAfter(horaHoje)) {
        System.out.println("Passou a hora do evento!, você está atrasado");
      } else {
        System.out.println("A hora do evento está chegando se prepare!");
      }
    } else if(data.isBefore(hoje)) {
      System.out.println("O evento é no dia "+formatadorData.format(data)+" se preapare!");
    } else {
      System.out.println("O evento já aconteceu!");
    }
  }
}